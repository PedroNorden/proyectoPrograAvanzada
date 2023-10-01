/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avancecurricular;

import java.util.*;

public class Sistema {
    private ArrayList<Alumno> alumnos;
    private HashMap<String, Alumno> mapaAlumnosNombre;
    private HashMap<Integer, Alumno> mapaAlumnosRut;
    private ArrayList<Asignatura> ramosDisponibles;

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
    String nombreBuscado = nombre.toLowerCase();
    for (Alumno alumno : alumnos) {
        String nombreAlumno = alumno.getNombre().toLowerCase();
        if (nombreAlumno.equals(nombreBuscado)) {
            return alumno;
        }
    }
    return null;
    }

    public Alumno obtenerAlumno(int rut) {
        return mapaAlumnosRut.get(rut);
    }

    public ArrayList<Alumno> getListaAlumnos(){
        return alumnos;
    }
}

