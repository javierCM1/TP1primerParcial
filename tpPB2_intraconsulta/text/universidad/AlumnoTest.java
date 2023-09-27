package universidad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class AlumnoTest {

	private Universidad uni;

	private Materia materia1;
	private Materia materia6;
	private Materia materia7;
	private Materia materia8;
	private Materia materia9;

	@Before

	public void Before() {
		uni = new Universidad("unlam");

		materia1 = new Materia(7454, "Programacion basica 2");

		materia6 = new Materia(2578, "Programacion basica 1");
		materia7 = new Materia(3464, "Matematicas");
		materia8 = new Materia(4567, "Ingles Tecnico 1");
		materia9 = new Materia(9645, "Informatica general");
		
		 

	}

	@Test
	public void queSePuedaCrearAlumno() {
		Alumno alumno2 = new Alumno("Ale", "Cabrera", 12007562);
		Alumno alumno3 = new Alumno("Leonel", "Messi", 23437292);

		boolean alumnoCreado = uni.agregarAlumnos(alumno3);
		
		assertTrue(alumnoCreado);

	}

	@Test
	public void queSePuedaInscribirAlumnoCurso() {
	
		Alumno alumno = new Alumno("Leonel", "Messi", 23432);

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

		
		boolean alumnoCreado = uni.agregarAlumnos(alumno);
		boolean cursoCreado = uni.crearCurso(curso);
		boolean InscripcionDeAlumnoAcurso = uni.InscribirAlumnoACurso(alumno.getDni(), curso.getIdCurso());

		Integer AulaDisponible = curso.getAula().getContadorDeAlumno();
		Integer ResultadoEsperado = 39;

		
		
		assertEquals(AulaDisponible, ResultadoEsperado);
		assertTrue(alumnoCreado);
		assertTrue(cursoCreado);
		assertTrue(InscripcionDeAlumnoAcurso);

	}

	@Test
	public void queNoSePuedaInscribirAlumnoCursoSiEstaFueraDeLaFecha() {
		Alumno alumno = new Alumno("Leonel", "Messi", 23437292);
		Materia materia1 = new Materia(2578, "Programacion basica 2");
		Integer idCurso = 3214;
		Aula aula = new Aula(123, 40);
		String turno = "tarde";
		Integer cantidadAlumnos = 50;
		Integer id = 12312;
		//
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 4, 15);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 5, 23);
		//
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 27);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 15);

		CicloLectivo ciclo = new CicloLectivo(id, fechaInicioInscripcion, fechaFinalizacionInscripcion,
				fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo);

		Curso curso = new Curso(idCurso, materia1, ciclo, aula, turno, cantidadAlumnos);

		boolean alumnoCreado = uni.agregarAlumnos(alumno);
		boolean cursoCreado = uni.crearCurso(curso);

		boolean intentoDeInscripcion = uni.InscribirAlumnoACurso(alumno.getDni(), curso.getIdCurso());

		assertTrue(alumnoCreado);
		assertTrue(cursoCreado);
		assertFalse(intentoDeInscripcion);

	}

	@Test
	public void queSePuedaInscribirMasde1AlumnoCurso() {
		// crear alumno
		Alumno alumno = new Alumno("Leonel", "Messi", 23437292);
		Alumno alumno2 = new Alumno("Ale", "Cabrera", 12007562);
		// crar curso

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

		assertTrue(uni.agregarAlumnos(alumno));
		assertTrue(uni.crearCurso(curso));
		assertTrue(uni.agregarAlumnos(alumno2));
		assertTrue(uni.InscribirAlumnoACurso(alumno.getDni(), curso.getIdCurso()));
		assertTrue(uni.InscribirAlumnoACurso(alumno2.getDni(), curso.getIdCurso()));
		Integer AulaDisponible = curso.getAula().getContadorDeAlumno();
		Integer ResultadoEsperado = 38;

		assertTrue(AulaDisponible.equals(ResultadoEsperado));
	}

	@Test
	public void queNOSePuedaInscribirAlumnoCursoSiAprovoLaMateria() {
		Alumno alumno = new Alumno("Leonel", "Messi", 23432);
		Materia materia1 = new Materia(2578, "Programacion basica 1");
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

		Curso curso = new Curso(idCurso, materia1, ciclo, aula, turno, cantidadAlumnos);

		assertTrue(uni.agregarAlumnos(alumno));
		assertTrue(uni.crearCurso(curso));
		assertTrue(uni.InscribirAlumnoACurso(alumno.getDni(), curso.getIdCurso()));

		Nota nota = new Nota(7, 7);

		assertTrue(uni.registrarNota(curso.getIdCurso(), alumno.getDni(), nota));
		assertFalse(uni.InscribirAlumnoACurso(alumno.getDni(), curso.getIdCurso()));
		assertTrue(curso.getMateria().isAprobado());
	}

	@Test
	public void queNOSePuedaInscribirAlumnoCursoSiNoAprovoLasMateriaCorrelativas() {
		// crear alumn
		Alumno alumno = new Alumno("Leonel", "Messi", 289732);
		// crar curso

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
		// agregando materias correlativas

		uni.agregarMaterias(materia1);
		uni.agregarMaterias(materia6);
		uni.agregarMaterias(materia7);
		uni.agregarMaterias(materia8);
		uni.agregarMaterias(materia9);
	
		uni.asiganarMateriaCorrelativa(materia1.getCodigoMateria(), materia6.getCodigoMateria());
		uni.asiganarMateriaCorrelativa(materia1.getCodigoMateria(), materia7.getCodigoMateria());
		uni.asiganarMateriaCorrelativa(materia1.getCodigoMateria(), materia8.getCodigoMateria());
		uni.asiganarMateriaCorrelativa(materia1.getCodigoMateria(), materia9.getCodigoMateria());

		// incribiendo alumno a las otras materias y asignando notas

		Curso curso = new Curso(idCurso, materia1, ciclo, aula, turno, cantidadAlumnos);
		
		uni.agregarAlumnos(alumno);
		uni.crearCurso(curso);
		
		Integer materiasCorrelativas = curso.getMateria().getCorrelativas().size();
		Integer resultadoEsperado = 4;
		
		boolean IntentoDeInscripcion = uni.InscribirAlumnoACurso(alumno.getDni(), curso.getIdCurso());
		
		
		assertEquals(materiasCorrelativas, resultadoEsperado);
		assertFalse(IntentoDeInscripcion);
		
	}
	
	@Test
	public void queSePuedaInscribirAlumnoCursoSiAprovoLasMateriaCorrelativas() {
		// crear alumn
		Alumno alumno = new Alumno("Leonel", "Messi", 289732);
		// crar curso

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
		// agregando materias correlativas

		uni.agregarMaterias(materia1);
		uni.agregarMaterias(materia6);
		uni.agregarMaterias(materia7);
		uni.agregarMaterias(materia8);
		uni.agregarMaterias(materia9);
	
		uni.asiganarMateriaCorrelativa(materia1.getCodigoMateria(), materia6.getCodigoMateria());
		uni.asiganarMateriaCorrelativa(materia1.getCodigoMateria(), materia7.getCodigoMateria());
		uni.asiganarMateriaCorrelativa(materia1.getCodigoMateria(), materia8.getCodigoMateria());
		uni.asiganarMateriaCorrelativa(materia1.getCodigoMateria(), materia9.getCodigoMateria());

		
		
		// incribiendo alumno a las otras materias y asignando notas

		Curso curso = new Curso(idCurso, materia1, ciclo, aula, turno, cantidadAlumnos);
		
		Curso curso2 = new Curso(84653, materia6, ciclo, aula, turno, cantidadAlumnos);
		Curso curso3 = new Curso(34534, materia7, ciclo, aula, turno, cantidadAlumnos);
		Curso curso4 = new Curso(64533, materia8, ciclo, aula, turno, cantidadAlumnos);
		Curso curso5 = new Curso(75733, materia9, ciclo, aula, turno, cantidadAlumnos);
		
		uni.agregarAlumnos(alumno);
		
		uni.crearCurso(curso);
		
		uni.crearCurso(curso2);
		uni.crearCurso(curso3);
		uni.crearCurso(curso4);
		uni.crearCurso(curso5);
		
		uni.InscribirAlumnoACurso(alumno.getDni(), curso2.getIdCurso());
		uni.InscribirAlumnoACurso(alumno.getDni(), curso3.getIdCurso());
		uni.InscribirAlumnoACurso(alumno.getDni(), curso4.getIdCurso());
		uni.InscribirAlumnoACurso(alumno.getDni(), curso5.getIdCurso());
		
		Nota nota1 = new Nota(10,8);
		Nota nota2 = new Nota(8,7);
		Nota nota3 = new Nota(7,9);
		Nota nota4 = new Nota(9,7);
		
		uni.registrarNota(84653, alumno.getDni(), nota1);
		uni.registrarNota(34534, alumno.getDni(), nota2);
		uni.registrarNota(64533, alumno.getDni(), nota3);
		uni.registrarNota(75733, alumno.getDni(), nota4);
		
		Integer materiasCorrelativas = curso.getMateria().getCorrelativas().size();
		Integer resultadoEsperado = 4;
		
		assertEquals(materiasCorrelativas, resultadoEsperado);
		assertTrue(uni.InscribirAlumnoACurso(alumno.getDni(), curso.getIdCurso())); 

	
		
	}
	
	@Test
	public void queNoSePuedaInscribirAlumnoCursoSiNoAprovoLasMateriaCorrelativas() {
		// crear alumn
		Alumno alumno = new Alumno("Leonel", "Messi", 289732);
		// crar curso

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
		

		uni.agregarMaterias(materia1);
		uni.agregarMaterias(materia6);
		uni.agregarMaterias(materia7);
		uni.agregarMaterias(materia8);
		uni.agregarMaterias(materia9);
	
		uni.asiganarMateriaCorrelativa(materia1.getCodigoMateria(), materia6.getCodigoMateria());
		uni.asiganarMateriaCorrelativa(materia1.getCodigoMateria(), materia7.getCodigoMateria());
		uni.asiganarMateriaCorrelativa(materia1.getCodigoMateria(), materia8.getCodigoMateria());
		uni.asiganarMateriaCorrelativa(materia1.getCodigoMateria(), materia9.getCodigoMateria());

		
		
		// incribiendo alumno a las otras materias y asignando notas

		Curso curso = new Curso(idCurso, materia1, ciclo, aula, turno, cantidadAlumnos);
		
		Curso curso2 = new Curso(84653, materia6, ciclo, aula, turno, cantidadAlumnos);
		Curso curso3 = new Curso(34534, materia7, ciclo, aula, turno, cantidadAlumnos);
		Curso curso4 = new Curso(64533, materia8, ciclo, aula, turno, cantidadAlumnos);
		Curso curso5 = new Curso(75733, materia9, ciclo, aula, turno, cantidadAlumnos);
		
		uni.agregarAlumnos(alumno);
		
		uni.crearCurso(curso);
		
		uni.crearCurso(curso2);
		uni.crearCurso(curso3);
		uni.crearCurso(curso4);
		uni.crearCurso(curso5);
		
		uni.InscribirAlumnoACurso(alumno.getDni(), curso2.getIdCurso());
		uni.InscribirAlumnoACurso(alumno.getDni(), curso3.getIdCurso());
		uni.InscribirAlumnoACurso(alumno.getDni(), curso4.getIdCurso());
		uni.InscribirAlumnoACurso(alumno.getDni(), curso5.getIdCurso());
		
		Nota nota1 = new Nota(3,3);
		Nota nota2 = new Nota(2,3);
		Nota nota3 = new Nota(2,3);
		Nota nota4 = new Nota(2,3);
		
		uni.registrarNota(84653, alumno.getDni(), nota1);
		uni.registrarNota(34534, alumno.getDni(), nota2);
		uni.registrarNota(64533, alumno.getDni(), nota3);
		uni.registrarNota(75733, alumno.getDni(), nota4);
		
		Integer materiasCorrelativas = curso.getMateria().getCorrelativas().size();
		Integer resultadoEsperado = 4;
		
		boolean intentoDeInscripcion = uni.InscribirAlumnoACurso(alumno.getDni(), curso.getIdCurso());
		
		assertEquals(materiasCorrelativas, resultadoEsperado);
		assertFalse(intentoDeInscripcion); 

	
		
	}
	
	 
	
	
	
	
}