package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ReceptorCliente extends Thread {

    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;
    Socket socket;

    public ReceptorCliente(Socket socket) throws IOException {
        this.socket = socket;
        flujoEntrada = new DataInputStream( socket.getInputStream() );
        flujoSalida = new DataOutputStream( socket.getOutputStream());
    }

    public void run(){
        try{
            while(true){
                String request = recibirRequest();
                contestarRequest(request);
            }
        }catch (Exception e) {
            System.err.println("Error en la conexion"+e.getMessage());
        }finally {
            cerrar();
        }

    }
    public void contestarRequest(String mensaje){
        try{

            flujoSalida.writeUTF(mensaje);
        }catch (IOException e) {
            System.err.println("error al contestar"+e.getMessage());
        }
    }
    public String recibirRequest(){
        try {
            return flujoEntrada.readUTF();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public void cerrar(){
        try{
            socket.close();
        }catch (IOException e) {
            System.err.println("Error al cerrar el socket tcp en cliente"+ e.getMessage());		}
    }
}