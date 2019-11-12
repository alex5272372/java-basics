package hw13;

import org.json.simple.JSONObject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Human implements HumanCreator {
    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private Family family;
    private Map<DayOfWeek, String> schedule;

    Human(String name, String surname, String birthDate, int iq) {
        this.name = name;
        this.surname = surname;
        this.iq = iq;
        this.schedule = new HashMap<DayOfWeek, String>();
        setBirthDate(birthDate);
    }

    Human(JSONObject humanJSON) {
        this.name = (String) humanJSON.get("name");
        this.surname = (String) humanJSON.get("surname");
        this.birthDate = (long) humanJSON.get("birthDate");
        this.iq = (int) (long) humanJSON.get("iq");
        this.schedule = new HashMap<DayOfWeek, String>();
    }

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }

    Date getBirthDate() {
        return new Date(birthDate);
    }

    public void setBirthDate(String birthDate) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.birthDate = df.parse(birthDate).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        int childIq = (family.getFather().iq + family.getMother().iq) / 2;

        Human child;
        if(generateRandomInt(2) == 0) {
            child = new Man(manName, surname, df.format(now), childIq);
        } else {
            child = new Woman(womanName, surname, df.format(now), childIq);
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
        Date result = new Date();
        result.setTime(-62167399200000L + result.getTime() - birthDate);
        DateFormat df = new SimpleDateFormat("y' years, 'M' months, 'd' days'");
        return "Human lives " + df.format(result);
    }


    public JSONObject getJSON() {
        JSONObject humanJSON = new JSONObject();
        humanJSON.put("name", name);
        humanJSON.put("surname", surname);
        humanJSON.put("birthDate", birthDate);
        humanJSON.put("iq", iq);
        return humanJSON;
    }

    @Override
    // instead prettyFormat
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return "{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + df.format(getBirthDate()) +
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
