/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import cordinator.Cordinator;
import domen.MedicinskiRadnik;
import forme.LoginForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;


/**
 *
 * @author Emilija
 */
public class LoginController {
    private final LoginForma lf;

    public LoginController(LoginForma lf) {
        this.lf = lf;
        addActionLiseners();
    }

    private void addActionLiseners() {
       lf.LoginAddActionLisener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              logIn(e);
           }

           private void logIn(ActionEvent e) {
              String email=lf.getjTextFieldEmail().getText().trim();
              if(!email.contains("@")){
                  JOptionPane.showMessageDialog(lf, "Email mora da sadrzi '@'", "GRESKA",JOptionPane.ERROR_MESSAGE);
                  return;
              }
              String password=String.valueOf(lf.getjPasswordField1().getPassword());
              if(password.length()<8){
                  JOptionPane.showMessageDialog(lf, "Lozinka mora da ima najmanje 8 karaktera", "GRESKA",JOptionPane.ERROR_MESSAGE);
                  return;
              }
               Komunikacija.getInstance().komunikacija();
               MedicinskiRadnik ulogovani= Komunikacija.getInstance().logIn(email,password);
               /*if(ulogovani==null){
                   JOptionPane.showMessageDialog(lf, "Korisnicko ime i sifra nisu ispravni", "GRESKA",JOptionPane.ERROR_MESSAGE);
                   JOptionPane.showMessageDialog(lf, "Ne moze da se otvori glavna forma i meni", "GRESKA",JOptionPane.ERROR_MESSAGE);
               }
               else{
                  JOptionPane.showMessageDialog(lf, "Korisnicko ime i sifra su ispravni", "USPEH",JOptionPane.INFORMATION_MESSAGE); 
                   Cordinator.getInstance().setMr(ulogovani);
                   Cordinator.getInstance().otvoriGlavnuFormu();
                  lf.dispose();
               }*/
           }
       });
    }

    public void otvoriFormu() {
        lf.setVisible(true);
    }

    public LoginForma getLf() {
        return lf;
    }
    
    
}
