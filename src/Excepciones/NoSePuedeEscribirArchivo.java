/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author Juampa
 */
public class NoSePuedeEscribirArchivo extends Exception {
    public NoSePuedeEscribirArchivo(String msj){
        super(msj);
    }
}
