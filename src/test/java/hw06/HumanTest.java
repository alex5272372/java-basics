package hw06;

import org.junit.Test;
import org.junit.Assert;

public class HumanTest {
    @Test
    public void testToString() {
        Human daughter = new Human("Anna", "Karleone", 1990, 72);
        daughter.setSchedule(0, "Task 1");
        daughter.setSchedule(1, "Task 2");
        daughter.setSchedule(2, "Task 3");

        String expectedResult = "Human{name='Anna', surname='Karleone', year=1990, iq=72, schedule=[[SUNDAY: Task 1][MONDAY: Task 2][TUESDAY: Task 3]]}";
        String actualResult = daughter.toString();
        Assert.assertEquals(expectedResult, actualResult);
    }
}
