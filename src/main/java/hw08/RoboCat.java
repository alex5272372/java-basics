package hw08;

public class RoboCat extends Pet {
    RoboCat(String nickname, int age, int trickLevel) {
        super(nickname, age, trickLevel);
        setSpecies(Species.ROBO_CAT);
    }

    void respond() {
        System.out.println(String.format("Hi human. I'm robot %s.", getNickname()));
    }
}
