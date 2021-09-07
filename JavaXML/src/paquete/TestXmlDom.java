package paquete;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * C�digo main completado para extraer caracter�sticas de un archivo XML de personas
 * @author Marina
 *
 */

public class TestXmlDom {
	
	public static void main(String[] args) {			
		try {
			// 1º Creamos una nueva instancia de un fábrica de constructores
			// de documentos.DocumentBuilderFactory
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// 2º A partir de la instancia anterior, fabricamos un 
			// constructor de documentos, que procesará el XML.
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3º Procesamos el documento (almacenado en un archivo) 
			// y lo convertimos en un árbol DOM.			
			Document documento=db.parse("personas.xml");	

			System.out.println(documento.getXmlVersion());
			System.out.println(documento.getXmlEncoding());
			System.out.println(documento.getNodeName());

			Element root = documento.getDocumentElement();
			System.out.println(root.getNodeName());

			//Buscar un nodo concreto
			NodeList listaNodos=documento.
					getElementsByTagName("persona");

			Element persona;
			if (listaNodos.getLength()>0){
				persona=(Element)listaNodos.item(0);
				NodeList nodoPersona = persona.getElementsByTagName("age");
				if(nodoPersona.getLength()==1) {
					Element firstName = (Element)nodoPersona.item(0);
					System.out.println(firstName.getChildNodes().
							item(0));

				}
			}


			//obtener lista de hijos
			listaNodos=documento.
					getDocumentElement().getChildNodes();
			
			//showPersonProperties(listaNodos);
			//showProperties(listaNodos);
			HashMap<Integer,String> mapa = showPropertiesMap(listaNodos);
			System.out.println(mapa);

		} catch (SAXException | IOException | ParserConfigurationException e) {

			e.printStackTrace();
		}

	}
	//TODO implementar este método para recorrer todas las personas
	//del XML y sus propiedades
	private static void showPersonProperties(NodeList listaNodos) {
		for (int i=0; i<listaNodos.getLength();i++) {
			Node nodo=listaNodos.item(i);
			switch (nodo.getNodeType()){
			case Node.ELEMENT_NODE:
				Element elemento = (Element) nodo;
				System.out.println("Etiqueta:" + 
						elemento.getTagName());
				//TODO tratar las propiedades de cada persona
				//Propiedad - ID
				NodeList nodoPropiedad = elemento.getElementsByTagName("id");
				if(nodoPropiedad.getLength()==1) {
					Element id = (Element)nodoPropiedad.item(0);
					System.out.println("\tID: " + id.getChildNodes().item(0).getNodeValue());
				}
				//Propiedad - FirstName
				nodoPropiedad = elemento.getElementsByTagName("first_name");
				if(nodoPropiedad.getLength()==1) {
					Element fname = (Element)nodoPropiedad.item(0);
					System.out.println("\tFirst Name: " + fname.getChildNodes().item(0).getNodeValue());
				}
				//Propiedad - LastName
				nodoPropiedad = elemento.getElementsByTagName("last_name");
				if(nodoPropiedad.getLength()==1) {
					Element lname = (Element)nodoPropiedad.item(0);
					System.out.println("\tLast Name: " + lname.getChildNodes().item(0).getNodeValue());
				}
				
				
				break;
			case Node.TEXT_NODE:
				Text texto = (Text) nodo;
				System.out.println("Texto:" + 
						texto.getWholeText());										
				
				break;
			}      
		}
	}
	//TODO recorrer cada persona, mostrar sus propiedades, crear y almacenar
	//las personas en una lista ordenada por apellidos y nombre, y también
	//almacenar todas las personas en un mapa compuesto por: el identificador
	//como clave y el correo como valor
	private HashMap<Integer,String> showProperties(Element elemento) {
		
		return null;		
	}
	
	private static void showProperties(NodeList elementos) {
		List<Persona> personas = new ArrayList<>();
		
		for (int i=0; i<elementos.getLength();i++) {
			Node nodo=elementos.item(i);
			switch (nodo.getNodeType()){
				case Node.ELEMENT_NODE:
					Element elemento = (Element) nodo;
					String id = null, fn = null,ln = null,gender = null,email = null,age = null;
					//Propiedad - ID
					NodeList nodoPropiedad = elemento.getElementsByTagName("id");
					if(nodoPropiedad.getLength()==1) {
						id = nodoPropiedad.item(0).getChildNodes().item(0).getNodeValue();
					}
					//Propiedad - FN
					nodoPropiedad = elemento.getElementsByTagName("first_name");
					if(nodoPropiedad.getLength()==1) {
						fn = nodoPropiedad.item(0).getChildNodes().item(0).getNodeValue();
					}
					//Propiedad - LN
					nodoPropiedad = elemento.getElementsByTagName("last_name");
					if(nodoPropiedad.getLength()==1) {
						ln = nodoPropiedad.item(0).getChildNodes().item(0).getNodeValue();
					}
					//Propiedad - email
					nodoPropiedad = elemento.getElementsByTagName("email");
					if(nodoPropiedad.getLength()==1) {
						email = nodoPropiedad.item(0).getChildNodes().item(0).getNodeValue();
					}
		
					//Propiedad - gender
					nodoPropiedad = elemento.getElementsByTagName("gender");
					if(nodoPropiedad.getLength()==1) {
						gender = nodoPropiedad.item(0).getChildNodes().item(0).getNodeValue();
					}
					//Propiedad - age
					nodoPropiedad = elemento.getElementsByTagName("age");
					if(nodoPropiedad.getLength()==1) {
						age = nodoPropiedad.item(0).getChildNodes().item(0).getNodeValue();
					}
					personas.add(new Persona(Integer.parseInt(id),fn,ln,gender,email,Integer.parseInt(age)));
					break;
					
			}
			
		}
		Collections.sort(personas, new Comparator<Persona>() {
			@Override
			public int compare(Persona o1, Persona o2) {
				if(o1.getFirstName().compareTo(o2.getFirstName()) > 0 ) {
					return 1;
				}
				if(o1.getFirstName().compareTo(o2.getFirstName()) < 0 ) {
					return -1;
				}
				if(o1.getFirstName().compareTo(o2.getFirstName()) == 0) {
					if(o1.getLastName().compareTo(o2.getLastName()) == 0) {
						return 0;
					}
					if(o1.getLastName().compareTo(o2.getLastName()) < 0) {
						return -1;
					}
					if(o1.getLastName().compareTo(o2.getLastName()) > 0) {
						return 1;
					}
					
				}
				return 0;
			}
		});
		for(Persona p: personas) {
			System.out.println(p);
		}		
	}
	
	private static HashMap<Integer,String> showPropertiesMap(NodeList elementos) {
		HashMap<Integer,String> mapa = new HashMap();
		
		for (int i=0; i<elementos.getLength();i++) {
			Node nodo=elementos.item(i);
			switch (nodo.getNodeType()){
				case Node.ELEMENT_NODE:
					Element elemento = (Element) nodo;
					String id = null, email = null;
					//Propiedad - ID
					NodeList nodoPropiedad = elemento.getElementsByTagName("id");
					if(nodoPropiedad.getLength()==1) {
						id = nodoPropiedad.item(0).getChildNodes().item(0).getNodeValue();
					}
					
					//Propiedad - email
					nodoPropiedad = elemento.getElementsByTagName("email");
					if(nodoPropiedad.getLength()==1) {
						email = nodoPropiedad.item(0).getChildNodes().item(0).getNodeValue();
					}
					mapa.put(Integer.parseInt(id), email);
					break;
					
			}
			
		}
		return mapa;		
	}
}
