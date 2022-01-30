package com.example.micitaquileia.iu.administrator.consultdoctors;

import android.content.Context;

import com.example.micitaquileia.entities.Doctor;

import java.util.ArrayList;

public class ConsultDoctorsPresenterImpl implements ConsultDoctorsMVP.Presenter {

    private ConsultDoctorsMVP.Model model;
    private ConsultDoctorsMVP.View view;

    public ConsultDoctorsPresenterImpl(ConsultDoctorsMVP.View view) {
        this.view = view;
        this.model = new ConsultDoctorsModelImpl(this);
    }

    @Override
    public void showDoctorList(ArrayList<Doctor> doctorList) {
        if(view != null){
            view.showDoctorList(doctorList);
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
    public void consultDoctorList(Context context) {
        if(model != null){
            model.consultDoctorList(context);
        }
    }

    @Override
    public void deleteDoctor(Context context, int id) {
        if(model != null){
            model.deleteDoctor(context, id);
        }
    }
}
