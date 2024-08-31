import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Arina extends JFrame {
    private JButton backButton;
    private JPanel panel;
    private JButton attackButton;
    private JButton skilsButton;
    private JButton healButton;
    private JButton tSusButton;
    private JButton rollButton;
    private JLabel state1;
    private JLabel state2;
    private JLabel state3;
    private int HP = 100;
    private int HP2 = 100;
    private int points = 0;


    public Arina() {

        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);

        backButton = new JButton("Back");
        attackButton = new JButton("Attack");
        skilsButton = new JButton("Skills");
        healButton = new JButton("Heal");
        tSusButton = new JButton("TSus");
        rollButton = new JButton("Roll");
        state1 = new JLabel(String.valueOf("Player HP : "+HP));
        state2 = new JLabel(String.valueOf("Enemy HP : "+HP2));
        state3 = new JLabel(String.valueOf("Point : " + points));

        // Set bounds for components
        backButton.setBounds(650, 500, 100, 30);
        attackButton.setBounds(30, 500, 100, 30);
        skilsButton.setBounds(180, 500, 100, 30);
        healButton.setBounds(330, 500, 100, 30);
        tSusButton.setBounds(480, 500, 100, 30);
        rollButton.setBounds(600, 400, 60, 60);
        state1.setBounds(50, 50, 100, 30);
        state2.setBounds(650, 50, 100, 30);
        state3.setBounds(50, 70, 100, 30);


        // Add components to panel
        panel.add(backButton);
        panel.add(attackButton);
        panel.add(skilsButton);
        panel.add(healButton);
        panel.add(tSusButton);
        panel.add(state1);
        panel.add(state2);
        panel.add(state3);
        panel.add(rollButton);

        // Set JFrame properties
        setTitle("GAME GOOD");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        // Add ActionListeners
        backButton.addActionListener(new ActionListener() {
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
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RollDice Roll = new RollDice();
                points += Roll.roll();
                state3.setText(String.valueOf("Point : " + points));
            }
        });

        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (points >= 3) {
                    points -= 3;
                    HP2 -= 10;
                    state2.setText(String.valueOf("Enemy HP : "+HP2));
                    state3.setText(String.valueOf("Point : " + points));
                }else System.out.println("not enough points");
            }
        });

        // Implement event handling for other buttons
        skilsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HP2 -= 50;
                state2.setText(String.valueOf("Enemy HP : "+HP2));
            }
        });

        healButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HP += 10;
                state1.setText(String.valueOf("Player HP : "+HP));
            }
        });

        tSusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HP2 -= 100;
                state2.setText(String.valueOf("Enemy HP : "+HP2));
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
