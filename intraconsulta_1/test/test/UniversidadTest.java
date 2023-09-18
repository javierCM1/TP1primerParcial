package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

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
	
	private Profe profe;
	private Profe profesor1 = new Profesor("Juan", "Pérez", "12345678");
	private Profe profesor2 = new Profesor("María", "González", "23456789");
	private Profe profesor3 = new Profesor("Pedro", "Rodríguez", "34567890");
	private Profe profesor4;

	private CicloLectivo ciclo;
	

	@Before

	public void Before() {
		uni = new Universidad("unlam");
		
	
		materia1 = new Materia(2578, "Programacion basica 2");
		materia2 = new Materia(3464, "Programacion web");
		materia3 = new Materia(4567, "Ingles Tecnico 2");
		materia4 = new Materia(9645, "Introducion a diseño grafico");
		materia5 = new Materia(2345, "Base de datos");
		
		alumno1 = new Alumno("Javier", "Cabrera", 54003292);
		alumno2 = new Alumno("Ale", "Cabrera", 12007562);
		alumno3 = new Alumno("Leonel", "Messi", 23437292);
		alumno4 = new Alumno("Andres", "Iniesta", 34457292);
		alumno5 = new Alumno("Julian", "Alvares", 12677298);
		
		Profesor profesor1 = new Profesor("Juan", "Pérez", "12345678");
		Profesor profesor2 = new Profesor("María", "González", "23456789");
		Profesor profesor3 = new Profesor("Pedro", "Rodríguez", "34567890");
		Profesor profesor4 = new Profesor("Laura", "Martínez", "45678901");
		
		
		Integer id = 12312;	
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 3, 15);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 23);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 27);
	    LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 15);
	    ciclo = new CicloLectivo(id,fechaInicioInscripcion,fechaFinalizacionInscripcion
	    		,fechaInicioCicloLectivo,fechaFinalizacionCicloLectivo);
		 
	}

	@Test
	public void queSePuedaRegistrarUnAlumno() {
		uni.agregarAlumnos(alumno1);
		assertNotNull(alumno1);

	}

	@Test

	public void queSePuedaCrearMateria() {

		boolean registro = uni.agregarMaterias(materia1);

		assertTrue(registro);
		assertNotNull(materia1);
	}

	@Test

	public void queSePuedaCrearCursada() {
		Integer codigo = 3214;
		Aula aula = new Aula(123, 40);
		String turno = "tarde";
		Integer cantidadAlumnos = 50;
        
		Curso curso = new Curso(codigo, materia1,ciclo,aula,turno,cantidadAlumnos);
		assertNotNull(curso);

	}

	@Test

	public void queElAumnoPuedaInscrivirseAMateria() {

		Integer dni = 54003292;
		Integer codigoMateria = 2578;
		
		Integer codigo = 3214;
		Integer sicloLectivo = 203;
		Aula aula = new Aula(123, 40);
		String turno = "tarde";
		Integer cantidadAlumnos = 50;
		
		uni.agregarAlumnos(alumno1);
		uni.agregarMaterias(materia1);
		Curso curso = new Curso(codigo, materia1, ciclo, aula,turno,cantidadAlumnos);
		uni.crearCurso(curso);
		
        boolean res =  uni.inscripcionMateriaAlumno(dni, codigoMateria);
		
		assertTrue(res);
		assertFalse(curso.getAula().isDisponible());
		
	}
	
	@Test

    public void crearCicloLectivo  (){
	
	    boolean eperado = uni.crearCicloLectivo(ciclo);
	    
	    assertEquals(1, uni.getCiclosLectivos().size());
	    assertTrue(eperado);  
	    
	}

	@Test
    
	public void asignarProfesorAlCurso() {
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
}