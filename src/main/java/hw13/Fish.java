package hw13;

import org.json.simple.JSONObject;

public class Fish extends Pet {
    Fish(String nickname, int age, int trickLevel) {
        super(nickname, age, trickLevel);
        setSpecies(Species.FISH);
    }

    public Fish(JSONObject humanJSON) {
        super(humanJSON);
    }

    void respond() {
        Logger.info("Bubble Bass");
    }
}
