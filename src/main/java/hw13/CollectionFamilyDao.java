package hw13;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    private final String FILE_NAME = "families.json";
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
        if (i >= 0 && i < families.size()) {
            families.remove(i);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteFamily(Family family) {
        for (Family f : families) {
            if (f.hashCode() == family.hashCode() && f.equals(family)) {
                families.remove(f);
                return true;
            }
        }
        return false;
    }

    public void saveFamily(Family family) {
        if (families.contains(family)) {
            for (Family f : families) {
                if (f.hashCode() == family.hashCode() && f.equals(family)) {
                    families.set(families.indexOf(f), family);
                    break;
                }
            }
        } else {
            families.add(family);
        }
    }

    // https://www.mkyong.com/java/json-simple-example-read-and-write-json/
    public void loadData() {
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader(FILE_NAME)) {

            JSONArray familiesJSON = (JSONArray) parser.parse(reader);
            Iterator<JSONObject> iterator = familiesJSON.iterator();
            while (iterator.hasNext()) {
                JSONObject familyJSON = iterator.next();
                Human mother = new Man((JSONObject) familyJSON.get("mother"));
                Human father = new Man((JSONObject) familyJSON.get("father"));
                Family family = new Family(mother, father);
                saveFamily(family);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void saveData() {
        JSONArray familiesJSON = new JSONArray();
        for(Family family : families) {
            familiesJSON.add(family.getJSON());
        }

        try (FileWriter file = new FileWriter(FILE_NAME)) {
            file.write(familiesJSON.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}