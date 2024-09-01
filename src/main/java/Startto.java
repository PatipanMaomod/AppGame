import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Startto extends JFrame {

    private JButton button1;
    private JPanel panel;
    private JLabel label;

    public Startto() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        button1 = new JButton("Start Game");
        label = new JLabel("Celestial Duel:\nThe Ultimate Confrontation");
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        button1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));



        label.setBounds(70, 200, 3000, 30);
        button1.setBounds(330, 270, 150, 30);
        panel.setLayout(null);

        panel.add(label);
        panel.add(button1);

        setContentPane(panel);

        setTitle("GAME GOOD");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNextWindow();
            }
        });
    }



    private void openNextWindow() {
        Arina nextPage = new Arina();
        nextPage.setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Startto();
            }
        });
    }
}
