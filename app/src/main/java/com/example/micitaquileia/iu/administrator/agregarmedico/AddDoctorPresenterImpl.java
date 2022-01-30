package com.example.micitaquileia.iu.administrator.agregarmedico;

import android.content.Context;

import com.example.micitaquileia.entities.Doctor;

public class AddDoctorPresenterImpl implements AddDoctorMVP.Presenter {

    private AddDoctorMVP.View view;
    private AddDoctorMVP.Model model;

    public AddDoctorPresenterImpl(AddDoctorMVP.View view) {
        this.view = view;
        model = new AddDoctorModelImpl(this);
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
    public void addDoctor(Context context, Doctor doctor) {
        if (model != null) {
            model.addDoctor(context, doctor);
        }
    }
}
