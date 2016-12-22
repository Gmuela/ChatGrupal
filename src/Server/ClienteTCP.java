package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteTCP {

	DataInputStream flujoEntrada;
	DataOutputStream flujoSalida;
	Socket socket;
	
	public ClienteTCP(String host, int puerto) throws UnknownHostException, IOException {
		Socket socket = new Socket( host , puerto );
		flujoEntrada = new DataInputStream( socket.getInputStream() );
		flujoSalida = new DataOutputStream( socket.getOutputStream());
	}
	
	public void enviarMensaje(String mensaje){ 
		try{
		flujoSalida.writeUTF(mensaje);
		}catch (IOException e) {
			// TODO: handle exception
		}
	}
	public String leerRespuesta(){
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


