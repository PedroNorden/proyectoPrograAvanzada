import java.util.*;

class Alumno {
    public String nombreAlumno;
    public String rut;
    private ArrayList<Asignatura> asignaturas;

    public Alumno(String nombreAlumno, String rut) {
        this.nombreAlumno = nombreAlumno;
        this.rut = rut;
        this.asignaturas = new ArrayList<>();
    }

    public void agregarAsignaturas(Asignatura nuevaAsignatura) {
        asignaturas.add(nuevaAsignatura);
    }
}

class Menu {
    private Alumno alumno;
    private Scanner scanner;

    public Menu(Alumno alumno) {
        this.alumno = alumno;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenuAlumno() {
        while (true) {
            System.out.println("Menu del Alumno " + alumno.nombreAlumno + ":");
            System.out.println("1. Agregar asignatura");
            System.out.println("2. Salir");
            System.out.print("Selecciona una opcion: ");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                scanner.nextLine();
                System.out.print("Ingrese el nombre de la asignatura: ");
                String nombreAsignatura = scanner.nextLine();
                System.out.print("Ingrese el nombre del profesor: ");
                String nombreProfesor = scanner.nextLine();
                System.out.print("Ingrese la cantidad de créditos: ");
                int creditos = scanner.nextInt();

                Asignatura nuevaAsignatura = new Asignatura(nombreAsignatura, nombreProfesor, creditos);
                alumno.agregarAsignaturas(nuevaAsignatura);
                System.out.println("Asignatura agregada con exito.");
            } else if (opcion == 2) {
                System.out.println("Volviendo al menu principal.");
                break;
            } else {
                System.out.println("Opcion inválida. Por favor, elija una opcion valida.");
            }
        }
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
    private HashMap<String, Alumna> mapaAlumnosRut;

    public Sistema() {
        alumnos = new ArrayList<Alumno>();
        mapaAlumnosNombre = new HashMap<>();
        mapaAlumnosRut = new HashMap<>();
    }

    public void agregarAlumno(Alumno nuevoAlumno) {
        alumnos.add(nuevoAlumno);
        mapaAlumnosNombre.put(nuevoAlumno.nombreAlumno, nuevoAlumno);
        mapaAlumnosRut.put(nuevoAlumno.rut, nuevoAlumno);
    }

    public void eliminarAlumno(Alumno alumnoParaEliminar) {
        alumnos.remove(alumnoParaEliminar);
        mapaAlumnosNombre.remove(alumnoParaEliminar.nombreAlumno);
        mapaAlumnosRut.remove(alumnoParaEliminar.rut);
    }

    public void listarAlumnosNombre() {
        Set<String> nombres = mapaAlumnosNombre.keySet();

        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }

    public void listarAlumnosRut() {
        Set<String> ruts = mapaAlumnosRut.keyset();

        for(String rut : ruts) {
            System.out.println(rut);
        }
    }

    public Alumno obtenerAlumnoPorNombre(String nombre) {
        return mapaAlumnosNombre.get(nombre);
    }

}

public class avanceCurricular {
    public static void main(String[] args) {

    }
}
