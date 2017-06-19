/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JP;

/**
 *
 * @author Juampa
 */
public class Telefono {
    private String numero="", extension="", nombre="";
    private int codigoArea, clienteID;
    public Telefono(){}
    public Telefono(String numero, String extension, String nombre, int codigoAreaID, int clienteID){
        this.numero=numero;
        this.extension=extension;
        this.nombre=nombre;
        this.codigoArea=codigoAreaID;
        this.clienteID=clienteID;
    }

    public String getNumero() {
        return numero;
    }

    public String getExtension() {
        return extension;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigoArea() {
        return codigoArea;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigoArea(int codigoArea) {
        this.codigoArea = codigoArea;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }
    
}
