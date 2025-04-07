package org.codingdojo.yatzy1;

import java.util.List;

class UpperSectionScorer {

    static int ones(List<Integer> dices) {
        return scoreNumber(1, dices);
    }

    static int twos(List<Integer> dices) {
        return scoreNumber(2, dices);
    }

    static int threes(List<Integer> dices) {
        return scoreNumber(3, dices);
    }

    static int fours(List<Integer> dices) {
        return scoreNumber(4, dices);
    }

    static int fives(List<Integer> dices) {
        return scoreNumber(5, dices);
    }

    static int sixes(List<Integer> dices) {
        return scoreNumber(6, dices);
    }

    private static int scoreNumber(int number, List<Integer> dices) {
        return dices.stream()
            .filter(d -> d == number)
            .mapToInt(d -> number)
            .sum();
    }
}
