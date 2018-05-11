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


public class todasJornadasParse {

    public static void main(String[] args) throws Exception {
        String nombre_archivo = "TodasJornadas";
        
        //CREAR ARRAYLIST PARA DATOS
        ArrayList datosJornada = new ArrayList();
            ArrayList codigo = new ArrayList();
            ArrayList fechaI = new ArrayList();
            ArrayList fechaF = new ArrayList();
            
        ArrayList partidos = new ArrayList();
            ArrayList partido= new ArrayList();
                ArrayList jugado = new ArrayList();
                ArrayList codigoP = new ArrayList();
                ArrayList fechaP = new ArrayList();
                ArrayList nombreL = new ArrayList();
                ArrayList nombreV = new ArrayList();
                ArrayList resultadoL = new ArrayList();
                ArrayList resultadoV = new ArrayList();
                ArrayList ListaJornadas = JornadaDB.listaJornada();
        
                //REPETITIVAS PARA RELLENAR LOS ARRAYLIST CON DATOS DE LA BD
        for (int j = 0; j < ListaJornadas.size(); j++) {
            Jornada jornadaObj = (Jornada) ListaJornadas.get(j);
            codigo.add(jornadaObj.getCodJornada());
            fechaI.add(jornadaObj.getFechaInicio().toString());
            fechaF.add(jornadaObj.getFechaFin().toString());
            for (int i = 0; i < jornadaObj.getPartido().size(); i++) {
                Partido partidoObj = (Partido) jornadaObj.getPartido().get(i);
                codigoP.add(partidoObj.getCodpartido());
                jugado.add(String.valueOf(partidoObj.isJugado()));
                fechaP.add(partidoObj.getFecha().toString());
                nombreL.add(partidoObj.getLocal().getNombre());
                nombreV.add(partidoObj.getVisitante().getNombre());
                resultadoL.add(String.valueOf(partidoObj.getResultadoEL()));
                resultadoV.add(String.valueOf(partidoObj.getResultadoEV()));
            }
        }
        //LLAMAR A FUNCION QUE CREA EL FICHERO PASANDOLE LOS ARRAYLIST
        try { 
            generate(ListaJornadas, nombre_archivo);
        } catch (Exception e) {System.out.println(e.getMessage());}
    }

    public static void generate(ArrayList ListaJornadas, String name) throws Exception{
            //CREAR FICHERO XML VERSION 1.0
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, name, null);
            document.setXmlVersion("1.0");
            
            
            
            //NODO RAIZ
            Element raiz = document.getDocumentElement();
            //REPETITIVA PARA LAS NUMEROSAS JORNADAS
            for(int i=0; i<ListaJornadas.size();i++){
                Jornada jornada = (Jornada) ListaJornadas.get(i);
                Element Jornada = document.createElement("Jornada"); 
                //ELEMENTOS
                Element datosJornada = document.createElement("datosJornada"); 
                Element codigoNode = document.createElement("codigo");
                Text codigoValue = document.createTextNode(String.valueOf(jornada.getCodJornada()));
                codigoNode.appendChild(codigoValue);      

                Element fechaINode = document.createElement("fechaInicio");
                Text fechaIValue = document.createTextNode(jornada.getFechaInicio().toString());
                fechaINode.appendChild(fechaIValue);
                
                Element fechaFNode = document.createElement("fechaFinal");
                Text fechaFValue = document.createTextNode(jornada.getFechaFin().toString());
                fechaFNode.appendChild(fechaFValue);
                
                Element partidos = document.createElement("partidos"); 
                //REPETITIVA CON LOS NUMEROSOS PARTIDOS DENTRO DE CADA JORNADA
                    for(int j=0; j<jornada.getPartido().size();j++){
                        Partido partidoObj = jornada.getPartido().get(j);
                        
                        Element partido  = document.createElement("partido"); 
                        partido.setAttribute("jugado", String.valueOf(partidoObj.isJugado()));
                        Element codigoPNode = document.createElement("codigoP"); 
                        Text codigoPValue = document.createTextNode(String.valueOf(partidoObj.getCodpartido()));
                        codigoPNode.appendChild(codigoPValue);

                        Element fechaPNode = document.createElement("fechaP"); 
                        Text fechaPValue = document.createTextNode(partidoObj.getFecha().toString());                
                        fechaPNode.appendChild(fechaPValue);

                        Element nombreLNode = document.createElement("nombreL"); 
                        Text nombreLValue = document.createTextNode(partidoObj.getLocal().getNombre());                
                        nombreLNode.appendChild(nombreLValue);

                        Element nombreVNode = document.createElement("nombreV"); 
                        Text nombreVValue = document.createTextNode(partidoObj.getVisitante().getNombre());                
                        nombreVNode.appendChild(nombreVValue);

                        Element resultadoLNode = document.createElement("resultadoL"); 
                        Text resultadoLValue = document.createTextNode(String.valueOf(partidoObj.getResultadoEL()));                
                        resultadoLNode.appendChild(resultadoLValue);

                        Element resultadoVNode = document.createElement("resultadoV"); 
                        Text resultadoVValue = document.createTextNode(String.valueOf(partidoObj.getResultadoEV()));                
                        resultadoVNode.appendChild(resultadoVValue);
                        //ASIGNAR ESTRUCTURA
                        partido.appendChild(codigoPNode);
                        partido.appendChild(fechaPNode);
                        partido.appendChild(nombreLNode);
                        partido.appendChild(nombreVNode);
                        partido.appendChild(resultadoLNode);
                        partido.appendChild(resultadoVNode);
                        partidos.appendChild(partido);
                        }

                datosJornada.appendChild(codigoNode);
                datosJornada.appendChild(fechaINode);
                datosJornada.appendChild(fechaFNode);
                
                Jornada.appendChild(datosJornada);
                Jornada.appendChild(partidos);
                //ASIGNAR RAMAS A RAIZ
                raiz.appendChild(Jornada); //pegamos el elemento a la raiz "Documento"
            }
                            
            //GENERAR XML
            Source source = new DOMSource(document);
            //Indicamos donde lo queremos almacenar
            name = "todasJornadas";
            Result result = new StreamResult(new java.io.File("../../LM/"+name+".xml")); //nombre del archivo
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        
    }
}

