package com.example.frgx;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Descripcion extends AppCompatActivity {

    private FragmentDescripcion frgDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);

        frgDescripcion= (FragmentDescripcion) getSupportFragmentManager().findFragmentById(R.id.frgDescripcion);
        Bundle extras=getIntent().getExtras();
        String descripcion= extras.getString("descripcion");

        frgDescripcion.setDescripcion(descripcion);

    }
}