package com.example.toolbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Date;

public class Llamadas extends Fragment
{

    private ListView lstLlamadas;
    private ArrayList<Llamada> llamadas;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        lstLlamadas=getView().findViewById(R.id.lstLlamadas);

        llamadas=new ArrayList<Llamada>();

        Llamada l= new Llamada("Marizza",new Date());
        llamadas.add(l);

        l= new Llamada("Diego",new Date());
        llamadas.add(l);

        lstLlamadas.setAdapter(new AdaptadorLlamadas(this.getContext(),llamadas));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.p_llamadas, container, false);
   }

}
