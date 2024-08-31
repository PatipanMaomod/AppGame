import java.util.Scanner;

public class GamePlay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // รับชื่อของ Player
        System.out.print("Enter player name: ");
        String playerName = sc.nextLine();

        // สร้างผู้เล่นด้วยชื่อที่ป้อน
        Player player = new Player(playerName);
        Enemy enemy = new Enemy("kiki", 30);
        RollDice rollDice = new RollDice();

        GameEvent gameEven = new GameEvent(player, enemy, rollDice, sc);
        gameEven.startGame();
        sc.close();
    }
}
