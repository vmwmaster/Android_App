package com.wilson.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView tvNombreCompleto;
    private TextView tvFechaNacimiento;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        //Recibimos los parametros
        Bundle parametros   = getIntent().getExtras();
        String nombre       = parametros.getString(getResources().getString(R.string.pnombre));
        String fecha       = parametros.getString(getResources().getString(R.string.pfechan));
        String telefono     = parametros.getString(getResources().getString(R.string.ptelefono));
        String email        = parametros.getString(getResources().getString(R.string.pemail));
        String descripcion  = parametros.getString(getResources().getString(R.string.pdesripcion));

        tvNombreCompleto    = findViewById(R.id.tvNombreCompleto);
        tvFechaNacimiento   = findViewById(R.id.tvFechaNacimiento);
        tvTelefono          = findViewById(R.id.tvTelefono);
        tvEmail             = findViewById(R.id.tvEmail);
        tvDescripcion       = findViewById(R.id.tvDescripcion);

        tvNombreCompleto.setText(nombre);
        tvFechaNacimiento.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);
    }

    public void editarDatos(View view) {
        finish();
    }
}