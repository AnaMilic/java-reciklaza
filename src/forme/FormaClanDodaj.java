/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forme;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logika.Kontroler;
import model.Clan;
import model.Zakon;

/**
 *
 * @author Ana
 */
public class FormaClanDodaj extends javax.swing.JFrame {

    /** Creates new form FormaClanDodaj */
    String operacija;
    Clan c;
    int brojClanova;
    Zakon z;
    public FormaClanDodaj(Clan c, String operacija, int brojClanova, Zakon z) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.c=c;
        this.operacija=operacija;
        this.brojClanova=brojClanova;
        this.z=z;
        if(operacija.equals("UPDATE")){
            podesiPolja(c);
            txtBrojClana.setEnabled(false);
            txtBrojClana.setText(String.valueOf(c.getBrojClana()));
            
        }else{
            txtBrojClana.setEnabled(false);
            txtBrojClana.setText(String.valueOf(brojClanova+1));
        }
        
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBrojClana = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSadrzaj = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNapomena = new javax.swing.JTextArea();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clan");

        jLabel2.setText("Broj clana:");

        jLabel3.setText("Sadrzaj:");

        jLabel4.setText("Napomena:");

        txtSadrzaj.setColumns(20);
        txtSadrzaj.setRows(5);
        jScrollPane1.setViewportView(txtSadrzaj);

        txtNapomena.setColumns(20);
        txtNapomena.setRows(5);
        jScrollPane2.setViewportView(txtNapomena);

        btnSacuvaj.setText("Sacuvaj clan");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSacuvaj))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(39, 39, 39)
                        .addComponent(txtBrojClana))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtBrojClana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSacuvaj)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            if(this.operacija.equals("INSERT")){
                this.insert();
                
            }else if(this.operacija.equals("UPDATE")){
                this.update();
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

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
            java.util.logging.Logger.getLogger(FormaClanDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaClanDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaClanDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaClanDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FormaClanDodaj().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtBrojClana;
    private javax.swing.JTextArea txtNapomena;
    private javax.swing.JTextArea txtSadrzaj;
    // End of variables declaration//GEN-END:variables

    

    private void podesiPolja(Clan c) {
        this.txtSadrzaj.setText(c.getSadrzaj());
        this.txtNapomena.setText(c.getNapomena());
    }

    private void insert() throws Exception {
        String napomena="";
        if(!txtNapomena.getText().isEmpty()){
            napomena=txtNapomena.getText();
        }
        
        String sadrzaj="";
        if(!txtSadrzaj.getText().isEmpty()){
            sadrzaj=txtSadrzaj.getText();
        }
        
        
        int brClana=brojClanova+1;
        
        Clan c=new Clan(z, brClana, sadrzaj, napomena);
        Kontroler.getInstanca().insertWithAutoincrement(c);
        JOptionPane.showMessageDialog(this, "Clan je uspesno sacuvan");
        this.setVisible(false);
        dispose();
        FormaClan fc=new FormaClan(z);
        fc.setVisible(true);
    }

    private void update() throws Exception {
        String napomena="";
        if(!txtNapomena.getText().isEmpty()){
            napomena=txtNapomena.getText();
        }
        
        String sadrzaj="";
        if(!txtSadrzaj.getText().isEmpty()){
            sadrzaj=txtSadrzaj.getText();
        }
        
        
        
        String brojCl=txtBrojClana.getText();
        int brCl=Integer.parseInt(brojCl);
        
        Clan clan=new Clan(z, brCl, sadrzaj, napomena);
        Kontroler.getInstanca().update(clan);
        JOptionPane.showMessageDialog(this, "Clan je uspesno izmenjen");
        this.setVisible(false);
        dispose();
        FormaClan fc=new FormaClan(z);
        fc.setVisible(true);
    }

}
