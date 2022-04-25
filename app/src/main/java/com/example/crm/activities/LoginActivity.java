package com.example.crm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.crm.MainActivity;
import com.example.crm.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setListeners();
    }

    private void setListeners() {
        binding.bottomLogin.setOnClickListener(v -> {
            Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
        });

        binding.createAccount.setOnClickListener(v ->
                startActivity(new Intent(this, SignUpActivity.class)));
    }
}