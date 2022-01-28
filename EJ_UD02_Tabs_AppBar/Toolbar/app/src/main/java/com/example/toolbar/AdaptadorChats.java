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
import java.util.List;

public class AdaptadorChats extends ArrayAdapter<Chat> {

    private ArrayList<Chat> chats;

    public AdaptadorChats(@NonNull Context context, @NonNull ArrayList<Chat> objects) {
        super(context, R.layout.listitem_chat, objects);
        this.chats= objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_chat, null);

        TextView txtContactC=item.findViewById(R.id.txtContactC);
        txtContactC.setText(chats.get(position).getContacto());

        TextView txtUltMsg=item.findViewById(R.id.txtUltMsg);
        txtUltMsg.setText(chats.get(position).getUltMsg());

        TextView txtNMsg=item.findViewById(R.id.txtNMsg);
        txtNMsg.setText(chats.get(position).getnMsg());

        return item;
    }
}
