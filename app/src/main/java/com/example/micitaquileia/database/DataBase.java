package com.example.micitaquileia.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.micitaquileia.entities.Doctor;
import com.example.micitaquileia.entities.Patient;
import com.example.micitaquileia.utilities.Constants;
import com.example.micitaquileia.utilities.Utilities;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {
    private static DataBase instance = null;
    private Context ctx;

    //Parámetros de conexión
    private static final String DATABASE_NAME = "micitaquileia";
    private static final int DATABASE_VERSION = 1;

    //Crear conexión

    private DataBase(@Nullable Context ctx) {
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
        this.ctx = ctx;
    }

    public static DataBase getInstance(Context ctx) {
        if (instance == null) {
            instance = new DataBase(ctx.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Constants.CREATE_DOCTOR_TABLE);
        sqLiteDatabase.execSQL(Constants.CREATE_PATIENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(Constants.DROP_TABLE_EXISTENT + Constants.DOCTOR_TABLE);
        sqLiteDatabase.execSQL(Constants.DROP_TABLE_EXISTENT + Constants.PATIENT_TABLE);
        onCreate(sqLiteDatabase);
    }


    public long createDoctor(Doctor doctor) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valuesDoctor = new ContentValues();
        valuesDoctor.put(Constants.DOCTOR_FULLNAME, doctor.getFullName());
        valuesDoctor.put(Constants.DOCTOR_PROFESSIONAL_CARD, doctor.getProfessionalCardCode());
        valuesDoctor.put(Constants.DOCTOR_SPECIALITY, doctor.getSpeciality());
        valuesDoctor.put(Constants.DOCTOR_YEARS_EXPERIENCE, doctor.getYearsOfExperience());
        valuesDoctor.put(Constants.DOCTOR_OFFICE, doctor.getOffice());
        valuesDoctor.put(Constants.DOCTOR_SERVES_AT_HOME, Utilities.boolToInt(doctor.isServesAtHome()));

        return db.insert(Constants.DOCTOR_TABLE, Constants.DOCTOR_ID, valuesDoctor);
    }

    public long createPatient(Patient patient) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valuesPatient = new ContentValues();
        valuesPatient.put(Constants.PATIENT_NAME, patient.getName());
        valuesPatient.put(Constants.PATIENT_SURNAME, patient.getSurname());
        valuesPatient.put(Constants.PATIENT_BIRTH_DATE, patient.getBirthDate());
        valuesPatient.put(Constants.PATIENT_IDENTIFICATION_CARD, patient.getIdentificationCard());
        valuesPatient.put(Constants.PATIENT_IS_IN_TREATMENT, Utilities.boolToInt(patient.isInTreatment()));

        return db.insert(Constants.PATIENT_TABLE, Constants.PATIENT_ID, valuesPatient);
    }

    public ArrayList<Doctor> consultDoctors() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Doctor> doctors = new ArrayList<>();
        Doctor doctor = null;
        Cursor cursor = db.rawQuery("SELECT " + Constants.DOCTOR_ID + ", " + Constants.DOCTOR_FULLNAME + ", " + Constants.DOCTOR_PROFESSIONAL_CARD + ", " + Constants.DOCTOR_SPECIALITY + " " +
                "FROM " + Constants.DOCTOR_TABLE, null);

        while (cursor.moveToNext()) {
            doctor = new Doctor();

            doctor.setId(cursor.getInt(0));
            doctor.setFullName(cursor.getString(1));
            doctor.setProfessionalCardCode(cursor.getString(2));
            doctor.setSpeciality(cursor.getString(3));

            doctors.add(doctor);
        }

        return doctors;
    }

    public ArrayList<Patient> consultPatients() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Patient> patients = new ArrayList<>();
        Patient patient = null;
        Cursor cursor = db.rawQuery("SELECT " + Constants.PATIENT_ID + ", " + Constants.PATIENT_IDENTIFICATION_CARD + ", " + Constants.PATIENT_NAME + ", " + Constants.PATIENT_SURNAME + ", " + Constants.PATIENT_BIRTH_DATE + " " +
                "FROM " + Constants.PATIENT_TABLE, null);

        while (cursor.moveToNext()) {
            patient = new Patient();

            patient.setId(cursor.getInt(0));
            patient.setIdentificationCard(cursor.getString(1));
            patient.setName(cursor.getString(2));
            patient.setSurname(cursor.getString(3));
            patient.setBirthDate(cursor.getString(4));

            patients.add(patient);
        }

        return patients;
    }

    public long deleteDoctor(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Constants.DOCTOR_TABLE, "id = ?", new String[]{String.valueOf(id)});
    }

    public long deletePatient(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Constants.PATIENT_TABLE, "id = ?", new String[]{String.valueOf(id)});
    }
}
