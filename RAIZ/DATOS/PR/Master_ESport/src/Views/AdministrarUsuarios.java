/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import UML.Usuario;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author 1gdaw09
 */
public class AdministrarUsuarios extends javax.swing.JPanel {
    Inicio ini;
    /**
     * Creates new form AdministrarUsuarios
     */
    public AdministrarUsuarios() {
        initComponents();

    }
    
    
    public void cargarDatos(Usuario usuario){
        TMostrarNombreUsuario.setText(usuario.getNombre());
        TMostrarApellidoUsuario.setText(usuario.getApellido());
        TMostrarPermisosUsuario.setText(usuario.getPermiso());
        String urlImg = null;
        switch(usuario.getPermiso()){
            case "administrador": urlImg="/Imagenes/administrador.png";
                break;
            case "duenno": urlImg="/Imagenes/duenno.png";
                break;
            case "usuario": urlImg="/Imagenes/usuario.png";
                break;
                
        }
                ImageIcon ii = new ImageIcon(this.getClass().getResource(urlImg));
                ImageIcon yy = new ImageIcon(ii.getImage().getScaledInstance(200, 200, WIDTH));
                jlImagen.setIcon(yy);
    }
    
// Cerrar sesion
    public void FuncionCerrarSesion() throws Throwable{
        new Login().setVisible(true);
        ini.dispose();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LNombreUsuarios = new javax.swing.JLabel();
        LApellidoUsuarios = new javax.swing.JLabel();
        LPermisosUsuarios = new javax.swing.JLabel();
        BCerrarSesion = new javax.swing.JButton();
        TMostrarNombreUsuario = new javax.swing.JTextField();
        TMostrarApellidoUsuario = new javax.swing.JTextField();
        TMostrarPermisosUsuario = new javax.swing.JTextField();
        jlImagen = new javax.swing.JLabel();

        LNombreUsuarios.setText("Nombre");

        LApellidoUsuarios.setText("Apellidos");

        LPermisosUsuarios.setText("Permisos");

        BCerrarSesion.setBackground(new java.awt.Color(255, 0, 0));
        BCerrarSesion.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        BCerrarSesion.setText("Cerrar sesion");
        BCerrarSesion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCerrarSesionActionPerformed(evt);
            }
        });

        TMostrarNombreUsuario.setEditable(false);

        TMostrarApellidoUsuario.setEditable(false);
        TMostrarApellidoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TMostrarApellidoUsuarioActionPerformed(evt);
            }
        });

        TMostrarPermisosUsuario.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LApellidoUsuarios)
                            .addComponent(LPermisosUsuarios)
                            .addComponent(LNombreUsuarios)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TMostrarNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                            .addComponent(TMostrarApellidoUsuario)
                            .addComponent(TMostrarPermisosUsuario)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(353, 353, 353)
                        .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(385, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LNombreUsuarios)
                    .addComponent(TMostrarNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LApellidoUsuarios)
                    .addComponent(TMostrarApellidoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LPermisosUsuarios)
                    .addComponent(TMostrarPermisosUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(BCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
    }// </editor-fold>//GEN-END:initComponents

    //llamar funcion cerrar sesion
    private void BCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCerrarSesionActionPerformed
        try {
            // TODO add your handling code here:

            FuncionCerrarSesion();
        } catch (Throwable ex) {
            Logger.getLogger(AdministrarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BCerrarSesionActionPerformed

    private void TMostrarApellidoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TMostrarApellidoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TMostrarApellidoUsuarioActionPerformed

        public void ventanaPadre(Inicio ini){
            this.ini = ini;
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCerrarSesion;
    private javax.swing.JLabel LApellidoUsuarios;
    private javax.swing.JLabel LNombreUsuarios;
    private javax.swing.JLabel LPermisosUsuarios;
    private javax.swing.JTextField TMostrarApellidoUsuario;
    private javax.swing.JTextField TMostrarNombreUsuario;
    private javax.swing.JTextField TMostrarPermisosUsuario;
    private javax.swing.JLabel jlImagen;
    // End of variables declaration//GEN-END:variables
}
