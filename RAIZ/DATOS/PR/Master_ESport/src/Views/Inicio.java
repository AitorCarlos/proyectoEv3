package Views;

import Views.Secundarios.CrearPanel;
import Views.Secundarios.InicioPanel;
import PARSES.clasificacionSax;
import UML.Usuario;
import Views.Consultas.*;
import Views.Peticiones.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import static master_esport.Master_ESport.cargarParses;

public class Inicio extends javax.swing.JFrame {
    int xMouse,yMouse;
    
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

/** Oculta o visualiza partes de la aplicacion dependiendo de los permisos que tenga la cuenta    */
    public void permisos(String permiso){
       switch(permiso){
           case "usuario":
                    BInicioDueño.setVisible(false);
                    BInicioAdministrador.setVisible(false);
               break;
           case "duenno":
                    BInicioAdministrador.setVisible(false);
               break;
            case "administrador":
                    BInicioDueño.setVisible(false);
                    
               break;
            default: javax.swing.JOptionPane.showMessageDialog(this, "error de usuario");
       }
   }
   
   public void AltaUsuarioPanel(){
/** Visualizacion de paneles */
        CrearPanel c1 = new CrearPanel(usuario);
        c1.setSize(991, 578);
        c1.setLocation(0, 0);
        
        
        PInterfaz.removeAll();
        PInterfaz.add(c1, BorderLayout.CENTER);
        PInterfaz.revalidate();
        PInterfaz.repaint();
    } 
    
public void InicioPanel(){
/** Visualizacion de paneles */     
        InicioPanel c1 = new InicioPanel();
        c1.setSize(991, 578);
        c1.setLocation(0, 0);
        PInterfaz.removeAll();
        PInterfaz.add(c1, BorderLayout.CENTER);
        PInterfaz.revalidate();
        PInterfaz.repaint();
        
    }

/** Visualizacion de paneles */  
public void ConsultasPanel(){
    
    
        ConsultasPanel c1 = new ConsultasPanel();
        c1.setSize(991, 578);
        c1.setLocation(0, 0);
        
        PInterfaz.removeAll();
        PInterfaz.add(c1, BorderLayout.CENTER);
        PInterfaz.revalidate();
        PInterfaz.repaint();
    }

public void AdministrarUsuarios(){
/** Visualizacion de paneles */  
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
/** Visualizacion de paneles*/ 
        AdministradorPanel c1 = new AdministradorPanel();
        c1.setSize(991, 578);
        c1.setLocation(0, 0);
        
        PInterfaz.removeAll();
        PInterfaz.add(c1, BorderLayout.CENTER);
        PInterfaz.revalidate();
        PInterfaz.repaint();
    } 
   
 /** Cambia el color a blanco dependiendo de donde estes  */
   public void ColorSeleccionado(JButton jb){
       BInicioInicio.setForeground(Color.black);
       BInicioConsultas.setForeground(Color.black); 
       BInicioDueño.setForeground(Color.black); 
       BInicioAdministrador.setForeground(Color.black); 
       BInicioUsuario.setForeground(Color.black);
       jb.setForeground(Color.white);
       this.update(this.getGraphics());
   
   }
   
   
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PanelInterfaz = new javax.swing.JPanel();
        BInicioUsuario = new javax.swing.JButton();
        BInicioDueño = new javax.swing.JButton();
        BInicioConsultas = new javax.swing.JButton();
        BInicioInicio = new javax.swing.JButton();
        BExit = new javax.swing.JButton();
        BInicioAdministrador = new javax.swing.JButton();
        FramDrag = new javax.swing.JPanel();
        Bmin = new javax.swing.JButton();
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

        PanelInterfaz.setBackground(new java.awt.Color(153, 204, 255));

