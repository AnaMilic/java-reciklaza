/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logika.Kontroler;
import model.Artikal;
import model.Knjizno_Zaduzenje;
import model.StavkaKnjiznogZaduzenja;

/**
 *
 * @author Ana
 */
public class FormaStavkaKnjiznogZaduzenjaDodaj extends javax.swing.JFrame {

    /**
     * Creates new form StavkaKnjiznogZaduzenjaDodaj
     */
    FormaStavkaKnjiznogZaduzenja parent;
    String operacija;
    Knjizno_Zaduzenje kz;
    StavkaKnjiznogZaduzenja skz;
    int brojStavke;
    public FormaStavkaKnjiznogZaduzenjaDodaj(FormaStavkaKnjiznogZaduzenja parent, boolean modal, StavkaKnjiznogZaduzenja skz, String operacija, Knjizno_Zaduzenje kz, int brojStavke) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.parent=parent;
        this.skz=skz;
        this.operacija=operacija;
        this.kz=kz;
        this.brojStavke=brojStavke;
        if(operacija.equals("UPDATE")){
            podesiPolja(skz);
            txtBrojZaduzenja.setText(String.valueOf(skz.getBrojZaduzenja().getBrojZaduzenja()));
            txtBrojZaduzenja.setEnabled(false);
            
            txtRedniBroj.setEnabled(false);
        }else if(operacija.equals("INSERT")){
            txtBrojZaduzenja.setText(String.valueOf(kz.getBrojZaduzenja()));
            txtBrojZaduzenja.setEnabled(false);
            int brSt=brojStavke+1;
            txtRedniBroj.setText(String.valueOf(brSt));
            txtRedniBroj.setEnabled(false);
            
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
        jLabel4 = new javax.swing.JLabel();
        txtBrojZaduzenja = new javax.swing.JTextField();
        txtRedniBroj = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSadrzaj = new javax.swing.JTextArea();
        cmbArtikal = new javax.swing.JComboBox();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stavka knjiznog zaduzenja");

        jLabel1.setText("Broj zaduzenja:");

        jLabel2.setText("Redni broj:");

        jLabel3.setText("Sadrzaj:");

        jLabel4.setText("Artikal:");

        txtSadrzaj.setColumns(20);
        txtSadrzaj.setRows(5);
        jScrollPane1.setViewportView(txtSadrzaj);

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
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBrojZaduzenja)
                            .addComponent(txtRedniBroj)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                            .addComponent(cmbArtikal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSacuvaj)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBrojZaduzenja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRedniBroj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbArtikal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnSacuvaj)
                .addGap(35, 35, 35))
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
            java.util.logging.Logger.getLogger(FormaStavkaKnjiznogZaduzenjaDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaStavkaKnjiznogZaduzenjaDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaStavkaKnjiznogZaduzenjaDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaStavkaKnjiznogZaduzenjaDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FormaStavkaKnjiznogZaduzenjaDodaj().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbArtikal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBrojZaduzenja;
    private javax.swing.JTextField txtRedniBroj;
    private javax.swing.JTextArea txtSadrzaj;
    // End of variables declaration//GEN-END:variables

    private void podesiPolja(StavkaKnjiznogZaduzenja skz) {
        
        txtSadrzaj.setText(skz.getSadrzaj());
        cmbArtikal.setSelectedItem(skz.getArtikal());
        txtRedniBroj.setText(String.valueOf(skz.getRedniBroj()));
    }

    private void popuniCmb() {
        try {
            cmbArtikal.removeAllItems();
            List<Artikal> listaArt=Kontroler.getInstanca().listaArtikala();
            for (Artikal a : listaArt) {
                cmbArtikal.addItem(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
    }

    private void insert() throws Exception {
        String redniBr=txtRedniBroj.getText();
        int rb=Integer.parseInt(redniBr);
        
        String sadr="";
        if(!txtSadrzaj.getText().isEmpty()){
            sadr=txtSadrzaj.getText();
        }
        
        Artikal art=(Artikal) cmbArtikal.getSelectedItem();
        
        StavkaKnjiznogZaduzenja st=new StavkaKnjiznogZaduzenja(kz.getDobavljac(), kz.getKupac(), kz, rb, sadr, art);
        Kontroler.getInstanca().insertWithAutoincrement(st);
        JOptionPane.showMessageDialog(this, "Stavka knjiznog zaduzenja je uspesno dodata");
        
        this.dispose();
        parent.dispose();
        new FormaStavkaKnjiznogZaduzenja(kz).setVisible(true);
    }

    private void update() throws Exception {
        String redniBr=txtRedniBroj.getText();
        int rb=Integer.parseInt(redniBr);
        
        String sadr="";
        if(!txtSadrzaj.getText().isEmpty()){
            sadr=txtSadrzaj.getText();
        }
        
        Artikal art=(Artikal) cmbArtikal.getSelectedItem();
        
        StavkaKnjiznogZaduzenja st=new StavkaKnjiznogZaduzenja(kz.getDobavljac(), kz.getKupac(), kz, rb, sadr, art);
        Kontroler.getInstanca().update(st);
        JOptionPane.showMessageDialog(this, "Stavka knjiznog zaduzenja je uspesno izmenjena");
        
        this.dispose();
        parent.dispose();
        new FormaStavkaKnjiznogZaduzenja(kz).setVisible(true);
    }
}
