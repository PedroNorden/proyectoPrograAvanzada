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
public class Profesor extends Persona{
    private String catedra;
    
    public Profesor(String nombre, int rut, String catedra)
    {
        super(nombre, rut);
        this.catedra = catedra;
    }
    
    public String getCatedra(){
        return this.catedra;
    }
    
    public void setCatedra(String catedra){
        this.catedra = catedra;
    }
}
