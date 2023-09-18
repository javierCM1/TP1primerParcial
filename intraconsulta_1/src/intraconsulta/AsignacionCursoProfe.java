package intraconsulta;

public class AsignacionCursoProfe {
	
	private Integer idAsignacion;
	private Profe profe;
	private Curso curso;
	
	public AsignacionCursoProfe(Integer nroinscripcion, Profe profe, Curso curso) {
		super();
		this.idAsignacion = nroinscripcion;
		this.profe = profe;
		this.curso = curso;
	}

	public Integer getIdAsignacion() {
		return idAsignacion;
	}

	public void setIdAsignacion(Integer idAsignacion) {
		this.idAsignacion = idAsignacion;
	}

	public Profe getProfe() {
		return profe;
	}

	public void setProfe(Profe profe) {
		this.profe = profe;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	

}
