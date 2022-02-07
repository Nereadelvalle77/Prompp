package com.example.examen2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BBDD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbdd);
    }

    public void crearCliente(View v)
    {
        Intent intent=new Intent(BBDD.this,CrearCliente.class);
        startActivity(intent);
    }

    public void modificarCliente(View v)
    {
        DialogoSeleccionCliente dgc= new DialogoSeleccionCliente(this,"modificar");
        FragmentManager fragmentManager= getSupportFragmentManager();
        dgc.show(fragmentManager,"Seleccion cliente");
    }

    public void crearFactura(View v)
    {
        DialogoSeleccionCliente dgc= new DialogoSeleccionCliente(this,"crear");
        FragmentManager fragmentManager= getSupportFragmentManager();
        dgc.show(fragmentManager,"Crear factura");
    }

    public void consultarFacturas(View v)
    {
        DialogoSeleccionCliente dgc= new DialogoSeleccionCliente(this,"consultar");
        FragmentManager fragmentManager= getSupportFragmentManager();
        dgc.show(fragmentManager,"Consultar factura");
    }
}