package Views;

import PARSES.clasificacionSax;
import UML.Usuario;
import Views.Segundarios.*;
import Views.Consultas.*;
import Views.Peticiones.*;
import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

public class Inicio extends javax.swing.JFrame {
    
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    public Inicio() {
        initComponents();
        setLocationRelativeTo(null);
        InicioPanel();
    }

    
    public void permisos(String permiso){
       switch(permiso){
           case "usuario":
                    BInicioAltas.setVisible(false);
                    BInicioAdministrador.setVisible(false);
               break;
           case "duenno":
                    BInicioAdministrador.setVisible(false);
               break;
            case "administrador":
                    BInicioAltas.setVisible(false);
                    
               break;
            default: javax.swing.JOptionPane.showMessageDialog(this, "error de usuario");
       }
   }
   
   public void AltaUsuarioPanel(){
//Visualizacion de paneles 
        CrearPanel c1 = new CrearPanel(usuario);
        c1.setSize(991, 578);
        c1.setLocation(0, 0);
        
        PInterfaz.removeAll();
        PInterfaz.add(c1, BorderLayout.CENTER);
        PInterfaz.revalidate();
        PInterfaz.repaint();
    } 
    
public void InicioPanel(){
//Visualizacion de paneles     
        InicioPanel c1 = new InicioPanel();
        c1.setSize(991, 578);
        c1.setLocation(0, 0);
        PInterfaz.removeAll();
        PInterfaz.add(c1, BorderLayout.CENTER);
        PInterfaz.revalidate();
        PInterfaz.repaint();
        
    }

public void ConsultasPanel(){
//Visualizacion de paneles     
        ConsultasPanel c1 = new ConsultasPanel();
        c1.setSize(991, 578);
        c1.setLocation(0, 0);
        
        PInterfaz.removeAll();
        PInterfaz.add(c1, BorderLayout.CENTER);
        PInterfaz.revalidate();
        PInterfaz.repaint();
    }

public void AdministrarUsuarios(){
//Visualizacion de paneles     
        AdministrarUsuarios c1 = new AdministrarUsuarios();
        c1.setSize(991, 578);
        c1.setLocation(0, 0);
        c1.ventanaPadre(this);
        c1.cargarDatos(usuario);
        PInterfaz.removeAll();
        PInterfaz.add(c1, BorderLayout.CENTER);
        PInterfaz.revalidate();
        PInterfaz.repaint();
    }

   public void AdministradorPanel(){
        //Visualizacion de paneles 
        AdministradorPanel c1 = new AdministradorPanel();
        c1.setSize(991, 578);
        c1.setLocation(0, 0);
        
        PInterfaz.removeAll();
        PInterfaz.add(c1, BorderLayout.CENTER);
        PInterfaz.revalidate();
        PInterfaz.repaint();
    } 
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PanelInterfaz = new javax.swing.JPanel();
        BInicioUsuario = new javax.swing.JButton();
        BInicioAltas = new javax.swing.JButton();
        BInicioConsultas = new javax.swing.JButton();
        BInicioInicio = new javax.swing.JButton();
        BExit = new javax.swing.JButton();
        BInicioAdministrador = new javax.swing.JButton();
        PInterfaz = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        PanelInterfaz.setBackground(new java.awt.Color(204, 204, 204));

