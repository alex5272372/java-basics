package hw07;

import java.util.Random;
import java.util.Calendar;

public class Human implements HumanCreator {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Family family;
    private String[][] schedule;

    Human(String name, String surname, int year, int iq) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;

        this.schedule = new String[7][2];
        schedule[0][0] = DayOfWeek.SUNDAY.name();
        schedule[1][0] = DayOfWeek.MONDAY.name();
        schedule[2][0] = DayOfWeek.TUESDAY.name();
        schedule[3][0] = DayOfWeek.WEDNESDAY.name();
        schedule[4][0] = DayOfWeek.THURSDAY.name();
        schedule[5][0] = DayOfWeek.FRIDAY.name();
        schedule[6][0] = DayOfWeek.SATURDAY.name();
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

    void setSchedule(int day, String task) {
        this.schedule[day][1] = task;
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

    void greetPet() {
        System.out.println(String.format("Hello, %s!", family.getPet().getNickname()));
    }

    void describePet() {
        Pet pet = family.getPet();
        System.out.println(String.format("I have a %1$s, he is %2$s years old, he %3$s",
                pet.getSpecies(), pet.getAge(), pet.getTrickLevel() > 50 ? "is very cunning" : "isn't cunning"));
    }

    private static int generateRandomInt(int bound){
        Random random = new Random();
        return random.nextInt(bound);
    }

    boolean feedPet(boolean isTime) {
        Pet pet = family.getPet();
        int i = generateRandomInt(100);
        if(isTime || i < pet.getTrickLevel()) {
            System.out.println(String.format("Hmm... I'll feed you, %s", pet.getNickname()));
            return true;
        } else {
            System.out.println(String.format("I think, %s isn't hungry.", pet.getNickname()));
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
        return "{" +
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
