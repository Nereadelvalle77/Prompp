package com.example.ficheros3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private ArrayList<Web> webs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista=findViewById(R.id.lista);

        webs=new ArrayList<Web>();
        leerRecurso();
        AdaptadorWeb adapter= new AdaptadorWeb(getApplicationContext(),webs);
        lista.setAdapter(adapter);
    }

    public void leerRecurso() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.webs)));
            String linea = br.readLine();
            while (linea != null) {
                String[] l=linea.split(";");
                Web w=new Web(l[0],l[1],l[2],l[3]);
                webs.add(w);
                linea = br.readLine();
            }
            br.close();

        }
        catch (Exception e) {
            Log.e ("MainActivity", "Error al leer recurso");
        }

    }
}