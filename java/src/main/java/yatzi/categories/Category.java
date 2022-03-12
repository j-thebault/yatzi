package yatzi.categories;

import java.util.List;

public interface Category {
    int NO_COMBINATION_SCORE = 0;
    Integer score (List<Integer> dices);
}
