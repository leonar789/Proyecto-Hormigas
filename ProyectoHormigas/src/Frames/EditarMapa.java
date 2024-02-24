/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frames;

import static Frames.PrincipalFrame.vista_grafo;
import static Frames.PrincipalFrame.visualizador;
import estructuras.App;
import java.awt.CardLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Leonardo
 */
public class EditarMapa extends javax.swing.JPanel {

    /**
     * Creates new form Iniciar_Simulacion
     */
    static CardLayout vista_f;
    public EditarMapa() {
        initComponents();
        this.actualizarComboboxCiudades();
    }
    public void actualizarComboboxCiudades(){
        String[] arregloCiudades=App.grafo.getVertices().ciudadesToArray();
        String[] arregloAristas=App.grafo.getTodasAristas().aristasToArray();
        cBoxCiudadesAgregar.setModel(new DefaultComboBoxModel <>(arregloCiudades));
        cBoxInicio.setModel(new DefaultComboBoxModel <>(arregloCiudades));
        cBoxMeta.setModel(new DefaultComboBoxModel <>(arregloCiudades));
        cBoxPrimeraCiudad.setModel(new DefaultComboBoxModel <>(arregloCiudades));
        cBoxSegundaCiudad.setModel(new DefaultComboBoxModel <>(arregloCiudades));
        cBoxEliminarCiudad.setModel(new DefaultComboBoxModel <>(arregloCiudades));
        cBoxEliminarCamino.setModel(new DefaultComboBoxModel <>(arregloAristas));
        
    }
    public void actualizarMiniGrafo(){
        App.cargarVisualizador();
        visualizador.add(App.verGrafo(),"vista_pequeña");
        vista_grafo.show(visualizador, "vista_pequeña");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
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
        jLabel2 = new javax.swing.JLabel();
        distanciaNueva = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cBoxCiudadesAgregar = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cBoxPrimeraCiudad = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        distanciaUnir = new javax.swing.JTextField();
        cBoxEliminarCamino = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        unir = new javax.swing.JButton();
        agregarCiudad = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        cBoxEliminarCiudad = new javax.swing.JComboBox<>();
        cBoxSegundaCiudad = new javax.swing.JComboBox<>();
        eliminarCiudad = new javax.swing.JButton();
        eliminarCamino = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        cBoxInicio = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cBoxMeta = new javax.swing.JComboBox<>();
        definir = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Unir con");

        distanciaNueva.setBackground(new java.awt.Color(204, 204, 204));
        distanciaNueva.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        distanciaNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanciaNuevaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Agregar Ciudad");

        jLabel11.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Unir Ciudades");

        cBoxCiudadesAgregar.setBackground(new java.awt.Color(204, 204, 204));
        cBoxCiudadesAgregar.setForeground(new java.awt.Color(0, 0, 0));
        cBoxCiudadesAgregar.setMaximumRowCount(111);

        jLabel13.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Distancia");

        jLabel14.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Primera Ciudad");

        cBoxPrimeraCiudad.setBackground(new java.awt.Color(204, 204, 204));
        cBoxPrimeraCiudad.setForeground(new java.awt.Color(0, 0, 0));
        cBoxPrimeraCiudad.setMaximumRowCount(111);

        jLabel15.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Distancia");

        distanciaUnir.setBackground(new java.awt.Color(204, 204, 204));
        distanciaUnir.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        distanciaUnir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanciaUnirActionPerformed(evt);
            }
        });

        cBoxEliminarCamino.setBackground(new java.awt.Color(204, 204, 204));
        cBoxEliminarCamino.setForeground(new java.awt.Color(0, 0, 0));
        cBoxEliminarCamino.setMaximumRowCount(111);

        jLabel16.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Segunda Ciudad");

        unir.setBackground(new java.awt.Color(153, 153, 153));
        unir.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        unir.setForeground(new java.awt.Color(255, 255, 255));
        unir.setText("Unir");
        unir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unirActionPerformed(evt);
            }
        });

        agregarCiudad.setBackground(new java.awt.Color(153, 153, 153));
        agregarCiudad.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        agregarCiudad.setForeground(new java.awt.Color(255, 255, 255));
        agregarCiudad.setText("Agregar");
        agregarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCiudadActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Eliminar");

        cBoxEliminarCiudad.setBackground(new java.awt.Color(204, 204, 204));
        cBoxEliminarCiudad.setForeground(new java.awt.Color(0, 0, 0));
        cBoxEliminarCiudad.setMaximumRowCount(111);

        cBoxSegundaCiudad.setBackground(new java.awt.Color(204, 204, 204));
        cBoxSegundaCiudad.setForeground(new java.awt.Color(0, 0, 0));
        cBoxSegundaCiudad.setMaximumRowCount(111);

        eliminarCiudad.setBackground(new java.awt.Color(153, 153, 153));
        eliminarCiudad.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        eliminarCiudad.setForeground(new java.awt.Color(255, 255, 255));
        eliminarCiudad.setText("Eliminar Ciudad");
        eliminarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarCiudadActionPerformed(evt);
            }
        });

        eliminarCamino.setBackground(new java.awt.Color(153, 153, 153));
        eliminarCamino.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        eliminarCamino.setForeground(new java.awt.Color(255, 255, 255));
        eliminarCamino.setText("Eliminar Camino");
        eliminarCamino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarCaminoActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Definir Recorrido");
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cBoxInicio.setBackground(new java.awt.Color(204, 204, 204));
        cBoxInicio.setForeground(new java.awt.Color(0, 0, 0));
        cBoxInicio.setMaximumRowCount(111);

        jLabel19.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Inicio");

        jLabel20.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Meta");

        cBoxMeta.setBackground(new java.awt.Color(204, 204, 204));
        cBoxMeta.setForeground(new java.awt.Color(0, 0, 0));
        cBoxMeta.setMaximumRowCount(111);

        definir.setBackground(new java.awt.Color(153, 153, 153));
        definir.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        definir.setForeground(new java.awt.Color(255, 255, 255));
        definir.setText("Definir");
        definir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                definirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cBoxCiudadesAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel2))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(eliminarCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                                    .addComponent(cBoxEliminarCiudad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(145, 145, 145))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(cBoxInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(definir)
                                                .addGap(31, 31, 31)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(eliminarCamino, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                            .addComponent(cBoxMeta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cBoxEliminarCamino, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cBoxPrimeraCiudad, 0, 151, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(jLabel14)))
                                        .addGap(42, 42, 42)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(62, 62, 62)
                                                .addComponent(jLabel16))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(unir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(distanciaUnir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(distanciaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(38, 38, 38)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(agregarCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cBoxSegundaCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jLabel19)
                                .addGap(61, 61, 61)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel20)))))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(327, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(distanciaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBoxCiudadesAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarCiudad))
                .addGap(32, 32, 32)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cBoxPrimeraCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(distanciaUnir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cBoxSegundaCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(unir)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cBoxEliminarCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cBoxEliminarCamino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eliminarCiudad)
                            .addComponent(eliminarCamino))
                        .addGap(43, 43, 43)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cBoxInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cBoxMeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(definir))
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(62, 62, 62))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jLabel7)
                    .addContainerGap(506, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void distanciaNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanciaNuevaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distanciaNuevaActionPerformed

    private void distanciaUnirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanciaUnirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distanciaUnirActionPerformed

    private void definirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_definirActionPerformed
        App.setRecorrido(cBoxInicio.getSelectedIndex(), cBoxMeta.getSelectedIndex());
        this.actualizarComboboxCiudades();
        App.cargarVisualizador();
        actualizarMiniGrafo();
    }//GEN-LAST:event_definirActionPerformed

    private void agregarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCiudadActionPerformed
        
        Double distancia=Double.parseDouble(distanciaNueva.getText());
        App.agregarCiudad(cBoxCiudadesAgregar.getSelectedIndex(),distancia);
        this.actualizarComboboxCiudades();
        actualizarMiniGrafo();
       
    }//GEN-LAST:event_agregarCiudadActionPerformed

    private void unirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unirActionPerformed
        Double distancia=Double.parseDouble(distanciaUnir.getText());
        App.enlazarCiudades(cBoxPrimeraCiudad.getSelectedIndex(), cBoxSegundaCiudad.getSelectedIndex(), distancia);
        this.actualizarComboboxCiudades();
        actualizarMiniGrafo();
    }//GEN-LAST:event_unirActionPerformed

    private void eliminarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarCiudadActionPerformed
        App.eliminarCiudad(cBoxEliminarCiudad.getSelectedIndex());
        this.actualizarComboboxCiudades();
        actualizarMiniGrafo();
    }//GEN-LAST:event_eliminarCiudadActionPerformed

    private void eliminarCaminoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarCaminoActionPerformed
        App.eliminarArista(cBoxEliminarCamino.getSelectedIndex());
        this.actualizarComboboxCiudades();
        actualizarMiniGrafo();
    }//GEN-LAST:event_eliminarCaminoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarCiudad;
    private javax.swing.JComboBox<String> cBoxCiudadesAgregar;
    private javax.swing.JComboBox<String> cBoxEliminarCamino;
    private javax.swing.JComboBox<String> cBoxEliminarCiudad;
    private javax.swing.JComboBox<String> cBoxInicio;
    private javax.swing.JComboBox<String> cBoxMeta;
    private javax.swing.JComboBox<String> cBoxPrimeraCiudad;
    private javax.swing.JComboBox<String> cBoxSegundaCiudad;
    private javax.swing.JButton definir;
    private javax.swing.JTextField distanciaNueva;
    private javax.swing.JTextField distanciaUnir;
    private javax.swing.JButton eliminarCamino;
    private javax.swing.JButton eliminarCiudad;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton unir;
    // End of variables declaration//GEN-END:variables
}
