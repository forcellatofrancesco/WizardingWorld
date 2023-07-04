package magical_game.gadget.item;

public class Defendo implements Shield {
    private final int defense;

    public Defendo(int defense) {
        this.defense = defense;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public String toString() {
        return "Defendo [defense=" + defense + "]";
    }

}
