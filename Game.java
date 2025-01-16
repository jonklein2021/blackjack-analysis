import java.util.Scanner;

public class Game {
    Cards deck;
    Strategy strategy;
    boolean das, allowSurrender;
    Hand player, dealer;
    Scanner scanner = new Scanner(System.in);
    
    public Game(Config cfg) {
        this.deck = new Cards(cfg.getNumDecks());
        this.allowSurrender = cfg.getSurrender();
        this.das = cfg.getDas();
        this.strategy = new Strategy();
        this.player = new Hand();
        this.dealer = new Hand();
    }
    
    /**
     * Simulates one hand of blackjack; players' decisions depend on strategy table
     * 
     * @return true if player wins, false if dealer wins
     */
    public boolean run() {
        System.out.println("\n-- New round --\n");
        // reset hands for clean round
        player.clear();
        dealer.clear();

        // ensure there are enough cards to play this round
        if (deck.remaining() < 8) {
            deck.reset();
        }

        // deal cards
        player.take(deck.deal());
        player.take(deck.deal());
        System.out.println("Player:");
        System.out.println(player.toString());

        // check for player's natural blackjack
        if (player.getTotals()[1] == 21) // many are saying this!
            return true;

        char dealerUpCard = deck.deal();
        dealer.take(dealerUpCard);
        dealer.take(deck.deal());
        System.out.println("Dealer: " + dealerUpCard);

        boolean busts = false, stands = false;
        while (!busts && !stands) {
            // make decision based on strategy table
            // char choice = strategy.decide(player.getKey(), dealerUpCard);
            char choice = scanner.nextLine().charAt(0);

            switch (choice) {
                case 'H': // hit
                    player.take(deck.deal());
                    System.out.println("Player:");
                    System.out.println(player.toString());
                    break;
                case 'S': // stand
                    stands = true;
                    break;
                case 'D': // double
                    
                    break;
                case 'd': // double if allowed, stand otherwise
                    
                    break;
                case 'X': // split (this will be hard)
                    
                    break;
                case 'x': // split and double if offered, hit otherwise
                    
                    break;
                default:
                    break;
            }

            if (player.getTotals()[0] > 21 && player.getTotals()[1] > 21) {
                busts = true;
            }
        }
        
        // check if player busts
        if (busts) {
            System.out.println("Player busts");
            return false;
        }

        // dealer's turn
        while (dealer.getTotals()[1] < 17) {
            dealer.take(deck.deal());
            System.out.println("Dealer:");
            System.out.println(dealer.toString());
        }

        // check if dealer busts
        if (dealer.getTotals()[0] > 21 && dealer.getTotals()[1] > 21) {
            System.out.println("Dealer busts");
            return true;
        }

        // compare totals and return result
        int playerScore = player.getTotals()[1] > 21 ? player.getTotals()[0] : player.getTotals()[1];
        int dealerScore = dealer.getTotals()[1] > 21 ? dealer.getTotals()[0] : dealer.getTotals()[1];
        System.out.println("Dealer: " + dealerScore);
        System.out.println("Player: " + playerScore);
        return playerScore > dealerScore;
    }
}
