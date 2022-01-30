package com.example.micitaquileia.iu.adapters;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.micitaquileia.R;
import com.example.micitaquileia.entities.Doctor;
import com.example.micitaquileia.interfaces.AdminActionOnUsersCallback;

import java.util.ArrayList;

public class DoctorsAdapter
        extends RecyclerView.Adapter<DoctorsAdapter.ViewHolderDatos>
        implements View.OnClickListener {

    private ArrayList<Doctor> doctorsList;
    private View.OnClickListener listener;
    private AdminActionOnUsersCallback callback;

    private TextView tvName, tvProfessionalCode, tvSpeciality;
    private Button btnEditDoctor, btnDeleteDoctor;

    public DoctorsAdapter(ArrayList<Doctor> doctorsList, AdminActionOnUsersCallback callback) {
        this.doctorsList = doctorsList;
        this.callback = callback;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_doctors, parent, false);
        view.setOnClickListener(listener);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        tvName.setText(doctorsList.get(position).getFullName());
        tvProfessionalCode.setText(doctorsList.get(position).getProfessionalCardCode());
        tvSpeciality.setText(doctorsList.get(position).getSpeciality());

        btnDeleteDoctor.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle("ELIMINAR MÉDICO")
                    .setMessage("¿Desea eliminar este médico?")
                    .setPositiveButton("Sí", (dialogInterface, i) -> {
                        callback.deleteUser(doctorsList.get(position).getId());
                        dialogInterface.dismiss();
                    })
                    .setNegativeButton("Cancelar", (dialogInterface, i) -> dialogInterface.cancel())
                    .create()
                    .show();
        });

        btnEditDoctor.setOnClickListener(view -> callback.editUser(doctorsList.get(position).getId()));
    }

    @Override
    public int getItemCount() {
        return doctorsList.size();
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvProfessionalCode = itemView.findViewById(R.id.tvProfessionalCode);
            tvSpeciality = itemView.findViewById(R.id.tvSpeciality);
            btnDeleteDoctor = itemView.findViewById(R.id.btnDeleteDoctor);
            btnEditDoctor = itemView.findViewById(R.id.btnEditDoctor);

        }
    }
}
