/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ekran;

import Nesneler.VeriTabani;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Cruz
 */
public class YemekOlusturEkran extends javax.swing.JFrame {

 public YemekOlusturEkran() {
  initComponents();
 }

 @SuppressWarnings("unchecked")
 // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
 private void initComponents() {

  textYemekAdi = new javax.swing.JTextField();
  textYemekTuru = new javax.swing.JTextField();
  textYemekFiyat = new javax.swing.JTextField();
  jScrollPane1 = new javax.swing.JScrollPane();
  textAreaYbilgisi = new javax.swing.JTextArea();
  butonYemekOlustur = new javax.swing.JButton();
  jLabel1 = new javax.swing.JLabel();
  jLabel2 = new javax.swing.JLabel();
  jLabel3 = new javax.swing.JLabel();
  jLabel4 = new javax.swing.JLabel();

  setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
  setTitle("Yemek Oluşturma Sayfası");

  textAreaYbilgisi.setColumns(20);
  textAreaYbilgisi.setRows(5);
  jScrollPane1.setViewportView(textAreaYbilgisi);

  butonYemekOlustur.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
  butonYemekOlustur.setText("Yemek Oluştur");
  butonYemekOlustur.addActionListener(new java.awt.event.ActionListener() {
   public void actionPerformed(java.awt.event.ActionEvent evt) {
    butonYemekOlusturActionPerformed(evt);
   }
  });

  jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
  jLabel1.setText("Yemek Adi     :");

  jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
  jLabel2.setText("Yemek türü   :");

  jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
  jLabel3.setText("Yemek Bilgisi");

  jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
  jLabel4.setText("Yemek Fiyatı   :");

  javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
  getContentPane().setLayout(layout);
  layout.setHorizontalGroup(
   layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
   .addGroup(layout.createSequentialGroup()
    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
     .addGroup(layout.createSequentialGroup()
      .addGap(101, 101, 101)
      .addComponent(jLabel3))
     .addGroup(layout.createSequentialGroup()
      .addGap(46, 46, 46)
      .addComponent(butonYemekOlustur, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
     .addGroup(layout.createSequentialGroup()
      .addGap(21, 21, 21)
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
       .addGroup(layout.createSequentialGroup()
        .addComponent(jLabel4)
        .addGap(18, 18, 18)
        .addComponent(textYemekFiyat))
       .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
       .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jLabel1)
         .addComponent(jLabel2))
        .addGap(20, 20, 20)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(textYemekAdi)
         .addComponent(textYemekTuru))))))
    .addContainerGap(33, Short.MAX_VALUE))
  );
  layout.setVerticalGroup(
   layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
   .addGroup(layout.createSequentialGroup()
    .addGap(31, 31, 31)
    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
     .addComponent(textYemekAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
     .addComponent(jLabel1))
    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
     .addComponent(textYemekTuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
     .addComponent(jLabel2))
    .addGap(8, 8, 8)
    .addComponent(jLabel3)
    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
    .addGap(18, 18, 18)
    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
     .addComponent(textYemekFiyat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
     .addComponent(jLabel4))
    .addGap(18, 18, 18)
    .addComponent(butonYemekOlustur, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
    .addContainerGap())
  );

  pack();
  setLocationRelativeTo(null);
 }// </editor-fold>//GEN-END:initComponents

 private void butonYemekOlusturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonYemekOlusturActionPerformed
  // TODO add your handling code here:

  String yemekAdi = textYemekAdi.getText();
  String yemekTuru = textYemekTuru.getText();
  String yemekBilgisi = textAreaYbilgisi.getText();
  String yemekFiyat = textYemekFiyat.getText();
  
  boolean olustur = true;
  boolean kontrol=true;
  kontrol=girilenleriKontrolEt(yemekAdi,yemekTuru,yemekBilgisi,yemekFiyat);
  olustur=fiyatKontrol();
  
  if(kontrol){
    if (olustur) {
     Double fiyat=Double.valueOf(textYemekFiyat.getText());
     
       Connection baglanti=null;
       baglanti=VeriTabani.veritabaninaBaglan();
       
       VeriTabani.yemekOlustur(yemekAdi, yemekTuru, yemekBilgisi, fiyat, baglanti);
       
       YoneticiEkran.comboboxDoldur();
       
       try {
        VeriTabani.baglantiKapat(baglanti);
       } catch (Exception ex) {
        Logger.getLogger(YemekOlusturEkran.class.getName()).log(Level.SEVERE, null, ex);
       }
     
     JOptionPane.showMessageDialog(this, "Yemek Oluşturuldu.");
     this.dispose();
    }else{
      JOptionPane.showMessageDialog(this, "Fiyat yanlış girildi.");
    }
  }
  else{
   JOptionPane.showMessageDialog(this, "Boş deger girilemez!");
  }  
    
 }//GEN-LAST:event_butonYemekOlusturActionPerformed

 private boolean fiyatKontrol(){
  boolean kontrol=true;
  Double fiyat;
  try{
   fiyat=Double.valueOf(textYemekFiyat.getText());
  }catch(Exception e){
   return false;
  }
  return true;  
 }
 
 private boolean girilenleriKontrolEt(String yAdi,String yTuru,String yBilgisi,String yFiyat){  
  if(yAdi.isEmpty()||yTuru.isEmpty()||yBilgisi.isEmpty()||yFiyat.isEmpty()){
   return false;
  }
   return true;
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
   java.util.logging.Logger.getLogger(YemekOlusturEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (InstantiationException ex) {
   java.util.logging.Logger.getLogger(YemekOlusturEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
   java.util.logging.Logger.getLogger(YemekOlusturEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
   java.util.logging.Logger.getLogger(YemekOlusturEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  }
  //</editor-fold>

  /* Create and display the form */
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new YemekOlusturEkran().setVisible(true);

   }
  });

 }


 // Variables declaration - do not modify//GEN-BEGIN:variables
 private javax.swing.JButton butonYemekOlustur;
 private javax.swing.JLabel jLabel1;
 private javax.swing.JLabel jLabel2;
 private javax.swing.JLabel jLabel3;
 private javax.swing.JLabel jLabel4;
 private javax.swing.JScrollPane jScrollPane1;
 private javax.swing.JTextArea textAreaYbilgisi;
 private javax.swing.JTextField textYemekAdi;
 private javax.swing.JTextField textYemekFiyat;
 private javax.swing.JTextField textYemekTuru;
 // End of variables declaration//GEN-END:variables
}
