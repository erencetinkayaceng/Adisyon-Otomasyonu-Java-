package Nesneler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Cruz
 */
public class VeriTabani {

 private static Connection connection = null;

 public static Connection veritabaninaBaglan() {

  try {
   Class.forName("org.postgresql.Driver");
   connection = DriverManager.getConnection(
           "jdbc:postgresql://localhost:5432/dpuLokantaAdisyon", "postgres", "12345");
   connection.setAutoCommit(false);
   System.out.println("Veri Tabanina Başarı ile Bağlanmıştır…!");
  } catch (SQLException e) {

   System.err.println("Bağlantı sağlanamadı.");
   e.printStackTrace();
   return null;

  } catch (ClassNotFoundException e) {
   // TODO Auto-generated catch block
   System.err.println("org.postgresql.Driver Pathi bulamadı ve veri tabanına bağlanamadı..");
   e.printStackTrace();
  }
  return connection;
 }

 public static void baglantiKapat(Connection _con) throws Exception {
  System.err.println("veritabanı bağlantısı kapatıldı.");
  _con.close();
 }

 public static void menuEkle(int _yid) {
  Statement stmt = null;
  try {
   if (_yid != -1) {
    stmt = connection.createStatement();
    String sql = "INSERT INTO menu (yemek_id) VALUES (" + _yid + ");";
    stmt.executeUpdate(sql);
    stmt.close();
    connection.commit();
   }
  } catch (Exception e) {
   System.err.println("Menu ekleme hatası !");
  }

 }

 public static void menuSil(int _id) {
  Statement stmt = null;
  try {
   if (_id != -1) {
    stmt = connection.createStatement();

    String sql = "DELETE from menu where id=" + _id + ";";
    stmt.executeUpdate(sql);
    stmt.close();
    connection.commit();
   }
  } catch (Exception e) {
   System.err.println("Menu silme hatası !");
  }

 }

 public static ArrayList<Menu> menuCek() {
  ArrayList<Menu> menu = new ArrayList<Menu>();
  Statement stmt = null;
  try {
   stmt = connection.createStatement();
   ResultSet rs = stmt.executeQuery("SELECT M.id,M.yemek_id,Y.id,Y.y_adi,Y.y_fiyat FROM menu M JOIN yemekler Y ON M.yemek_id=Y.id;");

   while (rs.next()) {

    int id = rs.getInt("id");
    int yid = rs.getInt("yemek_id");
    String yadi = rs.getString("y_adi");
    double yfiyat = rs.getDouble("y_fiyat");
    menu.add(new Menu(id, yid, yadi, yfiyat));
   }
   rs.close();
   stmt.close();

  } catch (Exception e) {
   System.err.println(e.getClass().getName() + ": " + e.getMessage());
   System.err.println("menu verisi çekilemedi");
   System.exit(-1);
  }

  return menu;
 }

 public static void yemekOlustur(String y_adi, String y_turu, String y_bilgisi, double y_fiyat, Connection baglanti) {
  Statement stmt = null;
  try {
   stmt = baglanti.createStatement();
   String sql = "INSERT INTO yemekler (y_adi,y_turu,y_bilgisi,y_fiyat) "
           + "VALUES ('" + y_adi + "','" + y_turu + "', '" + y_bilgisi + "'," + y_fiyat + ");";
   stmt.executeUpdate(sql);
   stmt.close();
   baglanti.commit();
  } catch (Exception e) {
   e.printStackTrace();
   System.err.println("Yemek oluşturulamadı.");
  }

 }

 public static void yemekSil(int _yid) {

  Statement stmt = null;
  try {
   if (_yid != -1) {
    stmt = connection.createStatement();

    String sql = "DELETE from yemekler where id=" + _yid + ";";
    stmt.executeUpdate(sql);
    stmt.close();
    connection.commit();
   }
  } catch (Exception e) {
   System.err.println("Yemek silme hatası !");
  }
 }

 public static ArrayList<Yemek> yemekCek() {
  ArrayList<Yemek> yemekler = new ArrayList<Yemek>();
  Statement stmt = null;

  try {
   stmt = connection.createStatement();
   ResultSet rs = stmt.executeQuery("SELECT * FROM yemekler;");

   while (rs.next()) {
    int id = rs.getInt("id");
    String yAdi = rs.getString("y_adi");
    String yTuru = rs.getString("y_turu");
    String yBilgisi = rs.getString("y_bilgisi");
    double yFiyat = rs.getDouble("y_fiyat");
    yemekler.add(new Yemek(id, yAdi, yTuru, yBilgisi, yFiyat));
   }

   rs.close();
   stmt.close();

  } catch (Exception e) {
   System.err.println(e.getClass().getName() + ": " + e.getMessage());
   System.err.println("yemek verisi çekilemedi");
   System.exit(-1);
  }

  return yemekler;
 }

