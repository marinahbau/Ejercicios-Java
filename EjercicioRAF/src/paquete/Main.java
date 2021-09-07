package paquete;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 7.3. Ficheros de acceso aleatorio: gestión de alumnos
	Hay que desarrollar una aplicación para gestionar alumnos usando ficheros de registros de datos. Las propiedades de los alumnos que interesan son: - Número del alumno (entero) - Nombre (cadena de caracteres: 40) - Domicilio (cadena de caracteres: 60) - Edad (entero) - Número de teléfono (entero) - Correo electrónico (cadena de caracteres:30) En esta actividad sólo desarrollaremos la operación de alta de un alumno. Para ello se construirá un menú con las siguientes operaciones: 
	1. Alta 
	2. Salir 
	En las actividades posteriores a esta iremos completando las operaciones de gestión sobre los datos de alumnos.
 * @author Marina
 *
 */

public class Main {
	
	public static void main(String[] args) {
		try {
			RandomAccessFile raf = new RandomAccessFile("alumnoos.dat","rw");
			Scanner sc = new Scanner(System.in);
			int numero_menu;
			//Estructura del menú
			do {
				System.out.println("Bienvenido al sistema de gestión");
				System.out.println("Menú:" + "\n1.Alta de un alumno" + "\n2.Salir");
				numero_menu = sc.nextInt();
				
				switch(numero_menu) {
				case 1:
					altaAlumno(raf);
					break;
				case 2:
					break;
				default:
					System.out.println("ERROR - Entrada no reconocida");
				}
			}while(numero_menu!=2);
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void altaAlumno(RandomAccessFile raf) {
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el numero del alumno nuevo: ");
		int numero = sc.nextInt();
		System.out.println("Introduce el nombre del alumno nuevo: ");
		String nombre = sc.next();
		System.out.println("Introduce el domicilio del alumno nuevo: ");
		String domicilio = sc.next();
		System.out.println("Introduce la edad del alumno nuevo: ");
		int edad = sc.nextInt();
		System.out.println("Introduce el tlf del alumno nuevo: ");
		int tlf = sc.nextInt();
		System.out.println("Introduce el correo del alumno nuevo: ");
		String correo = sc.next();*/
		
		Alumno nuevoAlumno = new Alumno(2,"Mario","Domicilio MArio",9,92191890,"Mario@gmail.com");
		nuevoAlumno.altaAlumno(raf);
		try {
			System.out.println("Tamanio fichero: " + raf.length() + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nuevoAlumno.leerAlumno(raf);
		System.out.println("Alumno dado de alta en el sistema");
	}

}
