package com.example.micitaquileia.iu.administrator.agregarmedico;

import android.content.Context;

import com.example.micitaquileia.database.DataBase;
import com.example.micitaquileia.entities.Doctor;

public class AddDoctorModelImpl implements AddDoctorMVP.Model{

    private AddDoctorMVP.Presenter presenter;
    private DataBase dataBase;

    public AddDoctorModelImpl(AddDoctorMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void addDoctor(Context context, Doctor doctor) {
        dataBase = DataBase.getInstance(context);
        long response = dataBase.createDoctor(doctor);

        if(response > 0){
            presenter.showResponse("Doctor registrado correctamente");
        }else{
            presenter.showError("Error al registrar el doctor");
        }

    }
}
