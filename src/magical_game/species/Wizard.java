package magical_game.species;

import magical_game.gadget.Power;
import magical_game.gadget.item.Defendo;
import magical_game.gadget.item.Infringo;

public class Wizard extends MagicalCreature {
    public static final int MAX_HEALTH = 100;
    public static final int MAX_ITEMS = 5;

    public Wizard(int damage, Power power) {
        super(MAX_HEALTH, MAX_ITEMS, power);
        addItem(new Defendo(damage));
        addItem(new Infringo(damage));
    }

    @Override
    public String toString() {
        return "Wizard [" + super.toString() + "]";
    }
}
