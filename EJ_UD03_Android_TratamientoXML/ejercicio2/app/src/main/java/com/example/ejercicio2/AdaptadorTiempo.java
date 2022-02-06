package com.example.ejercicio2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorTiempo extends ArrayAdapter<Tiempo>
{
    private ArrayList<Tiempo> tiempos;

    public AdaptadorTiempo(@NonNull Context context, @NonNull List<Tiempo> objects) {
        super(context, R.layout.listitem_tiempo, objects);
        tiempos= (ArrayList<Tiempo>) objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_tiempo, null);

        TextView txtDia=item.findViewById(R.id.txtDia);
        txtDia.setText(tiempos.get(position).getDia());

        TextView txtMaxima=item.findViewById(R.id.txtMaxima);
        txtMaxima.setText("Temperatura máxima:"+tiempos.get(position).getMaxima()+"\t");

        TextView txtMinima=item.findViewById(R.id.txtMinima);
        txtMinima.setText("Mínima:"+tiempos.get(position).getMinima());

        return item;

    }
}
