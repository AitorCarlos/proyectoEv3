
package Views;

import master_esport.*;
import UML.Miembro;
import UML_DB.MiembroDB;
import Views.Secundarios.CrearPanel;
import java.awt.*;
import java.io.File;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.*;
import javafx.scene.*;
import javafx.scene.media.*;
import javax.swing.*;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.net.URI;        
import java.util.logging.*;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
                
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        imglinkw();
        JCUsuarioInicio.requestFocus();
    }
    
//Visualizacion de paneles     
public void RegistroPanel(){
    
        RegistroPanel c1 = new RegistroPanel();
        c1.setSize(340, 179);
        c1.setLocation(0, 0);
        
        PPanelRegistro.removeAll();
        PPanelRegistro.add(c1, BorderLayout.CENTER);
        PPanelRegistro.revalidate();
        PPanelRegistro.repaint();
    } 

//Visualizacion de paneles 
    public void imglinkw(){
        ImageIcon ima = new ImageIcon("src\\Imagenes\\wordpress.png");
        Icon ico = new ImageIcon(ima.getImage().getScaledInstance(60, 60, 0));
        BLinkWordpress.setIcon(ico);
        BLinkWordpress.repaint();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        PanelLogin = new javax.swing.JPanel();
        BAcceder = new javax.swing.JButton();
        LIconoLogo = new javax.swing.JLabel();
        LNoEstasRegistrado = new javax.swing.JLabel();
        BLinkWordpress = new javax.swing.JButton();
        Bexit = new javax.swing.JButton();
        BRegistrarse = new javax.swing.JButton();
        PPanelRegistro = new javax.swing.JPanel();
        JCUsuarioInicio = new app.bolivia.swing.JCTextField();
        panelImage3 = new org.edisoncor.gui.panel.PanelImage();
        panelImage5 = new org.edisoncor.gui.panel.PanelImage();
        JRContraseñaUsuario = new jpass.JRPasswordField();
        jLabel1 = new javax.swing.JLabel();
        PVideoLogin = new javax.swing.JLabel();
        LTitulo = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        PanelLogin.setBackground(new java.awt.Color(204, 204, 204));

        BAcceder.setText("Acceder");
        BAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAccederActionPerformed(evt);
            }
        });

        LIconoLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo.png"))); // NOI18N

        LNoEstasRegistrado.setText("¿No estas registrado? ");

        BLinkWordpress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLinkWordpressActionPerformed(evt);
            }
        });

        Bexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Multiply_32px.png"))); // NOI18N
        Bexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BexitActionPerformed(evt);
            }
        });

        BRegistrarse.setText("Registrarse");
        BRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRegistrarseActionPerformed(evt);
            }
        });

        PPanelRegistro.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout PPanelRegistroLayout = new javax.swing.GroupLayout(PPanelRegistro);
        PPanelRegistro.setLayout(PPanelRegistroLayout);
        PPanelRegistroLayout.setHorizontalGroup(
            PPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        PPanelRegistroLayout.setVerticalGroup(
            PPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        JCUsuarioInicio.setBorder(null);
        JCUsuarioInicio.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        JCUsuarioInicio.setPlaceholder("Username");
        JCUsuarioInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCUsuarioInicioActionPerformed(evt);
            }
        });

        panelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono1.png"))); // NOI18N

        javax.swing.GroupLayout panelImage3Layout = new javax.swing.GroupLayout(panelImage3);
        panelImage3.setLayout(panelImage3Layout);
        panelImage3Layout.setHorizontalGroup(
            panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );
        panelImage3Layout.setVerticalGroup(
            panelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        panelImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/password1.png"))); // NOI18N

        javax.swing.GroupLayout panelImage5Layout = new javax.swing.GroupLayout(panelImage5);
        panelImage5.setLayout(panelImage5Layout);
        panelImage5Layout.setHorizontalGroup(
            panelImage5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );
        panelImage5Layout.setVerticalGroup(
            panelImage5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        JRContraseñaUsuario.setBorder(null);
        JRContraseñaUsuario.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        JRContraseñaUsuario.setPlaceholder("Password");
        JRContraseñaUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JRContraseñaUsuarioKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tambien nos puedes ver en :");

        javax.swing.GroupLayout PanelLoginLayout = new javax.swing.GroupLayout(PanelLogin);
        PanelLogin.setLayout(PanelLoginLayout);
        PanelLoginLayout.setHorizontalGroup(
            PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLoginLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelImage5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLoginLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(BAcceder))
                    .addComponent(LNoEstasRegistrado)
                    .addComponent(BRegistrarse)
                    .addComponent(JCUsuarioInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JRContraseñaUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60))
            .addGroup(PanelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLoginLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(BLinkWordpress, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLoginLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLoginLayout.createSequentialGroup()
                                .addComponent(LIconoLogo)
                                .addGap(37, 37, 37)
                                .addComponent(Bexit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PPanelRegistro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        PanelLoginLayout.setVerticalGroup(
            PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLoginLayout.createSequentialGroup()
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Bexit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LIconoLogo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JCUsuarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelImage5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JRContraseñaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BAcceder)
                .addGap(4, 4, 4)
                .addComponent(LNoEstasRegistrado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BRegistrarse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PPanelRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLoginLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BLinkWordpress, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLoginLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)))
                .addGap(16, 16, 16))
        );

        LTitulo.setBackground(new java.awt.Color(153, 255, 255));
        LTitulo.setFont(new java.awt.Font("Tahoma", 0, 72)); // NOI18N
        LTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/generatedtext.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PVideoLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(PanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(LTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(PVideoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//Escena del video     
        PVideoLogin.setLayout(new BorderLayout());
        PVideoLogin.add(createScene(),BorderLayout.CENTER);
    }//GEN-LAST:event_formWindowOpened

    private void BexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BexitActionPerformed

//Salir de la aplicacion

        System.exit(0);
    }//GEN-LAST:event_BexitActionPerformed

    private void BAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAccederActionPerformed
        try {
            Miembro miembro = MiembroDB.consultarMiembroNom(JCUsuarioInicio.getText());


        if (miembro == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "usuario no encontrado");
        }else
            if (JRContraseñaUsuario.getText().equals(miembro.getContrasenna())) {
                Master_ESport.cargarParses();
                this.dispose();
                Inicio ini = new Inicio();
                ini.setVisible(true);
                ini.setUsuario(miembro);
                ini.permisos(miembro.getPermiso());
            }else{
                javax.swing.JOptionPane.showMessageDialog(this, "usuario o contraseña erronea");
            }
        } catch (Exception ex) { javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage()); }
    }//GEN-LAST:event_BAccederActionPerformed

    private void BRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRegistrarseActionPerformed
