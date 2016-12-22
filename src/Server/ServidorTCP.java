package Server;

import Model.ClientInterface;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP extends Thread implements ClientInterface{

	ServerSocket serverSocket;
	Socket socket;
	
	public ServidorTCP(Socket socket) throws IOException{
		serverSocket = new ServerSocket(PUERTO);
		this.socket = socket;
	}
	
	public void run(){
		servir();
	}
	public void servir(){
		int i=0;
		while(true){
			try {
				Socket socket = serverSocket.accept();
				ReceptorCliente cliente = new ReceptorCliente(socket);
				i++;
				cliente.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
