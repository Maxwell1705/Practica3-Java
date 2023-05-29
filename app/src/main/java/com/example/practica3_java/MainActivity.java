package com.example.practica3_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declarar las variables
    private Button btnIngresar;
    private Button btnSalir;
    private EditText txtUsuario;
    private EditText txtContraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponentes();
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresar();
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salir();
            }
        });
    }

    private void iniciarComponentes() {
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtContraseña = (EditText) findViewById(R.id.txtContraseña);
    }

    private void ingresar() {
        String strUsuario;
        String strContraseña;

        strUsuario = getApplicationContext().getResources().getString(R.string.usuario);
        strContraseña = getApplicationContext().getResources().getString(R.string.contraseña);

        if(strUsuario.toString().equals(txtUsuario.getText().toString()) &&
                strContraseña.toString().equals(txtContraseña.getText().toString())) {

            // Hacer el paquete para enviar información
            Bundle bundle = new Bundle();
            bundle.putString("usuario", txtUsuario.getText().toString());

            // Crear el intent para llamar a otra actividad
            Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
            intent.putExtras(bundle);

            // Iniciar la actividad esperando o no respuesta
            startActivity(intent);
        } else {
            Toast.makeText(this.getApplicationContext(), "El usuario o contraseña no es válido", Toast.LENGTH_SHORT).show();
        }

    }


    private void salir() {
        finish();
    }
}