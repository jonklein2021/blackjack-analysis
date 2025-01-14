import java.util.ArrayList;

public class Hand {
    private ArrayList<Character> cards;
    private int softTotal, hardTotal;
    private String key; // key for strategy table

    public Hand() {
        cards = new ArrayList<>();
        softTotal = hardTotal = 0;
        key = "";
    }

    /**
     * Adds a card to the list, recalculate totals and key
     */
    public void take(char card) {
        cards.add(card);
    }

    /**
     * Clears current cards, resets totals and key
     */
    public void clear() {
        cards.clear();
        softTotal = hardTotal = 0;
        key = "";
    }

    /**
     * @return soft and hard totals as a 2-element array
     */
    public int[] getTotals() {
        return new int[]{softTotal, hardTotal};
    }

    /**
     * @return key for strategy table
     */
    public String getKey() {
        return key;
    }
}
