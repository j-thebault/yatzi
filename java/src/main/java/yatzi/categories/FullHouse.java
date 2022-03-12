package yatzi.categories;

import java.util.List;
import java.util.Optional;

public class FullHouse implements Category {

    @Override
    public Integer score(List<Integer> dices) {
        Multiples multiples = Multiples.fromDices(dices);
        Optional<Integer> threeOfAKind = multiples.findByExactCount(3).findFirst();
        Optional<Integer> pair = multiples.findByExactCount(2).findFirst();
        if(threeOfAKind.isPresent() && pair.isPresent()){
            return threeOfAKind.get() * 3 + pair.get() * 2;
        } else {
            return 0;
        }
    }
}
