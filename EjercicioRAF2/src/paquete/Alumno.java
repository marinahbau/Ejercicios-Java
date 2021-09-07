package paquete;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Alumno {
	public static final int TAM_NOMBRE = 40;
	public static final int TAM_DOMICILIO = 60;
	public static final int TAM_CORREO = 30;
	public static final int TAM_REGISTRO = TAM_NOMBRE + TAM_DOMICILIO + TAM_CORREO + 4*3;
	
	private int num_alumno = -1;
	private String nombre = "";
	private String domicilio = "";
	private int edad;
	private int tlf;
	private String correo = "";
	
	public Alumno(int num_alumno, String nombre, String domicilio, int edad, int tlf, String correo) {
		super();
		this.num_alumno = num_alumno;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.edad = edad;
		this.tlf = tlf;
		this.correo = correo;
	}

	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	public int getNum_alumno() {
		return num_alumno;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public int getEdad() {
		return edad;
	}

	public int getTlf() {
		return tlf;
	}

	public String getCorreo() {
		return correo;
	}
	
	public void altaAlumno(RandomAccessFile raf) {
		try {
			raf.seek(raf.length()); //Buscamos el final del fichero para escribir a partir de ahi
			raf.writeInt(this.num_alumno);
			System.out.println("Tamanio fichero0: " + raf.length() + "\n");
			this.aniadirString(TAM_NOMBRE, nombre, raf);
			System.out.println("Tamanio fichero: " + raf.length() + "\n");
			this.aniadirString(TAM_DOMICILIO, domicilio, raf);
			System.out.println("Tamanio fichero: " + raf.length() + "\n");
			raf.writeInt(this.edad);
			System.out.println("Tamanio fichero: " + raf.length() + "\n");
			raf.writeInt(this.tlf);
			System.out.println("Tamanio fichero: " + raf.length() + "\n");
			this.aniadirString(TAM_CORREO, correo, raf);
			System.out.println("Tamanio fichero: " + raf.length() + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void leerAlumno(RandomAccessFile raf, int num) {
		StringBuffer sb;
		try {
			raf.seek((num-1)*TAM_REGISTRO);
			int numero = raf.readInt();
			if(numero != -1) { //Si es valido leemos y mostramos
				System.out.println("Numero: "+ numero);
				System.out.println("Nombre: " + leerString(TAM_NOMBRE, raf));
				System.out.println("Domicilio: " + leerString(TAM_DOMICILIO, raf));
				System.out.println("Edad: "+ raf.readInt());
				System.out.println("Telefono: " + raf.readInt());
				System.out.println("Correo: " + leerString(TAM_CORREO, raf));
			}else { //Si no es valido solo leemos, no mostramos el registro pq esta borrado
				
				leerString(TAM_NOMBRE, raf);
				leerString(TAM_DOMICILIO, raf);
				raf.readInt();
				raf.readInt();
				leerString(TAM_CORREO, raf);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void aniadirString(int tamanio,String cadena, RandomAccessFile raf) {
		StringBuffer sb = new StringBuffer(tamanio);
		try {
			sb.append(cadena);
			for(int i=0; i<sb.capacity() - cadena.length(); i++) {
				sb.append(" ");
			}
			raf.writeBytes(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String leerString(int tamanio, RandomAccessFile raf) {
		StringBuffer sb = new StringBuffer(tamanio);
		for(int i=0; i<tamanio; i++) {
			try {
				sb.append((char) raf.readByte());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	public void modificarAlumno(RandomAccessFile raf) {
		try {
			raf.seek((this.num_alumno-1)*TAM_REGISTRO); //Buscamos el alumno a modificar
			raf.writeInt(this.num_alumno);
			
			this.aniadirString(TAM_NOMBRE, nombre, raf);
			
			this.aniadirString(TAM_DOMICILIO, domicilio, raf);
			
			raf.writeInt(this.edad);
			
			raf.writeInt(this.tlf);
			
			this.aniadirString(TAM_CORREO, correo, raf);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
