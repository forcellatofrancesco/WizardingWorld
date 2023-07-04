package magical_game.gadget.item;

import magical_game.species.Creature;

public class Sword implements Weapon, DegradableItem {
    private final int damage;

    private static final int DECAY = 5;

    private static final int MAX_USURY = 100;

    private int usury;

    public Sword(int damage) {
        this.damage = damage;
        this.usury = 0;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void use(Creature magicalCreature) {
        if (!isExhausted()) {
            Weapon.super.use(magicalCreature);
            usury += DECAY;
        }
    }

    public void repair(int repair) {
        usury = (usury - repair) % MAX_USURY;
    }

    @Override
    public int getDecay() {
        return DECAY;
    }

    @Override
    public int getMaxUsury() {
        return MAX_USURY;
    }

    @Override
    public int getUsury() {
        return usury;
    }

    @Override
    public String toString() {
        return "Sword [damage=" + damage + ", usury=" + usury + "]";
    }
}
