package com.example.micitaquileia.iu.administrator.agregarpaciente;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.micitaquileia.databinding.FragmentAgregarPacienteBinding;
import com.example.micitaquileia.entities.Patient;
import com.example.micitaquileia.utilities.Utilities;

import java.util.Calendar;

public class AgregarPacienteFragment extends Fragment implements AddPatientMVP.View {

    private FragmentAgregarPacienteBinding binding;
    private AddPatientMVP.Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAgregarPacienteBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new AddPatientPresenterImpl(this);

        selectBirthDate();

        binding.btnCreatePatient.setOnClickListener(view1 -> {
            createPatient();
        });

    }

    private void selectBirthDate() {
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        binding.etBirthDate.setKeyListener(null);
        binding.etBirthDate.setOnClickListener(view -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    month = month + 1;
                    String fecha = day+"/"+month+"/"+year;
                    binding.etBirthDate.setText(fecha);
                }
            },year,month,day);
            datePickerDialog.show();
        });
    }

    private void createPatient() {
        EditText[] fieldList = {binding.etName, binding.etSurname, binding.etBirthDate, binding.etIdentificationCard};
        if (Utilities.isFielsdFilled(fieldList)) {
            Patient patient = new Patient();
            patient.setName(binding.etName.getText().toString());
            patient.setSurname(binding.etSurname.getText().toString());
            patient.setBirthDate(binding.etBirthDate.getText().toString());
            patient.setIdentificationCard(binding.etIdentificationCard.getText().toString());
            patient.setInTreatment(binding.cbIsInTreatment.isChecked());

            presenter.addPatient(getContext(), patient);
        } else {
            Toast.makeText(getContext(), "Por favor, llene todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    private void cleanFields() {
        binding.etName.setText("");
        binding.etSurname.setText("");
        binding.etBirthDate.setText("");
        binding.etIdentificationCard.setText("");
        binding.cbIsInTreatment.setChecked(false);
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