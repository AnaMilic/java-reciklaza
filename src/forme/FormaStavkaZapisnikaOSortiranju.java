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
import model.StavkaZapisnika;
import model.Zapisnik_o_Sortiranju;
import tabele.TabelaStavkeZapisnika;

/**
 *
 * @author Ana
 */
public class FormaStavkaZapisnikaOSortiranju extends javax.swing.JFrame {

    /**
     * Creates new form FormaStavkaZapisnikaOSortiranju
     */
    Zapisnik_o_Sortiranju z;
    public FormaStavkaZapisnikaOSortiranju(Zapisnik_o_Sortiranju z) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.z=z;
        popuniTabelu(z);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblStavka = new javax.swing.JTable();
        btnDodaj = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stavka zapisnika o sortiranju");

        tblStavka.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblStavka);

        btnDodaj.setText("Dodaj stavku");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni stavku");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi stavku");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDodaj)
                        .addGap(83, 83, 83)
                        .addComponent(btnIzmeni)
                        .addGap(88, 88, 88)
                        .addComponent(btnObrisi)
                        .addGap(0, 183, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnIzmeni)
                    .addComponent(btnObrisi))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        try {
            List<StavkaZapisnika> listaStavk=Kontroler.getInstanca().listaStavkiZapisnika(z);
            
            int brojStavke=0;
            for (StavkaZapisnika st : listaStavk) {
                brojStavke=Integer.max(0, st.getRedniBroj());
            }
            StavkaZapisnika sz=new StavkaZapisnika();
            FormaStavkaZapisnikaOSortiranjuDodaj fszd=new FormaStavkaZapisnikaOSortiranjuDodaj(this,true,sz,"INSERT",z,brojStavke);
            fszd.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(FormaZapisnikOSortiranju.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        if(tblStavka.getSelectedRow()<0){
            JOptionPane.showMessageDialog(this, "Potrebno je da izaberete stavku zapisnika koju zelite da izmenite", "Greska!", JOptionPane.ERROR_MESSAGE);
        }else{
            StavkaZapisnika sz=((TabelaStavkeZapisnika)tblStavka.getModel()).getSelectedObject(tblStavka.getSelectedRow());
            FormaStavkaZapisnikaOSortiranjuDodaj fszd=new FormaStavkaZapisnikaOSortiranjuDodaj(this,true,sz,"UPDATE",z,0);
            fszd.setVisible(true);
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        if(tblStavka.getSelectedRow()<0){
            JOptionPane.showMessageDialog(this, "Potrebno je da izaberete stavku zapisnika koju zelite da obrisete", "Greska!", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                StavkaZapisnika sz=((TabelaStavkeZapisnika)tblStavka.getModel()).getSelectedObject(tblStavka.getSelectedRow());
                Kontroler.getInstanca().delete(sz);
                JOptionPane.showMessageDialog(this, "Uspesno ste obrisali stavku zapisnika!");
                this.dispose();
                new FormaStavkaZapisnikaOSortiranju(z).setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Greska prilikom brisanja stavke zapisnika", "Greska!", JOptionPane.ERROR_MESSAGE);
            } 
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

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
            java.util.logging.Logger.getLogger(FormaStavkaZapisnikaOSortiranju.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaStavkaZapisnikaOSortiranju.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaStavkaZapisnikaOSortiranju.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaStavkaZapisnikaOSortiranju.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FormaStavkaZapisnikaOSortiranju().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStavka;
    // End of variables declaration//GEN-END:variables

    private void popuniTabelu(Zapisnik_o_Sortiranju z) {
        try {
            
            List<StavkaZapisnika> listaStavki=Kontroler.getInstanca().listaStavkiZapisnika(z);
            TabelaStavkeZapisnika tblSt=new TabelaStavkeZapisnika(listaStavki);
            tblStavka.setModel(tblSt);
            
        } catch (Exception ex) {
            Logger.getLogger(FormaArtikal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void refreshTbl(){
        List<StavkaZapisnika> shownZ=loadObjects();
        TabelaStavkeZapisnika tbl=(TabelaStavkeZapisnika) tblStavka.getModel();
        tbl.setList(shownZ);
        tbl.fireTableDataChanged();
    }

    private List<StavkaZapisnika> loadObjects() {
        try {
            return Kontroler.getInstanca().listaStavkiZapisnika(new Zapisnik_o_Sortiranju());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
