package hw04;

import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Pet pet;
    private Human mother;
    private Human father;
    private String[][] schedule;

    public Human() {
        this.name = "";
        this.surname = "";
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, String surname, int year, int iq, Pet pet, Human mother, Human father, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
    }

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }

    public void greetPet() {
        System.out.println(String.format("Привет, %s", pet.getNickname()));
    }

    public void describePet() {
        System.out.println(String.format("У меня есть %1$s, ему %2$s лет, он %3$s",
                pet.getSpecies(), pet.getAge(), pet.getTrickLevel() > 50 ? "очень хитрый" : "почти не хитрый"));
    }

    private static int generateRandomInt(){
        Random random = new Random();
        return random.nextInt(100);
    }

    public boolean feedPet(boolean isTime) {
        int i = generateRandomInt();
        if(isTime || i < pet.getTrickLevel()) {
            System.out.println(String.format("Хм... покормлю ка я %s", pet.getNickname()));
            return true;
        } else {
            System.out.println(String.format("Думаю, %s не голоден.", pet.getNickname()));
            return false;
        }
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", mother='" + (mother == null ? "" : mother.getName() + " " + mother.getSurname()) + '\'' +
                ", father='" + (father == null ? "" : father.getName() + " " + father.getSurname()) + '\'' +
                ", pet=" + pet +
                '}';
    }
}
