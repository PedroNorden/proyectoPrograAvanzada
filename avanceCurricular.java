/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avancecurricular;

import com.mycompany.avancecurricular.Excepciones;
import com.mycompany.avancecurricular.Excepciones.AlumnoNoEncontradoException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class avanceCurricular {
    public static void main(String[] args) throws Excepciones.OpcionInvalidaException, AlumnoNoEncontradoException, FileNotFoundException, IOException {
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
            
            int campoIndex = 2;
            String campo = alumnos.get_csvField(linea, campoIndex);
            while(campo != null){
                
                nuevoAlumno.agregarAsignaturas(campo);
                campoIndex++;
                campo = alumnos.get_csvField(linea, campoIndex);
            }
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

                    try {
                        int rut = Integer.parseInt(nombreO_RutAlumnoMostrar);
                        alumnoMostrar = sistema.obtenerAlumno(rut);
                        if (alumnoMostrar == null) {
                            throw new AlumnoNoEncontradoException("El alumno '" + nombreO_RutAlumnoMostrar + "' no se encuentra en el sistema.");
                        }
                    } catch (NumberFormatException e) {
                        alumnoMostrar = sistema.obtenerAlumno(nombreO_RutAlumnoMostrar);
                        if (alumnoMostrar == null) {
                            throw new AlumnoNoEncontradoException("El alumno '" + nombreO_RutAlumnoMostrar + "' no se encuentra en el sistema.");
                        }
                    } catch (AlumnoNoEncontradoException e) {
                        System.err.println(e.getMessage());
                    }

                    if (alumnoMostrar != null) {
                        Menu menuAlumnoMostrar = new Menu(alumnoMostrar);
                        menuAlumnoMostrar.mostrarMenuAlumno();
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    opcionPrincipal = 0; // Asigna 0 para salir del bucle while
                    break;
                default:
                    try {
                        throw new Excepciones().new OpcionInvalidaException("Opción inválida. Por favor, elija una opción válida.");
                    } catch (Excepciones.OpcionInvalidaException e) {
                        e.printStackTrace();
                    }
                break;
            }
        }
        List<String[]> datos = new ArrayList<>();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/com/mycompany/avancecurricular/nombresRut.csv", true))) {
            for (Alumno alumno : sistema.getListaAlumnos()) {
                String nombre = alumno.getNombre();
                String rut = String.valueOf(alumno.getRut());

                ArrayList<Asignatura> asignaturasList = alumno.getAsignaturas();
                StringBuilder asignaturasStringBuilder = new StringBuilder();

                for (Asignatura asignatura : asignaturasList) {
                    asignaturasStringBuilder.append(asignatura.getNombreAsignatura());
                    asignaturasStringBuilder.append(", ");
                }

                if (!asignaturasList.isEmpty()) {
                    asignaturasStringBuilder.delete(asignaturasStringBuilder.length() - 2, asignaturasStringBuilder.length());
                }

                String asignaturas = asignaturasStringBuilder.toString();

                // Crea un arreglo de strings para cada alumno
                String[] datosAlumno = {nombre, rut, asignaturas};

                // Agrega los datos del alumno a la lista
                datos.add(datosAlumno);
            }

            for (String[] fila : datos) {
                StringBuilder csvLine = new StringBuilder();
                for (int i = 0; i < fila.length; i++) {
                    csvLine.append(fila[i]);
                    if (i < fila.length - 1) {
                        csvLine.append(",");
                    }
                }
                writer.write(csvLine.toString());
                writer.newLine();
            }

            System.out.println("Datos de alumnos exportados a " + "src/main/java/com/mycompany/avancecurricular/nombresRut.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Datos de alumnos exportados a " + "src/main/java/com/mycompany/avancecurricular/nombresRut.csv");    
        scanner.close();
    }
}
