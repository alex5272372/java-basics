package hw10;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FamilyTest {
    private Family family;

    @Before
    public void newFamily() {
        Pet catPet = new DomesticCat("tom", 3, 60);
        Human mother = new Human("Kate", "Karleone", "20/10/1965", 65);
        Human father = new Human("John", "Karleone", "08/05/1967", 67);
        Human son = new Human("Mark", "Karleone", "10/03/1988", 70);

        family = new Family(mother, father);
        family.addPet(catPet);
        family.addChild(son);
    }

    @Test
    public void testCountFamily() {
        int expectedResult = 3;
        int actualResult = family.countFamily();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddChildLength() {
        Human daughter = new Human("Anna", "Karleone", "20/11/1990", 72);
        family.addChild(daughter);
        Human numSibling = new Human("First", "Karleone", "26/12/1992", 55);
        family.addChild(numSibling);

        int expectedResult = 5;
        int actualResult = family.countFamily();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddChildObj() {
        family.deleteChild(0);
        Human daughter = new Human("Anna", "Karleone", "20/11/1990", 72);
        family.addChild(daughter);

        String expectedResult = "Family{\n" +
                "    mother={name='Kate', surname='Karleone', birthDate=20/10/1965, iq=65, schedule={}},\n" +
                "    father={name='John', surname='Karleone', birthDate=08/05/1967, iq=67, schedule={}},\n" +
                "    children=[{name='Anna', surname='Karleone', birthDate=20/11/1990, iq=72, schedule={}}],\n" +
                "    pets=[DOMESTIC_CAT{nickname='tom', age=3, trickLevel=60, habits=[], numberOfLegs=4, isHasFur=true, isCanFly=false}]}";
        String actualResult = family.toString();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDeleteChildInt() {
        family.deleteChild(0);

        String expectedResult = "Family{\n" +
                "    mother={name='Kate', surname='Karleone', birthDate=20/10/1965, iq=65, schedule={}},\n" +
                "    father={name='John', surname='Karleone', birthDate=08/05/1967, iq=67, schedule={}},\n" +
                "    children=[],\n" +
                "    pets=[DOMESTIC_CAT{nickname='tom', age=3, trickLevel=60, habits=[], numberOfLegs=4, isHasFur=true, isCanFly=false}]}";
        String actualResult = family.toString();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDeleteChildIntOut() {
        family.deleteChild(2);

        String expectedResult = "Family{\n" +
                "    mother={name='Kate', surname='Karleone', birthDate=20/10/1965, iq=65, schedule={}},\n" +
                "    father={name='John', surname='Karleone', birthDate=08/05/1967, iq=67, schedule={}},\n" +
                "    children=[{name='Mark', surname='Karleone', birthDate=10/03/1988, iq=70, schedule={}}],\n" +
                "    pets=[DOMESTIC_CAT{nickname='tom', age=3, trickLevel=60, habits=[], numberOfLegs=4, isHasFur=true, isCanFly=false}]}";
        String actualResult = family.toString();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDeleteChildObj() {
        Human son = new Human("Mark", "Karleone", "10/03/1988", 70);
        family.deleteChild(son);

        String expectedResult = "Family{\n" +
                "    mother={name='Kate', surname='Karleone', birthDate=20/10/1965, iq=65, schedule={}},\n" +
                "    father={name='John', surname='Karleone', birthDate=08/05/1967, iq=67, schedule={}},\n" +
                "    children=[],\n" +
                "    pets=[DOMESTIC_CAT{nickname='tom', age=3, trickLevel=60, habits=[], numberOfLegs=4, isHasFur=true, isCanFly=false}]}";
        String actualResult = family.toString();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDeleteChildObjOut() {
        Human numSibling = new Human("First", "Karleone", "26/12/1992", 55);
        family.deleteChild(numSibling);

        String expectedResult = "Family{\n" +
                "    mother={name='Kate', surname='Karleone', birthDate=20/10/1965, iq=65, schedule={}},\n" +
                "    father={name='John', surname='Karleone', birthDate=08/05/1967, iq=67, schedule={}},\n" +
                "    children=[{name='Mark', surname='Karleone', birthDate=10/03/1988, iq=70, schedule={}}],\n" +
                "    pets=[DOMESTIC_CAT{nickname='tom', age=3, trickLevel=60, habits=[], numberOfLegs=4, isHasFur=true, isCanFly=false}]}";
        String actualResult = family.toString();
        Assert.assertEquals(expectedResult, actualResult);
    }
}
