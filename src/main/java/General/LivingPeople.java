package General;

import General.helper.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Question:
 *      Given a list of people with their birth and death years, implement a method to compute the year with the most
 *      number of people alive. You may assume that all people were born between 1900 - 2000. If a person was alive in 1908
 *      and died in 1909 is included as alive in both 1908 & 1909
 *
 * Mistakes:
 *
 * Solution:
 *  - First create 2 arrays one with birth years and one with death years
 *  - Sort the arrays.
 *  - Iterate both arrays and select the min year each time. If this year is a birth year increase the current alive
 *    and check if this is a new record (and move birth ptr).
 *    if the year is a dead year decrease the number of alive (and move death ptr).
 *
 */
public class LivingPeople {
    public static int getMaxPeopleLiving(List<Person> people) {
        int[] born = new int[people.size()];
        int[] death = new int[people.size()];

        //Initialize arrays
        int index = 0;
        for (Person p: people ) {
            born[index]= p.birth;
            death[index]= p.death;
            index++;
        }

        Arrays.sort(born);
        Arrays.sort(death);

        int ptrBorn = 0;
        int ptrDeath = 0;
        int currentAlive = 0;
        int yearWithMaxAlive = 0;
        int maxAlive = 0;

        while(ptrBorn < born.length && ptrDeath < death.length){
            if(born[ptrBorn] < death[ptrDeath]){
                currentAlive ++;
                if(currentAlive > maxAlive){
                    maxAlive = currentAlive;
                    yearWithMaxAlive = born[ptrBorn];
                }

                ptrBorn++;
            } else if (born[ptrBorn] > death[ptrDeath]) {
                currentAlive--;
                ptrDeath++;
            } else {
                // the same year one died and one was born so no change
                ptrBorn++;
                ptrDeath++;
            }
        }

        return yearWithMaxAlive;
    }
}
