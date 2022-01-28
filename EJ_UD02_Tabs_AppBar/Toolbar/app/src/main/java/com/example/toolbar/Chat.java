package com.example.toolbar;

public class Chat {

    private String contacto;
    private String ultMsg;
    private int nMsg;

    public Chat(String contacto, String ultMsg, int nMsg) {
        this.contacto = contacto;
        this.ultMsg = ultMsg;
        this.nMsg = nMsg;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getUltMsg() {
        return ultMsg;
    }

    public void setUltMsg(String ultMsg) {
        this.ultMsg = ultMsg;
    }

    public int getnMsg() {
        return nMsg;
    }

    public void setnMsg(int nMsg) {
        this.nMsg = nMsg;
    }
}
