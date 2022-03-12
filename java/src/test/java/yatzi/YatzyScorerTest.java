package yatzi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void test_threes() {
        assertEquals(6, YatzyScorer.threes(1,2,3,2,3));
        assertEquals(12, YatzyScorer.threes(2,3,3,3,3));
    }



    @Test
    public void fours_test() 
    {
        assertEquals(12, new YatzyScorer(4,4,4,5,5).fours());
        assertEquals(8, new YatzyScorer(4,4,5,5,5).fours());
        assertEquals(4, new YatzyScorer(4,5,5,5,5).fours());
    }

    @Test
    public void fives() {
        assertEquals(10, new YatzyScorer(4,4,4,5,5).fives());
        assertEquals(15, new YatzyScorer(4,4,5,5,5).fives());
        assertEquals(20, new YatzyScorer(4,5,5,5,5).fives());
    }

    @Test
    public void sixes_test() {
        assertEquals(0, new YatzyScorer(4,4,4,5,5).sixes());
        assertEquals(6, new YatzyScorer(4,4,6,5,5).sixes());
        assertEquals(18, new YatzyScorer(6,5,6,6,5).sixes());
    }

    @Test
    public void one_pair() {
        assertEquals(6, YatzyScorer.score_pair(3,4,3,5,6));
        assertEquals(10, YatzyScorer.score_pair(5,3,3,3,5));
        assertEquals(12, YatzyScorer.score_pair(5,3,6,6,5));
    }

    @Test
    public void two_Pair() {
        assertEquals(16, YatzyScorer.two_pair(3,3,5,4,5));
        assertEquals(16, YatzyScorer.two_pair(3,3,5,5,5));
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
