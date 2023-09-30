/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avancecurricular;

public class Asignatura {
    private String nombreAsignatura;
    private Profesor profesor;
    private int creditos;
    private boolean completada;

    public Asignatura(String nombreAsignatura, Profesor profesor, int creditos) {
        this.nombreAsignatura = nombreAsignatura;
        this.profesor = profesor;
        this.creditos = creditos;
    }

    public void marcarComoCompletada() {
        completada = true;
    }

    public boolean isCompletada() {
        return completada;
    }

    public Profesor getProfesor(){
        return profesor;
    }
    
    public int getCreditos() {
        return creditos;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

}
