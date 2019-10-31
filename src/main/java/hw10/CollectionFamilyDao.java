package hw10;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    private List<Family> families;

    public CollectionFamilyDao() {
        this.families = new ArrayList<Family>();
    }

    public List<Family> getAllFamilies() {
        return families;
    }

    public Family getFamilyByIndex(int i) {
        return families.get(i);
    }

    public boolean deleteFamily(int i) {
        if(i >= 0 && i < families.size()) {
            families.remove(i);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteFamily(Family family) {
        for(Family f : families) {
            if(f.hashCode() == family.hashCode() && f.equals(family)) {
                families.remove(f);
                return true;
            }
        }
        return false;
    }

    public void saveFamily(Family family) {
        if(families.contains(family)) {
            for(Family f : families) {
                if(f.hashCode() == family.hashCode() && f.equals(family)) {
                    families.set(families.indexOf(f), family);
                    break;
                }
            }
        } else {
            families.add(family);
        }
    }
}
