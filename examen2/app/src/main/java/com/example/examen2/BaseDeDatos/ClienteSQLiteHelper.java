package com.example.examen2.BaseDeDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ClienteSQLiteHelper extends SQLiteOpenHelper
{

    private String sqlCreateCliente="CREATE TABLE Cliente (dni INTEGER, nombre TEXT, direccion TEXT ,tfno TEXT, PRIMARY KEY(dni))";
    private String sqlCreateFacturas="CREATE TABLE Facturas (num INTEGER,dni INTEGER,concepto TEXT,valor REAL,PRIMARY KEY(num), FOREIGN KEY(dni) REFERENCES Cliente(dni))";

    public ClienteSQLiteHelper(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(this.sqlCreateCliente);
        db.execSQL(this.sqlCreateFacturas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("drop table if exists Cliente");
        db.execSQL("drop table if exists Facturas");
        db.execSQL(this.sqlCreateCliente);
        db.execSQL(this.sqlCreateFacturas);
    }

}
