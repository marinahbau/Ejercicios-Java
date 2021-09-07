package multimedia;

import java.time.LocalDate;

public class Pelicula extends Multimedia{
	
	//Tiene los atributos titulo, autor, fecha y duracion
	//Ademas tiene
	private String actorPrincipal;
	private String actrizPrincipal;

	public Pelicula(String _titulo, String _autor, LocalDate _fecha, double _duracion, String _actor, String _actriz) throws Exception {
		super(_titulo, _autor, _fecha, _duracion);
		//Se permite que uno de los autores sea vacio pero no los dos
		if(_actor == "" && _actriz == "") {
			throw new Exception("Faltan los campos de los actores");
		}
		this.actorPrincipal = _actor;
		this.actrizPrincipal = _actriz;
	}
	
	@Override
	public String toString() {
		String resultado = super.toString();
		resultado += "\n Pelicula: \n" + "Actor principal: " + this.actorPrincipal + " Actriz Principal : " + this.actrizPrincipal;
		return resultado;
	}

}
