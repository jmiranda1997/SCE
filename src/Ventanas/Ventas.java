/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import RobertoPruebas.consultaFactura;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author jonathan Miranda
 */
public class Ventas extends javax.swing.JPanel {

    /**
     * Creates new form Ventas
     */
    private  Factura panel_Factura;
    private consultaFactura consulta;
    public Ventas() {
        initComponents();
        panel_Factura = new Factura();
        consulta=new consultaFactura();
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

        panel_Contenido = new javax.swing.JPanel();
        Minimizar = new javax.swing.JLabel();
        btn_Consulta = new javax.swing.JLabel();
        Salir = new javax.swing.JLabel();
        btn_Pagos = new javax.swing.JLabel();
        btn_Facturaccion = new javax.swing.JLabel();
        btn_Reportes = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        add(panel_Contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 940, 650));

        Minimizar.setForeground(new java.awt.Color(255, 255, 255));
        Minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosSCE/minus-symbol.png"))); // NOI18N
        add(Minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, -1, -1));

        btn_Consulta.setBackground(new java.awt.Color(0, 0, 0));
        btn_Consulta.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btn_Consulta.setForeground(new java.awt.Color(255, 255, 255));
        btn_Consulta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Consulta.setText("CONSULTA");
        btn_Consulta.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_Consulta.setName(""); // NOI18N
        btn_Consulta.setOpaque(true);
        btn_Consulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ConsultaMouseClicked(evt);
            }
        });
        add(btn_Consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, -10, 160, 50));

        Salir.setBackground(new java.awt.Color(0, 0, 0));
        Salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosSCE/cancel (2).png"))); // NOI18N
        Salir.setOpaque(true);
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });
        add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 40, 40));

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
        add(btn_Pagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, -10, 160, 50));

        btn_Facturaccion.setBackground(new java.awt.Color(0, 0, 0));
        btn_Facturaccion.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btn_Facturaccion.setForeground(new java.awt.Color(255, 255, 255));
        btn_Facturaccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Facturaccion.setText("FACTURACION");
        btn_Facturaccion.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_Facturaccion.setName(""); // NOI18N
        btn_Facturaccion.setOpaque(true);
        btn_Facturaccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_FacturaccionMouseClicked(evt);
            }
        });
        add(btn_Facturaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 160, 50));

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
        add(btn_Reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, -10, 160, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ReportesMouseClicked
        resetBoton(btn_Facturaccion);
        resetBoton(btn_Pagos);
        resetBoton(btn_Consulta);
        setBoton(btn_Reportes);
    }//GEN-LAST:event_btn_ReportesMouseClicked

    private void btn_PagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_PagosMouseClicked
        resetBoton(btn_Facturaccion);
        setBoton(btn_Pagos);
        resetBoton(btn_Consulta);
        resetBoton(btn_Reportes);
    }//GEN-LAST:event_btn_PagosMouseClicked

    private void btn_ConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ConsultaMouseClicked
        resetBoton(btn_Facturaccion);
        resetBoton(btn_Pagos);
        setBoton(btn_Consulta);
        resetBoton(btn_Reportes);
        consulta.setLocation(0, 0);
        consulta.setSize(panel_Contenido.getSize());
        panel_Contenido.removeAll();
        panel_Contenido.add(consulta, BorderLayout.CENTER);
        panel_Contenido.revalidate();
        panel_Contenido.repaint();
    }//GEN-LAST:event_btn_ConsultaMouseClicked
    
    private void btn_FacturaccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_FacturaccionMouseClicked
        setBoton(btn_Facturaccion);
        resetBoton(btn_Pagos);
        resetBoton(btn_Consulta);
        resetBoton(btn_Reportes);
        panel_Factura.setLocation(0, 0);
        panel_Factura.setSize(panel_Contenido.getSize());
        panel_Contenido.removeAll();
        panel_Contenido.add(panel_Factura, BorderLayout.CENTER);
        panel_Contenido.revalidate();
        panel_Contenido.repaint();
       
    }//GEN-LAST:event_btn_FacturaccionMouseClicked

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_SalirMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Minimizar;
    private javax.swing.JLabel Salir;
    private javax.swing.JLabel btn_Consulta;
    private javax.swing.JLabel btn_Facturaccion;
    private javax.swing.JLabel btn_Pagos;
    private javax.swing.JLabel btn_Reportes;
    public static javax.swing.JPanel panel_Contenido;
    // End of variables declaration//GEN-END:variables
}
