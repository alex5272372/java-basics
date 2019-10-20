package hw07;

public class Fish extends Pet {
    Fish(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.FISH);
    }

    void respond() {
        System.out.println("Bubble Bass");
    }
}