        BInicioUsuario.setBackground(new java.awt.Color(255, 255, 255));
        BInicioUsuario.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BInicioUsuario.setText("USUARIO");
        BInicioUsuario.setBorder(null);
        BInicioUsuario.setBorderPainted(false);
        BInicioUsuario.setFocusable(false);
        BInicioUsuario.setOpaque(false);
        BInicioUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BInicioUsuarioMouseClicked(evt);
            }
        });
        BInicioUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BInicioUsuarioActionPerformed(evt);
            }
        });

        BInicioDueño.setBackground(new java.awt.Color(255, 255, 255));
        BInicioDueño.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BInicioDueño.setText("DUEÑO");
        BInicioDueño.setBorder(null);
        BInicioDueño.setBorderPainted(false);
        BInicioDueño.setFocusable(false);
        BInicioDueño.setOpaque(false);
        BInicioDueño.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BInicioDueñoMouseClicked(evt);
            }
        });
        BInicioDueño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BInicioDueñoActionPerformed(evt);
            }
        });

        BInicioConsultas.setBackground(new java.awt.Color(255, 255, 255));
        BInicioConsultas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BInicioConsultas.setText("CONSULTAS");
        BInicioConsultas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BInicioConsultas.setBorderPainted(false);
        BInicioConsultas.setFocusable(false);
        BInicioConsultas.setOpaque(false);
        BInicioConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BInicioConsultasMouseClicked(evt);
            }
        });
        BInicioConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BInicioConsultasActionPerformed(evt);
            }
        });

        BInicioInicio.setBackground(new java.awt.Color(0, 255, 204));
        BInicioInicio.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BInicioInicio.setText("INICIO");
        BInicioInicio.setToolTipText("");
        BInicioInicio.setBorder(null);
        BInicioInicio.setBorderPainted(false);
        BInicioInicio.setFocusable(false);
        BInicioInicio.setOpaque(false);
        BInicioInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BInicioInicioMouseClicked(evt);
            }
        });
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
        BInicioAdministrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BInicioAdministradorMouseClicked(evt);
            }
        });
        BInicioAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BInicioAdministradorActionPerformed(evt);
            }
        });

        FramDrag.setBackground(new java.awt.Color(153, 204, 255));
        FramDrag.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                FramDragMouseDragged(evt);
            }
        });
        FramDrag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FramDragMousePressed(evt);
            }
        });

        javax.swing.GroupLayout FramDragLayout = new javax.swing.GroupLayout(FramDrag);
        FramDrag.setLayout(FramDragLayout);
        FramDragLayout.setHorizontalGroup(
            FramDragLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        FramDragLayout.setVerticalGroup(
            FramDragLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Bmin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Bmin.setForeground(new java.awt.Color(102, 102, 102));
        Bmin.setText("-");

        javax.swing.GroupLayout PanelInterfazLayout = new javax.swing.GroupLayout(PanelInterfaz);
        PanelInterfaz.setLayout(PanelInterfazLayout);
        PanelInterfazLayout.setHorizontalGroup(
            PanelInterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInterfazLayout.createSequentialGroup()
                .addGroup(PanelInterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInterfazLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(BInicioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(BInicioConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(BInicioDueño, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(BInicioAdministrador)
                        .addGap(28, 28, 28)
                        .addComponent(BInicioUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInterfazLayout.createSequentialGroup()
                        .addComponent(FramDrag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Bmin)
                        .addGap(2, 2, 2)))
                .addComponent(BExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelInterfazLayout.setVerticalGroup(
            PanelInterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInterfazLayout.createSequentialGroup()
                .addGroup(PanelInterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BExit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bmin, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(FramDrag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelInterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BInicioDueño, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BInicioConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BInicioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BInicioUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BInicioAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PInterfazLayout = new javax.swing.GroupLayout(PInterfaz);
        PInterfaz.setLayout(PInterfazLayout);
        PInterfazLayout.setHorizontalGroup(
            PInterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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
       
/** LLamar a la clase     */     
         ConsultasPanel();
        
        
    }//GEN-LAST:event_BInicioConsultasActionPerformed

    private void BInicioDueñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BInicioDueñoActionPerformed
/** LLamar a la clase     */              
         AltaUsuarioPanel();

    }//GEN-LAST:event_BInicioDueñoActionPerformed

    private void BInicioInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BInicioInicioActionPerformed
           
           
    }//GEN-LAST:event_BInicioInicioActionPerformed

    private void BInicioUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BInicioUsuarioActionPerformed
/** LLamar a la clase     */      
         AdministrarUsuarios();
        
    }//GEN-LAST:event_BInicioUsuarioActionPerformed

    private void BExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BExitActionPerformed
 
/** Salir del programa */
         System.exit(0);
    }//GEN-LAST:event_BExitActionPerformed

    private void BInicioAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BInicioAdministradorActionPerformed
  
/**LLamar a la clase     */             
         AdministradorPanel();
    }//GEN-LAST:event_BInicioAdministradorActionPerformed

    private void BInicioInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BInicioInicioMouseClicked
/**LLamar a la clase     */     
         ColorSeleccionado(BInicioInicio);
    }//GEN-LAST:event_BInicioInicioMouseClicked

    private void BInicioConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BInicioConsultasMouseClicked
/** LLamar a la clase     */     
         ColorSeleccionado(BInicioConsultas);
      
    }//GEN-LAST:event_BInicioConsultasMouseClicked

    private void BInicioDueñoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BInicioDueñoMouseClicked
/** LLamar a la clase     */     
         ColorSeleccionado(BInicioDueño);
    }//GEN-LAST:event_BInicioDueñoMouseClicked

    private void BInicioAdministradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BInicioAdministradorMouseClicked
/** LLamar a la clase     */     
         ColorSeleccionado(BInicioAdministrador);
    }//GEN-LAST:event_BInicioAdministradorMouseClicked

    private void BInicioUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BInicioUsuarioMouseClicked
/** LLamar a la clase     */     
         ColorSeleccionado(BInicioUsuario);
    }//GEN-LAST:event_BInicioUsuarioMouseClicked

    private void FramDragMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FramDragMouseDragged
        // TODO add your handling code here:

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse,y - yMouse);
    }//GEN-LAST:event_FramDragMouseDragged

    private void FramDragMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FramDragMousePressed
        // TODO add your handling code here:
        xMouse =evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_FramDragMousePressed

    
    
     
    
    
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
    private javax.swing.JButton BInicioConsultas;
    private javax.swing.JButton BInicioDueño;
    private javax.swing.JButton BInicioInicio;
    private javax.swing.JButton BInicioUsuario;
    private javax.swing.JButton Bmin;
    private javax.swing.JPanel FramDrag;
    private javax.swing.JPanel PInterfaz;
    private javax.swing.JPanel PanelInterfaz;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private boolean BInicioInicioActionPerformed(MouseEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
