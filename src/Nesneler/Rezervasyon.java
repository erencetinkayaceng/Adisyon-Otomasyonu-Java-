
package Nesneler;

/**
 *
 * @author Cruz
 */
public class Rezervasyon {
 
 int id;
 String tarihi;
 String saat;
int masano;

 public Rezervasyon(int id, String tarihi, String saat, int masano) {
  this.id = id;
  this.tarihi = tarihi;
  this.saat = saat;
  this.masano = masano;
 }
 
 public int getMasano() {
  return masano;
 }

 public void setMasano(int masano) {
  this.masano = masano;
 }
 
 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public String getTarihi() {
  return tarihi;
 }

 public void setTarihi(String tarihi) {
  this.tarihi = tarihi;
 }

 public String getSaat() {
  return saat;
 }

 public void setSaat(String saat) {
  this.saat = saat;
 }
 
 
}
