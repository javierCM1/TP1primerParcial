package intraconsulta;

public class AsignacionCursoAlumno {

	private Integer idInscripcion;
	private Alumno alumno;
	private Curso curso;
    private Nota nota;
    
	public AsignacionCursoAlumno(Integer idInscripcion, Alumno alumno, Curso curso) {
		super();
		this.idInscripcion = idInscripcion;
		this.alumno = alumno;
		this.curso = curso;
	}

	public Integer getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(Integer idInscripcion) {
		this.idInscripcion = idInscripcion;
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
