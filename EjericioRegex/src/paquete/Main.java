package paquete;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
	 * 6.11. Expresiones regulares II
	Desarrolla un programa Java que incluya métodos instanciables para realizar lo siguiente:
	
	1. Recibe una cadena de caracteres y devuelve true si la cadena es exactamente la palabra "true"
	
	2. Recibe una cadena de caracteres y devuelve true si la cadena es: "True", "true" o "TRUE"
	
	3. Recibe una cadena de caracteres y devuelve true la cadena contiene tres caracteres
	
	4. Recibe una cadena de caracteres y devuelve true si la cadena contiene algún carácter menos la "b"
	
	5. Recibe una cadena de caracteres y devuelve true si la cadena contiene un número menor de 200
 * @author Marina
 *
 */
public class Main {

	public static void main(String[] args) {
		String palabra = "200";
		
		if(funcion5(palabra)) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}

	}

	public static boolean funcion1(String palabra) {
		Pattern pat = Pattern.compile("True");
		Matcher mat = pat.matcher(palabra);
		
		if(mat.matches()) {
			return true;
		}
		return false;
	}
	
	public static boolean funcion2(String palabra) {
		Pattern pat = Pattern.compile("(true|True|TRUE)");
		Matcher mat = pat.matcher(palabra);
		
		if(mat.matches()) {
			return true;
		}
		return false;
	}
	
	public static boolean funcion3(String palabra) {
		Pattern pat = Pattern.compile(".{3}");
		Matcher mat = pat.matcher(palabra);
		
		if(mat.matches()) {
			return true;
		}
		return false;
	}
	
	public static boolean funcion4(String palabra) { //Como comprobar que una palabra no contiene una letra
		Pattern pat = Pattern.compile("[^b]");
		Matcher mat = pat.matcher(palabra);
		
		if(mat.matches()) {
			return true;
		}
		return false;
	}
	
	public static boolean funcion5(String palabra) {
		Pattern pat = Pattern.compile(".*[0-1][0-9][0-9].*");
		Matcher mat = pat.matcher(palabra);
		
		if(mat.matches()) {
			return true;
		}
		return false;
	}
}
