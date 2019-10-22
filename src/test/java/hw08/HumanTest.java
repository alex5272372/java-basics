package hw08;

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
        Woman mother = new Woman("Kate", "Karleone", 1965, 65);
        Man father = new Man("John", "Karleone", 1967, 67);
        Family family = new Family(mother, father);

        Human child = mother.bornChild();
        Assert.assertEquals("Karleone", child.getSurname());
        Assert.assertTrue(isValidName(child.getName()));
    }
}