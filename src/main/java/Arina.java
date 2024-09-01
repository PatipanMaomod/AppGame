import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Arina extends JFrame {
    private JButton backButton;
    private JPanel panel;
    private JPanel bottomPanel;
    private JButton attackButton;
    private JButton skilsButton;
    private JButton healButton;
    private JButton tSusButton;
    private CircularButton rollButton;
    private JLabel state1;
    private JLabel state2;
    private JLabel state3;
    private JLabel playerImageLabel;
    private JLabel enemyImageLabel;
    private JLabel Log;
    private JLabel LogEnamy;
    private ImageIcon playerImage;
    private ImageIcon enemyImage;
    private boolean playerTurn = true;
    private int turnCount = 0;
    private int HP = 100;
    private int HP2 = 100;
    private int points = 0;




    public Arina() {

        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);
        playerImage = new ImageIcon("C:\\java\\AppGame\\image\\Player\\images.jpg");
        enemyImage = new ImageIcon("C:\\java\\AppGame\\image\\Player\\Waterdispenser.png");

        playerImageLabel = new JLabel(playerImage);
        enemyImageLabel = new JLabel(enemyImage);

        backButton = new JButton("Back");
        attackButton = new JButton("Attack");
        skilsButton = new JButton("Skills");
        healButton = new JButton("Heal");
        tSusButton = new JButton("TSus");
        rollButton = new CircularButton("Roll");
        state1 = new JLabel(String.valueOf("Player HP : "+HP));
        state1.setFont(new Font("Serif", Font.BOLD, 20));

        state2 = new JLabel(String.valueOf("Enemy HP : "+HP2));
        state2.setFont(new Font("Serif", Font.BOLD, 20));

        state3 = new JLabel(String.valueOf("Point : " + points));
        state3.setFont(new Font("Serif", Font.BOLD, 20));

        //LOG
        Log = new JLabel("");
        Log.setBounds(50,400,30100,30);
        Log.setFont(new Font("Serif", Font.BOLD, 20));

        LogEnamy = new JLabel("");
        LogEnamy.setFont(new Font("Serif", Font.BOLD, 20));
        LogEnamy.setBounds(500,300,300,30);

        // Set bounds for components
        backButton.setBounds(650, 500, 100, 30);
        attackButton.setBounds(30, 500, 100, 30);
        skilsButton.setBounds(180, 500, 100, 30);
        healButton.setBounds(330, 500, 100, 30);
        tSusButton.setBounds(480, 500, 100, 30);
        rollButton.setBounds(600, 400, 100, 60);
        state1.setBounds(50, 50, 1000, 30);//player
        state2.setBounds(600, 50, 1000, 30);//enemy
        state3.setBounds(50, 70, 1000, 30);//point
        playerImageLabel.setBounds(50, 120, 200, 200);
        enemyImageLabel.setBounds(500, 120, 200, 250);


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
        panel.add(playerImageLabel);
        panel.add(enemyImageLabel);
        panel.add(Log);



        // bottom
        bottomPanel = new JPanel();
        bottomPanel.setBounds(0, 450, 800, 500);
        bottomPanel.setBackground(Color.GRAY);
        bottomPanel.setLayout(null);

        // Set JFrame properties
        setTitle("GAME GOOD");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        panel.add(bottomPanel);


        // Add ActionListeners
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNextWindow();
            }

            private void openNextWindow() {
                Startto NextPag = new Startto();
                NextPag.setVisible(true);
                setVisible(false);
            }
        });

        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Log.setText("");
            }
        });
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RollDice Roll = new RollDice();
                int x = Roll.roll(6, 1);
                points += x;
                Log.setText("+"+x+" point");
                timer.start();
                State();
                turnEnemy();
                checkGameOver();
                turnCount++;
            }
        });

        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (playerTurn && points >= 3) {
                    points -= 3;
                    HP2 -= 10;
                    Log.setText("Attacked! Enemy HP decreased by 10.");
                    State();
                    turnEnemy();
                    checkGameOver();
                    turnCount++;
                }else JOptionPane.showMessageDialog(null, "You don't have enough points!");
            }
        });

        // Implement event handling for other buttons
        skilsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (points >= 5) {
                    points -= 5;
                    HP2 -= 50;
                    Log.setText("Used Skill! Enemy HP decreased by 50.");
                    State();
                    turnEnemy();
                    checkGameOver();
                    turnCount++;
                }else JOptionPane.showMessageDialog(null, "You don't have enough points!");
            }
        });

        healButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (points >= 5) {
                    points -= 5;
                    HP += 10;
                    Log.setText("Heal! +50 HP.");
                    State();
                    turnEnemy();
                    checkGameOver();
                    turnCount++;
                }else JOptionPane.showMessageDialog(null, "You don't have enough points!");

            }
        });

        tSusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (points >= 20) {
                    points -= 20;
                    HP2 -= 100;
                    Log.setText("Attacked! Enemy HP decreased by 100.");

                    State();
                    turnEnemy();
                    checkGameOver();
                    turnCount++;
                }else JOptionPane.showMessageDialog(null, "You don't have enough points!");

            }

        });

    }

    private void State(){
        state1.setText(String.valueOf("Player HP : "+HP));
        state2.setText(String.valueOf("Enemy HP : "+HP2));
        state3.setText(String.valueOf("Point : " + points));
    }
    private void turnEnemy(){
        RollDice rd = new RollDice();
        if (turnCount ==3 ) {
            int damage = rd.roll(5, 15);
            JOptionPane.showMessageDialog(null, "Enemy Attack, player's HP decreased by "+damage+".");
            HP -= damage;
        }if (turnCount ==5) {
            int damage = rd.roll(15, 30);
            JOptionPane.showMessageDialog(null, "Enemy Attack, player's HP decreased by "+damage+".");
            HP -= damage;
        }if (turnCount ==8) {
            int damage = rd.roll(30, 65);
            JOptionPane.showMessageDialog(null, "Enemy Attack, player's HP decreased by "+damage+".");
            HP -= damage;
        }if (turnCount >10) {
            int damage = rd.roll(70, 100);
            JOptionPane.showMessageDialog(null, "Enemy Attack, player's HP decreased by "+damage+".");
            HP -= damage;
        }
        State();
    }

    private void checkGameOver() {
        if (HP <= 0) {
            HP = 0;
            state1.setText("Player HP : " + HP);
            JOptionPane.showMessageDialog(null, "YOU LOST!!");
            setVisible(false);
        } else if (HP2 <= 0) {
            HP2 = 0;
            state2.setText("Enemy HP : " + HP2);
            JOptionPane.showMessageDialog(null, "YOU WIN!!");
            setVisible(false);
        }

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
