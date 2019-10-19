package hw06;

import java.util.Arrays;

public class Pet {
    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    Pet(Species species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    Species getSpecies() {
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

    void eat() {
        System.out.println("I'm eating!");
    }

    void respond() {
        System.out.println(String.format("Hi host. I'm %s. I miss you!", nickname));
    }

    void foul() {
        System.out.println("I need to cover my tracks well...");
    }

    @Override
    public String toString() {
        return species + "{nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
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

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Object deleted: " + this);
    }
}

enum Species {
    DOG(4, true, false),
    CAT(4, true,false),
    HORSE(4, true, false),
    PARROT(2, false, true),
    DUCK(2, false, true),
    GOOSE(2, false, true);

    private int numberOfLegs;
    private boolean hasFur;
    private boolean canFly;

    Species(int numberOfLegs, boolean hasFur, boolean canFly) {
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
        this.canFly = canFly;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public boolean isHasFur() {
        return hasFur;
    }

    public boolean isCanFly() {
        return canFly;
    }
}
