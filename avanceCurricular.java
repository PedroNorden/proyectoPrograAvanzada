package proyectoPrograAvanzada;
class Alumno {
    private String nombreAlumno;
    private Asignatura[] asignaturas;

    public Alumno(String nombreAlumno, Asignatura[] asignaturas) {
        this.nombreAlumno = nombreAlumno;
        this.asignaturas = asignaturas;
    }

    public void agregarAsignaturas(Asignatura nuevaAsignatura) {
        Asignatura[] nuevasAsignaturas = new Asignatura[asignaturas.length + 1];

        for(int i = 0 ; i < asignaturas.length ; i++) {
            nuevasAsignaturas[i] = asignaturas[i];
        }

        nuevasAsignaturas[asignaturas.length] = nuevaAsignatura;

        asignaturas = nuevasAsignaturas;
    }
}

class Asignatura {
    private String nombreAsignatura;
    private String nombreProfesor;
    private int creditos;
    private boolean completada;
    
    public Asignatura(String nombreAsignatura, String nombreProfesor, int creditos) {
        this.nombreAsignatura = nombreAsignatura;
        this.nombreProfesor = nombreProfesor;
        this.creditos = creditos;
    }
    
    public void marcarComoCompletada() {
        completada = true;
    }

    public boolean isCompletada() {
        return completada;
    }

}

class Sistema{
    private Alumno[] alumnos;

    public Sistema(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }
}




public class avanceCurricular{
    public static void main(String[] args) {


    }
}
