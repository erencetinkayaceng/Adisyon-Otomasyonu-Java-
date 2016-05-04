/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Nesneler;

/**
 *
 * @author Cruz
 */
public class Yemek {
 
 int id;
 String y_adi,y_turu,y_bilgisi;
 double y_fiyat;

 public Yemek() {
 
 }
 
 public Yemek(int id, String y_adi, String y_turu, String y_bilgisi, double y_fiyat) {
  this.id = id;
  this.y_adi = y_adi;
  this.y_turu = y_turu;
  this.y_bilgisi = y_bilgisi;
  this.y_fiyat = y_fiyat;
 }

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public String getY_adi() {
  return y_adi;
 }

 public void setY_adi(String y_adi) {
  this.y_adi = y_adi;
 }

 public String getY_turu() {
  return y_turu;
 }

 public void setY_turu(String y_turu) {
  this.y_turu = y_turu;
 }

 public String getY_bilgisi() {
  return y_bilgisi;
 }

 public void setY_bilgisi(String y_bilgisi) {
  this.y_bilgisi = y_bilgisi;
 }

 public double getY_fiyat() {
  return y_fiyat;
 }

 public void setY_fiyat(double y_fiyat) {
  this.y_fiyat = y_fiyat;
 }
 
 
 
}
