package hw09;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FamilyServiceTest {
    private FamilyService familyService;

    @Before
    public void createFamilyService() {
        familyService = new FamilyService();

        Woman mother1 = new Woman("Kate1", "Karleone1", 1965, 65);
        Man father1 = new Man("John1", "Karleone1", 1967, 67);
        Family family1 = familyService.createNewFamily(mother1, father1);
        familyService.bornChild(family1, "Man11", "Woman11");
        Dog dogPet1 = new Dog("bobik1", 4, 40);
        familyService.addPet(0, dogPet1);
        DomesticCat catPet = new DomesticCat("tom", 3, 60);
        familyService.addPet(0, catPet);

        Woman mother2 = new Woman("Kate2", "Karleone2", 1965, 65);
        Man father2 = new Man("John2", "Karleone2", 1967, 67);
        Family family2 = familyService.createNewFamily(mother2, father2);
        familyService.bornChild(family2, "Man21", "Woman21");
        familyService.bornChild(family2, "Man22", "Woman22");
        Dog dogPet = new Dog("bobik", 4, 40);
        familyService.addPet(1, dogPet);

        Woman mother3 = new Woman("Kate3", "Karleone3", 1965, 65);
        Man father3 = new Man("John3", "Karleone3", 1967, 67);
        Family family3 = familyService.createNewFamily(mother3, father3);
        familyService.bornChild(family3, "Man31", "Woman31");
        familyService.bornChild(family3, "Man32", "Woman32");
        familyService.bornChild(family3, "Man33", "Woman33");
    }

    @Test
    public void testGetAllFamilies() {
        String expectedResult = "[Family{\n" +
                "    mother=Woman{name='Kate1', surname='Karleone1', year=1965, iq=65, schedule={}},\n" +
                "    father=Man{name='John1', surname='Karleone1', year=1967, iq=67, schedule={}},\n" +
                "    children=[Man{name='Man11', surname='Karleone1', year=2019, iq=66, schedule={}}],\n" +
                "    pets=[DOMESTIC_CAT{nickname='tom', age=3, trickLevel=60, habits=[], numberOfLegs=4, isHasFur=true, isCanFly=false}, DOG{nickname='bobik1', age=4, trickLevel=40, habits=[], numberOfLegs=4, isHasFur=true, isCanFly=false}]}, Family{\n" +
                "    mother=Woman{name='Kate2', surname='Karleone2', year=1965, iq=65, schedule={}},\n" +
                "    father=Man{name='John2', surname='Karleone2', year=1967, iq=67, schedule={}},\n" +
                "    children=[Woman{name='Woman21', surname='Karleone2', year=2019, iq=66, schedule={}}, Man{name='Man22', surname='Karleone2', year=2019, iq=66, schedule={}}],\n" +
                "    pets=[DOG{nickname='bobik', age=4, trickLevel=40, habits=[], numberOfLegs=4, isHasFur=true, isCanFly=false}]}, Family{\n" +
                "    mother=Woman{name='Kate3', surname='Karleone3', year=1965, iq=65, schedule={}},\n" +
                "    father=Man{name='John3', surname='Karleone3', year=1967, iq=67, schedule={}},\n" +
                "    children=[Man{name='Man31', surname='Karleone3', year=2019, iq=66, schedule={}}, Man{name='Man32', surname='Karleone3', year=2019, iq=66, schedule={}}, Man{name='Man33', surname='Karleone3', year=2019, iq=66, schedule={}}],\n" +
                "    pets=[]}]";
        String actualResult = familyService.getAllFamilies().toString();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetFamiliesBiggerThan() {
        int expectedResult = 1;
        int actualResult = familyService.getFamiliesBiggerThan(4).size();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetFamiliesLessThan() {
        int expectedResult = 1;
        int actualResult = familyService.getFamiliesLessThan(4).size();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountFamiliesWithMemberNumber() {
        int expectedResult = 1;
        int actualResult = familyService.countFamiliesWithMemberNumber(4);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void createNewFamily() {
        Woman mother4 = new Woman("Kate4", "Karleone4", 1965, 65);
        Man father4 = new Man("John4", "Karleone4", 1967, 67);

        String expectedResult = "Family{\n" +
                "    mother=Woman{name='Kate4', surname='Karleone4', year=1965, iq=65, schedule={}},\n" +
                "    father=Man{name='John4', surname='Karleone4', year=1967, iq=67, schedule={}},\n" +
                "    children=[],\n" +
                "    pets=[]}";
        String actualResult = familyService.createNewFamily(mother4, father4).toString();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testBornChild() {
        String expectedResult = "Family{\n" +
                "    mother=Woman{name='Kate1', surname='Karleone1', year=1965, iq=65, schedule={}},\n" +
                "    father=Man{name='John1', surname='Karleone1', year=1967, iq=67, schedule={}},\n" +
                "    children=[Man{name='Man11', surname='Karleone1', year=2019, iq=66, schedule={}}, Man{name='Bill', surname='Karleone1', year=2019, iq=66, schedule={}}],\n" +
                "    pets=[DOMESTIC_CAT{nickname='tom', age=3, trickLevel=60, habits=[], numberOfLegs=4, isHasFur=true, isCanFly=false}, DOG{nickname='bobik1', age=4, trickLevel=40, habits=[], numberOfLegs=4, isHasFur=true, isCanFly=false}]}";
        String actualResult = familyService.bornChild(familyService.getFamilyById(0), "Bill", "Bill").toString();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAdoptChild() {
        String expectedResult = "Family{\n" +
                "    mother=Woman{name='Kate1', surname='Karleone1', year=1965, iq=65, schedule={}},\n" +
                "    father=Man{name='John1', surname='Karleone1', year=1967, iq=67, schedule={}},\n" +
                "    children=[Woman{name='Woman11', surname='Karleone1', year=2019, iq=66, schedule={}}, {name='Bill', surname='Karleone1', year=2015, iq=80, schedule={}}],\n" +
                "    pets=[DOMESTIC_CAT{nickname='tom', age=3, trickLevel=60, habits=[], numberOfLegs=4, isHasFur=true, isCanFly=false}, DOG{nickname='bobik1', age=4, trickLevel=40, habits=[], numberOfLegs=4, isHasFur=true, isCanFly=false}]}";
        String actualResult = familyService.adoptChild(familyService.getFamilyById(0), new Human("Bill", "Karleone1", 2015, 80)).toString();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCount() {
        int expectedResult = 3;
        int actualResult = familyService.count();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetFamilyById() {
        String expectedResult = "Family{\n" +
                "    mother=Woman{name='Kate1', surname='Karleone1', year=1965, iq=65, schedule={}},\n" +
                "    father=Man{name='John1', surname='Karleone1', year=1967, iq=67, schedule={}},\n" +
                "    children=[Man{name='Man11', surname='Karleone1', year=2019, iq=66, schedule={}}],\n" +
                "    pets=[DOMESTIC_CAT{nickname='tom', age=3, trickLevel=60, habits=[], numberOfLegs=4, isHasFur=true, isCanFly=false}, DOG{nickname='bobik1', age=4, trickLevel=40, habits=[], numberOfLegs=4, isHasFur=true, isCanFly=false}]}";
        String actualResult = familyService.getFamilyById(0).toString();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetPets() {
        String expectedResult = "[DOMESTIC_CAT{nickname='tom', age=3, trickLevel=60, habits=[], numberOfLegs=4, isHasFur=true, isCanFly=false}, DOG{nickname='bobik1', age=4, trickLevel=40, habits=[], numberOfLegs=4, isHasFur=true, isCanFly=false}]";
        String actualResult = familyService.getPets(0).toString();
        Assert.assertEquals(expectedResult, actualResult);
    }
}