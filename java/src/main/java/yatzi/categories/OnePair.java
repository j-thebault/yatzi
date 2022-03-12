package yatzi.categories;

import java.util.List;
import java.util.Optional;

public class OnePair implements Category {
    @Override
    public Integer score(List<Integer> dices) {
        Optional<Integer> pairScore = dices.stream()
            .filter(existingDice -> containsPairOf(dices, existingDice))
            .max(Integer::compareTo)
            .map(dice -> dice * 2);
        return pairScore.orElse(0);
    }

    private boolean containsPairOf(List<Integer> dices, Integer existingDice) {
        return dices.stream().filter(existingDice::equals).count() > 1;
    }
}
