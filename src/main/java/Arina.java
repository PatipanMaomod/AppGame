import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Arina extends JFrame {
    private JButton backButton;
    private JPanel panel;
    private JPanel bottomPanel;
    private TrianglePanel enemyPanel;
    private EllipsePanel playerPanel;
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
    private ImageIcon playerImage;
    private ImageIcon enemyImage;
    private Player player;
    private Enemy enemy;
    private int turnCount = 0;
    Font f = new Font("Comic Sans MS", Font.PLAIN, 20);

    public Arina() {

        panel = new JPanel();
        enemyPanel = new TrianglePanel();
        playerPanel = new EllipsePanel();
        setContentPane(panel);
        panel.setLayout(null);

        player = new Player(JOptionPane.showInputDialog(null, "Enter your name:"),100,0);
        enemy = new Enemy("KIKI",100,0);

        playerImageLabel = new JLabel(playerImage);
        enemyImageLabel = new JLabel(enemyImage);


        backButton = new JButton("Back");
        backButton.setFont(f);
        attackButton = new JButton("Attack");
        attackButton.setFont(f);
        skilsButton = new JButton("Skills");
        skilsButton.setFont(f);
        healButton = new JButton("Heal");
        healButton.setFont(f);
        tSusButton = new JButton("Sus");
        tSusButton.setFont(f);
        rollButton = new CircularButton("Roll");
        rollButton.setFont(f);

        state1 = new JLabel(String.valueOf(player.getName()+" HP: "+player.getHP()));
        state1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        state2 = new JLabel(String.valueOf(enemy.getName()+": "+enemy.getHP()));
        state2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        state3 = new JLabel(String.valueOf("Point : " + player.points));
        state3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        playerImageLabel.setIcon(playerImage);

        playerImage = new ImageIcon(".//res//YOU.png");

        //LOG
        Log = new JLabel("");
        Log.setBounds(50,400,30100,30);
        Log.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Set bounds for components
        backButton.setBounds(650, 500, 100, 30);
        attackButton.setBounds(30, 500, 100, 30);
        skilsButton.setBounds(180, 500, 100, 30);
        healButton.setBounds(330, 500, 100, 30);
        tSusButton.setBounds(480, 500, 100, 30);
        rollButton.setBounds(600, 400, 100, 60);
        playerPanel.setBounds(50, 120, 200, 200);
        enemyPanel.setBounds(500, 120, 200, 250);
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
        panel.add(enemyPanel);
        panel.add(playerPanel);





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
                player.setPoints(player.getPoints() + x);
                Log.setText("+"+x+" point");
                timer.start();
                turnCount++;
                turnEnemy();
                checkGameOver();
                State();

            }
        });

        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.getPoints()>=3) {
                    player.attack(enemy);
                    Log.setText("Attacked! Enemy HP decreased by 10.");
                    turnCount++;
                    turnEnemy();
                    checkGameOver();
                    State();
                }else JOptionPane.showMessageDialog(null, "You don't have enough points!");
            }
        });

        // Implement event handling for other buttons
        skilsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.getPoints() >= 5) {
                    player.useSkill(enemy);
                    Log.setText("Used Skill! Enemy HP decreased by 50.");
                    turnCount++;
                    turnEnemy();
                    checkGameOver();
                    State();
                }else JOptionPane.showMessageDialog(null, "You don't have enough points!");
            }
        });

        healButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.getPoints() >= 5) {
                    player.heal();
                    Log.setText("Heal! +50 HP.");
                    turnCount++;
                    turnEnemy();
                    checkGameOver();
                    State();
                }else JOptionPane.showMessageDialog(null, "You don't have enough points!");
            }
        });


        tSusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.getPoints() >= 20) {
                    player.useSpecialSkill(enemy);
                    Log.setText("Attacked! Enemy HP decreased by 100.");
                    turnCount++;
                    turnEnemy();
                    checkGameOver();
                    State();
                }else JOptionPane.showMessageDialog(null, "You don't have enough points!");
            }

        });


    }
    private void turnEnemy() {
        enemy.setTurnCount(turnCount);
        enemy.attack(player);
    }
    private void State(){
        state1.setText(String.valueOf(player.getName()+" HP: "+player.getHP()));
        state2.setText(String.valueOf(enemy.getName()+ ": "+enemy.getHP()));
        state3.setText(String.valueOf("Point : " + player.getPoints()));
    }
    private void checkGameOver() {
        if (player.getHP() <= 0) {
            state1.setText(player.getName()+" HP :" + player.getHP());
            JOptionPane.showMessageDialog(null, "!!YOU LOST!!");
            setVisible(false);
        } else if (enemy.getHP() <= 0) {
            state2.setText(enemy.getName()+": " + enemy.getHP());
            JOptionPane.showMessageDialog(null, "!!YOU WIN!!");
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
