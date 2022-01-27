package com.example.controlesseleccion;

public class Web
{

    private String nombre;
    private String url;
    private int img;
    private String id;

    public Web(String nombre,String url,int img,String id)
    {

        this.nombre=nombre;
        this.url=url;
        this.img=img;
        this.id=id;

    }

    public String getNombre()
    {
        return nombre;
    }

    public String getUrl()
    {
        return url;
    }

    public int getImg()
    {
        return img;
    }

    public String getId()
    {
        return id;
    }

}
