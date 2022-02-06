package com.example.ficherosejercicio1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity
{

    private EditText txtContenido;
    private TextView lblInfo;

    private final int SOLICITUD_PERMISO_ESCRIBIR_SD = 0;
    private final int SOLICITUD_PERMISO_LEER_SD = 1;

    private final String ARCHIVO_INTERNO = "archivoInterno.txt";
    private final String ARCHIVO_EXTERNO = "archivoExterno.txt";

    private boolean sdDisponible = false;
    private boolean sdAccesoEscritura = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtContenido = findViewById(R.id.txtContenido);
        lblInfo = findViewById(R.id.lblInfo);

    }

    private void comprobarSD() {
        String estado = Environment.getExternalStorageState();

        if (estado.equals(Environment.MEDIA_MOUNTED)) {
            sdDisponible = true;
            sdAccesoEscritura = true;
        }
        //Solo lectura
        else if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            sdDisponible = true;
            sdAccesoEscritura = false;
        }
        else {
            sdDisponible = false;
            sdAccesoEscritura = false;
        }
    }

    private void leerSD() {
        try {

            //Carpeta en la que va a leer
            ContextWrapper cw = new ContextWrapper(getApplicationContext());
            File ruta_sd = cw.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(ruta_sd.getAbsolutePath(), ARCHIVO_EXTERNO))));

            //lee
            StringBuilder txtResult = new StringBuilder();
            String linea = br.readLine();
            while(linea != null) {
                txtResult.append(linea);
                linea = br.readLine();
            }
            br.close();

            lblInfo.setText(txtResult.toString());
        }
        catch (Exception e) {
            lblInfo.setText("");
            Log.e ("MainActivity", "Error al leer fichero en tarjeta SD");
        }
    }

    private void escribirSD() {
        try {
            //Carpeta en la que va a escribir
            ContextWrapper cw = new ContextWrapper(getApplicationContext());
            File ruta_sd = cw.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);

            //Crea si no existe y escribe
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File(ruta_sd.getAbsolutePath(), ARCHIVO_EXTERNO)));

            osw.write(txtContenido.getText().toString());
            osw.close();
        }
        catch (Exception e) {
            Log.e ("MainActivity", "Error al escribir fichero en tarjeta SD");
        }
    }

    public void escribirInterno(View view) {
        try {
            //Fi8chero en el que va a escribir
            FileOutputStream fos = openFileOutput(ARCHIVO_INTERNO, Context.MODE_APPEND);
            OutputStreamWriter osw = new OutputStreamWriter(fos);

            //Escribe
            osw.write(txtContenido.getText().toString() + "\n");
            osw.close();
        }
        catch (Exception e) {
            Log.e ("MainActivity", "Error al escribir fichero en memoria interna");
        }
    }

    public void escribirExterno(View view) {
        comprobarSD();
        //si tiene espacio y permiso de escirtura
        if(sdDisponible || sdAccesoEscritura) {
            //si tiene los permisos
            if (ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
                escribirSD();
            else
                //pide permisos
                solicitarPermiso
                        (
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                "Se necesita acceder a la memoria externa para escribir archivos en ella.",
                                SOLICITUD_PERMISO_ESCRIBIR_SD,
                                this
                        );
        }
        else {
            Log.e ("MainActivity", "Error al escribir fichero en memoria externa");
        }
    }

    public void leerInterno(View view) {
        try {
            FileInputStream fis = openFileInput(ARCHIVO_INTERNO);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            StringBuilder txtResult = new StringBuilder();
            String linea = br.readLine();
            while(linea != null) {
                txtResult.append(linea);
                linea = br.readLine();
            }
            br.close();

            lblInfo.setText(txtResult.toString());
        }
        catch (Exception e) {
            lblInfo.setText("");
            Log.e("MainActivity", "Error al leer fichero desde memoria interna");
        }
    }

    public void leerExterno(View view) {
        comprobarSD();
        if(sdDisponible || sdAccesoEscritura) {
            if (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
                leerSD();
            else
                solicitarPermiso
                        (
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                "Se necesita acceder a la SD para leer archivos en ella.",
                                SOLICITUD_PERMISO_LEER_SD,
                                this
                        );
        }
        else {
            lblInfo.setText("");
            Log.e ("MainActivity", "Error al leer fichero en memoria externa");
        }
    }

    //Lee de recursos solo tienen permiso de lectura
    public void leerRecurso(View view) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.datos)));

            StringBuilder txtResult = new StringBuilder();
            String linea = br.readLine();
            while (linea != null) {
                txtResult.append(linea);
                linea = br.readLine();
            }
            br.close();

            lblInfo.setText(txtResult.toString());
        }
        catch (Exception e) {
            lblInfo.setText("");
            Log.e ("MainActivity", "Error al leer recurso");
        }

    }

    public void borrarInterno(View view) {
        deleteFile(ARCHIVO_INTERNO);
    }

    public void borrarExterno(View view) {
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        File ruta_sd = cw.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File f = new File (ruta_sd.getAbsolutePath(), ARCHIVO_EXTERNO);

        if(f.exists())
            if(f.delete()) {
                Toast.makeText(this, "Fichero externo borrado", Toast.LENGTH_LONG).show();
            }
    }


    //Pedir permisos
    private static void solicitarPermiso (final String permiso,
                                          String justificacion,
                                          final int requestCode,
                                          final Activity actividad) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                actividad, permiso)) {
            //Informamos al usuario para qué y por qué
            //se necesitan los permisos
            new AlertDialog.Builder(actividad)
                    .setTitle("Solicitud de permiso")
                    .setMessage(justificacion)
                    .setPositiveButton("OK",
                            (dialog, which) -> ActivityCompat.requestPermissions(actividad,
                                    new String[]{permiso}, requestCode)).show();
        } else {
            //Muestra el cuadro de dialogo para la solicitud de permisos y
            //registra el permiso según respuesta del usuario
            ActivityCompat.requestPermissions(actividad,
                    new String[]{permiso}, requestCode);
        }
    }

    //Gestiona permisos
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == SOLICITUD_PERMISO_ESCRIBIR_SD) {
            if (grantResults.length >= 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                escribirSD();
            else
                Toast.makeText(this, "No se puede ESCRIBIR en memoria SD", Toast.LENGTH_LONG).show();
        } else if (requestCode == SOLICITUD_PERMISO_LEER_SD) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                leerSD();
            else
                Toast.makeText(this, "No se puede LEER de memoria SD", Toast.LENGTH_LONG).show();
        }
    }

}