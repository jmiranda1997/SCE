/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JP;

import Excepciones.*;
import Ventanas.Seguridad;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juampa
 */
public class Server {
    public static final File SERVER_CONFIG_DEFAULT_FILE=new File("server.conf");
    private String ip="localhost", pass="", user="",bd="";
    private byte[] passArray;
    public Server(){}
    public Server(String ip,String user, byte[] passArray, String bd){
        this.ip=ip;
        this.user=user;
        this.passArray=passArray;
        this.bd=bd;
    }
    public Server (File archivo) throws FileNotFoundException, FormatoInvalido, ArchivoNoExiste{
        try {
            if(archivo.exists()){
                ip=pass=bd="";
                passArray=null;
                //Creamos un RandomAccessFile para leer el archivo de configuración
                RandomAccessFile file = new RandomAccessFile(archivo, "r");
                //Vamos leyendo el archivo
                int leer=file.read();
                //Leemos los primeros 3 bytes del archivo para saber si la marca del archivo es correcta
                String marca="";
                if(file.length()>3){
                    for(int i=0;i<3;i++){
                        marca+=(char)leer;
                        leer=file.read();
                    }
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
                    ArrayList<Byte> contraTemp= new ArrayList<>();
                    while(leer!=-1){
                        contraTemp.add((byte)leer);
                        leer=file.read();
                    }
                    passArray=new byte[contraTemp.size()];
                    for(int i=0;i<contraTemp.size();i++){
                        passArray[i]=contraTemp.get(i);
                    }
                    file.close();
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
    public void escribirArchivo(File file) throws NoSePuedeEscribirArchivo{
        try {
            //Comprobamos si el archivo ya existe o si tiene datos
            if(!file.exists()||file.length()==0){
                //Creamos un RandomAccessFile para escribir el archivo
                RandomAccessFile archivo= new RandomAccessFile(file,"rw");
                //Escribimos la marca del archivo
                archivo.writeBytes(Seguridad.marcaInicio);
                //Escribimos la ip
                archivo.writeBytes(ip);
                //Escribimos el separador
                archivo.write(0);
                //Escribimos el nombre de la base de datos
                archivo.writeBytes(bd);
                //Escribimos  separador
                archivo.write(0);
                //Escribimos nombre de usuario
                archivo.writeBytes(user);
                //Separador
                archivo.write(0);
                //Escribimos la contraseña (cifrada) y cerramos el archivo
                archivo.write(passArray);
                archivo.close();
            }else{
                //Si el archivo ya existe y tiene contenido, lo vaciamos
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write("");
                bw.close();
                escribirArchivo(file);    
            }
        } catch (IOException ex) {
            throw new NoSePuedeEscribirArchivo("No puede escribirse en el archivo de configuración");
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
    public void setPassArray(byte[] passArray) {
        this.passArray = passArray;
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
    public byte[] getPassArray() {
        return passArray;
    }
    
}
