
package Views.Peticiones;

import UML.Duenno;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import static javax.swing.JOptionPane.showMessageDialog;
import master_esport.Master_ESport;


public class Peticiones extends javax.swing.JPanel {
    
    public Peticiones() {
        initComponents();
        listaPeticionDuenno();
    }
    
    public static DefaultListModel verPeticioDuenno(){
        
        DefaultListModel list = new DefaultListModel();
        
        try {
                                 
            ArrayList <Duenno> d = Master_ESport.verPDuennos();
            
            for(int x = 0; x < d.size(); x++){
                
                list.addElement("Nombre: "+d.get(x).getNombre() +".  Permiso: "+d.get(x).getPermiso()+".  Tipo: "+Master_ESport.verTipo());                                
            }

        }
        catch(Exception e){}
        
        return list;
    }
    
    public void listaPeticionDuenno(){
    
        jpl.setModel(verPeticioDuenno());
    }
    
    public void aceptarPeticionDuenno(int r){
    
        try {
            
            ArrayList <Duenno> d = Master_ESport.verPDuennos();
            Master_ESport.anadirDuenno(d.get(r));
            Master_ESport.borrarPeticion(d.get(r).getNickname());
            
        }
        catch (ArrayIndexOutOfBoundsException e){
        
            showMessageDialog(this, "Seleccione una peticion por favor");
        }
        catch (Exception e) {
            
            showMessageDialog(this, e.getMessage());
        }
        
        listaPeticionDuenno();
    }
    
    public void denegarPeticionDuenno(int r){
    
        try {
            
            ArrayList <Duenno> d = Master_ESport.verPDuennos();
            Master_ESport.borrarPeticion(d.get(r).getNickname());
            
        }
        catch (ArrayIndexOutOfBoundsException e){
        
            showMessageDialog(this, "Seleccione una peticion por favor");
        }
        catch (Exception e) {
            
            showMessageDialog(this, e.getMessage());
        }
        
        listaPeticionDuenno();
    }

            
            /**
             * This method is called from within the constructor to initialize the form.
             * WARNING: Do NOT modify this code. The content of this method is always
             * regenerated by the Form Editor.
             */
            @SuppressWarnings("unchecked")
            // <editor-fold defaultstate="collapsed" desc="Generated Code">
            
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp = new javax.swing.JScrollPane();
        jpl = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jp.setViewportView(jpl);

        jButton1.setForeground(new java.awt.Color(51, 255, 51));
        jButton1.setText("✔");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setForeground(new java.awt.Color(255, 0, 51));
        jButton2.setText("✖");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jp, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(162, 162, 162))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jp, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        aceptarPeticionDuenno(jpl.getSelectedIndex());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        denegarPeticionDuenno(jpl.getSelectedIndex());
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jp;
    private javax.swing.JList<String> jpl;
    // End of variables declaration//GEN-END:variables
}