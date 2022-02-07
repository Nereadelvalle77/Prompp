package com.example.examen2.BaseDeDatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examen2.R;

import java.util.ArrayList;

public class CrearCliente extends AppCompatActivity {

    private EditText edtDni;
    private EditText edtNombre;
    private EditText edtDireccion;
    private EditText edtTfno;

    private Button btGesion;

    private TextView txtCreando;

    private ClienteDao cd;

    private Cliente c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cliente);

        cd= new ClienteDao(this.getApplicationContext());

        edtDni=findViewById(R.id.edtDni);
        edtNombre=findViewById(R.id.edtNombre);
        edtDireccion=findViewById(R.id.edtDireccion);
        edtTfno=findViewById(R.id.edtTfno);
        txtCreando=findViewById(R.id.txtCreando);

        btGesion=findViewById(R.id.btGestion);

        Bundle extra=getIntent().getExtras();

        if(extra!=null)
        {
            c= (Cliente) extra.getSerializable("cliente");
            edtDni.setText(String.valueOf(c.getDni()));
            edtDni.setEnabled(false);

            edtNombre.setText(c.getNombre());
            edtNombre.setEnabled(false);

            edtDireccion.setText(c.getDireccion());
            edtTfno.setText(c.getTfno());

            txtCreando.setText(R.string.modificando);
            btGesion.setText(R.string.mdcl);
        }
    }

    public void crearCli(View v)
    {
        String dni=edtDni.getText().toString();
        String nombre=edtNombre.getText().toString();
        String direccion=edtDireccion.getText().toString();
        String tfno=edtTfno.getText().toString();

        if(dni.length()>0 && nombre.length()>0 && direccion.length()>0 && tfno.length()>0)
        {
            Cliente c=new Cliente(Integer.parseInt(dni),nombre,direccion,tfno, new ArrayList<Factura>());
            if(this.c==null)
            {
                cd.aniadirCliente(c);
            }
            else
            {
                cd.modificarCliente(c);
            }

            finish();

        }
        else
            Toast.makeText(this, "Todos los campos tienen que estar rellenados", Toast.LENGTH_SHORT).show();
    }
}