package Views.Peticiones;

import UML.Equipo;
import UML_DB.EquipoDB;
import UML_DB.JornadaDB;
import java.text.SimpleDateFormat;
import master_esport.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AjustesJornadasPanel extends javax.swing.JPanel {

    public AjustesJornadasPanel() {
        initComponents();
        comprobarJornada();
        cargaInicial();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taEquipos = new javax.swing.JTextArea();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        tbJornada = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Equipos Participantes");

        taEquipos.setColumns(20);
        taEquipos.setRows(5);
        jScrollPane1.setViewportView(taEquipos);

        tbJornada.setText("INICIAR");
        tbJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbJornadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbJornada)))
                .addContainerGap(256, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tbJornada)
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbJornadaActionPerformed

        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        switch (tbJornada.getText()){
            case "INICIAR": master_esport.Master_ESport.crearCalendario(master_esport.Master_ESport.cambiarFormato(String.valueOf(sdf.format(jdcFecha.getDate()))));
                break;
            case "FINALIZAR" : {
                    try {
                        JornadaDB.borrarTodasJornadas();
                    } catch (Exception ex) {
                        Logger.getLogger(AjustesJornadasPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
                break;
        }
    }//GEN-LAST:event_tbJornadaActionPerformed

    public void cargaInicial(){
        String equiposText = "";
        try {
            ArrayList equipos = EquipoDB.listaEquipo();
            for (int i = 0; i < equipos.size(); i++) {
                Equipo equipo = (Equipo) equipos.get(i);
                equiposText = equiposText + equipo.getNombre()+" \n";
            }
            if (equipos.size()<3 && tbJornada.getText().equalsIgnoreCase("INICIAR")) {
                tbJornada.setEnabled(false);
                equiposText = equiposText + "no hay equipos suficientes para iniciar la jornada";
            }
            taEquipos.setText(equiposText);
        } catch (Exception ex) {
            taEquipos.setText("No hay Equipos Disponibles");
        }
        }
        
    public void comprobarJornada(){
        try {
            if (JornadaDB.listaJornada().size()==0) {
                tbJornada.setText("INICIAR");
            }else{
                tbJornada.setText("FINALIZAR");
            }
        } catch (Exception ex) {
            Logger.getLogger(AjustesJornadasPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JTextArea taEquipos;
    private javax.swing.JButton tbJornada;
    // End of variables declaration//GEN-END:variables
}
