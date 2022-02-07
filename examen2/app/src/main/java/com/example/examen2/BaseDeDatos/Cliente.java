package com.example.examen2.BaseDeDatos;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable
{

    private int dni;
    private String nombre;
    private String direccion;
    private String tfno;
    private ArrayList<Factura> facturas;

    public Cliente(int dni, String nombre, String direccion, String tfno, ArrayList<Factura> facturas)
    {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tfno = tfno;
        this.facturas=facturas;
    }

    public Cliente(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public Cliente(int dni) {
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTfno() {
        return tfno;
    }

    public void setTfno(String tfno) {
        this.tfno = tfno;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }
}
