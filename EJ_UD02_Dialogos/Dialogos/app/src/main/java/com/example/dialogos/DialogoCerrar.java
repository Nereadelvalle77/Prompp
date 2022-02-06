package com.example.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoCerrar extends DialogFragment {

    //Interfaz de comunicación
    DialogoCerrar.OnDialogoCerrarListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener= (OnDialogoCerrarListener)context;
        }catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "no Implemento OnDialogoConfirmacionListener");
        }
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Se borraran todos los datos")
                .setTitle("¿Estas seguro de cerrar la aplicacion?")
                .setPositiveButton("ACEPTAR",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i ("Dialogos", "Confirmación Aceptada");
                                listener.onPossitiveCerrar();
                            }
                        })
                .setNegativeButton("CANCELAR",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i("Dialogos", "Confirmación denegada");
                                listener.onNegativeCerrar();
                            }
                        });
        return builder.create();
    }
    public interface OnDialogoCerrarListener {
        void onPossitiveCerrar();
        void onNegativeCerrar();
    }
}
