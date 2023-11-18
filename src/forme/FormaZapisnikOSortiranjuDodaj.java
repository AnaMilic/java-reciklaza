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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logika.Kontroler;
import model.Radnik;
import model.Zapisnik_o_Sortiranju;

/**
 *
 * @author Ana
 */
public class FormaZapisnikOSortiranjuDodaj extends javax.swing.JFrame {

    /**
     * Creates new form FormaZapisnikOSortiranjuDodaj
     */
    FormaZapisnikOSortiranju parent;
    String operacija;
    Zapisnik_o_Sortiranju zap;
    int brojZapisnika;
    public FormaZapisnikOSortiranjuDodaj(FormaZapisnikOSortiranju parent, boolean modal, Zapisnik_o_Sortiranju zap, String operacija, int brojZapisnika) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.zap=zap;
        this.parent=parent;
        this.operacija=operacija;
        this.brojZapisnika=brojZapisnika;
        if(operacija.equals("UPDATE")){
            podesiPolja(zap);
            
        }else if(operacija.equals("INSERT")){
            txtImePrezimeRadnik.setEnabled(false);
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
        txtMesto = new javax.swing.JTextField();
        txtDatum = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNapomena = new javax.swing.JTextArea();
        cmbRadnik = new javax.swing.JComboBox();
        btnSacuvaj = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtImePrezimeRadnik = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Zapisnik o sortiranju");

        jLabel1.setText("Mesto:");

        jLabel2.setText("Datum:");

        jLabel3.setText("Napomena:");

        jLabel4.setText("Radnik:");

        txtNapomena.setColumns(20);
        txtNapomena.setRows(5);
        jScrollPane1.setViewportView(txtNapomena);

        btnSacuvaj.setText("Sacuvaj zapisnik");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        jLabel6.setText("Ime i prezime:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnSacuvaj)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(31, 31, 31)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtMesto)
                                        .addComponent(txtDatum)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtImePrezimeRadnik)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(43, 43, 43)
                        .addComponent(cmbRadnik, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtImePrezimeRadnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbRadnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addComponent(btnSacuvaj)
                .addContainerGap())
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
            java.util.logging.Logger.getLogger(FormaZapisnikOSortiranjuDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaZapisnikOSortiranjuDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaZapisnikOSortiranjuDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaZapisnikOSortiranjuDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FormaZapisnikOSortiranjuDodaj().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbRadnik;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDatum;
    private javax.swing.JTextField txtImePrezimeRadnik;
    private javax.swing.JTextField txtMesto;
    private javax.swing.JTextArea txtNapomena;
    // End of variables declaration//GEN-END:variables

    private void podesiPolja(Zapisnik_o_Sortiranju zap) {
        this.txtMesto.setText(zap.getMesto());
        this.txtDatum.setText(String.valueOf(zap.getDatum()));
        this.txtNapomena.setText(zap.getNapomena());
        this.cmbRadnik.setSelectedItem(zap.getRadnik().getRadnikID());
        
        
        this.txtImePrezimeRadnik.setText(zap.getImePrezime());
    }

    private void popuniCmb() {
        try {
            cmbRadnik.removeAllItems();
            List<Radnik> listaRAdnika=Kontroler.getInstanca().listaRadnika();
            for (Radnik r : listaRAdnika) {
                cmbRadnik.addItem(r);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
    }

    private void insert() throws Exception {
        if(txtDatum.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Datum je obavezno polje!");
            return;
        }
        if(txtMesto.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Mesto je obavezno polje!");
            return;
        }
        
        String mesto=txtMesto.getText();
        
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String d=txtDatum.getText();
        Date dtm=new Date();
        try {
            dtm=sdf.parse(d);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Greska pri parsiranju datuma! Datum mora biti u formatu yyyy-MM-dd.");
        }
        
        String napomena=txtNapomena.getText();
        Radnik rad=(Radnik) cmbRadnik.getSelectedItem();
        
        int brZap=brojZapisnika+1;
        
        Zapisnik_o_Sortiranju zapOSort=new Zapisnik_o_Sortiranju(brZap, mesto, dtm, napomena, "", rad);
        Kontroler.getInstanca().insertWithAutoincrement(zapOSort);
        JOptionPane.showMessageDialog(this, "Zapisnik o sortiranju je uspesno dodat");
        parent.refreshTbl();
        this.setVisible(false);
        dispose();
    }

    private void update() throws Exception {
        if(txtDatum.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Datum je obavezno polje!");
            return;
        }
        if(txtMesto.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Mesto je obavezno polje!");
            return;
        }
        String mesto=txtMesto.getText();
        
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String d=txtDatum.getText();
        Date dtm=new Date();
        try {
            dtm=sdf.parse(d);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Greska pri parsiranju datuma! Datum mora biti u formatu yyyy-MM-dd.");
        }
        
        String napomena=txtNapomena.getText();
        Radnik rad=(Radnik) cmbRadnik.getSelectedItem();
        
        String imPr=txtImePrezimeRadnik.getText();
        
        Zapisnik_o_Sortiranju zapOSort=new Zapisnik_o_Sortiranju(zap.getZapisnikID(), mesto, dtm, napomena, imPr, rad);
        if(!imPr.equalsIgnoreCase(zap.getImePrezime())){
            zapOSort.setImePrezimeIzmenjeno(true);
        }
        
        Kontroler.getInstanca().update(zapOSort);
        JOptionPane.showMessageDialog(this, "Zapisnik o sortiranju je uspesno izmenjen");
        parent.refreshTbl();
        this.setVisible(false);
        dispose();
    }
}
