package edu.programacion;

import java.util.Scanner;
/**
 * 6.5. Hundir la flota
	Desarrolla una aplicación de simule el juego 'Hundir la flota', en la que se utilicen arrays primitivos. Las características del juego son las siguientes:
	
	El océano por donde navegarán los barcos es de un tamaño prefijado (4x4, 6x6 o 8x8).
	
	Los barcos tendrán un tamaño predefinido: 1x2, 1x3 y 1x4. Es decir cada barco ocupará 2, 3 o 4 posiciones en el océano.
	
	Independientemente del océano seleccionado sólo existirán 3 barcos.
	
	El jugador realizará disparos en base a las coordenadas de los barcos. Un barco se encontrará en uno de los siguientes estados: tocado o hundido (todas sus coordenadas han recibido un disparo)
	
	El juego comienza solicitando al jugador el tamaño del océano, después posicionando los barcos aleatoriamente, y a continuación solicitando los disparos al jugador. Después de cada disparo se mostrará el resultado del mismo: 'agua', 'tocado' o 'hundido'
	
	El juego finaliza cuando se hunden todos los barcos o el usuario decide no continuar jugando.
 * @author Marina
 *
 */
public class HundirFlota {

	public static void main(String[] args) {
		System.out.println("Determine el  tamaño del tablero:");
		int tamanio;
		Scanner sc = new Scanner(System.in);
		tamanio = sc.nextInt();
		if(tamanio==4 || tamanio==6 || tamanio==8) {
			Juego tablero = new Juego(tamanio);
			tablero.mostrarTablero2();
			int numero;
			do {
				System.out.println("Menus del juego:\n1.Disparar\n2.Salir del juego");
				numero = sc.nextInt();
				if(numero==1) {
					if(!tablero.jugar()) {
						break;
					}
					else {
						tablero.mostrarTablero2();
					}
				}
			}while(numero==1);
			System.out.println("Game Over");
		}
		else {
			System.out.println("Tamaño no disponible");
			return;
		}
	}

}
