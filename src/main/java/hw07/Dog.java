package hw07;

public class Dog extends Pet implements Foul {
    Dog(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.DOG);
    }

    public void foul() {
        System.out.println("DOG: I need to cover my tracks well...");
    }

    void respond() {
        System.out.println(String.format("Hi host. I'm DOG %s. I miss you!", getNickname()));
    }
}
