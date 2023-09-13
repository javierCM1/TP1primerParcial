package intraconsulta;

public class AsignacionCursoAlumno {

	private Alumno alumno;
	private Curso curso;
    private Nota nota;
	
	public AsignacionCursoAlumno(Alumno alumno, Curso curso) {
		super();
		this.alumno = alumno;
		this.curso = curso;
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

}
