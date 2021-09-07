package edu.modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Libro {
	private final IntegerProperty id;
	private final StringProperty titulo;
	private final StringProperty autor;
	private final IntegerProperty anno;
	
	public Libro(int id, String titulo, String autor, int anno) {
		this.id = new SimpleIntegerProperty(id);
		this.titulo = new SimpleStringProperty(titulo);
		this.autor = new SimpleStringProperty(autor);
		this.anno = new SimpleIntegerProperty(anno);
	}

	public IntegerProperty getId() {
		return id;
	}

	public StringProperty getTitulo() {
		return titulo;
	}

	public StringProperty getAutor() {
		return autor;
	}

	public IntegerProperty getAnno() {
		return anno;
	}
	
	
}
