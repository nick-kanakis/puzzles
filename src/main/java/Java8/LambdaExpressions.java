package Java8;

import java.util.List;

/**
 * (CTCI 13.7) Question:
 *      There is a class Country that has methods getContinent() and getPopulation(). Write a function int getPopulation(List<Country> countries, String continent)
 *      that computes the total population of a given continent, given a list of all countries and the name of a continent.
 *
 * Mistakes:
 *  - You can not reference a not final value outside of the lambda function
 *
 * Solution:
 *  1) First filter the result as only a stream of countries that are in the specified continent continue to the next step
 *  2) Create a stream of integers for the contries population
 *  3) Sum all stream.
 *
 */
public class LambdaExpressions {

    public static class Country {
        String continent;
        int population;

        public Country(String continent, int population) {
            this.continent = continent;
            this.population = population;
        }

        public String getContinent() {
            return continent;
        }

        public int getPopulation() {
            return population;
        }
    }

    public static int getPopulation(List<Country> countries, String continent) {
        return countries.stream()
                .filter(c -> c.getContinent().equals(continent))
                .mapToInt( c -> c.getPopulation())
                .sum();
    }
}
