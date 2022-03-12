package yatzi.categories;

import yatzi.utils.DiceUtils;

import java.util.List;

public class FullHouse implements Category {

    @Override
    public Integer score(List<Integer> dices) {
        boolean isFullHouse = isFullHouse(dices);
        if (isFullHouse) {
            return DiceUtils.sum(dices);
        } else {
            return NO_COMBINATION_SCORE;
        }
    }

    private boolean isFullHouse(List<Integer> dices) {
        Multiples multiples = Multiples.fromDices(dices);
        boolean threeOfAKind = multiples.hasExactCount(3);
        boolean pair = multiples.hasExactCount(2);
        return threeOfAKind && pair;
    }
}
