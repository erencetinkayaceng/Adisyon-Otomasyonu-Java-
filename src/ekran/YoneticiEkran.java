package ekran;

import Nesneler.Masa;
import Nesneler.Menu;
import Nesneler.VeriTabani;
import Nesneler.Yemek;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cruz
 */
public class YoneticiEkran extends javax.swing.JFrame {

 static ArrayList<Yemek> yemekler = null;
 static ArrayList<Menu> menu = null;
static ArrayList<Masa> masalar = null;

 DefaultListModel listModel;
 static ComboBoxModel comboboxModel,comboboxModelMasa;

 static int masaNosu=0;
 public YoneticiEkran() {
  initComponents();
  comboboxModel = new DefaultComboBoxModel();
  comboboxModelMasa = new DefaultComboBoxModel();
  comboboxDoldur();
   masaDoldur();
  listModel = new DefaultListModel();
  menuDoldur();
 }

 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuListe = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        comboboxYemekListe = new javax.swing.JComboBox();
        butonYemekEkle = new javax.swing.JButton();
        butonMenuYemekSil = new javax.swing.JButton();
        butonYemekOlustur = new javax.swing.JButton();
        butonYemekSil = new javax.swing.JButton();
        butonRezervasyon = new javax.swing.JButton();
        butonMasa = new javax.swing.JButton();
        comboboxMasalar = new javax.swing.JComboBox();
        butonMasaBilgisi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Yönetici Sayfası");
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Günlük Menü");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        menuListe.setBackground(new java.awt.Color(0, 0, 0));
        menuListe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        menuListe.setForeground(new java.awt.Color(255, 255, 255));
        menuListe.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(menuListe);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 210, 260));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/menu.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 250, 340));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 258, 351));

        jPanel2.setOpaque(false);

        comboboxYemekListe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        butonYemekEkle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        butonYemekEkle.setText("Menüye Yemek Ekle");
        butonYemekEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonYemekEkleActionPerformed(evt);
            }
        });

        butonMenuYemekSil.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        butonMenuYemekSil.setText("Menüden Yemek Sil");
        butonMenuYemekSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonMenuYemekSilActionPerformed(evt);
            }
        });

        butonYemekOlustur.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        butonYemekOlustur.setText("Yemek Oluştur");
        butonYemekOlustur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonYemekOlusturActionPerformed(evt);
            }
        });

        butonYemekSil.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        butonYemekSil.setText("Yemek Sil");
        butonYemekSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonYemekSilActionPerformed(evt);
            }
        });

        butonRezervasyon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        butonRezervasyon.setText("Rezervasyon Oluştur");
        butonRezervasyon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonRezervasyonActionPerformed(evt);
            }
        });

        butonMasa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        butonMasa.setText("Masa Ayar");
        butonMasa.setActionCommand("Masa Olustur");
        butonMasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonMasaActionPerformed(evt);
            }
        });

        comboboxMasalar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        butonMasaBilgisi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        butonMasaBilgisi.setText("Masa Bilgileri");
        butonMasaBilgisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonMasaBilgisiActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Masa No: ");

        jLabel3.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Yemekler Listesi");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(butonRezervasyon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butonYemekOlustur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butonMenuYemekSil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butonYemekEkle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboboxYemekListe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butonYemekSil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butonMasa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butonMasaBilgisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboboxMasalar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboboxYemekListe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(butonYemekEkle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butonMenuYemekSil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butonYemekOlustur)
                .addGap(8, 8, 8)
                .addComponent(butonYemekSil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butonRezervasyon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butonMasa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboboxMasalar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butonMasaBilgisi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 11, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/arka.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

 private void butonYemekOlusturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonYemekOlusturActionPerformed
  // TODO add your handling code here:
  YemekOlusturEkran yemekOlustur = new YemekOlusturEkran();
  yemekOlustur.show();
 }//GEN-LAST:event_butonYemekOlusturActionPerformed

 private void butonYemekEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonYemekEkleActionPerformed

  if (comboboxYemekListe.getSelectedIndex() != -1) {
   if (menudeYok(comboboxYemekListe.getSelectedIndex())) {
    String satir = yemekler.get(comboboxYemekListe.getSelectedIndex()).getY_adi() + "............"
            + yemekler.get(comboboxYemekListe.getSelectedIndex()).getY_fiyat();
    Connection baglanti = null;
    baglanti = VeriTabani.veritabaninaBaglan();
    VeriTabani.menuEkle(yemekler.get(comboboxYemekListe.getSelectedIndex()).getId());
    try {
     VeriTabani.baglantiKapat(baglanti);
    } catch (Exception e) {
    }
    listModel.addElement(satir);
    menuListe.setModel(listModel);
    listModel.clear();
    menuDoldur();
   } else {
    JOptionPane.showMessageDialog(this, "Kayıt yapılamadı. Yemek menüde zaten var.");
   }
  } else {
   JOptionPane.showMessageDialog(this, "Yemek seçilmedi");
  }
 }//GEN-LAST:event_butonYemekEkleActionPerformed

 private boolean menudeYok(int index) {
  for (int i = 0; i < menu.size(); i++) {
   if (yemekler.get(index).getId() == menu.get(i).getYemek_id()) {
    return false;
   }
  }
  return true;
 }

 private void butonMenuYemekSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonMenuYemekSilActionPerformed

  if (menuListe.getSelectedIndex() != -1) {
   Connection baglanti = null;
   baglanti = VeriTabani.veritabaninaBaglan();
   VeriTabani.menuSil(menu.get(menuListe.getSelectedIndex()).getId());
   try {
    VeriTabani.baglantiKapat(baglanti);
   } catch (Exception e) {
   }
   menu.remove(menuListe.getSelectedIndex());
   listModel.remove(menuListe.getSelectedIndex());
   menuListe.setModel(listModel);
  } else {
   JOptionPane.showMessageDialog(this, "Yemek seçilmedi");
  }


 }//GEN-LAST:event_butonMenuYemekSilActionPerformed

 private void butonRezervasyonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonRezervasyonActionPerformed
  // TODO add your handling code here:
  RezervasyonEkranim rezervasyon = new RezervasyonEkranim();
  rezervasyon.show();
 }//GEN-LAST:event_butonRezervasyonActionPerformed

 private void butonYemekSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonYemekSilActionPerformed
  // TODO add your handling code here:
  if (comboboxYemekListe.getSelectedIndex() != -1) {
   if (menudeYok(comboboxYemekListe.getSelectedIndex())) {
    Connection baglanti = null;
    baglanti = VeriTabani.veritabaninaBaglan();
    VeriTabani.yemekSil(yemekler.get(comboboxYemekListe.getSelectedIndex()).getId());
    JOptionPane.showMessageDialog(this, "Yemek silindi.");
    try {
     VeriTabani.baglantiKapat(baglanti);
    } catch (Exception e) {
    }
    comboboxYemekListe.removeAllItems();
    comboboxDoldur();
   } else {
    JOptionPane.showMessageDialog(this, "Yemek menüde gösterimde yemeği silmek için önce menüden siliniz.");
   }
  } else {
   JOptionPane.showMessageDialog(this, "Yemek seçilmedi");
  }
 }//GEN-LAST:event_butonYemekSilActionPerformed

 private void butonMasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonMasaActionPerformed
  // TODO add your handling code here:
  MasaEkran masaEkran=new MasaEkran();
  masaEkran.show();  
 }//GEN-LAST:event_butonMasaActionPerformed

 private void butonMasaBilgisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonMasaBilgisiActionPerformed
  // TODO add your handling code here:
  masaNosu=Integer.parseInt(comboboxMasalar.getSelectedItem().toString());
  MasaBilgisiEkran msbEkran =new MasaBilgisiEkran();
  msbEkran.show();
 }//GEN-LAST:event_butonMasaBilgisiActionPerformed

 public static void comboboxDoldur() {
  Connection baglanti = null;
  baglanti = VeriTabani.veritabaninaBaglan();
  yemekler = VeriTabani.yemekCek();
  String[] yemekDizi = new String[yemekler.size()];
  for (int i = 0; i < yemekler.size(); i++) {
   yemekDizi[i] = (yemekler.get(i).getY_adi().toString());
  }
  comboboxModel = new DefaultComboBoxModel(yemekDizi);
  comboboxYemekListe.setModel(comboboxModel);
  try {
   VeriTabani.baglantiKapat(baglanti);
  } catch (Exception e) {
  }

 }

 private void menuDoldur() {

  Connection baglanti = null;
  baglanti = VeriTabani.veritabaninaBaglan();
  menu = VeriTabani.menuCek();
  for (int i = 0; i < menu.size(); i++) {
   String satir = menu.get(i).getY_adi() + "............"
           + menu.get(i).getY_fiyati();
   listModel.addElement(satir);
  }
  try {
   VeriTabani.baglantiKapat(baglanti);
  } catch (Exception e) {
  }
  menuListe.setModel(listModel);
 }

  public static void masaDoldur() {
  Connection baglanti = null;
  baglanti = VeriTabani.veritabaninaBaglan();
  masalar = VeriTabani.masaCek();
  String[] masaDizisi = new String[masalar.size()];
  for (int i = 0; i < masalar.size(); i++) {
   masaDizisi[i] = (String.valueOf(masalar.get(i).getMasaNo()));
  }
  comboboxMasalar.removeAllItems();
  comboboxModelMasa = new DefaultComboBoxModel(masaDizisi);
  comboboxMasalar.setModel(comboboxModelMasa);
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
   java.util.logging.Logger.getLogger(YoneticiEkran.class
           .getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (InstantiationException ex) {
   java.util.logging.Logger.getLogger(YoneticiEkran.class
           .getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
   java.util.logging.Logger.getLogger(YoneticiEkran.class
           .getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
   java.util.logging.Logger.getLogger(YoneticiEkran.class
           .getName()).log(java.util.logging.Level.SEVERE, null, ex);
  }
  //</editor-fold>

  /* Create and display the form */
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new YoneticiEkran().setVisible(true);
   }
  });

 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butonMasa;
    private javax.swing.JButton butonMasaBilgisi;
    private javax.swing.JButton butonMenuYemekSil;
    private javax.swing.JButton butonRezervasyon;
    private javax.swing.JButton butonYemekEkle;
    private javax.swing.JButton butonYemekOlustur;
    private javax.swing.JButton butonYemekSil;
    private static javax.swing.JComboBox comboboxMasalar;
    private static javax.swing.JComboBox comboboxYemekListe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList menuListe;
    // End of variables declaration//GEN-END:variables
}
