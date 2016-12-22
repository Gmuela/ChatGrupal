package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ReceptorCliente extends Thread {

    private DataInputStream flujoEntrada;
    private Socket socket;

    public ReceptorCliente(Socket socket) throws IOException {
        this.socket = socket;
        flujoEntrada = new DataInputStream(socket.getInputStream());
    }

    public void run(){
        try{
            while(true){
                String request = recibirRequest();
                contestarRequest(request);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            cerrar();
        }

    }
    public void contestarRequest(String mensaje){
        try{
            ArrayList<Socket> socketArrayList = ArraySockets.getSocketArrayList();
            for (Socket thisSocket : socketArrayList) {
                OutputStream outputStream = thisSocket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                dataOutputStream.writeUTF(mensaje);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String recibirRequest(){
        String mensaje = null;
        try {
            mensaje = flujoEntrada.readUTF();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return mensaje;
    }
    public void cerrar(){
        try{
            socket.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}