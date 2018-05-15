package PARSES;

import UML.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import UML_DB.*;
import javax.xml.transform.OutputKeys;


public class clasificacionParse {

    public static void main(String[] args) {
        String nombre_archivo = "calsificacion";
        //LLAMAR A FUNCION QUE CREA EL FICHERO PASANDOLE EL ARRAYLIST
        try { 
            generate(PartidoDB.clasificacionEquipos(), nombre_archivo);
        } catch (Exception e) {System.out.println(e.getMessage());}
    }

    public static void generate(ArrayList ListaEquipos, String name) throws Exception{
            //CREAR FICHERO XML VERSION 1.0
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, name, null);
            document.setXmlVersion("1.0");
            Transformer tFormer = TransformerFactory.newInstance().newTransformer();
          //  Set system id
            tFormer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "systmId");


            
            
            
            
            //NODO RAIZ
            Element raiz = document.getDocumentElement();
            //REPETITIVA PARA LAS NUMEROSOS EQUIPOS
            for(int i=0; i<ListaEquipos.size();i++){
                Equipo equipo = (Equipo) ListaEquipos.get(i);
                Element Equipo = document.createElement("Equipo"); 
                equipo.setNombre(EquipoDB.consultarEquipoCod(equipo.getCodequipo()).getNombre());
                //ELEMENTOS
                Element datosEquipo = document.createElement("datosEquipo"); 
                Element codigoNode = document.createElement("codigo");
                Text codigoValue = document.createTextNode(String.valueOf(equipo.getCodequipo()));
                codigoNode.appendChild(codigoValue);      

                Element nombreNode = document.createElement("nombre");
                Text nombreValue = document.createTextNode(equipo.getNombre());
                nombreNode.appendChild(nombreValue);
                
                Element resultadoNode = document.createElement("resultado");
                Text resultadoValue = document.createTextNode(String.valueOf(equipo.getPuntosClasificacion()));
                resultadoNode.appendChild(resultadoValue);

                        //ASIGNAR ESTRUCTURA
                Equipo.appendChild(datosEquipo);
                Equipo.appendChild(resultadoNode);
                datosEquipo.appendChild(codigoNode);
                datosEquipo.appendChild(nombreNode);
            
                //ASIGNAR RAMAS A RAIZ
                raiz.appendChild(Equipo); //pegamos el elemento a la raiz "Documento"
            }
                            
            //GENERAR XML
            
            
            
            Source source = new DOMSource(document);
            //Indicamos donde lo queremos almacenar
            name = "clasificacion";
            Result result = new StreamResult(new java.io.File("../../LM/"+name+".xml")); //nombre del archivo
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        
    }
}

