package hw13;

import org.json.simple.JSONObject;

public final class Man extends Human {
    Man(String name, String surname, String birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    public Man(JSONObject humanJSON) {
        super(humanJSON);
    }

    @Override
    void greetPet(String nickname) {
        System.out.println(String.format("Man: Hello, %s!", getFamily().getPet(nickname).getNickname()));
    }

    void repairCar() {
        System.out.println("I'm doing repair car");
    }

    @Override
    public JSONObject getJSON() {
        JSONObject humanJSON = super.getJSON();
        humanJSON.put("gender", "man");
        return humanJSON;
    }

    @Override
    public String toString() {
        return "Man" + super.toString();
    }
}
