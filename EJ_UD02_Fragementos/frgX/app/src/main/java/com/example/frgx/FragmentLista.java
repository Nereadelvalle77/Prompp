package com.example.frgx;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentLista extends Fragment
{

    private ListView lstLibros;
    private AdaptadorLibro al;
    private ArrayList<Libro> libros;

    private FragmentDescripcion frgDescripcion;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.frg_lista, container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        lstLibros=(ListView) getView().findViewById(R.id.lstLibros);
        cargarLibros(((MainActivity)getActivity()).getFrgDescripcion());

        generarEventos();
    }

    private void generarEventos()
    {
        lstLibros.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Libro libro=al.getLibros().get(position);
                if(frgDescripcion==null)
                {
                    Intent intent=new Intent(getActivity(), Descripcion.class);
                    intent.putExtra("descripcion",libro.getDescripcion());
                    startActivity(intent);
                }
                else
                {
                    frgDescripcion.getTxtDescripcion().setText(libro.getDescripcion());
                }
            }
        });
    }

    private void cargarLibros(FragmentDescripcion frgDescripcion)
    {

        libros = new ArrayList<Libro>();
        libros.add(new Libro("Dormir en un mar de estrellas", "Paolini","El espacio alberga incontables secretos. Y Kira Navárez ha encontrado el más letal.Ella siempre ha soñado con encontrar vida en otros planetas. Pero nunca pensó que enfrentaría a un enemigo que pondrá en riesgo a toda la humanidad."));
        libros.add(new Libro("La historia interminable","Michael Ende","La Emperatriz Infantil está mortalmente enferma y su reino, Fantasia, corre un grave peligro. La salvación depende de Atreyu, un valiente guerrero de la tribu de los pieles verdes, y Bastian, un niño tímido que lee con pasión un libro mágico. Solo un ser humano puede salvar este lugar encantado."));
        libros.add(new Libro("Asesino de brujas","Shelby Mahurin","Dos años atrás, Louise le Blanc huyó de su aquelarre y se refugió en la ciudad de Cesarine, donde renunció a la magia para vivir de lo que pudiera robar. ... Asesino de brujas: la bruja blanca se desarrolla en un mundo de mujeres empoderadas, magia oscura y donde los romances son fuera de serie.\n"));

        al=new AdaptadorLibro(getContext(),libros,frgDescripcion);
        lstLibros.setAdapter(al);
        this.frgDescripcion=frgDescripcion;
    }
}
