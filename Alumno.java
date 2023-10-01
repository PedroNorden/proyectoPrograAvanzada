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


    public boolean agregarAsignaturas(Asignatura nuevaAsignatura) {
    for (Asignatura asignatura : asignaturas) {
        if (asignatura.getCodigoId().equals(nuevaAsignatura.getCodigoId())) {
            if (!asignatura.isCompletada()) {
                
                return false;
            } else {
                return false;
            }
        }
    }
    asignaturas.add(nuevaAsignatura);
    
    return true;
}

    public Boolean desinscribirAsignatura(Asignatura asignaturaADesinscribir)
    {
        if(!asignaturas.contains(asignaturaADesinscribir)){
            return false;
        }
        asignaturas.remove(asignaturaADesinscribir);
        return true;
    }
    
    public Boolean aprobarAsignatura(Asignatura asignaturaAprobada){
        if(!asignaturas.contains(asignaturaAprobada)){
            return false;
        }
        for(int k = 0; k < asignaturas.size(); k++){
            
            if(asignaturaAprobada.getNombreAsignatura().equals(asignaturas.get(k).getNombreAsignatura())){
                asignaturas.get(k).marcarComoCompletada();
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }
}
