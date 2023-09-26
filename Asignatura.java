/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avancecurricular;

public class Asignatura {
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

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public int getCreditos() {
        return creditos;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

}
