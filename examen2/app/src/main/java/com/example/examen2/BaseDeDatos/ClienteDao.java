package com.example.examen2.BaseDeDatos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ClienteDao
{

    private SQLiteDatabase db;

    public ClienteDao(Context contexto)
    {
        db= new ClienteSQLiteHelper(contexto, "Cliente", null, 1).getWritableDatabase();
    }

    public ArrayList<Cliente> verClientes()
    {
        ArrayList<Cliente> clientes= new ArrayList<Cliente>();

        Cursor c= db.rawQuery("select dni, nombre,direccion,tfno from Cliente", null);

        if(c.moveToFirst())
        {
            do
            {
                int dni=c.getInt(0);
                String nombre= c.getString(1);
                String direccion= c.getString(2);
                String tfno= c.getString(3);

                ArrayList<Factura> facturas=verFacturas(dni);

                Cliente cl= new Cliente(dni,nombre,direccion,tfno,facturas);
                clientes.add(cl);


            }while(c.moveToNext());
        }

        return clientes;
    }

    public ArrayList<Factura> verFacturas(int dni)
    {
        ArrayList<Factura> facturas= new ArrayList<Factura>();

        Cursor c= db.rawQuery("select num, concepto, valor from Facturas where dni="+String.valueOf(dni),null);

        if(c.moveToFirst())
        {
            do
            {
                int num=c.getInt(0);
                String concepto= c.getString(1);
                float valor=c.getFloat(2);
                Factura f= new Factura(num,dni,concepto,valor);
                facturas.add(f);

            }while(c.moveToNext());
        }

        return facturas;
    }

    public Cliente verCliente(Cliente cliente)
    {

        Cliente cl= null;
        Cursor c= db.rawQuery("select dni, nombre,direccion,tfno from Cliente where dni="+cliente.getDni(), null);

        if(c.moveToFirst())
        {
            int dni=c.getInt(0);
            String nombre= c.getString(1);
            String direccion= c.getString(2);
            String tfno= c.getString(3);

            ArrayList<Factura> facturas=verFacturas(dni);

            cl= new Cliente(dni,nombre,direccion,tfno,facturas);
        }

        return cl;

    }

    public void aniadirCliente(Cliente cliente)
    {
        if(verCliente(cliente)==null)
            db.execSQL("insert into Cliente (dni,nombre,direccion,tfno) values("+cliente.getDni()+",'"+cliente.getNombre()+"','"+cliente.getDireccion()+"','"+cliente.getTfno()+"')");

    }

    public void aniadirFactura(Factura f)
    {
        Cliente cl=new Cliente(f.getDni());
        if(verCliente(cl)!=null)
        {
            db.execSQL("insert into Facturas (num,dni,concepto,valor) values("+f.getNum()+",'"+f.getDni()+"','"+f.getConcepto()+"','"+f.getValor()+"')");
        }
    }

    public void modificarCliente(Cliente cliente)
    {
        db.execSQL("update Cliente set tfno='"+cliente.getTfno()+"', direccion='"+cliente.getDireccion()+"' where dni="+cliente.getDni());
    }

}
