package yatzi;

import yatzi.categories.*;

import java.util.List;

public class YatzyScorer {

    private static final int DICE_SET_SIZE = 5;
    private final List<Integer> diceList;

    public YatzyScorer(List<Integer> diceList) {
        // I added a validation here because in old code, the methods have (d1,d2,d3,d4,d5) arguments
        // I don't like methods with so many arguments, but here they had the benefit to indicate to caller the number of expected dices
        validateDiceList(diceList);
        this.diceList = diceList;
    }

    private void validateDiceList(List<Integer> diceList) {
        if (diceList.size() != DICE_SET_SIZE) {
            throw new IllegalArgumentException(String.format("A complete dice set is %s dices", DICE_SET_SIZE));
        }
    }

    public int chance() {
        return score(new Chance());
    }

    public int yatzy() {
        return score(new Yatzi());
    }

    public int ones() {
        return score(new Matches(1));
    }

    public int twos() {
        return score(new Matches(2));
    }

    public int threes() {
        return score(new Matches(3));
    }

    public int fours() {
        return score(new Matches(4));
    }

    public int fives() {
        return score(new Matches(5));
    }

    public int sixes() {
        return score(new Matches(6));
    }

    public int onePair() {
        return score(new ManyOfAKind(2));
    }

    public int twoPairs() {
        return score(new TwoPairs());
    }

    public int threeOfAKind() {
        return score(new ManyOfAKind(3));
    }

    public int fourOfAKind() {
        return score(new ManyOfAKind(4));
    }

    public int smallStraight() {
        return score(new SmallStraight());
    }

    public int largeStraight() {
        return score(new LargeStraight());
    }

    public int fullHouse() {
        return score(new FullHouse());
    }

    private Integer score(Category category) {
        return category.score(diceList);
    }
}



