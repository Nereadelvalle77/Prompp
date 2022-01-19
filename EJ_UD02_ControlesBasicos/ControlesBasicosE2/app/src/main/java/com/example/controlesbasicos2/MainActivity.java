package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    private Button btSuma;
    private Button btResta;
    private Button btMulti;
    private Button btDiv;

    private EditText txtPrimerValor;
    private EditText txtSegundoValor;

    private TextView lblOperacion;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSuma=(Button) findViewById(R.id.btSuma);
        btResta=(Button) findViewById(R.id.btResta);
        btMulti=(Button) findViewById(R.id.btMulti);
        btDiv=(Button) findViewById(R.id.btDiv);

        txtPrimerValor=(EditText) findViewById(R.id.txtPrimerValor);
        txtSegundoValor=(EditText) findViewById(R.id.txtSegundoValor);

        lblOperacion=(TextView) findViewById(R.id.lblOperacion);

    }

    public void hacerOperaciones(View v)
    {
        int n1;
        int n2;
        try//Teclado numerico en este caso no hace falta
        {
            n1=Integer.parseInt(txtPrimerValor.getText().toString());
            n2=Integer.parseInt(txtSegundoValor.getText().toString());
        }
        catch(NumberFormatException e)
        {
            n1=0;
            n2=1;
        }
        int id=v.getId();
        int resultado;
        switch (id)
        {
            case R.id.btSuma:
                resultado=n1+n2;
                lblOperacion.setText(String.valueOf(resultado));
                break;
            case R.id.btResta:
                resultado=n1-n2;
                lblOperacion.setText(String.valueOf(resultado));
                break;
            case R.id.btMulti:
                resultado=n1*n2;
                lblOperacion.setText(String.valueOf(resultado));
                break;
            case R.id.btDiv:
                if(n2==0)
                {
                    lblOperacion.setText("No se puede dividir entre cero");
                }
                else
                {
                    resultado=n1/n2;
                    lblOperacion.setText(String.valueOf(resultado));
                    //lblOperacion.setText(String.valueOf(n1/n2));
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + id);
        }
    }

}