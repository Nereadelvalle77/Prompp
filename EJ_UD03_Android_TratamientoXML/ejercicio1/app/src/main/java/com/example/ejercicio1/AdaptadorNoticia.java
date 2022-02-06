package com.example.ejercicio1;

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

public class AdaptadorNoticia extends ArrayAdapter
{
    private ArrayList<Noticia> noticias;

    public AdaptadorNoticia(@NonNull Context context, @NonNull List objects) {
        super(context, R.layout.listitem_noticia, objects);
        noticias= (ArrayList<Noticia>) objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_noticia, null);

        TextView txtTitulo=item.findViewById(R.id.txtTitulo);
        txtTitulo.setText(noticias.get(position).getTitulo());

        TextView txtDescripcion=item.findViewById(R.id.txtDescripcion);
        txtDescripcion.setText(noticias.get(position).getDescripcion());

        TextView txtPubDate=item.findViewById(R.id.txtPubDate);
        txtPubDate.setText(noticias.get(position).getPubDate());

        TextView txtCategoria=item.findViewById(R.id.txtCategoria);
        txtCategoria.setText(noticias.get(position).getCategory());

        return item;

    }
}
