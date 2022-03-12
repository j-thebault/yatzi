package yatzi.categories;

import java.util.List;

public class Chance implements Category {
    @Override
    public Integer score(List<Integer> dices) {
        return dices.stream().reduce(0, Integer::sum);
    }
}
