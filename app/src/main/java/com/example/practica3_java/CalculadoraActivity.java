package com.example.practica3_java;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraActivity extends AppCompatActivity {

    // Declaración de las variables
    private Button btnSumar;
    private Button btnRestar;
    private Button btnMultiplicar;
    private Button btnDividir;
    private Button btnLimpiar;
    private Button btnRegresar;
    private TextView lblUsuario;
    private TextView lblResultado;
    private EditText txtUno;
    private EditText txtDos;

    // Declarar el Objeto Calculadora
    private Calculadora calculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        iniciarComponentes();

        // Obtener los datos del MainActivity
        Bundle datos = getIntent().getExtras();
        String usuario = datos.getString("usuario");
        lblUsuario.setText(usuario);

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSumar();
            }
        });

        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRestar();
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnMultiplicar();
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDividir();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLimpiar();
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRegresar();
            }
        });
    }

    private void iniciarComponentes() {
        // Botones
        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegresar = findViewById(R.id.btnRegresar);

        // Etiquetas
        lblUsuario = findViewById(R.id.lblUsuario);
        lblResultado = findViewById(R.id.lblResultado);

        // Cajas de texto
        txtUno = findViewById(R.id.txtNum1);
        txtDos = findViewById(R.id.txtNum2);

        // Objeto Calculadora
        calculadora = new Calculadora(0, 0);
    }

    private void btnSumar() {
        String num1Text = txtUno.getText().toString();
        String num2Text = txtDos.getText().toString();

        if(num1Text.isEmpty() || num2Text.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Rellena todos los campos", Toast.LENGTH_SHORT).show();
        }else {
            calculadora.num1 = Float.parseFloat(txtUno.getText().toString());
            calculadora.num2 = Float.parseFloat(txtDos.getText().toString());
            float total = calculadora.suma();
            lblResultado.setText(String.valueOf(total));
        }
    }

    private void btnRestar() {
        String num1Text = txtUno.getText().toString();
        String num2Text = txtDos.getText().toString();

        if(num1Text.isEmpty() || num2Text.isEmpty()) {
            Toast.makeText(this.getApplicationContext(), "Rellena todos los campos", Toast.LENGTH_SHORT).show();
        }else {
            calculadora.num1 = Float.parseFloat(txtUno.getText().toString());
            calculadora.num2 = Float.parseFloat(txtDos.getText().toString());
            float total = calculadora.resta();
            lblResultado.setText(String.valueOf(total));
        }
    }

    private void btnMultiplicar() {
        String num1Text = txtUno.getText().toString();
        String num2Text = txtDos.getText().toString();

        if(num1Text.isEmpty() || num2Text.isEmpty()) {
            Toast.makeText(this.getApplicationContext(), "Rellena todos los campos", Toast.LENGTH_SHORT).show();
        }else {
            calculadora.num1 = Float.parseFloat(txtUno.getText().toString());
            calculadora.num2 = Float.parseFloat(txtDos.getText().toString());
            float total = calculadora.multiplicacion();
            lblResultado.setText(String.valueOf(total));
        }
    }

    private void btnDividir() {
        String num1Text = txtUno.getText().toString();
        String num2Text = txtDos.getText().toString();

        if(num1Text.isEmpty() || num2Text.isEmpty()) {
            Toast.makeText(this.getApplicationContext(), "Rellena todos los campos", Toast.LENGTH_SHORT).show();
        }else {
            calculadora.num1 = Float.parseFloat(txtUno.getText().toString());
            calculadora.num2 = Float.parseFloat(txtDos.getText().toString());
            float total = calculadora.division();
            lblResultado.setText(String.valueOf(total));
        }
    }

    private void btnLimpiar() {
        lblResultado.setText("");
        txtUno.setText("");
        txtDos.setText("");
    }

    private void btnRegresar() {
        AlertDialog.Builder confirmar = new AlertDialog.Builder(this);
        confirmar.setTitle("Calculadora");
        confirmar.setMessage("Regresar al MainActivity");
        confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // No hace nada
            }
        });
        confirmar.show();
    }
}