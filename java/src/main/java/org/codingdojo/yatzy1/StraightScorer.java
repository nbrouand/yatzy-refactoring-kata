package org.codingdojo.yatzy1;

import java.util.List;

class StraightScorer {

    static int smallStraight(List<Integer> dices) {
        return straight(dices, 1, 5, 15);
    }

    static int largeStraight(List<Integer> dices) {
        return straight(dices, 2, 6, 20);
    }

    private static int straight(List<Integer> dices, int start, int end, int score) {
        for (int i = start; i <= end; i++) {
            if (!dices.contains(i)) {
                return 0;
            }
        }
        return score;
    }
}
