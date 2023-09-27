package universidad;

public class Aula {

	private Integer NroAula;
	private Integer capasidad;
	private Integer contadorDeAlumno;
	private boolean disponible;

	public Aula(Integer nroAula, Integer capasidad) {
		super();
		this.NroAula = nroAula;
		this.capasidad = capasidad;
		this.disponible = true;
		this.contadorDeAlumno = capasidad;
	}

	public Integer getContadorDeAlumno() {
		return contadorDeAlumno;
	}

	public void setContadorDeAlumno(Integer contadorDeAlumno) {
		this.contadorDeAlumno = contadorDeAlumno;
	}

	public Integer getNroAula() {
		return NroAula;
	}

	public void setNroAula(Integer nroAula) {
		NroAula = nroAula;
	}

	public Integer getCapasidad() {
		return capasidad;
	}

	public void setCapasidad(Integer capasidad) {
		this.capasidad = capasidad;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

}
