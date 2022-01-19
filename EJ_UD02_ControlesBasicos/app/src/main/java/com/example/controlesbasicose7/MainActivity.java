package com.example.controlesbasicose7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Switch swtLuces;
    private ToggleButton tgbCamaras;
    private TextView txtTemperatura;
    private ImageButton btPlus;
    private ImageButton btMinus;
    private ImageView imgLuces;
    private ImageView imgCamaras;

    private int temperatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swtLuces=findViewById(R.id.swtLuces);
        tgbCamaras=findViewById(R.id.tgbCamaras);
        txtTemperatura=findViewById(R.id.txtTemperatura);
        btPlus=findViewById(R.id.btPlus);
        btMinus=findViewById(R.id.btMinus);
        imgLuces=findViewById(R.id.imgLuces);
        imgCamaras=findViewById(R.id.imgCamaras);

        temperatura=15;
    }

    public void controlarLuces(View v)
    {
        if(swtLuces.isChecked())
        {
            imgLuces.setImageResource(R.mipmap.encendida_foreground);
        }
        else
        {
            imgLuces.setImageResource(R.mipmap.apagada_foreground);
        }
    }

    public void controlarCamaras(View v)
    {
        if(tgbCamaras.isChecked())
        {
            imgCamaras.setVisibility(View.GONE);
        }
        else
        {
            imgCamaras.setVisibility(View.VISIBLE);
        }
    }

    public void subirTemperatura(View v)
    {
        if(temperatura<30)
            temperatura++;
        cambiarTemperatura();
    }

    public void bajarTemperatura(View v)
    {
        if(temperatura>-10)
        temperatura--;
        cambiarTemperatura();
    }

    public void cambiarTemperatura()
    {
        txtTemperatura.setText(this.temperatura+"ºC");
    }

}