package proyectoPrograAvanzada;
class Alumno {
    private String nombreAlumno;
    private Asignatura[] asignaturas;

    public Alumno(String nombreAlumno, Asignatura[] asignaturas) {
        this.nombreAlumno = nombreAlumno;
    }
}

class Asignatura {
    private String nombreAsignatura;
    private String nombreProfesor;
    private int creditos;

    public Asignatura(String nombreAsignatura, String nombreProfesor, int creditos) {
        this.nombreAsignatura = nombreAsignatura;
        this.nombreProfesor = nombreProfesor;
        this.creditos = creditos;
    }
}

class Sistema{
    private Alumno[] alumnos;
}


public class avanceCurricular{
    public static void main(String[] args) {


    }
}