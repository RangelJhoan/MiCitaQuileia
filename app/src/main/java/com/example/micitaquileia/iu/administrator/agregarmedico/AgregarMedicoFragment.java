
package com.example.micitaquileia.iu.administrator.agregarmedico;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.micitaquileia.databinding.FragmentAgregarMedicoBinding;
import com.example.micitaquileia.entities.Doctor;
import com.example.micitaquileia.utilities.Utilities;


public class AgregarMedicoFragment extends Fragment implements AddDoctorMVP.View {

    private FragmentAgregarMedicoBinding binding;
    private AddDoctorMVP.Presenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAgregarMedicoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new AddDoctorPresenterImpl(this);

        binding.btnCreateDoctor.setOnClickListener(view1 -> {
            createDoctor();
        });

    }

    private void createDoctor() {
        EditText[] fieldList = {binding.etFullName, binding.etProfessionalCode, binding.etSpeciality, binding.etYearsOfExperience, binding.etOffice};
        if(Utilities.isFielsdFilled(fieldList)){
            Doctor doctor = new Doctor();
            doctor.setFullName(binding.etFullName.getText().toString());
            doctor.setProfessionalCardCode(binding.etProfessionalCode.getText().toString());
            doctor.setSpeciality(binding.etSpeciality.getText().toString());
            doctor.setYearsOfExperience(Integer.parseInt(binding.etYearsOfExperience.getText().toString()));
            doctor.setOffice(binding.etOffice.getText().toString());
            doctor.setServesAtHome(binding.cbServesAtHome.isChecked());

            presenter.addDoctor(getContext(), doctor);
        }else{
            Toast.makeText(getContext(), "Por favor, llene todos los datos", Toast.LENGTH_SHORT).show();
        }
    }

    private void cleanFields(){
        binding.etFullName.setText("");
        binding.etProfessionalCode.setText("");
        binding.etSpeciality.setText("");
        binding.etYearsOfExperience.setText("");
        binding.etOffice.setText("");
        binding.cbServesAtHome.setChecked(false);
    }

    @Override
    public void showResponse(String response) {
        cleanFields();
        Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
    }
}