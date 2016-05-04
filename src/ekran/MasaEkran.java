package ekran;

import Nesneler.Masa;
import Nesneler.VeriTabani;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Cruz
 */
public class MasaEkran extends javax.swing.JFrame {

 static ArrayList<Masa> masalar = null;
 static ComboBoxModel comboboxModel;

 public MasaEkran() {
  initComponents();
  comboboxModel = new DefaultComboBoxModel();
  masaDoldur();
 }

 @SuppressWarnings("unchecked")
 // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
 private void initComponents() {

  jPanel1 = new javax.swing.JPanel();
  jLabel1 = new javax.swing.JLabel();
  textMasano = new javax.swing.JTextField();
  butonMasaOlustur = new javax.swing.JButton();
  comboboxMasano = new javax.swing.JComboBox();
  butonMasaSil = new javax.swing.JButton();
  jSeparator1 = new javax.swing.JSeparator();
  jLabel2 = new javax.swing.JLabel();
  jLabel3 = new javax.swing.JLabel();

  setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
  setTitle("Masa Ayar Sayfası");
  setResizable(false);

  jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
  jLabel1.setText("Masa No  :");

  butonMasaOlustur.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
  butonMasaOlustur.setText("Masa oluştur");
  butonMasaOlustur.addActionListener(new java.awt.event.ActionListener() {
   public void actionPerformed(java.awt.event.ActionEvent evt) {
    butonMasaOlusturActionPerformed(evt);
   }
  });

  comboboxMasano.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

  butonMasaSil.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
  butonMasaSil.setText("Masa Sil");
  butonMasaSil.setToolTipText("");
  butonMasaSil.addActionListener(new java.awt.event.ActionListener() {
   public void actionPerformed(java.awt.event.ActionEvent evt) {
    butonMasaSilActionPerformed(evt);
   }
  });

  jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
  jLabel2.setText("Masa oluştur");

  jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
  jLabel3.setText("Masa Silme");

  javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
  jPanel1.setLayout(jPanel1Layout);
  jPanel1Layout.setHorizontalGroup(
   jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
   .addComponent(jSeparator1)
   .addGroup(jPanel1Layout.createSequentialGroup()
    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
     .addGroup(jPanel1Layout.createSequentialGroup()
      .addGap(25, 25, 25)
      .addComponent(jLabel3)
      .addGap(18, 18, 18)
      .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
       .addComponent(butonMasaSil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
       .addComponent(comboboxMasano, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
     .addGroup(jPanel1Layout.createSequentialGroup()
      .addGap(71, 71, 71)
      .addComponent(jLabel2))
     .addGroup(jPanel1Layout.createSequentialGroup()
      .addGap(30, 30, 30)
      .addComponent(jLabel1)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
       .addComponent(butonMasaOlustur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
       .addComponent(textMasano))))
    .addContainerGap(70, Short.MAX_VALUE))
  );
  jPanel1Layout.setVerticalGroup(
   jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
   .addGroup(jPanel1Layout.createSequentialGroup()
    .addComponent(jLabel2)
    .addGap(15, 15, 15)
    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
     .addComponent(jLabel1)
     .addComponent(textMasano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    .addGap(15, 15, 15)
    .addComponent(butonMasaOlustur)
    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
    .addGap(18, 18, 18)
    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
     .addComponent(comboboxMasano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
     .addComponent(jLabel3))
    .addGap(18, 18, 18)
    .addComponent(butonMasaSil)
    .addContainerGap(24, Short.MAX_VALUE))
  );

  javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
  getContentPane().setLayout(layout);
  layout.setHorizontalGroup(
   layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
   .addGroup(layout.createSequentialGroup()
    .addContainerGap()
    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
  );
  layout.setVerticalGroup(
   layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    .addContainerGap())
  );

  pack();
  setLocationRelativeTo(null);
 }// </editor-fold>//GEN-END:initComponents

 private void butonMasaOlusturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonMasaOlusturActionPerformed
  // TODO add your handling code here:

  if (!textMasano.getText().toString().equals("")) {
   if (masaYok(Integer.valueOf(textMasano.getText().toString()))) {
    Connection baglanti = null;
    baglanti = VeriTabani.veritabaninaBaglan();
    VeriTabani.masaOlustur(Integer.valueOf(textMasano.getText().toString()), baglanti);
    try {
     VeriTabani.baglantiKapat(baglanti);
    } catch (Exception e) {
    }
    JOptionPane.showMessageDialog(this, "Masa oluşturuldu.");
   } else {
    JOptionPane.showMessageDialog(this, "Bu no ile masa zaten var");
   }
  } else {
   JOptionPane.showMessageDialog(this, "Boş değer girilemez.");
  }
YoneticiEkran.masaDoldur();
KullaniciEkran.masaDoldur();
 comboboxMasano.removeAllItems();
  masaDoldur();
 }//GEN-LAST:event_butonMasaOlusturActionPerformed

 private boolean masaYok(int _masano) {
  for (int i = 0; i < masalar.size(); i++) {
   if (masalar.get(i).getMasaNo() == _masano) {
    return false;
   }
  }
  return true;
 }


 private void butonMasaSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonMasaSilActionPerformed
  // TODO add your handling code here:
  if (comboboxMasano.getSelectedIndex() != -1) {
   Connection baglanti = null;
   baglanti = VeriTabani.veritabaninaBaglan();
   VeriTabani.masaSil(masalar.get(comboboxMasano.getSelectedIndex()).getId());
   try {
    VeriTabani.baglantiKapat(baglanti);
   } catch (Exception e) {
   }
   YoneticiEkran.masaDoldur();
   KullaniciEkran.masaDoldur();
   comboboxMasano.removeAllItems();
   masaDoldur();
  } else {
   JOptionPane.showMessageDialog(this, "Masa yok");
  }
 }//GEN-LAST:event_butonMasaSilActionPerformed

 private void masaDoldur() {
  Connection baglanti = null;
  baglanti = VeriTabani.veritabaninaBaglan();
  masalar = VeriTabani.masaCek();
  String[] masaDizisi = new String[masalar.size()];
  for (int i = 0; i < masalar.size(); i++) {
   masaDizisi[i] = (String.valueOf(masalar.get(i).getMasaNo()));
  }
  
  comboboxModel = new DefaultComboBoxModel(masaDizisi);
  comboboxMasano.setModel(comboboxModel);
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
   java.util.logging.Logger.getLogger(MasaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (InstantiationException ex) {
   java.util.logging.Logger.getLogger(MasaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
   java.util.logging.Logger.getLogger(MasaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
   java.util.logging.Logger.getLogger(MasaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  }
  //</editor-fold>

  /* Create and display the form */
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new MasaEkran().setVisible(true);
   }
  });
 }

 // Variables declaration - do not modify//GEN-BEGIN:variables
 private javax.swing.JButton butonMasaOlustur;
 private javax.swing.JButton butonMasaSil;
 private javax.swing.JComboBox comboboxMasano;
 private javax.swing.JLabel jLabel1;
 private javax.swing.JLabel jLabel2;
 private javax.swing.JLabel jLabel3;
 private javax.swing.JPanel jPanel1;
 private javax.swing.JSeparator jSeparator1;
 private javax.swing.JTextField textMasano;
 // End of variables declaration//GEN-END:variables
}
