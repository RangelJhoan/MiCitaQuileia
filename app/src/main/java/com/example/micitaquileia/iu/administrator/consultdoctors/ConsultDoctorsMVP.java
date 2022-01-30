package com.example.micitaquileia.iu.administrator.consultdoctors;

import android.content.Context;

import com.example.micitaquileia.entities.Doctor;

import java.util.ArrayList;

public interface ConsultDoctorsMVP {
    interface View{
        void showDoctorList(ArrayList<Doctor> doctorList);
        void showResponse(String response);
        void showError(String error);
    }
    interface Presenter{
        void showDoctorList(ArrayList<Doctor> doctorList);
        void consultDoctorList(Context context);
        void deleteDoctor(Context context, int id);
        void showResponse(String response);
        void showError(String error);
    }
    interface Model{
        void consultDoctorList(Context context);
        void deleteDoctor(Context context, int id);
    }
}
