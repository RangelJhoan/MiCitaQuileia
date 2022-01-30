package com.example.micitaquileia.iu.administrator.consultpatients;

import android.content.Context;

import com.example.micitaquileia.database.DataBase;
import com.example.micitaquileia.entities.Patient;

import java.util.ArrayList;

public class ConsultPatientsModelImpl implements ConsultPatientsMVP.Model {

    private ConsultPatientsMVP.Presenter presenter;
    private DataBase dataBase;

    public ConsultPatientsModelImpl(ConsultPatientsMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void consultPatientList(Context context) {
        dataBase = DataBase.getInstance(context);
        ArrayList<Patient> patientList = dataBase.consultPatients();
        presenter.showPatientList(patientList);
    }

    @Override
    public void deletePatient(Context context, int id) {
        dataBase = DataBase.getInstance(context);
        long responseDeletePatient = dataBase.deletePatient(id);
        if(responseDeletePatient > 0){
            presenter.showResponse("Paciente eliminado correctamente");
        }else{
            presenter.showError("Error al eliminar el paciente");
        }
    }
}
