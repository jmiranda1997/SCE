/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import RobertoPruebas.*;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Juampa
 */
public class Clientes extends javax.swing.JPanel {
    Conexion conexion;
    /**
     * Creates new form Clientes
     */
    public Clientes() {
        initComponents();
    }
    public Clientes(Conexion conexion){
        initComponents();
        this.conexion=conexion;
        listadoPanel.setVisible(false);
        generalPanel.setVisible(false);
        limpiar();
    }
    private void limpiar(){
        ingresarButton.setBackground(Color.BLACK);
        modificarButton.setBackground(Color.BLACK);
        eliminarButton.setBackground(Color.BLACK);
        verButton.setBackground(Color.BLACK);
        nombreField.setText("");
        apellidoField.setText("");
        nitField.setText("");
        direccionField.setText("");
        descuentoField.setText("0");
        limCreditoField.setText("0");
        creditoField.setText("0.00");
        chequeCheck.setSelected(false);
        listadoTable.setModel(new DefaultTableModel());
        listadoPanel.setEnabled(true);
        
    }
    private void filaSeleccionada(){
        int seleccion=listadoTable.getSelectedRow();
        if(seleccion!=-1){
            
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
        direccionField = new javax.swing.JTextField();
        lbl_codigo3 = new javax.swing.JLabel();
        nitField = new javax.swing.JTextField();
        lbl_codigo4 = new javax.swing.JLabel();
        lbl_codigo5 = new javax.swing.JLabel();
        chequeCheck = new javax.swing.JCheckBox();
        guardarButton = new javax.swing.JLabel();
        descuentoField = new javax.swing.JFormattedTextField();
        limCreditoField = new javax.swing.JFormattedTextField();
        lbl_codigo7 = new javax.swing.JLabel();
        creditoField = new javax.swing.JFormattedTextField();
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
        apellidoField.setNextFocusableComponent(nitField);
        apellidoField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                apellidoFieldFocusGained(evt);
            }
        });

        lbl_codigo2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_codigo2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo2.setText("Dirección:");

        direccionField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        direccionField.setBorder(null);
        direccionField.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        direccionField.setNextFocusableComponent(descuentoField);
        direccionField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                direccionFieldFocusGained(evt);
            }
        });

        lbl_codigo3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_codigo3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo3.setText("Límite de crédito:");

        nitField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        nitField.setBorder(null);
        nitField.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        nitField.setNextFocusableComponent(direccionField);
        nitField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nitFieldFocusGained(evt);
            }
        });

        lbl_codigo4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_codigo4.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo4.setText("NIT:");

        lbl_codigo5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_codigo5.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo5.setText("% de descuento:");

        chequeCheck.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        chequeCheck.setForeground(new java.awt.Color(255, 255, 255));
        chequeCheck.setText("¿Se le acepta cheque?");
        chequeCheck.setNextFocusableComponent(guardarButton);
        chequeCheck.setOpaque(false);

        guardarButton.setBackground(new java.awt.Color(255, 0, 0));
        guardarButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        guardarButton.setForeground(new java.awt.Color(255, 255, 255));
        guardarButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guardarButton.setText("GUARDAR");
        guardarButton.setName(""); // NOI18N
        guardarButton.setOpaque(true);
        guardarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarButtonMouseClicked(evt);
            }
        });

        descuentoField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        descuentoField.setText("0");
        descuentoField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        descuentoField.setNextFocusableComponent(limCreditoField);
        descuentoField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                descuentoFieldFocusGained(evt);
            }
        });

        limCreditoField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        limCreditoField.setText("0");
        limCreditoField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        limCreditoField.setNextFocusableComponent(creditoField);
        limCreditoField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                limCreditoFieldFocusGained(evt);
            }
        });

        lbl_codigo7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_codigo7.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo7.setText("Crédito actual:");

        creditoField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        creditoField.setText("0");
        creditoField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        creditoField.setNextFocusableComponent(chequeCheck);
        creditoField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                creditoFieldFocusGained(evt);
            }
        });

        javax.swing.GroupLayout generalPanelLayout = new javax.swing.GroupLayout(generalPanel);
        generalPanel.setLayout(generalPanelLayout);
        generalPanelLayout.setHorizontalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbl_codigo1)
                        .addComponent(lbl_codigo))
                    .addComponent(lbl_codigo4)
                    .addComponent(lbl_codigo2))
                .addGap(68, 68, 68)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(direccionField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nitField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidoField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generalPanelLayout.createSequentialGroup()
                        .addComponent(lbl_codigo5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(descuentoField))
                    .addGroup(generalPanelLayout.createSequentialGroup()
                        .addComponent(chequeCheck)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(generalPanelLayout.createSequentialGroup()
                        .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_codigo3)
                            .addComponent(lbl_codigo7))
                        .addGap(7, 7, 7)
                        .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(creditoField)
                            .addComponent(limCreditoField, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, generalPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(277, 277, 277))
        );
        generalPanelLayout.setVerticalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_codigo)
                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_codigo5)
                    .addComponent(descuentoField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_codigo1)
                    .addComponent(apellidoField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_codigo3)
                    .addComponent(limCreditoField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_codigo7)
                        .addComponent(creditoField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_codigo4)
                        .addComponent(nitField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_codigo2)
                    .addComponent(direccionField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chequeCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        add(generalPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 720, 210));

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
        verButton.setText("VER CLIENTES");
        verButton.setName(""); // NOI18N
        verButton.setOpaque(true);
        verButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verButtonMouseClicked(evt);
            }
        });
        add(verButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 160, 50));

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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listadoTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                listadoTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(listadoTable);

        lbl_codigo6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_codigo6.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo6.setText("Listado de clientes:");

        javax.swing.GroupLayout listadoPanelLayout = new javax.swing.GroupLayout(listadoPanel);
        listadoPanel.setLayout(listadoPanelLayout);
        listadoPanelLayout.setHorizontalGroup(
            listadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listadoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(listadoPanelLayout.createSequentialGroup()
                        .addComponent(lbl_codigo6)
                        .addContainerGap(743, Short.MAX_VALUE))
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

        add(listadoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 920, 320));

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
        limpiar();
        ingresarButton.setBackground(Color.RED);
        listadoPanel.setEnabled(false);
        listadoPanel.setVisible(true);
        generalPanel.setVisible(true);
        
    }//GEN-LAST:event_ingresarButtonMouseClicked

    private void modificarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarButtonMouseClicked
        limpiar();

        modificarButton.setBackground(Color.RED);

        listadoPanel.setVisible(true);
        generalPanel.setVisible(true);
    }//GEN-LAST:event_modificarButtonMouseClicked

    private void eliminarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarButtonMouseClicked
        limpiar();
        listadoPanel.setVisible(true);
        generalPanel.setVisible(true);
    }//GEN-LAST:event_eliminarButtonMouseClicked

    private void verButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verButtonMouseClicked
        try {
            limpiar();
            verButton.setBackground(Color.RED);
            listadoTable.setModel(conexion.obtenerClientesJP());
            listadoPanel.setVisible(true);
            generalPanel.setVisible(true);
        } catch (SQLException ex) {
            DialogoOpcion dialogo = new DialogoOpcion(null, true, DialogoOpcion.ICONO_ERROR, "ERROR", ex.getMessage());
            dialogo.setVisible(true);
        }
    }//GEN-LAST:event_verButtonMouseClicked

    private void listadoTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listadoTableMousePressed
        filaSeleccionada();
    }//GEN-LAST:event_listadoTableMousePressed

    private void listadoTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listadoTableKeyPressed

    }//GEN-LAST:event_listadoTableKeyPressed

    private void listadoTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listadoTableKeyReleased
        if (evt.getKeyCode() == 38 || evt.getKeyCode()== 40)
        {
            filaSeleccionada();
        }
    }//GEN-LAST:event_listadoTableKeyReleased

    private void guardarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarButtonMouseClicked
        try {
            if(ingresarButton.getBackground()==Color.RED){
                descuentoField.commitEdit();
                limCreditoField.commitEdit();
                creditoField.commitEdit();
                int resultado=conexion.crearCliente(nombreField.getText().trim(), apellidoField.getText().trim(), (long)descuentoField.getValue(),direccionField.getText().trim(), (long)limCreditoField.getValue(),Float.parseFloat(creditoField.getText()),nitField.getText().trim(), chequeCheck.isSelected());
                if(resultado==1){
                    DialogoOpcion dialogo= new DialogoOpcion(null, true, DialogoOpcion.ICONO_INFORMACION, "Ingreso", "Se ha ingresado correctamente");
                    dialogo.setVisible(true);
                }
                else if(resultado==0){
                    DialogoOpcion dialogo= new DialogoOpcion(null, true, DialogoOpcion.ICONO_ERROR, "Ingreso", "Este usuario ya existe");
                    dialogo.setVisible(true);
                }
            }else if(modificarButton.getBackground()==Color.RED){
                
            }
        } catch (SQLException|ParseException ex) {
            DialogoOpcion dialogo= new DialogoOpcion(null, true, DialogoOpcion.ICONO_ERROR, "Ingreso", "Error:\n"+ex.toString());
            dialogo.setVisible(true);
        }
        limpiar();
        
    }//GEN-LAST:event_guardarButtonMouseClicked

    private void MinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizarMouseClicked
        //Obtenemos los contenedores padres, hasta obtener el JFrame donde se está trabajando
        JFrame padre= (JFrame)this.getParent().getParent().getParent().getParent().getParent();
        //Se le manda la orden de minimizar
        padre.setExtendedState(1);
    }//GEN-LAST:event_MinimizarMouseClicked

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_SalirMouseClicked

    private void descuentoFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descuentoFieldFocusGained
        descuentoField.selectAll();
    }//GEN-LAST:event_descuentoFieldFocusGained

    private void limCreditoFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_limCreditoFieldFocusGained
        limCreditoField.selectAll();
    }//GEN-LAST:event_limCreditoFieldFocusGained

    private void creditoFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_creditoFieldFocusGained
        creditoField.selectAll();
    }//GEN-LAST:event_creditoFieldFocusGained

    private void nombreFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreFieldFocusGained
        nombreField.selectAll();
    }//GEN-LAST:event_nombreFieldFocusGained

    private void apellidoFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_apellidoFieldFocusGained
        apellidoField.selectAll();
    }//GEN-LAST:event_apellidoFieldFocusGained

    private void nitFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nitFieldFocusGained
        nitField.selectAll();
    }//GEN-LAST:event_nitFieldFocusGained

    private void direccionFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_direccionFieldFocusGained
        direccionField.selectAll();
    }//GEN-LAST:event_direccionFieldFocusGained
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Minimizar;
    private javax.swing.JLabel Salir;
    private javax.swing.JTextField apellidoField;
    private javax.swing.JCheckBox chequeCheck;
    private javax.swing.JFormattedTextField creditoField;
    private javax.swing.JFormattedTextField descuentoField;
    private javax.swing.JTextField direccionField;
    private javax.swing.JLabel eliminarButton;
    private javax.swing.JPanel generalPanel;
    private javax.swing.JLabel guardarButton;
    private javax.swing.JLabel ingresarButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_codigo1;
    private javax.swing.JLabel lbl_codigo2;
    private javax.swing.JLabel lbl_codigo3;
    private javax.swing.JLabel lbl_codigo4;
    private javax.swing.JLabel lbl_codigo5;
    private javax.swing.JLabel lbl_codigo6;
    private javax.swing.JLabel lbl_codigo7;
    private javax.swing.JFormattedTextField limCreditoField;
    private javax.swing.JPanel listadoPanel;
    private javax.swing.JTable listadoTable;
    private javax.swing.JLabel modificarButton;
    private javax.swing.JTextField nitField;
    private javax.swing.JTextField nombreField;
    private javax.swing.JLabel verButton;
    // End of variables declaration//GEN-END:variables
}
