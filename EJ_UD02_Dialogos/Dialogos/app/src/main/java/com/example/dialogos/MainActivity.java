package com.example.dialogos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogoIdentificacion.OnDialogoConfirmacionListener, DialogoCerrar.OnDialogoCerrarListener
{

    private TextView txtHola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FragmentManager fragmentManager= getSupportFragmentManager();
        DialogoIdentificacion di=new DialogoIdentificacion();
        di.show(getFragmentManager(),"aaa");

        txtHola=findViewById(R.id.txtHola);

    }

    public void cerrarApp(View v)
    {
        DialogoCerrar dc= new DialogoCerrar();
        dc.show(getSupportFragmentManager(),"aa");
    }

    @Override
    public void onPossitiveButtonClick(String usuario) {
        this.txtHola.setText("Hola "+usuario);
    }

    @Override
    public void onNegativeButtonClick() {

    }

    @Override
    public void onPossitiveCerrar() {
        finish();
    }

    @Override
    public void onNegativeCerrar() {
        Toast.makeText(getApplicationContext(),"Pues ok",Toast.LENGTH_LONG).show();
    }
}