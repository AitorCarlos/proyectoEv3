/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Secundarios;

import UML.Duenno;
import UML.Equipo;
import UML.Usuario;
import UML_DB.DuennoDB;
import UML_DB.EquipoDB;
import java.util.logging.Level;
import java.util.logging.Logger;
import master_esport.*;

/**
 *
 * @author 1gdaw09
 */
public class CrearEquiposPanel extends javax.swing.JPanel {

    Usuario usuario = new Usuario();
    public CrearEquiposPanel() {
        initComponents();
    }

    public void cargarDatos(Usuario usuario) throws Exception{
        this.usuario = usuario;
        if (EquipoDB.consultarEquipoCodDuenno(usuario.getCodusuario())!=null) {
            jbCrear.setEnabled(false);
            jlAviso.setText("Ya tienes tu equipo creado, elimínalo en la pertaña de modificaciones");
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        TNombredelequipo = new javax.swing.JTextField();
        TituloCrearEquipos = new javax.swing.JLabel();
        LNombredelequipo = new javax.swing.JLabel();
        jbCrear = new javax.swing.JButton();
        jlAviso = new javax.swing.JLabel();

        TituloCrearEquipos.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        TituloCrearEquipos.setText("Crear equipos");

        LNombredelequipo.setText("Nombre del equipo");

        jbCrear.setText("CREAR");
        jbCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(TituloCrearEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(LNombredelequipo)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlAviso)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TNombredelequipo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbCrear)))))
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
                    .addComponent(jbCrear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlAviso)
                .addContainerGap(323, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearActionPerformed
        // TODO add your handling code here:
        Equipo equipo = new Equipo();
        Duenno duenno = new Duenno();
        try {
            duenno = DuennoDB.consultarDuennoNickName(usuario.getNickname());
            equipo.setNombre(TNombredelequipo.getText());
            duenno.setCodusuario(duenno.getCodusuario());
            equipo.setDuenno(duenno);
            Master_ESport.peticionEquipo(equipo, duenno, "equipo");
        } catch (Exception ex) {
            Logger.getLogger(CrearEquiposPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbCrearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LNombredelequipo;
    private javax.swing.JTextField TNombredelequipo;
    private javax.swing.JLabel TituloCrearEquipos;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JButton jbCrear;
    private javax.swing.JLabel jlAviso;
    // End of variables declaration//GEN-END:variables
}
