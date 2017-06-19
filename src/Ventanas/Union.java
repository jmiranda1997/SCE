/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import RobertoPruebas.*;
import static Ventanas.Principal.jPanel2;
import java.awt.BorderLayout;
import java.awt.Color;

/**
 *
 * @author Juampa
 */
public class Union extends javax.swing.JPanel {
    Conexion conexion;
    Trabajadores trabajadores;
    Planilla planilla;
    Ausencias ausencias;
    DeudasTrabajador deudas;
    /**
     * Creates new form Union
     */
    public Union() {
        initComponents();
    }
    public Union(Conexion conexion){
        initComponents();
        this.conexion=conexion;
    }
    public void limpiar(){
        manejoButton.setBackground(Color.BLACK);
        deudasButton.setBackground(Color.BLACK);
        ausenciasButton.setBackground(Color.BLACK);
        planillaButton.setBackground(Color.BLACK);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        manejoButton = new javax.swing.JLabel();
        deudasButton = new javax.swing.JLabel();
        planillaButton = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        ausenciasButton = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        manejoButton.setBackground(new java.awt.Color(0, 0, 0));
        manejoButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        manejoButton.setForeground(new java.awt.Color(255, 255, 255));
        manejoButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        manejoButton.setText("MANEJO");
        manejoButton.setName(""); // NOI18N
        manejoButton.setOpaque(true);
        manejoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manejoButtonMouseClicked(evt);
            }
        });

        deudasButton.setBackground(new java.awt.Color(0, 0, 0));
        deudasButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        deudasButton.setForeground(new java.awt.Color(255, 255, 255));
        deudasButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deudasButton.setText("DEUDAS");
        deudasButton.setName(""); // NOI18N
        deudasButton.setOpaque(true);
        deudasButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deudasButtonMouseClicked(evt);
            }
        });

        planillaButton.setBackground(new java.awt.Color(0, 0, 0));
        planillaButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        planillaButton.setForeground(new java.awt.Color(255, 255, 255));
        planillaButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        planillaButton.setText("PLANILLA");
        planillaButton.setName(""); // NOI18N
        planillaButton.setOpaque(true);
        planillaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                planillaButtonMouseClicked(evt);
            }
        });

        panel.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );

        ausenciasButton.setBackground(new java.awt.Color(0, 0, 0));
        ausenciasButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        ausenciasButton.setForeground(new java.awt.Color(255, 255, 255));
        ausenciasButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ausenciasButton.setText("AUSENCIAS");
        ausenciasButton.setName(""); // NOI18N
        ausenciasButton.setOpaque(true);
        ausenciasButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ausenciasButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manejoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deudasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(planillaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ausenciasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(planillaButton)
                    .addComponent(deudasButton)
                    .addComponent(manejoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ausenciasButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manejoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manejoButtonMouseClicked
        limpiar();
        manejoButton.setBackground(Color.RED);
        //if(trabajadores==null)
            trabajadores=new Trabajadores(conexion);
        trabajadores.setLocation(0,0);
        trabajadores.setSize(panel.getSize());
        panel.removeAll();
        panel.add(trabajadores,BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }//GEN-LAST:event_manejoButtonMouseClicked

    private void deudasButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deudasButtonMouseClicked
        limpiar();
        deudasButton.setBackground(Color.RED);
        //if(deudas==null)
            deudas=new DeudasTrabajador(conexion);
        deudas.setLocation(0,0);
        deudas.setSize(panel.getSize());
        panel.removeAll();
        panel.add(deudas,BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }//GEN-LAST:event_deudasButtonMouseClicked

    private void planillaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_planillaButtonMouseClicked
        limpiar();
        planillaButton.setBackground(Color.RED);
        //if(planilla==null)
            planilla=new Planilla(conexion);
        planilla.setLocation(0,0);
        planilla.setSize(panel.getSize());
        panel.removeAll();
        panel.add(planilla,BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }//GEN-LAST:event_planillaButtonMouseClicked

    private void ausenciasButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ausenciasButtonMouseClicked
        limpiar();
        ausenciasButton.setBackground(Color.RED);
        //if(ausencias==null)
            ausencias=new Ausencias(conexion);
        ausencias.setLocation(0,0);
        ausencias.setSize(panel.getSize());
        panel.removeAll();
        panel.add(ausencias,BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }//GEN-LAST:event_ausenciasButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ausenciasButton;
    private javax.swing.JLabel deudasButton;
    private javax.swing.JLabel manejoButton;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel planillaButton;
    // End of variables declaration//GEN-END:variables
}
