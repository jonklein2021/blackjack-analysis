import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Strategy {
    // table representing basic strategy: https://www.blackjackapprenticeship.com/blackjack-strategy-charts/
    private static final HashMap<String, ArrayList<Character>> BASIC_STRATEGY = new HashMap<>();
    private HashMap<String, ArrayList<Character>> table;

    // columns are 2 3 4 5 6 7 8 9 T A
    // H = hit, S = stand, D = double, d = double if allowed and stand otherwise
    // X = split, x = split and double if DAS is offered and hit otherwise
    static {
        // hard Totals
        BASIC_STRATEGY.put("19", new ArrayList<>(List.of('S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S')));
        BASIC_STRATEGY.put("18", new ArrayList<>(List.of('S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S', 'S')));
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
        BASIC_STRATEGY.put("7", new ArrayList<>(List.of('H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H')));
        BASIC_STRATEGY.put("6", new ArrayList<>(List.of('H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H')));
        BASIC_STRATEGY.put("5", new ArrayList<>(List.of('H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H')));

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

    public Strategy() {
        table = BASIC_STRATEGY;
    }

    public char decide(String key, int location) {
        return table.get(key).get(location);
    }
}
