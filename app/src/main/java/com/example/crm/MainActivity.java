package com.example.crm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.crm.dao.DAO;
import com.example.crm.databinding.ActivityMainBinding;
import com.example.crm.modelo.Usuario;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toast.makeText(this, "Hola", Toast.LENGTH_SHORT).show();
        DAO dao = new DAO();

        String usuarios = "";
        for( Usuario u: dao.DoOnThread() ) {
            usuarios += u.getUsername() + "\n";
        }
        binding.texto.setText( usuarios );
    }
}