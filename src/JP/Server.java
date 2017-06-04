/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JP;

import Excepciones.*;
import Ventanas.Seguridad;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juampa
 */
public class Server {
    private String ip="localhost", pass="", user="",bd="";
    public Server(){}
    public Server(String ip,String pass, String bd){
        this.ip=ip;
        this.pass=pass;
        this.bd=bd;
    }
    public Server (File archivo) throws FileNotFoundException, FormatoInvalido, ArchivoNoExiste{
        try {
            if(archivo.exists()){
                ip=pass=bd="";
                //Creamos un RandomAccessFile para leer el archivo de configuración
                RandomAccessFile file = new RandomAccessFile(archivo, "r");
                //Vamos leyendo el archivo
                int leer=file.read();
                //Leemos los primeros 3 bytes del archivo para saber si la marca del archivo es correcta
                String marca="";
                while(leer!=83||leer!=67||leer!=69){
                    marca+=leer;
                    leer=file.read();
                }
                //Si la marca del archivo coincide, seguimos leyendo
                if(marca.equals("SCE")){
                    //Leemos hasta encontrar el separador (byte 0)
                    //Leemos la IP del servidor donde esta el SGBD
                    while(leer!=0){
                        ip+=(char)leer;
                        leer=file.read();
                    }
                    leer=file.read();
                    //Leemos el nombre de la BD
                    while(leer!=0){
                        bd+=(char)leer;
                        leer=file.read();
                    }
                    leer=file.read();
                    //Leemos el usuario del SGBD
                    while(leer!=0){
                        user+=(char)leer;
                        leer=file.read();
                    }
                    leer=file.read();
                    //Leemos la contraseña, encriptada, al SGBD, hasta el final del archivo
                    while(leer!=-1){
                        pass+=(char)leer;
                        leer=file.read();
                    }
                }else{
                    throw new FormatoInvalido("El archivo no es válido");
                }
            }else{
                throw new ArchivoNoExiste("El archivo de configuración no exise");
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribirArchivo(File file){
        try {
            if(!file.exists()){
                RandomAccessFile archivo= new RandomAccessFile(file,"rw");
                archivo.writeBytes(Seguridad.marcaInicio);
                
            }else{
                file.delete();
                escribirArchivo(file);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public void setBd(String bd) {
        this.bd = bd;
    }
    public String getIp() {
        return ip;
    }
    public String getPass() {
        return pass;
    }
    public String getBd() {
        return bd;
    }
    public String getUser() {
        return user;
    }
    
}
