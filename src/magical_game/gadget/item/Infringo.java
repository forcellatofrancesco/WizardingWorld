package magical_game.gadget.item;

public class Infringo implements Weapon {
    private final int damage;

    public Infringo(int damage) {
        this.damage = damage;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Infringo [damage=" + damage + "]";
    }
}
