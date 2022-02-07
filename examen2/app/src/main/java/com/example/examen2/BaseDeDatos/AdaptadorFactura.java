package com.example.examen2.BaseDeDatos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.examen2.R;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorFactura extends ArrayAdapter<Factura>
{

    private ArrayList<Factura> facturas;
    private Cliente c;

    public AdaptadorFactura(@NonNull Context context, @NonNull List<Factura> objects, Cliente c) {
        super(context, R.layout.listitem_factura, objects);
        facturas= (ArrayList<Factura>) objects;
        this.c=c;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_cliente, null);

        TextView txtNum=item.findViewById(R.id.txtNum);
        txtNum.setText(String.valueOf(facturas.get(position).getNum()));

        TextView txtConcepto=item.findViewById(R.id.txtConcepto);
        txtConcepto.setText(facturas.get(position).getConcepto());

        TextView txtValor=item.findViewById(R.id.txtValor);
        txtValor.setText(facturas.get(position).getValor()+"€");

        TextView txtDniF= item.findViewById(R.id.txtDniF);
        txtDniF.setText(String.valueOf(c.getDni()));

        TextView txtNombreF=item.findViewById(R.id.txtNombreF);
        txtNombreF.setText(c.getNombre());

        return (item);
    }
}
