package hw13;

import org.json.simple.JSONObject;

public final class Woman extends Human {
    Woman(String name, String surname, String birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    public Woman(JSONObject humanJSON) {
        super(humanJSON);
    }

    @Override
    void greetPet(String nickname) {
        Logger.info(String.format("Woman: Hello, %s!", getFamily().getPet(nickname).getNickname()));
    }

    void makeup() {
        Logger.info("I'm doing makeup");
    }

    @Override
    public JSONObject getJSON() {
        JSONObject humanJSON = super.getJSON();
        humanJSON.put("gender", "woman");
        return humanJSON;
    }

    @Override
    public String toString() {
        return "Woman" + super.toString();
    }
}
