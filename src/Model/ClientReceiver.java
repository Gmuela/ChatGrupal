package Model;

import Controller.CommunicationController;
import Controller.FactoryCommunicationController;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientReceiver extends Thread implements ClientInterface {

    private Socket socket;
    private DataInputStream flujoEntrada;
    private CommunicationController communicationController;

    public ClientReceiver(String host) {
        init(host);
    }

    private void init(String host) {
        try {
            this.socket = new Socket(host, PUERTO);
            this.communicationController = FactoryCommunicationController.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while(true){
            recibirRespuesta();
        }
    }

    public void recibirRespuesta() {
        try {
            InputStream inputStream = this.socket.getInputStream();
            this.flujoEntrada = new DataInputStream(inputStream);
            String mensaje = this.flujoEntrada.readUTF();
            CommunicationController communicationController = FactoryCommunicationController.getController();
            communicationController.recibirMensaje(mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
