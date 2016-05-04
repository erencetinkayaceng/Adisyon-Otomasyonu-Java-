package ekran;

import Nesneler.Masa;
import Nesneler.Menu;
import Nesneler.Rezervasyon;
import Nesneler.VeriTabani;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Cruz
 */
public class KullaniciEkran extends javax.swing.JFrame {

 static ArrayList<Menu> menu = null;
 static ArrayList<Masa> masalar = null;
   
 DefaultListModel menuListeModel, yemekEkleModel, hesapListeModel;

 static ComboBoxModel comboboxModel;
 static int bakilacakIndex;

 public KullaniciEkran() {
  initComponents();
  menuListeModel = new DefaultListModel();
  yemekEkleModel = new DefaultListModel();
  comboboxModel = new DefaultComboBoxModel();
  hesapListeModel = new DefaultListModel();
  menuDoldur();
  masaDoldur();
 }

 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gunlukMenu = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        siparisListe = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        hesapListe = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        butonSiparisYemekEkle = new javax.swing.JButton();
        butonSiparisYemekSil = new javax.swing.JButton();
        butonSiparisOnayla = new javax.swing.JButton();
        butonHesapOde = new javax.swing.JButton();
        butonYemekBilgisi = new javax.swing.JButton();
        comboboxMasano = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kullanıcı Sayfası");
        setMaximumSize(new java.awt.Dimension(677, 491));
        setMinimumSize(new java.awt.Dimension(677, 491));
        setPreferredSize(new java.awt.Dimension(677, 491));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setMaximumSize(new java.awt.Dimension(290, 345));
        jPanel1.setMinimumSize(new java.awt.Dimension(290, 345));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(290, 345));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Günlük Menü");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jScrollPane1.setMaximumSize(new java.awt.Dimension(160, 250));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(160, 250));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(160, 250));

        gunlukMenu.setBackground(new java.awt.Color(0, 0, 0));
        gunlukMenu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        gunlukMenu.setForeground(new java.awt.Color(255, 255, 255));
        gunlukMenu.setMaximumSize(new java.awt.Dimension(160, 250));
        gunlukMenu.setMinimumSize(new java.awt.Dimension(160, 250));
        gunlukMenu.setPreferredSize(new java.awt.Dimension(160, 250));
        jScrollPane1.setViewportView(gunlukMenu);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 200, 260));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/menu.png"))); // NOI18N
        jLabel5.setMaximumSize(new java.awt.Dimension(290, 345));
        jLabel5.setMinimumSize(new java.awt.Dimension(290, 345));
        jLabel5.setPreferredSize(new java.awt.Dimension(290, 345));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 250, 350));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 50, 258, 353);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        siparisListe.setBackground(new java.awt.Color(249, 228, 197));
        siparisListe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        siparisListe.setForeground(new java.awt.Color(51, 51, 51));
        siparisListe.setMaximumSize(new java.awt.Dimension(160, 270));
        siparisListe.setMinimumSize(new java.awt.Dimension(160, 270));
        jScrollPane2.setViewportView(siparisListe);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 170, 220));

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Sipariş Listesi");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Hesap Listesi");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        hesapListe.setBackground(new java.awt.Color(249, 228, 197));
        hesapListe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hesapListe.setForeground(new java.awt.Color(51, 51, 51));
        jScrollPane3.setViewportView(hesapListe);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 160, 220));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/siparis.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 420, 360));

        getContentPane().add(jPanel2);
        jPanel2.setBounds(267, 49, 410, 341);

        jPanel4.setOpaque(false);

        butonSiparisYemekEkle.setBackground(new java.awt.Color(51, 102, 255));
        butonSiparisYemekEkle.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        butonSiparisYemekEkle.setForeground(new java.awt.Color(255, 255, 255));
        butonSiparisYemekEkle.setText("Yemek Ekle");
        butonSiparisYemekEkle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        butonSiparisYemekEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonSiparisYemekEkleActionPerformed(evt);
            }
        });

        butonSiparisYemekSil.setBackground(new java.awt.Color(51, 102, 255));
        butonSiparisYemekSil.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        butonSiparisYemekSil.setForeground(new java.awt.Color(255, 255, 255));
        butonSiparisYemekSil.setText("Yemek Sil");
        butonSiparisYemekSil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        butonSiparisYemekSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonSiparisYemekSilActionPerformed(evt);
            }
        });

        butonSiparisOnayla.setBackground(new java.awt.Color(51, 102, 255));
        butonSiparisOnayla.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        butonSiparisOnayla.setForeground(new java.awt.Color(255, 255, 255));
        butonSiparisOnayla.setText("Sipariş Onayla");
        butonSiparisOnayla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        butonSiparisOnayla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonSiparisOnaylaActionPerformed(evt);
            }
        });

        butonHesapOde.setBackground(new java.awt.Color(51, 102, 255));
        butonHesapOde.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        butonHesapOde.setForeground(new java.awt.Color(255, 255, 255));
        butonHesapOde.setText("Hesap Öde");
        butonHesapOde.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        butonHesapOde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonHesapOdeActionPerformed(evt);
            }
        });

        butonYemekBilgisi.setBackground(new java.awt.Color(51, 102, 255));
        butonYemekBilgisi.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        butonYemekBilgisi.setForeground(new java.awt.Color(255, 255, 255));
        butonYemekBilgisi.setText("Yemek Bilgisi");
        butonYemekBilgisi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        butonYemekBilgisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonYemekBilgisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(butonYemekBilgisi, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butonSiparisYemekEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butonSiparisYemekSil, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(butonSiparisOnayla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butonHesapOde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butonSiparisYemekEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butonYemekBilgisi, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butonSiparisYemekSil, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butonSiparisOnayla, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butonHesapOde, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(10, 408, 646, 80);

        comboboxMasano.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        comboboxMasano.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboboxMasano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxMasanoActionPerformed(evt);
            }
        });
        getContentPane().add(comboboxMasano);
        comboboxMasano.setBounds(270, 20, 90, 21);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Masa No : ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(180, 20, 70, 15);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/arka.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(-20, -20, 700, 510);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

 private void butonYemekBilgisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonYemekBilgisiActionPerformed
  if(gunlukMenu.getSelectedIndex() != -1){
  bakilacakIndex = menu.get(gunlukMenu.getSelectedIndex()).getYemek_id();
  YemekEkran yemekEkran = new YemekEkran();
  yemekEkran.show();
  }
  else{
  JOptionPane.showMessageDialog(this, "Yemek seçilmedi.");
 }
 }//GEN-LAST:event_butonYemekBilgisiActionPerformed

 private void butonSiparisYemekEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonSiparisYemekEkleActionPerformed
  // TODO add your handling code here:
  if (gunlukMenu.getSelectedIndex() == -1) {
   JOptionPane.showMessageDialog(this, "Listeden yemek seçmediniz.");
  } else {
   if (menuListeModel.size() <= 0) {
    JOptionPane.showMessageDialog(this, "Günlük menüde yemek yok.");
   } else {
    yemekEkleModel.addElement(gunlukMenu.getSelectedValue());
    siparisListe.setModel(yemekEkleModel);
   }
  }
 }//GEN-LAST:event_butonSiparisYemekEkleActionPerformed

 private void butonSiparisYemekSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonSiparisYemekSilActionPerformed
  // TODO add your handling code here:
  if (yemekEkleModel.size() <= 0) {
   JOptionPane.showMessageDialog(this, "Sipariş listesinde yemek yok.");
  } else {
   if (siparisListe.getSelectedIndex() == -1) {
    JOptionPane.showMessageDialog(this, "Sipariş listesinden yemek seçmediniz.");
   } else {
    yemekEkleModel.removeElement(siparisListe.getSelectedValue());
    siparisListe.setModel(yemekEkleModel);
   }
  }
 }//GEN-LAST:event_butonSiparisYemekSilActionPerformed

 private void butonSiparisOnaylaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonSiparisOnaylaActionPerformed
  // TODO add your handling code here:
  hesapDoldur();
  int sonSiparisID = 0;
  if (!yemekEkleModel.isEmpty()) {
   Connection baglanti = null;
   baglanti = VeriTabani.veritabaninaBaglan();
   VeriTabani.siparisOlustur(siparisDizi(), baglanti);
   sonSiparisID=VeriTabani.sonSiparisCek(baglanti);
  
   int[] siparisler=VeriTabani.masaSiparisleriCek(Integer.parseInt(comboboxMasano.getSelectedItem().toString()), baglanti);
   int[] siparisEklenmisDizi=sonsiparisEkle(sonSiparisID,siparisler);
  
   VeriTabani.masaSiparisGuncelle(Integer.parseInt(comboboxMasano.getSelectedItem().toString()), siparisEklenmisDizi, baglanti);
   try {
    VeriTabani.baglantiKapat(baglanti);
   } catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Sipariş oluşmadı");
   }
   
  } else {
   JOptionPane.showMessageDialog(this, "Sipariş için yemek seçilmedi");
  }
  yemekEkleModel.clear();
 }//GEN-LAST:event_butonSiparisOnaylaActionPerformed

 private void butonHesapOdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonHesapOdeActionPerformed
  // TODO add your handling code here:
  if(!hesapListeModel.isEmpty()){ 
  JOptionPane.showMessageDialog(this, "Hesapınız : "+hesapBul()+" tl dir \n"+
           "Bizi tercih ettiğiniz için teşekkür ederiz.");   
   int _masano=Integer.parseInt(comboboxMasano.getSelectedItem().toString());
   siparisleriSil(_masano);      
   masaSiparisleriniGuncelle(_masano);
   rezervasyonSil(masalar.get(_masano-1).getRezervasyon_id());
   masaRezervasyonGuncelle(_masano);
   
  hesapListeModel.clear();
  }
  else{
   JOptionPane.showMessageDialog(this,"Masanın hesabı yok");  
  }
  
 }//GEN-LAST:event_butonHesapOdeActionPerformed

 private void comboboxMasanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxMasanoActionPerformed
  // TODO add your handling code here:
 }//GEN-LAST:event_comboboxMasanoActionPerformed

 private int[] sonsiparisEkle(int _sonsiparisID,int[] _siparisler){
  int[] sonsiparisEkliDizi=new int[_siparisler.length+1];
  if(_siparisler.length <=0){
   sonsiparisEkliDizi[0]=_sonsiparisID;
  }else{
   for(int i=0;i<_siparisler.length;i++){
    sonsiparisEkliDizi[i]=_siparisler[i];
   }   
   sonsiparisEkliDizi[_siparisler.length]=_sonsiparisID;
  }  
  return sonsiparisEkliDizi;
 }
 
 private void masaSiparisleriniGuncelle(int _masano){
   Connection baglanti = null;
   baglanti = VeriTabani.veritabaninaBaglan();
  int[] siparis=new int[1]; // siparişleri dizi şeklinde eklemeye devam etmek için bir elemanlı dizi atıyoruz
  siparis[0]=0;
  VeriTabani.masaSiparisGuncelle(_masano, siparis, baglanti);
   try {
    VeriTabani.baglantiKapat(baglanti);
   } catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Sipariş sil çalışmadı");
   }
 }
 private void masaRezervasyonGuncelle(int _masano){
   Connection baglanti = null;
   baglanti = VeriTabani.veritabaninaBaglan();
   VeriTabani.masaRezervasyonGuncelle(-1,_masano, baglanti);
   try {
    VeriTabani.baglantiKapat(baglanti);
   } catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Rezervasyon sil-güncelle çalışmadı");
   }
 }
 
 private void rezervasyonSil(int _rid){
  Connection baglanti = null;
   baglanti = VeriTabani.veritabaninaBaglan();
  VeriTabani.rezervasyonSil(_rid);
   try {
    VeriTabani.baglantiKapat(baglanti);
   } catch (Exception e) {
    JOptionPane.showMessageDialog(this, "rezervasyon sil çalışmadı");
   }
  
 }
 
 private void menuDoldur() {

  Connection baglanti = null;
  baglanti = VeriTabani.veritabaninaBaglan();
  menu = VeriTabani.menuCek();
  for (int i = 0; i < menu.size(); i++) {
   String satir = menu.get(i).getY_adi() + "-->"
           + menu.get(i).getY_fiyati();
   menuListeModel.addElement(satir);
  }
  try {
   VeriTabani.baglantiKapat(baglanti);
  } catch (Exception e) {
  }
  gunlukMenu.setModel(menuListeModel);
 }

 public static void masaDoldur() {
  Connection baglanti = null;
  baglanti = VeriTabani.veritabaninaBaglan();
  masalar = VeriTabani.masaCek();
  String[] masaDizisi = new String[masalar.size()];
  for (int i = 0; i < masalar.size(); i++) {
   masaDizisi[i] = (String.valueOf(masalar.get(i).getMasaNo()));
  }
  comboboxMasano.removeAllItems();
  comboboxModel = new DefaultComboBoxModel(masaDizisi);
  comboboxMasano.setModel(comboboxModel);
  try {
   VeriTabani.baglantiKapat(baglanti);
  } catch (Exception e) {
  }
 }

  
 private void hesapDoldur() {

  for (int i = 0; i < yemekEkleModel.size(); i++) {
   hesapListeModel.addElement(yemekEkleModel.get(i));
  }
  hesapListe.setModel(hesapListeModel);
 }

 private double hesapBul() {
  double hesap = 0.0;

  for (int i = 0; i < hesapListeModel.size(); i++) {
   for (int j = 0; j < menu.size(); j++) {
    String[] str = hesapListeModel.getElementAt(i).toString().split("-->");

    if (str[0].equals(menu.get(j).getY_adi())) {
     hesap += menu.get(j).getY_fiyati();

    }
   }
  }
  return hesap;
 }

 private int[] siparisDizi() {
  int[] siparisDizi = new int[yemekEkleModel.size()];
  int index = 0;
  for (int i = 0; i < yemekEkleModel.size(); i++) {
   for (int j = 0; j < menu.size(); j++) {
    String[] str = yemekEkleModel.getElementAt(i).toString().split("-->");
    if (str[0].equals(menu.get(j).getY_adi())) {
     siparisDizi[index] = menu.get(j).getYemek_id();   
     index++;
    }
   }
  }  
  return siparisDizi;
 }

 private int[] siparisleriCek (int _masano){
  int[] siparisler;
  Connection baglanti = null;
  baglanti = VeriTabani.veritabaninaBaglan();
  siparisler = VeriTabani.masaSiparisleriCek(_masano, baglanti);
  try {
   VeriTabani.baglantiKapat(baglanti);
  } catch (Exception e) {
  }
  
  return siparisler;          
 }
 
 private void siparisleriSil(int _masano){
  int[] siparisler=siparisleriCek(_masano);
  Connection baglanti = null;  
  baglanti = VeriTabani.veritabaninaBaglan();
  for(int i=1;i<siparisler.length;i++)
   VeriTabani.siparisSil(siparisler[i]);
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
   java.util.logging.Logger.getLogger(KullaniciEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (InstantiationException ex) {
   java.util.logging.Logger.getLogger(KullaniciEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
   java.util.logging.Logger.getLogger(KullaniciEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
   java.util.logging.Logger.getLogger(KullaniciEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  }
  //</editor-fold>

  /* Create and display the form */
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new KullaniciEkran().setVisible(true);
   }
  });
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butonHesapOde;
    private javax.swing.JButton butonSiparisOnayla;
    private javax.swing.JButton butonSiparisYemekEkle;
    private javax.swing.JButton butonSiparisYemekSil;
    private javax.swing.JButton butonYemekBilgisi;
    private static javax.swing.JComboBox comboboxMasano;
    private javax.swing.JList gunlukMenu;
    private javax.swing.JList hesapListe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList siparisListe;
    // End of variables declaration//GEN-END:variables
}
