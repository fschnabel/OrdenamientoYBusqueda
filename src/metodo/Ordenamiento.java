// Implentado por: Vinicio Changoluisa P.
// Diciembre 2023
package metodo;

import ejercicio.OrdenamientoAlumno.Alumno;
import ejercicio.OrdenamientoArchivo.Empleado;

public class Ordenamiento {

	// método de ordenamiento por inserción
	public static int[] insertionSort(int[] arrayA) {
		int i, j, aux;
		for (i = 1; i < arrayA.length; i++) {
			j = i;
			aux = arrayA[i];
			while (j > 0 && aux < arrayA[j - 1]) {
				arrayA[j] = arrayA[j - 1];
				j--;
			}
			arrayA[j] = aux;
		}
		return arrayA;
	}

	// Se agrega implementación de metodo para manejar con la primera letra
	public static String[] insertionSort(String[] arrayA) {
		int i, j;
		String aux;
		for (i = 1; i < arrayA.length; i++) {
			j = i;
			aux = arrayA[i];
			while (j > 0 && aux.charAt(0) < arrayA[j - 1].charAt(0)) {
				arrayA[j] = arrayA[j - 1];
				j--;
			}
			arrayA[j] = aux;
		}
		return arrayA;
	}

	// método de ordenamiento por selección
	public static int[] selectionSort(int[] arrayA) {
		int i, j, n, indiceMenor, aux;
		n = arrayA.length;
		for (i = 0; i < n - 1; i++) {
			indiceMenor = i;
			for (j = i; j < n; j++) {
				if (arrayA[j] <= arrayA[indiceMenor])
					indiceMenor = j;

			}
			if (i != indiceMenor) {
				aux = arrayA[i];
				arrayA[i] = arrayA[indiceMenor];
				arrayA[indiceMenor] = aux;
			}

		}
		return arrayA;
	}

	// método de ordenamiento por selección
	public static Empleado[] selectionSort(Empleado[] arrayA) {
		int i, j, n, indiceMayor;
		Empleado aux;
		n = arrayA.length;
		for (i = 0; i < n - 1; i++) {
			indiceMayor = i;
			for (j = i; j < n; j++) {
				if (arrayA[j].getNumeroVenta() >= arrayA[indiceMayor].getNumeroVenta())
					indiceMayor = j;

			}
			if (i != indiceMayor) {
				aux = arrayA[i];
				arrayA[i] = arrayA[indiceMayor];
				arrayA[indiceMayor] = aux;
			}

		}
		return arrayA;
	}

	// método de ordenamiento por burbuja
	public static int[] bubbleSort(int[] arrayA) {
		int i, j, aux;
		for (i = 0; i < arrayA.length - 1; i++) {
			for (j = 0; j < arrayA.length - i - 1; j++) {
				if (arrayA[j + 1] < arrayA[j]) {
					aux = arrayA[j + 1];
					arrayA[j + 1] = arrayA[j];
					arrayA[j] = aux;
				}
			}
		}
		return arrayA;
	}

	// ======================================================0
	// Algoritmos de ordenación eficiente
	// ======================================================0

	public static int[] merge(int arr[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0, k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
		return arr;
	}

	public static int[] mergeSort(int arr[], int l, int r) {
		int[] myarray = {};
		if (l < r) {
			int m = 0;
			m = l + (r - l) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);
			myarray = merge(arr, l, m, r);
		}
		return myarray;
	}

	public static int[] shell1(int A[]) {
		int salto, aux, i;
		boolean cambios;

		for (salto = A.length / 2; salto != 0; salto /= 2) {
			cambios = true;
			while (cambios) {
				cambios = false;
				for (i = salto; i < A.length; i++) {
					if (A[i - salto] > A[i]) {
						aux = A[i];
						A[i] = A[i - salto];
						A[i - salto] = aux;
						cambios = true;
					}
				}
			}
		}
		return A;
	}
	
	
	public static Alumno[] shell1(Alumno A[]) {
		int salto,  i;
		boolean cambios;
		Alumno aux;

		for (salto = A.length / 2; salto != 0; salto /= 2) {
			cambios = true;
			while (cambios) {
				cambios = false;
				for (i = salto; i < A.length; i++) {
					if (A[i - salto].notaMedia() > A[i].notaMedia()) {
						aux = A[i];
						A[i] = A[i - salto];
						A[i - salto] = aux;
						cambios = true;
					}
				}
			}
		}
		return A;
	}

