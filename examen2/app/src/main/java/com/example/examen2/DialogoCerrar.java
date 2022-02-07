package com.example.examen2;

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

    OnDialogoCerrarListener listener;

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
        builder.setMessage(R.string.ver_pronto)
                .setTitle(R.string.adios)
                .setPositiveButton("ACEPTAR",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i ("Dialogos", "Confirmación Aceptada");
                                listener.onPossitiveCerrar();
                            }
                        });
        return builder.create();
    }
    public interface OnDialogoCerrarListener {
        void onPossitiveCerrar();
        void onNegativeCerrar();
    }
}
