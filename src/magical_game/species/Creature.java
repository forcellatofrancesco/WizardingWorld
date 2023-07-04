package magical_game.species;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import magical_game.gadget.Inventory;
import magical_game.gadget.item.DegradableItem;
import magical_game.gadget.item.Item;
import magical_game.gadget.item.Shield;
import magical_game.gadget.item.Weapon;

/**
 * This represent a basic character for the game.
 */
public class Creature {
    private final int maxItems; /// number of possible items in the inventory
    private final int maxHealth; /// maximum health for the creature
    private final Inventory items; /// inventory that contains items
    private int health; /// current health

    /**
     * Default constructor for a creature.
     * 
     * @param maxHealth maximum health for a creature
     * @param maxItems  maximum number of items that the inventory can contain
     */
    public Creature(int maxHealth, int maxItems) {
        this.health = maxHealth;
        this.maxHealth = maxHealth;
        this.maxItems = maxItems;
        items = new Inventory(maxItems);
    }

    /**
     * This method allows this creature to attack another one
     * 
     * @param opponent creature that suffers the attack
     */
    public void attack(Creature opponent) {
        for (Item item : items) {
            if (item instanceof Weapon) {
                item.use(opponent);
            }
        }
    }

    /**
     * Method to check if the creature has weapons to combat
     * 
     * @return true if the creature has weapons
     */
    public boolean hasWeapons() {
        boolean res = false;
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext() && !res) {
            final Item item = iterator.next();
            if (item instanceof Weapon) {
                final Weapon weapon = (Weapon) item;
                if (!(weapon instanceof DegradableItem)) {
                    res = true;
                } else if (!((DegradableItem) weapon).isExhausted()) {
                    res = true;
                }
            }
        }
        return res;
    }

    /**
     * Method that the creature uses to defend itself
     * 
     * @param defense attack points inflicted by an enemy
     */
    public void defend(int defense) {
        health = Math.max(health - defense, 0);
        if (health > 0) {
            boolean maxed = health == maxHealth;
            Iterator<Item> iterator = items.iterator();
            while (iterator.hasNext() && !maxed) {
                final Item item = iterator.next();
                if (item instanceof Shield) {
                    item.use(this);
                    maxed = health == maxHealth;
                }
            }
            dropUselessItems();
        }
    }

    /**
     * Method that the creature uses to heal itself
     * 
     * @param points that will be healed
     */
    public void heal(int points) {
        health = Math.min(health + points, maxHealth);
    }

    /**
     * This method adds an item to the inventory
     * 
     * @param item to be added to the inventory
     * @return true if it has been added, false if the inventory is full
     */
    public boolean addItem(Item item) {
        return items.add(item);
    }

    /**
     * Method used to drop items which have 100% of usury
     */
    public void dropUselessItems() {
        int i = 0;
        List<Integer> droppable = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof DegradableItem && ((DegradableItem) item).isExhausted()) {
                droppable.add(i);
            }
            i++;
        }
        for (int index : droppable) {
            items.pullOut(index);
        }
    }

    /**
     * Method used to retrieve the items in the inventory
     * 
     * @return items in the inventory
     */
    public Item[] getItems() {
        Item[] res = new Item[items.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = items.getItem(i);
        }
        return res;
    }

    /**
     * This method removes the item at position i and returns it
     * 
     * @param i index where the item mus be dropped
     * @return the dropped item
     */
    public Item pullOutItem(int i) {
        return items.pullOut(i);
    }

    /**
     * Method used to get the maximum number of items
     * 
     * @return the maximum number of items that the inventory can store
     */
    public int getMaxItems() {
        return maxItems;
    }

    /**
     * Method used to get the maximum health available for this creature
     * 
     * @return the maximum health
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Method used to know how many items are actually stored when it is called
     * 
     * @return the number of items stored in the inventory
     */
    public int getItemsSize() {
        return items.size();
    }

    /**
     * Method used to know the health of the creature
     * 
     * @return the health of the creature
     */
    public int getHealth() {
        return health;
    }

    /**
     * Method used to check if the creature is alive
     * 
     * @return true if it is alive, false otherwise
     */
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return "Creature [health=" + health + ", items=" + items.toString() + "]";
    }
}
