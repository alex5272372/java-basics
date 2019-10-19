package hw06;

import org.junit.Test;
import org.junit.Assert;

public class PetTest {
    @Test
    public void testToString() {
        String[] myPetHabits = {"eat", "drink", "sleep"};
        Pet catPet = new Pet(Species.CAT, "tom", 3, 60, myPetHabits);

        String expectedResult = "CAT{nickname='tom', age=3, trickLevel=60, habits=[eat, drink, sleep], numberOfLegs=4, isHasFur=true, isCanFly=false}";
        String actualResult = catPet.toString();
        Assert.assertEquals(expectedResult, actualResult);
    }
}