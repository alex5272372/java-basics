package hw07;

import org.junit.Assert;
import org.junit.Test;

public class FamilyTest {
    private Family newFamily() {
        String[] myPetHabits = {"eat", "drink", "sleep"};
        Pet catPet = new DomesticCat("tom", 3, 60, myPetHabits);

        Human mother = new Human("Kate", "Karleone", 1965, 65);
        Human father = new Human("John", "Karleone", 1967, 67);
        Human son = new Human("Mark", "Karleone", 1988, 70);

        Human daughter = new Human("Anna", "Karleone", 1990, 72);
        daughter.setSchedule(0, "Task 1");
        daughter.setSchedule(1, "Task 2");
        daughter.setSchedule(2, "Task 3");

        Family family = new Family(mother, father);
        family.setPet(catPet);
        family.addChild(son);
        family.addChild(daughter);

        return family;
    }

    @Test
    public void testCountFamily() {
        Family family = newFamily();
        int expectedResult = 4;
        int actualResult = family.countFamily();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddChildLength() {
        Family family = newFamily();
        Human numSibling = new Human("First", "Karleone", 1992, 55);
        family.addChild(numSibling);

        int expectedResult = 5;
        int actualResult = family.countFamily();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddChildObj() {
        Family family = newFamily();
        Human numSibling = new Human("First", "Karleone", 1992, 55);
        family.addChild(numSibling);

        String expectedResult = "Family{\n" +
                "    mother={name='Kate', surname='Karleone', year=1965, iq=65, schedule=[]},\n" +
                "    father={name='John', surname='Karleone', year=1967, iq=67, schedule=[]},\n" +
                "    children=[{name='Mark', surname='Karleone', year=1988, iq=70, schedule=[]}, {name='Anna', surname='Karleone', year=1990, iq=72, schedule=[[SUNDAY: Task 1][MONDAY: Task 2][TUESDAY: Task 3]]}, {name='First', surname='Karleone', year=1992, iq=55, schedule=[]}],\n" +
                "    pet=DOMESTIC_CAT{nickname='tom', age=3, trickLevel=60, habits=[eat, drink, sleep], numberOfLegs=4, isHasFur=true, isCanFly=false}}";
        String actualResult = family.toString();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDeleteChildInt() {
        Family family = newFamily();
        family.deleteChild(0);

        String expectedResult = "Family{\n" +
                "    mother={name='Kate', surname='Karleone', year=1965, iq=65, schedule=[]},\n" +
                "    father={name='John', surname='Karleone', year=1967, iq=67, schedule=[]},\n" +
                "    children=[{name='Anna', surname='Karleone', year=1990, iq=72, schedule=[[SUNDAY: Task 1][MONDAY: Task 2][TUESDAY: Task 3]]}],\n" +
                "    pet=DOMESTIC_CAT{nickname='tom', age=3, trickLevel=60, habits=[eat, drink, sleep], numberOfLegs=4, isHasFur=true, isCanFly=false}}";
        String actualResult = family.toString();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDeleteChildIntOut() {
        Family family = newFamily();
        family.deleteChild(2);

        String expectedResult = "Family{\n" +
                "    mother={name='Kate', surname='Karleone', year=1965, iq=65, schedule=[]},\n" +
                "    father={name='John', surname='Karleone', year=1967, iq=67, schedule=[]},\n" +
                "    children=[{name='Mark', surname='Karleone', year=1988, iq=70, schedule=[]}, {name='Anna', surname='Karleone', year=1990, iq=72, schedule=[[SUNDAY: Task 1][MONDAY: Task 2][TUESDAY: Task 3]]}],\n" +
                "    pet=DOMESTIC_CAT{nickname='tom', age=3, trickLevel=60, habits=[eat, drink, sleep], numberOfLegs=4, isHasFur=true, isCanFly=false}}";
        String actualResult = family.toString();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDeleteChildObj() {
        Family family = newFamily();
        Human son = new Human("Mark", "Karleone", 1988, 70);
        family.deleteChild(son);

        String expectedResult = "Family{\n" +
                "    mother={name='Kate', surname='Karleone', year=1965, iq=65, schedule=[]},\n" +
                "    father={name='John', surname='Karleone', year=1967, iq=67, schedule=[]},\n" +
                "    children=[{name='Anna', surname='Karleone', year=1990, iq=72, schedule=[[SUNDAY: Task 1][MONDAY: Task 2][TUESDAY: Task 3]]}],\n" +
                "    pet=DOMESTIC_CAT{nickname='tom', age=3, trickLevel=60, habits=[eat, drink, sleep], numberOfLegs=4, isHasFur=true, isCanFly=false}}";
        String actualResult = family.toString();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDeleteChildObjOut() {
        Family family = newFamily();
        Human numSibling = new Human("First", "Karleone", 1992, 55);
        family.deleteChild(numSibling);

        String expectedResult = "Family{\n" +
                "    mother={name='Kate', surname='Karleone', year=1965, iq=65, schedule=[]},\n" +
                "    father={name='John', surname='Karleone', year=1967, iq=67, schedule=[]},\n" +
                "    children=[{name='Mark', surname='Karleone', year=1988, iq=70, schedule=[]}, {name='Anna', surname='Karleone', year=1990, iq=72, schedule=[[SUNDAY: Task 1][MONDAY: Task 2][TUESDAY: Task 3]]}],\n" +
                "    pet=DOMESTIC_CAT{nickname='tom', age=3, trickLevel=60, habits=[eat, drink, sleep], numberOfLegs=4, isHasFur=true, isCanFly=false}}";
        String actualResult = family.toString();
        Assert.assertEquals(expectedResult, actualResult);
    }
}