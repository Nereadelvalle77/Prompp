package com.example.ejercicio1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class RssHandler extends DefaultHandler
{

    private Noticia noticiaActual;
    private List<Noticia> noticias;
    private StringBuilder sbTexto;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();

        noticias=new ArrayList<Noticia>();
        sbTexto=new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        //Si estoy en la etiqueta item inicializo la noticia
        if(localName.equals("item"))
        {
            noticiaActual= new Noticia();
        }
    }

    //ir acumulando en una variable
    //auxiliar, sbTexto, todos los fragmentos de texto que encontremos
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);

        if(this.noticiaActual!=null)
            sbTexto.append(ch,start,length);
    }

    //cuanda acaba la etiqueta si es la que nos interesa le mete el texto
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);

        if(this.noticiaActual!=null)
        {
            if(localName.equals("title"))
                noticiaActual.setTitulo(sbTexto.toString());
            else if (localName.equals("link")){
                noticiaActual.setLink(sbTexto.toString());
            } else if (localName.equals("description")){
                noticiaActual.setDescripcion(sbTexto.toString());
            } else if (localName.equals("guid")){
                noticiaActual.setGuid(sbTexto.toString());
            } else if (localName.equals("pubDate")){
                noticiaActual.setPubDate(sbTexto.toString());
            } else if (localName.equals("item")){
                noticias.add(noticiaActual);
            }

            //Limpia
            sbTexto.setLength(0);
        }
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

}
