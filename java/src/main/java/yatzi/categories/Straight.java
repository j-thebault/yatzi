package yatzi.categories;

import yatzi.utils.DiceUtils;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Straight implements Category {

    @Override
    public Integer score(List<Integer> dices) {
        List<Integer> sortedDices = sortDices(dices);
        return calculateScore(sortedDices);
    }

    private List<Integer> sortDices(List<Integer> dices) {
        return dices.stream()
            .sorted()
            .collect(Collectors.toList());
    }

    private Integer calculateScore(List<Integer> sorted) {
        Integer score = NO_COMBINATION_SCORE;
        if (straight().equals(sorted)) {
            score = DiceUtils.sum(sorted);
        }
        return score;
    }

    protected abstract List<Integer> straight();
}
