package org.codingdojo.yatzy1;

import java.util.List;

import static java.util.Collections.frequency;

public class YatzyScorer {

    static int yatzy(List<Integer> dices) {
        for (int i = 1; i <= 6; i++) {
            if (frequency(dices, i) == 5) {
                return 50;
            }
        }
        return 0;
    }
}
