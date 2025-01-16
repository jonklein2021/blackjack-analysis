import java.util.ArrayList;

public class Hand {
    private ArrayList<Character> cards;
    private int total;
    private boolean hasAce;
    private String key; // key for strategy table

    public Hand() {
        cards = new ArrayList<>();
        total = 0;
        hasAce = false;
        key = "";
    }

    /**
     * Adds a card to the list, recalculate total and key
     */
    public void take(char card) {
        cards.add(card);

        total += getValue(card);

        if (card == 'A') {
            hasAce = true;
            if (total > 21) {
                total -= 10;
            }
        }

        // calculate key for strategy table
        if (cards.size() == 2 && card == 'A') {
            key = "A," + cards.get(0);
        } else if (cards.size() == 2 && card == cards.get(0)) {
            key = card + "," + card;
        } else {
            key = total + "";
        }
    }

    private int getValue(char card) {
        if (card == 'A') {
            return 11;
        } else if (card == 'T') {
            return 10;
        } else {
            return card - '0';
        }
    }

    /**
     * Clears current cards, resets totals and key
     */
    public void clear() {
        cards.clear();
        hasAce = false;
        total = 0;
        key = "";
    }

    /**
     * @return soft and hard totals as a 2-element array
     */
    public int[] getTotals() {
        return new int[]{hasAce ? total - 10 : total, total};
    }

    /**
     * @return key for strategy table
     */
    public String getKey() {
        return key;
    }

    public ArrayList<Character> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return String.format("Cards: %s\nTotal: %s\nKey: %s\n", cards.toString(), hasAce && total > 10 ? total - 10 + ", " + total : total + "", key);
    }
}
