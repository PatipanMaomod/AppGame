import javax.swing.*;

public class Player extends Character {

    public Player(String name, int HP, int points) {
        super(name, HP, points);
    }

    @Override
    public void takeDamage(int damage) {
        HP -= damage;
    }

    @Override
    public void attack(Character target) {
        if (points >= 3) {
            points -= 3;
            target.takeDamage(10);
        } else {
            JOptionPane.showMessageDialog(null, "You don't have enough points!", "Insufficient Points", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void heal() {
        if (points >= 5) {
            points -= 5;
            HP += 10;
        } else {
            JOptionPane.showMessageDialog(null, "You don't have enough points!", "Insufficient Points", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void useSkill(Character target) {
        if (points >= 5) {
            points -= 5;
            target.takeDamage(50);
        } else {
            JOptionPane.showMessageDialog(null, "You don't have enough points!", "Insufficient Points", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void useSpecialSkill(Character target) {
        if (points >= 20) {
            points -= 20;
            target.takeDamage(100);
        } else {
            JOptionPane.showMessageDialog(null, "You don't have enough points!", "Insufficient Points", JOptionPane.WARNING_MESSAGE);
        }
    }
}
