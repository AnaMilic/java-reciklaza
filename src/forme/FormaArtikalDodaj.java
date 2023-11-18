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
import model.Artikal;
import model.Jedinica_Mere;

/**
 *
 * @author Ana
 */
public class FormaArtikalDodaj extends javax.swing.JFrame {

    /**
     * Creates new form FormaArtikalDodaj
     */
    FormaArtikal parent;
    Artikal a;
    String operacija;
    public FormaArtikalDodaj(FormaArtikal parent, boolean modal, Artikal a, String operacija) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.parent=parent;
        this.a=a;
        this.operacija=operacija;
        if(operacija.equals("UPDATE")){
            podesiPolja(a);
        }else{
            txtTrenutnaCena.setEnabled(false);
            txtTrenutnaCena.setText("0.0");
        }
        popuniCmb();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNazivArtikla = new javax.swing.JTextField();
        cmbJM = new javax.swing.JComboBox();
        btnDodaj = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTrenutnaCena = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Artikal");

        jLabel1.setText("Naziv artikla:");

        jLabel2.setText("Jedinica mere:");

        btnDodaj.setText("Sacuvaj artikal");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        jLabel3.setText("Trenutna cena:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDodaj, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(15, 15, 15)
                        .addComponent(txtTrenutnaCena))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbJM, 0, 297, Short.MAX_VALUE)
                            .addComponent(txtNazivArtikla))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNazivArtikla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbJM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTrenutnaCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnDodaj)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
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
    }//GEN-LAST:event_btnDodajActionPerformed

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
            java.util.logging.Logger.getLogger(FormaArtikalDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaArtikalDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaArtikalDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaArtikalDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new FormaArtikalDodaj().setVisible(true);
            }
        });
    }

    private void podesiPolja(Artikal a) {
        this.txtNazivArtikla.setText(a.getNazivArtikla());
        this.cmbJM.setSelectedItem(a);
        this.txtTrenutnaCena.setText(String.valueOf(a.getTrenutnaCena()));
        //this.txtTrenutnaCena.setEnabled(false);
    }

    private void popuniCmb() {
        try {
            cmbJM.removeAllItems();
            List<Jedinica_Mere> lista=Kontroler.getInstanca().listaJM();
            for (Jedinica_Mere jm : lista) {
                cmbJM.addItem(jm);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JComboBox cmbJM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtNazivArtikla;
    private javax.swing.JTextField txtTrenutnaCena;
    // End of variables declaration//GEN-END:variables

    private void insert() throws Exception {
        if(txtNazivArtikla.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Naziv artikla je obavezno polje!");
            return;
        }
        String naziv=txtNazivArtikla.getText();
        Jedinica_Mere jm=(Jedinica_Mere)cmbJM.getSelectedItem();
        double cena=Double.parseDouble(txtTrenutnaCena.getText());
        
        Artikal artikal=new Artikal(0, naziv, jm, cena);
        Kontroler.getInstanca().insertWithoutAutoincrement(artikal);
        
        JOptionPane.showMessageDialog(this, "Artikal je uspesno dodat");
        parent.refreshTbl();
        this.setVisible(false);
        dispose();
    }

    private void update() throws Exception {
        if(txtNazivArtikla.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Naziv artikla je obavezno polje!");
            return;
        }
        if(txtTrenutnaCena.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Cena je obavezno polje!");
            return;
        }
        String nazivU=txtNazivArtikla.getText();
        Jedinica_Mere jmU=(Jedinica_Mere)cmbJM.getSelectedItem();
        double cenaU=Double.parseDouble(txtTrenutnaCena.getText());
        
        Artikal art=new Artikal(a.getSifraArtikla(), nazivU, jmU, cenaU);
        
        if(cenaU!=a.getTrenutnaCena()){
            art.setCenaIzmenjena(true);
        }
        
        Kontroler.getInstanca().update(art);
        
        JOptionPane.showMessageDialog(this, "Artikal je uspesno izmenjen");
        parent.refreshTbl();
        this.setVisible(false);
        dispose();
    }
}