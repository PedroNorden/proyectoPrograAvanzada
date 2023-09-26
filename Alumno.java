/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avancecurricular;

import java.util.*;

public class Alumno {
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

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }
}