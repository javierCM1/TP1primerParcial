package intraconsulta;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UniversidadTest {

	private Universidad uni;
	
	private Materia materia1;
	private Materia materia2;
	private Materia materia3;
	private Materia materia4;
	private Materia materia5;
	
	private Alumno alumno1;
	private Alumno alumno2;
	private Alumno alumno3;
	private Alumno alumno4;
	private Alumno alumno5;

	@Before

	public void Before() {
		uni = new Universidad("unlam");
		
		materia1 = new Materia(2578, "Programacion basica 2");
		materia2 = new Materia(3464, "Programacion web");
		materia3 = new Materia(4567, "Ingles Tecnico 2");
		materia4 = new Materia(9645, "Introducion a diseño grafico");
		materia5 = new Materia(2345, "Base de datos");
		
		alumno1 = new Alumno("javier", "cabrera", 54003292);
		alumno2 = new Alumno("ale", "cabrera", 12007562);
		alumno3 = new Alumno("javier", "cabrera", 23437292);
		alumno4 = new Alumno("javier", "cabrera", 34457292);
		alumno5 = new Alumno("javier", "cabrera", 12677298);
		
		 
	}

	@Test
	public void queSePuedaRegistrarUnAlumno() {


		uni.registrarAlumno(alumno1);

		assertNotNull(alumno1);

	}

	@Test

	public void queSePuedaCrearMateria() {

		boolean registro = uni.registrarMateria(materia1);

		assertTrue(registro);
		assertNotNull(materia1);
	}

	@Test

	public void queSePuedaCrearCursada() {
		Integer codigo = 3214;
		Integer sicloLectivo = 203;
		Aula aula = new Aula(123, 40);

		Curso curso = new Curso(codigo, materia1, sicloLectivo, aula);

		assertNotNull(curso);

	}

	@Test

	public void queElAumnoPuedaInscrivirseAMateria() {

		Integer dni = 54003292;
		Integer codigoMateria = 2578;
		
		Integer codigo = 3214;
		Integer sicloLectivo = 203;
		Aula aula = new Aula(123, 40);
		
		uni.registrarAlumno(alumno1);
		uni.registrarMateria(materia1);
		Curso curso = new Curso(codigo, materia1, sicloLectivo, aula);
		uni.crearCurso(curso);
		
        boolean res =  uni.inscripcionMateriaAlumno(dni, codigoMateria);
		
		assertTrue(res);
		assertFalse(curso.getAula().isDisponible());
		
	}

}
