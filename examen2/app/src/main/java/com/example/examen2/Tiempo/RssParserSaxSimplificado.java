package com.example.examen2.Tiempo;

import android.sax.Element;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.util.Xml;

import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class RssParserSaxSimplificado extends DefaultHandler
{

    private URL rssUrl;

    public RssParserSaxSimplificado(String url)
    {

        try {
            this.rssUrl = new URL (url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    public Tiempo parse()
    {
        Tiempo tiempo= new Tiempo();

        RootElement root= new RootElement("data");
        Element dia=root.getChild("day1");
        Element fecha=dia.getChild("date");

        fecha.setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String s) {
                tiempo.setFecha(s);
            }
        });

        Element maxima=dia.getChild("temperature_max");
        maxima.setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String s) {
                tiempo.setMaxima(s);
            }
        });

        Element minima=dia.getChild("temperature_min");
        minima.setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String s) {
                tiempo.setMinima(s);
            }
        });

        Element hora=root.getChild("hour_hour").getChild("hour1");

        Element h=hora.getChild("hour_data");
        h.setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String s) {
                tiempo.setHora(s);
            }
        });

        Element temperatura=hora.getChild("temperature");
        temperatura.setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String s) {
                tiempo.setTemperatura(s);
            }
        });

        Element text=hora.getChild("text");
        text.setEndTextElementListener(new EndTextElementListener() {
            @Override
            public void end(String s) {
                tiempo.setText(s);
            }
        });


        try {
            Xml.parse(this.getInputStream(),
                    Xml.Encoding.ISO_8859_1,
                    root.getContentHandler());
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return tiempo;
    }

    private InputStream getInputStream() {
        try {
            return rssUrl.openConnection().getInputStream();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
