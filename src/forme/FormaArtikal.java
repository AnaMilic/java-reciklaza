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
import tabele.TabelaArtikal;

/**
 *
 * @author Ana
 */
public class FormaArtikal extends javax.swing.JFrame {

    /**
     * Creates new form FormaArtikal
     */
    public FormaArtikal() {
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
        tblArtikal = new javax.swing.JTable();
        btnDodaj = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Artikal");

        tblArtikal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblArtikal);

        btnDodaj.setText("Dodaj artikal");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni artikal");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi artikal");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDodaj)
                        .addGap(46, 46, 46)
                        .addComponent(btnIzmeni)
                        .addGap(45, 45, 45)
                        .addComponent(btnObrisi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnIzmeni)
                    .addComponent(btnObrisi)
                    .addComponent(jButton1))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        Artikal a=new Artikal();
        FormaArtikalDodaj fad=new FormaArtikalDodaj(this,true,a,"INSERT");
        fad.setVisible(true);
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        if(tblArtikal.getSelectedRow()<0){
            JOptionPane.showMessageDialog(this, "Potrebno je da izaberete artikal koji zelite da izmenite", "Greska!", JOptionPane.ERROR_MESSAGE);
        }else{
            Artikal a=((TabelaArtikal)tblArtikal.getModel()).getSelectedObject(tblArtikal.getSelectedRow());
            FormaArtikalDodaj fad=new FormaArtikalDodaj(this, true, a, "UPDATE");
            fad.setVisible(true);
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        if(tblArtikal.getSelectedRow()<0){
            JOptionPane.showMessageDialog(this, "Potrebno je da izaberete artikal koji zelite da obrisete", "Greska!", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                Artikal a=((TabelaArtikal)tblArtikal.getModel()).getSelectedObject(tblArtikal.getSelectedRow());
                Kontroler.getInstanca().delete(a);
                JOptionPane.showMessageDialog(this, "Uspesno ste obrisali artikal!");
                refreshTbl();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Greska prilikom brisanja artikla", "Greska!", JOptionPane.ERROR_MESSAGE);
            } 
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

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
            java.util.logging.Logger.getLogger(FormaArtikal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaArtikal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaArtikal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaArtikal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormaArtikal().setVisible(true);
            }
        });
    }

    private void popuniTabelu() {
        try {
            List<Artikal> listaArtikala=Kontroler.getInstanca().listaArtikala();
            TabelaArtikal tblArt=new TabelaArtikal(listaArtikala);
            tblArtikal.setModel(tblArt);
        } catch (Exception ex) {
            Logger.getLogger(FormaArtikal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void refreshTbl(){
        List<Artikal> shownA=loadObjects();
        TabelaArtikal tbl=(TabelaArtikal) tblArtikal.getModel();
        tbl.setList(shownA);
        tbl.fireTableDataChanged();
    }

    private List<Artikal> loadObjects() {
        try {
            return Kontroler.getInstanca().listaArtikala();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblArtikal;
    // End of variables declaration//GEN-END:variables
}