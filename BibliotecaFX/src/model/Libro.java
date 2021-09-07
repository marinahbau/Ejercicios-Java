package model;

import com.mysql.cj.conf.IntegerProperty;
import com.mysql.cj.conf.StringProperty;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Libro {
	private SimpleIntegerProperty referencia;
	private SimpleStringProperty titulo;
	private SimpleStringProperty autor;
	private SimpleStringProperty editorial;
	public Libro(int i, String titulo, String autor, String edi) {
		super();
		this.referencia =new SimpleIntegerProperty(i);
		this.titulo = new SimpleStringProperty(titulo);
		this.autor = new SimpleStringProperty(autor);
		this.editorial = new SimpleStringProperty(edi);
	}
	public SimpleIntegerProperty getReferencia() {
		return referencia;
	}
	public void setReferencia(SimpleIntegerProperty referencia) {
		this.referencia = referencia;
	}
	public String getTitulo() {
		return titulo.getValue();
	}
	public void setTitulo(SimpleStringProperty titulo) {
		this.titulo = titulo;
	}
	public SimpleStringProperty getAutor() {
		return autor;
	}
	public void setAutor(SimpleStringProperty autor) {
		this.autor = autor;
	}
	public SimpleStringProperty getEditorial() {
		return editorial;
	}
	public void setEditorial(SimpleStringProperty editorial) {
		this.editorial = editorial;
	}
	
	
}
