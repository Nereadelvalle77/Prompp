package com.example.fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDescripcion extends Fragment
{

    private TextView txtDescripcion;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        txtDescripcion=getView().findViewById(R.id.txtDescripcion);
        return inflater.inflate(R.layout.frg_descripcion, container,false);
    }

    public TextView getTxtDescripcion() {
        return txtDescripcion;
    }
}
