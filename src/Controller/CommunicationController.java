package Controller;

import Model.ClientReceiver;
import Model.ClientTransmitter;
import Model.FactoryClient;

import javax.swing.*;

public class CommunicationController {

    private ClientReceiver clientReceiver;
    private ClientTransmitter clientTransmitter;

    JTextArea chat;

    public CommunicationController(String host) {
        this.clientReceiver = FactoryClient.createClientReceiver(host);
        this.clientTransmitter = FactoryClient.createClientTransmitter(host);
        clientReceiver.start();
    }

    public void initChat(JTextArea textAreaMensajes) {
        this.chat = textAreaMensajes;
    }

    public void enviarMensaje(String mensaje) {
        clientTransmitter.enviarMensaje(mensaje);
    }

    public void recibirMensaje(String mensaje) {
        this.chat.setText(this.chat.getText() + mensaje);
    }
}
