 package com.example.examen2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity implements DialogoCerrar.OnDialogoCerrarListener
 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gestionarBD(View v)
    {
        Intent intent = new Intent(MainActivity.this,BBDD.class);
        startActivity(intent);
    }

     public void verTiempo(View v)
     {
         Intent intent = new Intent(MainActivity.this,GestorXml.class);
         startActivity(intent);
     }

     public void cerrarApp(View v)
     {
         DialogoCerrar dc= new DialogoCerrar();
         dc.show(getSupportFragmentManager(),"Dialogo cerrar");
     }

     @Override
     public void onPossitiveCerrar() {
        finish();
     }

     @Override
     public void onNegativeCerrar() {
         Toast.makeText(this, R.string.no_cerrar, Toast.LENGTH_SHORT).show();
     }
 }