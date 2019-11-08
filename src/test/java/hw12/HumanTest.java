package hw12;

import org.junit.Assert;
import org.junit.Test;

public class HumanTest {
    private boolean isValidName(String name) {
        String[] names = {"Ayden", "Jayden", "Barack", "Sam", "Johnson", "Gennadi", "Genius", "Melvin", "Melville", "Zabi", "Madelyn", "Makayla", "Khloe", "Zahava", "Nava", "Linnett", "Cheyenne", "Genevieve", "Poppy", "Olinda"};

        for(int i = 0; i < names.length; i++) {
            if(names[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void bornChild() {
        Woman mother = new Woman("Kate", "Karleone", "20/10/1965", 65);
        Man father = new Man("John", "Karleone", "08/05/1967", 67);
        Family family = new Family(mother, father);

        Human child = mother.bornChild();
        Assert.assertEquals("Karleone", child.getSurname());
        Assert.assertTrue(isValidName(child.getName()));
    }

    @Test
    public void describeAge() {
        Woman mother = new Woman("Kate", "Karleone", "20/10/1965", 65);
        Man father = new Man("John", "Karleone", "08/05/1967", 67);
        Family family = new Family(mother, father);
        Human child = mother.bornChild();

        String expectedResult = "Human lives 1 years, 1 months, 1 days";
        String actualResult = child.describeAge();
        Assert.assertEquals(expectedResult, actualResult);
    }
}