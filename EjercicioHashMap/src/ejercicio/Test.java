package ejercicio;

public class Test {

	public static void main(String[] args) {
		Colegio c1 = new Colegio();
		
		c1.addAlumno("España");
		c1.addAlumno("España");
		c1.addAlumno("España");
		c1.addAlumno("Africa");
		c1.addAlumno("Suecia");

		c1.cuantos();
		c1.showAll();
		c1.showNacionalidad("aaa");
	}

}
