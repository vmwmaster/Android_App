package com.wilson.androidapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePickerDialog picker;
    TextInputEditText nombreCompleto;
    EditText fechaNacimiento;
    EditText telefono;
    EditText correoElectronico;
    TextInputEditText descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreCompleto              = findViewById(R.id.etNombreCompleto);
        telefono                    = findViewById(R.id.etTelefono);
        correoElectronico           = findViewById(R.id.etEmail);
        descripcion                 = findViewById(R.id.etDescripcion);
        fechaNacimiento             = findViewById(R.id.etFecha);

        //Seleccionar fecha DatePicker
        fechaNacimiento.setInputType(InputType.TYPE_NULL);
        fechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day             = cldr.get(Calendar.DAY_OF_MONTH);
                int month           = cldr.get(Calendar.MONTH);
                int year            = cldr.get(Calendar.YEAR);
                picker              = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                fechaNacimiento.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });


    }

    public void siguiente (View view){

        if (validaCampos()) {

            Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);

            //Enviamos los parametros
            Bundle miBundle = new Bundle();
            miBundle.putString("nombre", nombreCompleto.getText().toString());
            miBundle.putString("fecha", fechaNacimiento.getText().toString());
            miBundle.putString("telefono", telefono.getText().toString());
            miBundle.putString("email", correoElectronico.getText().toString());
            miBundle.putString("descripcion", descripcion.getText().toString());
            intent.putExtras(miBundle);

            startActivity(intent);
        }
    }

    public boolean validaCampos (){
        boolean retorno = true;

        String nombre               = nombreCompleto.getText().toString();
        String fechaN               = fechaNacimiento.getText().toString();
        String tel                  = telefono.getText().toString();
        String email                = correoElectronico.getText().toString();
        String descrip              = descripcion.getText().toString();

        if (nombre.isEmpty()) {
            nombreCompleto.setError("Campo Obligatorio");
            retorno = false;
        }

        if (fechaN.isEmpty()) {
            fechaNacimiento.setError("Campo Obligatorio");
            retorno = false;
        }

        if (tel.isEmpty()) {
            telefono.setError("Campo Obligatorio");
            retorno = false;
        }

        if (email.isEmpty()) {
            correoElectronico.setError("Campo Obligatorio");
            retorno = false;
        }

        if (descrip.isEmpty()) {
            descripcion.setError("Campo Obligatorio");
            retorno = false;
        }

        return retorno;
    }
}