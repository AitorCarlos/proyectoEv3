/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Segundarios;

import UML.Usuario;
import Views.Consultas.ConsultarJornadaPanel;
import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;



public class CrearPanel extends javax.swing.JPanel {
    
private Usuario usuario;

    public CrearPanel(Usuario usuario) {
        initComponents();
        this.usuario=usuario;
    }

//Visualizacion de paneles 
    public void CrearJugadorPanel(){
    
        CrearJugadorPanel c1 = new CrearJugadorPanel();
        c1.setSize(991, 578);
        c1.setLocation(0, 0);
        
        PInterfazAltas.removeAll();
        PInterfazAltas.add(c1, BorderLayout.CENTER);
        PInterfazAltas.revalidate();
        PInterfazAltas.repaint();
    }
//Visualizacion de paneles  
     public void CrearEquipoPanel(){
    
        CrearEquiposPanel c1 = new CrearEquiposPanel();
        c1.setSize(991, 578);
        c1.setLocation(0, 0);
        c1.cargarDatos(usuario);
        PInterfazAltas.removeAll();
        PInterfazAltas.add(c1, BorderLayout.CENTER);
        PInterfazAltas.revalidate();
        PInterfazAltas.repaint();
    }
    
    //Visualizacion de paneles  
     public void ModificarEquipo(){
    
        CrearEquiposPanel c1 = new CrearEquiposPanel();
        c1.setSize(991, 578);
        c1.setLocation(0, 0);
        
        PInterfazAltas.removeAll();
        PInterfazAltas.add(c1, BorderLayout.CENTER);
        PInterfazAltas.revalidate();
        PInterfazAltas.repaint();
    }

     //Visualizacion de paneles  
     public void ModificarJugador() throws Exception{
    
        ModificacionesPanel c1 = new ModificacionesPanel();
        c1.cargarDatos(usuario);
        c1.setSize(991, 578);
        c1.setLocation(0, 0);
        
        PInterfazAltas.removeAll();
        PInterfazAltas.add(c1, BorderLayout.CENTER);
        PInterfazAltas.revalidate();
        PInterfazAltas.repaint();
    }

     
     
     
     
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PInterfazAltas = new javax.swing.JPanel();
        BCrearEquipo = new javax.swing.JButton();
        BCrearJugador = new javax.swing.JButton();
        BModificarJugador = new javax.swing.JButton();

        javax.swing.GroupLayout PInterfazAltasLayout = new javax.swing.GroupLayout(PInterfazAltas);
        PInterfazAltas.setLayout(PInterfazAltasLayout);
        PInterfazAltasLayout.setHorizontalGroup(
            PInterfazAltasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        PInterfazAltasLayout.setVerticalGroup(
            PInterfazAltasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );

        BCrearEquipo.setBackground(new java.awt.Color(255, 255, 255));
        BCrearEquipo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BCrearEquipo.setText("Crear Equipo");
        BCrearEquipo.setBorder(null);
        BCrearEquipo.setBorderPainted(false);
        BCrearEquipo.setFocusable(false);
        BCrearEquipo.setOpaque(false);
        BCrearEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCrearEquipoActionPerformed(evt);
            }
        });

        BCrearJugador.setBackground(new java.awt.Color(255, 255, 255));
        BCrearJugador.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BCrearJugador.setText("Crear Jugador");
        BCrearJugador.setBorder(null);
        BCrearJugador.setBorderPainted(false);
        BCrearJugador.setFocusable(false);
        BCrearJugador.setOpaque(false);
        BCrearJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCrearJugadorActionPerformed(evt);
            }
        });

        BModificarJugador.setBackground(new java.awt.Color(255, 255, 255));
        BModificarJugador.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BModificarJugador.setText("Modificaciones");
        BModificarJugador.setBorder(null);
        BModificarJugador.setBorderPainted(false);
        BModificarJugador.setFocusable(false);
        BModificarJugador.setOpaque(false);
        BModificarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BModificarJugadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BCrearJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BCrearEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(BModificarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145))
                    .addComponent(PInterfazAltas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BCrearJugador)
                    .addComponent(BCrearEquipo)
                    .addComponent(BModificarJugador))
                .addGap(42, 42, 42)
                .addComponent(PInterfazAltas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BCrearEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCrearEquipoActionPerformed

//LLamar a la clase        
        CrearEquipoPanel();
    }//GEN-LAST:event_BCrearEquipoActionPerformed

    private void BCrearJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCrearJugadorActionPerformed

//LLamar a la clase          
        CrearJugadorPanel();
    }//GEN-LAST:event_BCrearJugadorActionPerformed

    private void BModificarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BModificarJugadorActionPerformed
    try {
        //LLamar a la clase
        ModificarJugador();
    } catch (Exception ex) {
        Logger.getLogger(CrearPanel.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_BModificarJugadorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCrearEquipo;
    private javax.swing.JButton BCrearJugador;
    private javax.swing.JButton BModificarJugador;
    private javax.swing.JPanel PInterfazAltas;
    // End of variables declaration//GEN-END:variables
}
