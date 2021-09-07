package serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * 7.5. Empleados de una empresa: serialización I
	Desarrollar una aplicación para almacenar objetos en un fichero personalizando el mecanismo de la serialización. El modelo de objetos a guardar estará representado por las siguientes relaciones:
	
	Disponemos de dos departamentos de una empresa.
	
	El primer departamento está formado por tres empleados, uno de ellos es director y los otros dos son secreatarios de este último.
	
	El segundo departamento estará formado por otros tres empleados. Uno de ellos es director y tiene como secretario a uno de los dos empleados.
	
	Se desea evitar la serialización en los objetos de la clase Departamento, ya que esta clase sólo mantendrá el nombre del mismo.
 * @author Marina
 *
 */
public class Main {

	public static void main(String[] args) {
		Departamento d1 = new Departamento("RRHH");
		Departamento d2 = new Departamento("Finanzas");

		Empleado emp1 = new Empleado("Juan", 500, d1);
		Empleado emp2 = new Empleado("Juanjo", 600, d1);
		ArrayList<Empleado> secretariosdir1 = new ArrayList<>();
		secretariosdir1.add(emp1);
		secretariosdir1.add(emp2);
		Director dir1 = new Director("Leire", 1000, d1, secretariosdir1);

		Empleado[] grupo1 = new Empleado[3];
		grupo1[0] = dir1;
		grupo1[1] = emp1;
		grupo1[2] = emp2;

		Empleado emp3 = new Empleado("Mari", 500, d2);
		Empleado emp4 = new Empleado("Jorge", 600, d2);
		ArrayList<Empleado> secretariosdir2 = new ArrayList<>();
		secretariosdir2.add(emp3);
		Director dir2 = new Director("Marina", 1000, d2, secretariosdir2);

		Empleado[] grupo2 = new Empleado[3];
		grupo2[0] = dir2;
		grupo2[1] = emp3;
		grupo2[2] = emp4;
		
		
		ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(new FileOutputStream("empleados.dat"));
			out.writeObject(grupo1);
			out.writeObject(grupo2);
			out.close();
			
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("empleados.dat"));
			Empleado[] resultado = (Empleado[])in.readObject();

			Empleado[] resultado2 = (Empleado[])in.readObject();
			in.close();
		
		
			for(Empleado i:resultado) {
				System.out.println(i.toString());
			}
			for(Empleado i:resultado2) {
				System.out.println(i.toString());
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
