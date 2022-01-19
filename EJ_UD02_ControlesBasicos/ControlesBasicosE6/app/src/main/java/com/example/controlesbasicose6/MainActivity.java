package com.example.controlesbasicose6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity
{

    private ImageView imgC1;
    private ImageView imgC2;

    private ImageView imgL1;
    private ImageView imgL2;

    private Switch swtC1;
    private Switch swtL1;

    private boolean l1;
    private boolean l2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgC1=findViewById(R.id.imgC1);
        imgL1=findViewById(R.id.imgL1);
        imgL2=findViewById(R.id.imgL2);
        imgC2=findViewById(R.id.imgC2);

        swtC1=findViewById(R.id.swtC1);
        swtL1=findViewById(R.id.swtL1);

        swtC1.setChecked(true);

        l1=true;
        l2=true;
    }

    public void apagarCamaras(View v)
    {
        if(v.getId()==swtC1.getId())
        {
            if(imgC1.getVisibility()==View.VISIBLE)
                imgC1.setVisibility(View.INVISIBLE);
            else
                imgC1.setVisibility(View.VISIBLE);
        }
        else
        {
            if(imgC2.getVisibility()==View.VISIBLE)
                imgC2.setVisibility(View.INVISIBLE);
            else
                imgC2.setVisibility(View.VISIBLE);
        }

    }

    public void controlarLuz(View v)
    {
        if(v.getId()==swtL1.getId())
        {
            if (l1 == true)
            {
                imgL1.setImageResource(R.drawable.bombillae);
                l1 = false;
            } else {
                imgL1.setImageResource(R.drawable.bombillaa);
                l1 = true;
            }
        }
        else
        {
            if (l2 == true)
            {
                imgL2.setImageResource(R.drawable.bombillae);
                l2 = false;
            } else {
                imgL2.setImageResource(R.drawable.bombillaa);
                l2 = true;
            }
        }
    }

}