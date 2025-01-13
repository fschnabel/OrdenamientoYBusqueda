package principal;

import java.util.Random;
import java.util.Scanner;

import ejercicio.OrdenamientoAlumno;
import ejercicio.OrdenamientoArchivo;
import ejercicio.OrdenamientoNombre;
import ejercicio.TiemposOrdenamiento;
import metodo.Busqueda;
import metodo.Ordenamiento;

public class Principal {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar menú
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Ordenamiento alfabético de nombres");
            System.out.println("2. Medir tiempos de ejecución de algoritmos de ordenamiento");
            System.out.println("3. Ordenar empleados por ventas");
            System.out.println("4. Calcular y ordenar medias de alumnos");
            System.out.println("5. Explicación de algoritmos de ordenamiento");
            System.out.println("6. Comparación de algoritmos de búsqueda");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            // Leer opción
            opcion = scanner.nextInt();

            // Procesar opción
            switch (opcion) {
                case 1:
                    System.out.println("Ejecutando ordenamiento alfabético de nombres...");
                    OrdenamientoNombre.ordenamientoPorNombre();
                    break;
                case 2:
                    System.out.println("Midiendo tiempos de ejecución...");
                    // Llamar al método correspondiente
                    TiemposOrdenamiento.medirTiemposOrdenamiento();
                    break;
                case 3:
                    System.out.println("Ordenando empleados por ventas...");
                    // Llamar al método correspondiente
                    OrdenamientoArchivo.ordenarArchivo();
                    break;
                case 4:
                    System.out.println("Calculando y ordenando medias de alumnos...");
                    // Llamar al método correspondiente
                    OrdenamientoAlumno.orderAlumno();
                    break;
                case 5:
                    System.out.println("Comparando algoritmos de búsqueda arreglo pequeño...");
                    int[] A= {1,2,3,10,50,100,500,1000,10000};
                    Busqueda.busquedaBinaria(A, 3);
                    Busqueda.busquedaSecuencial(A, 3);
                    Busqueda.busquedaInterpolacion(A, 3);
                    Busqueda.busquedaBinaria(A, 500);
                    Busqueda.busquedaSecuencial(A, 500);
                    Busqueda.busquedaInterpolacion(A, 500);
                    Busqueda.busquedaBinaria(A, 900);
                    Busqueda.busquedaSecuencial(A, 900);
                    Busqueda.busquedaInterpolacion(A, 900);

                    break;
                case 6:
                    System.out.println("Comparando algoritmos de búsqueda arreglo grande...");
                    int[] arreglo =Ordenamiento.shell1(generarArregloAleatorio(1000000, 1, 1000000));
                    Busqueda.busquedaSecuencial(arreglo, 500000);
                    Busqueda.busquedaBinaria(arreglo, 500000);
                    Busqueda.busquedaInterpolacion(arreglo, 500000);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida, por favor intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
	
	public static int[] generarArregloAleatorio(int tamano, int min, int max) {
        int[] arreglo = new int[tamano];
        Random random = new Random();

        for (int i = 0; i < tamano; i++) {
            arreglo[i] = i + 1; // Genera números entre min y max
        }

        return arreglo;
    }
}
