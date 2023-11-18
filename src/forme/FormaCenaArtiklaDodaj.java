/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.DocFlavor;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logika.Kontroler;
import model.Artikal;
import model.Cena_Artikla;


/**
 *
 * @author Ana
 */
public class FormaCenaArtiklaDodaj extends javax.swing.JFrame {

    /**
     * Creates new form FormaCenaArtiklaDodaj
     */
    FormaCenaArtikla parent;
    Cena_Artikla ca;
    String operacija;
    
    public FormaCenaArtiklaDodaj(FormaCenaArtikla parent, boolean modal, Cena_Artikla ca, String operacija) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.parent=parent;
        this.ca=ca;
        this.operacija=operacija;
        
        if(operacija.equals("UPDATE")){
            podesiPolja(ca);
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
        jLabel3 = new javax.swing.JLabel();
        cmbArtikal = new javax.swing.JComboBox();
        txtDatumOd = new javax.swing.JFormattedTextField();
        txtCena = new javax.swing.JTextField();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cena artikla");

        jLabel1.setText("Artikal");

        jLabel2.setText("Datum od");

        jLabel3.setText("Cena");

        txtDatumOd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        btnSacuvaj.setText("Sacuvaj");
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDatumOd)
                            .addComponent(txtCena)
                            .addComponent(cmbArtikal, 0, 373, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSacuvaj)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbArtikal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSacuvaj)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(FormaCenaArtiklaDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaCenaArtiklaDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaCenaArtiklaDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaCenaArtiklaDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FormaCenaArtiklaDodaj().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbArtikal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtCena;
    private javax.swing.JFormattedTextField txtDatumOd;
    // End of variables declaration//GEN-END:variables

    private void podesiPolja(Cena_Artikla ca) {
        this.cmbArtikal.setSelectedItem(ca.getArtikal());
        System.out.println(cmbArtikal.getSelectedItem());
        this.cmbArtikal.setEnabled(false);
        this.txtDatumOd.setText(String.valueOf(ca.getDatumOd()));
        this.txtDatumOd.setEnabled(false);
        this.txtCena.setText(String.valueOf(ca.getIznosCene()));
    }

    private void popuniCmb() {
        try {
            cmbArtikal.removeAllItems();
            List<Artikal> listaArt=Kontroler.getInstanca().listaArtikala();
            for (Artikal artikal : listaArt) {
                cmbArtikal.addItem(artikal);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void insert() throws Exception {
       
        try {
           if(txtCena.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Cena je obavezno polje!");
        }
        if(txtDatumOd.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Datum od je obavezno polje!");
        }
        double cena=Double.parseDouble(txtCena.getText());
        
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String datOd=txtDatumOd.getText();
        Date datumOd=new Date();
        try {
            datumOd=sdf.parse(datOd);
        } catch (ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Datum mora biti u formatu yyyy-MM-dd!");
        }
        
        Artikal art=(Artikal) cmbArtikal.getSelectedItem();
        Cena_Artikla cenaArt=new Cena_Artikla(art, datumOd, cena);
        Kontroler.getInstanca().insertWithAutoincrement(cenaArt);
        JOptionPane.showMessageDialog(this, "Cena je uspesno dodata");
        parent.refreshTbl();
        this.setVisible(false);
        dispose(); 
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        
        
        
    }

    private void update() throws Exception {
        
        System.out.println("Kliknutooooooo");
        
        double cena=Double.parseDouble(txtCena.getText());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String datOd=txtDatumOd.getText();
        Date dtm=new Date();
        try {
            dtm=sdf.parse(datOd);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Datum mora biti u formatu yyyy-MM-dd!");
            ex.getMessage();
            ex.printStackTrace();
            return;
        }
        
        Cena_Artikla cenaArt=new Cena_Artikla(ca.getArtikal(), dtm, cena);
        Kontroler.getInstanca().update(cenaArt);
        JOptionPane.showMessageDialog(this, "Cena je uspesno izmenjena");
        parent.refreshTbl();
        this.setVisible(false);
        dispose();
        
    }
}
