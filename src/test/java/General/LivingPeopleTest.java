package General;

import General.helper.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


/**
 * Created by Nicolas on 21/5/2018.
 */
public class LivingPeopleTest {
    @Test
    public void testGetMaxPeopleLiving() throws Exception {
        Person person1 = new Person(1901, 1990);
        Person person2 = new Person(1902, 1989);
        Person person3 = new Person(1903, 1988);
        Person person4 = new Person(1903, 1991);
        Person person5 = new Person(1905, 1906);
        Person person6 = new Person(1904, 1907);

        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);
        people.add(person6);

        assertEquals(1905, LivingPeople.getMaxPeopleLiving(people));
    }
}
