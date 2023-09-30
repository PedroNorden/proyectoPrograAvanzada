/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avancecurricular;

import java.util.*;

public class Alumno extends Persona {

    private ArrayList<Asignatura> asignaturas;

    public Alumno(String nombre, int rut) {
        super(nombre, rut);
        this.asignaturas = new ArrayList<>();
    }


    public void agregarAsignaturas(Asignatura nuevaAsignatura) {
        asignaturas.add(nuevaAsignatura);
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }
}
