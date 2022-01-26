package com.example.controlesbasicos2b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Actividad2_2 extends AppCompatActivity
{

    private TextView lblRST;
    private int correcto;
    private int incorrecto;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad22);

        lblRST=findViewById(R.id.lblRST);

        Bundle extras = getIntent().getExtras();
        Boolean s = extras.getBoolean("resultado");

        correcto=extras.getInt("correcto");
        incorrecto=extras.getInt("incorrecto");

        String str;
        if(s) {
            str = getResources().getString(R.string.rstEs) + " CORRECTA";
            correcto++;
        }
        else {
            str = getResources().getString(R.string.rstEs) + " INCORRECTA";
            incorrecto++;
        }
        lblRST.setText(str);
    }

    public void volver0(View v)
    {
        Intent intent=new Intent(this,Actividad2.class);
        intent.putExtra("correcto",correcto);
        intent.putExtra("incorrecto",incorrecto);
        setResult(RESULT_OK,intent);
        finish();
    }
}