//LLamar a la clase     
        RegistroPanel();
    }//GEN-LAST:event_BRegistrarseActionPerformed

    private void BLinkWordpressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLinkWordpressActionPerformed
     
//LINK Wordpress
        try{
        Desktop.getDesktop().browse(new URI("http://10.1.3.1"));
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERROR,no se puede ejecutar la accion");
        }
    }//GEN-LAST:event_BLinkWordpressActionPerformed

    private void JCUsuarioInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCUsuarioInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCUsuarioInicioActionPerformed

    private void JRContraseñaUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JRContraseñaUsuarioKeyPressed
        if (evt.getKeyCode()== KeyEvent.VK_ENTER) {
            BAcceder.doClick();
        }
    }//GEN-LAST:event_JRContraseñaUsuarioKeyPressed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
//Crear Escena video
    private JFXPanel createScene(){
        JFXPanel jfxPanel = new JFXPanel();
        Platform.runLater(new Runnable() {
             @Override
             public void run() {                 
                File file = new File("src/Imagenes/videoPanel.mp4");  
                    MediaPlayer oracleVid = new MediaPlayer(
                        new Media(file.toURI().toString())
                    );
                    //se añade video al jfxPanel
                    
                    jfxPanel.setScene(new Scene(new Group(new MediaView(oracleVid))));                    
                    oracleVid.setVolume(0.7);//volumen
                    oracleVid.setCycleCount(MediaPlayer.INDEFINITE);//repite video
                    oracleVid.play();//play video
             }
        });
        return jfxPanel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAcceder;
    private javax.swing.JButton BLinkWordpress;
    private javax.swing.JButton BRegistrarse;
    private javax.swing.JButton Bexit;
    public static app.bolivia.swing.JCTextField JCUsuarioInicio;
    public static jpass.JRPasswordField JRContraseñaUsuario;
    private javax.swing.JLabel LIconoLogo;
    private javax.swing.JLabel LNoEstasRegistrado;
    private javax.swing.JLabel LTitulo;
    private javax.swing.JPanel PPanelRegistro;
    private javax.swing.JLabel PVideoLogin;
    private javax.swing.JPanel PanelLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private org.edisoncor.gui.panel.PanelImage panelImage3;
    private org.edisoncor.gui.panel.PanelImage panelImage5;
    // End of variables declaration//GEN-END:variables
}
