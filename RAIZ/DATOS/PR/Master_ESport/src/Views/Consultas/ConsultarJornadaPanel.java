package Views.Consultas;

import UML.Jornada;
import UML_DB.JornadaDB;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultarJornadaPanel extends javax.swing.JPanel {

    public ConsultarJornadaPanel() {
        initComponents();
        rellenarCombo();
    }
    
    public void rellenarCombo(){
        ArrayList jornadas = null;
        try {
            jornadas = JornadaDB.listaJornada();
        } catch (Exception ex) {
            Logger.getLogger(ConsultarJornadaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < jornadas.size(); i++) {
            Jornada jornada = (Jornada) jornadas.get(i);
            CElegirJornada.addItem(String.valueOf(jornada.getCodJornada()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TituloConsultarJugador = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        CElegirJornada = new javax.swing.JComboBox<>();
        jlJornada = new javax.swing.JLabel();

        TituloConsultarJugador.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        TituloConsultarJugador.setText("Consultar Jornada");

        jLabel1.setText("Jornada");

        CElegirJornada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CElegirJornadaItemStateChanged(evt);
            }
        });

        jlJornada.setBackground(new java.awt.Color(255, 255, 255));
        jlJornada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlJornada.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jlJornada.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(353, 353, 353)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(CElegirJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(334, 334, 334))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(TituloConsultarJugador)
                        .addGap(286, 286, 286))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jlJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(TituloConsultarJugador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CElegirJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CElegirJornadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CElegirJornadaItemStateChanged
        try {
            Jornada jornada = JornadaDB.verJornada(Integer.parseInt(CElegirJornada.getSelectedItem().toString()));
            jlJornada.setText(jornada.toString());
            
            
        } catch (Exception ex) {
            Logger.getLogger(ConsultarJornadaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_CElegirJornadaItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CElegirJornada;
    private javax.swing.JLabel TituloConsultarJugador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jlJornada;
    // End of variables declaration//GEN-END:variables
}
