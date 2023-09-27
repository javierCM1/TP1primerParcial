package universidad;

public class RegistroMateriaAprobada {
    private Integer dni;
    private String nombre;
    private String apellido;
    private String nombreMateria;
    private Integer nota;
    private String descripcion;
    private Integer cicloLectivo;

   

    // Getters y setters (métodos para acceder y modificar los campos)

    public RegistroMateriaAprobada(Integer dni, String nombre, String apellido, String nombreMateria, Integer notaFinal,
			Integer cicloLectivo) {
    	 this.dni = dni;
         this.nombre = nombre;
         this.apellido = apellido;
         this.nombreMateria = nombreMateria;
         this.nota = notaFinal;
         this.cicloLectivo = cicloLectivo;
	}

	

	public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCicloLectivo() {
        return cicloLectivo;
    }

    public void setCicloLectivo(Integer cicloLectivo) {
        this.cicloLectivo = cicloLectivo;
    }
}