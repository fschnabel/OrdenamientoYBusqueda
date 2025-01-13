package ejercicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import metodo.Ordenamiento;

public class OrdenamientoArchivo {

	private static final String SEPARADOR_DEFECTO = "\\|"; // Separador por defecto para los registros.
	private static OrdenamientoArchivo localInstance;

	public static OrdenamientoArchivo getInstance() {
		if (localInstance == null) {
			localInstance = new OrdenamientoArchivo();
		}
		return localInstance;
	}

	public class Empleado {
		String nombre;
		int numeroVenta;
		int anioAntiguedad;

		public Empleado(String nombre, int numeroVenta, int anioAntiguedad) {
			this.nombre = nombre;
			this.numeroVenta = numeroVenta;
			this.anioAntiguedad = anioAntiguedad;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getNumeroVenta() {
			return numeroVenta;
		}

		public void setNumeroVenta(int numeroVenta) {
			this.numeroVenta = numeroVenta;
		}

		public int getAnioAntiguedad() {
			return anioAntiguedad;
		}

		public void setAnioAntiguedad(int anioAntiguedad) {
			this.anioAntiguedad = anioAntiguedad;
		}
		
		@Override
		public String toString() {
			return String.format("%s|%d|%d", nombre, numeroVenta, anioAntiguedad);
		}
		
		
	}

	private static Empleado[] obtenerEmpleados() {
		try (BufferedReader br = new BufferedReader(new FileReader("empleados.txt"))) {
			Empleado[] listaEmpleado = new Empleado[50];
			String linea;
			int fila = 0;
			System.out.println("Contenido del archivo");
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
				String[] atributos = linea.split(SEPARADOR_DEFECTO);
				String nombre = atributos[0];
				int numeroVentas = Integer.parseInt(atributos[1]);
				int anioAntiguedad = Integer.parseInt(atributos[2]);
				listaEmpleado[fila] = getInstance().new Empleado(nombre, numeroVentas, anioAntiguedad);
				fila++;

			}
			return listaEmpleado;
		} catch (IOException e) {
			return null; // Retorna null en caso de error.
		}
	}
	
	public static void ordenarArchivo() {
		Empleado[] empleados = Ordenamiento.selectionSort(obtenerEmpleados());
		System.out.println("Contenido ordenado del archivo");
		for (Empleado iterador : empleados) {
			System.out.println(iterador);
		}
	}

}
