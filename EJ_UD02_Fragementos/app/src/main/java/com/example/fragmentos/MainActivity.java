package com.example.fragmentos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{

    private FragmentLista frgLista;
    private FragmentDescripcion frgDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frgLista= (FragmentLista) getSupportFragmentManager().findFragmentById(R.id.frgLista);
        frgDescripcion= (FragmentDescripcion) getSupportFragmentManager().findFragmentById(R.id.frgDescripcion);

    }

    public FragmentDescripcion getFrgDescripcion() {
        return frgDescripcion;
    }
}