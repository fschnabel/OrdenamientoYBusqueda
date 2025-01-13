package ejercicio;

import java.util.Random;

import metodo.Ordenamiento;

public class TiemposOrdenamiento {
	public static int NUMERO_ELEMENTOS = 10000000;

	public static void medirTiemposOrdenamiento() {
		int[] numerosAleatorios = new int[NUMERO_ELEMENTOS];
		Random random = new Random();
		for (int i = 0; i < NUMERO_ELEMENTOS; i++) {
			numerosAleatorios[i] = random.nextInt(10000000);
		}
		int[] numerosAOrdenar = new int[NUMERO_ELEMENTOS];
		System.arraycopy(numerosAleatorios, 0, numerosAOrdenar, 0, NUMERO_ELEMENTOS);
		System.out.println("Verificación tiempo de ejecución");
		System.out.println("metodo bubbleSort");
		Long tiempoAntes = System.currentTimeMillis();
		if (NUMERO_ELEMENTOS < 100000)
			Ordenamiento.bubbleSort(numerosAOrdenar.clone());
		System.out.printf("Total en milisegundo: %d\n", System.currentTimeMillis() - tiempoAntes);

		System.arraycopy(numerosAleatorios, 0, numerosAOrdenar, 0, NUMERO_ELEMENTOS);
		System.out.println("metodo insertionSort");
		tiempoAntes = System.currentTimeMillis();
		if (NUMERO_ELEMENTOS < 100000)
			Ordenamiento.insertionSort(numerosAOrdenar.clone());
		System.out.printf("Total en milisegundo: %d\n", System.currentTimeMillis() - tiempoAntes);

		System.arraycopy(numerosAleatorios, 0, numerosAOrdenar, 0, NUMERO_ELEMENTOS);
		System.out.println("metodo selectionSort");
		tiempoAntes = System.currentTimeMillis();
		if (NUMERO_ELEMENTOS < 100000)
			Ordenamiento.selectionSort(numerosAOrdenar.clone());
		System.out.printf("Total en milisegundo: %d\n", System.currentTimeMillis() - tiempoAntes);

		System.arraycopy(numerosAleatorios, 0, numerosAOrdenar, 0, NUMERO_ELEMENTOS);
		System.out.println("metodo mergeSort");
		tiempoAntes = System.currentTimeMillis();
		Ordenamiento.mergeSort(numerosAOrdenar.clone(), 0, NUMERO_ELEMENTOS - 1);
		System.out.printf("Total en milisegundo: %d\n", System.currentTimeMillis() - tiempoAntes);

		System.arraycopy(numerosAleatorios, 0, numerosAOrdenar, 0, NUMERO_ELEMENTOS);
		System.out.println("metodo shell");
		tiempoAntes = System.currentTimeMillis();
		Ordenamiento.shell(numerosAOrdenar.clone());
		System.out.printf("Total en milisegundo: %d\n", System.currentTimeMillis() - tiempoAntes);

		System.arraycopy(numerosAleatorios, 0, numerosAOrdenar, 0, NUMERO_ELEMENTOS);
		System.out.println("metodo shell1");
		tiempoAntes = System.currentTimeMillis();
		Ordenamiento.shell1(numerosAOrdenar.clone());
		System.out.printf("Total en milisegundo: %d\n", System.currentTimeMillis() - tiempoAntes);
		
		System.arraycopy(numerosAleatorios, 0, numerosAOrdenar, 0, NUMERO_ELEMENTOS);
		System.out.println("metodo radix Sort");
		tiempoAntes = System.currentTimeMillis();
		Ordenamiento.radixSort(numerosAOrdenar.clone());
		System.out.printf("Total en milisegundo: %d\n", System.currentTimeMillis() - tiempoAntes);
	}
}
