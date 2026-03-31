/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.db;

import repository.Repository;

/**
 *
 * @author Emilija
 */
public interface DbRepository <T>extends Repository<T>{
    default public void connect() throws Exception{
        DbConnectionFactory.getInstacne().getConnection();
    }
    default public void disconnect() throws Exception{
        DbConnectionFactory.getInstacne().getConnection().close();
    }
    default public void commit() throws Exception{
        DbConnectionFactory.getInstacne().getConnection().commit();
    }
    default public void rollback() throws Exception{
        DbConnectionFactory.getInstacne().getConnection().rollback();
    }
}
