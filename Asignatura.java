/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avancecurricular;

public class Asignatura {
    private String codigoId;
    private String nombreAsignatura;
    private String profesor;
    private int creditos;
    private boolean completada;

    public Asignatura(String codigoId, String nombreAsignatura, String profesor, int creditos) {
        this.codigoId = codigoId;
        this.nombreAsignatura = nombreAsignatura;
        this.profesor = profesor;
        this.creditos = creditos;
    }

    public String getCodigoId() {
        return codigoId;
    }
    
    public void marcarComoCompletada() {
        completada = true;
    }

    public boolean isCompletada() {
        return completada;
    }

    public String getProfesor(){
        return profesor;
    }
    
    public int getCreditos() {
        return creditos;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

}
