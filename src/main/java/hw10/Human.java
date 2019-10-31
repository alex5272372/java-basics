package hw10;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Human implements HumanCreator {
    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private Family family;
    private Map<DayOfWeek, String> schedule;

    Human(String name, String surname, Calendar birthDate, int iq) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate.getTimeInMillis();
        this.iq = iq;
        this.schedule = new HashMap<DayOfWeek, String>();
    }

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }

    Calendar getBirthDate() {
        Calendar result = Calendar.getInstance();
        result.setTimeInMillis(birthDate);
        return result;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate.getTimeInMillis();
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

    public Human bornChild(String manName, String womanName) {
        Calendar now = Calendar.getInstance();
        int childIq = (family.getFather().iq + family.getMother().iq) / 2;

        Human child;
        if(generateRandomInt(2) == 0) {
            child = new Man(manName, surname, now, childIq);
        } else {
            child = new Woman(womanName, surname, now, childIq);
        }

        family.addChild(child);
        return child;
    }

    public Human bornChild() {
        // https://www.babble.com/baby-names/
        String[] manNames = {"Ayden", "Jayden", "Barack", "Sam", "Johnson", "Gennadi", "Genius", "Melvin", "Melville", "Zabi"};
        String[] womanNames = {"Madelyn", "Makayla", "Khloe", "Zahava", "Nava", "Linnett", "Cheyenne", "Genevieve", "Poppy", "Olinda"};
        int nameIndex = generateRandomInt(10);
        return bornChild(manNames[nameIndex], womanNames[nameIndex]);
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

    String describeAge() {
        Calendar result = Calendar.getInstance();
        result.setTimeInMillis(result.getTimeInMillis() - birthDate);
        DateFormat df = new SimpleDateFormat("yyyy' years, 'M' months, 'd' days'");
        return "Human lives " + df.format(result.getTime());
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + birthDate +
                ", iq=" + iq +
                ", schedule=" + schedule.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (birthDate != human.birthDate) return false;
        if (!name.equals(human.name)) return false;
        return surname.equals(human.surname);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + (int) (birthDate ^ (birthDate >>> 32));
        return result;
    }
}
