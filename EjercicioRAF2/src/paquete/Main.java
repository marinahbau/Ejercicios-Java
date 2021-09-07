package paquete;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 7.4. Ficheros de acceso aleatorio: gestión de alumnos II
	Continuamos con la gestión de alumnos de la actividad 7.3. 
	Ahora queremos implementar las siguientes operaciones:
	
	-Modificar datos de un alumno
	-Dar de baja, eliminar datos del alumno elegido
	-Mostrar datos de todos los alumnos
	Para las operaciones anteriores se incluirán las opciones de menú correspondientes
 * @author Marina
 *
 */
public class Main {
	
	public static void main(String[] args) {
		try {
			RandomAccessFile raf = new RandomAccessFile("alumnoos.dat","rw");
			
			int numero_menu;
			//Estructura del menú
			do {
				Scanner sc = new Scanner(System.in);
				System.out.println("Bienvenido al sistema de gestión");
				System.out.println("Menú:" + "\n1.Alta de un alumno" + "\n2.Salir" 
									+ "\n3.Modificar Datos de un alumno"
									+ "\n4.Dar de baja un alumno"
									+ "\n5.Mostrar todos los alumnos");
				numero_menu = sc.nextInt();
				
				switch(numero_menu) {
				case 1:
					altaAlumno(raf);
					break;
				case 2:
					break;
				case 3:
					modificarAlumno(raf);
					break;
				case 4:
					bajaAlumno(raf);
					break;
				case 5:
					mostrarAlumnos(raf);
					break;
				default:
					System.out.println("ERROR - Entrada no reconocida");
				}
				sc.close();
			}while(numero_menu!=2);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void altaAlumno(RandomAccessFile raf) {
		Scanner sc = new Scanner(System.in);
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
		String correo = sc.next();
		
		Alumno nuevoAlumno = new Alumno(numero,nombre,domicilio,edad,tlf,correo);
		nuevoAlumno.altaAlumno(raf);
		try {
			System.out.println("Tamanio fichero: " + raf.length() + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//nuevoAlumno.leerAlumno(raf);
		System.out.println("Alumno dado de alta en el sistema");
		sc.close();
	}

	public static void mostrarAlumnos(RandomAccessFile raf) {
		try {
			for(int i=0; i<(raf.length()/Alumno.TAM_REGISTRO); i++) {
				Alumno.leerAlumno(raf, i+1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void modificarAlumno(RandomAccessFile raf) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el numero del alumno a modificar: ");
		int numero = sc.nextInt();
		System.out.println("Introduce el nombre del alumno: ");
		String nombre = sc.next();
		System.out.println("Introduce el domicilio del alumno: ");
		String domicilio = sc.next();
		System.out.println("Introduce la edad del alumno: ");
		int edad = sc.nextInt();
		System.out.println("Introduce el tlf del alumno: ");
		int tlf = sc.nextInt();
		System.out.println("Introduce el correo del alumno: ");
		String correo = sc.next();
		
		Alumno nuevoAlumno = new Alumno(numero,nombre,domicilio,edad,tlf,correo);
		nuevoAlumno.modificarAlumno(raf);
		sc.close();
	}
	
	public static void bajaAlumno(RandomAccessFile raf) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce el numero del alumno a borrar: ");
			int numero = sc.nextInt();
			raf.seek((numero-1)*Alumno.TAM_REGISTRO);
			Alumno vacio = new Alumno();
			
			raf.writeInt(vacio.getNum_alumno());
			System.out.println("Tamanio fichero0: " + raf.length() + "\n");
			vacio.aniadirString(Alumno.TAM_NOMBRE, vacio.getNombre(), raf);
			System.out.println("Tamanio fichero: " + raf.length() + "\n");
			vacio.aniadirString(Alumno.TAM_DOMICILIO, vacio.getDomicilio(), raf);
			System.out.println("Tamanio fichero: " + raf.length() + "\n");
			raf.writeInt(vacio.getEdad());
			System.out.println("Tamanio fichero: " + raf.length() + "\n");
			raf.writeInt(vacio.getTlf());
			System.out.println("Tamanio fichero: " + raf.length() + "\n");
			vacio.aniadirString(Alumno.TAM_CORREO, vacio.getCorreo(), raf);
			System.out.println("Tamanio fichero: " + raf.length() + "\n");
			sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
