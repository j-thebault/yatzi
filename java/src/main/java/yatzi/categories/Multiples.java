package yatzi.categories;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Little abstraction class used to handle multiples categories (pairs, three of a kinds...)
 */
public class Multiples {
    private final Map<Integer, Long> dicesCount;

    private Multiples(Map<Integer, Long> dicesCount) {
        this.dicesCount = dicesCount;
    }

    /**
     * Return a {@link Stream<Integer>} containing all the dices that have at least threshold count.
     * @param threshold The minimum dice count that must have the same value
     * @return All the dice values that met condition count >= threshold
     * Exemple : Using a Multiple created with (1,1,2,2,2) :
     * - findMultiple(2) -> [1,2]
     * - findMultiple(3) -> [2]
     * - findMultiple(4) -> []
     */
    public Stream<Integer> findMultiple(Integer threshold){
        return dicesCount.entrySet().stream()
            .filter(diceCount -> diceCount.getValue() >= threshold)
            .map(Map.Entry::getKey);
    }

    public static Multiples fromDices(List<Integer> dices) {
        Map<Integer, Long> dicesCount = dices.stream()
            .collect(
                Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()));
        return new Multiples(dicesCount);
    }
}
