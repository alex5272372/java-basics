package hw12;

import java.util.*;

public class FamilyController {
    private FamilyService familyService;

    public FamilyController() {
        this.familyService = new FamilyService();
    }

    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int i) {
        return  familyService.getFamiliesBiggerThan(i);
    }

    public List<Family> getFamiliesLessThan(int i) {
        return familyService.getFamiliesLessThan(i);
    }

    public int countFamiliesWithMemberNumber(int i) {
        return familyService.countFamiliesWithMemberNumber(i);
    }

    public Family createNewFamily(Human mother, Human father) {
        return familyService.createNewFamily(mother, father);
    }

    public void deleteFamilyByIndex(int i) {
        familyService.deleteFamilyByIndex(i);
    }

    public Family bornChild(Family family, String manName, String womanName) {
        return familyService.bornChild(family, manName, womanName);
    }

    public Family adoptChild(Family family, Human child) {
        return familyService.adoptChild(family, child);
    }

    public void deleteAllChildrenOlderThen(int age) {
        familyService.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return familyService.count();
    }

    public Family getFamilyById(int i) {
        return familyService.getFamilyById(i);
    }

    Set<Pet> getPets(int i) {
        return familyService.getPets(i);
    }

    public void addPet(int i, Pet pet) {
        familyService.addPet(i, pet);
    }

    private int doAction(int state, Deque<String> params) {
        switch (state) {
            case 100:
                Woman mother1 = new Woman("Kate1", "Karleone1", "20/10/1965", 65);
                Man father1 = new Man("John1", "Karleone1", "08/05/1967", 67);
                Family family1 = createNewFamily(mother1, father1);
                bornChild(family1, "Man11", "Woman11");
                Dog dogPet1 = new Dog("bobik1", 4, 40);
                addPet(0, dogPet1);
                DomesticCat catPet = new DomesticCat("tom", 3, 60);
                addPet(0, catPet);

                Woman mother2 = new Woman("Kate2", "Karleone2", "20/10/1965", 65);
                Man father2 = new Man("John2", "Karleone2", "08/05/1967", 67);
                Family family2 = createNewFamily(mother2, father2);
                bornChild(family2, "Man21", "Woman21");
                bornChild(family2, "Man22", "Woman22");
                Dog dogPet = new Dog("bobik", 4, 40);
                addPet(1, dogPet);

                Woman mother3 = new Woman("Kate3", "Karleone3", "20/10/1965", 65);
                Man father3 = new Man("John3", "Karleone3", "08/05/1967", 67);
                Family family3 = createNewFamily(mother3, father3);
                bornChild(family3, "Man31", "Woman31");
                bornChild(family3, "Man32", "Woman32");
                bornChild(family3, "Man33", "Woman33");
                return 0;

            case 200:
                displayAllFamilies();
                return 0;

            case 301:
                getFamiliesBiggerThan(Integer.parseInt(params.poll()));
                return 0;

            case 401:
                getFamiliesLessThan(Integer.parseInt(params.poll()));
                return 0;

            case 501:
                System.out.println("countFamiliesWithMemberNumber: " + countFamiliesWithMemberNumber(Integer.parseInt(params.poll())));
                return 0;

            case 612:
                String motherName = params.poll();
                String motherSurname = params.poll();
                String motherYear = params.poll();
                String motherMonth = params.poll();
                String motherDay = params.poll();
                int motherIQ = Integer.parseInt(params.poll());
                Woman mother = new Woman(motherName, motherSurname, motherDay + "/" + motherMonth + "/" + motherYear, motherIQ);
                String fatherName = params.poll();
                String fatherSurname = params.poll();
                String fatherYear = params.poll();
                String fatherMonth = params.poll();
                String fatherDay = params.poll();
                int fatherIQ = Integer.parseInt(params.poll());
                Man father = new Man(fatherName, fatherSurname, fatherDay + "/" + fatherMonth + "/" + fatherYear, fatherIQ);
                createNewFamily(mother, father);
                return 0;

            case 701:
                deleteFamilyByIndex(Integer.parseInt(params.poll()) - 1);
                return 0;

            case 813:
                int familyNumber = Integer.parseInt(params.poll());
                String boyName = params.poll();
                String girlName = params.poll();

                Family family = getFamilyById(familyNumber - 1);
                bornChild(family, boyName, girlName);
                return 0;

            case 828:
                int familyNumber1 = Integer.parseInt(params.poll());
                String gender = params.poll();
                String childName = params.poll();
                String childSurname = params.poll();
                String childYear = params.poll();
                String childMonth = params.poll();
                String childDay = params.poll();
                int childIQ = Integer.parseInt(params.poll());

                Family family4 = getFamilyById(familyNumber1 - 1);
                Human child;
                if(gender.equals("m")) {
                    child = new Man(childName, childSurname, childDay + "/" + childMonth + "/" + childYear, childIQ);
                } else {
                    child = new Woman(childName, childSurname, childDay + "/" + childMonth + "/" + childYear, childIQ);
                }
                adoptChild(family4, child);
                return 0;

            case 830:
                return 0;

            default:
                return state;
        }
    }

    private String getMessage(int state) {
        switch (state) {
            case 0:
                return "1. Fill with test data\n" +
                        "2. Display the entire list of families\n" +
                        "3. Display a list of families where the number of people is more than a given\n" +
                        "4. Display a list of families where the number of people is less than a given\n" +
                        "5. Calculate the number of families where the number of members is equal\n" +
                        "6. Create a new family\n" +
                        "7. Delete family by family index in the general list\n" +
                        "8. Edit family by family index in the general list\n" +
                        "9. Remove all children over the age of";
            case 300:
            case 400:
            case 500:
                return "Enter number of people:";

            case 600:
                return "Enter mother's first name:";
            case 601:
                return "Enter mother's last name:";
            case 602:
                return "Enter mother's year of birth:";
            case 603:
                return "Enter mother's month of birth:";
            case 604:
                return "Enter mother's day of birth:";
            case 605:
                return "Enter mother's IQ:";
            case 606:
                return "Enter father's first name:";
            case 607:
                return "Enter father's last name:";
            case 608:
                return "Enter father's year of birth:";
            case 609:
                return "Enter father's month of birth:";
            case 610:
                return "Enter father's day of birth:";
            case 611:
                return "Enter father's IQ:";

            case 700:
            case 810:
            case 820:
                return "Enter family number";
            case 800:
                return "1. Have a baby\n" +
                        "2. Adopt a child\n" +
                        "3. Return to the main menu";

            case 811:
                return "Enter boy's first name:";
            case 812:
                return "Enter girl's first name:";
            case 821:
                return "Enter child's gender (m or f):";
            case 822:
                return "Enter child's first name:";
            case 823:
                return "Enter child's last name:";
            case 824:
                return "Enter child's year of birth:";
            case 825:
                return "Enter child's month of birth:";
            case 826:
                return "Enter child's day of birth:";
            case 827:
                return "Enter child's IQ:";

            case 900:
                return "Enter age:";
            default:
                return "";
        }
    }

    private int processState(int state, Deque<String> params) throws FamilyOverflowException {
        state = doAction(state, params);
        System.out.println(getMessage(state));

        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();

        if(data.equals("exit")) {
            return -1;
        }

        if(state == 600 || state == 601 || state == 606 || state == 607
        || state == 811 || state == 812 || state == 821 || state == 822 || state == 823) {
            if(state == 821 && !data.equals("m") && !data.equals("f")) {
                throw new FamilyOverflowException("Input 'm' or 'f', please");
            }

            params.offer(data);
            return state + 1;

        } else {
            int i = 0;

            try {
                i = Integer.parseInt(data);
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Your input is invalid, please try again");
                return state;
            }

            switch (state) {
                case 0:
                    if(i >= 1 && i <= 9) {
                        return i * 100;
                    } else {
                        throw new FamilyOverflowException("Item does not exist");
                    }

                case 800:
                    if(i >= 1 && i <= 3) {
                        return state + i * 10;
                    } else {
                        throw new FamilyOverflowException("Item does not exist");
                    }

                case 300:
                case 400:
                case 500:
                    if(i < 2) {
                        throw new FamilyOverflowException("A family cannot be less than 2 people");
                    }
                    break;

                case 602:
                case 608:
                case 824:
                    if(i < 1900 || i > 2100) {
                        throw new FamilyOverflowException("A year must be from 1900 to 2100");
                    }
                    break;

                case 603:
                case 609:
                case 825:
                    if(i < 1 || i > 12) {
                        throw new FamilyOverflowException("A month must be from 1 to 12");
                    }
                    break;

                case 604:
                case 610:
                case 826:
                    if(i < 1 || i > 31) {
                        throw new FamilyOverflowException("A day must be from 1 to 31");
                    }
                    break;
            }

            params.offer(String.valueOf(i));
            return state + 1;
        }

    }

    public void commandsLoop() {
        int state = 0;
        Deque<String> params = new ArrayDeque<>();

        while (state != -1) {
            try {
                state = processState(state, params);
            } catch (FamilyOverflowException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }
}
