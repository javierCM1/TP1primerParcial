package universidad;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class NotaTest {

	private Universidad uni;

	Materia materia;
	Curso curso;
	Alumno alumno;

	@Before

	public void Before() {
		uni = new Universidad("unlam");

		materia = new Materia(7454, "Programacion basica 2");

		alumno = new Alumno("Leonel", "Messi", 23432);
		Integer idCurso = 3214;
		Aula aula = new Aula(123, 40);
		String turno = "tarde";
		Integer cantidadAlumnos = 50;
		Integer id = 12312;

		// Configurar el ciclo lectivo
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 9, 15);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 12, 23);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 27);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 15);
		CicloLectivo ciclo = new CicloLectivo(id, fechaInicioInscripcion, fechaFinalizacionInscripcion,
				fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo);

		curso = new Curso(idCurso, materia, ciclo, aula, turno, cantidadAlumnos);

	}

	
	
	@Test
    public void queSePuedaRegistrarNotaPromocion() {
        Nota notaPromocion = new Nota(7, 7);


		uni.agregarAlumnos(alumno);
		uni.agregarMaterias(materia);
		uni.crearCurso(curso);
		uni.InscribirAlumnoACurso(alumno.getDni(), curso.getIdCurso());
		
        assertTrue(uni.registrarNota(curso.getIdCurso(), alumno.getDni(), notaPromocion));
        assertTrue(materia.isAprobado());
    }

    @Test
    public void testRegistrarNotaRecuperatorio() {
        Nota notaRecuperatorio = new Nota(5, 7);
        notaRecuperatorio.registrarRecuperatorioPrimerParcial(7);
        
        uni.agregarAlumnos(alumno);
		uni.agregarMaterias(materia);
		uni.crearCurso(curso);
        uni.InscribirAlumnoACurso(alumno.getDni(), curso.getIdCurso());
        
        assertTrue(uni.registrarNota(curso.getIdCurso(), alumno.getDni(), notaRecuperatorio));
        assertTrue(materia.isAprobado());
    }

    @Test
    public void testRegistrarNotaFinal() {
       
        Nota notaFinal = new Nota(4, 7);
        notaFinal.registrarRecuperatorioPrimerParcial(5);
        notaFinal.registrarExamenFinal(4);
        
        uni.agregarAlumnos(alumno);
		uni.agregarMaterias(materia);
		uni.crearCurso(curso);
        uni.InscribirAlumnoACurso(alumno.getDni(), curso.getIdCurso());
        
        assertTrue(uni.registrarNota(curso.getIdCurso(), alumno.getDni(), notaFinal));
        assertTrue(materia.isAprobado());
    }

    @Test
    public void testRegistrarNotaDesaprobado() {
      
        Nota notaDesaprobado = new Nota(3, 3);
        
        uni.agregarAlumnos(alumno);
      	uni.agregarMaterias(materia);
      	uni.crearCurso(curso);
        uni.InscribirAlumnoACurso(alumno.getDni(), curso.getIdCurso());

        assertTrue(uni.registrarNota(curso.getIdCurso(), alumno.getDni(), notaDesaprobado));
        assertFalse(materia.isAprobado());
    }

	
}
