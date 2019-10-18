package hw05;

import java.util.Arrays;

public class Pet {
    static {
        System.out.println("Loading class Pet");
    }

    {
        System.out.println("Creating object Pet");
    }

    private String species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public Pet() {
        this.species = "";
        this.nickname = "";
    }

    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    String getSpecies() {
        return species;
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

    public void eat() {
        System.out.println("Я кушаю!");
    }

    public void respond() {
        System.out.println(String.format("Привет, хозяин. Я - %s. Я соскучился!", nickname));
    }

    public void foul() {
        System.out.println("Нужно хорошо замести следы...");
    }

    @Override
    public String toString() {
        return species + "{nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
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
