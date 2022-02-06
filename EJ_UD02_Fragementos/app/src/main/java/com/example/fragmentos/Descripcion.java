package com.example.fragmentos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class Descripcion extends AppCompatActivity {

    private FragmentDescripcion frgDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);

        frgDescripcion= (FragmentDescripcion) getSupportFragmentManager().findFragmentById(R.id.frgDescripcion);
        Bundle extras=getIntent().getExtras();
        String descripcion= extras.getString("descripcion");
        Log.i("desc",descripcion);
    }
}