package universidad;

public class Curso {

	private Integer idCurso;
	private Materia materia;
	private CicloLectivo ciclo;
	private Aula aula;
	private String turno;
	private Integer cantidadDeAlumnos;

	public Curso(Integer idCurso, Materia materia, CicloLectivo ciclo, Aula aula, String turno,
			Integer cantidadDeAlumnos) {
		super();
		this.idCurso = idCurso;
		this.materia = materia;
		this.ciclo = ciclo;
		this.aula = aula;
		this.turno = turno;
		this.cantidadDeAlumnos = cantidadDeAlumnos;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public CicloLectivo getCiclo() {
		return ciclo;
	}

	public void setCiclo(CicloLectivo ciclo) {
		this.ciclo = ciclo;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Integer getCantidadDeAlumnos() {
		return cantidadDeAlumnos;
	}

	public void setCantidadDeAlumnos(Integer cantidadDeAlumnos) {
		this.cantidadDeAlumnos = cantidadDeAlumnos;
	}

}
