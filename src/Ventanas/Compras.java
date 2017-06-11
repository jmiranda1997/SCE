/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jonathan Miranda
 */
public class Compras extends javax.swing.JPanel {

    /**
     * Creates new form Proveedores
     */
    public Compras() {
        initComponents();
        inicializarPedido();
    }
    private void setBoton(JLabel boton){
        boton.setBackground(Color.RED);
    }
    private void resetBoton(JLabel boton){
        boton.setBackground(Color.BLACK);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Salir = new javax.swing.JLabel();
        Minimizar = new javax.swing.JLabel();
        btn_Compras = new javax.swing.JLabel();
        btn_Proveedores = new javax.swing.JLabel();
        btn_Reportes = new javax.swing.JLabel();
        btn_Pagos = new javax.swing.JLabel();
        panel_Contenido = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Salir.setBackground(new java.awt.Color(0, 0, 0));
        Salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosSCE/cancel (2).png"))); // NOI18N
        Salir.setOpaque(true);
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });
        add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 40, 40));

        Minimizar.setForeground(new java.awt.Color(255, 255, 255));
        Minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosSCE/minus-symbol.png"))); // NOI18N
        add(Minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, -1, -1));

        btn_Compras.setBackground(new java.awt.Color(0, 0, 0));
        btn_Compras.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btn_Compras.setForeground(new java.awt.Color(255, 255, 255));
        btn_Compras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Compras.setText("COMPRAS");
        btn_Compras.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_Compras.setName(""); // NOI18N
        btn_Compras.setOpaque(true);
        btn_Compras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ComprasMouseClicked(evt);
            }
        });
        add(btn_Compras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 160, 50));

        btn_Proveedores.setBackground(new java.awt.Color(0, 0, 0));
        btn_Proveedores.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btn_Proveedores.setForeground(new java.awt.Color(255, 255, 255));
        btn_Proveedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Proveedores.setText("PROVEEDORES");
        btn_Proveedores.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_Proveedores.setName(""); // NOI18N
        btn_Proveedores.setOpaque(true);
        btn_Proveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ProveedoresMouseClicked(evt);
            }
        });
        add(btn_Proveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, -10, 160, 50));

        btn_Reportes.setBackground(new java.awt.Color(0, 0, 0));
        btn_Reportes.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btn_Reportes.setForeground(new java.awt.Color(255, 255, 255));
        btn_Reportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Reportes.setText("REPORTES");
        btn_Reportes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_Reportes.setName(""); // NOI18N
        btn_Reportes.setOpaque(true);
        btn_Reportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ReportesMouseClicked(evt);
            }
        });
        add(btn_Reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, -10, 160, 50));

        btn_Pagos.setBackground(new java.awt.Color(0, 0, 0));
        btn_Pagos.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btn_Pagos.setForeground(new java.awt.Color(255, 255, 255));
        btn_Pagos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Pagos.setText("PAGOS");
        btn_Pagos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_Pagos.setName(""); // NOI18N
        btn_Pagos.setOpaque(true);
        btn_Pagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_PagosMouseClicked(evt);
            }
        });
        add(btn_Pagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, -10, 160, 50));

        panel_Contenido.setBackground(new java.awt.Color(0, 0, 0));
        panel_Contenido.setName(""); // NOI18N

        javax.swing.GroupLayout panel_ContenidoLayout = new javax.swing.GroupLayout(panel_Contenido);
        panel_Contenido.setLayout(panel_ContenidoLayout);
        panel_ContenidoLayout.setHorizontalGroup(
            panel_ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
        );
        panel_ContenidoLayout.setVerticalGroup(
            panel_ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        add(panel_Contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 940, 650));
    }// </editor-fold>//GEN-END:initComponents

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_SalirMouseClicked
    private JPanel panelPedido;
    public void inicializarPedido(){
        panelPedido = new Pedidos();
        panelPedido.setLocation(0, 0);
        panelPedido.setSize(panel_Contenido.getSize());
        panel_Contenido.removeAll();
        panel_Contenido.add(panelPedido, BorderLayout.CENTER);
        panel_Contenido.revalidate();
        panel_Contenido.repaint();
    }
    private void btn_ComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ComprasMouseClicked
        setBoton(btn_Compras);
        resetBoton(btn_Pagos);
        resetBoton(btn_Proveedores);
        resetBoton(btn_Reportes);
        //inicializarPedido();
        panelPedido.setLocation(0, 0);
        panelPedido.setSize(panel_Contenido.getSize());
        panel_Contenido.removeAll();
        panel_Contenido.add(panelPedido, BorderLayout.CENTER);
        panel_Contenido.revalidate();
        panel_Contenido.repaint();
    }//GEN-LAST:event_btn_ComprasMouseClicked

    private void btn_ProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ProveedoresMouseClicked
        resetBoton(btn_Compras);
        resetBoton(btn_Pagos);
        setBoton(btn_Proveedores);
        resetBoton(btn_Reportes);
        JPanel j = new Proveedores();
        j.setLocation(0, 0);
        j.setSize(panel_Contenido.getSize());
        panel_Contenido.removeAll();
        panel_Contenido.add(j, BorderLayout.CENTER);
        panel_Contenido.revalidate();
        panel_Contenido.repaint();
    }//GEN-LAST:event_btn_ProveedoresMouseClicked

    private void btn_PagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_PagosMouseClicked
        resetBoton(btn_Compras);
        setBoton(btn_Pagos);
        resetBoton(btn_Proveedores);
        resetBoton(btn_Reportes);
    }//GEN-LAST:event_btn_PagosMouseClicked

    private void btn_ReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ReportesMouseClicked
        resetBoton(btn_Compras);
        resetBoton(btn_Pagos);
        resetBoton(btn_Proveedores);
        setBoton(btn_Reportes);
    }//GEN-LAST:event_btn_ReportesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Minimizar;
    private javax.swing.JLabel Salir;
    private javax.swing.JLabel btn_Compras;
    private javax.swing.JLabel btn_Pagos;
    private javax.swing.JLabel btn_Proveedores;
    private javax.swing.JLabel btn_Reportes;
    public static javax.swing.JPanel panel_Contenido;
    // End of variables declaration//GEN-END:variables
}
