package org.codingdojo.yatzy1;

import java.util.List;

import static java.util.Collections.frequency;

public class NOfAKindScorer {

    public static int pair(List<Integer> dices) {
        return nOfAKind(dices, 2);
    }

    public static int threeOfAKind(List<Integer> dices) {
        return nOfAKind(dices, 3);
    }

    public static int fourOfAKind(List<Integer> dices) {
        return nOfAKind(dices, 4);
    }

    private static int nOfAKind(List<Integer> dices, int n) {
        for (int i = 6; i >= 1; i--) {
            if (frequency(dices, i) >= n) {
                return i * n;
            }
        }
        return 0;
    }
}
