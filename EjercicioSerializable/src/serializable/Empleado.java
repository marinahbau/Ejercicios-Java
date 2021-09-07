package serializable;

import java.io.Serializable;

public class Empleado  implements Serializable{
	protected String nombre;
	protected double sueldo;
	protected transient Departamento dept;
	
	
	public Empleado(String nombre, double sueldo, Departamento dept) {
		super();
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.dept = dept;
	}


	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", sueldo=" + sueldo + ", dept=" + dept + "]";
	}
	
	
}
