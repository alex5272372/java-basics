package hw13;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.*;
import java.util.stream.Collectors;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pets;

    Family(Human mother, Human father) {
        this.mother = mother;
        mother.setFamily(this);
        this.father = father;
        father.setFamily(this);
        this.children = new ArrayList<Human>();
        this.pets = new HashSet<Pet>();
    }

    Human getMother() {
        return mother;
    }

    Human getFather() {
        return father;
    }

    Set<Pet> getPets() {
        return pets;
    }

    Pet getPet(String nickname) {
        for(Pet pet : pets) {
            if (pet.getNickname().equals(nickname)) {
                return pet;
            }
        }
        return null;
    }

    Human getChild(int i) {
        return children.get(i);
    }

    void addPet(Pet pet) {
        pets.add(pet);
    }

    int countFamily() {
        return children.size() + 2;
    }

    void addChild(Human child) {
        child.setFamily(this);
        children.add(child);
    }

    boolean deleteChild(int i) {
        if(i < 0 || i >= children.size()) {
            return false;
        } else {
            children.get(i).setFamily(null);
            children.remove(i);
            return true;
        }
    }

    boolean deleteChild(Human child) {
        if(children.contains(child)) {
            children.remove(child);
            return true;
        } else {
            return  false;
        }
    }

    public void deleteAllChildrenOlderThen(int age) {
        long ms = Calendar.getInstance().getTimeInMillis();
        int i = 0;
        while(i < children.size()) {
            int years = (int) ((ms - children.get(i).getBirthDate().getTime()) / 365.25 / 24 / 60 / 60 / 1000);
            if (years > age) {
                deleteChild(i);
            } else {
                i++;
            }
        }
    }

    public JSONObject getJSON() {
        JSONObject familyJSON = new JSONObject();
        familyJSON.put("mother", mother.getJSON());
        familyJSON.put("father", father.getJSON());

        JSONArray childrenJSON = new JSONArray();
        for(Human child : children) {
            childrenJSON.add(child.getJSON());
        }
        familyJSON.put("children", childrenJSON);

        JSONArray petsJSON = new JSONArray();
        for(Pet pet : pets) {
            petsJSON.add(pet.getJSON());
        }
        familyJSON.put("pets", petsJSON);

        return familyJSON;
    }

    @Override
    // instead prettyFormat
    public String toString() {
        return "Family:" +
                "\n    mother: " + mother +
                "\n    father: " + father +
                "\n    children:" +
                "\n        " + children.stream().map(Human::toString).collect(Collectors.joining("\n        ")) +
                "\n    pets:" +
                "\n        " + pets.stream().map(Pet::toString).collect(Collectors.joining("\n        "));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Family family = (Family) o;

        if (!mother.equals(family.mother)) return false;
        return father.equals(family.father);
    }

    @Override
    public int hashCode() {
        int result = mother.hashCode();
        result = 31 * result + father.hashCode();
        return result;
    }
}
