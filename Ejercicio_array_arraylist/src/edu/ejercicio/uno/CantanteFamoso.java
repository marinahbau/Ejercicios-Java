package edu.ejercicio.uno;

import java.util.Arrays;

public class CantanteFamoso {
	private String nombre;
	private Disco[] discos;

	public CantanteFamoso(String nombre) {
		super();
		this.nombre = nombre;
		this.discos = new Disco[3];
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Disco[] getDiscos() {
		return discos;
	}

	public void setDiscos(Disco[] discos) {
		this.discos = discos;
		this.sort();
	}

	private void sort() {
		for (int i = 0; i < this.discos.length - 1; i++) {
			for (int j = 0; j < this.discos.length - i - 1; j++) {
				if (this.discos[j + 1].getNumReproduciones() > 
				this.discos[j].getNumReproduciones()) {
					Disco aux = this.discos[j + 1];
					this.discos[j + 1] = this.discos[j];
					this.discos[j] = aux;
				}
			}
		}
	}

	@Override
	public String toString() {
		return "CantanteFamoso [nombre=" + nombre + ", discos=" + Arrays.toString(discos) + "]";
	}

}
