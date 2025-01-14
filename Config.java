/**
 * Class representing the configuration of the game
 */
public class Config {
    private int numRounds = 12;
    private int numDecks = 1;
    private double money = 200.0;
    private double minBet = 5.0;
    private boolean das = false;
    private boolean allowSurrender = false;

    public Config() {}

    public Config(int n, int c, double m, double b, boolean d, boolean s) {
        numRounds = n;
        numDecks = c;
        money = m;
        minBet = b;
        das = d;
        allowSurrender = s;
    }

    public int getNumRounds() {
        return numRounds;
    }

    public int getNumDecks() {
        return numDecks;
    }

    public double getMoney() {
        return money;
    }

    public double getMinBet() {
        return minBet;
    }

    public boolean getDas() {
        return das;
    }

    public boolean getSurrender() {
        return allowSurrender;
    }

}
