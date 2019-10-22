package hw08;

public class Main {
    public static void main(String[] args) {
        DomesticCat catPet = new DomesticCat("tom", 3, 60);
        catPet.addHabit("eat");
        catPet.addHabit("drink");
        catPet.addHabit("sleep");

        Woman mother = new Woman("Kate", "Karleone", 1965, 65);
        Man father = new Man("John", "Karleone", 1967, 67);
        Family family = new Family(mother, father);
        Human firstChild = mother.bornChild();
        Human secondChild = mother.bornChild();

        secondChild.addSchedule(DayOfWeek.SUNDAY, "Task 1");
        secondChild.addSchedule(DayOfWeek.MONDAY, "Task 2");
        secondChild.addSchedule(DayOfWeek.TUESDAY, "Task 3");

        family.addPet(catPet);
        System.out.println(family);

        firstChild.describePet("tom");
        firstChild.greetPet("tom");
        catPet.foul();
        catPet.respond();
        if(firstChild.feedPet("tom", false)) {
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
