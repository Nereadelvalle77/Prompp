package com.example.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public String url = "https://www.europapress.es/rss/rss.aspx";
    private ListView lstNoticias;
    private List<Noticia> noticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstNoticias=findViewById(R.id.lstNoticias);
        cargarXMLConSAX();
    }

    public void cargarXMLConSAX (){
        CargarXmlTask tarea = new CargarXmlTask();
        tarea.execute(url);
    }

    private class CargarXmlTask extends AsyncTask<String,Integer,Boolean> {
        protected Boolean doInBackground(String... params) {
            RssParserSAX saxparser = new RssParserSAX(params[0]);
            noticias = saxparser.parse();
            return true;
        }

        protected void onPostExecute(Boolean result) {
        //Tratamos la lista de noticias
            lstNoticias.setAdapter(new AdaptadorNoticia(getApplicationContext(),noticias));
        }
    }

}