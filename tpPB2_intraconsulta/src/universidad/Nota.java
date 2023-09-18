package universidad;

public class Nota {

	private Integer primerParcial;
	private Integer segundoParcial;
	private Integer recuperatorio;

	public Nota(Integer primerParcial, Integer segundoParcial, Integer recuperatorio) {
		super();
		this.primerParcial = primerParcial;
		this.segundoParcial = segundoParcial;
		this.recuperatorio = recuperatorio;
	}

	public Integer getPrimerParcial() {
		return primerParcial;
	}

	public void setPrimerParcial(Integer primerParcial) {
		this.primerParcial = primerParcial;
	}

	public Integer getSegundoParcial() {
		return segundoParcial;
	}

	public void setSegundoParcial(Integer segundoParcial) {
		this.segundoParcial = segundoParcial;
	}

	public Integer getRecuperatorio() {
		return recuperatorio;
	}

	public void setRecuperatorio(Integer recuperatorio) {
		this.recuperatorio = recuperatorio;
	}

}