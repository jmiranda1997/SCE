/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Excepciones.NoSePuedeEscribirArchivo;
import JP.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

/**
 *
 * @author juampa
 */
public class Seguridad extends javax.swing.JPanel {
    public final static String marcaInicio="SCE";
    public final static String claveCifrado = "Sistema de Control Empresarial";
    /**
     * Creates new form Seguridad
     */
    public Seguridad() {
        initComponents();  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ipField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        bdField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        guardarDBButton = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        passField = new javax.swing.JPasswordField();

        setPreferredSize(new java.awt.Dimension(940, 650));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel1.setText("Dirección del servidor:");

        ipField.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel2.setText("Contraseña:");

        bdField.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel3.setText("Nombre de la BD:");

        guardarDBButton.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        guardarDBButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guardarDBButton.setText("Guardar");
        guardarDBButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guardarDBButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarDBButtonMouseClicked(evt);
            }
        });

        userField.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel4.setText("Usuario del SGBD:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(guardarDBButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userField)
                            .addComponent(bdField, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(ipField)
                            .addComponent(passField))))
                .addContainerGap(690, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(guardarDBButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(494, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void guardarDBButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarDBButtonMouseClicked
        if(!ipField.getText().equals("")&&!userField.getText().equals("")&&passField.getPassword()!=null&!bdField.getText().equals("")){
            try {
                // Generamos una clave que queramos que tenga al menos 16 bytes adecuada para AES
                Key key = new SecretKeySpec(claveCifrado.getBytes(),  0, 16, "AES");
                // Se obtiene un cifrador AES
                Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
                // Se inicializa el cifrador, se pone en modo de cifrado y se le envia la clave
                aes.init(Cipher.ENCRYPT_MODE,key);
                // Se encripta
                byte[] encriptado=aes.doFinal(new String(passField.getPassword()).getBytes());
                //Se crea un nuevo servidor, enviando los datos nuevos y se escribe la configuracion al archivo
                Server server=new Server(ipField.getText(), userField.getText(),encriptado , bdField.getText());
                server.escribirArchivo(Server.SERVER_CONFIG_DEFAULT_FILE);
                JOptionPane.showMessageDialog(null, "Archivo Escrito","Escritura exitosa", JOptionPane.INFORMATION_MESSAGE);
            } catch (NoSePuedeEscribirArchivo | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos","Error",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_guardarDBButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bdField;
    private javax.swing.JLabel guardarDBButton;
    private javax.swing.JTextField ipField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField passField;
    private javax.swing.JTextField userField;
    // End of variables declaration//GEN-END:variables
}
