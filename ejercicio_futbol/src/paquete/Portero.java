package paquete;

public class Portero extends Jugador {
	private int paradas;

	public Portero(String nombre, int dorsal) {
		super(nombre, dorsal);
	}

	public int getParadas() {
		return paradas;
	}

	public void setParadas(int paradas) {
		this.paradas = paradas;
	}
	
	public void contabilizarParadas() {
		this.paradas = this.paradas + 1;
	}

	@Override
	public String toString() {
		return super.toString() + " PORTERO: paradas * " + this.paradas;
	}
}
