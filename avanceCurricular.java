/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avancecurricular;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);

        
        CSV alumnos = new CSV("src/main/java/com/mycompany/avancecurricular/nombresRut");
        String linea = alumnos.firstLine();
        while (linea != null) {
            Persona alumnoActual = new Alumno("0", 0);
            alumnoActual.setNombre(alumnos.get_csvField(linea, 0));
            int rut = Integer.parseInt(alumnos.get_csvField(linea, 1));
            alumnoActual.setRut(rut);
            Alumno nuevoAlumno = (Alumno) alumnoActual;
            sistema.agregarAlumno(nuevoAlumno);
            linea = alumnos.nextLine();
        }

        int opcionPrincipal = 1;

        while (opcionPrincipal != 0) {
            System.out.println("Menu Principal:");
            System.out.println("1. Ingresar a Avance Curricular");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opcion: ");
            opcionPrincipal = scanner.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Ingrese el nombre o rut (sin puntos ni guion) del alumno que desea buscar: ");
                    String nombreO_RutAlumnoMostrar = scanner.nextLine();

                    Alumno alumnoMostrar = null;

                    // Intentar buscar al alumno por rut o nombre
                    try {
                        int rut = Integer.parseInt(nombreO_RutAlumnoMostrar);
                        alumnoMostrar = sistema.obtenerAlumno(rut);
                    } catch (NumberFormatException e) {
                        alumnoMostrar = sistema.obtenerAlumno(nombreO_RutAlumnoMostrar);
                    }

                    if (alumnoMostrar == null) {
                        System.out.println("El alumno '" + nombreO_RutAlumnoMostrar + "' no se encuentra en el sistema.");
                    } else {
                        Menu menuAlumnoMostrar = new Menu(alumnoMostrar);
                        menuAlumnoMostrar.mostrarMenuAlumno();
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
                    break;
            }
        }

        scanner.close();
    }
}
