package ekran;

import Nesneler.Masa;
import Nesneler.Menu;
import Nesneler.Rezervasyon;
import Nesneler.Siparis;
import Nesneler.VeriTabani;
import Nesneler.Yemek;
import java.awt.Color;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Cruz
 */
public class MasaBilgisiEkran extends javax.swing.JFrame {

 int masano = 0;
 static int bakilacakIndex = 0;
 static ArrayList<Menu> menu = null;
 static ArrayList<Masa> masalar = null;
 static ArrayList<Rezervasyon> rezervasyon = null;
 static ArrayList<Siparis> siparisler = null;
 static ArrayList<Yemek> yemekler = null;

 DefaultListModel menuListeModel, siparisListeModel, hesapListeModel;

 public MasaBilgisiEkran() {
  initComponents();
  masanoAlYaz();
  menuListeModel = new DefaultListModel();
  siparisListeModel = new DefaultListModel();
  hesapListeModel = new DefaultListModel();

  menuDoldur();
  rezervayonCek();
  rezervasyonYazdır();
  masaDoldur();
  siparisCek();
  yemekCek();
  guncelHesapDoldur();
 }

 private void rezervasyonYazdır() {

  int indis = rezervasyonIDBul(masano);
  if (indis != -1) {
   rezevPanel.setBackground(Color.red);
   labelRezervasyon.setText("Saat: " + rezervasyon.get(indis-1).getSaat() + "      Tarih: " + rezervasyon.get(indis-1).getTarihi());
  } else {
   rezevPanel.setBackground(Color.blue);
   labelRezervasyon.setText("Rezervasyon yok");
  }

 }

 private void menuDoldur() {

  Connection baglanti = null;
  baglanti = VeriTabani.veritabaninaBaglan();
  menu = VeriTabani.menuCek();
  for (int i = 0; i < menu.size(); i++) {
   String satir = menu.get(i).getY_adi() + "-->" + menu.get(i).getY_fiyati();
   menuListeModel.addElement(satir);
  }
  try {
   VeriTabani.baglantiKapat(baglanti);
  } catch (Exception e) {
  }
  gunlukMenu.setModel(menuListeModel);
 }

 public void masanoAlYaz() {
  masano = YoneticiEkran.masaNosu;
  labelMasano2.setText(String.valueOf(masano));
 }

 private void hesapDoldur() {

  for (int i = 0; i < siparisListeModel.size(); i++) {
   hesapListeModel.addElement(siparisListeModel.get(i));
  }
  hesapListe.setModel(hesapListeModel);
 }

