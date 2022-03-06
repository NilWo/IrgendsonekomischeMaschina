import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiMASCHINA implements ActionListener {
    JFrame frame;
    JPanel panel;
    JLabel countdown, bombe;
    JButton button;

    public void gui (int zeit) {
        frame = new JFrame();
        panel = new JPanel();
        Image icon = Toolkit.getDefaultToolkit().getImage("icon.jpg");

        // Countdown
        countdown = new JLabel(zeit + " Sekunden");
        countdown.setFont(new Font("Arial", Font.BOLD, 24));
        countdown.setHorizontalAlignment(SwingConstants.CENTER);
        countdown.setVerticalAlignment(SwingConstants.CENTER);
        countdown.setForeground(Color.white);

        // Bombe
        bombe = new JLabel("BOMBE");
        bombe.setFont(new Font("Arial", Font.BOLD, 30));
        bombe.setHorizontalAlignment(SwingConstants.CENTER);
        bombe.setVerticalAlignment(SwingConstants.CENTER);
        bombe.setOpaque(true);
        bombe.setBackground(Color.red);
        bombe.setForeground(Color.black);

        // Button
        button = new JButton("Hold to Defuse");
        button.setFont(new Font("Arial", Font.BOLD, 40));
        button.setBackground(Color.white);
        button.setFocusPainted(false);

        // Panel
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBackground(Color.darkGray);

        // Frame
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Bomb Defusal");
        frame.setMinimumSize(new Dimension(500, 500));
        frame.setResizable(false);
        frame.setIconImage(icon);
        frame.pack();
        frame.setVisible(true);

        // Adding to panel
        panel.add(countdown);
        panel.add(bombe);
        panel.add(button);

        // Timer
        for(;;) {
            countdown.setText(zeit + " Sekunden");
            zeit--;
            try {
                if (zeit<0) {
                    countdown.setText("Joke's over, you're dead!");
                    bombe.setText("Kabumm :)");
                    break;
                }
                else if (button.getModel().isArmed()) {
                    countdown.setText("Gefahr ausgewichen :p");
                    break;
                }
                else {
                    Thread.sleep(1000);
                }
            }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
           }
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        }
}