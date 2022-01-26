package com.example.controlesbasicos2b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Actividad3_2 extends AppCompatActivity {

    private TextView txtDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad32);

        txtDatos =findViewById(R.id.txtDatos);

        Bundle extras=getIntent().getExtras();

        String nombre=extras.getString("nombre");
        String ape=extras.getString("ape");
        String sx=extras.getString("sx");

        ArrayList<String> af= extras.getStringArrayList("af");
        String gst="";
        if(af.size()>0)
        {
            for (int i=0; i<af.size();i++ )
            {
                gst=gst+af.get(i)+",";
            }
        }
        else
        {
            gst="nada.";
        }

        txtDatos.setText("A "+nombre+" "+ape+ "("+sx+") le gusta "+gst);

    }
}