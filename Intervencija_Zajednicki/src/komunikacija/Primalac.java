/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emilija
 */
public class Primalac {
    private ObjectInputStream ois;

    public Primalac(Socket socket) {
        try {
            this.ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object primi() {
        try {
            return ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
