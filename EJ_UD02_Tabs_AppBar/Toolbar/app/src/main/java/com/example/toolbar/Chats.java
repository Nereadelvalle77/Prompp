package com.example.toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Chats extends Fragment
{


    private ListView lstChats;
    private ArrayList<Chat> chats;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        lstChats=(ListView) getView().findViewById(R.id.lstChats);

        chats=new ArrayList<Chat>();

        Chat c=new Chat("Manu","Ey, quedamos?",2);
        chats.add(c);
        c=new Chat("Luna","LOL",7);
        chats.add(c);
        c=new Chat("Mia","Que duro es",15);
        chats.add(c);

        lstChats.setAdapter(new AdaptadorChats(getContext(),chats));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.p_chats, container, false);
    }
}
