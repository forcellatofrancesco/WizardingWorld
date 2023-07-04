package magical_game.gadget.item;

/**
 * This represents an Item that get usury in time
 */
public interface DegradableItem extends Item {
    /**
     * This represents the decay, the damage of the item
     * 
     * @return damage inflicted to the item everytime it is used
     */
    public int getDecay();

    /**
     * When the item reaches the maximum usury it is broken
     * 
     * @return the maximum usury allowed for the item
     */
    public int getMaxUsury();

    /**
     * Actual usury
     * 
     * @return usury
     */
    public int getUsury();

    /**
     * This method is used to know if the item can be still used
     * 
     * @return true if it is NOT usable anymore, false otherwise
     */
    public default boolean isExhausted() {
        return getUsury() >= getMaxUsury();
    }

    /**
     * This method is used to know if the item can be still used
     * 
     * @return true if it IS usable anymore, false otherwise
     */
    public default boolean isUsable() {
        return getUsury() < getMaxUsury();
    }
}
