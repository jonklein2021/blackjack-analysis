public class Cards {
    final static int DECK_SIZE = 52;
    final static char[] DECK = {
        'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'T', 'T', 'T',
        'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'T', 'T', 'T',
        'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'T', 'T', 'T',
        'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'T', 'T', 'T'
    };

    private char[] cards;
    private int top;

    public Cards(int numDecks) {
        cards = new char[numDecks * DECK_SIZE];
        top = 0;

        for (int i = 0; i < numDecks; i++) {
            System.arraycopy(DECK, 0, cards, i * DECK_SIZE, DECK_SIZE);
        }

        shuffle();
    }

    private void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int j = (int) (Math.random() * cards.length);
            char temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    public char deal() {
        return cards[top++];
    }

    public int remaining() {
        return cards.length - top;
    }

    public void reset() {
        shuffle();
        top = 0;
    }

    public void print() {
        for (int i = top; i < cards.length; i++) {
            System.out.print(cards[i] + " ");
        }
        System.out.println();
    }
}
