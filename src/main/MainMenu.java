import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;

public class MainMenu {

    private NewFrame frame;

    public MainMenu() {

        frame = new NewFrame(new MenuPanel());
    }

    public void setVisible(boolean visible) {
        this.frame.setVisible(visible);
    }

    public class MenuPanel extends JPanel {

        public MenuPanel() {

            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBackground(Color.decode("#ffffff"));
            setBorder(new EmptyBorder(200, 120, 200, 120));
            setFocusable(true);

            try {
                Font semiBoldFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Poppins-SemiBold.ttf"));
                Font regularFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Poppins-Regular.ttf"));
                Font mediumFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Poppins-Medium.ttf"));

                JLabel loginLabel = new JLabel("Main Menu");
                loginLabel.setFont(semiBoldFont.deriveFont(24f));
                loginLabel.setForeground(Color.decode("#101727"));
                loginLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
                loginLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
                loginLabel.setFocusable(true);
                add(loginLabel);
                loginLabel.requestFocusInWindow();

                JLabel labelCaption = new JLabel("Welcome back! Please enter your details.");
                labelCaption.setFont(mediumFont.deriveFont(12f));
                labelCaption.setForeground(Color.decode("#B1B9C1"));
                labelCaption.setBorder(new EmptyBorder(0, 0, 32, 0));
                labelCaption.setAlignmentX(JLabel.LEFT_ALIGNMENT);
                add(labelCaption);



            } catch (FontFormatException | IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
