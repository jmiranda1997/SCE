/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RobertoPruebas;
import RobertoPruebas.*;
import Ventanas.DialogodeMensaje;
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
    private void conectar()
    {
       conexion=null;
        try{
            try {
            Class.forName(driver);//Se utiliza el driver de conexion
            } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de MySQL: " + ex);
        }
            conexion=DriverManager.getConnection(url+ip+"/"+nombreBD,user,pass);//Se conecta con la base de datos enviando
            //los parametros url, user, pass,
            
        } catch (SQLException ex) {
//            Dialogo.setContenido("ERROR", ex.getMessage(), DialogodeMensaje.ICONO_ERROR);
//            Dialogo.setVisible(true);
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
        if (!existeProveedor(Nombre, Nit)) {
            instruccion.executeUpdate("INSERT INTO proveedor (Nombre, Nit, Credito) VALUES ('"+ Nombre +"', '"+ NitReal +"', "+ credito +");");
        }else{
//           Dialogo.setContenido("INFORMACION", "EL PROVEEDOR YA EXISTE", credito);
//           Dialogo.setVisible(true);
        }
        conexion.close();
    }
    public void crearPedido(String Factura, float Total, boolean credito) throws SQLException{
        conectar();
        Statement instruccion = conexion.createStatement();
        instruccion.executeUpdate("INSERT INTO compra (Factura, Total, Credito) VALUES ('" + Factura + "', " + Total + ", " + ((credito) ? 1: 0) +");");
              
        conexion.close();
    }
    private boolean existeProveedor(String Nombre, String Nit) throws SQLException{
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
    public void desHabilitarProvedor(String Nombre) throws SQLException{
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
     */
    public DefaultTableModel obtenerProceedores() throws SQLException{
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
    public DefaultTableModel obtenerProductos() throws SQLException{
         Productos = null;
         iniciarTablaProductos();
        iniciarTablaProveedores();
        
        conectar();
        Statement instruccion = conexion.createStatement();
        ResultSet resultado = instruccion.executeQuery("SELECT id, Codigo, Codigo_Barras, Descripcion FROM producto where habilitado=1;");
        while(resultado.next()){
            Productos.addRow(new String[] {resultado.getString("Codigo"), resultado.getString("Codigo_Barras"), resultado.getString("Descripcion"), existencias(resultado.getInt("id"))+""});
        }
        conexion.close();
        return Productos;
    }
    public DefaultTableModel obtenerProductosfac(String Sucursal) throws SQLException{
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
     public DefaultTableModel obtenerExistencias(String Codigo) throws SQLException{
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
    private int sucursalId(String sucursal) throws SQLException{
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
    private float existencia(int Sucursal ,int Producto) throws SQLException{
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
    public DefaultTableModel obtenerPedidos() throws SQLException{
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
    public DefaultTableModel obtenerClientes() throws SQLException{
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
    public int numeroPedido() throws SQLException{
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
    public void insertarDetallePedido(int idCodigo, int idProve, int Pedido, float Precio, float Cantidad) throws SQLException{
        conectar();
        Statement instruccion = conexion.createStatement();
        
        instruccion.executeUpdate("INSERT INTO detalle_compra (Producto_id, Compra_id, proveedor_id, Precio, Cantidad) VALUES (" + idCodigo + ", " + (Pedido - 1) + ", " + idProve + ", " + Precio + ", " + Cantidad + ");");
        
        conexion.close();
    }
    public int idCodigo(String codigo) throws SQLException{
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
    public int idProve(String Nombre) throws SQLException{
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
    private float existencias(int id) throws SQLException{
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
    public float existencias(String Codigo) throws SQLException{
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
    /**
     * EJEMPLO DE COMO USAR ESTA CLASE
     * @throws SQLException en caso de error
     */
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
    /**
     * Invoca a un procedimiento almacenado en la BD para hacer login al programa
     * @param usuario nombre del usuario
     * @param pass contraeña
     * @return retorna 1 si los datos son correctos, 0 de lo contrario
     * @throws SQLException en caso de error
     */
    public int login(String usuario, String pass) throws SQLException{
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
     */
    public int crearUsuario(String usuario, String pass) throws SQLException{
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
     */
    public void eliminarUsuario(String usuario) throws SQLException{
        conectar(); //permite la conexion con la base de datos
        Statement instruccion=conexion.createStatement(); //Crea una nueva instruccion para la base de datos
        int resultado = instruccion.executeUpdate("DELETE FROM usuario WHERE Usuario='"+usuario+"'"); //se guarda el resultado de la instruccion
        conexion.close();
    }
    /**
     * Obtiene la lista de usuarios
     * @return un arreglo con la lista de usuarios
     * @throws SQLException en caso de error
     */
    public ArrayList obtenerUsuarios() throws SQLException{
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
     */
    public void insertarProducto (String codigo, String codBarras,String descrip, double venta,
            double costo, String estanteria, String columna, String fila, String marca, String unidad, 
            int sucursal, double existencia) throws SQLException{
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
            double costo, String estanteria, String columna, String fila, String marca) throws SQLException{
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
     */
    public ArrayList[] obtener_Sucursales_Unidades() throws SQLException{
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
     */
    public ArrayList obtener_detalleProducto(int id,int sucursal) throws SQLException
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
     */
   public ArrayList[] obtener_productos() throws SQLException{
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
      public ArrayList obtener_detalleProducto(String des, String codigo, String codigo_barras) throws SQLException{
        ArrayList atributo=new ArrayList();
        conectar(); //permite la conexion con la base de datos
        Statement instruccion=conexion.createStatement(); //Crea una nueva instruccion para la base de datos
        ResultSet resultado = instruccion.executeQuery("select p.id, p.codigo, codigo_barras,descripcion, precio_venta, "+
                "precio_costo,estanteria, columna, fila,u.id ,m.Nombre from producto p left join "+
                "unidad u on u.id=p.Unidad_id left join marca m ON m.id=p.Marca_id where p.codigo='"+codigo+
                "' and p.codigo_barras='"+codigo_barras+"' and p.descripcion='"+des+"';"); //se guarda el resultado de la instruccion, en esta ocasion, es una consulta
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
    * metodo que deshabilita productos en la base de datos
    * @param id del producto a deshabilitar
    * @throws SQLException 
    */
   public void deshabilitarProducto(int id) throws SQLException
   {
       if(id>0)
       {
           conectar();
           Statement instruccion=conexion.createStatement();
           instruccion.executeUpdate("update producto set habilitado=0 where id="+id+";");//se actualiza el campo habilitado como 0
           conexion.close();
       }
   }/**
    * Funcion que ingresa una nueva cotizacion para un cliente ya registrado
    * retorna un arreglo con la información principal del cliente
    * @param idCliente id del cliente
    * @param id_usuario id del usuario que ingreso la cotizacion
    * @return ArrayList que contiene 0.-id de cotizacion, 1.-numero de cotizacion, 2.- id del cliente.- 3 total
    * @throws SQLException 
    */
   public ArrayList insertarCotizacion(int idCliente,int id_usuario) throws SQLException{
       ArrayList lista=new ArrayList();
        conectar();
        Statement instruccion=conexion.createStatement();
        instruccion.executeUpdate("insert into ventas (Cliente_id,Usuario_id) values ("+idCliente+","+id_usuario+");");//se inseta el cloente
        int id=0;
        ResultSet resultado=instruccion.executeQuery("select id from ventas where Nombre="+idCliente+" and Usuario_id="+id_usuario+" and date(NOW()=date(fecha);");//se obtiene el cliente insertado
        while(resultado.next())
        { 
           id=resultado.getInt(1);
        }
        lista.add(id);
        resultado=instruccion.executeQuery("select numero,cliente_id,total from ventas where id="+id+";");//se guardan los datos de la cotizacion
        if(resultado.next())
        {
            lista.add(resultado.getInt(1));
            lista.add(resultado.getString(2));
            lista.add(resultado.getDouble(3));
        }
        conexion.close();
        return lista;
   }
   /**
    * Funcion que Inserta una nueva cotizacion para un cliente no registrado
    * y retorna los datos de la nueva cotizacion
    * @param nombre Nombre que tendra la cotizacion
    * @param id_usuario usuario que realizo la cotizacion
    * @return ArrayList que contiene 0.-id de cotizacion, 1.-numero de cotizacion, 2.- nombre del cliente.- 3 total
    */
   public ArrayList insertarCotizacion(String nombre,int id_usuario) throws SQLException
   {
        ArrayList lista=new ArrayList();
        conectar();
        Statement instruccion=conexion.createStatement();
        instruccion.executeUpdate("insert into ventas (Nombre,Usuario_id) values ('"+nombre+"',"+id_usuario+");");//se inseta el cloente
        int id=0;
        ResultSet resultado=instruccion.executeQuery("select id from ventas where Nombre='"+nombre+"' and Usuario_id="+id_usuario+" and date(NOW())=date(fecha);");//se obtiene el cliente insertado
        while(resultado.next())
        { 
           id=resultado.getInt(1);
        }
        lista.add(id);
        resultado=instruccion.executeQuery("select numero,nombre,total from ventas where id="+id+";");//se guardan los datos de la cotizacion
        if(resultado.next())
        {
            lista.add(resultado.getInt(1));
            lista.add(resultado.getString(2));
            lista.add(resultado.getDouble(3));
        }
        conexion.close();
        return lista;
   }
    public DefaultTableModel obtenerClientes_venta() throws SQLException{
        Clientes=null;
        iniciarTablaClientes();
        conectar();
        Statement instruccion = conexion.createStatement();
        ResultSet resultado = instruccion.executeQuery("SELECT Nombre, Apellido, Nit from cliente;");
        while(resultado.next()){
            Clientes.addRow(new String[] {resultado.getString(1), resultado.getString(2), resultado.getString(3)});
        }
        conexion.close();
        return Clientes;
    }
    public int obtenerExistencia(int sucursalId, int productoId) throws SQLException{
        int existencia=0;
        conectar();
        Statement instruccion = conexion.createStatement();
         ResultSet resultado;
        if(sucursalId>0)
        {
            resultado = instruccion.executeQuery("select e.Existencia from existencia e where e.Sucursales_id="+sucursalId+" e.Producto_id="+productoId+";");
        }
        else
        {
            resultado = instruccion.executeQuery("select SUM(e.Existencia) from existencia e where  e.Producto_id="+productoId+";");
        }
        if(resultado.next())
        {
            existencia=resultado.getInt(1);
        }
        return existencia;
    }

   public ArrayList[] obtenerSucursales() throws SQLException{
      
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
   public String fecha()throws SQLException{
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
   public String[] obtenerCliente(int id) throws SQLException{
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
   public String[] obtenerCliente(String nit) throws SQLException{
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
   public boolean existeCliente(String nit) throws SQLException{      
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

    public DefaultTableModel obtenerProductos_vista() throws SQLException{
         Productos = null;
         iniciarTablaProductos();
        Productos.setColumnCount(3);
        conectar();
        Statement instruccion = conexion.createStatement();
        ResultSet resultado = instruccion.executeQuery("SELECT Codigo, Codigo_Barras, Descripcion FROM producto where habilitado=1;");
        while(resultado.next()){
            Productos.addRow(new String[] {resultado.getString("Codigo"), resultado.getString("Codigo_Barras"), resultado.getString("Descripcion")});
        }
        conexion.close();
        return Productos;
    }
}
