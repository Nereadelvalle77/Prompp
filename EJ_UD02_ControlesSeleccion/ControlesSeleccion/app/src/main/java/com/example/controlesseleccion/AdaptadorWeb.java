package com.example.controlesseleccion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdaptadorWeb extends ArrayAdapter<Web>
{

    private Web[] datosWeb;

    public AdaptadorWeb(@NonNull Context context, Web[] datosWeb)
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

        ImageView img=item.findViewById(R.id.img);
        img.setImageResource(datosWeb[position].getImg());

        TextView txtNombre=item.findViewById(R.id.txtNombre);
        txtNombre.setText(datosWeb[position].getNombre());

        TextView txtURL=item.findViewById(R.id.txtURL);
        txtURL.setText(datosWeb[position].getUrl());

        TextView txtID=item.findViewById(R.id.txtID);
        txtID.setText(datosWeb[position].getId());

        return item;

    }
}
