package com.example.ejercicio2;

import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.sax.StartElementListener;
import android.sax.TextElementListener;
import android.util.Xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RssParserSAXSimplificado extends DefaultHandler
{

    private Tiempo tiempoActual;
    private URL rssUrl;

    public RssParserSAXSimplificado(String url) {
        try {
            this.rssUrl = new URL (url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Tiempo> parse()
    {
        ArrayList<Tiempo> tiempos= new ArrayList<Tiempo>();

        RootElement root= new RootElement("root");
        Element prediccion= root.getChild("prediccion");
        Element dia=prediccion.getChild("dia");

        dia.setStartElementListener(new StartElementListener() {
            @Override
            public void start(Attributes attributes) {
                tiempoActual = new Tiempo();
                tiempoActual.setDia(attributes.getValue("fecha"));
            }
        });

        dia.setEndElementListener(new EndElementListener() {
            @Override
            public void end() {
                tiempos.add(tiempoActual);
            }
        });

        Element temperatura=dia.getChild("temperatura");
        temperatura.getChild("maxima").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                tiempoActual.setMaxima(body);
            }
        });

        temperatura.getChild("minima").setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String body) {
                tiempoActual.setMinima(body);
            }
        });

        try {
            Xml.parse(this.getInputStream(),
                    Xml.Encoding.ISO_8859_1,
                    root.getContentHandler());
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return tiempos;
    }

    private InputStream getInputStream() {
        try {
            return rssUrl.openConnection().getInputStream();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
