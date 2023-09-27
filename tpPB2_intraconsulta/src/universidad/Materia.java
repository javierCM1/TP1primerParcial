package universidad;

import java.util.ArrayList;

public class Materia {

	private Integer codigoMateria;
	private String nombre;
	private ArrayList<Materia> correlativas;
	private boolean aprobado;

	public Materia(Integer codigoMateria, String nombre) {
		super();
		this.codigoMateria = codigoMateria;
		this.nombre = nombre;
		this.correlativas = new ArrayList<>();
		this.aprobado = false;
	}
	
	

	public boolean isAprobado() {
		return aprobado;
	}

	public void setAprobado(boolean aprobado) {
		this.aprobado = aprobado;
	}



	public Integer getCodigoMateria() {
		return codigoMateria;
	}

	public void setCodigoMateria(Integer codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Materia> getCorrelativas() {
		return correlativas;
	}

	public boolean agregarMateriaCorrelativa(Materia materiaCorrelativa) {
		return correlativas.add(materiaCorrelativa);
	}

	public boolean eliminarMateria(Materia materiaCorrelativa) {
		return correlativas.remove(materiaCorrelativa);
	}

	public Materia buscarMateriaCorrelativa(Integer codigoCorrelativa) {
		for (Materia correlativa : correlativas) {
			if (correlativa.getCodigoMateria().equals(codigoCorrelativa)) {
				return correlativa;
			}
		}
		return null;
	}

}
