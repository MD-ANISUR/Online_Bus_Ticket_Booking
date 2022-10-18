/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellofx;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class client1 {
    public static void main(String[] args) {
        String servIP = "localhost";
        int servPort = 4444;
        try {
            ServerSocket servSock = new ServerSocket(4444);
            Socket sock = new Socket(servIP, servPort);
            DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
            dos.writeUTF("Hello from Client!");
            dos.flush();
            dos.close();
            Socket sock1 = servSock.accept();
            
            DataInputStream dis = new DataInputStream(sock.getInputStream());
                System.out.println("Message from server :" + dis.readUTF());
            
            sock.close();
        } catch (Exception ex) {
            Logger.getLogger(client1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}