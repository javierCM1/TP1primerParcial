package universidad;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class CicloLectivoTest {

	private Universidad uni;

	@Before

	public void Before() {
		uni = new Universidad("unlam");

	}

	@Test
	public void quesePuedaCrearCicloLectivo() {

		Integer id = 12312;
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 3, 15);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 23);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 3, 27);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 7, 15);

		CicloLectivo ciclo = new CicloLectivo(id, fechaInicioInscripcion, fechaFinalizacionInscripcion,
				fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo);

		assertTrue(uni.crearCicloLectivo(ciclo));

	}

	@Test
	public void queNoSePuedaCrearCicloLectivoConSuperposicionDeFechas() {
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 9, 15);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 12, 23);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 7, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 8, 15);

		CicloLectivo ciclo = new CicloLectivo(2, fechaInicioInscripcion, fechaFinalizacionInscripcion,
				fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo);

		assertFalse(uni.crearCicloLectivo(ciclo));
	}

}
