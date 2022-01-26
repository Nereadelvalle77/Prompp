package com.example.controlesbasicos2b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Actividad1_1 extends AppCompatActivity
{

    private Bundle extras;

    private TextView lblSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad11);

        extras=getIntent().getExtras();

        lblSaludo=findViewById(R.id.lblSaludo);
        generarTexto();
    }

    private void generarTexto()
    {
        String saludo="Hola "+extras.getString("nombre")+" "+extras.getString("apellido")+"! ¿Aceptas las condiciones?";
        lblSaludo.setText(saludo);
    }

    public void aceptarCondiciones(View v)
    {
        Intent intent= new Intent(this, Actividad1.class);

        intent.putExtra("cond", "ACEPTADAS");

        setResult(RESULT_OK, intent);
        finish();
    }

    public void rechazarCondiciones(View v)
    {
        Intent intent= new Intent(this, Actividad1.class);

        intent.putExtra("cond", "RECHAZADAS");

        setResult(RESULT_OK, intent);
        finish();
    }

}