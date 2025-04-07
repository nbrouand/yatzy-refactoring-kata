package org.codingdojo.yatzy1;

import org.codingdojo.YatzyCalculator;

import java.util.Arrays;
import java.util.List;

public class Yatzy1 implements YatzyCalculator {

    @Override
    public List<String> validCategories() {
        return Arrays.stream(YatzyCategory.values())
            .map(Enum::name)
            .toList();
    }

    @Override
    public int score(List<Integer> dice, String category) {
        return YatzyCategory.valueOf(category).score(dice);
    }
}
