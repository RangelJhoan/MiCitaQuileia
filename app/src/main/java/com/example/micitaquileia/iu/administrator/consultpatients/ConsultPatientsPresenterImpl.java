package com.example.micitaquileia.iu.administrator.consultpatients;

import android.content.Context;

import com.example.micitaquileia.entities.Patient;

import java.util.ArrayList;

public class ConsultPatientsPresenterImpl implements ConsultPatientsMVP.Presenter{

    private ConsultPatientsMVP.Model model;
    private ConsultPatientsMVP.View view;

    public ConsultPatientsPresenterImpl(ConsultPatientsMVP.View view) {
        this.view = view;
        this.model = new ConsultPatientsModelImpl(this);
    }

    @Override
    public void showPatientList(ArrayList<Patient> patientList) {
        if(view != null){
            view.showPatientList(patientList);
        }
    }

    @Override
    public void consultPatientList(Context context) {
        if(model != null){
            model.consultPatientList(context);
        }
    }

    @Override
    public void showResponse(String response) {
        if(view != null){
            view.showResponse(response);
        }
    }

    @Override
    public void showError(String error) {
        if(view != null){
            view.showError(error);
        }
    }

    @Override
    public void deletePatient(Context context, int id) {
        if(model != null){
            model.deletePatient(context, id);
        }
    }
}
