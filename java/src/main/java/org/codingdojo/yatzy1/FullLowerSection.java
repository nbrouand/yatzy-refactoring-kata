package org.codingdojo.yatzy1;

import java.util.List;

import static java.util.Collections.frequency;
import static org.codingdojo.yatzy1.ChanceScorer.chance;

class FullLowerSection {

    static int fullHouse(List<Integer> dices) {
        boolean hasPair = false;
        boolean hasThree = false;

        for (int i = 1; i <= 6; i++) {
            int frequency = frequency(dices, i);
            if (frequency == 2) hasPair = true;
            if (frequency == 3) hasThree = true;
        }

        return (hasPair && hasThree) ? chance(dices) : 0;
    }
}
