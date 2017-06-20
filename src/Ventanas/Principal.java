/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;


import RobertoPruebas.Conexion;
import RobertoPruebas.Productos;
import RobertoPruebas.producto_lista;

import RobertoPruebas.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jonathanmiranda
 */
public class Principal extends javax.swing.JFrame {
    private Conexion conexion;
    private Seguridad seguridad;
    private Clientes clientes;
    private Compras panel_Compras;
    private Ventas panel_Ventas;
    private Trabajadores trabajadores;
    private Ausencias ausencias;
    private Union union;
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        setLocationRelativeTo(null);  
        panel_Compras = new Compras();
        panel_Ventas = new Ventas();
    }
    public Principal(Conexion con){
        initComponents();
        setLocationRelativeTo(null);
        this.conexion=con;
        panel_Compras = new Compras();
        panel_Ventas = new Ventas();
    }
    public void setEtiqueta(JLabel etiqueta){
        etiqueta.setBackground(Color.BLACK);
    }
    public void resetEtiqueta(JLabel etiqueta){
        etiqueta.setBackground(Color.RED);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_Inventario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_Compras = new javax.swing.JLabel();
        btn_Ventas = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Salir = new javax.swing.JLabel();
        Minimizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        btn_Inventario.setBackground(new java.awt.Color(255, 0, 0));
        btn_Inventario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Inventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosSCE/barcode (1).png"))); // NOI18N
        btn_Inventario.setOpaque(true);
        btn_Inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_InventarioMouseClicked(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosSCE/settings.png"))); // NOI18N
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        btn_Compras.setBackground(new java.awt.Color(255, 0, 0));
        btn_Compras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Compras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosSCE/shopping-cart.png"))); // NOI18N
        btn_Compras.setOpaque(true);
        btn_Compras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ComprasMouseClicked(evt);
            }
        });

        btn_Ventas.setBackground(new java.awt.Color(255, 0, 0));
        btn_Ventas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosSCE/price-tag.png"))); // NOI18N
        btn_Ventas.setOpaque(true);
        btn_Ventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_VentasMouseClicked(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosSCE/locked.png"))); // NOI18N
        jLabel6.setOpaque(true);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosSCE/coin.png"))); // NOI18N
        jLabel7.setOpaque(true);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_Inventario, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(btn_Compras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_Ventas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btn_Inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(btn_Compras, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(btn_Ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 690));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        Salir.setBackground(new java.awt.Color(0, 0, 0));
        Salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosSCE/cancel (2).png"))); // NOI18N
        Salir.setOpaque(true);
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });

        Minimizar.setForeground(new java.awt.Color(255, 255, 255));
        Minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosSCE/minus-symbol.png"))); // NOI18N
        Minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(867, 867, 867)
                .addComponent(Minimizar)
                .addGap(6, 6, 6)
                .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Minimizar))
                    .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(650, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 940, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_jPanel2MouseClicked

    private void btn_InventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_InventarioMouseClicked
        setEtiqueta(btn_Inventario);
        resetEtiqueta(jLabel3);
        resetEtiqueta(btn_Compras);
        resetEtiqueta(btn_Ventas);
        resetEtiqueta(jLabel6);
        resetEtiqueta(jLabel7);
        JPanel j = new Productos(conexion);
        j.setLocation(0, 0);
        j.setSize(jPanel2.getSize());
        jPanel2.removeAll();
        jPanel2.add(j, BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel1.repaint();
        jPanel2.repaint();           
    }//GEN-LAST:event_btn_InventarioMouseClicked
    
    private void btn_ComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ComprasMouseClicked
        setEtiqueta(btn_Compras);
        resetEtiqueta(jLabel3);
        resetEtiqueta(btn_Inventario);
        resetEtiqueta(btn_Ventas);
        resetEtiqueta(jLabel6);
        resetEtiqueta(jLabel7);
        panel_Compras.setLocation(0, 0);
        panel_Compras.setSize(jPanel2.getSize());
        jPanel2.removeAll();
        jPanel2.add(panel_Compras, BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel1.repaint();
        jPanel2.repaint();
//        panel_Compras.inicializarPedido();
    }//GEN-LAST:event_btn_ComprasMouseClicked

    private void btn_VentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_VentasMouseClicked
        setEtiqueta(btn_Ventas);
        resetEtiqueta(jLabel3);
        resetEtiqueta(btn_Compras);
        resetEtiqueta(btn_Inventario);
        resetEtiqueta(jLabel6);
        resetEtiqueta(jLabel7);
        panel_Ventas.setLocation(0, 0);
        panel_Ventas.setSize(jPanel2.getSize());
        jPanel2.removeAll();
        jPanel2.add(panel_Ventas, BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel1.repaint();
        jPanel2.repaint();
    }//GEN-LAST:event_btn_VentasMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        setEtiqueta(jLabel6);
        resetEtiqueta(jLabel3);
        resetEtiqueta(btn_Compras);
        resetEtiqueta(btn_Ventas);
        resetEtiqueta(btn_Inventario);
        resetEtiqueta(jLabel7);
        if(seguridad==null)
            seguridad= new Seguridad(conexion);
        seguridad.setLocation(0,0);
        seguridad.setSize(jPanel2.getSize());
        jPanel2.removeAll();
        jPanel2.add(seguridad,BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel2.repaint();
        jPanel1.repaint();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        setEtiqueta(jLabel7);
        resetEtiqueta(jLabel3);
        resetEtiqueta(btn_Compras);
        resetEtiqueta(btn_Ventas);
        resetEtiqueta(jLabel6);
        resetEtiqueta(btn_Inventario);
        if(union==null)
            union=new Union(conexion);
        union.setLocation(0,0);
        union.setSize(jPanel2.getSize());
//        
//        if(clientes==null)
//            clientes= new Clientes(conexion);
//        clientes.setLocation(0,0);
//        clientes.setSize(jPanel2.getSize());
        jPanel2.removeAll();
        jPanel2.add(union/*clientes*/,BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel2.repaint();
        jPanel1.repaint();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        setEtiqueta(jLabel3);
        resetEtiqueta(btn_Inventario);
        resetEtiqueta(btn_Compras);
        resetEtiqueta(btn_Ventas);
        resetEtiqueta(jLabel6);
        resetEtiqueta(jLabel7);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_SalirMouseClicked

    private void MinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizarMouseClicked
        //Obtenemos los contenedores padres, hasta obtener el JFrame donde se está trabajando
        JFrame padre= this;
        //Se le manda la orden de minimizar
        padre.setExtendedState(1);
    }//GEN-LAST:event_MinimizarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Minimizar;
    private javax.swing.JLabel Salir;
    private javax.swing.JLabel btn_Compras;
    private javax.swing.JLabel btn_Inventario;
    private javax.swing.JLabel btn_Ventas;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
