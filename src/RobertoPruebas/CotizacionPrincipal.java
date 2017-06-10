/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RobertoPruebas;

import java.awt.Dimension;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Roberto
 */
public class CotizacionPrincipal extends javax.swing.JPanel {
    private int cotizacionesActivas=0;
    private boolean nuevo=false, cliente=false;
    private Conexion conexion=new Conexion();
    /**
     * Creates new form CotizacionPrincipal
     * @param conexion
     */
    public CotizacionPrincipal(Conexion conexion) {
        initComponents();
        this.conexion=conexion;
        cambiarModo();
        cambiarCampos();
    }
    public void cambiarModo()
    {
        btn_añadirCliente.setVisible(nuevo);
        btn_buscarCliente.setVisible(nuevo);
        btn_guardar.setVisible(nuevo);
        btn_cancelar.setVisible(nuevo);
        btn_buscar.setVisible(!nuevo);
        txt_nit.setVisible(cliente);
        lbl_nit.setVisible(cliente);
    }
    public void cambiarCampos(){
        txt_nombre.setEnabled(nuevo);
        txt_nombre.setText("");
        txt_nit.setText("");
        txt_numero.setText("");
    }
    public void añadir_panel(int idCotizacion){
        PANEL p=new PANEL();
            p.setSize(250,100);
            p.setLocation(0,100*cotizacionesActivas);
            scp_listado.add(p);
            pn_cotizaciones.add(p);
            pn_cotizaciones.setPreferredSize(new Dimension(pn_cotizaciones.getWidth(),cotizacionesActivas*100));
            scp_cotizaciones.revalidate();
            scp_cotizaciones.repaint();
            scp_listado.revalidate();
            scp_listado.repaint();
            cotizacionesActivas++;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnContenido = new javax.swing.JPanel();
        scp_listado = new javax.swing.JScrollPane();
        pnDetalle = new javax.swing.JPanel();
        lbl_Titulo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        lbl_numero = new javax.swing.JLabel();
        txt_numero = new javax.swing.JTextField();
        lbl_nombre = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        lbl_nit = new javax.swing.JLabel();
        txt_nit = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JLabel();
        scp_cotizaciones = new javax.swing.JScrollPane();
        pn_cotizaciones = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        lbl_Titulo1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pn_herramientas = new javax.swing.JPanel();
        Salir1 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JLabel();
        btn_añadirCliente = new javax.swing.JLabel();
        btn_buscarCliente = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        pnContenido.setBackground(new java.awt.Color(0, 0, 0));
        pnContenido.setMinimumSize(new java.awt.Dimension(150, 150));
        pnContenido.setPreferredSize(new java.awt.Dimension(902, 648));

        scp_listado.setBorder(null);
        scp_listado.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scp_listado.setAutoscrolls(true);
        scp_listado.setPreferredSize(new java.awt.Dimension(292, 615));

        pnDetalle.setBackground(new java.awt.Color(0, 0, 0));
        pnDetalle.setForeground(new java.awt.Color(255, 255, 255));
        pnDetalle.setAlignmentX(0.0F);
        pnDetalle.setAlignmentY(0.0F);
        pnDetalle.setMaximumSize(new java.awt.Dimension(150, 150));
        pnDetalle.setMinimumSize(new java.awt.Dimension(150, 150));
        pnDetalle.setPreferredSize(new java.awt.Dimension(900, 650));

        lbl_Titulo.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        lbl_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Titulo.setText("COTIZACIONES");

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPane2.setViewportView(jPanel3);

        lbl_numero.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_numero.setForeground(new java.awt.Color(255, 255, 255));
        lbl_numero.setText("Número");
        lbl_numero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_numeroMouseClicked(evt);
            }
        });

        txt_numero.setBackground(new java.awt.Color(0, 0, 0));
        txt_numero.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_numero.setForeground(new java.awt.Color(255, 255, 255));
        txt_numero.setBorder(null);
        txt_numero.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_numero.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txt_numero.setEnabled(false);
        txt_numero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_numeroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_numeroFocusLost(evt);
            }
        });
        txt_numero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_numeroMousePressed(evt);
            }
        });
        txt_numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numeroActionPerformed(evt);
            }
        });

        lbl_nombre.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_nombre.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nombre.setText("Nombre");
        lbl_nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_nombreMouseClicked(evt);
            }
        });

        txt_nombre.setBackground(new java.awt.Color(0, 0, 0));
        txt_nombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setBorder(null);
        txt_nombre.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_nombre.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txt_nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_nombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_nombreFocusLost(evt);
            }
        });
        txt_nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_nombreMousePressed(evt);
            }
        });
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });

        lbl_nit.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_nit.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nit.setText("NIT");
        lbl_nit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_nitMouseClicked(evt);
            }
        });

        txt_nit.setBackground(new java.awt.Color(0, 0, 0));
        txt_nit.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_nit.setForeground(new java.awt.Color(255, 255, 255));
        txt_nit.setBorder(null);
        txt_nit.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_nit.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txt_nit.setEnabled(false);
        txt_nit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_nitFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_nitFocusLost(evt);
            }
        });
        txt_nit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_nitMousePressed(evt);
            }
        });
        txt_nit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nitActionPerformed(evt);
            }
        });

        btn_guardar.setBackground(new java.awt.Color(255, 0, 0));
        btn_guardar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btn_guardar.setForeground(new java.awt.Color(255, 255, 255));
        btn_guardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_guardar.setText("GUARDAR");
        btn_guardar.setOpaque(true);
        btn_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_guardarMouseClicked(evt);
            }
        });

        btn_cancelar.setBackground(new java.awt.Color(255, 0, 0));
        btn_cancelar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.setOpaque(true);
        btn_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancelarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnDetalleLayout = new javax.swing.GroupLayout(pnDetalle);
        pnDetalle.setLayout(pnDetalleLayout);
        pnDetalleLayout.setHorizontalGroup(
            pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(pnDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetalleLayout.createSequentialGroup()
                        .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_nombre)
                            .addComponent(lbl_numero))
                        .addGap(21, 26, Short.MAX_VALUE)
                        .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDetalleLayout.createSequentialGroup()
                                .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(lbl_nit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_nit, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86))
                            .addComponent(txt_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)))
                    .addGroup(pnDetalleLayout.createSequentialGroup()
                        .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_Titulo)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnDetalleLayout.createSequentialGroup()
                                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnDetalleLayout.setVerticalGroup(
            pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetalleLayout.createSequentialGroup()
                .addComponent(lbl_Titulo)
                .addGap(9, 9, 9)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_numero)
                    .addGroup(pnDetalleLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_nit)
                            .addGroup(pnDetalleLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txt_nit, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_nombre)
                    .addGroup(pnDetalleLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        scp_cotizaciones.setAutoscrolls(true);
        scp_cotizaciones.setPreferredSize(new java.awt.Dimension(273, 448));
        scp_cotizaciones.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                scp_cotizacionesAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        pn_cotizaciones.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout pn_cotizacionesLayout = new javax.swing.GroupLayout(pn_cotizaciones);
        pn_cotizaciones.setLayout(pn_cotizacionesLayout);
        pn_cotizacionesLayout.setHorizontalGroup(
            pn_cotizacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 271, Short.MAX_VALUE)
        );
        pn_cotizacionesLayout.setVerticalGroup(
            pn_cotizacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        scp_cotizaciones.setViewportView(pn_cotizaciones);

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        lbl_Titulo1.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        lbl_Titulo1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Titulo1.setText("EN USO");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosSCE/Modelo Añadir3.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setPreferredSize(new java.awt.Dimension(48, 48));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnContenidoLayout = new javax.swing.GroupLayout(pnContenido);
        pnContenido.setLayout(pnContenidoLayout);
        pnContenidoLayout.setHorizontalGroup(
            pnContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addGroup(pnContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scp_listado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scp_cotizaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnContenidoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Titulo1)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
        );
        pnContenidoLayout.setVerticalGroup(
            pnContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContenidoLayout.createSequentialGroup()
                .addComponent(scp_listado, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                    .addGroup(pnContenidoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addGroup(pnContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnContenidoLayout.createSequentialGroup()
                                .addComponent(lbl_Titulo1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scp_cotizaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );

        pn_herramientas.setBackground(new java.awt.Color(0, 0, 0));
        pn_herramientas.setPreferredSize(new java.awt.Dimension(868, 40));

        Salir1.setBackground(new java.awt.Color(0, 0, 0));
        Salir1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Salir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosSCE/cancel (2).png"))); // NOI18N
        Salir1.setOpaque(true);
        Salir1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Salir1MouseClicked(evt);
            }
        });

        btn_buscar.setBackground(new java.awt.Color(0, 0, 0));
        btn_buscar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_buscar.setText("BUSCAR");
        btn_buscar.setName(""); // NOI18N
        btn_buscar.setOpaque(true);
        btn_buscar.setPreferredSize(new java.awt.Dimension(93, 40));
        btn_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_buscarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_buscarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_buscarMouseReleased(evt);
            }
        });

        btn_añadirCliente.setBackground(new java.awt.Color(0, 0, 0));
        btn_añadirCliente.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btn_añadirCliente.setForeground(new java.awt.Color(255, 255, 255));
        btn_añadirCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_añadirCliente.setText("AÑADIR CLIENTE");
        btn_añadirCliente.setName(""); // NOI18N
        btn_añadirCliente.setOpaque(true);
        btn_añadirCliente.setPreferredSize(new java.awt.Dimension(93, 40));
        btn_añadirCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_añadirClienteMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_añadirClienteMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_añadirClienteMouseReleased(evt);
            }
        });

        btn_buscarCliente.setBackground(new java.awt.Color(0, 0, 0));
        btn_buscarCliente.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btn_buscarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscarCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_buscarCliente.setText("BUSCAR CLIENTE");
        btn_buscarCliente.setName(""); // NOI18N
        btn_buscarCliente.setOpaque(true);
        btn_buscarCliente.setPreferredSize(new java.awt.Dimension(93, 40));
        btn_buscarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_buscarClienteMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_buscarClienteMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_buscarClienteMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout pn_herramientasLayout = new javax.swing.GroupLayout(pn_herramientas);
        pn_herramientas.setLayout(pn_herramientasLayout);
        pn_herramientasLayout.setHorizontalGroup(
            pn_herramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_herramientasLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_añadirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_buscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Salir1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pn_herramientasLayout.setVerticalGroup(
            pn_herramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_herramientasLayout.createSequentialGroup()
                .addGroup(pn_herramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_herramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_añadirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_buscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Salir1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 952, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(pnContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(pn_herramientas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE))
                    .addGap(1, 1, 1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(pn_herramientas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(pnContenido, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                    .addGap(1, 1, 1)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Salir1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Salir1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_Salir1MouseClicked

    private void btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_buscarMouseClicked

    private void btn_buscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_buscarMousePressed

    private void btn_buscarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_buscarMouseReleased

    private void lbl_numeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_numeroMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_lbl_numeroMouseClicked

    private void txt_numeroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_numeroFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numeroFocusGained

    private void txt_numeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_numeroFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numeroFocusLost

    private void txt_numeroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_numeroMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numeroMousePressed

    private void txt_numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numeroActionPerformed

    private void lbl_nombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_nombreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_nombreMouseClicked

    private void txt_nombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nombreFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreFocusGained

    private void txt_nombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nombreFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreFocusLost

    private void txt_nombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nombreMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreMousePressed

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void lbl_nitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_nitMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_nitMouseClicked

    private void txt_nitFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nitFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nitFocusGained

    private void txt_nitFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nitFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nitFocusLost

    private void txt_nitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nitMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nitMousePressed

    private void txt_nitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nitActionPerformed

    private void scp_cotizacionesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_scp_cotizacionesAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_scp_cotizacionesAncestorAdded

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        if(!nuevo)
        {
            nuevo=true;
            txt_nombre.setEnabled(true);
            cambiarModo();
            cambiarCampos();
            //añadir_panel(0);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btn_añadirClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_añadirClienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_añadirClienteMouseClicked

    private void btn_añadirClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_añadirClienteMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_añadirClienteMousePressed

    private void btn_añadirClienteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_añadirClienteMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_añadirClienteMouseReleased

    private void btn_buscarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarClienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_buscarClienteMouseClicked

    private void btn_buscarClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarClienteMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_buscarClienteMousePressed

    private void btn_buscarClienteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarClienteMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_buscarClienteMouseReleased

    private void btn_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guardarMouseClicked
        try {
            // TODO add your handling code here:
            conexion.insertarCotizacion(0,txt_nombre.getText(),1);
            nuevo=false;
            cliente=false;
            cambiarModo();
            cambiarCampos();
            añadir_panel(0);
        } catch (SQLException ex) {
            Logger.getLogger(CotizacionPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_guardarMouseClicked

    private void btn_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelarMouseClicked
        // TODO add your handling code here:
           if(nuevo)
        {
            DialogoOpcion d=new DialogoOpcion(null,true,DialogoOpcion.ICONO_INTERROGANTE,"Nueva Cotizacion","¿Desea cancelar la creación?");
            d.setVisible(true);
            if(d.isAceptar())
            {
                nuevo=false;
                cambiarModo();
                cambiarCampos();
            }
        }
    }//GEN-LAST:event_btn_cancelarMouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Salir1;
    private javax.swing.JLabel btn_añadirCliente;
    private javax.swing.JLabel btn_buscar;
    private javax.swing.JLabel btn_buscarCliente;
    private javax.swing.JLabel btn_cancelar;
    private javax.swing.JLabel btn_guardar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JLabel lbl_Titulo1;
    private javax.swing.JLabel lbl_nit;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_numero;
    public static javax.swing.JPanel pnContenido;
    public static javax.swing.JPanel pnDetalle;
    private javax.swing.JPanel pn_cotizaciones;
    private javax.swing.JPanel pn_herramientas;
    private javax.swing.JScrollPane scp_cotizaciones;
    public static javax.swing.JScrollPane scp_listado;
    private javax.swing.JTextField txt_nit;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_numero;
    // End of variables declaration//GEN-END:variables
}
