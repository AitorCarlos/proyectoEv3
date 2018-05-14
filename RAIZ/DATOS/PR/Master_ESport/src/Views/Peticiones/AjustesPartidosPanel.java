package Views.Peticiones;

import UML.Jornada;
import UML.Partido;
import UML_DB.JornadaDB;
import UML_DB.PartidoDB;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AjustesPartidosPanel extends javax.swing.JPanel {

    
    public AjustesPartidosPanel() {
        initComponents();
        cargaInicial();
    }

    public void cargaInicial(){
        try {
            ArrayList jornadas = JornadaDB.listaJornada();
            for (int i = 0; i < jornadas.size(); i++) {
                Jornada jornada = (Jornada) jornadas.get(i);
                jcbJornada.addItem(String.valueOf(jornada.getCodJornada()));
            }
             
        } catch (Exception ex){
            Logger.getLogger(AjustesPartidosPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbJornada = new javax.swing.JComboBox<>();
        jcbPartido = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfRV = new javax.swing.JTextField();
        tfRL = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jlLocal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setText("Elegir Jornada");

        jLabel2.setText("Elegir Partido");

        jcbJornada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----" }));
        jcbJornada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbJornadaItemStateChanged(evt);
            }
        });
        jcbJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbJornadaActionPerformed(evt);
            }
        });

        jcbPartido.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbPartidoItemStateChanged(evt);
            }
        });

        jLabel3.setText("Resultado Local");

        jLabel4.setText("Resultado Visitante");

        tfRV.setText("            X ");
        tfRV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRVActionPerformed(evt);
            }
        });

        tfRL.setText("           X");
        tfRL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRLActionPerformed(evt);
            }
        });

        jbGuardar.setText("GUARDAR");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jlLocal.setText("----------");

        jLabel6.setText("----------");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfRL, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(jbGuardar)
                                .addGap(96, 96, 96)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfRV, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jlLocal))
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(29, 29, 29)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(107, 107, 107))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcbPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlLocal)
                            .addComponent(jLabel6))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfRL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfRV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbGuardar))))
                .addContainerGap(236, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcbJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbJornadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbJornadaActionPerformed

    private void tfRVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRVActionPerformed

    private void tfRLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRLActionPerformed

    private void jcbJornadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbJornadaItemStateChanged
        try {
            jcbPartido.removeAllItems();
            ArrayList partidos = PartidoDB.listaPartidoPorJornada(Integer.parseInt(jcbJornada.getSelectedItem().toString()));
            for (int i = 0; i < partidos.size(); i++) {
                Partido partidoP = (Partido) partidos.get(i);
                jcbPartido.addItem(partidoP.getLocal().getNombre() + " VS "+ partidoP.getVisitante().getNombre());
            }

        } catch (Exception ex) {
            Logger.getLogger(AjustesPartidosPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcbJornadaItemStateChanged

    private void jcbPartidoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbPartidoItemStateChanged
        try {
            Jornada jornada = JornadaDB.consultarJornada(Integer.parseInt(jcbJornada.getSelectedItem().toString()));
            ArrayList partidos = PartidoDB.listaPartidoPorJornada(Integer.parseInt(jcbJornada.getSelectedItem().toString()));
            Partido partido = (Partido) partidos.get(jcbPartido.getSelectedIndex());
            jlLocal.setText(partido.getLocal().getNombre());
            jLabel6.setText(partido.getVisitante().getNombre());
                    } catch (Exception ex) {
            Logger.getLogger(AjustesPartidosPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcbPartidoItemStateChanged

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        try {
            Jornada jornada = JornadaDB.consultarJornada(Integer.parseInt(jcbJornada.getSelectedItem().toString()));
            ArrayList partidos = PartidoDB.listaPartidoPorJornada(Integer.parseInt(jcbJornada.getSelectedItem().toString()));
            Partido partido = (Partido) partidos.get(jcbPartido.getSelectedIndex());
            partido.setResultadoEL(Integer.parseInt(tfRL.getText()));
            partido.setResultadoEV(Integer.parseInt(tfRV.getText()));
            partido.setJugado(true);
            PartidoDB.actualizarPartido(partido);
        } catch (Exception ex) {
            Logger.getLogger(AjustesPartidosPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JComboBox<String> jcbJornada;
    private javax.swing.JComboBox<String> jcbPartido;
    private javax.swing.JLabel jlLocal;
    private javax.swing.JTextField tfRL;
    private javax.swing.JTextField tfRV;
    // End of variables declaration//GEN-END:variables
}
