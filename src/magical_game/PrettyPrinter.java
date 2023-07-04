package magical_game;

/**
 * Helper class to print colorful text
 */
public class PrettyPrinter {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    /**
     * Method to print a colorful text
     * 
     * @param color  of the text
     * @param object to be printed
     */
    private static void print(String color, Object object) {
        System.out.print(color + object.toString() + ANSI_RESET);
    }

    /**
     * Method to print a colorful text and add a new line
     * 
     * @param color
     * @param object
     */
    private static void println(String color, Object object) {
        print(color, object.toString() + "\n");
    }

    /**
     * Prints in black
     * 
     * @param object to be printed
     */
    public static void printBlack(Object object) {
        print(ANSI_BLACK, object);
    }

    /**
     * Prints in black and adds a new line
     * 
     * @param object to be printed
     */
    public static void printlnBlack(Object object) {
        println(ANSI_BLACK, object);
    }

    /**
     * Prints in red
     * 
     * @param object to be printed
     */
    public static void printRed(Object object) {
        print(ANSI_RED, object);
    }

    /**
     * Prints in red and adds a new line
     * 
     * @param object to be printed
     */
    public static void printlnRed(Object object) {
        println(ANSI_RED, object);
    }

    /**
     * Prints in green
     * 
     * @param object to be printed
     */
    public static void printGreen(Object object) {
        print(ANSI_GREEN, object);
    }

    /**
     * Prints in green and adds a new line
     * 
     * @param object to be printed
     */
    public static void printlnGreen(Object object) {
        println(ANSI_GREEN, object);
    }

    /**
     * Prints in yellow
     * 
     * @param object to be printed
     */
    public static void printYellow(Object object) {
        print(ANSI_YELLOW, object);
    }

    /**
     * Prints in yellow and adds a new line
     * 
     * @param object to be printed
     */
    public static void printlnYellow(Object object) {
        println(ANSI_YELLOW, object);
    }

    /**
     * Prints in blue
     * 
     * @param object to be printed
     */
    public static void printBlue(Object object) {
        print(ANSI_BLUE, object);
    }

    /**
     * Prints in blue and adds a new line
     * 
     * @param object to be printed
     */
    public static void printlnBlue(Object object) {
        println(ANSI_BLUE, object);
    }

    /**
     * Prints in purple
     * 
     * @param object to be printed
     */
    public static void printPurple(Object object) {
        print(ANSI_PURPLE, object);
    }

    /**
     * Prints in purple and adds a new line
     * 
     * @param object to be printed
     */
    public static void printlnPurple(Object object) {
        println(ANSI_PURPLE, object);
    }

    /**
     * Prints in cyan
     * 
     * @param object to be printed
     */
    public static void printCyan(Object object) {
        print(ANSI_CYAN, object);
    }

    /**
     * Prints in cyan and adds a new line
     * 
     * @param object to be printed
     */
    public static void printlnCyan(Object object) {
        println(ANSI_CYAN, object);
    }

    /**
     * Prints in white
     * 
     * @param object to be printed
     */
    public static void printWhite(Object object) {
        print(ANSI_WHITE, object);
    }

    /**
     * Prints in white
     * 
     * @param object to be printed
     */
    public static void printlnWhite(Object object) {
        println(ANSI_WHITE, object);
    }
}
