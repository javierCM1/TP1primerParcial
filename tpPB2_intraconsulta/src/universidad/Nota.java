package universidad;

public class Nota {
	private Integer primerParcial;
	private Integer segundoParcial;
	private Integer recuperatorioPrimerParcial;
	private Integer recuperatorioSegundoParcial;
	private Integer examenFinal;

	public Nota(Integer primerParcial, Integer segundoParcial) {
		this.primerParcial = primerParcial;
		this.segundoParcial = segundoParcial;
		this.recuperatorioPrimerParcial = null;
		this.recuperatorioSegundoParcial = null;
		this.examenFinal = null;
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
	
	

	public boolean registrarRecuperatorioPrimerParcial(Integer nota) {
		if(nota > 10) {
			return false;
		}
		this.recuperatorioPrimerParcial = nota;
		return true;
	}

	public boolean registrarRecuperatorioSegundoParcial(Integer nota) {
		if(nota > 10) {
			return false;
		}
		this.recuperatorioSegundoParcial = nota;
		return true;
	}

	public boolean registrarExamenFinal(Integer nota) {
		if (nota>4) {
			return false;
		}
		this.examenFinal = nota;
		return true;
	}

	public boolean promocionarMateria() {
		if (primerParcial >= 7 && segundoParcial >= 7) {
			return true;
		}

		if (recuperatorioPrimerParcial != null && recuperatorioPrimerParcial >= 7) {
			return true;
		}

		if (recuperatorioSegundoParcial != null && recuperatorioSegundoParcial >= 7) {
			return true;
		}

		if (examenFinal != null && primerParcial >= 4 && segundoParcial >= 4 && examenFinal >= 4) {
			return true;
		}

		return false;
	}

	public boolean desaprobado() {
		if (primerParcial < 4 || segundoParcial < 4) {
			return true;
		}

		if (examenFinal != null && examenFinal < 4) {
			return true;
		}

		return false;
	}
	
	public Integer notaFinal() {
		Integer nota = null;
		if(recuperatorioSegundoParcial == null && recuperatorioPrimerParcial == null && examenFinal == null) {
			nota = (primerParcial + segundoParcial)/2;
			return nota;
		}
		
		if(recuperatorioSegundoParcial != null) {
			nota = (primerParcial+recuperatorioSegundoParcial)/2;
			return nota;
		}
		
		if(recuperatorioPrimerParcial != null) {
			nota = (segundoParcial+recuperatorioPrimerParcial)/2;
			return nota;
		}
		
		if(examenFinal != null && examenFinal<=4) {
			return this.examenFinal;
		}
		
		return nota;
	}
}