 private void guncelHesapDoldur() {
  int[] masaSiparisleri = masaSiparisleriniCek(masano);

  //siparişler içindeki idler ve masaya ait sipariş idler karşılatırılıp yemekler iddeki yemeklerin karşılıkları bulunur
  for (int i = 0; i < siparisler.size(); i++) {
   for (int j = 1; j < masaSiparisleri.length; j++) {
    
    //siparislerdeki id ile masasiparislerdeki idler eşitise gir
    if (siparisler.get(i).getId() == masaSiparisleri[j]) { 

     int[] yidler = siparisler.get(i).getY_id();
     
     for (int t = 0; t < yidler.length; t++) {
      for (int k = 0; k < yemekler.size(); k++) {
       
       //msasiparişlerdeki yemekid ile yemeklerdeki idler eşit ise gir
       if(yemekler.get(k).getId() == yidler[t]){
         String satir = yemekler.get(k).getY_adi() + "-->" + yemekler.get(k).getY_fiyat();
       hesapListeModel.addElement(satir);
       }
      
      }

     }
    }
   }
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
  int[] siparisDizi = new int[siparisListeModel.size()];
  int index = 0;
  for (int i = 0; i < siparisListeModel.size(); i++) {
   for (int j = 0; j < menu.size(); j++) {
    String[] str = siparisListeModel.getElementAt(i).toString().split("-->");
    if (str[0].equals(menu.get(j).getY_adi())) {
     siparisDizi[index] = menu.get(j).getYemek_id();
     index++;
    }
   }
  }
  return siparisDizi;
 }

 private int rezervasyonIDBul(int _masano) {
  for (int i = 0; i < rezervasyon.size(); i++) {
   if (rezervasyon.get(i).getMasano() == _masano) {
    return i + 1;
   }
  }
  return -1;
 }

 private void rezervayonCek() {
  Connection baglanti = null;
  baglanti = VeriTabani.veritabaninaBaglan();
  rezervasyon = VeriTabani.rezervasyonCek();
  try {
   VeriTabani.baglantiKapat(baglanti);
  } catch (Exception e) {
  }
 }

 private void siparisCek() {
  Connection baglanti = null;
  baglanti = VeriTabani.veritabaninaBaglan();
  siparisler = VeriTabani.siparisCek();
  try {
   VeriTabani.baglantiKapat(baglanti);
  } catch (Exception e) {
  }
 }

 private void yemekCek() {
  Connection baglanti = null;
  baglanti = VeriTabani.veritabaninaBaglan();
  yemekler = VeriTabani.yemekCek();
  try {
   VeriTabani.baglantiKapat(baglanti);
  } catch (Exception e) {
  }
 }

 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        siparisListe = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        hesapListe = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        butonYemekBilgisi = new javax.swing.JButton();
        butonSiparisYemekEkle = new javax.swing.JButton();
        butonSiparisYemekSil = new javax.swing.JButton();
        butonSiparisOnayla = new javax.swing.JButton();
        butonHesapOde = new javax.swing.JButton();
        labelMasano = new javax.swing.JLabel();
        labelMasano2 = new javax.swing.JLabel();
        labelRezervasyon = new javax.swing.JLabel();
        rezevPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gunlukMenu = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Masa Bilgileri Sayfası");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        siparisListe.setBackground(new java.awt.Color(249, 228, 197));
        siparisListe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jScrollPane2.setViewportView(siparisListe);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 170, 220));

        hesapListe.setBackground(new java.awt.Color(249, 228, 197));
        hesapListe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jScrollPane3.setViewportView(hesapListe);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 160, 220));

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Sipariş Listesi");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Hesap Listesi");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/siparis.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 450, 390));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 52, 400, 340));

        jPanel2.setOpaque(false);

        butonYemekBilgisi.setBackground(new java.awt.Color(51, 102, 255));
        butonYemekBilgisi.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        butonYemekBilgisi.setForeground(new java.awt.Color(255, 255, 255));
        butonYemekBilgisi.setText("Yemek Bilgisi");
        butonYemekBilgisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonYemekBilgisiActionPerformed(evt);
            }
        });

        butonSiparisYemekEkle.setBackground(new java.awt.Color(51, 102, 255));
        butonSiparisYemekEkle.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        butonSiparisYemekEkle.setForeground(new java.awt.Color(255, 255, 255));
        butonSiparisYemekEkle.setText("Yemek Ekle");
        butonSiparisYemekEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonSiparisYemekEkleActionPerformed(evt);
            }
        });

        butonSiparisYemekSil.setBackground(new java.awt.Color(51, 102, 255));
        butonSiparisYemekSil.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        butonSiparisYemekSil.setForeground(new java.awt.Color(255, 255, 255));
        butonSiparisYemekSil.setText("Yemek Sil");
        butonSiparisYemekSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonSiparisYemekSilActionPerformed(evt);
            }
        });

        butonSiparisOnayla.setBackground(new java.awt.Color(51, 102, 255));
        butonSiparisOnayla.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        butonSiparisOnayla.setForeground(new java.awt.Color(255, 255, 255));
        butonSiparisOnayla.setText("Sipariş Onayla");
        butonSiparisOnayla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonSiparisOnaylaActionPerformed(evt);
            }
        });

        butonHesapOde.setBackground(new java.awt.Color(51, 102, 255));
        butonHesapOde.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        butonHesapOde.setForeground(new java.awt.Color(255, 255, 255));
        butonHesapOde.setText("Hesap Öde");
        butonHesapOde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonHesapOdeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(butonYemekBilgisi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butonSiparisYemekEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butonSiparisYemekSil, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butonSiparisOnayla)
                .addGap(4, 4, 4)
                .addComponent(butonHesapOde)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butonYemekBilgisi, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butonSiparisYemekEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butonSiparisYemekSil, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butonSiparisOnayla, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butonHesapOde, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        labelMasano.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelMasano.setText("Masa No : ");
        getContentPane().add(labelMasano, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 18, -1, -1));

        labelMasano2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(labelMasano2, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 18, -1, -1));

        labelRezervasyon.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        getContentPane().add(labelRezervasyon, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 18, -1, -1));

        javax.swing.GroupLayout rezevPanelLayout = new javax.swing.GroupLayout(rezevPanel);
        rezevPanel.setLayout(rezevPanelLayout);
        rezevPanelLayout.setHorizontalGroup(
            rezevPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );
        rezevPanelLayout.setVerticalGroup(
            rezevPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        getContentPane().add(rezevPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 11, -1, -1));

        jPanel3.setMaximumSize(new java.awt.Dimension(250, 350));
        jPanel3.setMinimumSize(new java.awt.Dimension(250, 350));
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(250, 350));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Günlük Menü");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        gunlukMenu.setBackground(new java.awt.Color(0, 0, 0));
        gunlukMenu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        gunlukMenu.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(gunlukMenu);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 210, 260));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/menu.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 350));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 37, -1, 360));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/arka.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

 private void butonYemekBilgisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonYemekBilgisiActionPerformed
  // TODO add your handling code here:
  bakilacakIndex = menu.get(gunlukMenu.getSelectedIndex()).getYemek_id();
  YemekEkran yemekEkran = new YemekEkran();
  yemekEkran.show();
 }//GEN-LAST:event_butonYemekBilgisiActionPerformed

 private void butonSiparisYemekEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonSiparisYemekEkleActionPerformed
  // TODO add your handling code here:
  if (gunlukMenu.getSelectedIndex() == -1) {
   JOptionPane.showMessageDialog(this, "Listeden yemek seçmediniz.");
  } else {
   if (menuListeModel.size() <= 0) {
    JOptionPane.showMessageDialog(this, "Günlük menüde yemek yok.");
   } else {
    siparisListeModel.addElement(gunlukMenu.getSelectedValue());
    siparisListe.setModel(siparisListeModel);
   }
  }
 }//GEN-LAST:event_butonSiparisYemekEkleActionPerformed

 private void butonSiparisYemekSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonSiparisYemekSilActionPerformed
  // TODO add your handling code here:
  if (siparisListeModel.size() <= 0) {
   JOptionPane.showMessageDialog(this, "Sipariş listesinde yemek yok.");
  } else {
   if (siparisListe.getSelectedIndex() == -1) {
    JOptionPane.showMessageDialog(this, "Sipariş listesinden yemek seçmediniz.");
   } else {
    siparisListeModel.removeElement(siparisListe.getSelectedValue());
    siparisListe.setModel(siparisListeModel);
   }
  }
 }//GEN-LAST:event_butonSiparisYemekSilActionPerformed

 private void butonSiparisOnaylaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonSiparisOnaylaActionPerformed
  // TODO add your handling code here:
  hesapDoldur();
  int sonSiparisID = 0;
  if (!siparisListeModel.isEmpty()) {
   Connection baglanti = null;
   baglanti = VeriTabani.veritabaninaBaglan();
   VeriTabani.siparisOlustur(siparisDizi(), baglanti);
   sonSiparisID = VeriTabani.sonSiparisCek(baglanti);

   int[] siparisler = VeriTabani.masaSiparisleriCek(masano, baglanti);
   int[] siparisEklenmisDizi = sonsiparisEkle(sonSiparisID, siparisler);

   VeriTabani.masaSiparisGuncelle(masano, siparisEklenmisDizi, baglanti);
   try {
    VeriTabani.baglantiKapat(baglanti);
   } catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Sipariş oluşmadı");
   }
  } else {
   JOptionPane.showMessageDialog(this, "Sipariş için yemek seçilmedi");
  }
  siparisListeModel.clear();
 }//GEN-LAST:event_butonSiparisOnaylaActionPerformed

 private int[] sonsiparisEkle(int _sonsiparisID, int[] _siparisler) {
  int[] sonsiparisEkliDizi = new int[_siparisler.length + 1];
  if (_siparisler.length <= 0) {
   sonsiparisEkliDizi[0] = _sonsiparisID;
  } else {
   for (int i = 0; i < _siparisler.length; i++) {
    sonsiparisEkliDizi[i] = _siparisler[i];
   }
   sonsiparisEkliDizi[_siparisler.length] = _sonsiparisID;
  }

  return sonsiparisEkliDizi;
 }

 private void butonHesapOdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonHesapOdeActionPerformed
  // TODO add your handling code here:
  if (!hesapListeModel.isEmpty()) {
   JOptionPane.showMessageDialog(this, "Hesapınız : " + hesapBul() + " tl dir \n"
           + "Bizi tercih ettiğiniz için teşekkür ederiz.");

   siparisleriSil(masano);
   int indis = rezervasyonIDBul(masano);
   
   if(indis != -1){
    rezervasyonSil(rezervasyon.get(indis-1).getId());
   }
    
   masaSiparisleriniGuncelle(masano); 
   masaRezervasyonGuncelle(masano);

   hesapListeModel.clear();
   this.dispose();
  } else {
   JOptionPane.showMessageDialog(this, "Masanın hesabı yok");
  }
 }//GEN-LAST:event_butonHesapOdeActionPerformed

 private void masaSiparisleriniGuncelle(int _masano) {
  Connection baglanti = null;
  baglanti = VeriTabani.veritabaninaBaglan();
  int[] siparis = new int[1]; // siparişleri dizi şeklinde eklemeye devam etmek için bir elemanlı dizi atıyoruz
  siparis[0] = 0;
  VeriTabani.masaSiparisGuncelle(_masano, siparis, baglanti);
  try {
   VeriTabani.baglantiKapat(baglanti);
  } catch (Exception e) {
   JOptionPane.showMessageDialog(this, "Sipariş sil çalışmadı");
  }
 }

 private void masaRezervasyonGuncelle(int _masano) {
  Connection baglanti = null;
  baglanti = VeriTabani.veritabaninaBaglan();
  VeriTabani.masaRezervasyonGuncelle(-1, _masano, baglanti);
  try {
   VeriTabani.baglantiKapat(baglanti);
  } catch (Exception e) {
   JOptionPane.showMessageDialog(this, "Rezervasyon sil-güncelle çalışmadı");
  }
 }

 private void rezervasyonSil(int _rid) {
  Connection baglanti = null;
  baglanti = VeriTabani.veritabaninaBaglan();
  VeriTabani.rezervasyonSil(_rid);
  try {
   VeriTabani.baglantiKapat(baglanti);
  } catch (Exception e) {
   JOptionPane.showMessageDialog(this, "rezervasyon sil çalışmadı");
  }

 }

 private int[] masaSiparisleriniCek(int _masano) {
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

 private void siparisleriSil(int _masano) {
  int[] siparisler = masaSiparisleriniCek(_masano);
  Connection baglanti = null;
  baglanti = VeriTabani.veritabaninaBaglan();
  for (int i = 1; i < siparisler.length; i++) {
   VeriTabani.siparisSil(siparisler[i]);
  }
  try {
   VeriTabani.baglantiKapat(baglanti);
  } catch (Exception e) {
  }
 }

 public static void masaDoldur() {
  Connection baglanti = null;
  baglanti = VeriTabani.veritabaninaBaglan();
  masalar = VeriTabani.masaCek();
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
   java.util.logging.Logger.getLogger(MasaBilgisiEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (InstantiationException ex) {
   java.util.logging.Logger.getLogger(MasaBilgisiEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
   java.util.logging.Logger.getLogger(MasaBilgisiEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
   java.util.logging.Logger.getLogger(MasaBilgisiEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  }
  //</editor-fold>

  /* Create and display the form */
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new MasaBilgisiEkran().setVisible(true);
   }
  });
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butonHesapOde;
    private javax.swing.JButton butonSiparisOnayla;
    private javax.swing.JButton butonSiparisYemekEkle;
    private javax.swing.JButton butonSiparisYemekSil;
    private javax.swing.JButton butonYemekBilgisi;
    private javax.swing.JList gunlukMenu;
    private javax.swing.JList hesapListe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelMasano;
    private javax.swing.JLabel labelMasano2;
    private javax.swing.JLabel labelRezervasyon;
    private javax.swing.JPanel rezevPanel;
    private javax.swing.JList siparisListe;
    // End of variables declaration//GEN-END:variables
}
