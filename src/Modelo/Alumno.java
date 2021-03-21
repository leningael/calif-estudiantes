package Modelo;

public class Alumno {
    private String matricula;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private String asignatura;
    private double calif;

    public Alumno(String matricula, String apellidoPaterno, String apellidoMaterno, String nombres) {
        this.matricula = matricula;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;
        this.asignatura = "Disenio de Software";
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public double getCalif() {
        return calif;
    }

    public void setCalif(double calif) {
        this.calif = calif;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
    
    

    @Override
    public String toString() {
        return "Matricula: " + getMatricula() + ", Apellido Paterno: " + getApellidoPaterno() + ", Apellido Materno: " + getApellidoMaterno()
                + ", Nombres: " + getNombres();
    }
}
