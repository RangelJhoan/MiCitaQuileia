package com.example.micitaquileia.iu.administrator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.micitaquileia.databinding.ActivityAdministradorBinding;

public class AdministradorActivity extends AppCompatActivity {

    private ActivityAdministradorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdministradorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}