package multimedia;

import java.time.LocalDate;

public class Multimedia {

	private String titulo;
	private String autor;
	private LocalDate fechaLanzamiento;
	private double duracion;
	
	public Multimedia(String _titulo, String _autor, LocalDate _fecha, double _duracion) {
		this.titulo = _titulo;
		this.autor = _autor;
		this.fechaLanzamiento = _fecha;
		this.duracion = _duracion;
	}
	
	public String toString() {
		String resultado = "Multimedia: \n Titulo: " + this.titulo + " Autor: " + this.autor + " Fecha lanzamiento: " + this.fechaLanzamiento + " Duracion: " + this.duracion;
		return resultado;
	}
	
	public boolean equals(Multimedia archivoAcomparar) {
		boolean isEqual = false;
		if(this.titulo == archivoAcomparar.titulo && this.autor == archivoAcomparar.autor) {
			isEqual = true;
		}
		return isEqual;
	}
}
