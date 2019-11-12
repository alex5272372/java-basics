package hw13;

import org.json.simple.JSONObject;

public class RoboCat extends Pet {
    RoboCat(String nickname, int age, int trickLevel) {
        super(nickname, age, trickLevel);
        setSpecies(Species.ROBO_CAT);
    }

    public RoboCat(JSONObject humanJSON) {
        super(humanJSON);
    }

    void respond() {
        System.out.println(String.format("Hi human. I'm robot %s.", getNickname()));
    }
}
