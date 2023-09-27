package universidad;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class CursoTest {

	private Universidad uni;
	

	@Before

	public void Before() {
		uni = new Universidad("unlam");

	}

	@Test
	public void queSePuedaCrearCursada() {

		Materia materia1 = new Materia(2578, "Programacion basica 2");
		Integer idCurso = 3214;
		Aula aula = new Aula(123, 40);
		String turno = "tarde";
		Integer cantidadAlumnos = 50;
		Integer id = 12312;
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 3, 15);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 23);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 27);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 15);
		CicloLectivo ciclo = new CicloLectivo(id, fechaInicioInscripcion, fechaFinalizacionInscripcion, fechaInicioCicloLectivo,
				fechaFinalizacionCicloLectivo);

		Curso curso = new Curso(idCurso, materia1, ciclo, aula, turno, cantidadAlumnos);
		boolean exito =  uni.crearCurso(curso);
	
		assertTrue(exito);
		assertNotNull(curso);

	}
	
	@Test
	public void queSeNoPuedaCrearCursadaConLaMismaMateriaCicloLectivoTurno() {

		
		
		Materia materia1 = new Materia(2578, "Programacion basica 2");
		Integer idCurso = 3214;
		Aula aula = new Aula(123, 40);
		String turno = "tarde";
		Integer cantidadAlumnos = 50;
		Integer id = 12312;
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 3, 15);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 23);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 27);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 15);
		CicloLectivo ciclo = new CicloLectivo(id, fechaInicioInscripcion, fechaFinalizacionInscripcion, fechaInicioCicloLectivo,
				fechaFinalizacionCicloLectivo);

		Curso curso = new Curso(idCurso, materia1, ciclo, aula, turno, cantidadAlumnos);
		Curso curso2 = new Curso(465465,materia1,ciclo,aula,turno,cantidadAlumnos);
		
		boolean registroCurso =  uni.crearCurso(curso);
		boolean intentoRegistroCurso = uni.crearCurso(curso2);
		
		assertTrue(registroCurso);
		assertFalse(intentoRegistroCurso);
		
		
		

	}
	
	
	
	
	
	

}
