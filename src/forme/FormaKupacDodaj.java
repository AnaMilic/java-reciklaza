/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logika.Kontroler;
import model.Kupac;

/**
 *
 * @author Ana
 */
public class FormaKupacDodaj extends javax.swing.JFrame {

    /**
     * Creates new form FormaKupacDodaj
     */
    FormaKupac parent;
    Kupac k;
    String operacija;
    public FormaKupacDodaj(FormaKupac parent, boolean modal, Kupac k, String operacija) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.parent=parent;
        this.k=k;
        this.operacija=operacija;
        if(operacija.equals("UPDATE")){
            podesiPolja(k);
            txtMB.setEnabled(false);
        }
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
        jLabel7 = new javax.swing.JLabel();
        txtMB = new javax.swing.JTextField();
        txtPIB = new javax.swing.JTextField();
        txtNaziv = new javax.swing.JTextField();
        txtMesto = new javax.swing.JTextField();
        txtAdresa = new javax.swing.JTextField();
        txtTelefon = new javax.swing.JTextField();
        txtZiroRacun = new javax.swing.JTextField();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kupac");

        jLabel1.setText("Maticni broj kupca:");

        jLabel2.setText("PIB kupca:");

        jLabel3.setText("Naziv kupca:");

        jLabel4.setText("Mesto:");

        jLabel5.setText("Adresa:");

        jLabel6.setText("Telefon:");

        jLabel7.setText("Ziro racun:");

        btnSacuvaj.setText("Sacuvaj kupca");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSacuvaj)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMB)
                            .addComponent(txtPIB)
                            .addComponent(txtNaziv)
                            .addComponent(txtMesto)
                            .addComponent(txtAdresa)
                            .addComponent(txtTelefon)
                            .addComponent(txtZiroRacun, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtPIB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtZiroRacun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnSacuvaj)
                .addContainerGap(34, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(FormaKupacDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaKupacDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaKupacDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaKupacDodaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FormaKupacDodaj().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtAdresa;
    private javax.swing.JTextField txtMB;
    private javax.swing.JTextField txtMesto;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtPIB;
    private javax.swing.JTextField txtTelefon;
    private javax.swing.JTextField txtZiroRacun;
    // End of variables declaration//GEN-END:variables

    private void podesiPolja(Kupac k) {
       this.txtMB.setText(String.valueOf(k.getMaticniBrojKupca()));
       this.txtPIB.setText(String.valueOf(k.getPibKupca()));
       this.txtNaziv.setText(k.getNazivKupca());
       this.txtMesto.setText(k.getMestoKupca());
       this.txtAdresa.setText(k.getAdresaKupca());
       this.txtTelefon.setText(k.getTelefon());
       this.txtZiroRacun.setText(String.valueOf(k.getZiroRacun()));
    }

    private void insert() throws Exception {
        if(txtMB.getText().isEmpty() || txtPIB.getText().isEmpty() || txtNaziv.getText().isEmpty() || txtMesto.getText().isEmpty() || txtAdresa.getText().isEmpty() || txtTelefon.getText().isEmpty() || txtZiroRacun.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Sva polja su obavezna i moraju biti popunjena!");
            return;
        }
        
        int maticniBroj=Integer.parseInt(txtMB.getText());
        int pib=Integer.parseInt(txtPIB.getText());
        String naziv=txtNaziv.getText();
        String mesto=txtMesto.getText();
        String adresa=txtAdresa.getText();
        String telefon=txtTelefon.getText();
        long ziroRacun=Long.parseLong(txtZiroRacun.getText());
        
        Kupac kup=new Kupac(maticniBroj, pib, naziv, mesto, adresa, telefon, ziroRacun);
        Kontroler.getInstanca().insertWithAutoincrement(kup);
        
        JOptionPane.showMessageDialog(this, "Kupac je uspesno dodat");
        parent.refreshTbl();
        this.setVisible(false);
        dispose();
    }

    private void update() throws Exception {
        if(txtMB.getText().isEmpty() || txtPIB.getText().isEmpty() || txtNaziv.getText().isEmpty() || txtMesto.getText().isEmpty() || txtAdresa.getText().isEmpty() || txtTelefon.getText().isEmpty() || txtZiroRacun.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Sva polja su obavezna i moraju biti popunjena!");
            return;
        }
        
        int maticniBroj=Integer.parseInt(txtMB.getText());
        int pib=Integer.parseInt(txtPIB.getText());
        String naziv=txtNaziv.getText();
        String mesto=txtMesto.getText();
        String adresa=txtAdresa.getText();
        String telefon=txtTelefon.getText();
        long ziroRacun=Long.parseLong(txtZiroRacun.getText());
        
        Kupac kup=new Kupac(maticniBroj, pib, naziv, mesto, adresa, telefon, ziroRacun);
        Kontroler.getInstanca().update(kup);
        
        JOptionPane.showMessageDialog(this, "Kupac je uspesno izmenjen");
        parent.refreshTbl();
        this.setVisible(false);
        dispose();
    }
}
