import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Arina extends JFrame {
    private JButton Button1;
    private JPanel panel;
    private JButton attackButton;
    private JButton skilsButton;
    private JButton healButton;
    private JButton tSusButton;
    private JLabel state1;
    private int HP = 100;

    public Arina() {
        // Initialize components
        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null); // Use absolute positioning

        Button1 = new JButton("Back");
        attackButton = new JButton("Attack");
        skilsButton = new JButton("Skills");
        healButton = new JButton("Heal");
        tSusButton = new JButton("TSus");
        state1 = new JLabel(String.valueOf(HP));

        // Set bounds for components
        Button1.setBounds(650, 500, 100, 30);
        attackButton.setBounds(30, 500, 100, 30);
        skilsButton.setBounds(180, 500, 100, 30);
        healButton.setBounds(330, 500, 100, 30);
        tSusButton.setBounds(480, 500, 100, 30);
        state1.setBounds(50, 50, 100, 30);

        // Add components to panel
        panel.add(Button1);
        panel.add(attackButton);
        panel.add(skilsButton);
        panel.add(healButton);
        panel.add(tSusButton);
        panel.add(state1);

        // Set JFrame properties
        setTitle("GAME GOOD");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        // Add ActionListeners
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNextWindow();
            }

            private void openNextWindow() {
                // Create and show the next window
                Startto NextPag = new Startto();
                NextPag.setVisible(true);
                // Hide this window
                setVisible(false);
            }
        });

        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HP -= 10; // Decrease HP by 10
                state1.setText(String.valueOf(HP));
            }
        });

        // Implement event handling for other buttons
        skilsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Skills button action
            }
        });

        healButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Heal button action
            }
        });

        tSusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TSus button action
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Arina();
            }
        });
    }
}
