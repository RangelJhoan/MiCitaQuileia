package com.example.micitaquileia.iu.administrator.agregarpaciente;

import android.content.Context;

import com.example.micitaquileia.entities.Patient;

public class AddPatientPresenterImpl implements AddPatientMVP.Presenter {

    private AddPatientMVP.Model model;
    private AddPatientMVP.View view;

    public AddPatientPresenterImpl(AddPatientMVP.View view) {
        this.view = view;
        this.model = new AddPatientModelImpl(this);
    }

    @Override
    public void showResponse(String response) {
        if (view != null) {
            view.showResponse(response);
        }
    }

    @Override
    public void showError(String error) {
        if (view != null) {
            view.showError(error);
        }
    }

    @Override
    public void addPatient(Context context, Patient patient) {
        if (model != null) {
            model.addPatient(context, patient);
        }
    }
}
