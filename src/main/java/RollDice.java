import java.util.Random;

public class RollDice {
    private Random random;

    // Constructor
    public RollDice() {
        this.random = new Random();
    }
    public int roll(int n ,int m ) {
        return random.nextInt(n) + m;
    }
}
