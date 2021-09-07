package edu.programacion;

import java.util.Random;
import java.util.Scanner;

public class Juego {
	private boolean tablero[][];
	private String tablero2[][];
	private int tamanio;
	private Barco barco[];

	public Juego(int tamanio) {
		this.tamanio = tamanio;
		this.barco = new Barco[3];
		for(int i=0; i<3; i++) {
			this.barco[i] = new Barco(i + 2);
		}
		this.tablero = new boolean[tamanio][tamanio];
		this.tablero2 = new String[tamanio][tamanio];
		for(int i=0; i<this.tablero2.length; i++) {
			for(int j=0; j<this.tablero2[i].length; j++) {
				tablero2[i][j] = "agua";
			}
		}
		this.prepararJuego();
	}

	public void mostrarTablero2() {
		for(int i=0; i<tablero2.length; i++) {
			for(int j=0; j<tablero2[i].length; j++) {
				System.out.print(tablero2[i][j] + " ");
			}
			System.out.println("");
		}
	}

	private void prepararJuego() {
		boolean valido = false;
		System.out.println("Colocando barcos aleatoriamente...");
		for(int i=0; i<3; i++) {
			valido=false;
			while(valido==false) {
				Random rd = new Random();
				int posicionFilas = rd.nextInt(this.tamanio);
				int posicionColumnas = rd.nextInt(this.tamanio);
				int orientacion = rd.nextInt(2);
				//El 0 sera la horizontal y el 1 sera la vertical
				if(this.cabeBarco(i, orientacion, posicionFilas, posicionColumnas)) {
					this.barco[i].setPosicionX(posicionFilas);
					this.barco[i].setPosicionY(posicionColumnas);
					this.barco[i].setOrientacion(orientacion);
					if(orientacion==0) {
						for(int j=0; j<this.barco[i].getTamanioBarco(); j++) {
							this.tablero[posicionFilas][posicionColumnas + j] = true;
							this.tablero2[posicionFilas][posicionColumnas + j] =
									"barco" + i;
						}
					}
					if(orientacion==1) {
						for(int j=0; j<this.barco[i].getTamanioBarco(); j++) {
							this.tablero[posicionFilas + j][posicionColumnas] = true;
							this.tablero2[posicionFilas + j][posicionColumnas] = "barco" + i;
						}
					}
					valido=true;
				}
			}
		}
	}

	private boolean cabeBarco(int numBarco, int orientacion,
			int posicionFilas, int posicionColumnas) {
		boolean cabe = false;
		if(orientacion==0) {
			if(posicionColumnas + this.barco[numBarco].getTamanioBarco()-1
					<this.tamanio) cabe=true;
			else cabe=false;
			if(cabe) {
				for(int j=0; j<this.barco[numBarco].getTamanioBarco(); j++) {
					if(this.tablero[posicionFilas][posicionColumnas + j]==true) {
						cabe = false;
						break;
					}
				}
			}
		}
		if (orientacion==1) {
			if(posicionFilas + this.barco[numBarco].getTamanioBarco()-1
					<this.tamanio) cabe=true;
			else cabe=false;
			if(cabe) {
				for(int j=0; j<this.barco[numBarco].getTamanioBarco(); j++) {
					if(this.tablero[posicionFilas + j][posicionColumnas]==true) {
						cabe = false;
						break;
					}
				}
			}
		}
		return cabe;
	}

	public boolean jugar() {
		int coord1;
		int coord2;
		System.out.println("Introduzca las coordenadas del disparo:");
		Scanner sc = new Scanner(System.in);
		coord1 = sc.nextInt();
		coord2 = sc.nextInt();
		if(coord1 < this.tablero.length && coord2 < this.tablero.length) {
			//Vemos si hemos acertado el disparo o no
			if(this.tablero[coord1][coord2]==true) {
				if(this.tablero2[coord1][coord2].contains("barco")) {
					System.out.println("Tocado " + this.tablero2[coord1][coord2]);
					int numBarco = Character.getNumericValue(this.tablero2[coord1][coord2].charAt(this.tablero2[coord1][coord2].length()-1));	
					System.out.println("Numbarco" + numBarco);
					this.tablero2[coord1][coord2] = "herido";
					this.barco[numBarco].setEstado("Tocado");
					
					//Comprobamos si hemos hundido un barco y lo mostramos
					//Si todos los barcos estan hundidos, el juego termina
					if(this.mostrarBarcosHundidos() == 3) {
						return false;
					}
				}
			}
			else {
				System.out.println("Has tocado agua");
			}
		}
		else {
			System.out.println("Coordenada inv�lida");
		}
		return true;
	}
	
	private int mostrarBarcosHundidos() {
		int contadorHundidos = 0;
		System.out.println("Barcos Hundidos" +  "\n-------------------");
		for(int i=0; i<this.barco.length; i++) {
			if(this.barco[i].getEstadoFinal() == "Hundido") {
				System.out.println("Barco" + i);
				contadorHundidos++;
			}
		}
		return contadorHundidos;
	}
}
