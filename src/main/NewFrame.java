import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class NewFrame extends JFrame {

    public NewFrame(JPanel panel) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(panel);
        setBackground(Color.decode("#ffffff"));
        setIconImage(getImage("icon/icon.png"));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private Image getImage(String filename) {
        try {
            return ImageIO.read(getClass().getResourceAsStream("/" + filename));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
