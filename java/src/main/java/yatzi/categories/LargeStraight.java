package yatzi.categories;

import java.util.List;

public class LargeStraight extends Straight{

    private static final List<Integer> LARGE_STRAIGHT = List.of(2, 3, 4, 5,6);

    @Override
    protected List<Integer> straight() {
        return LARGE_STRAIGHT;
    }
}
