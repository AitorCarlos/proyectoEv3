/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Secundarios;

import PARSES.*;

/**
 *
 * @author 1gdaw09
 */
public class InicioPanel extends javax.swing.JPanel {

    /**
     * Creates new form InicioPanel
     */
    public InicioPanel() {
        initComponents();
        mostrarClasificacion();
        mostrarJornada();
    }
    
    public void mostrarClasificacion(){
        jlClasificacion.setText(clasificacionSax.main());
    }
    
    public void mostrarJornada(){
        jlJornada.setText(ultimaJornadasSAX.main());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PProximosPartidos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jlClasificacion = new javax.swing.JLabel();
        PClasificacion = new javax.swing.JPanel();
        LClasificacion = new javax.swing.JLabel();
        jlJornada = new javax.swing.JLabel();

        PProximosPartidos.setBackground(new java.awt.Color(255, 255, 255));
        PProximosPartidos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Jornada Actual");

        javax.swing.GroupLayout PProximosPartidosLayout = new javax.swing.GroupLayout(PProximosPartidos);
        PProximosPartidos.setLayout(PProximosPartidosLayout);
        PProximosPartidosLayout.setHorizontalGroup(
            PProximosPartidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PProximosPartidosLayout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        PProximosPartidosLayout.setVerticalGroup(
            PProximosPartidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PProximosPartidosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jlClasificacion.setBackground(new java.awt.Color(255, 255, 255));
        jlClasificacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlClasificacion.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jlClasificacion.setOpaque(true);

        PClasificacion.setBackground(new java.awt.Color(255, 255, 255));
        PClasificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        LClasificacion.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        LClasificacion.setText("Clasificación");

        javax.swing.GroupLayout PClasificacionLayout = new javax.swing.GroupLayout(PClasificacion);
        PClasificacion.setLayout(PClasificacionLayout);
        PClasificacionLayout.setHorizontalGroup(
            PClasificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PClasificacionLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(LClasificacion)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        PClasificacionLayout.setVerticalGroup(
            PClasificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PClasificacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jlJornada.setBackground(new java.awt.Color(255, 255, 255));
        jlJornada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlJornada.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jlJornada.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PProximosPartidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlJornada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PProximosPartidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PClasificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(128, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LClasificacion;
    private javax.swing.JPanel PClasificacion;
    private javax.swing.JPanel PProximosPartidos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jlClasificacion;
    private javax.swing.JLabel jlJornada;
    // End of variables declaration//GEN-END:variables
}
