package serializable;

import java.util.ArrayList;

public class Director extends Empleado{
	
	private double aumento_sueldo = 0.3;
	private ArrayList<Empleado> secretario = new ArrayList<>();
	
	public Director(String nombre, double sueldo, Departamento dept, ArrayList<Empleado>sec) {
		super(nombre, sueldo, dept); 
		this.secretario = sec;
		aumentarSueldo();
	}
	private void aumentarSueldo() {
		super.sueldo *= (1+this.aumento_sueldo);
	}
	
	@Override
	public String toString() {
		
		return super.toString() + "\nDirector [Secretarios=" + secretario + "]\n\n";
	}
	
	
}
