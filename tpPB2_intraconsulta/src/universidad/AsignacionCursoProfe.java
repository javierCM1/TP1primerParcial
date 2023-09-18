package universidad;

import java.util.ArrayList;

public class AsignacionCursoProfe {

	private ArrayList<Profe> profesor;
	private Curso curso;

	public AsignacionCursoProfe(Profe profe, Curso curso) {
		super();
		this.profesor = new ArrayList<>();
		this.curso = curso;
	}

	public ArrayList<Profe> getProfesor() {
		return profesor;
	}

	public void setProfesor(ArrayList<Profe> profesor) {
		this.profesor = profesor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
