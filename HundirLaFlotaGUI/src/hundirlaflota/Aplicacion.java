package hundirlaflota;

import java.io.IOException;

import Vista.vistaHundirFlota;
import Vista.vistaLog;
import Vista.vistaTablero;
import controlador.ControladorHundirFlota;

/**
 * Ejercicio sobre el juego Hundir la Flota aplicando una interfaz gráfica con Java Swing
 * siguiendo el patrón MVC
 * @author Marina
 *
 */
public class Aplicacion {

	public static void main(String[] args) throws IOException {
		/*//Pedimos al usuario el tamaño del tablero
		System.out.println("Bienvenido! Elija un tamaño de tablero: " 
		+ "\n1.Tablero de 4x4" + "\n2.Tablero de 6x6" + "\n3.Tablero de 8x8");
		
		Scanner sc = new Scanner(System.in);
		int eleccion = sc.nextInt();
		*/
		vistaLog log = new vistaLog();
		vistaHundirFlota vista = new vistaHundirFlota();
		vistaTablero tablero = new vistaTablero();
		ControladorHundirFlota controlador = new ControladorHundirFlota(vista,tablero,log);
		
		vista.setVisible(true);
		
		/*//Cargamos el nuevo tablero
		if(eleccion == 4 || eleccion == 6 || eleccion == 8) {
			Juego j1 = new Juego(eleccion);
			//4System.out.print(j1.tablero.toString());
			//j1.mostrarTablero();
			
		}
		else {
			System.out.println("Tamaño de tablero no disponible. Hasta la proxima!");
			return;
		}*/
		

	}

}
