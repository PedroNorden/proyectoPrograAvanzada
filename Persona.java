/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avancecurricular;

/**
 *
 * @author pedro
 */
public class Persona {
    private String nombre;
    private int rut;
    
    public Persona(String nombre, int rut){
        this.nombre = nombre;
        this.rut = rut;
    }
    
    public int getRut() {
        return rut;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setRut(int rut){
        this.rut = rut;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
