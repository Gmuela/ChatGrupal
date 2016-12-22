package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServicioServidorTCP extends Thread {

	DataInputStream flujoEntrada;
	DataOutputStream flujoSalida;
	Socket socket;
	String nombre;
	
	public ServicioServidorTCP(Socket socket, String nombre) throws IOException {
		this.socket = socket;
		this.nombre= nombre;
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
			flujoSalida.writeUTF("Desde el servidor, soy el servicio "+nombre+" contesto:"+ mensaje);
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

