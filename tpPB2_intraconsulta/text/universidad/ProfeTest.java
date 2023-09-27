package universidad;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class ProfeTest {

	private Universidad uni;
	private CicloLectivo ciclo;

	@Before

	public void Before() {

		uni = new Universidad("unlam");

		Integer id = 12312;
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 3, 15);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 23);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 27);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 15);
		ciclo = new CicloLectivo(id, fechaInicioInscripcion, fechaFinalizacionInscripcion, fechaInicioCicloLectivo,
				fechaFinalizacionCicloLectivo);
	}

	@Test
	public void queSePuedaAgregarProfesores() {

		Profe profe = new Profe("leonardo", "cabrera", 34534534);
		boolean resultado = uni.agregarProfesores(profe);

		assertNotNull(uni);
		assertTrue(resultado);

	}

	@Test

	public void asignarProfesorAlCurso() {
		Integer idCurso = 65437;
		Aula aula = new Aula(150, 60);
		String turno = "noche";
		Integer cantidadAlumnos = 20;
		Materia materia = new Materia(2578, "Programacion basica 2");

		Profe profesor = new Profe("Pedro", "Rodríguez", 34567890);
		Curso curso = new Curso(idCurso, materia, ciclo, aula, turno, cantidadAlumnos);

		uni.agregarProfesores(profesor);
		uni.crearCurso(curso);

		boolean exito = uni.asignarProfesoresALCurso(curso.getIdCurso(), profesor.getDni());

		assertTrue(exito);

	}

	@Test

	public void queSePuedaAgregarMasProfesoresSiEsNecesario() {
		Integer idCurso = 65437;
		Aula aula = new Aula(150, 60);
		String turno = "noche";
		Integer cantidadAlumnos = 34;
		Materia materia = new Materia(2578, "Programacion basica 2");

		Profe profesor = new Profe("Pedro", "Rodríguez", 34567890);
		Profe profesor2 = new Profe("María", "González", 23456789);
		Curso curso = new Curso(idCurso, materia, ciclo, aula, turno, cantidadAlumnos);

		uni.agregarProfesores(profesor);
		uni.agregarProfesores(profesor2);
		uni.crearCurso(curso);

		boolean resultado = uni.asignarProfesoresALCurso(curso.getIdCurso(), profesor.getDni());
		boolean resultado2 = uni.asignarProfesoresALCurso(curso.getIdCurso(), profesor2.getDni());

		assertTrue(resultado);
		assertTrue(resultado2);
	

	}
	
	@Test

	public void queNoSePuedaAgregarMasProfesoresSiLaCantidadDeAlumnosEsMenor() {
		Integer idCurso = 65437;
		Aula aula = new Aula(150, 60);
		String turno = "noche";
		Integer cantidadAlumnos = 19;
		Materia materia = new Materia(2578, "Programacion basica 2");

		Profe profesor = new Profe("Pedro", "Rodríguez", 34567890);
		Profe profesor2 = new Profe("María", "González", 23456789);
		Curso curso = new Curso(idCurso, materia, ciclo, aula, turno, cantidadAlumnos);

		uni.agregarProfesores(profesor);
		uni.agregarProfesores(profesor2);
		uni.crearCurso(curso);

		boolean inscripcionProfe = uni.asignarProfesoresALCurso(curso.getIdCurso(), profesor.getDni());
		boolean IntentoDeInscripcion = uni.asignarProfesoresALCurso(curso.getIdCurso(), profesor2.getDni());

		assertTrue(inscripcionProfe);
		assertFalse(IntentoDeInscripcion);

	}
	

}
