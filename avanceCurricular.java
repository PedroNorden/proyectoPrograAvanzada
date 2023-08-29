import java.util.*;

class Alumno {
    public String nombreAlumno;
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
    private ArrayList<Alumno> alumnos;
    private HashMap<String, Alumno> mapaAlumnosNombre;

    public Sistema() {
        alumnos = new ArrayList();
        mapaAlumnosNombre = new HashMap<>();
    }

    public void agregarAlumno(Alumno nuevoAlumno) {
        alumnos.add(nuevoAlumno);
        mapaAlumnosNombre.put(nuevoAlumno.nombreAlumno, nuevoAlumno);
    }

    public void eliminarAlumno(Alumno alumnoParaEliminar)
    {
        alumnos.remove(alumnoParaEliminar);
        mapaAlumnosNombre.remove(alumnoParaEliminar.nombreAlumno, alumnoParaEliminar);
    }

    public void listarAlumnosNombre(){
        Set<String> nombres = mapaAlumnosNombre.keySet();

        for(String nombre : nombres)
        {
            System.out.println(nombre);
        }
    }

}




public class avanceCurricular{
    public static void main(String[] args) {


    }
}
