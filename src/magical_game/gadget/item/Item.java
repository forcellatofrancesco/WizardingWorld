package magical_game.gadget.item;

import magical_game.species.Creature;

/**
 * This is an item which can affect a creature
 */
public interface Item {
    /**
     * Method used to affect a creature
     * 
     * @param creature the effect of this item is applied to this param
     */
    public void use(Creature creature);
}
