package com.example.controlesseleccion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Ejercicio1 extends AppCompatActivity
{

    private ListView lista;

    private TextView txtDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        lista=findViewById(R.id.lista);
        txtDatos=findViewById(R.id.txtDatos);

        rellenarLista();
        generarEventos();
    }

    private void rellenarLista()
    {

        final String paises[]=new String[] {"España","Inglaterra","Italia","Rusia","Japon"};

        ArrayAdapter<String> adaptadorListView = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, paises);
        lista.setAdapter(adaptadorListView);

    }

    private void generarEventos()
    {

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String pais= (String) lista.getItemAtPosition(position);
                cambiarDatos(pais);
            }
        });

    }

    private void cambiarDatos(String pais)
    {

        String datos;
        switch (pais)
        {
            case "España":
                datos="España tiene una superficie de 505.935 Km^2 y 47.394.223 habitantes";
                break;
            case "Inglaterra":
                datos="Inglaterra tiene una superficie de 243.610 Km^2 y 67.025.542 habitantes";
                break;
            case "Italia":
                datos="Italia tiene una superficie de 301.340 Km^2 y 59.257.566 habitantes";
                break;
            case "Rusia":
                datos="Rusia tiene una superficie de 17.098.250 Km^2 y 146.171.000 habitantes";
                break;
            case "Japon":
                datos="Japon tiene una superficie de 377.970 Km^2 y 126.190.000 habitantes";
                break;
            default:
                datos=null;
        }
        txtDatos.setText(datos);

    }

    public void volver0(View v)
    {
        finish();
    }

}