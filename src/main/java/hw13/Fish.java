package hw13;

public class Fish extends Pet {
    Fish(String nickname, int age, int trickLevel) {
        super(nickname, age, trickLevel);
        setSpecies(Species.FISH);
    }

    void respond() {
        System.out.println("Bubble Bass");
    }
}
