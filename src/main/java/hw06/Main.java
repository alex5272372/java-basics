package hw06;

public class Main {
    public static void main(String[] args) {
        String[] myPetHabits = {"eat", "drink", "sleep"};
        Pet catPet = new Pet(Species.CAT, "tom", 3, 60, myPetHabits);

        Human mother = new Human("Kate", "Karleone", 1965, 65);
        Human father = new Human("John", "Karleone", 1967, 67);
        Human son = new Human("Mark", "Karleone", 1988, 70);

        Human daughter = new Human("Anna", "Karleone", 1990, 72);
        daughter.setSchedule(0, "Task 1");
        daughter.setSchedule(1, "Task 2");
        daughter.setSchedule(2, "Task 3");

        Human numSibling = new Human("First", "Karleone", 1992, 55);
        Human objSibling = new Human("Anykey", "Karleone", 1994, 50);

        Family family = new Family(mother, father);
        family.setPet(catPet);
        family.addChild(son);
        family.addChild(daughter);
        family.addChild(numSibling);
        family.addChild(objSibling);
        System.out.println("--------------------------------------------------------------------");
        family.deleteChild(2);
        family.deleteChild(objSibling);
        System.out.println("Family count " + family.countFamily() + ":");
        System.out.println(family);

        son.describePet();
        son.greetPet();
        catPet.foul();
        catPet.respond();
        if(son.feedPet(false)) {
            catPet.eat();
        }

        System.out.println("--------------------------------------------------------------------");
        System.out.println("Hello! My name is " + daughter.getName() + " " + daughter.getSurname());
        System.out.println("My mother's name is " + daughter.getFamily().getMother().getName() + " " + daughter.getFamily().getMother().getSurname());
        System.out.println("My father's name is " + daughter.getFamily().getFather().getName() + " " + daughter.getFamily().getFather().getSurname());

        System.out.println("--------------------------------------------------------------------");
        for(int i = 0; i < 3000000; i++) {
            new Human("Alex " + i, "Karleone", 1965, 65);
        }
    }
}
