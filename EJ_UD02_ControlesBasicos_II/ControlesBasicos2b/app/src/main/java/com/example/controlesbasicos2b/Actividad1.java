package com.example.controlesbasicos2b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Actividad1 extends AppCompatActivity
{

    private Button btVolver;
    private Button btVerificar;

    private EditText txtNombre;
    private EditText txtApellido;

    private TextView lblVerficar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        btVolver=findViewById(R.id.btVolver);
        btVerificar=findViewById(R.id.btVerificar);

        txtNombre=findViewById(R.id.txtNom);
        txtApellido=findViewById(R.id.txtApe);

        lblVerficar=findViewById(R.id.lblVerificar);

    }

    public void volver0(View v)
    {
        Intent intent=new Intent(Actividad1.this,MainActivity.class);
        startActivity(intent);
    }

    public void verficarDatos(View v)
    {

        Intent intent=new Intent(Actividad1.this,Actividad1_1.class);

        String nom=txtNombre.getText().toString();
        String ape=txtApellido.getText().toString();

        intent.putExtra("nombre",nom);
        intent.putExtra("apellido",ape);

        startActivityForResult(intent, 77);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 77) && (resultCode == RESULT_OK)) {
            String res = data.getExtras().getString("cond");
            generarTexto(res);
        }
    }

    private void generarTexto(String res)
    {
        String str=getResources().getString(R.string.aceptas_condiciones)+res;
        lblVerficar.setText(str);
    }

}