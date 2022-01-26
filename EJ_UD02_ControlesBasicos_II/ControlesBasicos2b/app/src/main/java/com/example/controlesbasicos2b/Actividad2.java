package com.example.controlesbasicos2b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Actividad2 extends AppCompatActivity
{

    private int correcto;
    private int incorrecto;

    private int n1;
    private int n2;

    private EditText txtResult;

    private TextView lblN1;
    private TextView lblN2;

    private TextView lblCorrecto;
    private TextView lblIncorrecto;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        correcto=0;
        incorrecto=0;

        txtResult= findViewById(R.id.txtResult);

        lblN1= findViewById(R.id.lblN1);
        lblN2= findViewById(R.id.lblN2);

        lblCorrecto= findViewById(R.id.lblCorrecto);
        lblIncorrecto= findViewById(R.id.lblIncorrecto);

        establecerAleatorios();
        establecerIntentos();
    }

    public void establecerAleatorios()
    {
        n1= (int) (0+Math.random()*101);
        n2= (int) (0+Math.random()*101);

        lblN1.setText(String.valueOf(n1));
        lblN2.setText(String.valueOf(n2));
        txtResult.setText("");
    }

    public void establecerIntentos()
    {
        lblCorrecto.setText(getResources().getString(R.string.intCr)+this.correcto);
        lblIncorrecto.setText(getResources().getString(R.string.intInc)+this.incorrecto);
    }

    public void comprobarResultados(View v)
    {
        String prueba=txtResult.getText().toString();
        if(prueba!=null)
        {
            try
            {
                int pr=Integer.parseInt(prueba);

                boolean r;
                if(pr==(n1+n2))
                {
                    r=true;
                }
                else
                {
                    r=false;
                }

                Intent intent= new Intent(this, Actividad2_2.class);
                intent.putExtra("resultado", r);
                intent.putExtra("correcto",correcto);
                intent.putExtra("incorrecto",incorrecto);
                startActivityForResult(intent,1277);
            }
            catch(NumberFormatException e)
            {
                finish();
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1277 && resultCode == RESULT_OK) {
            establecerAleatorios();
            correcto = data.getExtras().getInt("correcto");
            incorrecto = data.getExtras().getInt("incorrecto");
            establecerIntentos();
        }
    }

    public void volver0(View v)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}