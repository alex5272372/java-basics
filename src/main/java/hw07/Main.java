package hw07;

public class Main {
    public static void main(String[] args) {
        String[] myPetHabits = {"eat", "drink", "sleep"};
        DomesticCat catPet = new DomesticCat("tom", 3, 60, myPetHabits);

        Woman mother = new Woman("Kate", "Karleone", 1965, 65);
        Man father = new Man("John", "Karleone", 1967, 67);
        Family family = new Family(mother, father);
        Human firstChild = mother.bornChild();
        Human secondChild = mother.bornChild();

        secondChild.setSchedule(0, "Task 1");
        secondChild.setSchedule(1, "Task 2");
        secondChild.setSchedule(2, "Task 3");

        family.setPet(catPet);
        System.out.println(family);

        firstChild.describePet();
        firstChild.greetPet();
        catPet.foul();
        catPet.respond();
        if(firstChild.feedPet(false)) {
            catPet.eat();
        }

        System.out.println("--------------------------------------------------------------------");
        System.out.println("Hello! My name is " + secondChild.getName() + " " + secondChild.getSurname());
        System.out.println("My mother's name is " + secondChild.getFamily().getMother().getName() + " " + secondChild.getFamily().getMother().getSurname());
        System.out.println("She often speaks:");
        mother.makeup();
        System.out.println("My father's name is " + secondChild.getFamily().getFather().getName() + " " + secondChild.getFamily().getFather().getSurname());
        System.out.println("He often speaks:");
        father.repairCar();
    }
}
