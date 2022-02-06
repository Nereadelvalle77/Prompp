package com.example.notificaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtN1;
    private TextView txtN2;
    private EditText edtResultado;

    private TextView txtOperacion;
    private TextView txtAciertos;

    private int aciertos;
    private GestorAleatorios ga;

    //NOTIFICACION
    private NotificationManager notificationManager;
    static final String CANAL_ID ="mi_canal";
    static final int NOTIFICACION_ID =1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtN1=findViewById(R.id.txtN1);
        txtN2=findViewById(R.id.txtN2);
        edtResultado=findViewById(R.id.edtResultado);

        txtOperacion=findViewById(R.id.txtOperacion);
        txtAciertos=findViewById(R.id.txtAciertos);

        aciertos=0;

        ga = new GestorAleatorios();
        cambiarCampos();
    }

    private void cambiarCampos()
    {
        txtN1.setText(String.valueOf(ga.devolverN1()));
        txtN2.setText(String.valueOf(ga.devolverN2()));
        txtOperacion.setText(ga.devolverOperacion());
    }

    public void comprobarResultado(View v)
    {
        //Deberian gestionarse el caso en el que no se introduzca nada
        int n1=Integer.parseInt(txtN1.getText().toString());
        int n2=Integer.parseInt(txtN2.getText().toString());
        int rRecibido=Integer.parseInt(edtResultado.getText().toString());
        String operacion=txtOperacion.getText().toString();

        GestorOperaciones go=new GestorOperaciones(n1,n2,rRecibido,operacion);
        if(go.esCorrecto())
        {
            aciertos++;
            txtAciertos.setText(aciertos+"  intentos acertados");
        }

        cambiarCampos();
        edtResultado.setText("");
        gestionarNotificacion();
    }

    private void gestionarNotificacion()
    {
        if(aciertos>=10)
        {
            //Creamos notificacion
            notificationManager = (NotificationManager) getSystemService(
                    NOTIFICATION_SERVICE);
            //Creamos el canal. SOLO puede hacerse en dispositivos con ver. 8 o más.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel notificationChannel = new NotificationChannel(
                        CANAL_ID, "Mis notificaciones",
                        NotificationManager.IMPORTANCE_DEFAULT);
                notificationChannel.setDescription("Descripción del canal");
                notificationManager.createNotificationChannel(notificationChannel);
            }
            NotificationCompat.Builder notificacion =
                    new NotificationCompat.Builder(MainActivity.this,CANAL_ID)
                            .setSmallIcon(R.drawable.ic_launcher_foreground)
                            .setContentTitle("10 ACIERTOS!!!")
                            .setContentText("Felicidades pelele");
            notificationManager.notify(NOTIFICACION_ID, notificacion.build());
        }
    }

}