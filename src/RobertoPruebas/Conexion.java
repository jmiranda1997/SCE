/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RobertoPruebas;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Roberto
 */
public class Conexion {
    private static Connection conexion;//variable que servira para la conexión a la base de datos
    private static final String driver="com.mysql.jdbc.Driver", url="jdbc:mysql://"; //variables que serivran en la conexion, estas nunca deben ser modificados
    private static String user="root", ip="localhost", pass=""; //Variables que pueden ser modificadas y por defecto son las que se muestran
    public Conexion()
    {
        
    }
    /**
     * Metodo que genera la conexion utilizando los atributos de esta clase
     */
    private void conectar()
    {
       conexion=null;
        try{
            try {
            Class.forName(driver);//Se utiliza el driver de conexion
            } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de MySQL: " + ex);
        }
            conexion=DriverManager.getConnection(url+ip+"/"+"sce",user,"@Sistemas2017");//Se conecta con la base de datos enviando
            //los parametros url, user, pass,
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Función para crear un nuevo proveedor
     * @param Nombre
     * @param Nit
     * @param Credito
     * @throws SQLException 
     */
    public void crearProveedor(String Nombre, String Nit, boolean Credito) throws SQLException{
        conectar();
        Statement instruccion = conexion.createStatement();
        int credito = 0;
        String NitReal = "No Aplica";
        if (Credito) {
            credito = 1;
        }
        if (!Nit.equals("") && !Nit.equals("INGRESE EL NIT DEL PROVEEDOR (SI APLICA)")) {
            NitReal = Nit;
        }
        instruccion.executeUpdate("INSERT INTO proveedor (Nombre, Nit, Credito) VALUES ('"+ Nombre +"', '"+ NitReal +"', "+ credito +");");
        conexion.close();
    }
    private void iniciarTabla() {
        Proveedores = new DefaultTableModel();
        Proveedores.addColumn("Nombre");
        Proveedores.addColumn("Nit");
        Proveedores.addColumn("Credito");
        Proveedores.addColumn("Saldo");
    }
    private DefaultTableModel Proveedores;
    /**
     * Metodo que regresa la lista de proveedores como un arreglo
     * @return
     * @throws SQLException 
     */
    public DefaultTableModel obtenerProceedores() throws SQLException{
         Proveedores = null;
        iniciarTabla();
        
        conectar();
        Statement instruccion = conexion.createStatement();
        ResultSet resultado = instruccion.executeQuery("SELECT Nombre, Nit, Credito, Saldo FROM proveedor;");
        while(resultado.next()){
            Proveedores.addRow(new String[] {resultado.getString("Nombre"), resultado.getString("Nit"), (resultado.getString("Credito").equals("1"))? "SI": "NO", resultado.getString("Saldo")});
        }
        conexion.close();
        return Proveedores;
    }
    public int cantidadProveedores() throws SQLException{
        int cant = 0;
        
        conectar();
        Statement instruccion = conexion.createStatement();
        ResultSet resultado = instruccion.executeQuery("SELECT COUNT(*) Cantidad FROM proveedor;");
        while(resultado.next()){
            cant = resultado.getInt("Cantidad");
        }
        conexion.close();
        return cant;
    }
    public void ejemploDeUso() throws SQLException{
        conectar(); //permite la conexion con la base de datos
        Statement instruccion=conexion.createStatement(); //Crea una nueva instruccion para la base de datos
        ResultSet resultado = instruccion.executeQuery("select * from unidad"); //se guarda el resultado de la instruccion, en esta ocasion, es una consulta
        while(resultado.next())//Es una funcion booleana que mueve el cursor del resultado, si este es TRUE, aun hay registros de resultado
        {
            System.out.println(resultado.getInt(1)+"    "+resultado.getString("Nombre"));
            //para extraer los datos del resultado de la instruccion, pueden obtenerse en diferentes tipos de variable
            //Y pueden buscarse por numero de columna (iniciando en 1) o nombre de columna
        }
        conexion.close();
    }

}
