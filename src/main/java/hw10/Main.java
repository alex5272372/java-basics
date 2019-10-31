package hw10;

public class Main {
    public static void main(String[] args) {
        FamilyController familyController = new FamilyController();

        Woman mother1 = new Woman("Kate1", "Karleone1", "20/10/1965", 65);
        Man father1 = new Man("John1", "Karleone1", "08/05/1967", 67);
        Family family1 = familyController.createNewFamily(mother1, father1);
        familyController.bornChild(family1, "Man11", "Woman11");
        Dog dogPet1 = new Dog("bobik1", 4, 40);
        familyController.addPet(0, dogPet1);
        DomesticCat catPet = new DomesticCat("tom", 3, 60);
        familyController.addPet(0, catPet);

        Woman mother2 = new Woman("Kate2", "Karleone2", "20/10/1965", 65);
        Man father2 = new Man("John2", "Karleone2", "08/05/1967", 67);
        Family family2 = familyController.createNewFamily(mother2, father2);
        familyController.bornChild(family2, "Man21", "Woman21");
        familyController.bornChild(family2, "Man22", "Woman22");
        Dog dogPet = new Dog("bobik", 4, 40);
        familyController.addPet(1, dogPet);

        Woman mother3 = new Woman("Kate3", "Karleone3", "20/10/1965", 65);
        Man father3 = new Man("John3", "Karleone3", "08/05/1967", 67);
        Family family3 = familyController.createNewFamily(mother3, father3);
        familyController.bornChild(family3, "Man31", "Woman31");
        familyController.bornChild(family3, "Man32", "Woman32");
        familyController.bornChild(family3, "Man33", "Woman33");

        System.out.println("FamiliesBiggerThan 4:");
        familyController.getFamiliesBiggerThan(4);
        System.out.println("FamiliesLessThan 4:");
        familyController.getFamiliesLessThan(4);

        family3.getChild(2).setBirthDate("01/01/2000");
        System.out.println(family3.getChild(2).describeAge());
        familyController.deleteAllChildrenOlderThen(10);
        System.out.println("countFamiliesWithMemberNumber 4: " + familyController.countFamiliesWithMemberNumber(4));

        familyController.displayAllFamilies();
    }
}
