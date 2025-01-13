
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

}
