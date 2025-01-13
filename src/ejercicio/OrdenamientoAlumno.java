package ejercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import metodo.Ordenamiento;

public class OrdenamientoAlumno {

	private static OrdenamientoAlumno localInstance;

	public static OrdenamientoAlumno getInstance() {
		if (localInstance == null) {
			localInstance = new OrdenamientoAlumno();
		}
		return localInstance;
	}

	public class Alumno {
		String nombreAlumno;
		Materia[] materias;
		int notaMedia = -1;

		public Alumno(String nombreAlumno, Materia[] materias) {
			this.nombreAlumno = nombreAlumno;
			this.materias = materias;
		}

		public int notaMedia() {
			if (notaMedia < 0) {
				int notaTotal = 0;
				for (Materia iterador : materias) {
					notaTotal += iterador.nota;
				}
				notaMedia = notaTotal / materias.length;
			}
			return notaMedia;
		}

	}

	public class Materia {
		String nombreMateria;
		int nota;

		public Materia(String nombreMateria, int nota) {
			this.nombreMateria = nombreMateria;
			this.nota = nota;
		}
	}

	private static Alumno[] llenardatos() {
		String[] nombresAlumnos = { "Juan", "Ana", "Luis", "Marta", "Carlos", "Sofía", "Pedro", "María", "José",
				"Lucía", "Fernando", "Clara", "Andrés", "Elena", "Diego", "Paula", "Manuel", "Laura", "Álvaro",
				"Isabel" };

		String[] nombresMaterias = { "Matemáticas", "Ciencias", "Historia", "Literatura", "Geografía" };

		Random random = new Random();
		Alumno[] alumnos = new Alumno[nombresAlumnos.length];

		for (int i = 0; i < nombresAlumnos.length; i++) {
			Materia[] materias = new Materia[nombresMaterias.length];

			for (int j = 0; j < nombresMaterias.length; j++) {
				int nota = random.nextInt(100);
				materias[j] = getInstance().new Materia(nombresMaterias[j], nota);
			}

			alumnos[i] = getInstance().new Alumno(nombresAlumnos[i], materias);
		}

		return alumnos;
	}

	private static int notaMediaTotal(Alumno[] alumnos) {
		int notaTotal = 0;
		int totalNotas = 0;
		for (Alumno iteradorAlumno : alumnos) {
			for (Materia iteradorMateria : iteradorAlumno.materias) {
				notaTotal += iteradorMateria.nota;
				totalNotas++;
			}
		}
		return notaTotal / totalNotas;
	}

	private static Materia[] notaMediaPorMateria(Alumno[] alumnos) {
		List<Materia> materias = new ArrayList<Materia>();

		for (Alumno iteradorAlumno : alumnos) {
			for (Materia iteradorMateria : iteradorAlumno.materias) {
				Optional<Materia> materiaPromedio = materias.stream()
						.filter(p -> p.nombreMateria == iteradorMateria.nombreMateria).findFirst();
				if (materiaPromedio.isPresent()) {
					materiaPromedio.get().nota += iteradorMateria.nota;
				} else {
					materias.add(getInstance().new Materia(iteradorMateria.nombreMateria, iteradorMateria.nota));
				}

			}
		}

		for (Materia iterador : materias) {
			iterador.nota = iterador.nota / alumnos.length;
		}
		return materias.toArray(new Materia[0]);
	}

	public static void orderAlumno() {
		Alumno[] alumnos =  Ordenamiento.shell1(llenardatos());
		System.out.println("Promedio total:" + notaMediaTotal(alumnos));
		Materia[] materias = notaMediaPorMateria(alumnos);
		System.out.println("Promedio por materia");
		for (Materia iterador : materias) {
			System.out.println(iterador.nombreMateria + ":" + iterador.nota);
		}
		System.out.println("Promedio por alumno ordenado");
		for(Alumno iterador : alumnos) {
			System.out.println(iterador.nombreAlumno + ":" + iterador.notaMedia);
		}
	}

}
