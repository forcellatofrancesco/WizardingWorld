package magical_game.species;

public class Human extends Creature {

    public static final int MAX_HEALTH = 100;
    public static final int MAX_ITEMS = 4;

    public Human() {
        super(MAX_HEALTH, MAX_ITEMS);
    }

    @Override
    public String toString() {
        return "Human [" + super.toString() + "]";
    }
}
