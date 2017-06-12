/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RobertoPruebas;
import Ventanas.DialogodeMensaje;
import Excepciones.*;
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
    private static final String driver="com.mysql.jdbc.Driver", url="jdbc:mysql://"; //variables que serivran en la conexion, estas nunca deben ser modificados0
    private static String user="root", ip="localhost", pass="@Sistemas2017", nombreBD="sce"; //Variables que pueden ser modificadas y por defecto son las que se muestran
    public final static String claveCifradoBase="SCEUser Cifrado AES";
    /**
     * Crea un objeto conexión con datos predeterminados
     */
    public Conexion (){}
    /**
     * Construye un objeto conexión con datos especificos del servidor con el SGBD
     * @param user usuario de acceso
     * @param ip ip del servidor
     * @param pass contraseña del usuario
     * @param db base de datos a conectarse
     */
    public Conexion(String user, String ip, String pass, String db)
    {
        this.user=user;
        this.ip=ip;
        this.pass=pass;
        this.nombreBD=db;
    }
    public Conexion(String user, String pass, String db)
    {
        this.user=user;
        this.pass=pass;
        this.nombreBD=db;
    }
    /**
     * Metodo que genera la conexion utilizando los atributos de esta clase
     * @param nombreBD el nombre de la base de datos a conectarse
     */
    private void conectar() throws NoSePuedeConectar
    {
       conexion=null;
        try{
            Class.forName(driver);//Se utiliza el driver de conexion
            conexion=DriverManager.getConnection(url+ip+"/"+nombreBD,user,pass);//Se conecta con la base de datos enviando
            //los parametros url, user, pass,
        }catch (SQLException|NullPointerException ex) {
            throw new NoSePuedeConectar("No puede conectarse a la BD, error:\n"+ex.toString());
        } catch (ClassNotFoundException ex) {
            throw new NoSePuedeConectar("Error al registrar el driver de MySQL, error:\n" + ex.toString());
        }
    }
    /**
     * Función para crear un nuevo proveedor
     * @param Nombre
     * @param Nit
     * @param Credito
     * @throws SQLException 
     * @throws Excepciones.NoSePuedeConectar en caso de que no se pueda conectar a la BD
     */
    public void crearProveedor(String Nombre, String Nit, boolean Credito) throws SQLException, NoSePuedeConectar{
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
        if (!existeProveedor(Nombre, Nit)) {
            instruccion.executeUpdate("INSERT INTO proveedor (Nombre, Nit, Credito) VALUES ('"+ Nombre +"', '"+ NitReal +"', "+ credito +");");
        }else{
//           Dialogo.setContenido("INFORMACION", "EL PROVEEDOR YA EXISTE", credito);
//           Dialogo.setVisible(true);
        }
        conexion.close();
    }
    public void crearPedido(String Factura, float Total, boolean credito) throws SQLException, NoSePuedeConectar{
        conectar();
        Statement instruccion = conexion.createStatement();
        instruccion.executeUpdate("INSERT INTO compra (Factura, Total, Credito) VALUES ('" + Factura + "', " + Total + ", " + ((credito) ? 1: 0) +");");
              
        conexion.close();
    }
    private boolean existeProveedor(String Nombre, String Nit) throws SQLException, NoSePuedeConectar{
        int cantNombre, cantNit;
        cantNit = cantNombre = 0;
        conectar();
        Statement instruccion = conexion.createStatement();
        ResultSet resultado = instruccion.executeQuery("SELECT COUNT(*) Cantidad FROM proveedor WHERE Nombre = '" + Nombre+"';");
        while (resultado.next()) {            
            cantNombre = resultado.getInt("Cantidad");
        }
        if (cantNombre != 0) {
            conexion.close();
            return true;
        }
        if (!Nit.equals("No Aplica")) {
            resultado = instruccion.executeQuery("SELECT COUNT(*) Cantidad FROM proveedor WHERE Nombre = '" + Nit+"';");
            while (resultado.next()) {            
                cantNit = resultado.getInt("Cantidad");
            }
            if (cantNit != 0) {
                conexion.close();
                return true;
            }
        }
        conexion.close();
        return false;
    }
    private void iniciarTablaProveedores() {
//        
        Proveedores = new DefaultTableModel(null, new String[]{"Nombre", "Nit", "Credito","Saldo"}){
            boolean[] canEdit = new boolean [] {
        false, false, false, false
            };
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
            }
        };
    }
     private void iniciarTablaProductos() {
//        
        Productos = new DefaultTableModel(null, new String[]{"Codigo", "Barras", "Descripccion", "Existencias"}){
            boolean[] canEdit = new boolean [] {
        false, false, false, false
            };
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
            }
        };
    }
     
    private void iniciarTablaPedidos() {
//        
        Productos = new DefaultTableModel(null, new String[]{"Numero", "Proveedor", "Fecha", "Total", "Saldo"}){
            boolean[] canEdit = new boolean [] {
        false, false, false, false
            };
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
            }
        };
    }
    private void iniciarTablaClientes() {
//        
        Clientes = new DefaultTableModel(null, new String[]{"Codigo", "Nit",  "Nombre",  "Descuento", "Credito", "Saldo"}){
            boolean[] canEdit = new boolean [] {
        false, false, false, false, false, false
            };
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
            }
        };
    }
    private void iniciarTablaExistencias() {
//        
        Existencias = new DefaultTableModel(null, new String[]{"Sucursal", "Cantidad"}){
            boolean[] canEdit = new boolean [] {
        false, false
            };
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
            }
        };
    }
    public void desHabilitarProvedor(String Nombre) throws SQLException, NoSePuedeConectar{
        conectar();
        
        Statement instruccion = conexion.createStatement();
        instruccion.executeUpdate("UPDATE proveedor SET Habilitado = 0 WHERE Nombre = '" + Nombre + "';");
        conexion.close();
    }
    private DefaultTableModel Proveedores, Productos, Pedidos, Clientes, Existencias;
    /**
     * Metodo que regresa la lista de proveedores como un arreglo
     * @return
     * @throws SQLException 
     * @throws Excepciones.NoSePuedeConectar en caso de que no se pueda conectar a la BD
     */
    public DefaultTableModel obtenerProceedores() throws SQLException, NoSePuedeConectar{
         Proveedores = null;
        iniciarTablaProveedores();
        
        conectar();
        Statement instruccion = conexion.createStatement();
        ResultSet resultado = instruccion.executeQuery("SELECT Nombre, Nit, Credito, Saldo, Habilitado FROM proveedor;");
        while(resultado.next()){
            boolean habilitado = (resultado.getString("Habilitado").equals("1"));
            if(habilitado) Proveedores.addRow(new String[] {resultado.getString("Nombre"), resultado.getString("Nit"), (resultado.getString("Credito").equals("1"))? "SI": "NO", resultado.getString("Saldo")});
        }
        conexion.close();
        return Proveedores;
    }
    public DefaultTableModel obtenerProductos() throws SQLException, NoSePuedeConectar{
         Productos = null;
         iniciarTablaProductos();
        
        conectar();
        Statement instruccion = conexion.createStatement();
        ResultSet resultado = instruccion.executeQuery("SELECT id, Codigo, Codigo_Barras, Descripcion FROM producto where habilitado=1;");
        while(resultado.next()){
            Productos.addRow(new String[] {resultado.getString("Codigo"), resultado.getString("Codigo_Barras"), resultado.getString("Descripcion"), existencias(resultado.getInt("id"))+""});
        }
        conexion.close();
        return Productos;
    }
    public DefaultTableModel obtenerProductosfac(String Sucursal) throws SQLException, NoSePuedeConectar{
         Productos = null;
         iniciarTablaProductos();
        
        conectar();
        Statement instruccion = conexion.createStatement();
        ResultSet resultado = instruccion.executeQuery("SELECT id, Codigo, Codigo_Barras, Descripcion FROM producto where habilitado=1;");
        while(resultado.next()){
            Productos.addRow(new String[] {resultado.getString("Codigo"), resultado.getString("Codigo_Barras"), resultado.getString("Descripcion"), existencia(sucursalId(Sucursal),resultado.getInt("id"))+""});
        }
        conexion.close();
        return Productos;
    }
     public DefaultTableModel obtenerExistencias(String Codigo) throws SQLException, NoSePuedeConectar{
         Existencias = null;
         iniciarTablaExistencias();
        
        conectar();
        Statement instruccion = conexion.createStatement();
        ResultSet resultado = instruccion.executeQuery("SELECT s.Nombre , e.Existencia from existencia e INNER JOIN producto p ON e.Producto_id = p.id INNER JOIN sucursales s on e.Sucursales_id = s.id WHERE p.Codigo = '"+ Codigo +"';");
        while(resultado.next()){
            Existencias.addRow(new String[] {resultado.getString("Nombre"), resultado.getString("Existencia")});
        }
        conexion.close();
        return Existencias;
    }
    private int sucursalId(String sucursal) throws SQLException, NoSePuedeConectar{
        int id= 0;
        conectar();
        
        Statement instrucion = conexion.createStatement();
        ResultSet resultado = instrucion.executeQuery("SELECT id FROM sucursales WHERE Nombre = '" + sucursal + "';");
        while(resultado.next()){
            id = resultado.getInt("id");
        }
        
        conexion.close();
        return id;
    }
    private float existencia(int Sucursal ,int Producto) throws SQLException, NoSePuedeConectar{
        float exi= 0;
        conectar();
        
        Statement instrucion = conexion.createStatement();
        ResultSet resultado = instrucion.executeQuery("SELECT Existencia from existencia WHERE Producto_id = " + Producto + " AND Sucursales_id = " + Sucursal + ";");
        while(resultado.next()){
            exi = resultado.getFloat("Existencia");
        }
        
        conexion.close();
        return exi;
    }
    public DefaultTableModel obtenerPedidos() throws SQLException, NoSePuedeConectar{
        Pedidos = null;
        iniciarTablaProveedores();
        
        conectar();
        Statement instruccion = conexion.createStatement();
        ResultSet resultado = instruccion.executeQuery("SELECT Nombre, Nit, Credito, Saldo, Habilitado FROM proveedor;");
        while(resultado.next()){
            boolean habilitado = (resultado.getString("Habilitado").equals("1"));
            if(habilitado) Pedidos.addRow(new String[] {resultado.getString("Nombre"), resultado.getString("Nit"), (resultado.getString("Credito").equals("1"))? "SI": "NO", resultado.getString("Saldo")});
        }
        conexion.close();
        return Pedidos;
    }
    public DefaultTableModel obtenerClientes() throws SQLException, NoSePuedeConectar{
        Clientes = null;
        iniciarTablaClientes();
        
        conectar();
        Statement instruccion = conexion.createStatement();
        ResultSet resultado = instruccion.executeQuery("SELECT id, NIT, Nombre, Apellido, Descuento, LimiteCredito, Saldo FROM cliente;");
        while(resultado.next()){
            //boolean habilitado = (resultado.getString("Habilitado").equals("1"));
            /*if(habilitado)*/ Clientes.addRow(new String[] {resultado.getInt("id")+ "", resultado.getString("NIT"), (resultado.getString("Apellido") == null)? resultado.getString("Nombre"): resultado.getString("Nombre") + " " + resultado.getString("Apellido"), resultado.getString("Descuento"), resultado.getString("LimiteCredito"), resultado.getString("Saldo")});
        }
        conexion.close();
        return Clientes;
    }
    public int numeroPedido() throws SQLException, NoSePuedeConectar{
        int numero = 0;
        conectar();
        Statement instruccion = conexion.createStatement();
        ResultSet resultado = instruccion.executeQuery("SELECT AUTO_INCREMENT Nuevo FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'sce' AND TABLE_NAME = 'compra';");
        while (resultado.next()) {
            numero = resultado.getInt("Nuevo");
        }
        conexion.close();
        return numero;
    }
    public void insertarDetallePedido(int idCodigo, int idProve, int Pedido, float Precio, float Cantidad) throws SQLException, NoSePuedeConectar{
        conectar();
        Statement instruccion = conexion.createStatement();
        
        instruccion.executeUpdate("INSERT INTO detalle_compra (Producto_id, Compra_id, proveedor_id, Precio, Cantidad) VALUES (" + idCodigo + ", " + (Pedido - 1) + ", " + idProve + ", " + Precio + ", " + Cantidad + ");");
        
        conexion.close();
    }
    public int idCodigo(String codigo) throws SQLException, NoSePuedeConectar{
        int numero = 0;
        conectar();
        Statement instruccion = conexion.createStatement();
        ResultSet resultado = instruccion.executeQuery("SELECT id FROM Producto WHERE Codigo = '" + codigo +"';");
        while (resultado.next()) {
            numero = resultado.getInt("id");
        }
        conexion.close();
        return numero;
    }
    public int idProve(String Nombre) throws SQLException, NoSePuedeConectar{
        int numero = 0;
        conectar();
        Statement instruccion = conexion.createStatement();
        ResultSet resultado = instruccion.executeQuery("SELECT id FROM proveedor WHERE Nombre = '" + Nombre +"';");
        while (resultado.next()) {
            numero = resultado.getInt("id");
        }
        conexion.close();
        return numero;
    }
    private float existencias(int id) throws SQLException, NoSePuedeConectar{
       float existencias = 0;
       
            conectar();
            Statement instruccion = conexion.createStatement();
            ResultSet resultado = instruccion.executeQuery("SELECT Existencia FROM Existencia WHERE Producto_id = " + id + ";");
            while (resultado.next()){
                existencias += resultado.getFloat("Existencia");
            }
            conexion.close();
       
       return existencias;
    }
    public float existencias(String Codigo) throws SQLException, NoSePuedeConectar{
       float existencias = 0;
       
            conectar();
            Statement instruccion = conexion.createStatement();
            ResultSet resultado = instruccion.executeQuery("SELECT e.Existencia from existencia e INNER JOIN producto p ON e.Producto_id = p.id WHERE p.Codigo = '" + Codigo + "';");
            while (resultado.next()){
                existencias += resultado.getFloat("Existencia");
            }
            conexion.close();
       
       return existencias;
    }
    public int cantidadProveedores() throws SQLException, NoSePuedeConectar{
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
    /**
     * EJEMPLO DE COMO USAR ESTA CLASE
     * @throws SQLException en caso de error
     * @throws Excepciones.NoSePuedeConectar en caso de que no se pueda conectar a la BD
     */
    public void ejemploDeUso() throws SQLException, NoSePuedeConectar{
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
    /**
     * Invoca a un procedimiento almacenado en la BD para hacer login al programa
     * @param usuario nombre del usuario
     * @param pass contraeña
     * @return retorna 1 si los datos son correctos, 0 de lo contrario
     * @throws SQLException en caso de error
     * @throws Excepciones.NoSePuedeConectar en caso de que no se pueda conectar a la BD
     */
    public int login(String usuario, String pass) throws SQLException, NoSePuedeConectar{
        conectar(); //permite la conexion con la base de datos
        Statement instruccion=conexion.createStatement(); //Crea una nueva instruccion para la base de datos
        ResultSet resultado = instruccion.executeQuery("SELECT login('"+usuario+"','"+claveCifradoBase+"','"+pass+"') R"); //se guarda el resultado de la instruccion
        int res=-1;
        while(resultado.next())//Es una funcion booleana que mueve el cursor del resultado, si este es TRUE, aun hay registros de resultado
        {
            res= resultado.getInt(1);
        }
        conexion.close();
        return res;
    }
    /**
     * Invoca un procedimiento almacenado en la BD para crear un nuevo usuario
     * @param usuario usuario nuevo
     * @param pass contraseña del usuario
     * @return 1 si se ha creado el usuario, 0 de lo contrario
     * @throws SQLException en caso de error
     * @throws Excepciones.NoSePuedeConectar en caso de que no se pueda conectar a la BD
     */
    public int crearUsuario(String usuario, String pass) throws SQLException, NoSePuedeConectar{
        conectar(); //permite la conexion con la base de datos
        Statement instruccion=conexion.createStatement(); //Crea una nueva instruccion para la base de datos
        ResultSet resultado = instruccion.executeQuery("SELECT creacionUsuarioVacio('"+usuario+"','"+pass+"','"+claveCifradoBase+"') R"); //se guarda el resultado de la instruccion
        int res=-1;
        while(resultado.next())//Es una funcion booleana que mueve el cursor del resultado, si este es TRUE, aun hay registros de resultado
        {
            res= resultado.getInt(1);
        }
        conexion.close();
        return res;
    }
    /**
     * Elimina un usuario
     * @param usuario usuario a eliminar
     * @throws SQLException en caso de error
     * @throws Excepciones.NoSePuedeConectar en caso de que no se pueda conectar a la BD
     */
    public void eliminarUsuario(String usuario) throws SQLException, NoSePuedeConectar{
        conectar(); //permite la conexion con la base de datos
        Statement instruccion=conexion.createStatement(); //Crea una nueva instruccion para la base de datos
        int resultado = instruccion.executeUpdate("DELETE FROM usuario WHERE Usuario='"+usuario+"'"); //se guarda el resultado de la instruccion
        conexion.close();
    }
    /**
     * Obtiene la lista de usuarios
     * @return un arreglo con la lista de usuarios
     * @throws SQLException en caso de error
     * @throws Excepciones.NoSePuedeConectar en caso de que no se pueda conectar a la BD
     */
    public ArrayList obtenerUsuarios() throws SQLException, NoSePuedeConectar{
        ArrayList users=new ArrayList();
        conectar(); //permite la conexion con la base de datos
        Statement instruccion=conexion.createStatement(); //Crea una nueva instruccion para la base de datos
        ResultSet resultado = instruccion.executeQuery("SELECT Usuario FROM usuario"); //se guarda el resultado de la instruccion
        while(resultado.next())//Es una funcion booleana que mueve el cursor del resultado, si este es TRUE, aun hay registros de resultado
        {
            users.add(resultado.getString(1));
        }
        conexion.close();
        return users;
    }
    /**
     * Metodo que inserta un nuevo producto en la base
     * @param codigo codigo interno
     * @param codBarras codigo de barras del producto
     * @param descrip //descripcion del profucto
     * @param venta //precio de venta
     * @param costo //Precio de compra
     * @param estanteria //estanteria donde se encuentra
     * @param columna //columna de estanteria
     * @param fila //fila de estanteria
     * @param marca //marca del producto
     * @param unidad //id de la unidad de medicion
     * @param sucursal //sucursal a la que se quiere agregar
     * @param existencia
     * @throws SQLException 
     * @throws Excepciones.NoSePuedeConectar en caso de que no se pueda conectar a la BD
     */
    public void insertarProducto (String codigo, String codBarras,String descrip, double venta,
            double costo, String estanteria, String columna, String fila, String marca, String unidad, 
            int sucursal, double existencia) throws SQLException, NoSePuedeConectar{
        conectar(); //permite la conexion con la base de datos
        int marcaId=0;
        int fraccion=0;
        if(estanteria.isEmpty())
            estanteria=null;
        if(columna.isEmpty())
            columna=null;
        if(fila.isEmpty())
            fila=null;
        if(unidad!=null)
            fraccion=1;
        Statement instruccion=conexion.createStatement(); //Crea una nueva instruccion para la base de datos
        ResultSet resultado = instruccion.executeQuery("select id from marca where Nombre= '"+marca.toUpperCase()+"';"); //se guarda el resultado de la instruccion, en esta ocasion, es una consulta
        if(resultado.next())
            marcaId=resultado.getInt(1);
        else
        {
            instruccion=conexion.createStatement();
            instruccion.executeUpdate("insert into marca (Nombre) values ('"+marca.toUpperCase()+"');");
             resultado = instruccion.executeQuery("select id from marca where Nombre= '"+marca.toUpperCase()+"';");
            if(resultado.next())
            {   
                marcaId=resultado.getInt(1);      
            }
        }
        instruccion=conexion.createStatement();
        instruccion.executeUpdate("insert into producto (codigo,codigo_barras,descripcion,precio_venta,precio_costo,Estanteria,"
                +"Columna,Fila,marca_id,unidad_id,fraccion) values ('"+codigo+"','"+codBarras+"','"+descrip+"',"+venta+","+costo+","+estanteria+","+
                columna+","+fila+","+marcaId+","+unidad+","+fraccion+");");
        instruccion=conexion.createStatement();
        resultado = instruccion.executeQuery("select max(id) from producto;");
        instruccion=conexion.createStatement();
        if(resultado.next())
            instruccion.executeUpdate("insert into existencia (sucursales_id,producto_id,existencia) values ("
                +sucursal+","+resultado.getInt(1)+","+existencia+");");
        conexion.close();
    }
    public void modificarProducto(int id,String codigo, String codBarras,String descrip, double venta, 
            double costo, String estanteria, String columna, String fila, String marca) throws SQLException, NoSePuedeConectar{
        conectar(); //permite la conexion con la base de datos
        String marcaId;
        //int fraccion=0;
        if(estanteria.isEmpty())
            estanteria=null;
        if(columna.isEmpty())
            columna=null;
        if(fila.isEmpty())
            fila=null;
        /*if(unidad!=null)
            fraccion=1;*/
        Statement instruccion=conexion.createStatement(); //Crea una nueva instruccion para la base de datos
        ResultSet resultado;
        if(marca.isEmpty())
            marcaId=null;
        else{
            resultado = instruccion.executeQuery("select id from marca where Nombre= '"+marca.toUpperCase()+"';"); //se guarda el resultado de la instruccion, en esta ocasion, es una consulta
            if(resultado.next())
                marcaId=resultado.getString(1);
            else
            {
                instruccion=conexion.createStatement();
                instruccion.executeUpdate("insert into marca (Nombre) values ('"+marca.toUpperCase()+"');");
                resultado = instruccion.executeQuery("select id from marca where Nombre= '"+marca.toUpperCase()+"';");
                marcaId=resultado.getString(1);       
            }
        }
        instruccion.executeUpdate("update producto set codigo='"+codigo+"',codigo_barras='"+codBarras+"',descripcion='"+descrip+
                "',precio_venta="+venta+",precio_costo="+costo+",Estanteria="+estanteria+",Columna="+columna+
                ",Fila="+fila+",marca_id="+marcaId+" where id="+id+";");
        conexion.close();
    }
    /**
     * Funcion que retorna guarda las sucursales y su id en una matriz, tambien guarda las unidades 
     * registradas en la base de datos y su id
     * @return matriz dinamica de tamaño 2xN que alamcena la sucursal y su id, y esta matriz tambien incluye otra de 2xN
     * @throws SQLException 
     * @throws Excepciones.NoSePuedeConectar en caso de que no se pueda conectar a la BD
     */
    public ArrayList[] obtener_Sucursales_Unidades() throws SQLException, NoSePuedeConectar{
        ArrayList[] matriz=new ArrayList[4];
        matriz[0]=new ArrayList();
        matriz[1]=new ArrayList();
        matriz[2]=new ArrayList();
        matriz[3]=new ArrayList();
        conectar(); //permite la conexion con la base de datos
        Statement instruccion=conexion.createStatement(); //Crea una nueva instruccion para la base de datos
        ResultSet resultado = instruccion.executeQuery("select id,Nombre from sucursales"); //se guarda el resultado de la instruccion, en esta ocasion, es una consulta
        while(resultado.next())//Es una funcion booleana que mueve el cursor del resultado, si este es TRUE, aun hay registros de resultado
        {
            matriz[0].add(resultado.getInt(1));
            matriz[1].add(resultado.getString(2));
        }
        resultado = instruccion.executeQuery("select id,Nombre from unidad"); //se guarda el resultado de la instruccion, en esta ocasion, es una consulta
        while(resultado.next())//Es una funcion booleana que mueve el cursor del resultado, si este es TRUE, aun hay registros de resultado
        {
            matriz[2].add(resultado.getInt(1));
            matriz[3].add(resultado.getString(2));
        }
        conexion.close();
        return matriz;
    }
    /**
     * 
     * @param id Recibe una id del producto a buscar
     * @param sucursal Id de la sucursal en donde se busca
     * @return un arreglo con todos los atributos del producti
     * @throws SQLException 
     * @throws Excepciones.NoSePuedeConectar en caso de que no se pueda conectar a la BD
     */
    public ArrayList obtener_detalleProducto(int id,int sucursal) throws SQLException, NoSePuedeConectar
    {
        ArrayList atributo=new ArrayList();
        conectar(); //permite la conexion con la base de datos
        Statement instruccion=conexion.createStatement(); //Crea una nueva instruccion para la base de datos
        ResultSet resultado = instruccion.executeQuery("select p.id, p.codigo, codigo_barras,descripcion, precio_venta, "+
                "precio_costo,estanteria, columna, fila,u.id ,m.Nombre from producto p left join "+
                "unidad u on u.id=p.Unidad_id left join marca m ON m.id=p.Marca_id where p.id="+id+";"); //se guarda el resultado de la instruccion, en esta ocasion, es una consulta
        if(resultado.next())//Es una funcion booleana que mueve el cursor del resultado, si este es TRUE, aun hay registros de resultado
        {
            for(int i=1;i<12;i++)
            {
                atributo.add(resultado.getString(i));
            }
        }   
        conexion.close();
        return atributo;
    }
      /**
     * Funcion que obtiene todos los productos contenidos en la base de datos, su descripcion, codiogs y su id en una matriz
     * @return Matriz con atributos de todos los productos
     * @throws SQLException 
     * @throws Excepciones.NoSePuedeConectar en caso de que no se pueda conectar a la BD
     */
   public ArrayList[] obtener_productos() throws SQLException, NoSePuedeConectar{
        ArrayList[] matriz=new ArrayList[4];
        matriz[0]=new ArrayList();
        matriz[1]=new ArrayList();
        matriz[2]=new ArrayList();
        matriz[3]=new ArrayList();
        conectar(); //permite la conexion con la base de datos
        Statement instruccion=conexion.createStatement(); //Crea una nueva instruccion para la base de datos
        ResultSet resultado = instruccion.executeQuery("select id,codigo,codigo_barras,descripcion from producto where habilitado=1;"); //se guarda el resultado de la instruccion, en esta ocasion, es una consulta
        while(resultado.next())//Es una funcion booleana que mueve el cursor del resultado, si este es TRUE, aun hay registros de resultado
        {
            matriz[0].add(resultado.getInt(1));
            matriz[1].add(resultado.getString(2));
            matriz[2].add(resultado.getString(3));
            matriz[3].add(resultado.getString(4));
        }
        conexion.close();
        return matriz;
    }
   public void deshabilitarProducto(int id) throws SQLException, NoSePuedeConectar
   {
       if(id>0)
       {
           conectar();
           Statement instruccion=conexion.createStatement();
           instruccion.executeUpdate("update producto set habilitado=0 where id="+id+";");
           conexion.close();
       }
   }
   /**
     * Metodo que regresa la lista de clientes como un arreglo
     * @return una DefaultTableModel con los clientes en la BD
     * @throws SQLException en caso de error
     * @throws Excepciones.NoSePuedeConectar en caso de que no se pueda conectar a la BD
     */
    public DefaultTableModel obtenerClientes() throws SQLException, NoSePuedeConectar{
        DefaultTableModel modelo = null;
        modelo=inicializarTablaClientes(modelo);
        conectar();
        Statement instruccion = conexion.createStatement();
        ResultSet resultado = instruccion.executeQuery("SELECT id, NIT, Nombre, Apellido, Descuento, Direccion, LimiteCredito, Saldo, Cheque, Habilitado FROM cliente;");
        while(resultado.next()){
            if(resultado.getString("Habilitado").equals("1"))
                modelo.addRow(new String[] {resultado.getString("id"),resultado.getString("NIT"), resultado.getString("Nombre"), resultado.getString("Apellido"), resultado.getString("Descuento"),resultado.getString("Direccion"),resultado.getString("LimiteCredito"),resultado.getString("Saldo"), (resultado.getString("Cheque").equals("1")? "SI": "NO")});
        }
        conexion.close();
        return modelo;
    }
    /**
     * Crea una nuevo DefaultTableModel para clientes
     * @param modelo el modelo para la JTable, vacio o con otros datos
     * @return el modelo para la JTable, inicializado
     */
    private DefaultTableModel inicializarTablaClientes(DefaultTableModel modelo) {
//        
        modelo = new DefaultTableModel(null, new String[]{"ID", "NIT", "Nombre", "Apellido", "% descuento","Dirección","Limite de Crédito","Saldo Actual","¿Puede darnos cheque?"}){
            boolean[] canEdit = new boolean [] {
        false, false, false, false,false,false,false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        return modelo;
    } 
    /**
     * Invoca a una funcion almacenada en la BD para crear un nuevo cliente
     * @param nombre nombre del cliente
     * @param apellido apellido del cliente
     * @param descuento % de descuento del cliente
     * @param direccion dirección del cliente
     * @param limCredito limite de credito del cliente
     * @param saldo saldo inicial del cliente
     * @param NIT NIT del cliente
     * @param cheque si se le acepta cheque al cliente o no
     * @return 1 en caso de que se inserte, 0 de lo contrario
     * @throws SQLException en caso de error
     * @throws Excepciones.NoSePuedeConectar en caso de que no se pueda conectar a la BD
     */
    public int crearCliente(String nombre, String apellido, long descuento, String direccion, long limCredito, float saldo, String NIT, boolean cheque) throws SQLException, NoSePuedeConectar{
        conectar(); //permite la conexion con la base de datos
        Statement instruccion=conexion.createStatement(); //Crea una nueva instruccion para la base de datos
        ResultSet resultado = instruccion.executeQuery("SELECT creaClientes('"+(nombre.equals("")? "N/A":nombre)+"','"+(apellido.equals("")? "N/A":apellido)+"',"+descuento+",'"+(direccion.equals("")? "N/A":direccion)+"',"+limCredito+","+saldo+",'"+(NIT.equals("")? "N/A":NIT)+"',"+(cheque? 1:0)+") R"); //se guarda el resultado de la instruccion
        int res=-1;
        while(resultado.next())//Es una funcion booleana que mueve el cursor del resultado, si este es TRUE, aun hay registros de resultado
        {
            res= resultado.getInt(1);
        }
        conexion.close();
        return res;
    }
    /**
     * Actualiza los datos de un cliente
     * @param id ID del cliente a actualizar
     * @param nombre nuevo nombre
     * @param apellido nuevo apellido
     * @param descuento nuevo descuento
     * @param direccion nueva dirección
     * @param limCredito nuevo limite de credito
     * @param saldo nuevo saldo
     * @param NIT nuevo NIT del cliente
     * @param cheque si se le acepta cheque al cliente, o no
     * @return numero de filas en la BD que han sido modificadas (Debe ser 1)
     * @throws SQLException en caso de error
     * @throws Excepciones.NoSePuedeConectar en caso de que no se pueda conectar a la BD
     */
    public int modificarCliente(int id, String nombre, String apellido, long descuento, String direccion, long limCredito, float saldo, String NIT, boolean cheque) throws SQLException, NoSePuedeConectar{
        conectar(); //permite la conexion con la base de datos
        Statement instruccion=conexion.createStatement(); //Crea una nueva instruccion para la base de datos
        int resultado = instruccion.executeUpdate("UPDATE Cliente SET nombre='"+(nombre.equals("")? "N/A":nombre)+"', apellido='"+(apellido.equals("")? "N/A":apellido)+"',descuento="+descuento+",direccion='"+(direccion.equals("")? "N/A":direccion)+"',limitecredito="+limCredito+",saldo="+saldo+",nit='"+(NIT.equals("")? "N/A":NIT)+"',cheque="+(cheque? 1:0)+" WHERE id="+id+";"); //se guarda el resultado de la instruccion
        conexion.close();
        return resultado;
    }
    /**
     * Elimina un cliente de la BD
     * @param id id del cliente a borrar
     * @return el numero de filas afectadas (debe ser 1)
     * @throws SQLException en caso de error
     * @throws Excepciones.NoSePuedeConectar en caso de que no se pueda conectar a la BD
     */
    public int eliminarCliente(int id) throws SQLException, NoSePuedeConectar{
        conectar(); //permite la conexion con la base de datos
        Statement instruccion=conexion.createStatement(); //Crea una nueva instruccion para la base de datos
        //int resultado = instruccion.executeUpdate("DELETE FROM Cliente WHERE id="+id+";"); //se guarda el resultado de la instruccion
        int resultado = instruccion.executeUpdate("UPDATE Cliente SET habilitado=0 WHERE id="+id+";"); //se guarda el resultado de la instruccion
        conexion.close();
        return resultado;
    }
    /**
     * Metodo que genera la conexion para saber si puede conectarse a la BD
     * @return true si se puede conectar a la base con los datos ingresados, false de lo contrario
     */
    public boolean probarConexion ()
    {
       conexion=null;
        try{
            try {
                Class.forName(driver);//Se utiliza el driver de conexion
            }catch (ClassNotFoundException ex) {
                return false;
            }
            conexion=DriverManager.getConnection(url+ip+"/"+nombreBD,user,pass);//Se conecta con la base de datos enviando
            //los parametros url, user, pass,
            conexion.close();
            return true;
        }catch (SQLException ex) {
            return false;
        }
        
    }
   public ArrayList[] obtenerSucursales() throws SQLException, NoSePuedeConectar{
      
       ArrayList[] Sucursales = new ArrayList[3];
       Sucursales[0] = new ArrayList();
       Sucursales[1] = new ArrayList();
       Sucursales[2] = new ArrayList();
       
       conectar(); //permite la conexion con la base de datos
        Statement instruccion=conexion.createStatement(); //Crea una nueva instruccion para la base de datos
        ResultSet resultado = instruccion.executeQuery("SELECT Nombre, NumeroFac, SerieFact FROM sucursales");
       while (resultado.next()) {     
           Sucursales[0].add(resultado.getString("Nombre"));
           Sucursales[1].add(resultado.getString("NumeroFac"));
           Sucursales[2].add((resultado.getString("SerieFact") == null) ? "": resultado.getString("SerieFact"));
       }
       
       conexion.close();
       return Sucursales;
   }
   public String fecha()throws SQLException, NoSePuedeConectar{
       String Fecha = "";
       conectar(); //permite la conexion con la base de datos
        Statement instruccion=conexion.createStatement(); //Crea una nueva instruccion para la base de datos
        ResultSet resultado = instruccion.executeQuery("SELECT obtenerFecha() Fecha;");
       while (resultado.next()) {     
           Fecha = resultado.getString("Fecha");
       }
       
       conexion.close();
       return Fecha;
   }
   public String[] obtenerCliente(int id) throws SQLException, NoSePuedeConectar{
        String[]  Cliente= null;
               
        conectar();
        Statement instruccion = conexion.createStatement();
        ResultSet resultado = instruccion.executeQuery("SELECT NIT, Nombre, Apellido, Descuento, Direccion, LimiteCredito FROM cliente WHERE id = " + id + ";");
        while(resultado.next()){
             Cliente = (new String[] {id + "", resultado.getString("NIT"), resultado.getString("Nombre"), (resultado.getString("Apellido") == null) ? "" : resultado.getString("Apellido"), resultado.getString("Descuento"), resultado.getString("Direccion"), resultado.getFloat("LimiteCredito") + ""});
        }
        conexion.close();
        return Cliente;
   }
   public String[] obtenerCliente(String nit) throws SQLException, NoSePuedeConectar{
        String[] Cliente = null;

        conectar();
        Statement instruccion = conexion.createStatement();
        ResultSet resultado = instruccion.executeQuery("SELECT id, Nombre, Apellido, Descuento, Direccion, LimiteCredito FROM cliente WHERE NIT = '" + nit + "';");
        while(resultado.next()){
            Cliente = (new String[] {resultado.getInt("id")+ "", nit, resultado.getString("Nombre"), (resultado.getString("Apellido") == null) ? "" : resultado.getString("Apellido"), resultado.getString("Descuento"), resultado.getString("Direccion"), resultado.getFloat("LimiteCredito") + ""});
        }
        conexion.close();
        return Cliente;
   }
   public boolean existeCliente(String nit) throws SQLException, NoSePuedeConectar{      
       conectar();
       Statement instruccion = conexion.createStatement();
       ResultSet resultado = instruccion.executeQuery("SELECT COUNT(*) cant FROM cliente WHERE NIT = '" + nit + "';");
       
       while (resultado.next()) {           
           if (resultado.getInt("cant") > 0) {
               conexion.close();
               return true;
           }
       }
       
       conexion.close();
       return false;   
   }
}
