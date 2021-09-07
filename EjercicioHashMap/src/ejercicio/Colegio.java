package ejercicio;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Crea una clase colegio que almacene la nacionalidad de los alumnos de un colegio. La clase tendr� los siguientes m�todos.
	addAlumno(String nacionalidad - a�ade la nacionalidad de un nuevo alumno
	showAll() - Muestra las distintas nacionalidades y el n�mero de alumnos que existen por nacionalidad.
	showNacionalidad(String nacionalidad) - Muestra la nacionalidad y el n�mero de alumnos de esa nacionalidad
	cuantos() - Muestra cu�ntas nacionalidades diferentes existen en el colegio.
	borra() - Elimina los datos insertados.
	� Crea tambi�n una clase para testear la clase anterior.
	� Crea tambi�n una clase exceptionVacio del tipo Exception que ser� lanzada en el caso que se llame al m�todo addAlumno(String nacionalidad) con un par�metro nacionalidad vac�o.
 * @author Marina
 *
 */
public class Colegio {
	private Map alumno;

	public Colegio() {
		super();
		this.alumno = new HashMap<String,Integer>();
	}
	
	public void addAlumno(String nacionalidad) {
		if(this.alumno.containsKey(nacionalidad)) {
			int numeroAnterior = (Integer) alumno.get(nacionalidad);
			alumno.remove(nacionalidad);
			alumno.put(nacionalidad, numeroAnterior+1);
		}
		else {
			this.alumno.put(nacionalidad, 1);
		}
	}
	
	public void showAll() {
//		Iterator it = alumno.keySet().iterator();
//		
//		while(it.hasNext()) {
//			String clave = (String) it.next();
//			System.out.println("Nacionalidad: " +  it + " numero de alumnos: " + alumno.get(clave));
//		}
		
		//Otra forma
		for(Object i:alumno.keySet()) {
			System.out.println("Nacionalidad: " +  i.toString() + " numero de alumnos: " + alumno.get(i));
		}
	}
	
	public void showNacionalidad(String nacionalidad) {
		if(this.alumno.containsKey(nacionalidad)) {
			System.out.println("Nacionalidad: " + nacionalidad + " numero de alumnos: " + alumno.get(nacionalidad));
		}
		else {
			System.out.println("No hay ningun alumno con esa nacionalidad");
		}
	}
	
	public void cuantos() {
		System.out.println("Hay " + alumno.size() + " nacionalidades en el colegio");
	}
	
	public void borra() {
		this.alumno.clear();
		System.out.println("Datos borrados");
	}
}
