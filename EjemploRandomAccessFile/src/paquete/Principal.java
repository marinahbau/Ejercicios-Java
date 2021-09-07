package paquete;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Principal {
	private static final int TAM_REG=18;
	private static final int TAM_NOMBRE=10;
	
	public static void main(String[] args) {
		String cadena="Hola";
		int numero=20;
		String entrada = "";
		StringBuffer sb;
		
		try {
			RandomAccessFile raf = new RandomAccessFile("prueba.dat","rw");
			escribir(3,raf);
			System.out.println("tamaño fichero: "+ raf.length());
			System.out.println("tamaño registro "+ TAM_REG);
			
			Scanner sc = new Scanner(System.in);
			entrada = "10";
			
			while(Integer.parseInt(entrada) > (raf.length()/TAM_REG)) {
				System.out.print("Introduce numero de registro a leer: ");
				entrada = sc.next();
			}
			
			leer(Integer.parseInt(entrada),raf);
			raf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void escribir(int num, RandomAccessFile raf) {
		StringBuffer sb;
		String cadena = "Hola";
		int numero = 20;
		
		try {
			raf.seek(raf.length());
			for(int j=0;j<num;j++) {
				sb = new StringBuffer(10);
				sb.append(cadena);
				for(int i=0; i<sb.capacity() - cadena.length(); i++) {
					sb.append("-");
				}
				raf.writeInt(j+1);
				raf.writeBytes(sb.toString());
				raf.writeInt(numero);
				raf.seek(raf.length());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void leer(int num, RandomAccessFile raf) throws IOException {
		StringBuffer sb;
		String cadena;
		int numero;
		int numreg;
		
		sb = new StringBuffer(10);
		raf.seek((num-1)*TAM_REG);
		numreg = raf.readInt();
		for(int i=0; i<TAM_NOMBRE; i++) {
			sb.append((char)raf.readByte());
		}
		numero = raf.readInt();
		System.out.println(numreg + sb.toString() + numero);
	}
}
