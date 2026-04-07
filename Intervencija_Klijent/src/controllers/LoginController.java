/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

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
              String password=String.valueOf(lf.getjPasswordField1().getPassword());
               Komunikacija.getInstance().komunikacija();
               MedicinskiRadnik ulogovani= Komunikacija.getInstance().logIn(email,password);
               if(ulogovani==null){
                   JOptionPane.showMessageDialog(lf, "Niste uspeli daa se ulogujete", "GRESKA",JOptionPane.ERROR_MESSAGE);
               }else{
                  JOptionPane.showMessageDialog(lf, "Uspesno ste se ulogovali", "USPEH",JOptionPane.INFORMATION_MESSAGE); 
                  lf.dispose();
               }
           }
       });
    }

    public void otvoriFormu() {
        lf.setVisible(true);
    }
    
    
}