 public static void masaOlustur(int _masano, Connection baglanti) {
  Statement stmt = null;
  try {
   stmt = baglanti.createStatement();
   String sql = "INSERT INTO masa (masano,siparis_id) "
           + "VALUES (" + _masano + ",'{0}');";
   stmt.executeUpdate(sql);
   stmt.close();
   baglanti.commit();
  } catch (Exception e) {
   e.printStackTrace();
   System.err.println("Masa oluşturulamadı. ");
  }

 }

 public static ArrayList<Masa> masaCek() {
  ArrayList<Masa> masa = new ArrayList<Masa>();
  Statement stmt = null;
  try {
   stmt = connection.createStatement();
   ResultSet rs = stmt.executeQuery("SELECT * FROM masa ;");

   while (rs.next()) {

    int id = rs.getInt("id");
    int masano = rs.getInt("masano");
    int rid = rs.getInt("rezervasyon_id");

    masa.add(new Masa(id, rid, masano));
   }
   rs.close();
   stmt.close();

  } catch (Exception e) {
   System.err.println(e.getClass().getName() + ": " + e.getMessage());
   System.err.println("masa verisi çekilemedi");
   System.exit(-1);
  }
  return masa;
 }

 public static void masaSil(int _mid) {
  Statement stmt = null;
  try {
   if (_mid != -1) {
    stmt = connection.createStatement();

    String sql = "DELETE from masa where id=" + _mid + ";";
    stmt.executeUpdate(sql);
    stmt.close();
    connection.commit();
   }
  } catch (Exception e) {
   System.err.println("masa silme hatası !");
  }
 }

 public static void siparisOlustur(int[] _yid, Connection baglanti) {
  Statement stmt = null;
  String str = siparisSqlHazirla(_yid);
  try {
   stmt = baglanti.createStatement();
   String sql = "INSERT INTO siparis (y_id) "
           + "VALUES ('" + str + "');";
   stmt.executeUpdate(sql);
   stmt.close();
   baglanti.commit();
  } catch (Exception e) {
   e.printStackTrace();
   System.err.println("Sipariş oluşturulamadı.");
  }

 }

 private static String siparisSqlHazirla(int[] _yid) {
  String str = "{";
  for (int i = 0; i < _yid.length; i++) {

   if (_yid.length - 1 != i) {
    str += _yid[i] + ",";
   }
  }
  str += _yid[_yid.length - 1];
  str += "}";
  return str;
 }

 public static int sonSiparisCek(Connection baglanti) {
  int sonSiparisID = 0;

  Statement stmt = null;
  try {
   stmt = connection.createStatement();
   ResultSet rs = stmt.executeQuery("SELECT * FROM siparis ORDER BY id DESC LIMIT 1 ;");
   while (rs.next()) {
    sonSiparisID = rs.getInt("id");
   }
   rs.close();
   stmt.close();
  } catch (Exception e) {
   e.printStackTrace();
   System.err.println("Son siparis çekilemedi");
  }

  return sonSiparisID;
 }

 public static ArrayList<Siparis> siparisCek() {
  ArrayList<Siparis> siparis = new ArrayList<Siparis>();
  int[] yid = null;
  Statement stmt = null;
  try {
   stmt = connection.createStatement();
   ResultSet rs = stmt.executeQuery("SELECT * FROM siparis ;");
   
   java.util.ArrayList alRowData = null;
   while (rs.next()) {

    int id = rs.getInt("id");
    
    //bir satırı sütun sütun çekmek
    alRowData = new java.util.ArrayList();
    java.sql.ResultSetMetaData rsmd = rs.getMetaData();
    int numberOfColumns = rsmd.getColumnCount();
    for (int columnIndex = 1; columnIndex <= numberOfColumns; columnIndex++) {
     alRowData.add(rs.getObject(columnIndex));
    }

    String str = alRowData.get(1).toString();
    str = str.substring(1, str.length() - 1); // {} kaldırma işlemi
    String[] strs = str.split(",");  //eğer 12,2 gibi dizi var ise ayırma

    if (strs.length <= 0) {
     yid = new int[1];
     yid[0] = Integer.valueOf(str);
    } else {
     int index = 0;
     yid = new int[strs.length];
     while (strs.length != index) {
      yid[index] = Integer.valueOf(strs[index]); //stringi inte çevirip diziye ekleme
      index++;
     }
    }

    siparis.add(new Siparis(id, yid));
   }
   rs.close();
   stmt.close();

  } catch (Exception e) {
   System.err.println(e.getClass().getName() + ": " + e.getMessage());
   System.err.println("siparis verisi çekilemedi");
   System.exit(-1);
  }

  return siparis;
 }

 public static int sonRezervasyonCek(Connection baglanti) {
  int sonSiparisID = 0;

  Statement stmt = null;
  try {
   stmt = connection.createStatement();
   ResultSet rs = stmt.executeQuery("SELECT * FROM rezervasyon ORDER BY id DESC LIMIT 1 ;");
   while (rs.next()) {
    sonSiparisID = rs.getInt("id");
   }
   rs.close();
   stmt.close();
  } catch (Exception e) {
   e.printStackTrace();
   System.err.println("Rezervasyon çekilemedi");
  }

  return sonSiparisID;
 }

