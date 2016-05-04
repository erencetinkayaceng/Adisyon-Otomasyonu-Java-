package Nesneler;

/**
 *
 * @author Cruz
 */
public class Masa {
 
 int id,rezervasyon_id,masaNo;

 public Masa(int id, int rezervasyon_id, int masaNo) {
  this.id = id;
  this.rezervasyon_id = rezervasyon_id;
  this.masaNo = masaNo;
 }

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public int getRezervasyon_id() {
  return rezervasyon_id;
 }

 public void setRezervasyon_id(int rezervasyon_id) {
  this.rezervasyon_id = rezervasyon_id;
 }

 public int getMasaNo() {
  return masaNo;
 }

 public void setMasaNo(int masaNo) {
  this.masaNo = masaNo;
 }
 
 
}
