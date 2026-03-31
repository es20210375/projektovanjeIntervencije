/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konfiguracija;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Emilija
 */
public class Konfiguracija {
    private static Konfiguracija instanca;
     Properties konfiguracija;
    private Konfiguracija() {
        try{
        konfiguracija=new Properties();
        konfiguracija.load(new FileInputStream("C:\\Users\\Emilija\\Desktop\\Projekat softveri\\Intervencija_Server\\config\\config.properties"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static Konfiguracija getInstanca(){
        if(instanca==null){
            instanca=new Konfiguracija();
        }return instanca;
    }
    
 public String getProperty(String key){
  return konfiguracija.getProperty(key,"n/a");
}
 public void setProperty(String key,String value){
     konfiguracija.setProperty(key, value);
 }
 public void SacuvajIzmene(){
     try {
         konfiguracija.store(new FileOutputStream("C:\\Users\\Emilija\\Desktop\\Projekat softveri\\Intervencija_Server\\config\\config.properties"),null);
     } catch (Exception e) {
         e.printStackTrace();
     }
 }
}