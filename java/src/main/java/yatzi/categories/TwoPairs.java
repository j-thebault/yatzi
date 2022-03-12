package yatzi.categories;

import yatzi.Combinations;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class TwoPairs implements Category {

    @Override
    public Integer score(List<Integer> dices) {
        List<Integer> pairs = findPairs(dices);
        return calculateScore(pairs);
    }

    private List<Integer> findPairs(List<Integer> dices) {
        return Multiples.fromDices(dices)
            .findByThreshold(Combinations.PAIR)
            .collect(Collectors.toList());
    }

    private Integer calculateScore(List<Integer> pairs) {
        Integer score = NO_COMBINATION_SCORE;
        if (pairs.size() == 2) {
            score = new HashSet<>(pairs)
                .stream()
                .map(dice -> dice * 2)
                .reduce(NO_COMBINATION_SCORE, Integer::sum);
        }
        return score;
    }
}
