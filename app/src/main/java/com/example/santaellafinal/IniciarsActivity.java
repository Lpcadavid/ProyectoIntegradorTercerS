package com.example.santaellafinal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class IniciarsActivity extends AppCompatActivity {

    private EditText editTextCorreo;
    private EditText editTextContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciars);


        editTextCorreo = findViewById(R.id.editTextUsername);
        editTextContrasena = findViewById(R.id.editTextPassword);
        Button btnIniciarSesion = findViewById(R.id.buttonLogin);


        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtiene el texto de los EditText
                String correo = editTextCorreo.getText().toString().trim();
                String contrasena = editTextContrasena.getText().toString().trim();


                if (esValido(correo, contrasena)) {

                    if (correo.equals("santaella@max.com") && contrasena.equals("12345")) {

                        Intent intent = new Intent(IniciarsActivity.this, CarritoActivity.class);
                        startActivity(intent);
                    } else {

                        Toast.makeText(IniciarsActivity.this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    }
                } else {

                    Toast.makeText(IniciarsActivity.this, "Por favor, introduce un correo y una contraseña", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean esValido(String correo, String contrasena) {
        return !TextUtils.isEmpty(correo) && !TextUtils.isEmpty(contrasena);
    }
}
