package edu.ejercicio.uno;

import java.util.ArrayList;

public class ListaCantantesFamosos {
	private ArrayList<CantanteFamoso> cantantesFamosos;

	public ListaCantantesFamosos() {
		super();
		this.cantantesFamosos = new ArrayList<>();
	}

	public ArrayList<CantanteFamoso> getCantantesFamosos() {
		return cantantesFamosos;
	}

	public void setCantantesFamosos(ArrayList<CantanteFamoso> cantantesFamosos) {
		this.cantantesFamosos = cantantesFamosos;
	}

	public void aniadirCantante(CantanteFamoso cantante) {
		cantantesFamosos.add(cantante);
	}

	public void removeCantante(CantanteFamoso cantante) {
		cantantesFamosos.remove(cantante);
	}

	@Override
	public String toString() {
		return "ListaCantantesFamosos [cantantesFamosos=" + cantantesFamosos + "]";
	}

}
