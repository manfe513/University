import java.util.ArrayList;

/**
 * Performing basic replacement commands on a particular input WORD
 * E - epsilon, empty symbol
 */
public class NormalAlgorithm {

    private static String IN = "EbababE";

    private static class Replacement {

        String from;
        String to;

        Replacement(String from, String to) {
            this.from = from;
            this.to = to;
        }
    }

    private static final ArrayList<Replacement> REPLACEMENTS = new ArrayList<>();

    static {
        // order is important here,
        // for simplification there's no additional sorting
        REPLACEMENTS.add(new Replacement("ab", "a")); // 1
        REPLACEMENTS.add(new Replacement("b", "E")); // 2
        REPLACEMENTS.add(new Replacement("a", "b")); // 3
    }

    public static void main(String[] args) {
        performCommands();
    }

    private static void performCommands() {
        boolean hasEntry = false;

        System.out.println("\nInput WORD: " + IN);

        for (Replacement r : REPLACEMENTS) {

            while (IN.contains(r.from)) {
                System.out.println("Replacing " + r.from + " -> " + r.to);
                IN = IN.replaceFirst(r.from, r.to);
                System.out.println("Changed WORD: " + IN);
                hasEntry = true;
            }

            if (hasEntry) {
                performCommands();
                break;
            }
        }
    }
}
