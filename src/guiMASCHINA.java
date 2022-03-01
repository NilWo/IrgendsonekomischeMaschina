import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class guiMASCHINA implements ActionListener {
    JFrame frame;
    JPanel panel;
    JLabel bombe, countdown;
    JButton button;
    int zeit;


    public void gui () {
        frame = new JFrame();
        panel = new JPanel();

        zeit = 10;

        // Countdown
        countdown = new JLabel(String.valueOf(zeit) + " Sekunden");
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



        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBackground(Color.darkGray);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("guiMASCHINA");
        frame.setMinimumSize(new Dimension(500, 500));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);


        panel.add(countdown);
        panel.add(bombe);
        panel.add(button);


        // Timer
        for(;;) {
            countdown.setText(String.valueOf(zeit) + " Sekunden");
            zeit--;

            try {
                           Thread.sleep(1000);
            }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            if (zeit<0) {
                countdown.setText("Joke's over, you're dead!");
                bombe.setText("Kabumm :)");
                break;
            }
            else if (button.getModel().isArmed()) {
                // button.addActionListener(e -> countdown.setText("Gefahr ausgewichen"));
                countdown.setText("Gefahr ausgewichen :p");
                break;
            }
           }
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        }
    }
