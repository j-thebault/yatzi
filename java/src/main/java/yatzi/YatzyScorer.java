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



    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;




        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}


