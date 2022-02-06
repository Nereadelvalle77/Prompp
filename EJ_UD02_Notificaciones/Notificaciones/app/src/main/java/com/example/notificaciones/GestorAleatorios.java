package com.example.notificaciones;

import java.util.Random;
import java.util.stream.IntStream;

public class GestorAleatorios
{

    private int[] n;
    private String[] o;

    public GestorAleatorios()
    {
        n= IntStream.range(1, 11).toArray();
        o= new String[]{"+", "-", "*", "/"};
    }

    public int devolverN1()
    {
        int p= new Random().nextInt(n.length);
        return n[p];
    }

    public int devolverN2()
    {
        int p= new Random().nextInt(n.length);
        return n[p];
    }

    public String devolverOperacion()
    {
        int p= new Random().nextInt(o.length);
        return o[p];
    }

}
