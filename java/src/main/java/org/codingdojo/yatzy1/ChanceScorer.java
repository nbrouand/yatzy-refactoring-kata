package org.codingdojo.yatzy1;

import java.util.List;

public class ChanceScorer {

    static int chance(List<Integer> dices) {
        return dices.stream().mapToInt(Integer::intValue).sum();
    }
}
