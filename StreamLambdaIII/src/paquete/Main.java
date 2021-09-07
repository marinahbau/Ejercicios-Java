package paquete;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 6.12. Streams y lambda III
	Desarrolla una aplicación Java con métodos NO instanciables que realicen lo siguiente:
	
	1. Devuelve una cadena a partir del primer carácter de cada palabra almacenada en una lista, con palabras, que se recibe como parámetro.
	
	2. Devuelve una cadena de caracteres a partir de un mapa cuyas claves son de tipo cadena y los valores de tipo entero. La cadena devuelta debe contener lo siguiente: "clave1=valor1, clave2=valor2, ..., claveN=valorN". Donde:
	
	clave1 y clave2: son los valores de las claves para el primer y segundo elemento del mapa
	
	valor1 y valor2: son los valores de las claves anteriores
	
	3. Utilizando el fichero adjunto, personas.csv, que contiene los datos de personas: identificador, nombre, apellidos, correo y edad. Desarrolla una aplicación Java que realice lo siguiente:
	
	Construye una clase Persona con las propiedades necesarias para los datos del fichero personas.csv
	Lee el fichero y guarda su contenido en una lista o un array de tipo Persona
	Crea un mapa con las personas que son mayores de edad
	Crea un mapa con las personas cuyo primer apellido comienza por 'C' o por 'A'
 * @author Marina
 *
 */
public class Main {

	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		lista.add("hola");
		lista.add("adios");
		System.out.println(metodo1(lista));

		HashMap<String,Integer> mapa = new HashMap();
		mapa.put("hola", 1);
		mapa.put("adios", 2);
		System.out.println(metodo2(mapa));
		metodo3();
	}
	
	public static String metodo1(List<String> lista) {
		String resultado = lista.stream().map(s -> s.substring(0, 1))
				.collect(Collectors.joining());
		
		return resultado;
	}
	
	public static String metodo2(HashMap<String,Integer> mapa) {
		String resultado = mapa.entrySet().stream()
				.map(m -> m.getKey() + " = " + m.getValue())
				.collect(Collectors.joining(","));
		
		return resultado;
	}
	
	public static void metodo3() {
		
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("personas.csv"));
			String row;
			csvReader.readLine();
			List<Persona> personas= new ArrayList<>();
			while ((row = csvReader.readLine()) != null) {
			    String[] data = row.split(",");
			    personas.add(new Persona(Integer.parseInt(data[0]),data[1],data[2],data[3],Integer.parseInt(data[4])));
			}
			csvReader.close();
			
			Map<Integer, Integer> mapa =  personas.stream()
					.filter(p -> p.getEdad() > 18)
					.collect(Collectors.toMap(Persona::getId, Persona::getEdad));
			
			Map<Integer, String> mapa2 =  personas.stream()
					.filter(p -> p.getApellido().charAt(0) == 'A' || p.getApellido().charAt(0) == 'C' )
					.collect(Collectors.toMap(Persona::getId, Persona::getApellido));
			System.out.println(mapa2);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
