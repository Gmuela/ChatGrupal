package Server;

import Model.ClientInterface;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP extends Thread implements ClientInterface{

	ServerSocket serverSocket;
	Socket socket;
	
	public ServidorTCP(){
		serverSocket = getServerSocket();
	}

	private ServerSocket getServerSocket() {
		ServerSocket serverSocket = null;
		try {
			 serverSocket = new ServerSocket(PUERTO);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return serverSocket;
	}

	public void run(){
		servir();
	}
	private void servir(){

		while(true){
			try {
				socket = serverSocket.accept();
				ArraySockets.addNewSocket(socket);
				ReceptorCliente cliente = new ReceptorCliente(socket);
				cliente.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