 public static int[] masaSiparisleriCek(int _masano, Connection baglanti) {
  int[] sid = null;
  Statement stmt = null;
  try {
   stmt = connection.createStatement();
   ResultSet rs = stmt.executeQuery("SELECT * FROM masa where masano=" + _masano + ";");
   java.util.ArrayList alRowData = null;

   while (rs.next()) {
    //bir satırı sütun sütun çekmek
    alRowData = new java.util.ArrayList();
    java.sql.ResultSetMetaData rsmd = rs.getMetaData();
    int numberOfColumns = rsmd.getColumnCount();
    for (int columnIndex = 1; columnIndex <= numberOfColumns; columnIndex++) {
     alRowData.add(rs.getObject(columnIndex));
    }

    String str = alRowData.get(3).toString();
    str = str.substring(1, str.length() - 1); // {} kaldırma işlemi
    String[] strs = str.split(",");  //eğer 12,2 gibi dizi var ise ayırma

    if (strs.length <= 0) {
     sid = new int[1];
     sid[0] = Integer.valueOf(str);
    } else {
     int index = 0;
     sid = new int[strs.length];
     while (strs.length != index) {
      sid[index] = Integer.valueOf(strs[index]); //stringi inte çevirip diziye ekleme
      index++;
     }
    }

   }

   rs.close();
   stmt.close();
  } catch (Exception e) {
   e.printStackTrace();
   System.err.println("Masanın siparişleri çekilemedi");
  }

  return sid;
 }

 public static void masaSiparisGuncelle(int _masano, int[] _sonsiparisEkliDizi, Connection baglanti) {

  Statement stmt = null;
  try {
   stmt = baglanti.createStatement();
   String sql = "UPDATE masa set siparis_id ='" + sonsiparisEklisqlHazirla(_sonsiparisEkliDizi) + "' where masano=" + _masano + ";";
   stmt.executeUpdate(sql);
   stmt.close();
   baglanti.commit();
  } catch (Exception e) {
   e.printStackTrace();
   System.err.println("Sipariş bilgisi güncellenemedi.");
  }
 }

 private static String sonsiparisEklisqlHazirla(int[] _yid) {
  String str = "{";
  for (int i = 0; i < _yid.length; i++) {

   if (_yid.length - 1 != i) {
    str += _yid[i] + ",";
   }
  }
  str += _yid[_yid.length - 1];
  str += "}";
  return str;
 }

 public static void masaRezervasyonGuncelle(int _rezervasyonID, int _masano, Connection baglanti) {

  Statement stmt = null;
  try {
   stmt = baglanti.createStatement();
   String sql = null;
   if (_rezervasyonID == -1) {
    sql = "UPDATE masa set rezervasyon_id =" + null + " where masano=" + _masano + ";";
   } else {
    sql = "UPDATE masa set rezervasyon_id =" + _rezervasyonID + " where masano=" + _masano + ";";
   }

   stmt.executeUpdate(sql);
   stmt.close();
   baglanti.commit();
  } catch (Exception e) {
   e.printStackTrace();
   System.err.println("Rezervasyon bilgisi güncellenemedi.");
  }
 }

 public static ArrayList<Rezervasyon> rezervasyonCek() {

  ArrayList<Rezervasyon> rezervasyon = new ArrayList<Rezervasyon>();
  Statement stmt = null;
  try {
   stmt = connection.createStatement();
   ResultSet rs = stmt.executeQuery("SELECT * FROM rezervasyon ;");

   while (rs.next()) {

    int id = rs.getInt("id");
    int masano = rs.getInt("masano");
    String tarihi = rs.getString("tarihi");
    String saat = rs.getString("saat");
    rezervasyon.add(new Rezervasyon(id, tarihi, saat, masano));
   }
   rs.close();
   stmt.close();

  } catch (Exception e) {
   System.err.println(e.getClass().getName() + ": " + e.getMessage());
   System.err.println("Rezervasyon verisi çekilemedi");
  }
  return rezervasyon;

 }

 public static void siparisSil(int _sid) {
  Statement stmt = null;
  try {
   if (_sid != -1) {
    stmt = connection.createStatement();

    String sql = "DELETE from siparis where id=" + _sid + ";";
    stmt.executeUpdate(sql);
    stmt.close();
    connection.commit();
   }
  } catch (Exception e) {
   System.err.println("siparis silme hatası !");
  }

 }

 public static void rezervasyonSil(int _rid) {
  Statement stmt = null;
  try {
   if (_rid != -1) {
    stmt = connection.createStatement();

    String sql = "DELETE from rezervasyon where id=" + _rid + ";";
    stmt.executeUpdate(sql);
    stmt.close();
    connection.commit();
   }
  } catch (Exception e) {
   System.err.println("rezervasyon silme hatası !");
  }

 }
}
