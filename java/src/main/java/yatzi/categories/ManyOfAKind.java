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
        Optional<Integer> threeOfAKindScore = Multiples.fromDices(dices)
            .findMultiple(threshold)
            .findFirst()
            .map(dice -> dice * threshold);
        return threeOfAKindScore.orElse(0);
    }
}
