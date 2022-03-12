package yatzi.categories;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Straight implements Category {

    @Override
    public Integer score(List<Integer> dices) {
        List<Integer> sorted = dices.stream()
            .sorted()
            .collect(Collectors.toList());
        return calculateScore(sorted);
    }

    private Integer calculateScore(List<Integer> sorted) {
        Integer score = 0;
        if (straight().equals(sorted)) {
            score = sorted.stream().reduce(0, Integer::sum);
        }
        return score;
    }

    protected abstract List<Integer> straight();
}
