/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import RobertoPruebas.Conexion;
import java.sql.SQLException;

/**
 *
 * @author jonathan Miranda
 */
public class DialogodeConfrimacion extends javax.swing.JFrame {

    public static final int ICONO_ERROR = 1;
    public static final int ICONO_INFORMACION = 2;
    public static final int ICONO_INTERROGANTE = 3;
    private int seleccion;
    private Conexion Conexion_DB = new Conexion();
    private String Nombre;
    private DialogodeMensaje Dialogo = new DialogodeMensaje();
    public int estado = 0;
    public DialogodeConfrimacion() {
        initComponents();
    }
    public void setContenido(String Titulo, String Mensaje, int Icono, String Nombre){
        this.lbl_Titulo.setText(Titulo);
        this.Mensaje.setText(Mensaje);
        this.seleccion = Icono;
        this.Nombre =Nombre;
        estado = 0;
        if (Icono == 1) {
            this.Icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosSCE/error.png")));
            this.btn_Cancelar.setVisible(false);
        }else if (Icono == 2){
            this.Icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosSCE/info.png")));
            this.btn_Cancelar.setVisible(false);
        }else if (Icono == 3){
            this.Icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosSCE/question.png")));
            this.btn_Cancelar.setVisible(true);
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

        jPanel1 = new javax.swing.JPanel();
        btn_Cancelar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_Titulo = new javax.swing.JLabel();
        Icono = new javax.swing.JLabel();
        Mensaje = new javax.swing.JLabel();
        btn_Aceptar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Cancelar.setBackground(new java.awt.Color(255, 0, 0));
        btn_Cancelar.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        btn_Cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Cancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Cancelar.setText("CANCELAR");
        btn_Cancelar.setOpaque(true);
        btn_Cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CancelarMouseClicked(evt);
            }
        });
        jPanel1.add(btn_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 160, 40));

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        lbl_Titulo.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lbl_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Titulo.setText("TITULO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_Titulo)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        Icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosSCE/info.png"))); // NOI18N
        jPanel1.add(Icono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        Mensaje.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Mensaje.setForeground(new java.awt.Color(255, 255, 255));
        Mensaje.setText("MENSAJE");
        Mensaje.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(Mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 290, 80));

        btn_Aceptar.setBackground(new java.awt.Color(255, 0, 0));
        btn_Aceptar.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        btn_Aceptar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Aceptar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Aceptar.setText("ACEPTAR");
        btn_Aceptar.setOpaque(true);
        btn_Aceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_AceptarMouseClicked(evt);
            }
        });
        jPanel1.add(btn_Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 160, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CancelarMouseClicked
        // TODO add your handling code here:
        estado = 1;
        this.setVisible(false);
    }//GEN-LAST:event_btn_CancelarMouseClicked

    private void btn_AceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AceptarMouseClicked
        // TODO add your handling code here:
        if (seleccion == 3) {
            try {
                Conexion_DB.desHabilitarProvedor(Nombre);
            } catch (SQLException ex) {
                Dialogo.setContenido("ERROR", ex.getMessage(), DialogodeMensaje.ICONO_ERROR);
                Dialogo.setVisible(true);
            }
        }
        estado = 1;
        this.setVisible(false);
    }//GEN-LAST:event_btn_AceptarMouseClicked

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
            java.util.logging.Logger.getLogger(DialogodeConfrimacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogodeConfrimacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogodeConfrimacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogodeConfrimacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DialogodeConfrimacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Icono;
    private javax.swing.JLabel Mensaje;
    private javax.swing.JLabel btn_Aceptar;
    private javax.swing.JLabel btn_Cancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_Titulo;
    // End of variables declaration//GEN-END:variables
}
