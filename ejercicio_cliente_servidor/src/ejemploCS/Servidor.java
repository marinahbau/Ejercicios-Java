package ejemploCS;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hay que desarrollar una aplicación Java cliente-servidor, las dos aplicaciones. El servidor realizará operaciones a demanda del cliente. 
 * La comunicación entre ambos terminará cuando el cliente no quiera realizar más operaciones.
 * Las operaciones posibles son:Potencia
 * @author Marina
 *
 */

public class Servidor {
	static final int PUERTO=506;
	
	public Servidor() {
		
		try {
			ServerSocket skServidor = new ServerSocket(PUERTO);
			System.out.println("Escuchando el puerto "+ PUERTO);
			
			for (int numCli = 0; numCli < 3; numCli++) {
				Socket skCliente = skServidor.accept();
				System.out.println("sirvo al cliente "+  numCli);
				
				InputStream in = skCliente.getInputStream();
				DataInputStream ind = new DataInputStream(in);
				
				OutputStream out = skCliente.getOutputStream();
				DataOutputStream outd = new DataOutputStream(out);
			
				//Esperamos flujo de lectura
				int numero = ind.readInt();
				System.out.println("El cliente " + numCli + " dice " + numero);
				
				outd.writeUTF("Dame la potencia ");
				int potencia = ind.readInt();
				System.out.println("El cliente " + numCli + " dice " + potencia);
				
				int calculo = (int) Math.pow(numero, potencia);
				outd.writeUTF("El resultado es " + calculo);
				
				skCliente.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main (String[] arg) {
		new Servidor();
	}
}
