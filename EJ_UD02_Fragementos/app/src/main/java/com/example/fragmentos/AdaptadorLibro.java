package com.example.fragmentos;

import android.app.Activity;
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

public class AdaptadorLibro extends ArrayAdapter<Libro>
{

    private ArrayList<Libro> libros;
    private FragmentDescripcion frgDescripcion;

    public AdaptadorLibro(@NonNull Context context, @NonNull List<Libro> objects, FragmentDescripcion frgDescripcion) {
        super(context, R.layout.listitem_libro, objects);
        libros= (ArrayList<Libro>) objects;
        this.frgDescripcion=frgDescripcion;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_libro, null);

        TextView lblTitulo = (TextView) item.findViewById(R.id.txtTitulo);
        lblTitulo.setText(libros.get(position).getTitulo());

        TextView lblAutor = (TextView) item.findViewById(R.id.txtAutor);
        lblAutor.setText(libros.get(position).getAutor());

        return (item);
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }
}
