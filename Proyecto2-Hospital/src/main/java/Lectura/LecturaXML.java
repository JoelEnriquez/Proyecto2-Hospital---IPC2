/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lectura;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.input.SAXBuilder;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;

/**
 *
 * @author Joel Enriquez
 */
public class LecturaXML {

    String pathXML;

    public LecturaXML(String pathXML) {
        this.pathXML = pathXML;
    }

    public void leerXML() throws IOException {
        SAXBuilder builder = new SAXBuilder();
     
        try {
            File archivoEntradaXML = new File(pathXML);
            Document documento = (Document) builder.build(archivoEntradaXML);
            Element root = documento.getRootElement();

            List<Element> listaAdmins = root.getChildren("admin");

            for (int i = 0; i < listaAdmins.size(); i++) {

                Element admin = listaAdmins.get(i);

                List<Element> valoresAdmin = admin.getChildren();

                for (int j = 0; j < valoresAdmin.size(); j++) {
                    Element campoAdmin = valoresAdmin.get(i);
                    String codigo = campoAdmin.getChildTextTrim("CODIGO");
                    String DPI = campoAdmin.getChildTextTrim("DPI");
                    String NOMBRE = campoAdmin.getChildTextTrim("NOMBRE");
                    String PASSWORD = campoAdmin.getChildTextTrim("PASSWORD");

                    System.out.println(codigo + "\t" + DPI + "\t" + NOMBRE + "\t" + PASSWORD);
                }
            }

        } catch (JDOMException e) {
        }

//        try {
//            File archivoEntrada = new File(pathXML);
//            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
//            Document document = (Document) documentBuilder.parse(archivoEntrada);
//            
//            document.getDocumentElement().normalize();
//            System.out.println("Elemento raiz:" + document.getDocumentElement().getNodeName());
//            NodeList listaAdmin = document.getElementsByTagName("admin");
//            NodeList listaDoctores = document.getElementsByTagName("doctor");
//            NodeList listaLaboratoristas = document.getElementsByTagName("laboratorista");
//            NodeList listaPacientes = document.getElementsByTagName("paciente");
//            NodeList listaExamenes = document.getElementsByTagName("examen");
//            NodeList listaReportes = document.getElementsByTagName("reporte");
//            NodeList listaResultados = document.getElementsByTagName("resultado");
//            NodeList listaCitas = document.getElementsByTagName("cita");
//            NodeList listaConsultas = document.getElementsByTagName("consulta");
//
//            for (int i = 0; i < listaAdmin.getLength(); i++) {
//                Node nodo = listaAdmin.item(i);
//                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
//                    Element element = (Element) nodo;
//                    //NodeList 
//                }
//            }
//            
//        } catch (Exception e) {
//        }
//        try {
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            // Creo un documentBuilder
//            DocumentBuilder builder = factory.newDocumentBuilder();
//
//            // Obtengo el documento, a partir del XML
//            Document documento = (Document) builder.parse(new File("concesionario.xml"));
//
//            // Cojo todas las etiquetas coche del documento
//            NodeList listaCoches = documento.getElementsByTagName("coche");
//        } catch (Exception e) {
//        }
    }
}
