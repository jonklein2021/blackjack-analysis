public class Test {
    public static void usage() {
        System.out.println("Usage: java Test [options]");
        System.out.println("Options:");
        System.out.println("  -h, --help    Print this message");
        System.out.println("  -n  <value>   Specify number of hands to play (Default: 12)");
        System.out.println("  -c  <value>   Specify number of 52-card decks to use (Default: 8)");
        System.out.println("  -m  <value>   Specify amount of money to start with (Default: 200.00)");
        System.out.println("  -b  <value>   Specify minimum bet for each round (Default: 5.00)");
        System.out.println("  -d, --das     Enable doubling after split");
        System.out.println("  -s, --surrender     Enable surrender");
    }

    public static void main(String[] args) {
        // default values
        int numRounds = 12;
        int numDecks = 1;
        double startingMoney = 200.0;
        double minBet = 5.0;
        boolean das = false;
        boolean allowSurrender = false;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-h") || args[i].equals("--help")) {
                usage();
                return;
            } else if (args[i].equals("-n")) {
                numRounds = Integer.parseInt(args[++i]);
            } else if (args[i].equals("-c")) {
                numDecks = Integer.parseInt(args[++i]);
            } else if (args[i].equals("-m")) {
                startingMoney = Double.parseDouble(args[++i]);
            } else if (args[i].equals("-b")) {
                minBet = Double.parseDouble(args[++i]);
            } else if (args[i].equals("-d") || args[i].equals("--das")) {
                das = true;
            } else if (args[i].equals("-s") || args[i].equals("--surrender")) {
                allowSurrender = true;
            } else {
                System.out.println("Invalid option: " + args[i]);
                usage();
                return;
            }
        }

        // create config and game objects
        Config cfg = new Config(numRounds, numDecks, startingMoney, minBet, das, allowSurrender);
        Game game = new Game(cfg);

        System.out.println("Rounds: " + numRounds);
        System.out.println("Decks: " + numDecks);

        // simulate blackjack game logic
        boolean[] score = new boolean[numRounds]; // score[i] is true iff player wins ith round
        int[] money = new int[numRounds]; // money[i] is the amount of money player has after ith round
        for (int i = 0; i < numRounds; i++) {
            score[i] = game.run();
        }

        // report results

    }
}