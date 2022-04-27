package com.example.crm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.crm.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setListeners();
    }

    public void setListeners() {
        binding.bottomSignUp.setOnClickListener( v -> Toast.makeText(this, "Sign Up", Toast.LENGTH_SHORT).show());

        binding.loginLink.setOnClickListener( v -> onBackPressed());
    }
}