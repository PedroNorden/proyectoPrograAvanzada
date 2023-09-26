/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avancecurricular;

import java.util.*;

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

        int opcionPrincipal = 1;

        while (opcionPrincipal != 0) {
            System.out.println("Menu Principal:");
            System.out.println("1. Ingresar a Avance Curricular");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opcion: ");
            opcionPrincipal = scanner.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    scanner.nextLine(); // Consumir la nueva línea pendiente
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
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
                    break;
            }
        }

        scanner.close();
    }

}
