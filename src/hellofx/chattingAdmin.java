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
public class chattingAdmin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            try {
                ServerSocket servSock = new ServerSocket(4444);
                Socket sock = servSock.accept();//this is the socket of the client
                DataInputStream dis = new DataInputStream(sock.getInputStream());
                System.out.println("Message from Client number " + i + ": " + dis.readUTF());
                
                DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
                dos.writeUTF("Hello from Server!");
                dos.flush();
                dos.close();
                
                servSock.close();
            } catch (Exception ex) {
                Logger.getLogger(chattingAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
            if(i==2){
                break;
            }
        }
    }

}
