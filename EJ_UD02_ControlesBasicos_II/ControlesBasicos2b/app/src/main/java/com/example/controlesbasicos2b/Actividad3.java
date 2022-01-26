package com.example.controlesbasicos2b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Actividad3 extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtApe;
    private RadioButton rdbtMujer;
    private RadioButton rdbtHombre;
    private CheckBox chbMusica;
    private CheckBox chbLectura;
    private CheckBox chbDeportes;
    private CheckBox chbViajar;

    private RadioGroup rbtnG;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3);

        txtNombre=findViewById(R.id.txtNombre);
        txtApe=findViewById(R.id.txtApe);

        rdbtMujer=findViewById(R.id.rdbtMujer);
        rdbtHombre=findViewById(R.id.rdbtHombre);

        chbMusica=findViewById(R.id.chbMusica);
        chbLectura=findViewById(R.id.chbLectura);
        chbDeportes=findViewById(R.id.chbDeportes);
        chbViajar=findViewById(R.id.chbViajar);

        rbtnG=findViewById(R.id.rbtnG);
    }

    private boolean validarDatos()
    {
        Boolean valido=true;

        String nombre=txtNombre.getText().toString();
        if(nombre.length()<0)
            valido=false;

        String ape=txtApe.getText().toString();
        if(ape.length()<0)
            valido=false;

        int id=rbtnG.getCheckedRadioButtonId();
        if(id==-1)
        {
            valido=false;
        }

        return valido;
    }

    public void enviarDatos(View v)
    {
        if(validarDatos())
        {

            RadioButton rb=findViewById(rbtnG.getCheckedRadioButtonId());

            ArrayList<String> af=new ArrayList<String>();
            if(chbMusica.isChecked())
                af.add(chbMusica.getText().toString());
            if(chbLectura.isChecked())
                af.add(chbLectura.getText().toString());
            if(chbDeportes.isChecked())
                af.add(chbDeportes.getText().toString());
            if(chbViajar.isChecked())
                af.add(chbViajar.getText().toString());

            Intent intent=new Intent(Actividad3.this,Actividad3_2.class);
            intent.putExtra("nombre",txtNombre.getText().toString());
            intent.putExtra("ape",txtApe.getText().toString());
            intent.putExtra("sx",rb.getText().toString());
            intent.putExtra("af",af);
            startActivity(intent);
        }
    }
}