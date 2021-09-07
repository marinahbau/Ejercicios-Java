package ejercicioRepasoLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
 
/**
 * Construir una clase para representar vehículos con los siguientes parámetros: matrícula, modelo, y kilometros recorridos.
	El campo modelo pertenece a un enum Modelo con las siguientes marcas: audi, bmw, opel, honda, citroen.
	Construye sus getters, setters y toString
	
	-Crea un main con un vector de vehiculos, tipo List<Vehiculos> y añade varios vehiculos.
	
		- Implementa los siguientes métodos:
			○ public List<Integer> velocidad(List<Vehiculo> vehiculos), este metodo nos debe permitir obtener una lista SOLO con la velocidad de los vehiculos, esta puede ser dada en metros, centimetros o kilometros (considerar cambios en la cabecera de la función)
			○ public void modelo(List<Vehiculo> vehiculos, String modelo), que nos muestre una lista con los vehiculos que existen con esa marca y el numero de vehiculos de esa marca en total
			○ public List<Vehiculo> ordenarPor(List<Vehiculo> vehiculos), que ordene los vehiculos según uno de los campos, hacer una función para cada uno de los campos: matricula, modelo y kilometros
			○ public List<Vehiculo> distintosSegunModelo(List<Vehiculo> vehiculos), lista de SOLO marcas que hay entre los vehiculos
			- Public void matricula(List<Vehiculo> vehiculos), devuelve la matricula que este primero en orden alfabetico.
 * @author Marina
 *
 */
public class Main {
 
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("1111AAA", Modelo.BMW, 10000));
        vehiculos.add(new Vehiculo("2222BBB", Modelo.AUDI, 20000));
        vehiculos.add(new Vehiculo("3333CCC", Modelo.OPEL, 30000));
        vehiculos.add(new Vehiculo("4444DDD", Modelo.BMW, 100000));
        vehiculos.add(new Vehiculo("5555EEE", Modelo.AUDI, 200000));
        vehiculos.add(new Vehiculo("6666FFF", Modelo.OPEL, 300000));
        vehiculos.add(new Vehiculo("7777GGG", Modelo.CITROEN, 0));
    }
    
    public List<Integer> kilometros(List<Vehiculo> vehiculos){ //TODO EN UNO
    	List<Integer> result = vehiculos.stream()
    	        .map(v -> v.getKilometros()*2)
    	        .collect(Collectors.toList());
		return result;
    }
 
    public List<Integer> metros(List<Vehiculo> vehiculos){
		return null;
    	//TODO
    }
    public List<Integer> centimetros(List<Vehiculo> vehiculos){
		return null;
    	//TODO
    }
    
    public List<Vehiculo> modelo(List<Vehiculo> vehiculos, String modelo){
    	List<Vehiculo> result = vehiculos.stream()
    	        .filter(v -> v.getModelo().equals(modelo))
    	        .collect(Collectors.toList());
		return result;
    }
    
    public List<Vehiculo> ordenar(List<Vehiculo> vehiculos, String parametro){
    	switch(parametro) {
    	case "kilometro": //Mejor un metodo para cada uno
    		List<Vehiculo> result = vehiculos.stream()
            .sorted((v1, v2) -> Integer.compare(v1.getKilometros(), v2.getKilometros()))
            .collect(Collectors.toList());
    		break;
    	}
    }
    //Lista de diferentes marcas en los vehiculos existentes
    public List<Vehiculo> distintosSegunModelo(List<Vehiculo> vehiculos){
    	 List<Modelo> result = vehiculos.stream()
    	         .map(Vehiculo::getModelo)
    	         .distinct()
    	         .collect(Collectors.toList());
    	 return result;
    	
    }
    
    
}