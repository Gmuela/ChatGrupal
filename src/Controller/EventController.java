package Controller;

import Server.ServidorTCP;
import Vista.ChatUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventController implements ActionListener {

    private JTextField nick;
    private JTextField host;
    private JTextField textToSend;

    private CommunicationController communicationController;

    public void initFieldsInLogin(JTextField nick, JTextField host) {
        this.nick = nick;
        this.host = host;
    }

    public void initFieldsInChatUI(JTextField textToSend) {
        this.textToSend = textToSend;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonName = button.getName();
        if (buttonName.equalsIgnoreCase("login")) {
            ServidorTCP server = new ServidorTCP();
            server.start();
            FactoryCommunicationController.initController(this.host.getText());
            this.communicationController = FactoryCommunicationController.getController();
            new ChatUI().openChat();
            this.communicationController.enviarMensaje("\n"+this.nick.getText() + " se ha conectado.\n");
        } else if (buttonName.equalsIgnoreCase("send")) {
            String mensaje = this.nick.getText() + ": " + this.textToSend.getText() + "\n";
            this.communicationController.enviarMensaje(mensaje);
            this.textToSend.setText("");
        }
    }
}
