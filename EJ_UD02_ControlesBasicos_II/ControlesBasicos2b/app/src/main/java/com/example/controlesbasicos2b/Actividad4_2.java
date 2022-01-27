package com.example.controlesbasicos2b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Actividad4_2 extends AppCompatActivity {

    private TextView txtInfo;

    private int clicks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad42);

        Bundle extras=getIntent().getExtras();
        clicks=extras.getInt("clicks");

        txtInfo=findViewById(R.id.txtInfo);
        txtInfo.setText("¡Enhorabuena has clickado el huevo "+clicks+" veces!");

    }

    public void cambiarContador(View v)
    {
        clicks=0;
        cerrarVentana();
    }

    private void cerrarVentana() {
        Intent intent= new Intent(Actividad4_2.this, Actividad4.class);
        intent.putExtra("clicks",this.clicks);
        setResult(RESULT_OK,intent);
        finish();
    }

    public void sumar10(View v)
    {
        clicks+=10;
        cerrarVentana();
    }
}