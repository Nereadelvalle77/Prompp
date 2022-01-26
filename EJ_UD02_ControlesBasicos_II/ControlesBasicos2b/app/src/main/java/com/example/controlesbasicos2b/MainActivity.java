package com.example.controlesbasicos2b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ejecutarActividad(View v)
    {

         int id=v.getId();
         Intent intent;
        switch (id)
        {
            case R.id.btAct01:
                intent=new Intent(MainActivity.this,Actividad1.class);
                startActivity(intent);
                break;
            case R.id.btAct02:
                intent=new Intent(MainActivity.this,Actividad2.class);
                startActivity(intent);
                break;
            case R.id.btAct03:
                intent=new Intent(MainActivity.this,Actividad3.class);
                startActivity(intent);
                break;
            case R.id.btAct04:
                intent=new Intent(MainActivity.this,Actividad4.class);
                startActivity(intent);
                break;
            case R.id.btSalir:
                finishAffinity();
                break;
        }

    }

}