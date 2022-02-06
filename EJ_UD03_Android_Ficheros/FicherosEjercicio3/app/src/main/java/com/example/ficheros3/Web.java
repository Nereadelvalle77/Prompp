package com.example.ficheros3;

public class Web
{

    private String nombre;
    private String url;
    private String logo;
    private String id;

    public Web(String nombre,String url,String logo,String id)
    {

        this.nombre=nombre;
        this.url=url;
        this.logo=logo;
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

    public String getLogo() {
        return logo;
    }

    public String getId()
    {
        return id;
    }

}
