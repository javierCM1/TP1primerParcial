package universidad;


public class AsignacionCursoAlumno {

	private Integer idAsignacion;
	private Alumno alumno;
	private Curso curso;
    private Nota nota;
    
	public AsignacionCursoAlumno(Integer idInscripcion, Alumno alumno, Curso curso) {
		super();
		this.idAsignacion = idInscripcion;
		this.alumno = alumno;
		this.curso = curso;
	}

	public Integer getIdInscripcion() {
		return idAsignacion;
	}

	public void setIdInscripcion(Integer idInscripcion) {
		this.idAsignacion = idInscripcion;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}
	
	
	

}
