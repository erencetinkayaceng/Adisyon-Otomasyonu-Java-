package Nesneler;

/**
 *
 * @author Cruz
 */
public class Menu {
 
 int id,yemek_id;
 String y_adi;
 double y_fiyati;
 
 public Menu(int id, int yemek_id, String y_adi, double y_fiyati) {
  this.id = id;
  this.yemek_id = yemek_id;
  this.y_adi = y_adi;
  this.y_fiyati = y_fiyati;
 }
 
 public String getY_adi() {
  return y_adi;
 }

 public void setY_adi(String y_adi) {
  this.y_adi = y_adi;
 }

 public double getY_fiyati() {
  return y_fiyati;
 }

 public void setY_fiyati(double y_fiyati) {
  this.y_fiyati = y_fiyati;
 }

 
 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public int getYemek_id() {
  return yemek_id;
 }

 public void setYemek_id(int yemek_id) {
  this.yemek_id = yemek_id;
 }
 
 
 
 
 
 
}
