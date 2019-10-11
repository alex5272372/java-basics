package hw01;

public class Numbers {
    public static void main(String[] args) {
        // https://www.filmsite.org/greatestfilms-byyear.html
        String[][] events = new String[10][];
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

        System.out.println(events[4][8]);
    }
}
