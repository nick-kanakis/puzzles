package Java8;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * (CTCI 13.8) Question:
 *  Using Lambda expressions, write a function List<Integer> getRandomSubset(List<Integer> list), that returns a random
 *  subset of arbitrary size. All subsets (including the empty set) should be equally likely to be chosen
 *
 * Mistakes:
 *  -Filter adds a value a value to the list only if the result is true!
 *
 * Solution:
 *  - Iterate each element and flip a coin (random boolean) if result is true add it to the result, else skip it.
 */
public class LambdaRandom {

    public static List<Integer> getRandomSubset(List<Integer> list){
        Random rand = new Random();

        return list.stream()
                .filter( i -> rand.nextBoolean())
                .collect(Collectors.toList());
    }
}
