package universidad;

public class Aula {

	private Integer NroAula;
	private Integer capasidad;
	private boolean disponible;

	public Aula(Integer nroAula, Integer capasidad) {
		super();
		this.NroAula = nroAula;
		this.capasidad = capasidad;
		this.disponible = true;
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
