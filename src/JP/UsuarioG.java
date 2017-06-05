/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JP;

import Excepciones.ArchivoNoExiste;
import Excepciones.FormatoInvalido;
import Excepciones.NoSePuedeEscribirArchivo;
import Ventanas.Seguridad;
import java.io.BufferedWriter;
import java.io.File;
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
public class UsuarioG {
    public static final File LOGGED_USER_DEFAULT_FILE= new File("login.conf");
    private String user="", pass="";
    private byte[] passBytes=null;
    public UsuarioG(String user, String pass){
        this.user=user;
        this.pass=pass;
    }
    public UsuarioG(){}
    public UsuarioG(File archivo) throws ArchivoNoExiste, FormatoInvalido{
        try {
            if(archivo.exists()){
                user=pass="";
                passBytes=null;
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
                    //Leemos el nombre de usuario
                    while(leer!=0){
                        user+=(char)leer;
                        leer=file.read();
                    }
                    leer=file.read();
                    //Leemos la contraseña, encriptada, del usuario del sistema
                    ArrayList<Byte> contraTemp= new ArrayList<>();
                    while(leer!=-1){
                        contraTemp.add((byte)leer);
                        leer=file.read();
                    }
                    passBytes=new byte[contraTemp.size()];
                    for(int i=0;i<contraTemp.size();i++){
                        passBytes[i]=contraTemp.get(i);
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
                archivo.writeBytes(user);
                //Escribimos el separador
                archivo.write(0);
                //Escribimos la contraseña (cifrada) y cerramos el archivo
                archivo.write(passBytes);
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

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public byte[] getPassBytes() {
        return passBytes;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setPassBytes(byte[] passBytes) {
        this.passBytes = passBytes;
    }
    
}
