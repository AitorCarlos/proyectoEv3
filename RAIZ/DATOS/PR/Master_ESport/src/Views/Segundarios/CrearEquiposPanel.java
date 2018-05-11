/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Segundarios;

import UML.Duenno;
import UML.Equipo;
import UML.Usuario;
import UML_DB.DuennoDB;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1gdaw09
 */
public class CrearEquiposPanel extends javax.swing.JPanel {

    Usuario usuario = new Usuario();
    public CrearEquiposPanel() {
        initComponents();
    }

    public void cargarDatos(Usuario usuario){
        this.usuario = usuario;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TNombredelequipo = new javax.swing.JTextField();
        TituloCrearEquipos = new javax.swing.JLabel();
        LNombredelequipo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        TituloCrearEquipos.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        TituloCrearEquipos.setText("Crear equipos");

        LNombredelequipo.setText("Nombre del equipo");

        jButton1.setText("CREAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(LNombredelequipo)
                        .addGap(38, 38, 38)
                        .addComponent(TNombredelequipo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(TituloCrearEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(381, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(TituloCrearEquipos)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LNombredelequipo)
                    .addComponent(TNombredelequipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(329, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Equipo equipo = new Equipo();
        Duenno duenno = new Duenno();
        try {
            duenno = DuennoDB.consultarDuennoNickName(usuario.getNickname());
        } catch (Exception ex) {
            Logger.getLogger(CrearEquiposPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        equipo.setNombre(TNombredelequipo.getText());
        duenno.setCodusuario(duenno.getCodusuario());
        equipo.setDuenno(duenno);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LNombredelequipo;
    private javax.swing.JTextField TNombredelequipo;
    private javax.swing.JLabel TituloCrearEquipos;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
