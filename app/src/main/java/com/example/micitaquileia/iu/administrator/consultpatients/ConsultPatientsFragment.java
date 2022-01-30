package com.example.micitaquileia.iu.administrator.consultpatients;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.micitaquileia.databinding.FragmentConsultPatientsBinding;
import com.example.micitaquileia.entities.Patient;
import com.example.micitaquileia.interfaces.AdminActionOnUsersCallback;
import com.example.micitaquileia.iu.adapters.PatientsAdapter;
import com.example.micitaquileia.utilities.Constants;

import java.util.ArrayList;

public class ConsultPatientsFragment extends Fragment implements ConsultPatientsMVP.View, AdminActionOnUsersCallback {

    private FragmentConsultPatientsBinding binding;
    private PatientsAdapter patientsAdapter;
    private ConsultPatientsMVP.Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentConsultPatientsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new ConsultPatientsPresenterImpl(this);

        presenter.consultPatientList(getContext());

    }

    @Override
    public void showPatientList(ArrayList<Patient> patientList) {
        patientsAdapter = new PatientsAdapter(patientList, this);
        binding.rvPatients.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvPatients.setAdapter(patientsAdapter);
    }

    @Override
    public void showResponse(String response) {
        Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void editUser(int id) {

    }

    @Override
    public void deleteUser(int id) {
        presenter.deletePatient(getContext(), id);
        presenter.consultPatientList(getContext());
    }
}