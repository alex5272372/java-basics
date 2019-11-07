package hw11;

import java.util.List;

public interface FamilyDao {
    List<Family> getAllFamilies();
    Family getFamilyByIndex(int i);
    boolean deleteFamily(int i);
    boolean deleteFamily(Family family);
    void saveFamily(Family family);
}
