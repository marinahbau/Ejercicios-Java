package edu.ejercicio.uno;

public class Disco {
	private String titulo;
	private int numReproduciones;
	
	public Disco(String titulo, int numReproduciones) {
		super();
		this.titulo = titulo;
		this.numReproduciones = numReproduciones;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumReproduciones() {
		return numReproduciones;
	}

	public void setNumReproduciones(int numReproduciones) {
		this.numReproduciones = numReproduciones;
	}

	@Override
	public String toString() {
		return "Disco [titulo=" + titulo + ", numReproduciones=" + numReproduciones + "]";
	}
	
}
