package hw08;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

public class Human implements HumanCreator {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Family family;
    private HashMap<DayOfWeek, String> schedule;

    Human(String name, String surname, int year, int iq) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = new HashMap<DayOfWeek, String>();
    }

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }

    Family getFamily() {
        return family;
    }

    void setFamily(Family family) {
        this.family = family;
    }

    void addSchedule(DayOfWeek day, String task) {
        schedule.put(day, task);
    }

    public Human bornChild() {
        // https://www.babble.com/baby-names/
        String[] manNames = {"Ayden", "Jayden", "Barack", "Sam", "Johnson", "Gennadi", "Genius", "Melvin", "Melville", "Zabi"};
        String[] womanNames = {"Madelyn", "Makayla", "Khloe", "Zahava", "Nava", "Linnett", "Cheyenne", "Genevieve", "Poppy", "Olinda"};
        int nameIndex = generateRandomInt(10);
        Calendar now = Calendar.getInstance();
        int childIq = (family.getFather().iq + family.getMother().iq) / 2;

        Human child;
        if(generateRandomInt(2) == 0) {
            child = new Man(manNames[nameIndex], surname, now.get(Calendar.YEAR), childIq);
        } else {
            child = new Woman(womanNames[nameIndex], surname, now.get(Calendar.YEAR), childIq);
        }

        family.addChild(child);
        return child;
    }

    void greetPet(String nickname) {
        if (family.getPet(nickname) != null) {
            System.out.println(String.format("Hello, %s!", nickname));
        }
    }

    void describePet(String nickname) {
        Pet pet = family.getPet(nickname);
        System.out.println(String.format("I have a %1$s, he is %2$s years old, he %3$s",
                pet.getSpecies(), pet.getAge(), pet.getTrickLevel() > 50 ? "is very cunning" : "isn't cunning"));
    }

    private static int generateRandomInt(int bound){
        Random random = new Random();
        return random.nextInt(bound);
    }

    boolean feedPet(String nickname, boolean isTime) {
        Pet pet = family.getPet(nickname);
        int i = generateRandomInt(100);
        if(isTime || i < pet.getTrickLevel()) {
            System.out.println(String.format("Hmm... I'll feed you, %s", pet.getNickname()));
            return true;
        } else {
            System.out.println(String.format("I think, %s isn't hungry.", pet.getNickname()));
            return false;
        }
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", schedule=" + schedule.toString() +
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
