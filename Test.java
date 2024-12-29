import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test {
    // table representing basic strategy: https://www.blackjackapprenticeship.com/blackjack-strategy-charts/
    public static final HashMap<String, ArrayList<Character>> BASIC_STRATEGY = new HashMap<>();

    // columns are 2 3 4 5 6 7 8 9 T A
    // H = hit, S = stand, D = double, d = double if allowed and stand otherwise
    // X = split, x = split and double if DAS is offered and hit otherwise
    static {
        // hard Totals
        BASIC_STRATEGY.put("17", new ArrayList<>(List.of('S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S')));
        BASIC_STRATEGY.put("16", new ArrayList<>(List.of('S', 'S', 'S', 'S', 'S', 'H', 'H', 'H', 'H', 'H')));
        BASIC_STRATEGY.put("15", new ArrayList<>(List.of('S', 'S', 'S', 'S', 'S', 'H', 'H', 'H', 'H', 'H')));
        BASIC_STRATEGY.put("14", new ArrayList<>(List.of('S', 'S', 'S', 'S', 'S', 'H', 'H', 'H', 'H', 'H')));
        BASIC_STRATEGY.put("13", new ArrayList<>(List.of('S', 'S', 'S', 'S', 'S', 'H', 'H', 'H', 'H', 'H')));
        BASIC_STRATEGY.put("12", new ArrayList<>(List.of('H', 'H', 'S', 'S', 'S', 'H', 'H', 'H', 'H', 'H')));
        BASIC_STRATEGY.put("11", new ArrayList<>(List.of('D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'H')));
        BASIC_STRATEGY.put("10", new ArrayList<>(List.of('D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'H', 'H')));
        BASIC_STRATEGY.put("9", new ArrayList<>(List.of('H', 'D', 'D', 'D', 'D', 'H', 'H', 'H', 'H', 'H')));
        BASIC_STRATEGY.put("8", new ArrayList<>(List.of('H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H')));

        // soft Totals
        BASIC_STRATEGY.put("A,9", new ArrayList<>(List.of('S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S')));
        BASIC_STRATEGY.put("A,8", new ArrayList<>(List.of('S', 'S', 'S', 'S', 'd', 'S', 'S', 'S', 'S', 'S')));
        BASIC_STRATEGY.put("A,7", new ArrayList<>(List.of('d', 'd', 'd', 'd', 'S', 'S', 'H', 'H', 'H', 'H')));
        BASIC_STRATEGY.put("A,6", new ArrayList<>(List.of('H', 'D', 'D', 'D', 'D', 'H', 'H', 'H', 'H', 'H')));
        BASIC_STRATEGY.put("A,5", new ArrayList<>(List.of('H', 'H', 'D', 'D', 'D', 'H', 'H', 'H', 'H', 'H')));
        BASIC_STRATEGY.put("A,4", new ArrayList<>(List.of('H', 'H', 'D', 'D', 'D', 'H', 'H', 'H', 'H', 'H')));
        BASIC_STRATEGY.put("A,3", new ArrayList<>(List.of('H', 'H', 'H', 'D', 'D', 'H', 'H', 'H', 'H', 'H')));
        BASIC_STRATEGY.put("A,2", new ArrayList<>(List.of('H', 'H', 'H', 'D', 'D', 'H', 'H', 'H', 'H', 'H')));
 
        // pair splits
        BASIC_STRATEGY.put("A,A", new ArrayList<>(List.of('X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X')));
        BASIC_STRATEGY.put("T,T", new ArrayList<>(List.of('S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S')));
        BASIC_STRATEGY.put("9,9", new ArrayList<>(List.of('X', 'X', 'X', 'X', 'X', 'S', 'X', 'X', 'S', 'S')));
        BASIC_STRATEGY.put("8,8", new ArrayList<>(List.of('X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X')));
        BASIC_STRATEGY.put("7,7", new ArrayList<>(List.of('X', 'X', 'X', 'X', 'X', 'X', 'H', 'H', 'H', 'H')));
        BASIC_STRATEGY.put("6,6", new ArrayList<>(List.of('x', 'X', 'X', 'X', 'X', 'H', 'H', 'H', 'H', 'H')));
        BASIC_STRATEGY.put("5,5", new ArrayList<>(List.of('D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'H', 'H')));
        BASIC_STRATEGY.put("4,4", new ArrayList<>(List.of('H', 'H', 'H', 'x', 'x', 'H', 'H', 'H', 'H', 'H')));
        BASIC_STRATEGY.put("3,3", new ArrayList<>(List.of('x', 'x', 'X', 'X', 'X', 'X', 'H', 'H', 'H', 'H')));
        BASIC_STRATEGY.put("2,2", new ArrayList<>(List.of('x', 'x', 'X', 'X', 'X', 'X', 'H', 'H', 'H', 'H')));
    }


    public static void usage() {
        System.out.println("Usage: java Test [options]");
        System.out.println("Options:");
        System.out.println("  -h, --help    Print this message");
        System.out.println("  -n  <value>   Specify number of hands to play (Default: 12)");
        System.out.println("  -c  <value>   Specify number of 52-card decks to use (Default: 1)");
        System.out.println("  -m  <value>   Specify amount of money to start with (Default: 200.00)");
        System.out.println("  -b  <value>   Specify minimum bet for each round (Default: 5.00)");
        System.out.println("  -d, --das     Enable doubling after split");
    }

    public static void main(String[] args) {
        int numRounds = 12;
        int numDecks = 1;
        double money = 200.0;
        double minBet = 5.0;
        boolean das = false;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-h") || args[i].equals("--help")) {
                usage();
                return;
            } else if (args[i].equals("-n")) {
                numRounds = Integer.parseInt(args[++i]);
            } else if (args[i].equals("-c")) {
                numDecks = Integer.parseInt(args[++i]);
            } else if (args[i].equals("-m")) {
                money = Double.parseDouble(args[++i]);
            } else if (args[i].equals("-b")) {
                minBet = Double.parseDouble(args[++i]);
            } else if (args[i].equals("-d") || args[i].equals("--das")) {
                das = true;
            } else {
                System.out.println("Invalid option: " + args[i]);
                usage();
                return;
            }
        }

        Cards deck = new Cards(numDecks);
        deck.print();

        System.out.println("Rounds: " + numRounds);
        System.out.println("Decks: " + numDecks);

        // simulate blackjack game logic
        boolean[] score = new boolean[numRounds]; // score[i] is true iff player wins ith round
        for (int i = 0; i < numRounds; i++) {
            // buy in for this round
            money -= minBet;

            ArrayList<Character> playerHand = new ArrayList<>(Arrays.asList(deck.deal(), deck.deal()));
            ArrayList<Character> dealerHand = new ArrayList<>(Arrays.asList(deck.deal(), deck.deal()));

        }

    }
}