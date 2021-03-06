/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

/**
 *
 * @author jonathan Miranda
 */
public class Descuento extends javax.swing.JDialog {

    /**
     * Creates new form Descuento
     */
    public Descuento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    private float cantidad, descuento;
    private boolean Seleccion = false;

    public boolean isSeleccion() {
        return Seleccion;
    }
    public Descuento(java.awt.Frame parent, boolean modal, float cantidad, float descuento) {
        super(parent, modal);
        initComponents();
        this.cantidad = cantidad;
        this.descuento = descuento;
    }

    public float getCantidad() {
        return cantidad;
    }

    public float getDescuento() {
        return descuento;
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
        btn_Aceptar = new javax.swing.JLabel();
        lbl_Titulo1 = new javax.swing.JLabel();
        lbl_Titulo2 = new javax.swing.JLabel();
        txt_Cant = new javax.swing.JFormattedTextField();
        sep_Nombre7 = new javax.swing.JSeparator();
        sep_Nombre8 = new javax.swing.JSeparator();
        txt_Desc = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

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
        jPanel1.add(btn_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 180, 40));

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        lbl_Titulo.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lbl_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Titulo.setText("CANTIDAD Y DESCUENTO");

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
        jPanel1.add(btn_Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 180, 40));

        lbl_Titulo1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lbl_Titulo1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Titulo1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_Titulo1.setText("DECUENTO");
        jPanel1.add(lbl_Titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 150, -1));

        lbl_Titulo2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lbl_Titulo2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Titulo2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_Titulo2.setText("CANTIDAD");
        jPanel1.add(lbl_Titulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 150, -1));

        txt_Cant.setBackground(new java.awt.Color(0, 0, 0));
        txt_Cant.setBorder(null);
        txt_Cant.setForeground(new java.awt.Color(255, 255, 255));
        txt_Cant.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txt_Cant.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txt_Cant.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_Cant.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txt_Cant.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_Cant.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_CantFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_CantFocusLost(evt);
            }
        });
        jPanel1.add(txt_Cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 180, -1));

        sep_Nombre7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(sep_Nombre7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 180, 10));

        sep_Nombre8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(sep_Nombre8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 180, 10));

        txt_Desc.setBackground(new java.awt.Color(0, 0, 0));
        txt_Desc.setBorder(null);
        txt_Desc.setForeground(new java.awt.Color(255, 255, 255));
        txt_Desc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txt_Desc.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txt_Desc.setText("0.00");
        txt_Desc.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_Desc.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txt_Desc.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_Desc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_DescFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_DescFocusLost(evt);
            }
        });
        jPanel1.add(txt_Desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 180, -1));

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
        this.setVisible(false);
    }//GEN-LAST:event_btn_CancelarMouseClicked

    private void btn_AceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AceptarMouseClicked
        this.cantidad = Float.parseFloat(txt_Cant.getText());
        this.descuento = Float.parseFloat(txt_Desc.getText());
        Seleccion = true;
        this.setVisible(false);
    }//GEN-LAST:event_btn_AceptarMouseClicked

    private void txt_CantFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_CantFocusGained
        if (txt_Cant.getText().equals("0.00")) txt_Cant.setText("");
    }//GEN-LAST:event_txt_CantFocusGained

    private void txt_CantFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_CantFocusLost
        if (txt_Cant.getText().equals("")) txt_Cant.setText("0.00");
    }//GEN-LAST:event_txt_CantFocusLost

    private void txt_DescFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_DescFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DescFocusGained

    private void txt_DescFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_DescFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DescFocusLost

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
            java.util.logging.Logger.getLogger(Descuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Descuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Descuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Descuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Descuento dialog = new Descuento(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel btn_Cancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JLabel lbl_Titulo1;
    private javax.swing.JLabel lbl_Titulo2;
    private javax.swing.JSeparator sep_Nombre7;
    private javax.swing.JSeparator sep_Nombre8;
    private javax.swing.JFormattedTextField txt_Cant;
    private javax.swing.JFormattedTextField txt_Desc;
    // End of variables declaration//GEN-END:variables
}
