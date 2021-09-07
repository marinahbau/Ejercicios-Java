package multimedia;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Multimedia m1 = new Multimedia("", "Actor", LocalDate.of(2020, 04, 06), 20.30);
		Multimedia m2 = new Multimedia("Holas", "aaaa", LocalDate.of(2020, 04, 06), 20.30);
		Multimedia m3 = new Multimedia("Holas", "oleole", LocalDate.of(2020, 04, 06), 20.30);

		Pelicula p1 = new Pelicula("Holas", "oleole", LocalDate.of(2020, 04, 06), 20.30,"","");
		ListaMultimedia l1 = new ListaMultimedia(2);
		
		l1.add(m1);
		l1.add(m2);
		l1.add(m3);
		
		System.out.println(l1.size());
		System.out.println(l1.toString());
		
		
	}

}
