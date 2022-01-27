package com.example.controlesseleccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Ejercicio2 extends AppCompatActivity
{

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        lista=findViewById(R.id.lista);

        rellanarLista();
        generarEventos();
    }

    private void rellanarLista()
    {
        Web[] datosWeb=new Web[] {
                new Web("Instagram","https://www.instagram.com/?hl=es",R.mipmap.instagram_round,"272"),
                new Web("Twitter","https://twitter.com/?lang=es",R.mipmap.twitter_round,"T45"),
                new Web("Facebook","https://es-es.facebook.com/",R.mipmap.facebook_round,"84sF"),
        };

        AdaptadorWeb aw= new AdaptadorWeb(this,datosWeb);
        lista.setAdapter(aw);
    }

    private void generarEventos()
    {
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                Web web=(Web) adapterView.getItemAtPosition(position);
                String url=web.getUrl();

                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    public void volver0(View v)
    {
        finish();
    }

}