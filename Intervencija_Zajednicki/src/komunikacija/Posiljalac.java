/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emilija
 */
public class Posiljalac {
    private ObjectOutputStream oos;

    public Posiljalac(Socket socket) {
        try {
            this.oos = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void posalji(Object obj) {
        try {
            oos.writeObject(obj);
            oos.flush();
            oos.reset(); // VAŽNO
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
