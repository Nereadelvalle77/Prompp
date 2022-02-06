package com.example.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class DialogoIdentificacion extends DialogFragment
{

    private OnDialogoConfirmacionListener listener;

    private View v;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v= inflater.inflate(R.layout.dialogo_identificacion, null);
        builder.setView(inflater.inflate(R.layout.dialogo_identificacion, null))
                .setTitle("Identificate mortal")
                .setPositiveButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                recogerDatos(dialog);
                            }
                        });

        return builder.create();
    }

    private void recogerDatos(DialogInterface dialog) {

        Dialog dialogObj =Dialog.class.cast(dialog);

        EditText etUsr=(EditText) dialogObj.findViewById(R.id.edtUsuario);
        String usu = etUsr.getText().toString();

        EditText etCtr=(EditText) dialogObj.findViewById(R.id.edtContrasenia);
        String contra = etCtr.getText().toString();

        if(usu.equals("usuario1") && contra.equals("12345678"))
        {
            listener.onPossitiveButtonClick(usu);
            dialog.dismiss();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            listener = (OnDialogoConfirmacionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    " no Implemento OnDialogoConfirmacionListener");
        }
    }

    public interface OnDialogoConfirmacionListener{
        void onPossitiveButtonClick(String usuario); //Eventos Botón Positivos
        void onNegativeButtonClick(); //Eventos Botón Negativo
    }
}
