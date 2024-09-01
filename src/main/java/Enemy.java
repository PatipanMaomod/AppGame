import javax.swing.*;
import java.util.Random;

public class Enemy extends Character {
    private RollDice rd = new RollDice();
    private int turnCount;

    public Enemy(String name, int HP, int points) {
        super(name, HP, points);
    }

    public void setTurnCount(int turnCount) {
        this.turnCount = turnCount;
    }

    @Override
    public void takeDamage(int damage) {
        HP -= damage;
    }

    public void attack(Character target) {
        int damage = 0;

        // Adjust damage based on turn count
        if (turnCount == 3) {
            damage = rd.roll(5, 15);
            JOptionPane.showMessageDialog(null, "Enemy Attack! Player's HP decreased by " + damage + ".","EnemyTurn", JOptionPane.INFORMATION_MESSAGE);
        } else if (turnCount == 5) {
            damage = rd.roll(15, 30);
            JOptionPane.showMessageDialog(null, "Enemy Attack! Player's HP decreased by " + damage + ".","EnemyTurn", JOptionPane.INFORMATION_MESSAGE);
        } else if (turnCount == 8) {
            damage = rd.roll(30, 65);
            JOptionPane.showMessageDialog(null, "Enemy Attack! Player's HP decreased by " + damage + ".","EnemyTurn", JOptionPane.INFORMATION_MESSAGE);
        } else if (turnCount > 10) {
            damage = rd.roll(70, 100);
            JOptionPane.showMessageDialog(null, "Enemy Attack! Player's HP decreased by " + damage + ".","EnemyTurn", JOptionPane.INFORMATION_MESSAGE);
        }
        target.takeDamage(damage);
    }


}
