package org.codingdojo.yatzy1;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.frequency;

public class Yatzy1 {

    public static int ones(List<Integer> dices) {
        return scoreNumber(1, dices);
    }

    public static int twos(List<Integer> dices) {
        return scoreNumber(2, dices);
    }

    public static int threes(List<Integer> dices) {
        return scoreNumber(3, dices);
    }

    public static int fours(List<Integer> dices) {
        return scoreNumber(4, dices);
    }

    public static int fives(List<Integer> dices) {
        return scoreNumber(5, dices);
    }

    public static int sixes(List<Integer> dices) {
        return scoreNumber(6, dices);
    }

    private static int scoreNumber(int number, List<Integer> dices) {
        return dices.stream()
            .filter(d -> d == number)
            .mapToInt(d -> number)
            .sum();
    }

    public static int pair(List<Integer> dices) {
        for (int i = 6; i >= 1; i--) {
            if (frequency(dices, i) >= 2) {
                return i * 2;
            }
        }
        return 0;
    }

    public static int twoPair(List<Integer> dices) {
        int tmp = 0;
        for (int i = 6; i >= 1; i--) {
            if (frequency(dices, i) >= 2) {
                tmp += i * 2;
            }
        }
        return tmp;
    }

    public static int threeOfAKind(List<Integer> dices) {
        for (int i = 6; i >= 1; i--) {
            if (frequency(dices, i) >= 3) {
                return i * 3;
            }
        }
        return 0;
    }

    public static int fourOfAKind(List<Integer> dices) {
        for (int i = 6; i >= 1; i--) {
            if (frequency(dices, i) >= 3) {
                return i * 4;
            }
        }
        return 0;
    }

    public static int smallStraight(List<Integer> dices) {
        for (int i = 1; i <= 5; i++) {
            if (!dices.contains(i)) {
                return 0;
            }
        }
        return 15;
    }

    public static int largeStraight(List<Integer> dices) {
        for (int i = 2; i <= 6; i++) {
            if (!dices.contains(i)) {
                return 0;
            }
        }
        return 20;
    }

    public static int fullHouse(List<Integer> dices) {
        boolean hasPair = false;
        boolean hasThree = false;

        for (int i = 1; i <= 6; i++) {
            int frequency = frequency(dices, i);
            if (frequency == 2) hasPair = true;
            if (frequency == 3) hasThree = true;
        }

        return (hasPair && hasThree) ? chance(dices) : 0;
    }

    public static int chance(List<Integer> dices) {
        return dices.stream().mapToInt(Integer::intValue).sum();
    }

    public static int yatzy(List<Integer> dices) {
        for (int i = 1; i <= 6; i++) {
            if (frequency(dices, i) == 5) {
                return 50;
            }
        }
        return 0;
    }
}



