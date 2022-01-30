package com.example.micitaquileia.iu.administrator.consultdoctors;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.micitaquileia.databinding.FragmentConsultDoctorsBinding;
import com.example.micitaquileia.entities.Doctor;
import com.example.micitaquileia.interfaces.AdminActionOnUsersCallback;
import com.example.micitaquileia.iu.adapters.DoctorsAdapter;
import com.example.micitaquileia.utilities.Constants;

import java.util.ArrayList;

public class ConsultDoctorsFragment extends Fragment implements ConsultDoctorsMVP.View, AdminActionOnUsersCallback {

    private FragmentConsultDoctorsBinding binding;
    private ConsultDoctorsMVP.Presenter presenter;
    private DoctorsAdapter doctorsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentConsultDoctorsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new ConsultDoctorsPresenterImpl(this);

        presenter.consultDoctorList(getContext());

    }

    @Override
    public void showDoctorList(ArrayList<Doctor> doctorList) {
        doctorsAdapter = new DoctorsAdapter(doctorList, this);
        binding.rvDoctors.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvDoctors.setAdapter(doctorsAdapter);
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
        presenter.deleteDoctor(getContext(), id);
        presenter.consultDoctorList(getContext());
    }
}