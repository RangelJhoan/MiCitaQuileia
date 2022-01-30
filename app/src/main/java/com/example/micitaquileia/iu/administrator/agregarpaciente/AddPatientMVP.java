package com.example.micitaquileia.iu.administrator.agregarpaciente;

import android.content.Context;

import com.example.micitaquileia.entities.Patient;

public interface AddPatientMVP {
    interface View {
        void showResponse(String response);
        void showError(String error);
    }

    interface Presenter {
        void showResponse(String response);
        void showError(String error);
        void addPatient(Context context, Patient patient);
    }

    interface Model {
        void addPatient(Context context, Patient patient);
    }
}
