public class LogEvent {
    private Player player;
    private Enemy enemy;

    // Constructor to initialize LogEvent with player and enemy
    public LogEvent(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    // Method to print the current state of player and enemy
    public void log() {
        System.out.println(formatLog());
    }

    // Format the log output as a string
    private String formatLog() {
        return player.getName() + " [HP: " + player.getHp() + ", Points: " + player.getPoints() + "]\n" +
                enemy.getName() + " [HP: " + enemy.getHp() + ", Points: " + enemy.getPoints() + "]";
    }
}
