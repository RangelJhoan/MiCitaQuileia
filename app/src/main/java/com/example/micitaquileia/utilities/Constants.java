package com.example.micitaquileia.utilities;

public class Constants {
    /*
        Constants del menú
     */
    public static final String CREATE_DOCTOR = "Crear médico";
    public static final String GET_DOCTORS = "Consultar médicos";

    public static final String CREATE_PATIENT = "Crear paciente";
    public static final String GET_PATIENTS = "Consultar pacientes";

    /*
        Constants de la base de datos
     */

    //Dropear tabla existente
    public static final String DROP_TABLE_EXISTENT = "DROP TABLE IF EXISTS ";

    //CAMPOS ENTIDAD: doctor
    public static final String DOCTOR_TABLE = "doctor";
    public static final String DOCTOR_ID = "id";
    public static final String DOCTOR_FULLNAME = "full_name";
    public static final String DOCTOR_PROFESSIONAL_CARD = "professional_card";
    public static final String DOCTOR_SPECIALITY = "speciality";
    public static final String DOCTOR_YEARS_EXPERIENCE = "years_experience";
    public static final String DOCTOR_OFFICE = "office";
    public static final String DOCTOR_SERVES_AT_HOME = "serves_at_home";

    public static final String CREATE_DOCTOR_TABLE = "CREATE TABLE " + DOCTOR_TABLE + " (" + DOCTOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + DOCTOR_FULLNAME + " TEXT, " +
            DOCTOR_PROFESSIONAL_CARD + " TEXT, " + DOCTOR_SPECIALITY + " TEXT, " + DOCTOR_YEARS_EXPERIENCE + " REAL, " + DOCTOR_OFFICE + " TEXT, " + DOCTOR_SERVES_AT_HOME + " INTEGER)";

    //CAMPOS ENTIDAD: patient
    public static final String PATIENT_TABLE = "patient";
    public static final String PATIENT_ID = "id";
    public static final String PATIENT_NAME = "name";
    public static final String PATIENT_SURNAME = "surname";
    public static final String PATIENT_BIRTH_DATE = "birth_date";
    public static final String PATIENT_IDENTIFICATION_CARD = "identification_card";
    public static final String PATIENT_IS_IN_TREATMENT = "is_in_treatment";

    public static final String CREATE_PATIENT_TABLE = "CREATE TABLE " + PATIENT_TABLE + " (" + PATIENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + PATIENT_NAME + " TEXT, " +
            PATIENT_SURNAME + " TEXT, " + PATIENT_BIRTH_DATE + " TEXT, " + PATIENT_IDENTIFICATION_CARD + " TEXT, " + PATIENT_IS_IN_TREATMENT + " INTEGER)";

    public static final String DELETE_DOCTOR = "Eliminar doctor";
    public static final String EDIT_DOCTOR = "Editar doctor";

    public static final String DELETE_PATIENT = "Eliminar paciente";
    public static final String EDIT_PATIENT = "Editar paciente";

}
