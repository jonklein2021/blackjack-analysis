public class Game {
    Cards deck;
    Strategy strategy;
    boolean das, allowSurrender;
    Hand player, dealer;
    
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
        // ensure there are enough cards to play this round
        if (deck.remaining() < 8) {
            deck.reset();
        }

        // deal cards
        player.take(deck.deal());
        player.take(deck.deal());

        
        // check for player's natural blackjack
        if (player.getTotals()[1] == 21) // many are saying this!
            return true;

        char dealerUpCard = deck.deal();
        dealer.take(dealerUpCard);
        dealer.take(deck.deal());

        boolean busts = false;
        while (!busts) {
            // make decision based on strategy table
            char choice = strategy.decide(player.getKey(), dealerUpCard);

            switch (choice) {
                case 'H': // hit
                    
                    break;
                case 'S': // stand
                    
                    break;
                case 'D': // double
                    
                    break;
                case 'd': // double if allowed, stand otherwise
                    
                    break;
                case 'X': // split (this will be hard)
                    
                    break;
                    
                case 'x': // split and double if DAS is offered, hit otherwise
                    
                    break;
                default:
                    break;
            }
        }
            
        // reset hands for next time
        player.clear();
        dealer.clear();

        return true;
    }
}
