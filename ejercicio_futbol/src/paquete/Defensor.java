package paquete;

public class Defensor extends Jugador {
	private int paseExitoso;
	private int balonRecuperado;

	public Defensor(String nombre, int dorsal) {
		super(nombre, dorsal);
	}

	public int getPaseExitoso() {
		return paseExitoso;
	}

	public void setPaseExitoso(int paseExitoso) {
		this.paseExitoso = paseExitoso;
	}

	public int getBalonRecuperado() {
		return balonRecuperado;
	}

	public void setBalonRecuperado(int balonRecuperado) {
		this.balonRecuperado = balonRecuperado;
	}

	public void contabilizarPase() {
		this.paseExitoso = this.paseExitoso + 1;
	}

	public void contabilizarRecuperacion() {
		this.balonRecuperado = this.balonRecuperado + 1;
	}

	@Override
	public String toString() {
		return super.toString() + " DEFENSOR: pases * " + this.paseExitoso + " recuperaciones * " + this.balonRecuperado;
	}

}
