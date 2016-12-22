package Vista;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class UtilView {

    public static final Color BACKGROUND_COLOR = new Color(255, 102, 0);
    public static final Color FOREGROUND_COLOR = Color.WHITE;
    public static final String URL_ICON = "http://www.myiconfinder.com/uploads/iconsets/256-256-f269bbc2a3bd8805b0dccb6c36dd2fac.png";

    public static void setButtonStyle(JButton button, int width, int height) {
        button.setBackground(BACKGROUND_COLOR);
        button.setForeground(FOREGROUND_COLOR);
        button.setPreferredSize(new Dimension(width, height));
        button.setMaximumSize(new Dimension(width, height));
        button.setMinimumSize(new Dimension(width, height));
    }

    public static void setEnterAction(JFrame frame, JButton button) {
        frame.getRootPane().setDefaultButton(button);
    }

    public static void setFrameSize(JFrame frame, int width, int height) {
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
    }

    public static void setTextFieldSize(JTextField myText, int width, int height) {
        myText.setPreferredSize(new Dimension(width, height));
        myText.setMaximumSize(new Dimension(width, height));
        myText.setMinimumSize(new Dimension(width, height));
    }

    public static void setAutoScroll(JTextArea textAreaMensajes) {
        DefaultCaret caret = (DefaultCaret) textAreaMensajes.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }

    public static void setIcon(JFrame frame) {
        try {
            URL urlIcon = new URL(URL_ICON);
            frame.setIconImage(getIconFrom(urlIcon));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage getIconFrom(URL urlIcon) throws IOException {
        return ImageIO.read(urlIcon);
    }

}
