package hw09;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FamilyService {
    private FamilyDao familyDao;

    FamilyService() {
        this.familyDao = new CollectionFamilyDao();
    }

    List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    void displayAllFamilies() {
        for(Family family : getAllFamilies()) {
            System.out.println(family);
        }
    }

    List<Family> getFamiliesBiggerThan(int i) {
        List<Family> newFamilies = new ArrayList<Family>();
        for(Family family : getAllFamilies()) {
            if(family.countFamily() > i) {
                newFamilies.add(family);
                System.out.println(family);
            }
        }
        return  newFamilies;
    }

    List<Family> getFamiliesLessThan(int i) {
        List<Family> newFamilies = new ArrayList<Family>();
        for(Family family : getAllFamilies()) {
            if(family.countFamily() < i) {
                newFamilies.add(family);
                System.out.println(family);
            }
        }
        return newFamilies;
    }

    int countFamiliesWithMemberNumber(int i) {
        int count = 0;
        for(Family family : getAllFamilies()) {
            if(family.countFamily() == i) {
                count++;
            }
        }
        return count;
    }

    Family createNewFamily(Human mother, Human father) {
        Family newFamily = new Family(mother, father);
        familyDao.saveFamily(newFamily);
        return newFamily;
    }

    void deleteFamilyByIndex(int i) {
        familyDao.deleteFamily(i);
    }

    public Family bornChild(Family family, String manName, String womanName) {
        family.getMother().bornChild(manName, womanName);
        return family;
    }

    Family adoptChild(Family family, Human child) {
        family.addChild(child);
        return family;
    }

    void deleteAllChildrenOlderThen(int age) {
        for(Family family : getAllFamilies()) {
            family.deleteAllChildrenOlderThen(age);
        }
    }

    int count() {
        return getAllFamilies().size();
    }

    Family getFamilyById(int i) {
        return familyDao.getFamilyByIndex(i);
    }

    Set<Pet> getPets(int i) {
        return getFamilyById(i).getPets();
    }

    void addPet(int i, Pet pet) {
        getFamilyById(i).addPet(pet);
    }
}
