package magical_game.species;

import magical_game.gadget.item.Weapon;

public class Ogre extends Creature {

    public static final int MAX_HEALTH = 200;
    public static final int MAX_ITEMS = 5;

    public Ogre(final int damage) {
        super(MAX_HEALTH, MAX_ITEMS);
        addItem(new Weapon() {
            @Override
            public int getDamage() {
                return damage;
            }

            @Override
            public String toString() {
                return "OgreBat [damage=" + damage + "]";
            }
        });
    }

    @Override
    public String toString() {
        return "Ogre [" + super.toString() + "]";
    }
}
