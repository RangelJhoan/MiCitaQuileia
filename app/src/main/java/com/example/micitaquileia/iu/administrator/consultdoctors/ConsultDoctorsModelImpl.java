package com.example.micitaquileia.iu.administrator.consultdoctors;

import android.content.Context;

import com.example.micitaquileia.database.DataBase;
import com.example.micitaquileia.entities.Doctor;

import java.util.ArrayList;

public class ConsultDoctorsModelImpl implements ConsultDoctorsMVP.Model{

    private ConsultDoctorsMVP.Presenter presenter;
    private DataBase dataBase;

    public ConsultDoctorsModelImpl(ConsultDoctorsMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void consultDoctorList(Context context) {
        dataBase = DataBase.getInstance(context);
        ArrayList<Doctor> doctors = dataBase.consultDoctors();
        presenter.showDoctorList(doctors);
    }

    @Override
    public void deleteDoctor(Context context, int id) {
        dataBase = DataBase.getInstance(context);
        long responseDeleteDoctor = dataBase.deleteDoctor(id);
        if(responseDeleteDoctor > 0){
            presenter.showResponse("Médico eliminado correctamente");
        }else{
            presenter.showError("Error al eliminar el médico");
        }
    }
}
