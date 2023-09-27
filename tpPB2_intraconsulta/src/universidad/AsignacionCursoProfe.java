package universidad;

import java.util.ArrayList;

public class AsignacionCursoProfe {

	private ArrayList<Profe> profesor;
	private Curso curso;
	private Integer profesoresNecesarios;

	public AsignacionCursoProfe(Profe profe, Curso curso) {
		super();
		this.profesor = new ArrayList<>();
		this.curso = curso;
		this.profesoresNecesarios = 0;
	}
	
	public void agregarProfesor(Profe profe) {
		profesor.add(profe);
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

	public Integer getProfesoresNecesarios() {
		return profesoresNecesarios;
	}

	public void setProfesoresNecesarios(Integer profesoresNecesarios) {
		this.profesoresNecesarios = profesoresNecesarios;
	}
	
	

}
