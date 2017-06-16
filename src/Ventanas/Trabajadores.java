/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Excepciones.NoSePuedeConectar;
import RobertoPruebas.*;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juampa
 */
public class Trabajadores extends javax.swing.JPanel {
    Conexion conexion;
    /**
     * Creates new form Clientes
     */
    public Trabajadores() {
        initComponents();
    }
    /**
     * Crea un nuevo panel de clientes
     * @param conexion objeto para conectarse a la BD
     */
    public Trabajadores(Conexion conexion){
        initComponents();
        this.conexion=conexion;
        //Inicia los paneles invisibles, para que se seleccione una opcion
        listadoPanel.setVisible(false);
        generalPanel.setVisible(false);
        //Limpia el formulario
        limpiar();
    }
    /**
     * Limpia el formulario
     */
    private void limpiar(){
        //Pone los botones de opcion como negros
        ingresarButton.setBackground(Color.BLACK);
        modificarButton.setBackground(Color.BLACK);
        eliminarButton.setBackground(Color.BLACK);
        verButton.setBackground(Color.BLACK);
        //Limpia los JFields
        dpiField.setText("");
        nombreField.setText("");
        apellidoField.setText("");
        telefonoField.setText("");
        //Inicializa con 0 los campos de numero
        bonoField.setText("0.00");
        comisionField.setText("0.00");
        salarioField.setText("0.00");
        //Limpia los datePickers
        inicioDate.setDate(null);
        bonoDate.setDate(null);
        //Setea un modelo vacio a la tabla
        listadoTable.setModel(new DefaultTableModel());
        listadoPanel.setEnabled(true);
        
    }
    /**
     * Carga los datos de la fila seleccionada en los campos, si se esta en modo modificación
     */
    private void filaSeleccionada(){
        if(modificarButton.getBackground()==Color.RED){
            int seleccion=listadoTable.getSelectedRow();
            if(seleccion!=-1){
                dpiField.setText((String)listadoTable.getValueAt(seleccion, 1));
                nombreField.setText((String)listadoTable.getValueAt(seleccion, 2));
                apellidoField.setText((String)listadoTable.getValueAt(seleccion, 3));
                telefonoField.setText((String)listadoTable.getValueAt(seleccion, 5));
                bonoField.setText((String)listadoTable.getValueAt(seleccion, 7));                
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ingresarButton = new javax.swing.JLabel();
        modificarButton = new javax.swing.JLabel();
        generalPanel = new javax.swing.JPanel();
        lbl_codigo = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        lbl_codigo1 = new javax.swing.JLabel();
        apellidoField = new javax.swing.JTextField();
        lbl_codigo2 = new javax.swing.JLabel();
        telefonoField = new javax.swing.JTextField();
        lbl_codigo3 = new javax.swing.JLabel();
        dpiField = new javax.swing.JTextField();
        lbl_codigo4 = new javax.swing.JLabel();
        lbl_codigo5 = new javax.swing.JLabel();
        generalButton = new javax.swing.JLabel();
        lbl_codigo7 = new javax.swing.JLabel();
        bonoField = new javax.swing.JFormattedTextField();
        comisionField = new javax.swing.JFormattedTextField();
        salarioField = new javax.swing.JFormattedTextField();
        lbl_codigo8 = new javax.swing.JLabel();
        lbl_codigo9 = new javax.swing.JLabel();
        inicioDate = new com.toedter.calendar.JDateChooser();
        bonoDate = new com.toedter.calendar.JDateChooser();
        eliminarButton = new javax.swing.JLabel();
        verButton = new javax.swing.JLabel();
        listadoPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listadoTable = new javax.swing.JTable();
        lbl_codigo6 = new javax.swing.JLabel();
        Minimizar = new javax.swing.JLabel();
        Salir = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ingresarButton.setBackground(new java.awt.Color(0, 0, 0));
        ingresarButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        ingresarButton.setForeground(new java.awt.Color(255, 255, 255));
        ingresarButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingresarButton.setText("INGRESO");
        ingresarButton.setName(""); // NOI18N
        ingresarButton.setOpaque(true);
        ingresarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresarButtonMouseClicked(evt);
            }
        });
        add(ingresarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 50));

        modificarButton.setBackground(new java.awt.Color(0, 0, 0));
        modificarButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        modificarButton.setForeground(new java.awt.Color(255, 255, 255));
        modificarButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        modificarButton.setText("MODIFICACION");
        modificarButton.setName(""); // NOI18N
        modificarButton.setOpaque(true);
        modificarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificarButtonMouseClicked(evt);
            }
        });
        add(modificarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 160, 50));

        generalPanel.setOpaque(false);

        lbl_codigo.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_codigo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo.setText("Nombre:");

        nombreField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        nombreField.setBorder(null);
        nombreField.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        nombreField.setNextFocusableComponent(apellidoField);
        nombreField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombreFieldFocusGained(evt);
            }
        });

        lbl_codigo1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_codigo1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo1.setText("Apellido:");

        apellidoField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        apellidoField.setBorder(null);
        apellidoField.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        apellidoField.setNextFocusableComponent(dpiField);
        apellidoField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                apellidoFieldFocusGained(evt);
            }
        });

        lbl_codigo2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_codigo2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo2.setText("Teléfono:");

        telefonoField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        telefonoField.setBorder(null);
        telefonoField.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        telefonoField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                telefonoFieldFocusGained(evt);
            }
        });

        lbl_codigo3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_codigo3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo3.setText("Salario base:");

        dpiField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        dpiField.setBorder(null);
        dpiField.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        dpiField.setNextFocusableComponent(telefonoField);
        dpiField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dpiFieldFocusGained(evt);
            }
        });

        lbl_codigo4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_codigo4.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo4.setText("DPI:");

        lbl_codigo5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_codigo5.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo5.setText("% de comisión:");

        generalButton.setBackground(new java.awt.Color(255, 0, 0));
        generalButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        generalButton.setForeground(new java.awt.Color(255, 255, 255));
        generalButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        generalButton.setText("GUARDAR");
        generalButton.setName(""); // NOI18N
        generalButton.setOpaque(true);
        generalButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generalButtonMouseClicked(evt);
            }
        });

        lbl_codigo7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_codigo7.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo7.setText("Bono incentivo:");

        bonoField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        bonoField.setText("0.00");
        bonoField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        bonoField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bonoFieldFocusGained(evt);
            }
        });

        comisionField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        comisionField.setText("0.00");
        comisionField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        comisionField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                comisionFieldFocusGained(evt);
            }
        });

        salarioField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        salarioField.setText("0.00");
        salarioField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        salarioField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                salarioFieldFocusGained(evt);
            }
        });

        lbl_codigo8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_codigo8.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo8.setText("Fecha de inicio:");

        lbl_codigo9.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_codigo9.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo9.setText("Fecha de bono:");

        inicioDate.setDateFormatString("yyyy/MM/dd");
        inicioDate.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        bonoDate.setDateFormatString("yyyy/MM/dd");
        bonoDate.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        javax.swing.GroupLayout generalPanelLayout = new javax.swing.GroupLayout(generalPanel);
        generalPanel.setLayout(generalPanelLayout);
        generalPanelLayout.setHorizontalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generalPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(generalPanelLayout.createSequentialGroup()
                                .addComponent(lbl_codigo4)
                                .addGap(125, 125, 125)
                                .addComponent(dpiField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, generalPanelLayout.createSequentialGroup()
                                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_codigo1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_codigo, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(apellidoField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, generalPanelLayout.createSequentialGroup()
                                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_codigo2)
                                    .addComponent(lbl_codigo5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comisionField)
                                    .addComponent(telefonoField, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(generalPanelLayout.createSequentialGroup()
                                .addComponent(lbl_codigo9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(bonoDate, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(generalPanelLayout.createSequentialGroup()
                                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_codigo3)
                                    .addComponent(lbl_codigo7)
                                    .addComponent(lbl_codigo8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bonoField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(salarioField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inicioDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(generalPanelLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(generalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        generalPanelLayout.setVerticalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(generalPanelLayout.createSequentialGroup()
                        .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(generalPanelLayout.createSequentialGroup()
                                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_codigo4)
                                    .addComponent(dpiField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_codigo)
                                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(generalPanelLayout.createSequentialGroup()
                                    .addComponent(salarioField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bonoField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(generalPanelLayout.createSequentialGroup()
                                    .addComponent(lbl_codigo3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbl_codigo7))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(apellidoField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_codigo8))
                            .addComponent(lbl_codigo1)))
                    .addComponent(inicioDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_codigo2)
                        .addComponent(telefonoField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_codigo9))
                    .addComponent(bonoDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_codigo5)
                    .addComponent(comisionField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(generalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(generalPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 770, 250));

        eliminarButton.setBackground(new java.awt.Color(0, 0, 0));
        eliminarButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        eliminarButton.setForeground(new java.awt.Color(255, 255, 255));
        eliminarButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eliminarButton.setText("ELIMINACIÓN");
        eliminarButton.setName(""); // NOI18N
        eliminarButton.setOpaque(true);
        eliminarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarButtonMouseClicked(evt);
            }
        });
        add(eliminarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 160, 50));

        verButton.setBackground(new java.awt.Color(0, 0, 0));
        verButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        verButton.setForeground(new java.awt.Color(255, 255, 255));
        verButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        verButton.setText("VER TRABAJADORES");
        verButton.setName(""); // NOI18N
        verButton.setOpaque(true);
        verButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verButtonMouseClicked(evt);
            }
        });
        add(verButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 190, 50));

        listadoPanel.setOpaque(false);

        listadoTable.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        listadoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        listadoTable.setGridColor(new java.awt.Color(0, 0, 0));
        listadoTable.setRowHeight(24);
        listadoTable.setSelectionBackground(new java.awt.Color(255, 0, 0));
        listadoTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        listadoTable.setShowVerticalLines(false);
        listadoTable.getTableHeader().setReorderingAllowed(false);
        listadoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listadoTableMousePressed(evt);
            }
        });
        listadoTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                listadoTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(listadoTable);

        lbl_codigo6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_codigo6.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo6.setText("Listado de trabajadores:");

        javax.swing.GroupLayout listadoPanelLayout = new javax.swing.GroupLayout(listadoPanel);
        listadoPanel.setLayout(listadoPanelLayout);
        listadoPanelLayout.setHorizontalGroup(
            listadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listadoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(listadoPanelLayout.createSequentialGroup()
                        .addComponent(lbl_codigo6)
                        .addContainerGap(699, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        listadoPanelLayout.setVerticalGroup(
            listadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listadoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_codigo6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        add(listadoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 920, 320));

        Minimizar.setForeground(new java.awt.Color(255, 255, 255));
        Minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosSCE/minus-symbol.png"))); // NOI18N
        Minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizarMouseClicked(evt);
            }
        });
        add(Minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, -1, -1));

        Salir.setBackground(new java.awt.Color(0, 0, 0));
        Salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosSCE/cancel (2).png"))); // NOI18N
        Salir.setOpaque(true);
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });
        add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void ingresarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresarButtonMouseClicked
        //Limpia el formulario
        limpiar();
        //Setea el boton de ingresar como rojo
        ingresarButton.setBackground(Color.RED);
        //Muestra los paneles
        listadoPanel.setEnabled(false);
        listadoPanel.setVisible(true);
        generalPanel.setVisible(true);
        //Cambia el texto del botón
        generalButton.setText("Ingresar");
        generalButton.setEnabled(true);
        //Pone el foco en el texto de nombre
        nombreField.requestFocus();
        
    }//GEN-LAST:event_ingresarButtonMouseClicked

    private void modificarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarButtonMouseClicked
        try {
            //limpia el formulario
            limpiar();
            //Setea el color del boton a rojo
            modificarButton.setBackground(Color.RED);
            //Muestra los paneles
            listadoPanel.setVisible(true);
            generalPanel.setVisible(true);
            //Obtiene la lista de clientes y la setea en la tabla
            listadoTable.setModel(conexion.obtenerClientesJP());
            //Setea el texto del boton
            generalButton.setText("Actualizar Datos");
            generalButton.setEnabled(true);
            //Pone el foco en la tabla
            listadoTable.requestFocus();
        } catch (SQLException|NoSePuedeConectar ex) {
            DialogoOpcion dialogo= new DialogoOpcion(null, true, DialogoOpcion.ICONO_ERROR, "Modificación", "Error:\n"+ex.toString());
            dialogo.setVisible(true);
        }
    }//GEN-LAST:event_modificarButtonMouseClicked

    private void eliminarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarButtonMouseClicked
        try {
            //Limpia el formulario
            limpiar();
            //Pone el color del boton en rojo y muestra los paneles
            eliminarButton.setBackground(Color.RED);
            listadoPanel.setVisible(true);
            generalPanel.setVisible(true);
            //Cambia el texto del botón
            generalButton.setText("Eliminar Selección");
            generalButton.setEnabled(true);
            //Obtiene la lista de clientes y la pone en la tabla, pone el foco en la misma
            listadoTable.setModel(conexion.obtenerClientesJP());
            listadoTable.requestFocus();
        } catch (SQLException|NoSePuedeConectar ex) {
            DialogoOpcion dialogo= new DialogoOpcion(null, true, DialogoOpcion.ICONO_ERROR, "Eliminación", "Error:\n"+ex.toString());
            dialogo.setVisible(true);
        }
    }//GEN-LAST:event_eliminarButtonMouseClicked

    private void verButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verButtonMouseClicked
        try {
            //Limpia el formulario
            limpiar();
            //Cambia el color del boton a rojo
            verButton.setBackground(Color.RED);
            //Obtiene la lista de clientes y la pone en la tabla
            listadoTable.setModel(conexion.obtenerClientesJP());
            //Muestra los paneles
            listadoPanel.setVisible(true);
            generalPanel.setVisible(true);
            //Inhabilita el botón
            generalButton.setEnabled(false);
        } catch (SQLException|NoSePuedeConectar ex) {
            DialogoOpcion dialogo= new DialogoOpcion(null, true, DialogoOpcion.ICONO_ERROR, "Visualización", "Error:\n"+ex.toString());
            dialogo.setVisible(true);
        }
    }//GEN-LAST:event_verButtonMouseClicked

    private void listadoTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listadoTableMousePressed
        filaSeleccionada();
    }//GEN-LAST:event_listadoTableMousePressed

    private void listadoTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listadoTableKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode()== KeyEvent.VK_DOWN)
        {
            filaSeleccionada();
        }
    }//GEN-LAST:event_listadoTableKeyReleased

    private void generalButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generalButtonMouseClicked
        try {
            //Si esta en modo ingreso, modificación o eliminación, hace cosas distintas
            //Se comprueba en que modo está
            if(ingresarButton.getBackground()==Color.RED){
                //Valida los datos de los textos de numero
                bonoField.commitEdit();
                //Hace un ingreso a la BD
                int resultado=1;//conexion.crearCliente(nombreField.getText().trim(), apellidoField.getText().trim(), (long)descuentoField.getValue(),direccionField.getText().trim(), (long)limCreditoField.getValue(),Float.parseFloat(saldoField.getText()),nitField.getText().trim(), chequeCheck.isSelected());
                //Si el resultado es 1, significa que si se ingreso, si es 0 que no (ya existe)
                if(resultado==1){
                    DialogoOpcion dialogo= new DialogoOpcion(null, true, DialogoOpcion.ICONO_INFORMACION, "Ingreso", "Se ha ingresado correctamente");
                    dialogo.setVisible(true);
                }
                else if(resultado==0){
                    DialogoOpcion dialogo= new DialogoOpcion(null, true, DialogoOpcion.ICONO_ERROR, "Ingreso", "Este usuario ya existe");
                    dialogo.setVisible(true);
                }
                //Limpia el formulario
                limpiar();
            }else if(modificarButton.getBackground()==Color.RED){
                //Valida los datos de los campos de numero
                bonoField.commitEdit();
                //Hace la consulta de modificación y devuelve el número de filas cambiadas (Debe de ser 1)
                int filasMod=0;//conexion.modificarCliente(Integer.parseInt(listadoTable.getValueAt(listadoTable.getSelectedRow(),0).toString()),nombreField.getText().trim(), apellidoField.getText().trim(), (long)descuentoField.getValue(),direccionField.getText().trim(), (long)limCreditoField.getValue(),Float.parseFloat(saldoField.getText()),nitField.getText().trim(), chequeCheck.isSelected());
                DialogoOpcion dialogo= new DialogoOpcion(null, true, DialogoOpcion.ICONO_INFORMACION, "Modificación", "Se ha actualizado correctamente\nRegistros actualizados: "+filasMod);
                dialogo.setVisible(true);
                //Limpia el formulario
                limpiar();
            }else if(eliminarButton.getBackground()==Color.RED)
            {
                //Muestra un dialogo para confirmar si se quiere borrar el cliente
                DialogoOpcion dialogo = new DialogoOpcion(null, true, DialogoOpcion.ICONO_INTERROGANTE,"Eliminación", "¿Esta seguro de eliminar al cliente seleccionado?");
                dialogo.setVisible(true);
                //Si se acepta, entonces lo borra
                if(dialogo.isAceptar()){
                    //Manda la orden de eliminación a la BD, devuelve el número de filas cambiadas
                    int filasMod=conexion.eliminarCliente(Integer.parseInt(listadoTable.getValueAt(listadoTable.getSelectedRow(),0).toString()));
                    dialogo= new DialogoOpcion(null, true, DialogoOpcion.ICONO_INFORMACION, "Eliminación", "Se ha eliminado al cliente\nRegistros actualizados: "+filasMod);
                    dialogo.setVisible(true);
                    //Limpia el formulario
                    limpiar();
                }
            }
        } catch (SQLException|ParseException|NoSePuedeConectar ex) {
            DialogoOpcion dialogo= new DialogoOpcion(null, true, DialogoOpcion.ICONO_ERROR, "Ingreso", "Error:\n"+ex.toString());
            dialogo.setVisible(true);
            limpiar();
        }
        
    }//GEN-LAST:event_generalButtonMouseClicked

    private void MinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizarMouseClicked
        //Obtenemos los contenedores padres, hasta obtener el JFrame donde se está trabajando
        JFrame padre= (JFrame)this.getParent().getParent().getParent().getParent().getParent();
        //Se le manda la orden de minimizar
        padre.setExtendedState(1);
    }//GEN-LAST:event_MinimizarMouseClicked

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_SalirMouseClicked

    private void nombreFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreFieldFocusGained
        nombreField.selectAll();
    }//GEN-LAST:event_nombreFieldFocusGained

    private void apellidoFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_apellidoFieldFocusGained
        apellidoField.selectAll();
    }//GEN-LAST:event_apellidoFieldFocusGained

    private void dpiFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dpiFieldFocusGained
        dpiField.selectAll();
    }//GEN-LAST:event_dpiFieldFocusGained

    private void telefonoFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telefonoFieldFocusGained
        telefonoField.selectAll();
    }//GEN-LAST:event_telefonoFieldFocusGained

    private void comisionFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comisionFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_comisionFieldFocusGained

    private void bonoFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bonoFieldFocusGained
        bonoField.selectAll();
    }//GEN-LAST:event_bonoFieldFocusGained

    private void salarioFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_salarioFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_salarioFieldFocusGained
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Minimizar;
    private javax.swing.JLabel Salir;
    private javax.swing.JTextField apellidoField;
    private com.toedter.calendar.JDateChooser bonoDate;
    private javax.swing.JFormattedTextField bonoField;
    private javax.swing.JFormattedTextField comisionField;
    private javax.swing.JTextField dpiField;
    private javax.swing.JLabel eliminarButton;
    private javax.swing.JLabel generalButton;
    private javax.swing.JPanel generalPanel;
    private javax.swing.JLabel ingresarButton;
    private com.toedter.calendar.JDateChooser inicioDate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_codigo1;
    private javax.swing.JLabel lbl_codigo2;
    private javax.swing.JLabel lbl_codigo3;
    private javax.swing.JLabel lbl_codigo4;
    private javax.swing.JLabel lbl_codigo5;
    private javax.swing.JLabel lbl_codigo6;
    private javax.swing.JLabel lbl_codigo7;
    private javax.swing.JLabel lbl_codigo8;
    private javax.swing.JLabel lbl_codigo9;
    private javax.swing.JPanel listadoPanel;
    private javax.swing.JTable listadoTable;
    private javax.swing.JLabel modificarButton;
    private javax.swing.JTextField nombreField;
    private javax.swing.JFormattedTextField salarioField;
    private javax.swing.JTextField telefonoField;
    private javax.swing.JLabel verButton;
    // End of variables declaration//GEN-END:variables
}
