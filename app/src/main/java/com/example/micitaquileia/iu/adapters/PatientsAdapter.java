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
import com.example.micitaquileia.entities.Patient;
import com.example.micitaquileia.interfaces.AdminActionOnUsersCallback;

import java.util.ArrayList;

public class PatientsAdapter
        extends RecyclerView.Adapter<PatientsAdapter.ViewHolderDatos>
        implements View.OnClickListener {

    private ArrayList<Patient> patientList;
    private View.OnClickListener listener;
    private AdminActionOnUsersCallback callback;

    public PatientsAdapter(ArrayList<Patient> patientList, AdminActionOnUsersCallback callback) {
        this.patientList = patientList;
        this.callback = callback;
    }

    @NonNull
    @Override
    public PatientsAdapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_patients, parent, false);
        view.setOnClickListener(listener);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientsAdapter.ViewHolderDatos holder, int position) {
        holder.tvIdentificationNumber.setText(patientList.get(position).getIdentificationCard());
        holder.tvName.setText(patientList.get(position).getName());
        holder.tvSurname.setText(patientList.get(position).getSurname());
        holder.tvBirthDate.setText(patientList.get(position).getBirthDate());

        holder.btnEditPatient.setOnClickListener(view -> {
            callback.editUser(patientList.get(position).getId());
        });

        holder.btnDeletePatient.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle("ELIMINAR MÉDICO")
                    .setMessage("¿Desea eliminar este médico?")
                    .setPositiveButton("Sí", (dialogInterface, i) -> {
                        callback.deleteUser(patientList.get(position).getId());
                        dialogInterface.dismiss();
                    })
                    .setNegativeButton("Cancelar", (dialogInterface, i) -> {
                        dialogInterface.cancel();
                    })
                    .create()
                    .show();
        });

    }

    @Override
    public int getItemCount() {
        return patientList.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView tvIdentificationNumber, tvName, tvSurname, tvBirthDate;
        Button btnEditPatient, btnDeletePatient;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            tvIdentificationNumber = itemView.findViewById(R.id.tvIdentificationNumber);
            tvName = itemView.findViewById(R.id.tvName);
            tvSurname = itemView.findViewById(R.id.tvSurname);
            tvBirthDate = itemView.findViewById(R.id.tvBirthDate);
            btnDeletePatient = itemView.findViewById(R.id.btnDeletePatient);
            btnEditPatient = itemView.findViewById(R.id.btnEditPatient);

        }
    }
}
