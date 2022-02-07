package com.example.examen2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class DialogoSeleccionCliente extends DialogFragment
{

    private Cliente c;
    private BBDD bbdd;
    private String accion;

    public DialogoSeleccionCliente(BBDD parent, String accion)
    {
        this.bbdd =parent;
        this.accion=accion;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Elige tu grupo");
        ClienteDao cd= new ClienteDao(getContext());
        ArrayList<Cliente> clientes=cd.verClientes();
        AdaptadorCliente ac= new AdaptadorCliente(getContext(),clientes);

        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(bbdd, "Tienes que elegir un cliente si quieres gestionarlo", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setAdapter(ac, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=null;
                Cliente cl= ac.getItem(which);
                switch (accion)
                {
                    case "modificar":
                        intent= new Intent(bbdd,CrearCliente.class);
                        intent.putExtra("cliente",  cl);
                        break;
                    case "crear":
                        intent= new Intent(bbdd,CrearFactura.class);
                        intent.putExtra("cliente",  cl);
                        break;
                    case "consultar":
                        intent= new Intent(bbdd,ConsultaFacturas.class);
                        int dni=cl.getDni();
                        String nombre=cl.getNombre();
                        intent.putExtra("dni",  dni);
                        intent.putExtra("nombre", nombre);
                        break;
                }
                startActivity(intent);

            }
        });

        Dialog dialog=builder.create();
        final ViewGroup content = (ViewGroup) dialog.findViewById(android.R.id.content);
        content.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                content.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                View inner = content.getChildAt(0);
                content.removeViewAt(0);
                ScrollView scrollView = new ScrollView(getContext());
                scrollView.addView(inner);
                content.addView(scrollView);
            }
        });

        return dialog;
    }
}
