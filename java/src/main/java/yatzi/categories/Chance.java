package yatzi.categories;

import yatzi.utils.DiceUtils;

import java.util.List;

public class Chance implements Category {
    @Override
    public Integer score(List<Integer> dices) {
        return DiceUtils.sum(dices);
    }
}
