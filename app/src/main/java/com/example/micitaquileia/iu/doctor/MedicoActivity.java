package com.example.micitaquileia.iu.doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.micitaquileia.databinding.ActivityMedicoBinding;

public class MedicoActivity extends AppCompatActivity {

    private ActivityMedicoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMedicoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}