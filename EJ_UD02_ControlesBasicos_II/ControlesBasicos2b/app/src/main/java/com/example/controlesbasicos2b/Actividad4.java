package com.example.controlesbasicos2b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class Actividad4 extends AppCompatActivity {

    private int clicks;

    private ImageButton btHuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad4);

        btHuevo=findViewById(R.id.btHuevo);

        clicks=0;
    }

    public void comprobarClicks(View v)
    {
        Intent intent= new Intent(Actividad4.this,Actividad4_2.class);
        intent.putExtra("clicks",this.clicks);
        startActivityForResult(intent,1277);
    }

    public void sumarClick(View v)
    {
        clicks+=1;
        YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(btHuevo);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1277 && resultCode==RESULT_OK)
        {
            this.clicks=data.getExtras().getInt("clicks");
            if(clicks>10) {
                btHuevo.setImageResource(R.mipmap.huevopollo_foreground);
                YoYo.with(Techniques.RubberBand).duration(700).repeat(1).playOn(btHuevo);
            }
        }

    }
}