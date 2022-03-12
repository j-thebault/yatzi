package yatzi.categories;

import java.util.List;

public class Yatzi implements Category {

    @Override
    public Integer score(List<Integer> dices) {
        Integer firstDice = dices.get(0);
        boolean hasDifferentDice = dices.stream().anyMatch(dice -> !firstDice.equals(dice));
        return hasDifferentDice ? 0 : 50;
    }
}
