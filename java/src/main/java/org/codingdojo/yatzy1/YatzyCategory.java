package org.codingdojo.yatzy1;

import java.util.List;
import java.util.function.Function;

enum YatzyCategory {
    ONES(UpperSectionScorer::ones),
    TWOS(UpperSectionScorer::twos),
    THREES(UpperSectionScorer::threes),
    FOURS(UpperSectionScorer::fours),
    FIVES(UpperSectionScorer::fives),
    SIXES(UpperSectionScorer::sixes),

    PAIR(NOfAKindScorer::pair),
    TWO_PAIRS(TwoPairScorer::twoPair),
    THREE_OF_A_KIND(NOfAKindScorer::threeOfAKind),
    FOUR_OF_A_KIND(NOfAKindScorer::fourOfAKind),
    SMALL_STRAIGHT(StraightScorer::smallStraight),
    LARGE_STRAIGHT(StraightScorer::largeStraight),
    FULL_HOUSE(FullLowerSection::fullHouse),
    YATZY(YatzyScorer::yatzy),
    CHANCE(ChanceScorer::chance);

    private final Function<List<Integer>, Integer> scoreFunction;

    YatzyCategory(Function<List<Integer>, Integer> scoreFunction) {
        this.scoreFunction = scoreFunction;
    }

    public int score(List<Integer> dices) {
        return scoreFunction.apply(dices);
    }
}