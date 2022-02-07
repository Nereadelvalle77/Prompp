package com.example.examen2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ConsultaFacturas extends AppCompatActivity {

    private TextView txtInfoC;
    private ListView lstFacturas;

    private Cliente c;
    private ClienteDao cd;
    private ArrayList<Factura> facturas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_facturas);

        txtInfoC= findViewById(R.id.txtInfoC);
        lstFacturas=findViewById(R.id.lstFacturas);

        Bundle extras=getIntent().getExtras();
        Cliente c=new Cliente(extras.getInt("dni"),extras.getString("nombre"));

        String str=getString(R.string.fade)+" "+c.getNombre();
        txtInfoC.setText(str);

        cd= new ClienteDao(this.getApplicationContext());
        facturas=cd.verFacturas(c.getDni());

        View header= getLayoutInflater().inflate(R.layout.list_cabecera,null);
        lstFacturas.addHeaderView(header);

        lstFacturas.setAdapter(new AdaptadorFactura(getApplicationContext(),facturas,c));

    }
}