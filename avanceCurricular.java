package proyectoPrograAvanzada;

import java.util.*;

class Alumno {
    private String nombreAlumno;
    private int rut;
    private ArrayList<Asignatura> asignaturas;

    public Alumno(String nombreAlumno, int rut) {
        this.nombreAlumno = nombreAlumno;
        this.rut = rut;
        this.asignaturas = new ArrayList<>();
    }

    public int getRut() {
        return rut;
    }

    public String getNombre() {
        return nombreAlumno;
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
        int opcion = 1;
        while (opcion != 0) {
            System.out.println("Menu del Alumno " + alumno.getNombre() + ":");
            System.out.println("1. Agregar asignatura");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
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
                    break;
                case 0:
                    System.out.println("Volviendo al menu principal.");
                    break;
                default:
                    System.out.println("Opcion inválida. Por favor, elija una opcion valida.");
                    break;
            }
        }
        scanner.close();
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
    private HashMap<Integer, Alumno> mapaAlumnosRut;

    public Sistema() {
        alumnos = new ArrayList<Alumno>();
        mapaAlumnosNombre = new HashMap<>();
        mapaAlumnosRut = new HashMap<>();
    }

    public void agregarAlumno(Alumno nuevoAlumno) {
        alumnos.add(nuevoAlumno);
        mapaAlumnosNombre.put(nuevoAlumno.getNombre(), nuevoAlumno);
        mapaAlumnosRut.put(nuevoAlumno.getRut(), nuevoAlumno);
    }

    public void eliminarAlumno(Alumno alumnoParaEliminar) {
        alumnos.remove(alumnoParaEliminar);
        mapaAlumnosNombre.remove(alumnoParaEliminar.getNombre());
        mapaAlumnosRut.remove(alumnoParaEliminar.getRut());
    }

    public void listarAlumnosNombre() {
        Set<String> nombres = mapaAlumnosNombre.keySet();

        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }


    public Alumno obtenerAlumno(String nombre) {
        return mapaAlumnosNombre.get(nombre);
    }

    public Alumno obtenerAlumno(int rut) {
        return mapaAlumnosRut.get(rut);
    }

}

public class avanceCurricular {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        Scanner scanner = new Scanner(System.in);

        Alumno alumno1 = new Alumno("Juan", 12345678);
        sistema.agregarAlumno(alumno1);
        Alumno alumno2 = new Alumno("Pedro", 87654321);
        sistema.agregarAlumno(alumno2);
        Alumno alumno3 = new Alumno("Maria", 13579246);
        sistema.agregarAlumno(alumno3);
        Alumno alumno4 = new Alumno("Jose", 24681357);
        sistema.agregarAlumno(alumno4);

        System.out.println("Ingrese el nombre o rut (sin puntos ni guion) del alumno que desea buscar: ");
        String nombreO_RutAlumnoMostrar = scanner.nextLine();

        Alumno alumnoMostrar = null;

        
        try {
            int rut = Integer.parseInt(nombreO_RutAlumnoMostrar);
            alumnoMostrar = sistema.obtenerAlumno(rut);
        } catch (NumberFormatException e) {
            
            alumnoMostrar = sistema.obtenerAlumno(nombreO_RutAlumnoMostrar);
        }

        while (alumnoMostrar == null) {
            System.out.println(
                    "No se encontro el alumno. Ingrese nuevamente el nombre o rut del alumno que desea buscar: ");
            nombreO_RutAlumnoMostrar = scanner.nextLine();
            
            try {
                int rut = Integer.parseInt(nombreO_RutAlumnoMostrar);
                alumnoMostrar = sistema.obtenerAlumno(rut);
            } catch (NumberFormatException e) {
                
                alumnoMostrar = sistema.obtenerAlumno(nombreO_RutAlumnoMostrar);
            }
        }

        Menu menuAlumnoMostrar = new Menu(alumnoMostrar);
        menuAlumnoMostrar.mostrarMenuAlumno();

        scanner.close();
    }

}
