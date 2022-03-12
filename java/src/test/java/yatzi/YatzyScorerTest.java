package yatzi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyScorerTest {

    @ParameterizedTest(name = "#{index} - Chance {0}")
    @MethodSource
    public void chanceSpecification(YatzySpecification spec) {
        assertEquals(spec.expectedResult, new YatzyScorer(spec.dices).chance());
    }

    private static Stream<YatzySpecification> chanceSpecification(){
        return Stream.of(
            new YatzySpecification(List.of(2,3,4,5,1), 15),
            new YatzySpecification(List.of(3,3,4,5,1), 16));
    }

    @ParameterizedTest(name = "#{index} - Yatzi {0}")
    @MethodSource
    public void yatziSpecification(YatzySpecification spec) {
        assertEquals(spec.expectedResult, new YatzyScorer(spec.dices).yatzy());
    }

    private static Stream<YatzySpecification> yatziSpecification(){
        return Stream.of(
            new YatzySpecification(List.of(4,4,4,4,4), 50),
            new YatzySpecification(List.of(6,6,6,6,6), 50),
            new YatzySpecification(List.of(6,6,6,6,3), 0)
            );
    }

    @ParameterizedTest(name = "#{index} - Ones {0}")
    @MethodSource
    public void onesSpecification(YatzySpecification spec) {
        assertEquals(spec.expectedResult, new YatzyScorer(spec.dices).ones());
    }

    private static Stream<YatzySpecification> onesSpecification(){
        return Stream.of(
            new YatzySpecification(List.of(1,2,3,4,5), 1),
            new YatzySpecification(List.of(1,2,1,4,5), 2),
            new YatzySpecification(List.of(6,2,2,4,5), 0),
            new YatzySpecification(List.of(1,2,1,1,1), 4)
        );
    }

    @ParameterizedTest(name = "#{index} - Twos {0}")
    @MethodSource
    public void twosSpecification(YatzySpecification spec) {
        assertEquals(spec.expectedResult, new YatzyScorer(spec.dices).twos());
    }

    private static Stream<YatzySpecification> twosSpecification(){
        return Stream.of(
            new YatzySpecification(List.of(1,2,3,2,6), 4),
            new YatzySpecification(List.of(2,2,2,2,2), 10)
        );
    }

    @ParameterizedTest(name = "#{index} - Threes {0}")
    @MethodSource
    public void threesSpecification(YatzySpecification spec) {
        assertEquals(spec.expectedResult, new YatzyScorer(spec.dices).threes());
    }

    private static Stream<YatzySpecification> threesSpecification(){
        return Stream.of(
            new YatzySpecification(List.of(1,2,3,2,3), 6),
            new YatzySpecification(List.of(2,3,3,3,3), 12)
        );
    }

    @ParameterizedTest(name = "#{index} - Fours {0}")
    @MethodSource
    public void foursSpecification(YatzySpecification spec) {
        assertEquals(spec.expectedResult, new YatzyScorer(spec.dices).fours());
    }

    private static Stream<YatzySpecification> foursSpecification(){
        return Stream.of(
            new YatzySpecification(List.of(4,4,4,5,5), 12),
            new YatzySpecification(List.of(4,4,5,5,5), 8),
            new YatzySpecification(List.of(4,5,5,5,5), 4)
        );
    }

    @ParameterizedTest(name = "#{index} - Fives {0}")
    @MethodSource
    public void fivesSpecification(YatzySpecification spec) {
        assertEquals(spec.expectedResult, new YatzyScorer(spec.dices).fives());
    }

    private static Stream<YatzySpecification> fivesSpecification(){
        return Stream.of(
            new YatzySpecification(List.of(4,4,4,5,5), 10),
            new YatzySpecification(List.of(4,4,5,5,5), 15),
            new YatzySpecification(List.of(4,5,5,5,5), 20)
        );
    }

    @ParameterizedTest(name = "#{index} - Sixes {0}")
    @MethodSource
    public void sixesSpecification(YatzySpecification spec) {
        assertEquals(spec.expectedResult, new YatzyScorer(spec.dices).sixes());
    }

    private static Stream<YatzySpecification> sixesSpecification(){
        return Stream.of(
            new YatzySpecification(List.of(4,4,4,5,5), 0),
            new YatzySpecification(List.of(4,4,6,5,5), 6),
            new YatzySpecification(List.of(6,5,6,6,5), 18)
        );
    }

    @ParameterizedTest(name = "#{index} - One Pair {0}")
    @MethodSource
    public void onePairSpecification(YatzySpecification spec) {
        assertEquals(spec.expectedResult, new YatzyScorer(spec.dices).onePair());
    }

    private static Stream<YatzySpecification> onePairSpecification(){
        return Stream.of(
            // Adding some spec from https://sammancoaching.org/kata_descriptions/yatzy.html
            // The "no pair" dataset seems important to me and was not included in original test set
            // The (x,x,x,x,y) was also important to check that pair always give value * 2 even with more than two dices have the same value
            new YatzySpecification(List.of(1,2,3,4,5), 0),
            new YatzySpecification(List.of(3,4,3,5,6), 6),
            new YatzySpecification(List.of(3,3,3,3,1), 6),
            new YatzySpecification(List.of(5,3,3,3,5), 10),
            new YatzySpecification(List.of(5,3,6,6,5), 12)
        );
    }

    @ParameterizedTest(name = "#{index} - Two Pairs {0}")
    @MethodSource
    public void twoPairsSpecification(YatzySpecification spec) {
        assertEquals(spec.expectedResult, new YatzyScorer(spec.dices).twoPairs());
    }

    private static Stream<YatzySpecification> twoPairsSpecification(){
        return Stream.of(
            // Same as onePairSpecification, I added a "no match" spec that check the 0 score.
            new YatzySpecification(List.of(1,2,3,4,5), 0),
            new YatzySpecification(List.of(3,3,5,4,5), 16),
            new YatzySpecification(List.of(3,3,5,5,5), 16)
        );
    }

    @Test
    public void three_of_a_kind()
    {
        assertEquals(9, YatzyScorer.three_of_a_kind(3,3,3,4,5));
        assertEquals(15, YatzyScorer.three_of_a_kind(5,3,5,4,5));
        assertEquals(9, YatzyScorer.three_of_a_kind(3,3,3,3,5));
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, YatzyScorer.four_of_a_kind(3,3,3,3,5));
        assertEquals(20, YatzyScorer.four_of_a_kind(5,5,5,4,5));
        assertEquals(9, YatzyScorer.three_of_a_kind(3,3,3,3,3));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, YatzyScorer.smallStraight(1,2,3,4,5));
        assertEquals(15, YatzyScorer.smallStraight(2,3,4,5,1));
        assertEquals(0, YatzyScorer.smallStraight(1,2,2,4,5));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, YatzyScorer.largeStraight(6,2,3,4,5));
        assertEquals(20, YatzyScorer.largeStraight(2,3,4,5,6));
        assertEquals(0, YatzyScorer.largeStraight(1,2,2,4,5));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, YatzyScorer.fullHouse(6,2,2,2,6));
        assertEquals(0, YatzyScorer.fullHouse(2,3,4,5,6));
    }

    static class YatzySpecification {
        public final List<Integer> dices;
        public final Integer expectedResult;

        YatzySpecification(List<Integer> dices, Integer expectedResult) {
            this.dices = dices;
            this.expectedResult = expectedResult;
        }

        @Override
        public String toString() {
            return
                "with dices " + dices +
                " should give a score of " + expectedResult;
        }
    }
}
