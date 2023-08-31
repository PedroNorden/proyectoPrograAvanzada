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

        for (int i = 0; i < asignaturas.length; i++) {
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

class Sistema {
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

    public void eliminarAlumno(Alumno alumnoParaEliminar) {
        alumnos.remove(alumnoParaEliminar);
        mapaAlumnosNombre.remove(alumnoParaEliminar.nombreAlumno, alumnoParaEliminar);
    }

    public void listarAlumnosNombre() {
        Set<String> nombres = mapaAlumnosNombre.keySet();

        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }

    public Alumno obtenerAlumnoPorNombre(String nombre) {
        return mapaAlumnosNombre.get(nombre);
    }

}

public class avanceCurricular {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Agregar asignatura a alumno");
            System.out.println("2. Salir");
            System.out.print("Selecciona una opcion: ");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                scanner.nextLine();
                System.out.print("Ingrese el nombre del alumno: ");
                String nombreAlumno = scanner.nextLine();

                Alumno alumno = sistema.obtenerAlumnoPorNombre(nombreAlumno);
                if (alumno != null) {
                    System.out.print("Ingrese el nombre de la asignatura: ");
                    String nombreAsignatura = scanner.nextLine();
                    System.out.print("Ingrese el nombre del profesor: ");
                    String nombreProfesor = scanner.nextLine();
                    System.out.print("Ingrese la cantidad de creditos: ");
                    int creditos = scanner.nextInt();

                    Asignatura nuevaAsignatura = new Asignatura(nombreAsignatura, nombreProfesor, creditos);
                    alumno.agregarAsignaturas(nuevaAsignatura);
                    System.out.println("Asignatura agregada con exito.");
                } else {
                    System.out.println("Alumno no encontrado.");
                }
            } else if (opcion == 2) {
                System.out.println("Saliendo del programa.");
                break;
            } else {
                System.out.println("Opcion inválida. Por favor, elija una opción valida.");
            }
        }

    }
}
