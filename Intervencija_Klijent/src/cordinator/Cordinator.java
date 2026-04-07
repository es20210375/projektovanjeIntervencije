/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cordinator;

import controllers.LoginController;
import forme.LoginForma;

/**
 *
 * @author Emilija
 */
public class Cordinator {
    private static Cordinator instacne;
    private LoginController loginController;
    public static Cordinator getInstance(){
        if(instacne==null){
            instacne=new Cordinator();
        }return instacne;
    }
    private Cordinator() {
    }

    public void otvoriLogInFormu() {
        loginController=new LoginController(new LoginForma());
        loginController.otvoriFormu();
    }
    
    
}
