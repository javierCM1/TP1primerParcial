package universidad;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RegistroDeMateriasAprobadasTest {

	
   
    private Universidad uni;
 

    @Before
    public void setUp() {
    	
    	uni = new Universidad("unlam");

    }
    
    @Test
    public void ObtenerListadoMateriasAprobadasParaUnAlumno() {
    	
    	Alumno alumno = new Alumno("Juan", "Perez", 23432);

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
		Nota nota1 = new Nota(7, 8);
		
		boolean alumnoCreado = uni.agregarAlumnos(alumno);
		boolean cursoCreado = uni.crearCurso(curso);
		boolean InscripcionDeAlumnoAcurso = uni.InscribirAlumnoACurso(alumno.getDni(), curso.getIdCurso());
		boolean registroNota =  uni.registrarNota(idCurso, alumno.getDni(), nota1);
		List<RegistroMateriaAprobada> materiasAprobadas = uni.obtenerListadoMateriasAprobadasParaUnAlumno(alumno.getDni());
		
		RegistroMateriaAprobada registro = materiasAprobadas.get(0);
		
        assertTrue(registroNota);
		assertTrue(alumnoCreado);
		assertTrue(cursoCreado);
		assertTrue(InscripcionDeAlumnoAcurso);

		Integer notaEsperada = 7;
		Integer IdCicloLectivoEsperado = 12312;
		assertEquals(materiasAprobadas.size(), 1);
		assertEquals("Juan", registro.getNombre());
		assertEquals("Perez", registro.getApellido());
		assertEquals("Programacion basica 2", registro.getNombreMateria());
	    assertEquals(notaEsperada,registro.getNota());
	    assertEquals(IdCicloLectivoEsperado, registro.getCicloLectivo());
		
     
    	
    }
   
    
    
}
