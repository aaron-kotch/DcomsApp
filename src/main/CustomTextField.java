import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;

public class CustomTextField extends JPanel {

    public CustomTextField(String label, String placeholder) {
        setBackground(Color.decode("#ffffff"));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(4, 0, 20, 0));

        try {
            Font mediumFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Poppins-Medium.ttf"));
            Font semiBoldFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Poppins-SemiBold.ttf"));

            JTextField nameField;

            JLabel textLabel = new JLabel(label);
            textLabel.setFont(semiBoldFont.deriveFont(12f));
            textLabel.setForeground(Color.decode("#454D5A"));
            textLabel.setBorder(new EmptyBorder(0, 0, 6, 0));
            textLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
            add(textLabel);

            nameField = new RoundedTextField(20);
            nameField.setFont(mediumFont.deriveFont(12f));
            nameField.setBackground(Color.decode("#F8F8F8"));
            nameField.setBorder(new EmptyBorder(16, 20, 16, 20));
            nameField.setAlignmentX(RoundedTextField.LEFT_ALIGNMENT);
            add(nameField);

            if (nameField.getText().length() == 0) {
                nameField.setText(placeholder);
                nameField.setForeground(Color.decode("#999999"));
            }

            nameField.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    nameField.setText("");
                    nameField.setForeground(Color.decode("#2b2b2b"));
                }

                @Override
                public void focusLost(FocusEvent e) {
                    nameField.setText(placeholder);
                    nameField.setForeground(Color.decode("#999999"));
                }
            });
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    public class RoundedTextField extends JTextField {

        private Shape shape;
        public RoundedTextField(int size) {
            super(size);
            setOpaque(false);
        }
        protected void paintComponent(Graphics g) {
            g.setColor(Color.decode("#f8f8f8"));
            g.fillRoundRect(0, 0, getWidth()+1, getHeight()+1, 20, 20);
            super.paintComponent(g);
        }
        protected void paintBorder(Graphics g) {
            g.setColor(Color.decode("#f8f8f8"));
            g.drawRoundRect(0, 0, getWidth()+1, getHeight()+1, 20, 20);
        }
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth()+1, getHeight()+1, 20, 20);
            }
            return shape.contains(x, y);
        }
    }
}
