package yatzi.categories;

import java.util.List;
import java.util.stream.Collectors;

public class SmallStraight implements Category {

    private static final List<Integer> SMALL_STRAIGHT = List.of(1, 2, 3, 4, 5);

    @Override
    public Integer score(List<Integer> dices) {
        List<Integer> sorted = dices.stream()
            .sorted()
            .collect(Collectors.toList());
        return sorted.equals(SMALL_STRAIGHT) ? 15 : 0;
    }
}
