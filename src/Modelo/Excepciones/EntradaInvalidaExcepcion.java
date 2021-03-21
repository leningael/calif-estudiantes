/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Excepciones;

/**
 *
 * @author lenin
 */
public class EntradaInvalidaExcepcion extends RuntimeException{
    public EntradaInvalidaExcepcion(String message) {
        super(message);
    }
}
