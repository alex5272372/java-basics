package hw13;

public class DomesticCat extends Pet implements Foulable {
    DomesticCat(String nickname, int age, int trickLevel) {
        super(nickname, age, trickLevel);
        setSpecies(Species.DOMESTIC_CAT);
    }

    public void foul() {
        System.out.println("CAT: I need to cover my tracks well...");
    }

    void respond() {
        System.out.println(String.format("Hi host. I'm CAT %s. I miss you!", getNickname()));
    }
}
