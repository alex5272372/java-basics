package hw01;

import java.util.Scanner;
import java.util.Random;

public class Numbers {
    private final static int years = 10;
    private final static int films = 10;

    public static void main(String[] args) {
        // https://www.filmsite.org/greatestfilms-byyear.html
        String[][] events = new String[years][];
        events[0] = new String[]{
                "Almost Famous",
                "American Psycho",
                "Amores Perros",
                "The Beach",
                "Best in Show",
                "Billy Elliot",
                "The Cell",
                "Chicken Run",
                "Crouching Tiger, Hidden Dragon",
                "Dancer in the Dark"
        };
        events[1] = new String[]{
                "Amelie",
                "A Beautiful Mind",
                "Black Hawk Down",
                "Donnie Darko",
                "Fat Girl",
                "Final Fantasy: The Spirits Within",
                "Ghost World",
                "Gosford Park",
                "Hannibal",
                "Harry Potter and the Sorcerer's Stone"
        };
        events[2] = new String[]{
                "Adaptation",
                "The Bourne Identity",
                "Bowling for Columbine",
                "Chicago",
                "City of God",
                "Die Another Day",
                "Far From Heaven",
                "Femme Fatale",
                "Frida",
                "Gangs of New York"
        };
        events[3] = new String[]{
                "Big Fish",
                "Dogville",
                "The Dreamers",
                "Finding Nemo",
                "Good Bye Lenin!",
                "House of Sand and Fog",
                "Kill Bill: Vol. 1",
                "Lost in Translation",
                "Love, Actually",
                "Master and Commander: The Far Side of the World"
        };
        events[4] = new String[]{
                "Bad Education",
                "Before Sunset",
                "The Bourne Supremacy",
                "Dawn of the Dead",
                "The Day After Tomorrow",
                "Downfall",
                "Eternal Sunshine of the Spotless Mind",
                "Fahrenheit 9/11",
                "Harry Potter and the Prisoner of Azkaban",
                "Hellboy"
        };
        events[5] = new String[]{
                "Aeon Flux",
                "Batman Begins",
                "Brokeback Mountain",
                "Cache",
                "Capote",
                "The Chronicles of Narnia: The Lion, the Witch, and the Wardrobe",
                "The Constant Gardener",
                "Crash",
                "The Exorcism of Emily Rose",
                "Good Night, and Good Luck"
        };
        events[6] = new String[]{
                "Apocalypto",
                "Away From Her",
                "Babel",
                "Borat: Cultural Learnings of America for Make Benefit Glorious Nation of Kazakhstan",
                "Casino Royale",
                "The Departed",
                "The Devil Wears Prada",
                "Dreamgirls",
                "Flags of Our Fathers",
                "Happy Feet"
        };
        events[7] = new String[]{
                "Across the Universe",
                "The Assassination of Jesse James By the Coward Robert Ford",
                "Atonement",
                "Before the Devil Knows You're Dead",
                "The Bourne Ultimatum",
                "The Diving Bell and the Butterfly",
                "4 Months, 3 Weeks, and 2 Days",
                "Gone Baby Gone",
                "Hairspray",
                "Hannibal Rising"
        };
        events[8] = new String[]{
                "Anvil! The Story of Anvil",
                "The Chronicles of Narnia: Prince Caspian",
                "The Class (Entre les Murs)",
                "The Curious Case of Benjamin Button",
                "The Dark Knight",
                "Doubt",
                "Frost/Nixon",
                "Gomorrah (Gomorra)",
                "Gran Torino",
                "Indiana Jones and the Kingdom of the Crystal Skull"
        };
        events[9] = new String[]{
                "Avatar",
                "The Bad Lieutenant Port of Call: New Orleans",
                "The Blind Side",
                "Crazy Heart",
                "An Education",
                "The Girl With the Dragon Tattoo",
                "The Hangover",
                "Harry Potter and the Half Blood Prince",
                "The Hurt Locker",
                "Inglourious Basterds"
        };

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = sc.next();
        System.out.println("Let the game begin!");

        while(true) {
            int i = generateRandomInt();
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("What year is the movie premiere?");
            System.out.println(events[i / films][i % films]);
            System.out.println("Enter a number from 0 (corresponds to 2000) to 9 (corresponds to 2009), or -1 for exit");

            boolean[] approach = new boolean[years];
            while (true) {
                String val = sc.next();
                int num = processNextInt(val);

                if (num == -2 || !isValidInput(num)) {
                    continue;
                } else if(num == -1) {
                    return;
                }

                if(approach[num]) {
                    System.out.println("This number was entered earlier.");
                    continue;
                } else {
                    approach[num] = true;
                }

                int res = directionOfApproach(num, i / films, name);
                if(res == 0) {
                    printApproach(approach);
                    break;
                }
            }
        }
    }

    private static void printApproach(boolean[] approach) {
        String res = "";
        for(int i = years - 1; i >= 0; i--) {
            if(approach[i]) {
                res = res + " " + i;
            }
        }
        System.out.println("Your numbers:" + res);
    }

    private static int generateRandomInt(){
        Random random = new Random();
        return random.nextInt(years * films);
    }

    private static int directionOfApproach(int val, int dest, String name) {
        if(val < dest) {
            System.out.println("Your number is too small. Please, try again.");
            return -1;
        } else if(val > dest) {
            System.out.println("Your number is too big. Please, try again.");
            return 1;
        } else {
            System.out.println(String.format("Congratulations, %s!", name));
            return 0;
        }
    }

    private static boolean isValidInput(int val) {
        if(val >= -1 && val <= 9) {
            return true;
        } else {
            System.out.println("Wrong input. Value must be between -1 and 9.");
            return false;
        }
    }

    private static int processNextInt(String val) {
        try {
            return Integer.parseInt(val);
        } catch (Exception e) {
            System.out.println(String.format("Wrong input. %s.", e.getMessage()));
            return -2;
        }
    }
}
