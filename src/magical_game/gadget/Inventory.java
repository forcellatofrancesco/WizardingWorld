package magical_game.gadget;

import java.util.Iterator;

import magical_game.gadget.item.Item;

/**
 * This class represent an inventory of a limited size.
 */
public class Inventory implements Iterable<Item> {
    private final Item[] items; /// Array of items
    private int index; /// index of the next item to be added to the inventory

    /**
     * Constructor of the Inventory
     * 
     * @param length maximum size of the inventory, represents how many items can be
     *               stored
     */
    public Inventory(int length) {
        items = new Item[length];
        index = 0;
    }

    /**
     * Method used to know how many items are actually stored.
     * 
     * @return the number of items stored
     */
    public int size() {
        return index;
    }

    /**
     * Adds a new item to the inventory
     * 
     * @param item to be added
     * @return true if it has been added, false if the inventory was full
     */
    public boolean add(Item item) {
        boolean res = index < items.length;
        if (res) {
            items[index] = item;
            index++;
        }
        return res;
    }

    /**
     * This methods shift all the items in the array to the left by one position,
     * starting from the index param
     * 
     * @param array this is the array to be shifted
     * @param index starting index, the element at its position will be overwritten.
     */
    private static void shiftLeft(Object[] array, int index) {
        for (int i = index + 1; i < array.length; i++) {
            array[i - 1] = array[i];
        }
    }

    /**
     * Method used to extract an Item from the inventory
     * 
     * @param index element to be extracted
     * @return the extracted element
     */
    public Item pullOut(int index) {
        Item res = items[index];
        shiftLeft(items, index);
        this.index--;
        return res;
    }

    /**
     * Returns an item without removing it from the inventory
     * 
     * @param index where the item has been stored
     * @return the item at the index position
     */
    public Item getItem(int index) {
        return items[index];
    }

    @Override
    public String toString() {
        Iterator<Item> iterator = iterator();
        String str = "";
        while (iterator.hasNext()) {
            str += iterator.next();
            if (iterator.hasNext()) {
                str += ", ";
            }
        }
        return "Inventory [" + str + "]";
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < index;
            }

            @Override
            public Item next() {
                return items[i++]; // post increment
            }
        };
    }

}
