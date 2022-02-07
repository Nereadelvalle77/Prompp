package com.example.examen2.BaseDeDatos;

import java.io.Serializable;

public class Factura implements Serializable
{

    private int num;
    private int dni;
    private String concepto;
    private float valor;

    public Factura(int num, int dni, String concepto, float valor) {
        this.num = num;
        this.dni = dni;
        this.concepto = concepto;
        this.valor = valor;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
