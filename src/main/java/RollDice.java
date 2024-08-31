import java.util.Random;

public class RollDice {
    private Random random;

    // Constructor
    public RollDice() {
        this.random = new Random();
    }

    // Method roll the dice and return a number between 1 and 6
    public int roll() {
        return random.nextInt(6) + 1; // Generates a number between 1 and 6
    }

}