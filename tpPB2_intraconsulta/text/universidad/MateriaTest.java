package universidad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MateriaTest {

	@Test
	public void queSePuedaCrearMateria() {
		Universidad uni = new Universidad("unlam");
		Materia materia1 = new Materia(2578, "Programacion basica 2");

		boolean registro = uni.agregarMaterias(materia1);

		assertTrue(registro);
		assertNotNull(materia1);
	}
	
	@Test
	public void queSePuedaAgregarMateriaCorrelativas() {
		Universidad uni = new Universidad("unlam");
		
		Materia materia1 = new Materia(2578, "Programacion basica 2");
		
		Materia materia6 = new Materia(4458, "Programacion basica 1");
		Materia	materia7 = new Materia(3464, "Matematicas");
		Materia	materia8 = new Materia(4567, "Ingles Tecnico 1");
		Materia	materia9 = new Materia(9645, "Informatica general");
		
		
		uni.agregarMaterias(materia6);
		uni.agregarMaterias(materia7);
		uni.agregarMaterias(materia8);
		uni.agregarMaterias(materia9);

		boolean materiaPrincipal = uni.agregarMaterias(materia1);
	    uni.asiganarMateriaCorrelativa(materia1.getCodigoMateria(), materia6.getCodigoMateria());
	    uni.asiganarMateriaCorrelativa(materia1.getCodigoMateria(), materia7.getCodigoMateria());
		uni.asiganarMateriaCorrelativa(materia1.getCodigoMateria(), materia8.getCodigoMateria());
		uni.asiganarMateriaCorrelativa(materia1.getCodigoMateria(), materia9.getCodigoMateria());
  
		Integer cantidadDeMaterias = materia1.getCorrelativas().size();
		Integer cantidadEsperada = 4;
		
		assertTrue(materiaPrincipal);
		assertNotNull(materia1);
		assertEquals(cantidadDeMaterias, cantidadEsperada);
	}
	
	@Test
	public void queSePuedaEliminarMateriaCorrelativas() {
		
	
		Universidad uni = new Universidad("unlam");
		
		Materia materia1 = new Materia(2578, "Programacion basica 2");
		
		Materia materia6 = new Materia(4458, "Programacion basica 1");
		Materia	materia7 = new Materia(3464, "Matematicas");
		Materia	materia8 = new Materia(4567, "Ingles Tecnico 1");
		Materia	materia9 = new Materia(9645, "Informatica general");
		
		
		uni.agregarMaterias(materia6);
		uni.agregarMaterias(materia7);
		uni.agregarMaterias(materia8);
		uni.agregarMaterias(materia9);

		// se agrega 4 materias correlativas y despues se borra una
		boolean registro = uni.agregarMaterias(materia1);
		boolean registro2 = uni.asiganarMateriaCorrelativa(materia1.getCodigoMateria(), materia6.getCodigoMateria());
		boolean registro3 = uni.asiganarMateriaCorrelativa(materia1.getCodigoMateria(), materia7.getCodigoMateria());
		boolean registro4 = uni.asiganarMateriaCorrelativa(materia1.getCodigoMateria(), materia8.getCodigoMateria());
		boolean registro5 = uni.asiganarMateriaCorrelativa(materia1.getCodigoMateria(), materia9.getCodigoMateria());
		
		uni.EliminarCorrelativa(materia1.getCodigoMateria(), materia7.getCodigoMateria());
  
		Integer cantidadDeMaterias = materia1.getCorrelativas().size();
		Integer cantidadEsperada = 3;
		
		
		assertTrue(registro);
		assertNotNull(materia1);
		assertEquals(cantidadDeMaterias, cantidadEsperada);
	}
	

}
