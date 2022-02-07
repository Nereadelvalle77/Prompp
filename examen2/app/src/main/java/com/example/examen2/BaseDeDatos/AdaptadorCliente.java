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

public class AdaptadorCliente extends ArrayAdapter<Cliente> 
{
    
    private ArrayList<Cliente> clientes;
    
    public AdaptadorCliente(@NonNull Context context, @NonNull List<Cliente> objects)
    {
        super(context, R.layout.listitem_cliente, objects);
        clientes= (ArrayList<Cliente>) objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) 
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_cliente, null);

        TextView txtNombre=item.findViewById(R.id.txtNombre);
        txtNombre.setText(clientes.get(position).getNombre());

        TextView txtDni=item.findViewById(R.id.txtDni);
        txtDni.setText(String.valueOf(clientes.get(position).getDni()));

        TextView txtDireccion=item.findViewById(R.id.txtDireccion);
        txtDireccion.setText(clientes.get(position).getDireccion());

        TextView txtTfno=item.findViewById(R.id.txtTfno);
        txtTfno.setText(clientes.get(position).getTfno());

        TextView txtFacturas=item.findViewById(R.id.txtFacturas);
        txtFacturas.setText(parent.getResources().getString(R.string.facturas)+clientes.get(position).getFacturas().size());

        return (item);
    }
}
