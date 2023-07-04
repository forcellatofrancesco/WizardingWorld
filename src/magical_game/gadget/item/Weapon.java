package magical_game.gadget.item;

import magical_game.species.Creature;

/**
 * This class represent an Item that can damage a Creature
 */
public interface Weapon extends Item {

    @Override
    public default void use(Creature magicalCreature) {
        magicalCreature.defend(getDamage());
    }

    /**
     * This method returns the damage that this weapon can inflict
     * 
     * @return the damage
     */
    public int getDamage();
}
