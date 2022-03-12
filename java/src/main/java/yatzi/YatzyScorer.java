package yatzi;

import yatzi.categories.*;

import java.util.List;

public class YatzyScorer {

    private final List<Integer> diceList;

    public YatzyScorer(List<Integer> diceList) {
        this.diceList = diceList;
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

    protected Integer[] dice;
    public YatzyScorer(int d1, int d2, int d3, int d4, int _5)
    {
        dice = new Integer[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = _5;
        diceList = null;
    }

    private Integer score(Category category){
        return category.score(diceList);
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
}



