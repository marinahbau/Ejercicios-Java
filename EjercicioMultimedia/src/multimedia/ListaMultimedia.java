package multimedia;

import java.util.ArrayList;

public class ListaMultimedia {

	private ArrayList<Multimedia> multimedias;
	private int capacidad;
	private static int almacenados = 0;
	
	public ListaMultimedia(int _capacidad) {
		this.capacidad = _capacidad;
		multimedias = new ArrayList<>();
	}
	
	public int size() {
		return almacenados;
	}
	
	public boolean add(Multimedia m) {
		boolean resultado;
		if(ListaMultimedia.almacenados + 1 <= this.capacidad) {
			multimedias.add(m);
			ListaMultimedia.almacenados += 1;
			resultado = true;
		}
		else {
			resultado = false;
		}
		return resultado;
	}
	
	public Multimedia get(int posicion) {
		return this.multimedias.get(posicion);
	}
	
	public String toString() {
		String resultado = "";
		for(int i=0; i<ListaMultimedia.almacenados; i++) {
			resultado += this.multimedias.get(i).toString();
		}
		return resultado;
	}
	
	
	
	
}
