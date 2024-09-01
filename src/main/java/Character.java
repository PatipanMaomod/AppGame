public abstract class Character {
    protected int HP;
    protected int points;
    protected String name;

    public Character(String name, int HP, int points) {
        this.name = name;
        this.HP = HP;
        this.points = points;
    }

    public int getHP() {
        return HP;
    }

    public void setHP() {
        this.HP = HP;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public abstract void takeDamage(int damage);

    public abstract void attack(Character target);
}
