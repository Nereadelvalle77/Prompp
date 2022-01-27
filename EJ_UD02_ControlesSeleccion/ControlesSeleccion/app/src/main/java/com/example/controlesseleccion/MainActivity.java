package com.example.controlesseleccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void irA1(View v)
    {
        Intent intent=new Intent(this,Ejercicio1.class);
        startActivity(intent);
    }

    public void irA2(View v)
    {
        Intent intent=new Intent(this,Ejercicio2.class);
        startActivity(intent);
    }

    public void irA3(View v)
    {
        Intent intent=new Intent(this,Ejercicio3.class);
        startActivity(intent);
    }

}