package com.example.micitaquileia.iu.administrator.agregarpaciente;

import android.content.Context;

import com.example.micitaquileia.database.DataBase;
import com.example.micitaquileia.entities.Patient;

public class AddPatientModelImpl implements AddPatientMVP.Model{

    private AddPatientMVP.Presenter presenter;
    private DataBase dataBase;

    public AddPatientModelImpl(AddPatientMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void addPatient(Context context, Patient patient) {
        dataBase = DataBase.getInstance(context);
        long responsePatient = dataBase.createPatient(patient);

        if(responsePatient > 0){
            presenter.showResponse("Paciente registrado correctamente");
        }else{
            presenter.showError("Error al registrar paciente");
        }

    }
}
