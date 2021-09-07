package hundirlaflota;

import java.util.Arrays;

public class Barco {
	private int tamanioBarco;
	private String estado[];
	private int posicionX;
	private int posicionY;
	private int orientacion;
	private int numEstado;
	
	public Barco(int tamanioBarco) {
		this.tamanioBarco = tamanioBarco;
		this.estado = new String[tamanioBarco];
		Arrays.fill(this.estado, "vivo");
	}

	public int getTamanioBarco() {
		return tamanioBarco;
	}

	public void setTamanioBarco(int tamanioBarco) {
		this.tamanioBarco = tamanioBarco;
	}

	public String getEstado(int posicion) {
		return estado[posicion];
	}

	public void setEstado (String estado) {
		this.estado[numEstado] = estado;
		numEstado++;
	}

	public int getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
	
	public int getOrientacion() {
		return orientacion;
	}

	public void setOrientacion(int orientacion) {
		this.orientacion = orientacion;
	}
	
	public String getEstadoFinal() {

		for(int i=0; i<this.tamanioBarco; i++) {
			if(this.estado[i] == "vivo") {
				return "Vivo";
			}
		}
		return "Hundido";
	}
}
