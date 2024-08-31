import java.util.Scanner;

public class GamePlay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //รับชื่อของPlayer
        System.out.print("Enter player name : ");
        String playerName = sc.nextLine();

        //สร้างผู้เล่นด้วยชื่อที่ป้อน
        Player player = new Player(playerName);

        Enemy enemy = new Enemy("kiki", 30);
        RollDice rollDice = new RollDice();

        // แสดงสถานะ
        System.out.println(player);
        System.out.println(enemy);
        //เลือกว่าจะทอยลูกเต๋าหรือไม่

        boolean gameRunning = true;
        while (gameRunning) {
            System.out.print("Do you want to roll the dice? (y/n): ");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("y")) {
                int rollResult = rollDice.roll();
                System.out.println("YOU roller a " + rollResult);
                player.setPoints(rollResult);

                int sk = 0;
                boolean notSkill = false;
                while (!notSkill) {
                    System.out.print("Select skillsType 1, 2, 3: ");
                    if (sc.hasNextInt()) {
                        sk = sc.nextInt();
                        sc.nextLine();

                        if (sk >= 1 && sk <= 3) {
                            notSkill = true;
                        } else {
                            System.out.println("Invalid skill type. Please enter 1, 2, or 3: ");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number: ");
                        sc.nextLine();
                    }
                }

                switch (sk) {
                    case 1:
                        if (player.getPoints() > 0) {
                            enemy.setHp(enemy.getHp() - 15);
                            player.setPoints(player.getPoints() - 1);
                        } else System.out.println("Your point not enough");
                        break;
                    case 2:
                        if (player.getPoints() >= 5) {
                            enemy.setHp(enemy.getHp()- 5);
                            player.setPoints(player.getPoints() - 3);
                        } else System.out.println("Your point not enough");
                        break;
                    case 3:
                        if (player.getPoints() >= 5) {
                            player.setHp(player.getHp() + 3);
                            player.setPoints(player.getPoints() - 5);
                        } else System.out.println("Your point not enough");
                        break;
                    default:
                        System.out.println("Invalid skill type.");
                        break;
                }

                System.out.println(player);
                System.out.println(enemy);

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
}
