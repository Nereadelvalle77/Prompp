package com.example.ficheros2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> provincias;
    private Spinner spProvincias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spProvincias=findViewById(R.id.spProvincias);
        leerRecurso();
    }

    public void leerRecurso() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.provincias)));

            provincias=new ArrayList<String>();

            String linea = br.readLine();
            while (linea != null) {
                provincias.add(linea);
                linea = br.readLine();
            }
            br.close();

            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,provincias);
            spProvincias.setAdapter(adapter);

        }
        catch (Exception e) {
            Log.e ("MainActivity", "Error al leer recurso");
        }

    }
}