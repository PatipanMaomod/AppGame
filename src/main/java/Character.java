public class Character {
    private String name;
    private int hp;
    private int points;

    // Constructor
    public Character(String name, int hp, int points) {
        this.name = name;
        this.hp = hp;
        this.points = points;
    }

    // Getter
    public String getName() {

        return name;
    }
    public int getHp() {

        return hp;
    }
    public int getPoints() {

        return points;
    }
    //Setter
    public void setName(String name) {

        this.name = name;
    }
    public void setHp(int hp) {

        this.hp = hp;
    }
    public void setPoints(int points) {

        this.points = points;
    }

    public void addHp(int hp) {

        this.hp += hp;
    }

    // Method ดามาจี
    public void takeDMG(int dmg) {

        hp -= dmg;
    }
    // Method ฮีน
    public void heal(int amount) {

        this.hp += amount;
    }


    public void addPoints(int points) {

        this.points += points;
    }
    public void  subPoints(int points) {

        this.points -= points;
    }

    //บอกค่าตา่งๆ
    @Override
    public String toString() {
        return name + " [HP: " + hp + ", Points: " + points + "]";
    }
}
