/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RobertoPruebas;

import RobertoPruebas.Conexion;
import Ventanas.DialogodeConfrimacion;
import Ventanas.DialogodeMensaje;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jonathan Miranda
 */
public class selectorFactura extends javax.swing.JDialog {

    /**
     * Creates new form selectorSucursal
     */
    private final Conexion Conexion_DB = new Conexion();
    private ArrayList ids;
    private String[] datos=null;
    public selectorFactura(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        try {
            DefaultTableModel tabla=Conexion_DB.obtenerFacturasConsulta(null,null,null);
            if(tabla!=null)
            {
                tabla_Sucursales.setModel(tabla);
                ids=Conexion_DB.id_ventas(null,null,null);
            }
            else
                this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(selectorFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.setLocationRelativeTo(null);
    }
    
    public String[] getDatos() {
        return datos;
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
        btn_Aceptar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_Titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_Sucursales = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Aceptar.setBackground(new java.awt.Color(255, 0, 0));
        btn_Aceptar.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        btn_Aceptar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Aceptar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Aceptar.setText("ACEPTAR");
        btn_Aceptar.setEnabled(false);
        btn_Aceptar.setOpaque(true);
        btn_Aceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_AceptarMouseClicked(evt);
            }
        });
        jPanel1.add(btn_Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, 160, 40));

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Titulo.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lbl_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Titulo.setText("SELECCIONE UNA FACTURA");
        jPanel2.add(lbl_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 40));

        tabla_Sucursales.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tabla_Sucursales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_Sucursales.setGridColor(new java.awt.Color(0, 0, 0));
        tabla_Sucursales.setRowHeight(24);
        tabla_Sucursales.setSelectionBackground(new java.awt.Color(255, 0, 0));
        tabla_Sucursales.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tabla_Sucursales.setShowVerticalLines(false);
        tabla_Sucursales.getTableHeader().setReorderingAllowed(false);
        tabla_Sucursales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_SucursalesMousePressed(evt);
            }
        });
        tabla_Sucursales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabla_SucursalesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_Sucursales);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 650, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AceptarMouseClicked
        // TODO add your handling code here:
        datos=new String[9];
        datos[0]=ids.get(tabla_Sucursales.getSelectedRow()).toString();
        datos[1]=tabla_Sucursales.getValueAt(tabla_Sucursales.getSelectedRow(),0).toString();
        datos[2]=tabla_Sucursales.getValueAt(tabla_Sucursales.getSelectedRow(),1).toString();
        datos[3]=tabla_Sucursales.getValueAt(tabla_Sucursales.getSelectedRow(),2).toString();
        datos[4]=tabla_Sucursales.getValueAt(tabla_Sucursales.getSelectedRow(),3).toString();
        datos[5]=tabla_Sucursales.getValueAt(tabla_Sucursales.getSelectedRow(),4).toString();
        datos[6]=tabla_Sucursales.getValueAt(tabla_Sucursales.getSelectedRow(),5).toString();
        datos[7]=tabla_Sucursales.getValueAt(tabla_Sucursales.getSelectedRow(),6).toString();
        datos[8]=tabla_Sucursales.getValueAt(tabla_Sucursales.getSelectedRow(),7).toString();
        this.setVisible(false);
        
    }//GEN-LAST:event_btn_AceptarMouseClicked

    private void tabla_SucursalesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_SucursalesMousePressed
        if (tabla_Sucursales.getSelectedRow() != -1) {
            btn_Aceptar.setEnabled(true);
        }

    }//GEN-LAST:event_tabla_SucursalesMousePressed

    private void tabla_SucursalesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla_SucursalesKeyPressed
        //filaSeleccionada();
    }//GEN-LAST:event_tabla_SucursalesKeyPressed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(selectorFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(selectorFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(selectorFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(selectorFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                selectorFactura dialog = new selectorFactura(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_Aceptar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JTable tabla_Sucursales;
    // End of variables declaration//GEN-END:variables
}
