package PARSES;

import UML.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import master_esport.Master_ESport;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

public class clasificacionSax extends DefaultHandler {

    List myEq;
    private String tempVal;
    private Equipo tempEq;
    ArrayList <Equipo> equipos;
    
    public static String main() {
        clasificacionSax spe = new clasificacionSax();
        return spe.runExample();
    }
    
    
public clasificacionSax() {
        myEq = new <Equipo> ArrayList();
        tempEq = new Equipo();
    }
        
    public String runExample() {
        parseDocument();
        return printData();
    }
    
    private void parseDocument() {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser sp = spf.newSAXParser();
            sp.parse("../../LM/clasificacion.xml", this);
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tempVal = "";
        if (qName.equalsIgnoreCase("Equipo")) {
            tempEq = new Equipo();
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("Equipo")) {
            myEq.add(tempEq);
        } else if (qName.equalsIgnoreCase("datosEquipo")) {
        } else if (qName.equalsIgnoreCase("codigo")) {
            tempEq.setCodequipo(Integer.parseInt(tempVal));
        } else if (qName.equalsIgnoreCase("nombre")) {
            tempEq.setNombre(tempVal);
        } else if (qName.equalsIgnoreCase("resultado")) {
            tempEq.setPuntosClasificacion(Integer.parseInt(tempVal));
        }
    }
    
    private String printData() {
        String clasificaciones="";
        String clasificacionesHtml="<html><h1>";
        for (int i = 0; i < myEq.size(); i++) {
            Equipo equipo = (Equipo) myEq.get(i);
            clasificaciones = clasificaciones + equipo.toStringClasificacion() + "<br>";
        }
        clasificacionesHtml = clasificacionesHtml + clasificaciones + "</h1></html>";
        return clasificacionesHtml;
    }
}
