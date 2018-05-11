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

public class ultimaJornadasSAX extends DefaultHandler {

    List myJor;
    private String tempVal;
    private Jornada tempJor;
    private Partido tempPart;
    ArrayList <Partido> partidos;
    
    public static String main() {
        ultimaJornadasSAX spe = new ultimaJornadasSAX();
        return spe.runExample();
    }
    
public ultimaJornadasSAX() {
        myJor = new <Jornada> ArrayList();
        partidos = new <Partido> ArrayList();
        tempPart = new Partido();
    }
        
    public String runExample() {
        parseDocument();
        return printData();
    }
    
    private void parseDocument() {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser sp = spf.newSAXParser();
            sp.parse("../../LM/ultimaJornada.xml", this);
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
        if (qName.equalsIgnoreCase("Jornada")) {
            tempJor = new Jornada();
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("Jornada")) {
            tempJor.setPartido(partidos);
            myJor.add(tempJor);
            partidos = new <Partido> ArrayList();
        } else if (qName.equalsIgnoreCase("datosJornada")) {
        } else if (qName.equalsIgnoreCase("codigo")) {
            tempJor.setCodJornada(Integer.parseInt(tempVal));
        } else if (qName.equalsIgnoreCase("fechaInicio")) {
            tempJor.setFechaInicio(cambiarFormato(tempVal));
        } else if (qName.equalsIgnoreCase("fechaFinal")) {
            tempJor.setFechaFin(cambiarFormato(tempVal));
        } else if (qName.equalsIgnoreCase("Partidos")) {
        } else if (qName.equalsIgnoreCase("partido")) {
        }else if (qName.equalsIgnoreCase("codigoP")) {
            tempPart = new Partido();
                tempPart.setCodpartido(Integer.parseInt(tempVal));
        } else if (qName.equalsIgnoreCase("fechaP")) {
                tempPart.setFecha(cambiarFormato(tempVal));
        } else if (qName.equalsIgnoreCase("nombreL")) {
                Equipo equipo = new Equipo();
                equipo.setNombre(tempVal);
                tempPart.setLocal(equipo);
        } else if (qName.equalsIgnoreCase("nombreV")) {
                Equipo equipo = new Equipo();
                equipo.setNombre(tempVal);
                tempPart.setVisitante(equipo);
        } else if (qName.equalsIgnoreCase("resultadoL")) {
                tempPart.setResultadoEL(Integer.parseInt(tempVal));
        } else if (qName.equalsIgnoreCase("resultadoV")) {
                tempPart.setResultadoEV(Integer.parseInt(tempVal));
                partidos.add(tempPart);
        }
    }
    
    private String printData() {

        String jornadaT="";
        for (int i = 0; i < myJor.size(); i++) {
            Jornada jornada = (Jornada) myJor.get(i);
            jornadaT = jornada + jornada.toString();
        }
        return jornadaT;
        
    }
    
        public java.sql.Date cambiarFormato(String fecha){
            String nuevaFecha ="";
            for (int i = 0; i < 4; i++) {
                nuevaFecha =nuevaFecha + fecha.charAt(i);
            }
            nuevaFecha = nuevaFecha + "/";
            for (int i = 5; i < 7; i++) {
                nuevaFecha =nuevaFecha + fecha.charAt(i);
            }
            nuevaFecha = nuevaFecha + "/";
            for (int i = 8; i < 10; i++) {
                nuevaFecha =nuevaFecha + fecha.charAt(i);
            }
            return Master_ESport.crearFecha(nuevaFecha);
    }

}
