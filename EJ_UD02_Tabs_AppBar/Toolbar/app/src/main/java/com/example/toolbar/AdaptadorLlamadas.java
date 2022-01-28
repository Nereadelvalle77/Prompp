package com.example.toolbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdaptadorLlamadas extends ArrayAdapter<Llamada>
{

    private ArrayList<Llamada> llamadas;

    public AdaptadorLlamadas(@NonNull Context context, @NonNull ArrayList<Llamada> objects) {
        super(context, R.layout.listitem_llamada, objects);
        this.llamadas= objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_chat, null);

        TextView txtContactL=item.findViewById(R.id.txtContactL);
        txtContactL.setText(llamadas.get(position).getContacto());

        TextView txtMomento=item.findViewById(R.id.txtMomento);
        txtMomento.setText(llamadas.get(position).getMomento().toString());

        return item;
    }

}
