package yatzi.utils;

import java.util.List;

public class DiceUtils {
    public static Integer sum(List<Integer> dices){
        return dices.stream().reduce(0, Integer::sum);
    }
}
