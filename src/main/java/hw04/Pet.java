package hw04;

import java.util.Arrays;

public class Pet {
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
}
