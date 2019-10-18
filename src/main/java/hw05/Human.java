package hw05;

import java.util.Random;

public class Human {
    static {
        System.out.println("Loading class Human");
    }

    {
        System.out.println("Creating object Human");
    }

    private String name;
    private String surname;
    private int year;
    private int iq;
    private Family family;
    private String[][] schedule;

    public Human(String name, String surname, int year, int iq) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;

        this.schedule = new String[7][2];
        schedule[0][0] = "Sunday";
        schedule[1][0] = "Monday";
        schedule[2][0] = "Tuesday";
        schedule[3][0] = "Wednesday";
        schedule[4][0] = "Thursday";
        schedule[5][0] = "Friday";
        schedule[6][0] = "Saturday";
    }

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public void setSchedule(int day, String task) {
        this.schedule[day][1] = task;
    }

    public void greetPet() {
        System.out.println(String.format("Привет, %s", family.getPet().getNickname()));
    }

    public void describePet() {
        Pet pet = family.getPet();
        System.out.println(String.format("У меня есть %1$s, ему %2$s лет, он %3$s",
                pet.getSpecies(), pet.getAge(), pet.getTrickLevel() > 50 ? "очень хитрый" : "почти не хитрый"));
    }

    private static int generateRandomInt(){
        Random random = new Random();
        return random.nextInt(100);
    }

    public boolean feedPet(boolean isTime) {
        Pet pet = family.getPet();
        int i = generateRandomInt();
        if(isTime || i < pet.getTrickLevel()) {
            System.out.println(String.format("Хм... покормлю ка я %s", pet.getNickname()));
            return true;
        } else {
            System.out.println(String.format("Думаю, %s не голоден.", pet.getNickname()));
            return false;
        }
    }

    private String scheduleToString() {
        String result = "";
        for(int i = 0; i < 7; i++) {
            if(schedule[i][1] != null && schedule[i][1] != "") {
                result = result + "[" + schedule[i][0] + ": " + schedule[i][1] + "]";
            }
        }
        return  "[" + result + "]";
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", schedule=" + scheduleToString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (year != human.year) return false;
        if (!name.equals(human.name)) return false;
        return surname.equals(human.surname);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + year;
        return result;
    }
}
