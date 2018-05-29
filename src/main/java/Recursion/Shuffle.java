package Recursion;

import java.util.Random;

/**
 * (CTCI 17.2) Question:
 *  Write a method to shuffle an array of integers, the shuffle must be perfect, each array.length! permutations must be
 *  equal likely.
 *
 * Mistakes:
 *
 * Solution:
 * - If you had shuffled N-1 elements perfectly how would you shuffle the N element?
 *   Just pick a position from 0 to N-1 to swap the N element with!
 *    Building on that the solution below if fairly self-explanatory!
 *
 */
public class Shuffle {
    public static void shuffleCards(int[] deck) {
        Random rand = new Random();
        for (int i = 1; i < deck.length; i++) {
            int randomIndex = rand.nextInt(i);
            swap(deck, randomIndex, i);
        }
    }

    private static void swap(int[] deck, int index1, int index2) {
        int tmp = deck[index1];
        deck[index1] = deck[index2];
        deck[index2] = tmp;
    }
}
