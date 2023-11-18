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
import model.Radnik;
import tabele.TabelaRadnik;

/**
 *
 * @author Ana
 */
public class FormaRadnik extends javax.swing.JFrame {

    /**
     * Creates new form FormaRadnik
     */
    public FormaRadnik() {
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
        tblRadnik = new javax.swing.JTable();
        btnDodaj = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Radnik");

        tblRadnik.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblRadnik);

        btnDodaj.setText("Dodaj radnika");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni radnika");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi radnika");
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
                        .addGap(72, 72, 72)
                        .addComponent(btnIzmeni)
                        .addGap(73, 73, 73)
                        .addComponent(btnObrisi)
                        .addGap(0, 105, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnIzmeni)
                    .addComponent(btnObrisi))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        
        try {
            List<Radnik> listaRdn=Kontroler.getInstanca().listaRadnika();
            
            int brojRadnika=1;
            for (Radnik rd : listaRdn) {
                brojRadnika=Integer.max(1, rd.getRadnikID());
            }
            
            
            Radnik r=new Radnik();
            FormaRadnikDodaj frd=new FormaRadnikDodaj(this,true,r,"INSERT",brojRadnika);
            frd.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(FormaRadnik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        if(tblRadnik.getSelectedRow()<0){
            JOptionPane.showMessageDialog(this, "Potrebno je da izaberete radnika kog zelite da izmenite", "Greska!", JOptionPane.ERROR_MESSAGE);
        }else{
            Radnik r=((TabelaRadnik)tblRadnik.getModel()).getSelectedObject(tblRadnik.getSelectedRow());
            FormaRadnikDodaj frd=new FormaRadnikDodaj(this,true,r,"UPDATE",0);
        frd.setVisible(true);
        } 
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        if(tblRadnik.getSelectedRow()<0){
            JOptionPane.showMessageDialog(this, "Potrebno je da izaberete radnika kog zelite da obrisete", "Greska!", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                Radnik r=((TabelaRadnik)tblRadnik.getModel()).getSelectedObject(tblRadnik.getSelectedRow());
                Kontroler.getInstanca().delete(r);
                JOptionPane.showMessageDialog(this, "Uspesno ste obrisali radnika!");
                refreshTbl();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Greska prilikom brisanja radnika", "Greska!", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(FormaRadnik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaRadnik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaRadnik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaRadnik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormaRadnik().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRadnik;
    // End of variables declaration//GEN-END:variables

    private void popuniTabelu() {
        try {
            List<Radnik> listaRadnika=Kontroler.getInstanca().listaRadnika();
            TabelaRadnik tblRdn=new TabelaRadnik(listaRadnika);
            tblRadnik.setModel(tblRdn);
        } catch (Exception ex) {
            Logger.getLogger(FormaArtikal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void refreshTbl(){
        List<Radnik> shownR=loadObjects();
        TabelaRadnik tbl=(TabelaRadnik) tblRadnik.getModel();
        tbl.setList(shownR);
        tbl.fireTableDataChanged();
    }

    private List<Radnik> loadObjects() {
        try {
            return Kontroler.getInstanca().listaRadnika();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
