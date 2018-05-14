/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import static javax.swing.JOptionPane.showMessageDialog;
import master_esport.Master_ESport;

/**
 *
 * @author 1gdaw09
 */
public class RegistroPanel extends javax.swing.JPanel {

    /**
     * Creates new form CrearUsuarioPanel
     */
    
    public RegistroPanel() {
        initComponents();
    }
    
    public String permiso(){
    
        String permiso = "";
        
        if(jcDuenno.isSelected()){
        
            permiso = "duenno";
        }
        else{
        
            permiso = "usuario";
        }
        
        return permiso;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LCrearContraseña = new javax.swing.JLabel();
        txNickname = new javax.swing.JTextField();
        txApellido = new javax.swing.JTextField();
        txContrasena = new javax.swing.JPasswordField();
        BVerPass = new javax.swing.JToggleButton();
        txNombre = new javax.swing.JTextField();
        BCrearUsuario = new javax.swing.JButton();
        LCrearNombredeUsuario = new javax.swing.JLabel();
        LCrearNombre = new javax.swing.JLabel();
        LCrearApellidos = new javax.swing.JLabel();
        jcDuenno = new javax.swing.JCheckBox();

        LCrearContraseña.setText("Contraseña");

        BVerPass.setText("Ver Pass");

        BCrearUsuario.setText("Crear Usuario");
        BCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCrearUsuarioActionPerformed(evt);
            }
        });

        LCrearNombredeUsuario.setText("Nombre de usuario");

        LCrearNombre.setText("Nombre");

        LCrearApellidos.setText("Apellidos");

        jcDuenno.setText("¿Dueño?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LCrearNombredeUsuario)
                            .addComponent(LCrearContraseña)
                            .addComponent(LCrearNombre)
                            .addComponent(jcDuenno))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(txApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txNickname))
                                .addComponent(BCrearUsuario))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BVerPass))))
                    .addComponent(LCrearApellidos))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LCrearNombredeUsuario)
                    .addComponent(txNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LCrearNombre)
                    .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LCrearApellidos)
                    .addComponent(txApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LCrearContraseña)
                    .addComponent(BVerPass, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BCrearUsuario)
                    .addComponent(jcDuenno))
                .addContainerGap(66, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCrearUsuarioActionPerformed
        // TODO add your handling code here:
        
        try{
        
            if(jcDuenno.isSelected()){
            
                String passText = new String(txContrasena.getPassword());
                Master_ESport.peticionDuenno(txNickname.getText(), txNombre.getText(), txApellido.getText(), passText, permiso(), "duenno");
                
                showMessageDialog(this, "Peticion de dueño realizada, espera a que un administrador la acepte");
                
                txNickname.setText(null); txNombre.setText(null); txApellido.setText(null); txContrasena.setText(null); jcDuenno.setSelected(false);
                
            }
            else{
            
                String passText = new String(txContrasena.getPassword());
                Master_ESport.crearMiembro(txNickname.getText(), txNombre.getText(), txApellido.getText(), passText, permiso());
                
                showMessageDialog(this, "Miembro creado");
                
                txNickname.setText(null); txNombre.setText(null); txApellido.setText(null); txContrasena.setText(null);
            }
        }
        catch(Exception e){
        
            showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_BCrearUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCrearUsuario;
    private javax.swing.JToggleButton BVerPass;
    private javax.swing.JLabel LCrearApellidos;
    private javax.swing.JLabel LCrearContraseña;
    private javax.swing.JLabel LCrearNombre;
    private javax.swing.JLabel LCrearNombredeUsuario;
    private javax.swing.JCheckBox jcDuenno;
    private javax.swing.JTextField txApellido;
    private javax.swing.JPasswordField txContrasena;
    private javax.swing.JTextField txNickname;
    private javax.swing.JTextField txNombre;
    // End of variables declaration//GEN-END:variables
}
