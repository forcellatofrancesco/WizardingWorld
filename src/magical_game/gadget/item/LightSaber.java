package magical_game.gadget.item;

public class LightSaber implements Weapon {
    private final int damage;

    public LightSaber(int damage) {
        this.damage = damage;
    }

    @Override
    public int getDamage() {
        return damage;
    }
}
