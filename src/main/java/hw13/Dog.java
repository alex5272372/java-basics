package hw13;

import org.json.simple.JSONObject;

public class Dog extends Pet implements Foulable {
    Dog(String nickname, int age, int trickLevel) {
        super(nickname, age, trickLevel);
        setSpecies(Species.DOG);
    }

    public Dog(JSONObject humanJSON) {
        super(humanJSON);
    }

    public void foul() {
        Logger.info("DOG: I need to cover my tracks well...");
    }

    void respond() {
        Logger.info(String.format("Hi host. I'm DOG %s. I miss you!", getNickname()));
    }
}
