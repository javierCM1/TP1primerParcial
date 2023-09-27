package universidad;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ReportesNotasAlumnosTest {

	private Universidad uni;
	


	@Test
	public void ObtenerReporteDeNotasDeAlumnosDeCurso() {
		uni = new Universidad("unlam");

		Alumno alumno = new Alumno("Leonel", "Messi", 23432);
        Alumno alumno2 = new Alumno("jose", "Martinez", 45363);
		
		
		
		Materia materia1 = new Materia(2578, "Programacion basica 2");
		Integer idCurso = 3214;
		Aula aula = new Aula(123, 40);
		String turno = "tarde";
		Integer cantidadAlumnos = 50;
		Integer id = 12312;
		// la fecha de inscricion es la fecha actual
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 9, 15);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 12, 23);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 27);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 15);
		CicloLectivo ciclo = new CicloLectivo(id, fechaInicioInscripcion, fechaFinalizacionInscripcion,
				fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo);

		Curso curso = new Curso(idCurso, materia1, ciclo, aula, turno, cantidadAlumnos);

		Nota nota = new Nota(10,8);
		Nota nota2 = new Nota(7,8);
		
		
		
		uni.agregarAlumnos(alumno);
		uni.agregarAlumnos(alumno2);
		uni.crearCurso(curso);
		uni.InscribirAlumnoACurso(alumno.getDni(), curso.getIdCurso());
		uni.InscribirAlumnoACurso(alumno2.getDni(), curso.getIdCurso());
        uni.registrarNota(curso.getIdCurso(), alumno.getDni(),nota);
        uni.registrarNota(curso.getIdCurso(), alumno2.getDni(),nota2);
	    
	    
	    List<ReporteNotasAlumno> reporteNotas = uni.obtenerReporteDeNotasDeAlumnosDeCurso(curso.getIdCurso());

	 
	    assertFalse(reporteNotas.isEmpty());

	    assertEquals("Leonel", reporteNotas.get(0).getNombre());
	    assertEquals("jose", reporteNotas.get(1).getNombre());
	    assertEquals(9, reporteNotas.get(0).getNota());
	    assertEquals(7, reporteNotas.get(1).getNota());
	}
}
