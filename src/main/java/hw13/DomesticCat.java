package hw13;

import org.json.simple.JSONObject;

public class DomesticCat extends Pet implements Foulable {
    DomesticCat(String nickname, int age, int trickLevel) {
        super(nickname, age, trickLevel);
        setSpecies(Species.DOMESTIC_CAT);
    }

    public DomesticCat(JSONObject humanJSON) {
        super(humanJSON);
    }

    public void foul() {
        Logger.info("CAT: I need to cover my tracks well...");
    }

    void respond() {
        Logger.info(String.format("Hi host. I'm CAT %s. I miss you!", getNickname()));
    }
}
