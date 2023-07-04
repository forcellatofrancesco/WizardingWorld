package magical_game.species;

import magical_game.gadget.Power;

/**
 * It is a creature which can use a power.
 */
public class MagicalCreature extends Creature {
    private Power power;

    public MagicalCreature(int maxHealth, int maxItems, Power power) {
        super(maxHealth, maxItems);
        this.power = power;
    }

    public void usePower() {
        power.use();
    }

    @Override
    public String toString() {
        return "MagicalCreature [" + super.toString() + "]";
    }

}
