package com.example.controlesbasicose5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private ImageView img;
    private Button btBing;
    private Button btGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img=findViewById(R.id.img);

        btBing=findViewById(R.id.btBing);
        btGoogle=findViewById(R.id.btGoogle);

        generarEventos();
    }

    private void generarEventos()
    {
        btBing.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                img.setImageResource(R.drawable.bing);
            }
        });
        btGoogle.setOnClickListener(this);
    }

    public void cambiarIMG(View v)
    {
        img.setImageResource(R.drawable.yahoo);
    }

    @Override
    public void onClick(View view)
    {
        img.setImageResource(R.drawable.google);
    }
}