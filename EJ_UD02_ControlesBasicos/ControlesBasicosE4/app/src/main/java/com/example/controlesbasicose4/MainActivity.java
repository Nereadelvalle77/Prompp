package com.example.controlesbasicose4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    private EditText txtDNI;
    private EditText txtLetra;

    private Button btValidar;

    private TextView lblValidar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDNI=(EditText) findViewById(R.id.txtDNI);
        txtLetra=(EditText) findViewById(R.id.txtLetra);

        btValidar=(Button) findViewById(R.id.btValidar);

        lblValidar=(TextView) findViewById(R.id.lblValidar);
    }

    public void validarDNI(View v)
    {
        int dni=Integer.parseInt(txtDNI.getText().toString());
        int resto=dni%23;
        char letra;
        switch(resto)
        {
            case 0:
                letra='T';
                break;
            case 1:
                letra='R';
                break;
            case 2:
                letra='W';
                break;
            case 3:
                letra='A';
                break;
            case 4:
                letra='G';
                break;
            case 5:
                letra='M';
                break;
            case 6:
                letra='Y';
                break;
            case 7:
                letra='F';
                break;
            case 8:
                letra='P';
                break;
            case 9:
                letra='D';
                break;
            case 10:
                letra='X';
                break;
            case 11:
                letra='B';
                break;
            case 12:
                letra='N';
                break;
            case 13:
                letra='J';
                break;
            case 14:
                letra='Z';
                break;
            case 15:
                letra='S';
                break;
            case 16:
                letra='Q';
                break;
            case 17:
                letra='V';
                break;
            case 18:
                letra='H';
                break;
            case 19:
                letra='L';
                break;
            case 20:
                letra='C';
                break;
            case 21:
                letra='K';
                break;
            case 22:
                letra='E';
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + resto);
        }
        if(String.valueOf(letra).equals(txtLetra.getText().toString()))
        {
            lblValidar.setText("Letra introducida correcta");
            lblValidar.setBackgroundColor(getResources().getColor(R.color.white,null));
        }
        else
        {
            lblValidar.setText("Letra introducida incorrecta");
            lblValidar.setBackgroundColor(getResources().getColor(R.color.red,null));
        }

    }
}