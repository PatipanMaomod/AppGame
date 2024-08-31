import java.util.Scanner;

public class GameEvent {
    private Player player;
    private Enemy enemy;
    private RollDice rollDice;
    private Scanner sc;

    // Constructor to initialize GameEvent with player, enemy, rollDice, and scanner
    public GameEvent(Player player, Enemy enemy, RollDice rollDice, Scanner sc) {
        this.player = player;
        this.enemy = enemy;
        this.rollDice = rollDice;
        this.sc = sc;
    }

    // Start the game
    public void startGame() {
        boolean gameRunning = true;
        while (gameRunning) {
            System.out.print("Do you want to roll the dice? (y/n): ");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("y")) {
                int rollResult = rollDice.roll();
                System.out.println("You rolled a " + rollResult);
                player.setPoints(rollResult);

                int skillType = getSkillType();
                processSkill(skillType);

                // Display updated status
                System.out.println(player);
                System.out.println(enemy);

                // Check for game end conditions
                if (enemy.getHp() <= 0) {
                    System.out.println("Congratulations! You defeated the enemy.");
                    gameRunning = false;
                } else if (player.getHp() <= 0) {
                    System.out.println("Sorry, you have been defeated.");
                    gameRunning = false;
                }

            } else if (choice.equalsIgnoreCase("n")) {
                System.out.println("You chose not to roll the dice.");
            } else {
                System.out.println("Invalid choice. Please enter 'y' or 'n'.");
            }
        }
    }

    // Get skill type from user with validation
    private int getSkillType() {
        int skillType = 0;
        boolean validSkill = false;
        while (!validSkill) {
            System.out.print("Select skill type (1, 2, 3): ");
            if (sc.hasNextInt()) {
                skillType = sc.nextInt();
                sc.nextLine(); // Clear newline character
                if (skillType >= 1 && skillType <= 3) {
                    validSkill = true;
                } else {
                    System.out.println("Invalid skill type. Please enter 1, 2, or 3.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // Clear invalid input
            }
        }
        return skillType;
    }

    // Process the selected skill
    private void processSkill(int skillType) {
        switch (skillType) {
            case 1:
                if (player.getPoints() > 0) {
                    enemy.setHp(enemy.getHp() - 15);
                    player.setPoints(player.getPoints() - 1);
                } else {
                    System.out.println("Not enough points.");
                }
                break;
            case 2:
                if (player.getPoints() >= 5) {
                    enemy.setHp(enemy.getHp() - 5);
                    player.setPoints(player.getPoints() - 3);
                } else {
                    System.out.println("Not enough points.");
                }
                break;
            case 3:
                if (player.getPoints() >= 5) {
                    player.setHp(player.getHp() + 3);
                    player.setPoints(player.getPoints() - 5);
                } else {
                    System.out.println("Not enough points.");
                }
                break;
            default:
                System.out.println("Invalid skill type.");
                break;
        }
    }
}
