package com.example.micitaquileia.iu.administrator.menuadministrador;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.micitaquileia.R;
import com.example.micitaquileia.databinding.FragmentMenuAdministradorBinding;
import com.example.micitaquileia.entities.Menu;
import com.example.micitaquileia.interfaces.MenuCallback;
import com.example.micitaquileia.iu.adapters.MenuAdapter;
import com.example.micitaquileia.utilities.Constants;

import java.util.ArrayList;

public class MenuAdministradorFragment extends Fragment implements MenuCallback {

    private FragmentMenuAdministradorBinding binding;
    private ArrayList<Menu> listaMenu;
    private MenuAdapter adapter;
    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMenuAdministradorBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        cargarMenu();

    }

    private void cargarMenu() {
        listaMenu = new ArrayList<>();
        listaMenu.add(new Menu(Constants.CREATE_DOCTOR, R.drawable.agregar_medico_128));
        listaMenu.add(new Menu(Constants.GET_DOCTORS, R.drawable.medico_128));
        listaMenu.add(new Menu(Constants.CREATE_PATIENT, R.drawable.agregar_paciente_128));
        listaMenu.add(new Menu(Constants.GET_PATIENTS, R.drawable.paciente_128));

        binding.rvBotonesMenu.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter = new MenuAdapter(listaMenu, this);
        binding.rvBotonesMenu.setAdapter(adapter);

    }

    @Override
    public void navegarFragment(Menu menu) {
        switch (menu.getNombre()){
            case Constants.CREATE_DOCTOR:
                navController.navigate(R.id.agregarMedicoFragment);
                break;
            case Constants.GET_DOCTORS:
                navController.navigate(R.id.consultarMedicosFragment);
                break;
            case Constants.CREATE_PATIENT:
                navController.navigate(R.id.agregarPacienteFragment);
                break;
            case Constants.GET_PATIENTS:
                navController.navigate(R.id.consultarPacientesFragment);
                break;
            default:
                Toast.makeText(getContext(), "Error al seleccionar una opción", Toast.LENGTH_LONG).show();
        }
    }
}