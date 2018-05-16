/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Consultas;

import UML.Equipo;
import UML.Jugador;
import UML_DB.EquipoDB;
import UML_DB.JugadorDB;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1gdaw09
 */
public class ConsultarJugadorPanel extends javax.swing.JPanel {

    /**
     * Creates new form ConsultarJugadorPanel
     */
    public ConsultarJugadorPanel() {
        initComponents();
        rellenarCombo();
    }

    public void rellenarCombo(){
        ArrayList equipos=null;
        try {
            equipos = EquipoDB.listaEquipo();
        } catch (Exception ex) {
            Logger.getLogger(ConsultarEquipoPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < equipos.size(); i++) {
            Equipo equipo = (Equipo) equipos.get(i);
            CConsultarEquipo.addItem(equipo.getNombre());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TBuscarNickname = new javax.swing.JTextField();
        LPerteneceA = new javax.swing.JLabel();
        TituloConsultarJugador = new javax.swing.JLabel();
        LConsultarEquipo = new javax.swing.JLabel();
        CConsultarEquipo = new javax.swing.JComboBox<>();
        LConsultarJugador = new javax.swing.JLabel();
        CConsultarJugador = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDatos = new javax.swing.JTextArea();
        LDatosdeJugador = new javax.swing.JLabel();
        LNickname = new javax.swing.JLabel();
        jbBuscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtaPertenece = new javax.swing.JTextArea();

        LPerteneceA.setText("Pertenece a");

        TituloConsultarJugador.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        TituloConsultarJugador.setText("Consultar Jugador");

        LConsultarEquipo.setText("Equipo");

        CConsultarEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----" }));
        CConsultarEquipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CConsultarEquipoItemStateChanged(evt);
            }
        });

        LConsultarJugador.setText("Jugador");

        CConsultarJugador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----" }));
        CConsultarJugador.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CConsultarJugadorItemStateChanged(evt);
            }
        });

        jtaDatos.setColumns(20);
        jtaDatos.setRows(5);
        jScrollPane1.setViewportView(jtaDatos);

        LDatosdeJugador.setText("Datos del jugador");

        LNickname.setText("Nickname");

        jbBuscar.setText("BUSCAR");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jtaPertenece.setColumns(20);
        jtaPertenece.setRows(5);
        jScrollPane3.setViewportView(jtaPertenece);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(TituloConsultarJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LPerteneceA)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LDatosdeJugador)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(LConsultarEquipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CConsultarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LConsultarJugador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CConsultarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LNickname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TBuscarNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBuscar)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(TituloConsultarJugador)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LConsultarEquipo)
                    .addComponent(CConsultarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LConsultarJugador)
                    .addComponent(CConsultarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LNickname)
                    .addComponent(TBuscarNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LPerteneceA)
                    .addComponent(LDatosdeJugador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(206, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CConsultarEquipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CConsultarEquipoItemStateChanged

        if (CConsultarEquipo.getSelectedItem().equals("-----")) {
            CConsultarJugador.removeAllItems();
        }else{
            TBuscarNickname.setText("");
            CConsultarJugador.setEnabled(true);
            try {
                // TODO add your handling code here:
                CConsultarJugador.removeAllItems();
                Equipo equipo = EquipoDB.consultarEquipoNom(CConsultarEquipo.getSelectedItem().toString());
                if (equipo.getJugador().size()==0 || equipo.getJugador()==null) {
                    CConsultarJugador.addItem("Sin jugadores");
                }else{
                    for (int i = 0; i < equipo.getJugador().size(); i++) {
                        Jugador jugador = (Jugador) equipo.getJugador().get(i);
                        CConsultarJugador.addItem(jugador.getNickname());
                    }
                }
            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_CConsultarEquipoItemStateChanged

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        CConsultarJugador.setEnabled(false);
        CConsultarJugador.removeAllItems();
        Jugador jugador;
        CConsultarEquipo.setSelectedIndex(0);
        try {
            jugador = JugadorDB.consultarJugadorNick(TBuscarNickname.getText());
        } catch (Exception ex) {jugador=null;}
        
        if (jugador==null) {
            jtaPertenece.setText("Jugador no encontrado");
            jtaDatos.setText("Jugador no encontrado");
        }else
            jtaPertenece.setText(jugador.getEquipo().getNombre());
            jtaDatos.setText(jugador.toString());
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void CConsultarJugadorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CConsultarJugadorItemStateChanged
        if (CConsultarJugador.isEnabled()) {
            Jugador jugador;
            try {
                jugador = JugadorDB.consultarJugadorNick(CConsultarJugador.getSelectedItem().toString());
            } catch (Exception ex) {jugador=null;}

            if (jugador==null) {
                jtaPertenece.setText("Jugador no encontrado");
                jtaDatos.setText("Jugador no encontrado");
            }else{
                jtaPertenece.setText(jugador.getEquipo().getNombre());
                jtaDatos.setText(jugador.toString());
            }
        }
    }//GEN-LAST:event_CConsultarJugadorItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CConsultarEquipo;
    private javax.swing.JComboBox<String> CConsultarJugador;
    private javax.swing.JLabel LConsultarEquipo;
    private javax.swing.JLabel LConsultarJugador;
    private javax.swing.JLabel LDatosdeJugador;
    private javax.swing.JLabel LNickname;
    private javax.swing.JLabel LPerteneceA;
    private javax.swing.JTextField TBuscarNickname;
    private javax.swing.JLabel TituloConsultarJugador;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JTextArea jtaDatos;
    private javax.swing.JTextArea jtaPertenece;
    // End of variables declaration//GEN-END:variables
}
