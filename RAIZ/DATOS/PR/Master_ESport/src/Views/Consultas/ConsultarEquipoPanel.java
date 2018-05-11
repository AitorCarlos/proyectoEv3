package Views.Consultas;

import UML.Equipo;
import UML.Jugador;
import UML_DB.EquipoDB;
import UML_DB.JugadorDB;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultarEquipoPanel extends javax.swing.JPanel {

    public ConsultarEquipoPanel() {
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
            jcEquipos.addItem(equipo.getNombre());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TituloIniciosesion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jcEquipos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlLista = new javax.swing.JTextArea();

        TituloIniciosesion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        TituloIniciosesion.setText("Consultar Equipos");

        jLabel1.setText("Elige equipo");

        jcEquipos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcEquiposItemStateChanged(evt);
            }
        });

        jlLista.setColumns(20);
        jlLista.setRows(5);
        jlLista.setText("Lista de los jugadores\n......\t\t......\n......\t\t......\n......\t\t......\n......\t\t......");
        jScrollPane1.setViewportView(jlLista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TituloIniciosesion)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(266, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(TituloIniciosesion)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcEquiposItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcEquiposItemStateChanged
        try {
            // TODO add your handling code here:
            Equipo equipo = EquipoDB.consultarEquipoNom(jcEquipos.getSelectedItem().toString());
            String texto="";
            if (equipo.getJugador().size()==0 || equipo.getJugador()==null) {
                texto = "Este equipo no tiene jugadores.";
            }else{
                for (int i = 0; i < equipo.getJugador().size(); i++) {
                    Jugador jugador = (Jugador) equipo.getJugador().get(i);
                    texto = texto + jugador.toString()+"\n";
                }
            }
            
            jlLista.setText(texto);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jcEquiposItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TituloIniciosesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcEquipos;
    private javax.swing.JTextArea jlLista;
    // End of variables declaration//GEN-END:variables
}
