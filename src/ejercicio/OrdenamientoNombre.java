package ejercicio;

import metodo.Ordenamiento;

public class OrdenamientoNombre {
	
	public static String[] NOMBRES = {
		    "Andrea", "Carlos", "María", "Jorge", "Luis", 
		    "Sofía", "Pedro", "Gabriela", "Fernando", "Alberto", 
		    "Daniel", "Camila", "Francisco", "Valeria", "Juan", 
		    "Paula", "Sebastián", "Diana", "Ricardo", "Lucía"
		};

	
	public static void ordenamientoPorNombre() {
		System.out.println("Lista nombres a ordenar por la primera letra");
		for (String iterador : NOMBRES) {
			System.out.println(iterador);
		}
		String[] nombresClonar = NOMBRES.clone();
		String[] nombresOrdenados = Ordenamiento.insertionSort(nombresClonar);
		System.out.println("Lista nombres ordenados por la primera letra");
		for (String iterador : nombresOrdenados) {
			System.out.println(iterador);
		}
	}

}
