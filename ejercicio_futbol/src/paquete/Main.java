package paquete;

import java.util.HashSet;
import java.util.Scanner;


/**
 * Ejercicio para gestionar un equipo de fútbol, enunciado en enunciado_futbol.pdf
 * @author Marina
 */

public class Main {

	public static void main(String[] args) {
		HashSet<Jugador> jugadores = new HashSet<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Añadir atacante\n2. Añadir defensor\n3. Añadir portero\n4. Contabilizar gol\n"
				+ "5. Contabilizar pase exitoso\n6. Contabilizar balon recuperado\n7. Contabilizar parada\n"
				+ "8. Mostrar datos de un jugador\n9. Salir del programa");
		String nombre;
		int dorsal;
		
		do {
			Scanner sc1 = new Scanner(System.in);
			System.out.println("> ");
			int opcion = sc.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("Introduzca el nombre del jugador: ");
				nombre = sc1.nextLine();
				System.out.println("Introduzca el dorsal del jugador: ");
				dorsal = sc1.nextInt();
				jugadores.add(new Atacante(nombre, dorsal));
				break;
			case 2:
				System.out.println("Introduzca el nombre del jugador: ");
				nombre = sc1.nextLine();
				System.out.println("Introduzca el dorsal del jugador: ");
				dorsal = sc1.nextInt();
				jugadores.add(new Defensor(nombre, dorsal));
				break;
			case 3:
				System.out.println("Introduzca el nombre del jugador: ");
				nombre = sc1.nextLine();
				System.out.println("Introduzca el dorsal del jugador: ");
				dorsal = sc1.nextInt();
				jugadores.add(new Portero(nombre, dorsal));
				break;
			case 4:
				boolean encontrado = false;
				System.out.println("Introduzca el dorsal del jugador: ");
				dorsal = sc1.nextInt();
				for(Jugador j:jugadores) {
					if(j.getDorsal()==dorsal) {
						j.contabilizarGoles();
						encontrado = true;
					}
				}
				if(!encontrado) {
					throw new java.lang.IllegalArgumentException("El dorsal introducido no pertenece al equipo");
				}
				break;
			case 5:
				boolean encontrado1 = false;
				System.out.println("Introduzca el dorsal del jugador: ");
				dorsal = sc1.nextInt();
				for(Jugador j:jugadores) {
					if(j.getDorsal()==dorsal) {
						if(j.getClass()==Atacante.class) {
							((Atacante) j).contabilizarPase();
						}
						if(j.getClass()==Defensor.class) {
							((Defensor) j).contabilizarPase();
						}
						if(j.getClass()==Portero.class) {
							throw new java.lang.IllegalArgumentException("Los porteros no pueden contabilizar pases");
						}
						encontrado1 = true;
					}
				}
				if(!encontrado1) {
					throw new java.lang.IllegalArgumentException("El dorsal introducido no pertenece al equipo");
				}
				break;
			case 6:
				boolean encontrado2 = false;
				System.out.println("Introduzca el dorsal del jugador: ");
				dorsal = sc1.nextInt();
				for(Jugador j:jugadores) {
					if(j.getDorsal()==dorsal) {
						if(j.getClass()==Atacante.class) {
							((Atacante) j).contabilizarRecuperacion();
						}
						if(j.getClass()==Defensor.class) {
							((Defensor) j).contabilizarRecuperacion();
						}
						if(j.getClass()==Portero.class) {
							throw new java.lang.IllegalArgumentException("Los porteros no pueden contabilizar balones recuperados");
						}
						encontrado2 = true;
					}
				}
				if(!encontrado2) {
					throw new java.lang.IllegalArgumentException("El dorsal introducido no pertenece al equipo");
				}
				break;
			case 7:
				boolean encontrado3 = false;
				System.out.println("Introduzca el dorsal del jugador: ");
				dorsal = sc1.nextInt();
				for(Jugador j:jugadores) {
					if(j.getDorsal()==dorsal) {
						if(j.getClass()==Portero.class) {
							((Portero) j).contabilizarParadas();
						}
						if(j.getClass()==Atacante.class) {
							throw new java.lang.IllegalArgumentException("Los atacantes no pueden contabilizar paradas");
						}
						if(j.getClass()==Defensor.class) {
							throw new java.lang.IllegalArgumentException("Los defensores no pueden contabilizar paradas");
						}

						encontrado3 = true;
					}
				}
				if(!encontrado3) {
					throw new java.lang.IllegalArgumentException("El dorsal introducido no pertenece al equipo");
				}
				break;
			case 8:
				boolean encontrado4 = false;
				System.out.println("Introduzca el dorsal del jugador: ");
				dorsal = sc1.nextInt();
				for(Jugador j:jugadores) {
					if(j.getDorsal()==dorsal) {
						System.out.println(j.toString());
						encontrado4 = true;
					}
				}
				if(!encontrado4) {
					throw new java.lang.IllegalArgumentException("El dorsal introducido no pertenece al equipo");
				}
				break;
			case 9:
				System.exit(0);
				break;
			}
		} while(true);
	}
}
