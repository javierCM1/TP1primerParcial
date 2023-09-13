package intraconsulta;

import java.util.ArrayList;


public class Materia {
	
	private Integer codigoMateria;
	private String nombre;
	private ArrayList<Materia> correlativas;
	

	public Materia(Integer codigoMateria, String nombre) {
		super();
		this.codigoMateria = codigoMateria;
		this.nombre = nombre;
		this.correlativas = new ArrayList<>();
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

	
}




