package hw07;

public class RoboCat extends Pet {
    RoboCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.ROBO_CAT);
    }

    void respond() {
        System.out.println(String.format("Hi human. I'm robot %s.", getNickname()));
    }
}
