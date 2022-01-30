package com.example.micitaquileia.iu.administrator.consultpatients;

import android.content.Context;

import com.example.micitaquileia.entities.Patient;

import java.util.ArrayList;

public interface ConsultPatientsMVP {
    interface View{
        void showPatientList(ArrayList<Patient> patientList);
        void showResponse(String response);
        void showError(String error);
    }
    interface Presenter{
        void showPatientList(ArrayList<Patient> patientList);
        void consultPatientList(Context context);
        void showResponse(String response);
        void showError(String error);
        void deletePatient(Context context, int id);
    }
    interface Model{
        void consultPatientList(Context context);
        void deletePatient(Context context, int id);
    }
}