        BInicioUsuario.setBackground(new java.awt.Color(255, 255, 255));
        BInicioUsuario.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BInicioUsuario.setText("USUARIO");
        BInicioUsuario.setBorder(null);
        BInicioUsuario.setBorderPainted(false);
        BInicioUsuario.setFocusable(false);
        BInicioUsuario.setOpaque(false);
        BInicioUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BInicioUsuarioActionPerformed(evt);
            }
        });

        BInicioAltas.setBackground(new java.awt.Color(255, 255, 255));
        BInicioAltas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BInicioAltas.setText("DUEÑO");
        BInicioAltas.setBorder(null);
        BInicioAltas.setBorderPainted(false);
        BInicioAltas.setFocusable(false);
        BInicioAltas.setOpaque(false);
        BInicioAltas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BInicioAltasActionPerformed(evt);
            }
        });

        BInicioConsultas.setBackground(new java.awt.Color(255, 255, 255));
        BInicioConsultas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BInicioConsultas.setText("CONSULTAS");
        BInicioConsultas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BInicioConsultas.setBorderPainted(false);
        BInicioConsultas.setFocusable(false);
        BInicioConsultas.setOpaque(false);
        BInicioConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BInicioConsultasActionPerformed(evt);
            }
        });

        BInicioInicio.setBackground(new java.awt.Color(255, 255, 255));
        BInicioInicio.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BInicioInicio.setText("INICIO");
        BInicioInicio.setBorder(null);
        BInicioInicio.setBorderPainted(false);
        BInicioInicio.setFocusable(false);
        BInicioInicio.setOpaque(false);
        BInicioInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BInicioInicioActionPerformed(evt);
            }
        });

        BExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Multiply_32px.png"))); // NOI18N
        BExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BExitActionPerformed(evt);
            }
        });

        BInicioAdministrador.setBackground(new java.awt.Color(255, 255, 255));
        BInicioAdministrador.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BInicioAdministrador.setText("ADMINISTRADOR");
        BInicioAdministrador.setBorder(null);
        BInicioAdministrador.setBorderPainted(false);
        BInicioAdministrador.setFocusable(false);
        BInicioAdministrador.setOpaque(false);
        BInicioAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BInicioAdministradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelInterfazLayout = new javax.swing.GroupLayout(PanelInterfaz);
        PanelInterfaz.setLayout(PanelInterfazLayout);
        PanelInterfazLayout.setHorizontalGroup(
            PanelInterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInterfazLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(BInicioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(BInicioConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(BInicioAltas, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BInicioAdministrador)
                .addGap(28, 28, 28)
                .addComponent(BInicioUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(BExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelInterfazLayout.setVerticalGroup(
            PanelInterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInterfazLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(PanelInterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BInicioAltas, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BInicioConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BInicioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BInicioUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BInicioAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(PanelInterfazLayout.createSequentialGroup()
                .addComponent(BExit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PInterfazLayout = new javax.swing.GroupLayout(PInterfaz);
        PInterfaz.setLayout(PInterfazLayout);
        PInterfazLayout.setHorizontalGroup(
            PInterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 991, Short.MAX_VALUE)
        );
        PInterfazLayout.setVerticalGroup(
            PInterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelInterfaz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PInterfaz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelInterfaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PInterfaz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BInicioConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BInicioConsultasActionPerformed
       
//LLamar a la clase          
         ConsultasPanel();
        
        
    }//GEN-LAST:event_BInicioConsultasActionPerformed

    private void BInicioAltasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BInicioAltasActionPerformed
        
//LLamar a la clase          
        //AQUI PONER QUE NO SE VEA SI NO TIENE PERMISO DE ADMINISTRADOR
        AltaUsuarioPanel();

    }//GEN-LAST:event_BInicioAltasActionPerformed

    private void BInicioInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BInicioInicioActionPerformed
//LLamar a la clase        
        InicioPanel();
       
           
           
    }//GEN-LAST:event_BInicioInicioActionPerformed

    private void BInicioUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BInicioUsuarioActionPerformed
    
 //LLamar a la clase        
        AdministrarUsuarios();
        
    }//GEN-LAST:event_BInicioUsuarioActionPerformed

    private void BExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BExitActionPerformed
 
//Salir del programa
        System.exit(0);
    }//GEN-LAST:event_BExitActionPerformed

    private void BInicioAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BInicioAdministradorActionPerformed
  
//LLamar a la clase          
        AdministradorPanel();
    }//GEN-LAST:event_BInicioAdministradorActionPerformed

    
    
     
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BExit;
    private javax.swing.JButton BInicioAdministrador;
    private javax.swing.JButton BInicioAltas;
    private javax.swing.JButton BInicioConsultas;
    private javax.swing.JButton BInicioInicio;
    private javax.swing.JButton BInicioUsuario;
    private javax.swing.JPanel PInterfaz;
    private javax.swing.JPanel PanelInterfaz;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
