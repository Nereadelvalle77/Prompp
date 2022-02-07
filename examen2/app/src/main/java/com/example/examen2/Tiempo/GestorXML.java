package com.example.examen2.Tiempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.examen2.R;

public class GestorXML extends AppCompatActivity
{

    private String urlB="https://api.tutiempo.net/xml/?lan=es&apid=qsTX4X4qq44as6Q&lid=8050";
    private String urlV="https://api.tutiempo.net/xml/?lan=es&apid=qsTX4X4qq44as6Q&lid=8043";
    private String urlD="https://api.tutiempo.net/xml/?lan=es&apid=qsTX4X4qq44as6Q&lid=4917";

    private Tiempo t;

    private TextView txtEn;
    private TextView txtFecha;
    private TextView txtTemperatura;
    private TextView txtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestor_xml);

        txtEn=findViewById(R.id.txtEn);
        txtFecha=findViewById(R.id.txtFecha);
        txtTemperatura=findViewById(R.id.txtTemperatura);
        txtText=findViewById(R.id.txtText);
    }

    public void cargarBilbo(View v)
    {
        cargarConSAXSimplificado(urlB);
        txtEn.setText(getString(R.string.tiempo_en)+" Bilbao");
    }

    public void cargarVitoria(View v)
    {
        cargarConSAXSimplificado(urlV);
        txtEn.setText(getString(R.string.tiempo_en)+" Vitoria");
    }

    public void cargarDonosti(View v)
    {
        cargarConSAXSimplificado(urlD);
        txtEn.setText(getString(R.string.tiempo_en)+" Donosti");
    }

    public void salir()
    {
        finish();
    }

    private class CargarXmlTask extends AsyncTask<String,Integer,Boolean> {
        protected Boolean doInBackground(String... params) {
            RssParserSaxSimplificado saxparserSimplificado =
                    new RssParserSaxSimplificado(params[0]);
            t = saxparserSimplificado.parse();
            return true;
        }
        protected void onPostExecute(Boolean result) {
            txtFecha.setText(getString(R.string.fecha_hora)+" "+t.getFecha()+"/"+t.getHora());
            txtTemperatura.setText(getString(R.string.temperatura)+" "+t.getTemperatura()+" Min "+t.getMinima()+", Max "+t.getMaxima());
            txtText.setText(t.getText());
        }
    }

    public void cargarConSAXSimplificado(String url){
        //Carga del XML mediante tarea Asincrona
        CargarXmlTask tarea = new CargarXmlTask();
        tarea.execute(url);
    }
}