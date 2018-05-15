package Views.Secundarios;

import UML.Duenno;
import UML.Equipo;
import UML.Jugador;
import UML.Usuario;
import UML_DB.DuennoDB;
import UML_DB.EquipoDB;
import UML_DB.JugadorDB;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModificacionesPanel extends javax.swing.JPanel {

    private Usuario usuario;
    
    public ModificacionesPanel() {
        initComponents();
    }

    public void cargarDatos(Usuario usuario) throws Exception{
        this.usuario=usuario;
        Duenno duenno = DuennoDB.consultarDuennoNickName(usuario.getNickname());
        Equipo equipo = EquipoDB.consultarEquipoCodDuenno(duenno.getCodusuario());
        jlNombreEquipo.setText(equipo.getNombre());
        for (int i = 0; i < equipo.getJugador().size(); i++) {
            cbJugador.addItem(equipo.getJugador().get(i).getNickname());
        }
        ArrayList jugadoresSinEquipo = JugadorDB.listaDeJugadoresSinEquipo();
        for (int i = 0; i < jugadoresSinEquipo.size(); i++) {
            Jugador jugador = (Jugador) jugadoresSinEquipo.get(i);
            cbJugadorSinEquipo.addItem(jugador.getNickname());
        }
        
    }  
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlNombreEquipo = new javax.swing.JLabel();
        cbJugador = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfApellido = new javax.swing.JTextField();
        tfSueldo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbJugadorSinEquipo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        tfSueldoDisponible = new javax.swing.JTextField();
        tfNickname = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jbActualizar = new javax.swing.JButton();
        jbAnnadirEquipo = new javax.swing.JButton();
        jbDespedir = new javax.swing.JButton();
        jlEquipo = new javax.swing.JButton();

        jlNombreEquipo.setText("Nombre Equipo");

        cbJugador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----" }));
        cbJugador.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbJugadorItemStateChanged(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("Nickname");

        jLabel5.setText("Sueldo");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Modificar Equipo");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Modificar Jugador");

        jLabel8.setText("Jugadores Disponibles");

        cbJugadorSinEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----" }));
        cbJugadorSinEquipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbJugadorSinEquipoItemStateChanged(evt);
            }
        });

        jLabel9.setText("Sueldo");

        tfSueldoDisponible.setText("                      X");
        tfSueldoDisponible.setEnabled(false);

        jLabel11.setText("Seleccionar Jugador");

        jbActualizar.setText("ACTUALIZAR");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jbAnnadirEquipo.setText("AÑADIR A TU EQUIPO");
        jbAnnadirEquipo.setEnabled(false);
        jbAnnadirEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnnadirEquipoActionPerformed(evt);
            }
        });

        jbDespedir.setText("DESPEDIR");
        jbDespedir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDespedirActionPerformed(evt);
            }
        });

        jlEquipo.setText("Eliminar Equipo");
        jlEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlEquipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jbDespedir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbActualizar))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(48, 48, 48)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfApellido)
                                .addComponent(tfNickname)
                                .addComponent(tfNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                .addComponent(tfSueldo))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jlNombreEquipo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlEquipo)
                            .addComponent(cbJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(73, 73, 73)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbAnnadirEquipo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbJugadorSinEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfSueldoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(cbJugadorSinEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(tfSueldoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbAnnadirEquipo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlNombreEquipo)
                                    .addComponent(jlEquipo))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(tfNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(tfSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbActualizar)
                            .addComponent(jbDespedir))
                        .addContainerGap(127, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbJugadorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbJugadorItemStateChanged
        try {
            // TODO add your handling code here:
            Jugador jugador = JugadorDB.consultarJugadorNick(cbJugador.getSelectedItem().toString());
            tfNombre.setText(jugador.getNombre());
            tfApellido.setText(jugador.getApellido());
            tfNickname.setText(jugador.getNickname());
            tfSueldo.setText(String.valueOf(jugador.getSueldo()));
        } catch (Exception ex) {
            Logger.getLogger(ModificacionesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_cbJugadorItemStateChanged

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        // TODO add your handling code here:
                try {
            Jugador jugador = new Jugador();
            jugador.setNombre(tfNombre.getText());
            jugador.setApellido(tfApellido.getText());
            jugador.setSueldo(Double.parseDouble(tfSueldo.getText()));
            jugador.setNickname(tfNickname.getText());
            jugador.setCodjugador(JugadorDB.consultarJugadorNick(tfNickname.getText()).getCodjugador());
            JugadorDB.modificarJugador(jugador);
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void cbJugadorSinEquipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbJugadorSinEquipoItemStateChanged
        // TODO add your handling code here:
        if (cbJugadorSinEquipo.getSelectedItem().toString().equalsIgnoreCase("-----")) {
            tfSueldoDisponible.setEditable(false);
            tfSueldoDisponible.setEnabled(false);
            tfSueldoDisponible.setText("X");
            jbAnnadirEquipo.setEnabled(false);
        }else{
            tfSueldoDisponible.setEditable(true);
            tfSueldoDisponible.setEnabled(true);
            tfSueldoDisponible.setText("");
            jbAnnadirEquipo.setEnabled(true);
        }
    }//GEN-LAST:event_cbJugadorSinEquipoItemStateChanged

    private void jbAnnadirEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnnadirEquipoActionPerformed
        
        if (Integer.parseInt(tfSueldoDisponible.getText())<760) {
            javax.swing.JOptionPane.showMessageDialog(this, "Sueldo mínimo 760");
        }else{
            try {
                        tfSueldoDisponible.setEnabled(false);
                        Jugador jugador = JugadorDB.consultarJugadorNickSinEquipo(cbJugadorSinEquipo.getSelectedItem().toString());
                        jugador.setSueldo(Double.parseDouble(tfSueldoDisponible.getText()));
                        jugador.setEquipo(EquipoDB.consultarEquipoCod(DuennoDB.consultarDuennoNickName(usuario.getNickname()).getCodusuario()));
                        JugadorDB.modificarJugadorCodEquipo(EquipoDB.consultarEquipoCodDuenno(DuennoDB.consultarDuennoNickName(usuario.getNickname()).getCodusuario()), jugador);
                        javax.swing.JOptionPane.showMessageDialog(this, "Jugador Añadido");
                        tfSueldoDisponible.setText("");
                        this.paintAll(this.getGraphics());  
                    } catch (Exception ex) {
                        javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage());
                    }
        }
    }//GEN-LAST:event_jbAnnadirEquipoActionPerformed

    private void jbDespedirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDespedirActionPerformed
        try {
            // TODO add your handling code here:
            Jugador jugador = JugadorDB.consultarJugadorNick(tfNickname.getText());
            jugador.setSueldo(null);
            JugadorDB.modificarJugadorCodEquipo(null, jugador);
            
        } catch (Exception ex) {
            Logger.getLogger(ModificacionesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jbDespedirActionPerformed

    private void jlEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlEquipoActionPerformed
        try {
            EquipoDB.borrarEquipo(EquipoDB.consultarEquipoNom(jlNombreEquipo.getText()).getCodequipo());
        } catch (Exception ex) {
            Logger.getLogger(ModificacionesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jlEquipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbJugador;
    private javax.swing.JComboBox<String> cbJugadorSinEquipo;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbAnnadirEquipo;
    private javax.swing.JButton jbDespedir;
    private javax.swing.JButton jlEquipo;
    private javax.swing.JLabel jlNombreEquipo;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfNickname;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfSueldo;
    private javax.swing.JTextField tfSueldoDisponible;
    // End of variables declaration//GEN-END:variables
}
