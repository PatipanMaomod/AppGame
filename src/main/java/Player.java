public class Player {
    private String name;
    private int hp;
    private int points;

    //Constructor player
    public Player(String name) {
        this.name = name;
        this.hp = 20;
        this.points = 0;
    }

    //attributes คุณลักษณะ ของ player
    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public int getPoints() {
        return points;
    }
    //setter methods
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setPoints(int points) {
        this.points = points;
    }

}
