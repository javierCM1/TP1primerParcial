package intraconsulta;

import java.time.LocalDate;

public class CicloLectivo {
    private Integer id;
    private LocalDate fechaInicioInscripcion;
    private LocalDate fechaFinalizacionInscripcion;
    private LocalDate fechaInicioCicloLectivo;
    private LocalDate fechaFinalizacionCicloLectivo;
    
    
	public CicloLectivo(Integer id, LocalDate fechaInicioInscripcion, LocalDate fechaFinalizacionInscripcion,
			LocalDate fechaInicioCicloLectivo, LocalDate fechaFinalizacionCicloLectivo) {
		super();
		this.id = id;
		this.fechaInicioInscripcion = fechaInicioInscripcion;
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo;
		this.fechaFinalizacionCicloLectivo = fechaFinalizacionCicloLectivo;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDate getFechaInicioInscripcion() {
		return fechaInicioInscripcion;
	}


	public void setFechaInicioInscripcion(LocalDate fechaInicioInscripcion) {
		this.fechaInicioInscripcion = fechaInicioInscripcion;
	}


	public LocalDate getFechaFinalizacionInscripcion() {
		return fechaFinalizacionInscripcion;
	}


	public void setFechaFinalizacionInscripcion(LocalDate fechaFinalizacionInscripcion) {
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
	}


	public LocalDate getFechaInicioCicloLectivo() {
		return fechaInicioCicloLectivo;
	}


	public void setFechaInicioCicloLectivo(LocalDate fechaInicioCicloLectivo) {
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo;
	}


	public LocalDate getFechaFinalizacionCicloLectivo() {
		return fechaFinalizacionCicloLectivo;
	}


	public void setFechaFinalizacionCicloLectivo(LocalDate fechaFinalizacionCicloLectivo) {
		this.fechaFinalizacionCicloLectivo = fechaFinalizacionCicloLectivo;
	}
 
   
    
}