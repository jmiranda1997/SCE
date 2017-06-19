/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RobertoPruebas;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Roberto
 */
public class Financiero extends javax.swing.JPanel {
    private Conexion conexion;
    /**
     * Creates new form Financiero
     */
    public Financiero(Conexion conexion) {
        initComponents();
        this.conexion=conexion;
    }
    public void desactivarBotonoes(JLabel exclusion)
    {
        exclusion.setBackground(Color.red);
        if(btn_empleados!=exclusion)
            btn_empleados.setBackground(Color.black);
        if(btn_planilla!=exclusion)
            btn_planilla.setBackground(Color.black);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_contenido = new javax.swing.JPanel();
        btn_planilla = new javax.swing.JLabel();
        btn_empleados = new javax.swing.JLabel();
        Salir = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        pn_contenido.setBackground(new java.awt.Color(0, 0, 0));
        pn_contenido.setPreferredSize(new java.awt.Dimension(930, 650));

        javax.swing.GroupLayout pn_contenidoLayout = new javax.swing.GroupLayout(pn_contenido);
        pn_contenido.setLayout(pn_contenidoLayout);
        pn_contenidoLayout.setHorizontalGroup(
            pn_contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pn_contenidoLayout.setVerticalGroup(
            pn_contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        btn_planilla.setBackground(new java.awt.Color(0, 0, 0));
        btn_planilla.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btn_planilla.setForeground(new java.awt.Color(255, 255, 255));
        btn_planilla.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_planilla.setText("PLANILLA");
        btn_planilla.setName(""); // NOI18N
        btn_planilla.setOpaque(true);
        btn_planilla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_planillaMouseClicked(evt);
            }
        });

        btn_empleados.setBackground(new java.awt.Color(0, 0, 0));
        btn_empleados.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btn_empleados.setForeground(new java.awt.Color(255, 255, 255));
        btn_empleados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_empleados.setText("EMPLEADOS");
        btn_empleados.setName(""); // NOI18N
        btn_empleados.setOpaque(true);
        btn_empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_empleadosMouseClicked(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_contenido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_planilla, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_empleados, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 576, Short.MAX_VALUE)
                        .addComponent(Salir)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_planilla, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_empleados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Salir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(pn_contenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_planillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_planillaMouseClicked
        desactivarBotonoes(btn_planilla);
        Planilla planilla= new Planilla(conexion);
        planilla.setLocation(0,0);
        planilla.setSize(pn_contenido.getSize());
        pn_contenido.removeAll();
        pn_contenido.add(planilla,BorderLayout.CENTER);
        pn_contenido.revalidate();
        pn_contenido.repaint();
    }//GEN-LAST:event_btn_planillaMouseClicked

    private void btn_empleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_empleadosMouseClicked
        desactivarBotonoes(btn_empleados);
        DeudasTrabajador deudas= new DeudasTrabajador(conexion);
        deudas.setLocation(0,0);
        deudas.setSize(pn_contenido.getSize());
        pn_contenido.removeAll();
        pn_contenido.add(deudas,BorderLayout.CENTER);
        pn_contenido.revalidate();
        pn_contenido.repaint();
    }//GEN-LAST:event_btn_empleadosMouseClicked

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_SalirMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Salir;
    private javax.swing.JLabel btn_empleados;
    private javax.swing.JLabel btn_planilla;
    private javax.swing.JPanel pn_contenido;
    // End of variables declaration//GEN-END:variables
}