
package ekran;

import Nesneler.VeriTabani;
import Nesneler.Yemek;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Cruz
 */
public class YemekEkran extends javax.swing.JFrame {
static ArrayList<Yemek> yemekler = null;
 
 public YemekEkran() {
  initComponents();
  yemekGoster();
 }


 @SuppressWarnings("unchecked")
 // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
 private void initComponents() {

  jLabel1 = new javax.swing.JLabel();
  jLabel2 = new javax.swing.JLabel();
  jLabel3 = new javax.swing.JLabel();
  jScrollPane1 = new javax.swing.JScrollPane();
  textYemekBilgisi = new javax.swing.JTextArea();
  jLabel4 = new javax.swing.JLabel();
  butonKapat = new javax.swing.JButton();
  labelYemekAdi = new javax.swing.JLabel();
  labelYemekTuru = new javax.swing.JLabel();
  labelYemekFiyat = new javax.swing.JLabel();

  setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
  setTitle("Yemek Bilgileri Sayfası");
  setResizable(false);

  jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
  jLabel1.setText("Yemek Adı     :");

  jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
  jLabel2.setText("Yemek Türü   :");

  jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
  jLabel3.setText("Yemek Bilgisi");

  textYemekBilgisi.setColumns(20);
  textYemekBilgisi.setRows(5);
  textYemekBilgisi.setEnabled(false);
  jScrollPane1.setViewportView(textYemekBilgisi);

  jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
  jLabel4.setText("Yemek Fiyatı :");

  butonKapat.setText("Kapat");
  butonKapat.addActionListener(new java.awt.event.ActionListener() {
   public void actionPerformed(java.awt.event.ActionEvent evt) {
    butonKapatActionPerformed(evt);
   }
  });

  labelYemekAdi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
  labelYemekAdi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
  labelYemekAdi.setText("jLabel5");

  labelYemekTuru.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
  labelYemekTuru.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
  labelYemekTuru.setText("jLabel5");

  labelYemekFiyat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
  labelYemekFiyat.setText("jLabel5");

  javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
  getContentPane().setLayout(layout);
  layout.setHorizontalGroup(
   layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
   .addGroup(layout.createSequentialGroup()
    .addGap(25, 25, 25)
    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
     .addGroup(layout.createSequentialGroup()
      .addComponent(jLabel2)
      .addGap(18, 18, 18)
      .addComponent(labelYemekTuru))
     .addGroup(layout.createSequentialGroup()
      .addComponent(jLabel1)
      .addGap(18, 18, 18)
      .addComponent(labelYemekAdi))
     .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
     .addGroup(layout.createSequentialGroup()
      .addComponent(jLabel4)
      .addGap(41, 41, 41)
      .addComponent(labelYemekFiyat)))
    .addContainerGap(25, Short.MAX_VALUE))
   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
    .addGap(0, 0, Short.MAX_VALUE)
    .addComponent(butonKapat, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
   .addGroup(layout.createSequentialGroup()
    .addGap(94, 94, 94)
    .addComponent(jLabel3)
    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
  );
  layout.setVerticalGroup(
   layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
   .addGroup(layout.createSequentialGroup()
    .addContainerGap()
    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
     .addComponent(jLabel1)
     .addComponent(labelYemekAdi))
    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
     .addComponent(jLabel2)
     .addComponent(labelYemekTuru))
    .addGap(18, 18, 18)
    .addComponent(jLabel3)
    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
    .addGap(18, 18, 18)
    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
     .addComponent(jLabel4)
     .addComponent(labelYemekFiyat))
    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
    .addComponent(butonKapat)
    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
  );

  pack();
  setLocationRelativeTo(null);
 }// </editor-fold>//GEN-END:initComponents

 private void butonKapatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonKapatActionPerformed
  // TODO add your handling code here:
  this.dispose();
 }//GEN-LAST:event_butonKapatActionPerformed

 private void yemekGoster(){
  
  yemekGetir();
  
  int index=indexBul();
  
  goster(index);
  
 }

 private void goster(int index) {
  labelYemekAdi.setText(yemekler.get(index).getY_adi().toString());
  labelYemekTuru.setText(yemekler.get(index).getY_turu().toString());
  textYemekBilgisi.setText(yemekler.get(index).getY_bilgisi().toString());
  labelYemekFiyat.setText(String.valueOf(yemekler.get(index).getY_fiyat()));
 }

 private int indexBul() {
  int index=0;
  for(int i=0;i<yemekler.size();i++){
   if(yemekler.get(i).getId() == KullaniciEkran.bakilacakIndex ){
    index=i;
   }
   else if(yemekler.get(i).getId() == MasaBilgisiEkran.bakilacakIndex ){
    index=i;
   }
  }
  return index;
 }

 private void yemekGetir() {
  Connection baglanti = null;
  baglanti = VeriTabani.veritabaninaBaglan();
  yemekler = VeriTabani.yemekCek();
  try {
   VeriTabani.baglantiKapat(baglanti);
  } catch (Exception e) {
  }
 }

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
   java.util.logging.Logger.getLogger(YemekEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (InstantiationException ex) {
   java.util.logging.Logger.getLogger(YemekEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
   java.util.logging.Logger.getLogger(YemekEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
   java.util.logging.Logger.getLogger(YemekEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  }
        //</editor-fold>

  /* Create and display the form */
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new YemekEkran().setVisible(true);
   }
  });
 }

 // Variables declaration - do not modify//GEN-BEGIN:variables
 private javax.swing.JButton butonKapat;
 private javax.swing.JLabel jLabel1;
 private javax.swing.JLabel jLabel2;
 private javax.swing.JLabel jLabel3;
 private javax.swing.JLabel jLabel4;
 private javax.swing.JScrollPane jScrollPane1;
 private javax.swing.JLabel labelYemekAdi;
 private javax.swing.JLabel labelYemekFiyat;
 private javax.swing.JLabel labelYemekTuru;
 private javax.swing.JTextArea textYemekBilgisi;
 // End of variables declaration//GEN-END:variables
}
