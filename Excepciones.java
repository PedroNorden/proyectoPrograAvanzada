/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avancecurricular;


public class Excepciones {
    
    public static class AlumnoNoEncontradoException extends Exception {
        public AlumnoNoEncontradoException(String mensaje) {
            super(mensaje);
        }
    }
     
    public class OpcionInvalidaException extends Exception {
        public OpcionInvalidaException(String mensaje) {
            super(mensaje);
        }
    }
    
}
