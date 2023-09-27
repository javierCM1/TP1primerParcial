package universidad;

public class ReporteNotasAlumno {
    private int idCurso;
    private String nombreMateria;
    private int dni;
    private String nombre;
    private String apellido;
    private int nota;

    public ReporteNotasAlumno(int idCurso, String nombreMateria, int dni, String nombre, String apellido, int nota) {
        this.idCurso = idCurso;
        this.nombreMateria = nombreMateria;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota = nota;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
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

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
