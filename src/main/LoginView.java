import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;

public class LoginView {

    NewFrame frame;

    public LoginView() {
        frame = new NewFrame(new LoginPanel());
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginView();
    }

    public class LoginPanel extends JPanel {

        public LoginPanel() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBackground(Color.decode("#ffffff"));
            setBorder(new EmptyBorder(200, 120, 200, 120));
            setFocusable(true);

            try {
                Font semiBoldFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Poppins-SemiBold.ttf"));
                Font regularFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Poppins-Regular.ttf"));
                Font mediumFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Poppins-Medium.ttf"));

                JLabel loginLabel = new JLabel("Login");
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

                CustomTextField nameField = new CustomTextField("Name", "Enter your Name");
                CustomTextField idField = new CustomTextField("Password", "Enter password");

                nameField.setAlignmentX((CustomTextField.LEFT_ALIGNMENT));
                add(nameField);

                idField.setAlignmentX((CustomTextField.LEFT_ALIGNMENT));
                add(idField);

                JButton loginButton = new JButton("Login");

                loginButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        frame.dispose();
                        MainMenu mainMenu = new MainMenu();
                        mainMenu.setVisible(true);
                    }
                });

                loginButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
                loginButton.setFont(semiBoldFont.deriveFont(12f));
                loginButton.setBackground(Color.decode("#3454CF"));
                loginButton.setBorderPainted(false);
                loginButton.setFocusPainted(false);
                loginButton.setForeground(Color.white);
                loginButton.setBorder(new EmptyBorder(12, 140, 12, 140));
                loginButton.setContentAreaFilled(true);
                add(loginButton);


            } catch (FontFormatException | IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
