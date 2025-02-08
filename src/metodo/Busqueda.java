
//Implentado por: Vinicio Changoluisa
//Diciembre 2023

package metodo;

public class Busqueda {

	public static int busquedaSecuencial(int elementos[], int x) {
		System.out.print("Busqueda Sencuencial ");
		int iteraciones = 0;
		for (int i = 0; i < elementos.length; i++) {
			iteraciones++;
			if (elementos[i] == x) {
				System.out.printf("Se encontro el elemento en el indice %d, comparaciones: %d \n", i, iteraciones);
				return i;
			}
		}
		System.out.printf("No se encontro el elemento en el indice %d, comparaciones: %d \n", -1, iteraciones);
		return -1;
	}

	public static int busquedaBinaria(int elementos[], int x) {
		System.out.print("Busqueda Binaria ");
		int l = 0, r = elementos.length - 1, m;
		int iteraciones = 0;
		while (l <= r) {
			iteraciones++;
			m = l + (r - l) / 2;
			if (elementos[m] == x) {
				System.out.printf("Se encontro el elemento en el indice %d, comparaciones: %d \n", m, iteraciones);
				return m;
			}
			if (elementos[m] < x)
				l = m + 1;
			else
				r = m - 1;
		}
		System.out.printf("No se encontro el elemento en el indice %d, comparaciones: %d \n", -1, iteraciones);
		return -1;
	}

	public static int busquedaInterpolacion(int[] array, int key) {
		System.out.print("Busqueda Interpolación ");
		int low = 0;
        int high = array.length - 1;
        int iteraciones = 0;

        while (low <= high && key >= array[low] && key <= array[high]) {
        	iteraciones++;
            // Evitar división por cero
            if (array[high] == array[low]) {
                if (array[low] == key) {
                    return low; // Elemento encontrado
                } else {
                    break; // No se puede continuar la interpolación
                }
            }

            // Calcular la posición estimada utilizando interpolación
            int pos = low + ((key - array[low]) * (high - low)) / (array[high] - array[low]);

            // Verificar si la posición calculada está dentro de los límites del arreglo
            if (pos < low || pos > high) {
                break; // Salir del bucle si la posición está fuera de rango
            }

            // Verificar si el elemento en la posición estimada es el buscado
            if (array[pos] == key) {
				System.out.printf("Se encontro el elemento en el indice %d, comparaciones: %d \n", pos, iteraciones);
                return pos; // Elemento encontrado
            }

            // Si el elemento buscado es mayor, buscar en la parte superior
            if (array[pos] < key) {
                low = pos + 1;
            }
            // Si el elemento buscado es menor, buscar en la parte inferior
            else {
                high = pos - 1;
            }
        }
		System.out.printf("No se encontro el elemento en el indice %d, comparaciones: %d \n", -1, iteraciones);

        return -1; // Elemento no encontrado
	}
	
	// Búsqueda Secuencial en Matriz
    public static int[] busquedaSecuencial(int[][] matriz, int x) {
        System.out.print("Busqueda Secuencial en Matriz ");
        int iteraciones = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                iteraciones++;
                if (matriz[i][j] == x) {
                    System.out.printf("Se encontro el elemento en la posicion [%d, %d], comparaciones: %d \n", i, j, iteraciones);
                    return new int[]{i, j};
                }
            }
        }
        System.out.printf("No se encontro el elemento, comparaciones: %d \n", iteraciones);
        return new int[]{-1, -1};
    }

    // Búsqueda Binaria en Matriz Ordenada
    public static int[] busquedaBinaria(int[][] matriz, int x) {
        System.out.print("Busqueda Binaria en Matriz ");
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int izquierda = 0, derecha = filas * columnas - 1;
        int iteraciones = 0;

        while (izquierda <= derecha) {
            iteraciones++;
            int medio = izquierda + (derecha - izquierda) / 2;
            int fila = medio / columnas;
            int columna = medio % columnas;

            if (matriz[fila][columna] == x) {
                System.out.printf("Se encontro el elemento en la posicion [%d, %d], comparaciones: %d \n", fila, columna, iteraciones);
                return new int[]{fila, columna};
            }

            if (matriz[fila][columna] < x) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        System.out.printf("No se encontro el elemento, comparaciones: %d \n", iteraciones);
        return new int[]{-1, -1};
    }

    // Búsqueda en Matriz Ordenada por Interpolación (Aproximada)
    public static int[] busquedaInterpolacion(int[][] matriz, int x) {
        System.out.print("Busqueda Interpolación en Matriz ");
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int inicio = 0, fin = filas * columnas - 1;
        int iteraciones = 0;

        while (inicio <= fin) {
            iteraciones++;
            if (matriz[fin / columnas][fin % columnas] == matriz[inicio / columnas][inicio % columnas]) {
                if (matriz[inicio / columnas][inicio % columnas] == x) {
                    return new int[]{inicio / columnas, inicio % columnas};
                } else {
                    break;
                }
            }

            int pos = inicio + ((x - matriz[inicio / columnas][inicio % columnas]) * (fin - inicio)) /
                    (matriz[fin / columnas][fin % columnas] - matriz[inicio / columnas][inicio % columnas]);

            if (pos < inicio || pos > fin) break;

            int fila = pos / columnas;
            int columna = pos % columnas;

            if (matriz[fila][columna] == x) {
                System.out.printf("Se encontro el elemento en la posicion [%d, %d], comparaciones: %d \n", fila, columna, iteraciones);
                return new int[]{fila, columna};
            }

            if (matriz[fila][columna] < x) {
                inicio = pos + 1;
            } else {
                fin = pos - 1;
            }
        }

        System.out.printf("No se encontro el elemento, comparaciones: %d \n", iteraciones);
        return new int[]{-1, -1};
    }

}
