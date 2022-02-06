package com.example.ficheros3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdaptadorWeb extends ArrayAdapter<Web>
{

    private ArrayList<Web> datosWeb;

    public AdaptadorWeb(@NonNull Context context, ArrayList<Web> datosWeb)
    {
        super(context, R.layout.listitem_web,datosWeb);
        this.datosWeb=datosWeb;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {

        LayoutInflater inflater=LayoutInflater.from(getContext());
        View item= inflater.inflate(R.layout.listitem_web,null);

        TextView txtNombre=item.findViewById(R.id.txtNombre);
        txtNombre.setText(datosWeb.get(position).getNombre());

        TextView txtURL=item.findViewById(R.id.txtURL);
        txtURL.setText(datosWeb.get(position).getUrl());

        TextView txtID=item.findViewById(R.id.txtID);
        txtID.setText(datosWeb.get(position).getId());

        return item;

    }
}
