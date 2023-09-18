package universidad;

import java.util.ArrayList;

public class Universidad {

	private ArrayList<Alumno> alumnos;
	private ArrayList<Materia> materias;
	private ArrayList<Profe> profes;
	private ArrayList<AsignacionCursoProfe> inscripcionesProfe;
	private ArrayList<AsignacionCursoAlumno> inscripcionesAlumnos;
	private ArrayList<Curso> cursos;
	private ArrayList<Aula> aulas;
	private ArrayList<CicloLectivo> ciclosLectivos;

	public Universidad(String nombre) {
		super();
		this.alumnos = new ArrayList<>();
		this.materias = new ArrayList<>();
		this.profes = new ArrayList<>();
		this.inscripcionesProfe = new ArrayList<>();
		this.inscripcionesAlumnos = new ArrayList<>();
		this.cursos = new ArrayList<>();
		this.aulas = new ArrayList<>();
		this.ciclosLectivos = new ArrayList<>();

	}

	public boolean agregarMaterias(Materia materia) {

		for (Materia materiaExistente : materias) {
			if (materiaExistente.getNombre().equals(materia.getNombre())) {
				return false;
			}
		}
		return materias.add(materia);
	}

	public boolean agregarAlumnos(Alumno alumno) {

		for (Alumno alumno1 : alumnos) {
			if (alumno1.getDni() == alumno.getDni()) {
				return false;
			}
		}
		return alumnos.add(alumno);
	}

	public boolean crearCicloLectivo(CicloLectivo ciclo) {
		for (CicloLectivo ciclo1 : ciclosLectivos) {
			if (ciclo1.getId() == ciclo.getId()) {
				return false;
			}
		}
		return ciclosLectivos.add(ciclo);
	}

	public boolean crearCurso(Curso curso) {
		for (Curso curso1 : cursos) {
			if (curso1.getMateria().getCodigoMateria().equals(curso.getMateria().getCodigoMateria())
					&& curso1.getCiclo().getId().equals(curso.getCiclo().getId())
					&& curso1.getTurno().equals(curso.getTurno())) {
				return false;
			}
		}

		return cursos.add(curso);
	}

	public boolean crearDocentes(Profe profe) {

		for (Profe profe1 : profes) {
			if (profe1.getDni().equals(profe.getDni())) {
				return false;
			}
		}
		return profes.add(profe);
	}

	public boolean AsiganarMateriaCorrelativa(Integer codigoMateria, Integer codigoDeMateriaCorrelativa) {

		Materia materiaPrincipal = buscarMateria(codigoMateria);
		Materia materiaCorrelativa = buscarMateria(codigoDeMateriaCorrelativa);

		if (materiaPrincipal == null || materiaCorrelativa == null) {
			return false;
		}
		return materiaPrincipal.agregarMateriaCorrelativa(materiaCorrelativa);
	}

	public boolean EliminarCorrelativa(Integer codigoMateria, Integer codigoCorrelativaAELiminar) {
		Materia materiaPrincipal = buscarMateria(codigoMateria);

		if (materiaPrincipal == null) {
			return false;
		}

		Materia materiaCorrelativaAEliminar = materiaPrincipal.buscarMateriaCorrelativa(codigoCorrelativaAELiminar);

		if (materiaCorrelativaAEliminar == null) {
			return false;
		}

		return materiaPrincipal.eliminarMateria(materiaCorrelativaAEliminar);
	}

	/*
	 * public boolean InscribirAlumnoACurso(Integer dni, Integer codigoCurso) {
	 * 
	 * }
	 */
	public boolean asignarProfesoresALCurso(Integer idCurso, Integer dniDocente) {

		Profe profe = buscarProfePorDNI(dniDocente);

		if (profe == null) {
			return false;
		}

		Curso curso = buscarCursoPorid(idCurso);

		if (curso == null) {
			return false;
		}

		Integer numeroAlumnos = curso.getCantidadDeAlumnos();

		Integer profesoresNecesarios = numeroAlumnos / 20;

		if (numeroAlumnos % 20 != 0) {
			profesoresNecesarios++;
		}

		if (profesoresNecesarios >= 1) {
			AsignacionCursoProfe asignacion = new AsignacionCursoProfe(profe, curso);
			inscripcionesProfe.add(asignacion);
			return true;
		}
		
		
		return false;
	}

	public Alumno buscarAlumnoPorDNI(Integer dni) {

		for (Alumno alumno : alumnos) {
			if (alumno.getDni().equals(dni)) {
				return alumno;
			}
		}
		return null;
	}
	
	public AsignacionCursoProfe buscarAsignacionprofe(Integer idCurso) {
		
		for (AsignacionCursoProfe asignar : inscripcionesProfe) {
			if(asignar.getCurso().getIdCurso().equals(idCurso)) {
				return asignar;
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

	public Curso buscarCursoPorid(Integer idCurso) {

		for (Curso curso : cursos) {
			if (curso.getIdCurso().equals(idCurso)) {
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

	public ArrayList<CicloLectivo> getCiclosLectivos() {
		return ciclosLectivos;
	}

	public void setCiclosLectivos(ArrayList<CicloLectivo> ciclosLectivos) {
		this.ciclosLectivos = ciclosLectivos;
	}

}
