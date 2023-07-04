import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import magical_game.MagicalGame;
import magical_game.gadget.item.Item;
import magical_game.species.Creature;
import magical_game.species.Jedi;
import magical_game.species.Ogre;
import magical_game.species.Wizard;
import magical_game.PrettyPrinter;

public class App {
    public static void main(String[] args) throws Exception {
        MagicalGame magicalGame = MagicalGame.instance();
        Scanner scanner = new Scanner(System.in);
        Creature hero = magicalGame.getHero();
        boolean play = false;
        Random random = new Random();
        do {
            magicalGame.addEnemy(new Ogre(random.nextInt(15) + 5));
            magicalGame.addEnemy(new Wizard(random.nextInt(15) + 5, () -> magicalGame.addEnemy(new Ogre(5))));
            magicalGame.addEnemy(new Jedi(random.nextInt(15) + 15, () -> {
                if (random.nextBoolean()) {
                    hero.pullOutItem(0);
                }
            }));
            while (magicalGame.isThereAnyEnemy() && hero.isAlive()) {
                Creature enemy = magicalGame.defeatEnemy((creature) -> System.out.println(creature));
                if (hero.isAlive() && !enemy.isAlive()) {
                    System.out.println("You are still alive!");
                    PrettyPrinter.printlnBlue("You have defeated " + enemy);
                    hero.dropUselessItems();
                    System.out.println(magicalGame.getHero());
                    List<Item> droppedItems = magicalGame.getDroppedItems();
                    for (Item dropped : droppedItems) {
                        System.out.println("The enemy has dropped this item:");
                        PrettyPrinter.printlnPurple(dropped);
                        PrettyPrinter.printlnGreen("Inventory: " + Arrays.toString(hero.getItems()));
                        if (hero.getItemsSize() < hero.getMaxItems()) {
                            System.out.println("Do you want to add this item to your inventory?[Y/n]");
                            String input = scanner.nextLine();
                            if (input.isEmpty() || input.toLowerCase().equals("y")) {
                                hero.addItem(dropped);
                            }
                        } else {
                            System.out.println(
                                    "There is not enough space in your inventory.\nIf you want to drop an Item, type its index: "
                                            + 0 + "-" + (hero.getMaxItems() - 1) + " [N]");
                            String input = scanner.nextLine();
                            int index;
                            if (!input.isEmpty() && (index = Integer.parseInt(input)) < hero.getMaxItems()) {
                                hero.pullOutItem(index);
                                hero.addItem(dropped);
                            }
                        }
                    }
                } else {
                    PrettyPrinter.printlnRed("You are dead...\n" + hero);
                    PrettyPrinter.printlnYellow(enemy);
                }
            }
            System.out.println("Do you want to continue?[y/N]");
            String input = scanner.nextLine();
            if (input.isEmpty() || input.toLowerCase().equals("n")) {
                play = false;
            } else if (input.toLowerCase().equals("y")) {
                play = true;
            }
        } while (play);
        PrettyPrinter.printlnYellow("You have made " + magicalGame.getPoints() + " points!");
        scanner.close();
    }
}
