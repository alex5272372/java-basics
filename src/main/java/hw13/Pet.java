package hw13;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.HashSet;
import java.util.Set;

public abstract class Pet {
    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private Set<String> habits;


    Pet(String nickname, int age, int trickLevel) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.species = Species.UNKNOWN;
        this.habits = new HashSet<String>();
    }

    public Set<String> getHabits() {
        return habits;
    }

    void addHabit(String habit) {
        habits.add(habit);
    }

    Species getSpecies() {
        return species;
    }

    void setSpecies(Species species) {
        this.species = species;
    }

    String getNickname() {
        return nickname;
    }

    int getAge() {
        return age;
    }

    int getTrickLevel() {
        return trickLevel;
    }

    void eat() {
        System.out.println("I'm eating!");
    }

    abstract void respond();

    public JSONObject getJSON() {
        JSONObject petJSON = new JSONObject();
        petJSON.put("species", species.toString());
        petJSON.put("nickname", nickname);
        petJSON.put("age", age);
        petJSON.put("trickLevel", trickLevel);

        JSONArray habitsJSON = new JSONArray();
        for(String habit : habits) {
            habitsJSON.add(habit);
        }
        petJSON.put("habits", habitsJSON);

        return petJSON;
    }

    @Override
    // instead prettyFormat
    public String toString() {
        return species + "{nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + habits.toString() +
                ", numberOfLegs=" + species.getNumberOfLegs() +
                ", isHasFur=" + species.isHasFur() +
                ", isCanFly=" + species.isCanFly() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        if (age != pet.age) return false;
        if (!species.equals(pet.species)) return false;
        return nickname.equals(pet.nickname);
    }

    @Override
    public int hashCode() {
        int result = species.hashCode();
        result = 31 * result + nickname.hashCode();
        result = 31 * result + age;
        return result;
    }
}
