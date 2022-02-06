package com.example.notificaciones;

public class GestorOperaciones
{

    private int n1;
    private int n2;
    private int rRecibido;
    private int rCorrecto;

    private String operacion;

    public GestorOperaciones(int n1, int n2, int rRecibido, String operacion)
    {
        this.n1=n1;
        this.n2=n2;
        this.rRecibido=rRecibido;
        this.operacion=operacion;

        calcularRCorrecto();

    }

    private void calcularRCorrecto()
    {
        switch (operacion)
        {
            case "+":
                this.rCorrecto=n1+n2;
                break;
            case "-":
                this.rCorrecto=n1-n2;
                break;
            case "/":
                if(n2!=0)
                    this.rCorrecto=n1/n2;
                break;
            case "*":
                this.rCorrecto=n1*n2;
                break;
        }
    }

    public boolean esCorrecto()
    {
        if(this.rCorrecto==this.rRecibido)
            return true;
        return false;
    }

}
