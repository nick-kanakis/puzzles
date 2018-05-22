package General;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Nicolas on 21/5/2018.
 */
public class EnglishIntTest {
    @Test
    public void testIntToEnglish() throws Exception {
        int input1 = 1123;
        String output1 = " One Thousand One Hundred Twenty Three  ";
        int input2 = 302000;
        String output2 = "Three Hundred Two Thousand   ";

        assertTrue(output1.equals(EnglishInt.intToEnglish(input1)));
        assertTrue(output2.equals(EnglishInt.intToEnglish(input2)));
    }
}