	public static int[] shell(int A[]) {
		int aux = 0, j;
		for (int gap = A.length / 2; gap > 0; gap = gap == 2 ? 1 : (int) (gap / 2)) {
			for (int i = gap; i < A.length; i++) {
				aux = A[i];
				j = i;
				for (; j >= gap && A[j - gap] > aux; j -= gap) {
					A[j] = A[j - gap];
				}
				A[j] = aux;
			}
		}
		return A;
	}
	
	
	// Método de ordenamiento Radix Sort
    public static int[] radixSort(int[] array) {
        int max = getMax(array);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            array = countingSortByDigit(array, exp);
        }
        return array;
    }

    // Encuentra el máximo valor en el array
    private static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Ordena los números por dígitos usando Counting Sort
    private static int[] countingSortByDigit(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // Cuenta las ocurrencias de cada dígito
        for (int i = 0; i < n; i++) {
            count[Math.abs(array[i] / exp) % 10]++;
        }

        // Actualiza los índices en el array de conteo
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        // Construye el array ordenado
        for (int i = n - 1; i >= 0; i--) {
            int digit = Math.abs(array[i] / exp) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }

        return output;
    }
    
 // Método de ordenamiento por inserción para matrices (por filas)
    public static int[][] insertionSortRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                int key = matrix[i][j];
                int k = j - 1;
                while (k >= 0 && matrix[i][k] > key) {
                    matrix[i][k + 1] = matrix[i][k];
                    k--;
                }
                matrix[i][k + 1] = key;
            }
        }
        return matrix;
    }

    // Método de ordenamiento por inserción para matrices (por columnas)
    public static int[][] insertionSortCols(int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 1; i < matrix.length; i++) {
                int key = matrix[i][j];
                int k = i - 1;
                while (k >= 0 && matrix[k][j] > key) {
                    matrix[k + 1][j] = matrix[k][j];
                    k--;
                }
                matrix[k + 1][j] = key;
            }
        }
        return matrix;
    }

    // Método de ordenamiento por selección para matrices (por filas)
    public static int[][] selectionSortRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int minIdx = j;
                for (int k = j + 1; k < matrix[i].length; k++) {
                    if (matrix[i][k] < matrix[i][minIdx]) {
                        minIdx = k;
                    }
                }
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][minIdx];
                matrix[i][minIdx] = temp;
            }
        }
        return matrix;
    }

    // Método de ordenamiento por burbuja para matrices (por filas)
    public static int[][] bubbleSortRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                for (int k = 0; k < matrix[i].length - j - 1; k++) {
                    if (matrix[i][k] > matrix[i][k + 1]) {
                        int temp = matrix[i][k];
                        matrix[i][k] = matrix[i][k + 1];
                        matrix[i][k + 1] = temp;
                    }
                }
            }
        }
        return matrix;
    }
    
    // Método de ordenamiento Shell Sort para matrices (por filas)
    public static int[][] shellSortRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int gap = matrix[i].length / 2; gap > 0; gap /= 2) {
                for (int j = gap; j < matrix[i].length; j++) {
                    int temp = matrix[i][j];
                    int k;
                    for (k = j; k >= gap && matrix[i][k - gap] > temp; k -= gap) {
                        matrix[i][k] = matrix[i][k - gap];
                    }
                    matrix[i][k] = temp;
                }
            }
        }
        return matrix;
    }

    // Método de ordenamiento Radix Sort para matrices (por filas)
    public static int[][] radixSortRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = radixSort(matrix[i]);
        }
        return matrix;
    }
    
 

   

}
