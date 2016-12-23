package Vista;

import Controller.CommunicationController;
import Controller.EventController;
import Controller.FactoryCommunicationController;
import Controller.FactoryEventController;

import javax.swing.*;

public class ChatUI {
    private JPanel chatGrupal;

    private JScrollPane mensajesChat;
    private JTextArea textAreaMensajes;

    private JPanel myWriteArea;
    private JTextField myText;
    private JButton buttonSend;

    public ChatUI() {
        CommunicationController controller = FactoryCommunicationController.getController();
        controller.initChat(this.textAreaMensajes);
        EventController eventController = FactoryEventController.getController();
        eventController.initFieldsInChatUI(this.myText);
        this.buttonSend.addActionListener(eventController);
        this.buttonSend.setName("send");
    }

    public void openChat() {
        JFrame frame = new JFrame("JChat");
        JPanel general = this.chatGrupal;
        frame.setContentPane(general);

        StyleUtil.setIcon(frame);
        StyleUtil.setFrameSize(frame, 450, 700);
        StyleUtil.setTextFieldSize(this.myText, 100, 40);
        StyleUtil.setButtonStyle(this.buttonSend, 100, 30);
        StyleUtil.setEnterAction(frame, this.buttonSend);
        StyleUtil.setAutoScroll(this.textAreaMensajes);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
