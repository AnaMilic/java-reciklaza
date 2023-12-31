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
import model.Dobavljac;
import model.Kupac;
import model.Prijemnica;
import model.Radnik;

/**
 *
 * @author Ana
 */
public class FormaPrijemnicaDodaj extends javax.swing.JFrame {

    /**
     * Creates new form FormaPrijemnicaDodaj
     */
    FormaPrijemnica parent;
    String operacija;
    Prijemnica p;
    int brojPrijemnice;
    public FormaPrijemnicaDodaj(FormaPrijemnica parent, boolean modal, Prijemnica p, String operacija, int brojPrijemnice) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.parent=parent;
        this.p=p;
        this.operacija=operacija;
        this.brojPrijemnice=brojPrijemnice;
        if(operacija.equals("UPDATE")){
            podesiPolja(p);
        }else if(operacija.equals("INSERT")){
            txtUkupanIznos.setEnabled(false);    
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDatum = new javax.swing.JTextField();
        txtOtprema = new javax.swing.JTextField();
        txtMesto = new javax.swing.JTextField();
        cmbDobavljac = new javax.swing.JComboBox();
        cmbKupac = new javax.swing.JComboBox();
        cmbRadnik = new javax.swing.JComboBox();
        btnSacuvaj = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtUkupanIznos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Prijemnica");

        jLabel1.setText("Datum izdavanja:");

        jLabel2.setText("Nacin otpreme:");

        jLabel3.setText("Mesto izdavanja:");

        jLabel4.setText("Dobavljac:");

        jLabel5.setText("Kupac:");

        jLabel6.setText("Radnik:");

        btnSacuvaj.setText("Sacuvaj prijemnicu");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        jLabel7.setText("Ukupan iznos:");

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
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOtprema)
                            .addComponent(txtMesto)
                            .addComponent(cmbDobavljac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbKupac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbRadnik, 0, 444, Short.MAX_VALUE)
                            .addComponent(txtUkupanIznos)
                            .addComponent(txtDatum)))
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
                    .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtOtprema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbDobavljac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbKupac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbRadnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtUkupanIznos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSacuvaj)
                .addContainerGap(27, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(FormaPrijemnicaDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaPrijemnicaDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaPrijemnicaDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaPrijemnicaDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FormaPrijemnicaDodaj().setVisible(true);
            }
        });
    }

    private void podesiPolja(Prijemnica p) {
        this.txtMesto.setText(p.getMestoIzdavanja());
        this.txtDatum.setText(String.valueOf(p.getDatumIzdavanja()));
        this.txtOtprema.setText(p.getNacinOtpreme());
        this.cmbRadnik.setSelectedItem(p.getRadnik().getRadnikID());
        this.cmbDobavljac.setSelectedItem(p.getDobavljac().getMaticniBrojDobavljaca());
        this.cmbKupac.setSelectedItem(p.getKupac().getMaticniBrojKupca());
        this.txtUkupanIznos.setText(String.valueOf(p.getIznosUkupno()));
    }

    private void popuniCmb() {
        try {
            cmbRadnik.removeAllItems();
            List<Radnik> listaRAdnika=Kontroler.getInstanca().listaRadnika();
            for (Radnik r : listaRAdnika) {
                cmbRadnik.addItem(r);
            }
            
            cmbDobavljac.removeAllItems();
            List<Dobavljac> listaDob=Kontroler.getInstanca().listaDobavljaca();
            for (Dobavljac d : listaDob) {
                cmbDobavljac.addItem(d);
            }
            
            cmbKupac.removeAllItems();
            List<Kupac> listaKup=Kontroler.getInstanca().listaKupaca();
            for (Kupac k : listaKup) {
                cmbKupac.addItem(k);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ex.getMessage();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbDobavljac;
    private javax.swing.JComboBox cmbKupac;
    private javax.swing.JComboBox cmbRadnik;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtDatum;
    private javax.swing.JTextField txtMesto;
    private javax.swing.JTextField txtOtprema;
    private javax.swing.JTextField txtUkupanIznos;
    // End of variables declaration//GEN-END:variables

    private void insert() throws Exception {
        if(txtDatum.getText().isEmpty()||txtMesto.getText().isEmpty()||txtOtprema.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Sva polja su obavezna i moraju biti popunjena!");
            return;
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String d=txtDatum.getText();
        Date dtm=new Date();
        try {
            dtm=sdf.parse(d);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Greska pri parsiranju datuma! Datum mora biti u formatu yyyy-MM-dd.");
        }
        String mst=txtMesto.getText();
        String otpr=txtOtprema.getText();
        Radnik rad=(Radnik) cmbRadnik.getSelectedItem();
        Dobavljac dob=(Dobavljac) cmbDobavljac.getSelectedItem();
        Kupac kup=(Kupac) cmbKupac.getSelectedItem();
        
        int brPrij=brojPrijemnice+1;
        
        Prijemnica prij=new Prijemnica(brPrij, dtm, otpr, mst, dob, kup, rad, 0);
        Kontroler.getInstanca().insertWithAutoincrement(prij);
        JOptionPane.showMessageDialog(this, "Prijemnica je uspesno dodata");
        parent.refreshTbl();
        this.setVisible(false);
        dispose();
    }

    private void update() throws Exception {
        if(txtDatum.getText().isEmpty()||txtMesto.getText().isEmpty()||txtOtprema.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Sva polja su obavezna i moraju biti popunjena!");
            return;
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String d=txtDatum.getText();
        Date dtm=new Date();
        try {
            dtm=sdf.parse(d);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Greska pri parsiranju datuma! Datum mora biti u formatu yyyy-MM-dd.");
        }
        String mst=txtMesto.getText();
        String otpr=txtOtprema.getText();
        Radnik rad=(Radnik) cmbRadnik.getSelectedItem();
        Dobavljac dob=(Dobavljac) cmbDobavljac.getSelectedItem();
        Kupac kup=(Kupac) cmbKupac.getSelectedItem();
        
        double ukIznos=Double.parseDouble(txtUkupanIznos.getText());
        
        
        Prijemnica prij=new Prijemnica(p.getBrojPrijemnice(), dtm, otpr, mst, dob, kup, rad, ukIznos);
        
        if(ukIznos!=p.getIznosUkupno()){
            prij.setIznosUkupnoIzmenjen(true);
        }
        
        Kontroler.getInstanca().update(prij);
        JOptionPane.showMessageDialog(this, "Prijemnica je uspesno izmenjena");
        parent.refreshTbl();
        this.setVisible(false);
        dispose();
    }
}
