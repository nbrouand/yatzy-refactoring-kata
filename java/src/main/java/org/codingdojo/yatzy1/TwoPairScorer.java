package org.codingdojo.yatzy1;

import java.util.List;

import static java.util.Collections.frequency;

class TwoPairScorer {

    static int twoPair(List<Integer> dices) {
        int tmp = 0;
        for (int i = 6; i >= 1; i--) {
            if (frequency(dices, i) >= 2) {
                tmp += i * 2;
            }
        }
        return tmp;
    }
}
