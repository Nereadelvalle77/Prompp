package com.example.toolbar;

import java.util.Date;

public class Llamada {

    private String contacto;
    private Date momento;

    public Llamada(String contacto, Date momento) {
        this.contacto = contacto;
        this.momento = momento;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }
}
