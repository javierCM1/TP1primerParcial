package intraconsulta;

public class Curso {
	
	private Integer codigo;
	private Materia materia;
	private Integer cicloLectivo;
	private Aula aula;
	private String dia;
	/**
	 * @param codigo
	 * @param materia
	 * @param cicloLectivo
	 * @param aula
	 */
	public Curso(Integer codigo, Materia materia, Integer cicloLectivo, Aula aula) {
		super();
		this.codigo = codigo;
		this.materia = materia;
		this.cicloLectivo = cicloLectivo;
		this.aula = aula;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public Integer getCicloLectivo() {
		return cicloLectivo;
	}
	public void setCicloLectivo(Integer cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}
	public Aula getAula() {
		return aula;
	}
	public void setAula(Aula aula) {
		this.aula = aula;
	}
	
	
	

	
	
}
