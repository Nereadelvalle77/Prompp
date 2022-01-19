package com.example.controlesbasicose3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    public LinearLayout panFondo;

    private Button btEncender;
    private Button btApagar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        panFondo = (LinearLayout) findViewById(R.id.panFondo);

        btEncender= (Button) findViewById(R.id.btEncender);
        btApagar=(Button) findViewById(R.id.btApagar);
    }

    public void encender(View v)
    {
        panFondo.setBackgroundColor(getResources().getColor(R.color.azulC,getTheme()));
    }

    public void apagar(View v)
    {
        panFondo.setBackgroundColor(getResources().getColor(R.color.azulS,getTheme()));
    }
}