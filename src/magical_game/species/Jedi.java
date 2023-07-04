package magical_game.species;

import magical_game.gadget.Power;
import magical_game.gadget.item.LightSaber;

public class Jedi extends MagicalCreature {
    public static final int MAX_HEALTH = 100;
    public static final int MAX_ITEMS = 5;

    public Jedi(int damage, Power power) {
        super(MAX_HEALTH, MAX_ITEMS, power);
        addItem(new LightSaber(damage));
    }

    @Override
    public String toString() {
        return "Jedi [" + super.toString() + "]";
    }
}
