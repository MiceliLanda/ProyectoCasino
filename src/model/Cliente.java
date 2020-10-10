package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

    public static void main(String [] args){

        final String Host ="127.0.0.1";
        final int puerto = 5000;
        DataInputStream in;
        DataOutputStream out;
        Socket sc;

        {
            try {
                sc = new Socket(Host, puerto);
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                out.writeUTF("soy el cliente");
                String mensaje = in.readUTF();
                System.out.println("mensaje");
                sc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
