package com.example.micitaquileia.iu.administrator.agregarmedico;

import android.content.Context;

import com.example.micitaquileia.entities.Doctor;

public interface AddDoctorMVP {
    interface View{
        void showResponse(String response);
        void showError(String error);
    }
    interface Presenter{
        void showResponse(String response);
        void showError(String error);
        void addDoctor(Context context, Doctor doctor);
    }
    interface Model{
        void addDoctor(Context context, Doctor doctor);
    }
}
