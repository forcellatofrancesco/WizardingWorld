package magical_game.gadget.item;

import magical_game.species.Creature;

public class HealthPotion implements Shield, DegradableItem {

    private int defense;
    private int usury;

    public HealthPotion(int defense) {
        this.defense = defense;
        usury = 0;
    }

    @Override
    public void use(Creature magicalCreature) {
        if (!isExhausted()) {
            Shield.super.use(magicalCreature);
            usury = getMaxUsury();
        }
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int getDecay() {
        return defense;
    }

    @Override
    public int getMaxUsury() {
        return defense;
    }

    @Override
    public int getUsury() {
        return usury;
    }

    @Override
    public String toString() {
        return "HealthPotion [defense=" + defense + ", usury=" + usury + "]";
    }
}
