/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avancecurricular;

import java.util.*;
import java.io.*;

public class Menu {
    private Alumno alumno;
    private Scanner scanner;
    private ArrayList<Asignatura> ramosDisponibles;

    public Menu(Alumno alumno) {
        this.alumno = alumno;
        this.scanner = new Scanner(System.in);
        this.ramosDisponibles = cargarListaDeRamosDisponiblesDesdeCSV(); 
    }   

    public void mostrarMenuAlumno() {
        int opcion = 1;
        while (opcion != 0) {
            System.out.println("Menu del Alumno " + alumno.getNombre() + ":");
            
            mostrarRamosInscritos();
            int totalCreditos = calcularTotalCreditosAsignaturas();
            int creditosInscritos = calcularCreditosInscritos();
            double porcentajeAvance = (creditosInscritos * 100.0) / totalCreditos;

            System.out.printf("| Total de créditos: %-21d | Creditos inscritos %-21d | Porcentaje de avance academico %-1.1f%% |%n", totalCreditos, creditosInscritos, porcentajeAvance);
            System.out.println("1. Inscribir asignatura");
            System.out.println("2. Desinscribir asignatura");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    inscribirRamo();
                    break;
                case 2:
                    desinscribirRamo();
                    break;
                
            }
        }
    }

    private void cargarYMostrarRamos() {
        try {
            CSV ramosCSV = new CSV("src/main/java/com/mycompany/avancecurricular/MallaRamos");
            String linea = ramosCSV.firstLine();

            System.out.println("+------------------+----------------------------------------------------+----------------------+----------+");
            System.out.println("| Código Ident.    | Nombre de la Asignatura                            | Profesor             | Créditos |");
            System.out.println("+------------------+----------------------------------------------------+----------------------+----------+");

            while (linea != null) {
                String codigoIdentificador = ramosCSV.get_csvField(linea, 0);
                String nombreRamo = ramosCSV.get_csvField(linea, 1);
                String nombreProfesor = ramosCSV.get_csvField(linea, 2);
                int creditos = Integer.parseInt(ramosCSV.get_csvField(linea, 3));

                // Aquí se muestra el nombre del profesor directamente
                System.out.printf("| %-16s | %-50s | %-20s | %-8d |%n", codigoIdentificador, nombreRamo, nombreProfesor, creditos);

                linea = ramosCSV.nextLine();
            }

            System.out.println("+------------------+----------------------------------------------------+----------------------+----------+");

            ramosCSV.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo MallaRamos.");
        } catch (IOException e) {
            System.out.println("Error de lectura del archivo MallaRamos.");
        }
    }
    
    private Asignatura buscarRamoPorCodigo(String codigo) {
        // Cargar la lista de ramos disponibles desde el archivo CSV
        ArrayList<Asignatura> listaDeRamosDisponibles = cargarListaDeRamosDisponiblesDesdeCSV();

        // Realizar la búsqueda en la lista de ramos disponibles
        for (Asignatura ramo : listaDeRamosDisponibles) {
            if (ramo.getCodigoId().equals(codigo)) {
                return ramo; // Se encontró el ramo
            }
        }
        return null; // No se encontró el ramo con el código identificador dado
    }
    private ArrayList<Asignatura> cargarListaDeRamosDisponiblesDesdeCSV() {
        ArrayList<Asignatura> listaDeRamos = new ArrayList<>();
        try {
            CSV ramosCSV = new CSV("src/main/java/com/mycompany/avancecurricular/MallaRamos");
            String linea = ramosCSV.firstLine();

            while (linea != null) {
                String codigoIdentificador = ramosCSV.get_csvField(linea, 0);
                String nombreRamo = ramosCSV.get_csvField(linea, 1);
                String nombreProfesor = ramosCSV.get_csvField(linea, 2);
                int creditos = Integer.parseInt(ramosCSV.get_csvField(linea, 3));

                Asignatura ramo = new Asignatura(codigoIdentificador, nombreRamo, nombreProfesor, creditos);
                listaDeRamos.add(ramo);

                linea = ramosCSV.nextLine();
            }

            ramosCSV.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo MallaRamos.");
        } catch (IOException e) {
            System.out.println("Error de lectura del archivo MallaRamos.");
        }
        return listaDeRamos;
    }
    
    private void mostrarRamosInscritos(){
        
        System.out.println("+------------------+----------------------------------------------------+----------+");
        System.out.println("| Código Ident.    | Nombre de la asignatura                            | Créditos |");
        System.out.println("+------------------+----------------------------------------------------+----------+");
        for (Asignatura asignatura : alumno.getAsignaturas()) {
            System.out.printf("| %-16s | %-50s | %-8d |%n", asignatura.getCodigoId(), asignatura.getNombreAsignatura(), asignatura.getCreditos());
        }
        System.out.println("+------------------+----------------------------------------------------+----------+");
    }
       
    private void inscribirRamo(){
        
        scanner.nextLine();
        System.out.println("Inscribir ramos:");

        cargarYMostrarRamos();
                    
        System.out.print("Ingrese el código identificador de la asignatura que desea inscribir: ");
        String codigoRamoInscribir = scanner.nextLine();
     
        Asignatura ramoInscribir = buscarRamoPorCodigo(codigoRamoInscribir);

        if (ramoInscribir == null) {
            System.out.println("El código identificador ingresado no corresponde a ningúna asignatura .");
        } else { 
            boolean agregado = alumno.agregarAsignaturas(ramoInscribir);
            if (agregado) {
            System.out.println("Asignatura '" + ramoInscribir.getNombreAsignatura() + "' inscrita con éxito.");
            } else {
            System.out.println("La asignatura '" + ramoInscribir.getNombreAsignatura() + "' ya está inscrita.");
        }
        }
        
    }
    
    private void desinscribirRamo() {
        
        mostrarRamosInscritos();
        scanner.nextLine();
        System.out.print("Ingrese el código de la asignatura que desea desinscribir: ");
        String codigoRamoDesinscribir = scanner.nextLine();


        Asignatura asignaturaADesinscribir = null;
        for (Asignatura asignatura : alumno.getAsignaturas()) {
            if (asignatura.getCodigoId().equals(codigoRamoDesinscribir)) {
                asignaturaADesinscribir = asignatura;
                break;
            }
        }

        if (asignaturaADesinscribir != null) {

            boolean desinscrito = alumno.desinscribirAsignatura(asignaturaADesinscribir);
            if (desinscrito) {
                System.out.println("Asignatura '" + asignaturaADesinscribir.getNombreAsignatura() + "' desinscrita con éxito.");
            } 
            
        } else {
            System.out.println("No se encontró la asignatura con el código ingresado.");
        }
    }
    
    private int calcularTotalCreditosAsignaturas() {
        int totalCreditos = 0;
        for (Asignatura asignatura : ramosDisponibles) {
            totalCreditos += asignatura.getCreditos();
        }
        return totalCreditos;
    }
    
    private int calcularCreditosInscritos() {
        int creditosInscritos = 0;
        for (Asignatura asignatura : alumno.getAsignaturas()) {
            creditosInscritos += asignatura.getCreditos();
        }
        return creditosInscritos;
    }
    
    private double calcularPorcentajeAvance() {
        int totalCreditos = calcularTotalCreditosAsignaturas();
        int creditosInscritos = calcularCreditosInscritos();
        if (totalCreditos > 0) {
            return (double) creditosInscritos / totalCreditos * 100;
        } else {
            return 0.0;
        }   
    }
}

