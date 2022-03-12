package yatzi.categories;

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
            .findByThreshold(2)
            .collect(Collectors.toList());
    }

    private Integer calculateScore(List<Integer> pairs) {
        Integer score = 0;
        if (pairs.size() == 2) {
            score = new HashSet<>(pairs)
                .stream()
                .map(dice -> dice * 2)
                .reduce(0, Integer::sum);
        }
        return score;
    }
}
