package universidad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

	public boolean agregarProfesores(Profe profe) {

		for (Profe profe1 : profes) {
			if (profe1.getDni() == profe.getDni()) {
				return false;
			}
		}
		return profes.add(profe);
	}

	public boolean crearCurso(Curso curso) {
		for (Curso cursoExistente : cursos) {
			if (cursoExistente.getMateria().getCodigoMateria() == curso.getMateria().getCodigoMateria()
					&& cursoExistente.getCiclo().getId() == curso.getCiclo().getId()
					&& cursoExistente.getTurno().equals(curso.getTurno())) {
				return false;
			}
		}

		return cursos.add(curso);
	}

	public boolean crearCicloLectivo(CicloLectivo ciclo) {
		LocalDate inicioCiclo = ciclo.getFechaInicioCicloLectivo();
		LocalDate finInscripcion = ciclo.getFechaFinalizacionInscripcion();

		if (finInscripcion.isAfter(inicioCiclo) || finInscripcion.isEqual(inicioCiclo)) {
			return false;
		}
		return ciclosLectivos.add(ciclo);
	}

	public boolean asiganarMateriaCorrelativa(Integer codigoMateria, Integer codigoDeMateriaCorrelativa) {

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

	public boolean InscribirAlumnoACurso(Integer dni, Integer codigoCurso) {

		// valida si el alumno y curso exista
		Alumno alumno = buscarAlumnoPorDNI(dni);
		Curso curso = buscarCursoPorid(codigoCurso);

		if (alumno == null || curso == null) {
			return false;
		}

		// valida que que no se pueda inscrivir a la misma materia con mismo ciclo
		// lectivo
		for (AsignacionCursoAlumno asignacion : inscripcionesAlumnos) {
			if (asignacion.getAlumno().getDni().equals(dni) && asignacion.getCurso().getIdCurso().equals(codigoCurso)
					&& asignacion.getCurso().getCiclo().getId().equals(curso.getCiclo().getId())) {
				return false;
			}
		}
		// valida si la inscripcion se hace dentro de la fecha correspondiente

		LocalDate fechaDeInscripcion = LocalDate.now();
		LocalDate fechaDeInicio = curso.getCiclo().getFechaInicioInscripcion();
		LocalDate fechaDeFinalizacion = curso.getCiclo().getFechaFinalizacionInscripcion();

		if (fechaDeInscripcion.isBefore(fechaDeInicio) || fechaDeInscripcion.isAfter(fechaDeFinalizacion)) {
			return false;
		}

		// valida si el alumno ya aprobo la materia

		AsignacionCursoAlumno asignar = buscarinscripcionesAlumnos(curso.getIdCurso(), alumno.getDni());

		if (asignar != null && asignar.getCurso().getMateria().isAprobado()) {
			return false;
		}

		// valida si el alumno tiene la materias correlativas aprovadas

		if (asignar != null) {
			for (Materia correlativa : asignar.getCurso().getMateria().getCorrelativas()) {
				if (!correlativa.isAprobado()) {
					return false;
				}
			}
		}

		Materia materia = curso.getMateria();
		if (materia.getCorrelativas().size() != 0) {
			for (Materia materia1 : materia.getCorrelativas()) {
				if (!materia1.isAprobado()) {
					return false;
				}
			}
		}

		// valida si la capasidad del aula es optima
		if (curso.getAula().getContadorDeAlumno() == 0) {
			return false;
		}

		curso.getAula().setContadorDeAlumno(curso.getAula().getContadorDeAlumno() - 1);
		curso.setCantidadDeAlumnos(curso.getCantidadDeAlumnos() + 1);
		AsignacionCursoAlumno inscripcion = new AsignacionCursoAlumno(alumno, curso);
		inscripcionesAlumnos.add(inscripcion);
		return true;
	}

	public boolean asignarProfesoresALCurso(Integer idCurso, Integer dniDocente) {
		Profe profe = buscarProfePorDNI(dniDocente);
		if (profe == null) {
			return false;
		}
		Curso curso = buscarCursoPorid(idCurso);
		if (curso == null) {
			return false;
		}

		Double alumnos = (double) curso.getCantidadDeAlumnos();
		Integer profesoresNecesarios = (int) Math.ceil(alumnos / 20);

		AsignacionCursoProfe asignar = buscarAsignacionprofe(idCurso);
		if (asignar == null && profesoresNecesarios > 0) {
			AsignacionCursoProfe asignacion = new AsignacionCursoProfe(profe, curso);
			asignacion.agregarProfesor(profe);
			asignacion.setProfesoresNecesarios(profesoresNecesarios - 1);
			inscripcionesProfe.add(asignacion);
			return true;
		} else if (asignar != null && asignar.getProfesoresNecesarios() > 0) {
			asignar.agregarProfesor(profe);
			asignar.setProfesoresNecesarios(asignar.getProfesoresNecesarios() - 1);
			return true;
		}

		return false;
	}

	public boolean registrarNota(Integer idCurso, Integer dniAlumno, Nota nota) {

		Alumno alumno = buscarAlumnoPorDNI(dniAlumno);
		Curso curso = buscarCursoPorid(idCurso);

		if (curso == null || alumno == null) {
			return false;
		}

		AsignacionCursoAlumno asignacion = buscarinscripcionesAlumnos(idCurso, dniAlumno);

		if (asignacion == null) {
			return false;
		}
		
		if (nota.getPrimerParcial() > 10 || nota.getSegundoParcial() > 10) {
			return false;
		}

		asignacion.setNota(nota);

		if (asignacion.getNota().promocionarMateria()) {
			asignacion.getCurso().getMateria().setAprobado(true);
		}

		return true;

	}

	public List<Materia> obtenerMateriasAprobadasDeUnAlumno(Integer idAlumno) {
		List<Materia> materiasAprobadas = new ArrayList<>();

		for (AsignacionCursoAlumno asignacion : inscripcionesAlumnos) {
			if (asignacion.getAlumno().getDni().equals(idAlumno) && asignacion.getNota() != null) {
				if (asignacion.getNota().promocionarMateria()) {
					materiasAprobadas.add(asignacion.getCurso().getMateria());
				}
			}
		}

		return materiasAprobadas;
	}

	public Nota obtenerNota(Integer dni, Integer codigoMateria) {

		for (AsignacionCursoAlumno asignacion : inscripcionesAlumnos) {
			if (asignacion.getAlumno().getDni().equals(dni)
					&& asignacion.getCurso().getMateria().getCodigoMateria().equals(codigoMateria)) {
				return asignacion.getNota();
			}
		}
		return null;
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
			if (asignar.getCurso().getIdCurso().equals(idCurso)) {
				return asignar;
			}
		}
		return null;
	}

	public AsignacionCursoAlumno buscarinscripcionesAlumnos(Integer idCurso, Integer dni) {

		for (AsignacionCursoAlumno asignar : inscripcionesAlumnos) {
			if (asignar.getCurso().getIdCurso().equals(idCurso) && asignar.getAlumno().getDni().equals(dni)) {
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

	public Aula buscarAulaPorNro(Integer NroAula) {
		for (Aula aula : aulas) {
			if (aula.getNroAula().equals(NroAula)) {
				return aula;
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

	
	

}
