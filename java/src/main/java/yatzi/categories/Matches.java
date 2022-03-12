package yatzi.categories;

import java.util.List;

public class Matches implements Category {

    private final Integer matchingDice;

    public Matches(Integer matchingDice) {
        this.matchingDice = matchingDice;
    }

    @Override
    public Integer score(List<Integer> dices) {
        return dices.stream()
            .filter(dice -> dice.equals(matchingDice))
            .reduce(NO_COMBINATION_SCORE, Integer::sum);
    }
}
