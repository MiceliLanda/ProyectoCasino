package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {

    public static void main(String [] args){

        Socket sc = null;
        final int puerto = 5000;
        ServerSocket server;
        DataInputStream in;
        DataOutputStream out;

        {
            try {
                server = new ServerSocket(puerto);
                System.out.println("Servioor encendido");

                while(true){
                    sc = server.accept();
                    System.out.println("Client Connected");
                    in = new DataInputStream(sc.getInputStream());
                    out = new DataOutputStream(sc.getOutputStream());

                    String mensaje = in.readUTF();
                    System.out.println(mensaje);

                    out.writeUTF("Mensaje del servidor");

                    sc.close();
                    System.out.println("Client Disconnected");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }





}
