package com.example.examen2.BaseDeDatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examen2.R;

public class CrearFactura extends AppCompatActivity {

    private TextView txtCreando;

    private EditText edtNum;
    private EditText edtConcepto;
    private EditText edtValor;

    private Cliente c;
    private ClienteDao cd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_factura);

        txtCreando=findViewById(R.id.txtCreando);
        edtNum=findViewById(R.id.edtNum);
        edtConcepto=findViewById(R.id.edtConcepto);
        edtValor=findViewById(R.id.edtValor);

        Bundle extra= getIntent().getExtras();
        c= (Cliente) extra.getSerializable("cliente");
        cd= new ClienteDao(getApplicationContext());

    }

    public void crearFact(View v)
    {
        String num=edtNum.getText().toString();
        String concepto=edtConcepto.getText().toString();
        String valor=edtValor.getText().toString();

        if(num.length()>0 && concepto.length()>0 && valor.length()>0)
        {
            Factura f= new Factura(Integer.parseInt(num),c.getDni(),concepto,Float.parseFloat(valor));
            cd.aniadirFactura(f);
            finish();
        }
        else
        {
            Toast.makeText(this, "Todos los campos tienen que estar rellenados", Toast.LENGTH_SHORT).show();
        }

    }
}