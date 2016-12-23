package Vista;

import Controller.EventController;
import Controller.FactoryEventController;

import javax.swing.*;

public class Login {
    private JPanel loginChatGrupal;
    private JTextField host;
    private JTextField nick;
    private JButton loginButton;

    public Login() {
        FactoryEventController.initController();
        EventController eventController = FactoryEventController.getController();
        eventController.initFieldsInLogin(this.host,this.nick);
        this.loginButton.addActionListener(eventController);
        this.loginButton.setName("login");
    }

    public void openLogin() {
        JFrame frame = new JFrame("JChat");
        JPanel loginChatGrupal = this.loginChatGrupal;
        frame.setContentPane(loginChatGrupal);

        StyleUtil.setIcon(frame);
        StyleUtil.setFrameSize(frame,300,150);
        StyleUtil.setTextFieldSize(this.host, 100, 25);
        StyleUtil.setTextFieldSize(this.nick, 100, 25);
        StyleUtil.setButtonStyle(this.loginButton, 50, 30);
        StyleUtil.setEnterAction(frame, this.loginButton);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
