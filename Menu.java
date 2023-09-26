/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avancecurricular;

import java.util.*;

public class Menu {
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
            System.out.println("2. Listar asignaturas");
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
                case 2:
                    System.out.println("Asignaturas del alumno " + alumno.getNombre() + ":");
                    String separador = "+---------------------+---------------------+----------+";
                    System.out.println(separador);
                    System.out.printf("| %-20s | %-20s | %-8s |\n", "Asignatura", "Profesor", "Créditos");
                    System.out.println(separador);
                    for (Asignatura asignatura : alumno.getAsignaturas()) {
                        String nombre = asignatura.getNombreAsignatura();
                        String profesor = asignatura.getNombreProfesor();
                        int creditosAsignatura = asignatura.getCreditos();
                        System.out.printf("| %-20s | %-20s | %-8d |\n", nombre, profesor, creditosAsignatura);
                    }
                    System.out.println(separador);
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

