package paquete;

public class Jugador {
	protected String nombre;
	protected int dorsal;
	protected int goles;

	public Jugador(String nombre, int dorsal) {
		this.nombre = nombre;
		this.dorsal = dorsal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	public void contabilizarGoles() {
		this.goles = this.goles + 1;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", dorsal=" + dorsal + ", goles=" + goles + "]";
	}

}
