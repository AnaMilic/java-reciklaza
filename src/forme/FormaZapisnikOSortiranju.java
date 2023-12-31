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
import model.Zapisnik_o_Sortiranju;
import tabele.TabelaZapisnikOSortiranju;

/**
 *
 * @author Ana
 */
public class FormaZapisnikOSortiranju extends javax.swing.JFrame {

    /**
     * Creates new form FormaZapisnikOSortiranju
     */
    public FormaZapisnikOSortiranju() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        popuniTabelu();
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
        tblZapisnik = new javax.swing.JTable();
        btnDodaj = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnStavke = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Zapisnik o sortiranju");

        tblZapisnik.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblZapisnik);

        btnDodaj.setText("Dodaj zapisnik");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni zapisnik");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi zapisnik");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnStavke.setText("Pregled stavki");
        btnStavke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStavkeActionPerformed(evt);
            }
        });

        jButton1.setText("Ponovo ucitaj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addGap(76, 76, 76)
                        .addComponent(btnIzmeni)
                        .addGap(73, 73, 73)
                        .addComponent(btnObrisi)
                        .addGap(75, 75, 75)
                        .addComponent(btnStavke)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnIzmeni)
                    .addComponent(btnObrisi)
                    .addComponent(btnStavke)
                    .addComponent(jButton1))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        
        try {
            List<Zapisnik_o_Sortiranju> listaZap=Kontroler.getInstanca().listaZapisnika();
            
            int brojZapisnika=1;
            for (Zapisnik_o_Sortiranju zs : listaZap) {
                brojZapisnika=Integer.max(1, zs.getZapisnikID());
            }
            
            Zapisnik_o_Sortiranju zap=new Zapisnik_o_Sortiranju();
            FormaZapisnikOSortiranjuDodaj fzd=new FormaZapisnikOSortiranjuDodaj(this,true,zap,"INSERT",brojZapisnika);
            fzd.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(FormaZapisnikOSortiranju.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        if(tblZapisnik.getSelectedRow()<0){
            JOptionPane.showMessageDialog(this, "Potrebno je da izaberete zapisnik koji zelite da izmenite", "Greska!", JOptionPane.ERROR_MESSAGE);
        }else{
            Zapisnik_o_Sortiranju zap=((TabelaZapisnikOSortiranju)tblZapisnik.getModel()).getSelectedObject(tblZapisnik.getSelectedRow());
            FormaZapisnikOSortiranjuDodaj fzd=new FormaZapisnikOSortiranjuDodaj(this,true,zap,"UPDATE",0);
            fzd.setVisible(true);
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        if(tblZapisnik.getSelectedRow()<0){
            JOptionPane.showMessageDialog(this, "Potrebno je da izaberete zapisnik koji zelite da obrisete", "Greska!", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                Zapisnik_o_Sortiranju z=((TabelaZapisnikOSortiranju)tblZapisnik.getModel()).getSelectedObject(tblZapisnik.getSelectedRow());
                Kontroler.getInstanca().delete(z);
                JOptionPane.showMessageDialog(this, "Uspesno ste obrisali zapisnik!");
                refreshTbl();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Greska prilikom brisanja zapisnika", "Greska!", JOptionPane.ERROR_MESSAGE);
            } 
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnStavkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStavkeActionPerformed
        if(tblZapisnik.getSelectedRow()<0){
            JOptionPane.showMessageDialog(this, "Potrebno je da izaberete zapisnik za koji zelite da vidite stavke", "Greska!", JOptionPane.ERROR_MESSAGE);
        }else{
            Zapisnik_o_Sortiranju z=((TabelaZapisnikOSortiranju)tblZapisnik.getModel()).getSelectedObject(tblZapisnik.getSelectedRow());
            FormaStavkaZapisnikaOSortiranju fsz=new FormaStavkaZapisnikaOSortiranju(z);
            fsz.setVisible(true);
            
        }
        
        
    }//GEN-LAST:event_btnStavkeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        refreshTbl();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormaZapisnikOSortiranju.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaZapisnikOSortiranju.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaZapisnikOSortiranju.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaZapisnikOSortiranju.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormaZapisnikOSortiranju().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnStavke;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblZapisnik;
    // End of variables declaration//GEN-END:variables

    private void popuniTabelu() {
        try {
            List<Zapisnik_o_Sortiranju> listaZapisnika=Kontroler.getInstanca().listaZapisnika();
            TabelaZapisnikOSortiranju tblZap=new TabelaZapisnikOSortiranju(listaZapisnika);
            tblZapisnik.setModel(tblZap);
        } catch (Exception ex) {
            Logger.getLogger(FormaArtikal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void refreshTbl(){
        List<Zapisnik_o_Sortiranju> shownZ=loadObjects();
        TabelaZapisnikOSortiranju tbl=(TabelaZapisnikOSortiranju) tblZapisnik.getModel();
        tbl.setList(shownZ);
        tbl.fireTableDataChanged();
    }

    private List<Zapisnik_o_Sortiranju> loadObjects() {
        try {
            return Kontroler.getInstanca().listaZapisnika();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
