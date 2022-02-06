package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String url="https://www.aemet.es/xml/municipios/localidad_28079.xml";
    private ArrayList<Tiempo> tiempos;
    private ListView lstTiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstTiempo=findViewById(R.id.lstTiempo);
        cargarConSAXSimplificado();
    }

    public void cargarConSAXSimplificado(){
    //Carga del XML mediante tarea Asincrona
        CargarXmlTask tarea = new CargarXmlTask();
        tarea.execute(url);
    }

    private class CargarXmlTask extends AsyncTask<String,Integer,Boolean> {
        protected Boolean doInBackground(String... params) {
            RssParserSAXSimplificado saxparserSimplificado =
                    new RssParserSAXSimplificado(params[0]);
            tiempos = saxparserSimplificado.parse();
            return true;
        }
        protected void onPostExecute(Boolean result) {
        //Tratamos la lista de noticias

            lstTiempo.setAdapter(new AdaptadorTiempo(getApplicationContext(),tiempos));

        }
    }

}