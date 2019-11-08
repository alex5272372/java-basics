package hw12;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {
    private FamilyDao familyDao;

    FamilyService() {
        this.familyDao = new CollectionFamilyDao();
    }

    List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    void displayAllFamilies() {
        getAllFamilies().stream().forEach(family -> System.out.println(family));
    }

    List<Family> getFamiliesBiggerThan(int i) {
        List<Family> newFamilies = getAllFamilies().stream()
                .filter(family -> family.countFamily() > i)
                .collect(Collectors.toList());
        newFamilies.stream().forEach(family -> System.out.println(family));
        return newFamilies;
    }

    List<Family> getFamiliesLessThan(int i) {
        List<Family> newFamilies = getAllFamilies().stream()
                .filter(family -> family.countFamily() < i)
                .collect(Collectors.toList());
        newFamilies.stream().forEach(family -> System.out.println(family));
        return newFamilies;
    }

    int countFamiliesWithMemberNumber(int i) {
        return (int) getAllFamilies().stream().filter(family -> family.countFamily() == i).count();
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
        getAllFamilies().stream().forEach(family -> family.deleteAllChildrenOlderThen(age));
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
