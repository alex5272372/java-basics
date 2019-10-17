package hw04;

public class Main {
    public static void main(String[] args) {
        Pet emptyPet = new Pet();
        System.out.println("emptyPet:");
        System.out.println(emptyPet);

        Pet dogPet = new Pet("dog", "bobik");
        System.out.println("dogPet:");
        System.out.println(dogPet);

        String[] myPetHabits = {"eat", "drink", "sleep"};
        Pet catPet = new Pet("cat", "tom", 3, 60, myPetHabits);
        System.out.println("catPet:");
        System.out.println(catPet);

        Human grandma = new Human();
        System.out.println("grandma:");
        System.out.println(grandma);

        Human mother = new Human("Kate", "Karleone", 1965);
        System.out.println("mother:");
        System.out.println(mother);

        Human father = new Human("John", "Karleone", 1967, grandma, new Human());
        System.out.println("father:");
        System.out.println(father);

        Human son = new Human("Mark", "Karleone", 1988, 70, catPet, mother, father, new String[7][2]);
        System.out.println("son:");
        System.out.println(son);

        System.out.println("--------------------------------------------------------------------");

        son.describePet();
        son.greetPet();
        catPet.foul();
        catPet.respond();
        if(son.feedPet(false)) {
            catPet.eat();
        }
    }
}
