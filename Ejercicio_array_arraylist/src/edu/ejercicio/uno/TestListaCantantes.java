package edu.ejercicio.uno;

import java.util.Scanner;

/**
 * Ejercicio Array y ArrayList

	Crear una clase denominada ListaCantantesFamosos que disponga de un atributo ArrayList listaCantantesFamosos que contenga objetos de tipo CantanteFamoso.
	La clase ListaCantantesFamosos debe tener un método que permita añadir objetos de tipo CantanteFamoso a la lista.
	
	Un objeto de tipo CantanteFamoso tendrá como atributos un nombre y un array normal de la clase Discos, con los 3 discos más vendidos, siempre ordenados por su numero de reproducciones, además de sus getters y setters.
	
	La clase Disco tiene los atributos titulo y numero de reproducciones.
	
	Crea una clase test con un main que inicialice un objeto de tipo ListaCantantesFamosos y añade manualmente objetos de tipo CantanteFamoso a la lista. Muestra los nombres de cada cantante y su disco con más ventas por pantalla. Se debe pedir al usuario el nombre y los discos con más ventas de otro cantante famoso, y una vez introducidos los datos mostrar la lista actualizada. Se debe dar la opcion al usuario de volver a introducir otro cantante hasta que el usuario decida salir.
	
	Por favor introduzca los datos de un cantante.
	Nombre: Michael Jackson
	Disco con más ventas: Thriller
	La lista actualizada contiene los siguientes datos:
	Cantante: Michael Jackson    Disco con más ventas: Thriller.
	¿Desea introducir los datos de otro cantante (s/n)?
	s
	Por favor introduzca los datos de otro cantante.
	Nombre: Luis Miguel
	Disco con más ventas: Mi jardín oculto
	La lista actualizada contiene los siguientes datos:
	Cantante: Michael Jackson    Disco con más ventas: Thriller.
	Cantante: Luis Miguel        Disco con más ventas: Mi jardín oculto.
 * @author Marina
 *
 */

public class TestListaCantantes {

	public static void main(String[] args) {
		ListaCantantesFamosos lcf = new ListaCantantesFamosos();
		Disco[] discos = new Disco[3];
		String opcion = "";
		String opcion2 = "";
		int contador = 0;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("¿Desea introducir datos de otro "
					+ "cantante?\n(Si/No)");
			opcion = sc.nextLine();
			if(opcion.toUpperCase().equals("NO")) break;
			else {
				System.out.print("Introduzca el nombre: ");
				String nombre = sc.nextLine();
				discos = new Disco[3];
				do {
					Scanner sc2 = new Scanner(System.in);
					System.out.println("¿Desea Introducir datos de un disco?(Si/No)");
					opcion2 = sc2.nextLine();
					if(opcion2.toUpperCase().equals("NO")) break;
					else {
						System.out.print("Introduzca nombre del disco: ");
						String nombreDisco = sc2.nextLine();
						System.out.print("Introduzca las reproducciones del disco: ");
						int reproducciones = sc2.nextInt();
						Disco disco = new Disco(nombreDisco, reproducciones);
						discos[contador] = disco;
						contador++;
					}
					//sc2.close();
				}while(opcion2.toUpperCase().equals("SI"));
				CantanteFamoso cf = new CantanteFamoso(nombre);
				cf.setDiscos(discos);
				lcf.aniadirCantante(cf);
			}
			//sc.close();
			System.out.println(lcf.toString());
		}while(opcion.toUpperCase().equals("SI"));
	}

}
