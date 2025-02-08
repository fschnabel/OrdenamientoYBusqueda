package principal;

import java.util.Random;

import metodo.Busqueda;
import metodo.Ordenamiento;

public class Complejidad {
	public static void main(String[] args) {
        int[][] matriz = generarMatriz(1000, 1000);
        int x = matriz[new Random().nextInt(1000)][new Random().nextInt(1000)];
        int negX = -x;
        
        System.out.println("Buscando: " + x + " y " + negX);
        
        // Búsqueda Secuencial
        long start = System.nanoTime();
        Busqueda.busquedaSecuencial(matriz, x);
        Busqueda.busquedaSecuencial(matriz, negX);
        long end = System.nanoTime();
        System.out.println("Tiempo de Búsqueda Secuencial: " + (end - start) / 1e6 + " ms");
        
        // Búsqueda Binaria (requiere matriz ordenada)
        start = System.nanoTime();
        Busqueda.busquedaBinaria(matriz, x);
        Busqueda.busquedaBinaria(matriz, negX);
        end = System.nanoTime();
        System.out.println("Tiempo de Búsqueda Binaria: " + (end - start) / 1e6 + " ms");
        
        // Ordenación con Merge Sort
        start = System.nanoTime();
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = Ordenamiento.mergeSort(matriz[i], 0, matriz[i].length - 1);
        }
        end = System.nanoTime();
        System.out.println("Matriz ordenada por filas con Merge Sort en " + (end - start) / 1e6 + " ms");
        
        // Aplicar otros métodos de ordenación
        start = System.nanoTime();
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = Ordenamiento.bubbleSort(matriz[i]);
        }
        end = System.nanoTime();
        System.out.println("Matriz ordenada por filas con Bubble Sort en " + (end - start) / 1e6 + " ms");
        
        start = System.nanoTime();
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = Ordenamiento.insertionSort(matriz[i]);
        }
        end = System.nanoTime();
        System.out.println("Matriz ordenada por filas con Insertion Sort en " + (end - start) / 1e6 + " ms");
        
        start = System.nanoTime();
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = Ordenamiento.shell(matriz[i]);
        }
        end = System.nanoTime();
        System.out.println("Matriz ordenada por filas con Shell Sort en " + (end - start) / 1e6 + " ms");
        
        start = System.nanoTime();
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = Ordenamiento.radixSort(matriz[i]);
        }
        end = System.nanoTime();
        System.out.println("Matriz ordenada por filas con Radix Sort en " + (end - start) / 1e6 + " ms");
        
        
    }

    // Método para generar una matriz con números aleatorios
    public static int[][] generarMatriz(int filas, int columnas) {
        Random rand = new Random();
        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = rand.nextInt(2000) - 1000; // Números entre -1000 y 1000
            }
        }
        return matriz;
    }
}
