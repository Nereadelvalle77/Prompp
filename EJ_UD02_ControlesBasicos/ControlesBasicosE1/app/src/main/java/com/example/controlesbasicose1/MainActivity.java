package com.example.controlesbasicose1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
{

    private EditText txtPrimerValor;
    private EditText txtSegundoValor;
    private TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtPrimerValor= (EditText) findViewById(R.id.txtPrimerValor);
        txtSegundoValor= (EditText) findViewById(R.id.txtSegundoValor);
        lblResultado= (TextView) findViewById(R.id.lblResultado);

    }

    public void sumar(View v)
    {
        try
        {
            int n1= Integer.parseInt(txtPrimerValor.getText().toString());
            int n2=Integer.parseInt(txtSegundoValor.getText().toString());
            int suma=n1+n2;
            lblResultado.setText(String.valueOf(suma));
        }
        catch(NumberFormatException e)
        {
            Toast.makeText(this.getBaseContext(),"Asegurate de introducir numeros",Toast.LENGTH_LONG).show();
        }

    }
}