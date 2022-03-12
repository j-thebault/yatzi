package yatzi.categories;

import java.util.List;

public class SmallStraight extends Straight{

    private static final List<Integer> SMALL_STRAIGHT = List.of(1, 2, 3, 4, 5);

    @Override
    protected List<Integer> straight() {
        return SMALL_STRAIGHT;
    }
}
