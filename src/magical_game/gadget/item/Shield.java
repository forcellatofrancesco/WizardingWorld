package magical_game.gadget.item;

import magical_game.species.Creature;

/**
 * This item can be used to defend a Creature by healing itself
 */
public interface Shield extends Item {

    @Override
    default void use(Creature magicalCreature) {
        magicalCreature.heal(getDefense());
    }

    /**
     * Get the point of health that cen be restored
     * 
     * @return defense points
     */
    public int getDefense();
}
