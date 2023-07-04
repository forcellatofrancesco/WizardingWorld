package magical_game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.function.Consumer;

import magical_game.gadget.item.HealthPotion;
import magical_game.gadget.item.Item;
import magical_game.gadget.item.Sword;
import magical_game.species.Creature;
import magical_game.species.Human;
import magical_game.species.MagicalCreature;

/**
 * Object used to create and play a game.
 */
public class MagicalGame {
    private static MagicalGame gameTable;

    private Human hero;

    private final Queue<Creature> enemies;

    private final List<Item> droppedItems;

    private int points;

    /**
     * Private constructor. It can be called only inside of this class.
     */
    private MagicalGame() {
        enemies = new LinkedList<>();
        droppedItems = new ArrayList<>();
        reset();
    }

    /**
     * This method is used to create an instance. This object is a Singleton object.
     * 
     * @return instance of this Game table
     */
    public static MagicalGame instance() {
        if (gameTable == null) {
            gameTable = new MagicalGame();
        }
        return gameTable;
    }

    /**
     * Method to return the principal character, the hero that must defeat all
     * enemies!
     * 
     * @return the hero of the game.
     */
    public Creature getHero() {
        return hero;
    }

    /**
     * Method to add an enemy to the game.
     * 
     * @param enemy must be defeated by the hero
     */
    public void addEnemy(Creature enemy) {
        enemies.add(enemy);
    }

    /**
     * This method allow the hero to try to defeat an enemy.
     * 
     * @param consumer action that it is performed when the hero or the enemy
     *                 attacks. It can be null.
     * @return defeated enemy.
     */
    public Creature defeatEnemy(Consumer<Creature> consumer) {
        Creature enemy = null;
        if (!enemies.isEmpty() && hero.isAlive()) {
            enemy = enemies.poll();
            while (hero.isAlive() && enemy.isAlive() && hero.hasWeapons()) {
                hero.attack(enemy);
                if (consumer != null) {
                    consumer.accept(enemy);
                }
                enemy.attack(hero);
                if (consumer != null) {
                    consumer.accept(hero);
                }
                if (enemy instanceof MagicalCreature) {
                    ((MagicalCreature) enemy).usePower();
                }
            }
            if (hero.isAlive() && !enemy.isAlive()) {
                points += 10;
                randomDroppedItems();
            }
        }
        return enemy;
    }

    /**
     * Method used to check if there are other enemies to defeat.
     * 
     * @return true if there are enemies to defeat.
     */
    public boolean isThereAnyEnemy() {
        return !enemies.isEmpty();
    }

    /**
     * Method that randomly adds items to the list of dropped items
     */
    private void randomDroppedItems() {
        Random random = new Random();
        int drop = random.nextInt(hero.getMaxItems()) + 1;
        droppedItems.clear();
        for (int i = 0; i < drop; i++) {
            int item = random.nextInt(2);
            switch (item) {
                case 0:
                    droppedItems.add(new Sword(random.nextInt(75) + 25 + points));
                    break;
                case 1:
                    droppedItems.add(new HealthPotion(random.nextInt(75) + 25 + points));
                    break;

            }
        }
    }

    /**
     * Method to get the list of dropped items
     * 
     * @return the list of dropped items
     */
    public List<Item> getDroppedItems() {
        return droppedItems;
    }

    /**
     * Get the score obtained by the hero
     * 
     * @return the points scored
     */
    public int getPoints() {
        return points;
    }

    /**
     * Method used to reset the game and make another play.
     */
    public void reset() {
        points = 0;
        hero = new Human();
        hero.addItem(new Sword(new Random().nextInt(75) + 25));
        enemies.clear();
        droppedItems.clear();
    }
}
