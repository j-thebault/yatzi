package yatzi.categories;

import java.util.List;

public class Yatzi implements Category {

    private static final int YATZI_SCORE = 50;

    @Override
    public Integer score(List<Integer> dices) {
        Integer firstDice = dices.get(0);
        boolean hasDifferentDice = dices.stream().anyMatch(dice -> !firstDice.equals(dice));
        return hasDifferentDice ? NO_COMBINATION_SCORE : YATZI_SCORE;
    }
}
