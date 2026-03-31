/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;


import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Emilija
 */
public class DbConnectionFactory {
    private static DbConnectionFactory instanca;
    private Connection connection;
    public static DbConnectionFactory getInstacne(){
        if(instanca==null){
            instanca=new DbConnectionFactory();
        }return instanca;
    }
    private DbConnectionFactory() {
        try{
            if(connection==null|| connection.isClosed()){
                String url=konfiguracija.Konfiguracija.getInstanca().getProperty("url");
                String username=konfiguracija.Konfiguracija.getInstanca().getProperty("username");
                String password=konfiguracija.Konfiguracija.getInstanca().getProperty("password");
                connection=DriverManager.getConnection(url,username,password);
                connection.setAutoCommit(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public Connection getConnection() {
        return connection;
    }
    
}
