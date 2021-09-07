package ejemploCS;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	static final String HOST="localhost";
	static final int PUERTO=506;
	public Cliente() {
		
		try {
			Socket skCliente = new Socket (HOST, PUERTO);
			InputStream aux = skCliente.getInputStream();
			OutputStream out = skCliente.getOutputStream();
			DataInputStream ind = new DataInputStream(aux);
			DataOutputStream outd = new DataOutputStream(out);
			
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Escribe un numero: ");
			int numero = sc.nextInt();
			outd.writeInt(numero);
			
			
			//Esperamos respuesta
			System.out.println("El servidor contesta: " + ind.readUTF());
			int potencia = sc.nextInt();
			outd.writeInt(potencia);
			
			
			//Esperamos respuesta
			System.out.println("El servidor contesta: " + ind.readUTF());
			
			skCliente.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] arg) {
		new Cliente();
	}
}
