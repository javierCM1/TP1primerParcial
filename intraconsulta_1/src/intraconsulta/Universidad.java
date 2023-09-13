package intraconsulta;

import java.util.ArrayList;

public class Universidad {

	private ArrayList<Alumno> alumnos;
	private ArrayList<Materia> materias;
	private ArrayList<Profe> profes;
	private ArrayList<AsignacionCursoProfe> inscripcionesProfe;
	private ArrayList<AsignacionCursoAlumno> inscripcionesAlumnos;
	private ArrayList<Curso> cursos;
	private ArrayList<Aula> aulas;

	public Universidad(String nombre) {
		super();
		this.alumnos = new ArrayList<>();
		this.materias = new ArrayList<>();
		this.profes = new ArrayList<>();
		this.inscripcionesProfe = new ArrayList<>();
		this.inscripcionesAlumnos = new ArrayList<>();
		this.cursos = new ArrayList<>();
		this.aulas = new ArrayList<>();

	}

	public boolean registrarAlumno(Alumno alumno) {

		return alumnos.add(alumno);
	}

	public boolean registrarProfesor(Profe profe) {
		return profes.add(profe);
	}

	public boolean registrarMateria(Materia materia) {
		return materias.add(materia);
	}

	public boolean crearCurso(Curso curso) {
		curso.getAula().setDisponible(false);
		return cursos.add(curso);
	}

	public Alumno buscarAlumnoPorDNI(Integer dni) {

		for (Alumno alumno : alumnos) {
			if (alumno.getDni().equals(dni)) {
				return alumno;
			}
		}
		return null;
	}

	public Materia buscarMateria(Integer codigo) {

		for (Materia materia : materias) {
			if (materia.getCodigoMateria().equals(codigo)) {
				return materia;
			}
		}
		return null;
	}

	public Curso buscarCursoPorCodigoDeMateria(Integer idMateria) {

		for (Curso curso : cursos) {
			if (curso.getMateria().getCodigoMateria().equals(idMateria)) {
				return curso;
			}
		}
		return null;
	}

	public Profe buscarProfePorDNI(Integer dni) {

		for (Profe profe : profes) {
			if (profe.getDni().equals(dni)) {
				return profe;
			}
		}
		return null;
	}

	public boolean inscripcionMateriaAlumno(Integer dni, Integer codigoDeMateria) {

		Alumno alumno = buscarAlumnoPorDNI(dni);
		Curso curso = buscarCursoPorCodigoDeMateria(codigoDeMateria);

		if (alumno != null && curso != null) {
			AsignacionCursoAlumno inscripcion = new AsignacionCursoAlumno(alumno, curso);
			return inscripcionesAlumnos.add(inscripcion);
		}

		return false;

	}

	public void imprimirAlumno() {
		boolean alumnosRegistrado = false;
		for (Alumno alumno : alumnos) {
			System.out.println("nombre: " + alumno.getNombre());
			System.out.println("apellido: " + alumno.getApellido());
			System.out.println("dni: " + alumno.getDni());
			alumnosRegistrado = true;
		}

		if (!alumnosRegistrado) {
			System.out.println("No hay alumnos registrados.");
		}
	}

	public void imprimirAulasDisponibles() {

		boolean aulasDisponibles = false;
		for (Aula aula : aulas) {
			if (aula.isDisponible()) {
				System.out.println("Numero de aula: " + aula.getNroAula());
				System.out.println("Capasidad: " + aula.getCapasidad());
				System.out.println();
				aulasDisponibles = true;
			}
		}

		if (!aulasDisponibles) {
			System.out.println("No hay aulas disponibles.");
		}
	}

	public void imprimirMaterias() {
		for (Materia materia : materias) {
			System.out.println("codigo de materia: " + materia.getCodigoMateria());
			System.out.println("nombre: " + materia.getNombre());
			System.out.println();
		}
	}

}
