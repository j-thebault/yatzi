package yatzi.categories;

import java.util.List;
import java.util.Optional;

public class ManyOfAKind implements Category {

    private final Integer threshold;

    public ManyOfAKind(Integer threshold) {
        this.threshold = threshold;
    }

    @Override
    public Integer score(List<Integer> dices) {
        Optional<Integer> score = Multiples.fromDices(dices)
            .findByThreshold(threshold)
            .max(Integer::compareTo)
            .map(dice -> dice * threshold);
        return score.orElse(NO_COMBINATION_SCORE);
    }
}
