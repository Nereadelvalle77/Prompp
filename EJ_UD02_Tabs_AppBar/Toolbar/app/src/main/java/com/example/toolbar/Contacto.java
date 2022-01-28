package com.example.toolbar;

public class Contacto {

    private String nombre;
    private String ap1;
    private String correo;

    public Contacto(String nombre, String ap1, String correo) {
        this.nombre = nombre;
        this.ap1 = ap1;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp1() {
        return ap1;
    }

    public void setAp1(String ap1) {
        this.ap1 = ap1;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
