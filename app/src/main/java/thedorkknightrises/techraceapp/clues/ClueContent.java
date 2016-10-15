package thedorkknightrises.techraceapp.clues;

import java.util.ArrayList;
import java.util.List;

import thedorkknightrises.techraceapp.locations.LocationContent;

public class ClueContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Clue> ITEMS_1 = new ArrayList<>();
    public static final List<Clue> ITEMS_2 = new ArrayList<>();

    static {
        ITEMS_1.add(new Clue(1, LocationContent.ITEMS.get(1).name, "This is where frogs go to watch movies. Think TechRace! Think puns!"));
        ITEMS_1.add(new Clue(2, LocationContent.ITEMS.get(2).name, "A clue is what you seek.<br>" +
                "No one said it is easy.<br>" +
                "Did you really strive for it?<br>" +
                "Sure?<br>" +
                "Trust your instincts.<br>" +
                "Now go and find your destiny.<br>" +
                "Easy it is, if you concentrate at first."));
        ITEMS_1.add(new Clue(3, LocationContent.ITEMS.get(3).name, "Though she has aged over the years,<br>" +
                "her childhood photo will remain eternal.<br>" +
                "If you figure this out, you are a genius!"));
        ITEMS_1.add(new Clue(4, LocationContent.ITEMS.get(4).name, "He's got some funk in his trunk, he's got a \uD83D\uDD2B in his name. People flock to this place to see him, and you must do the same."));
        ITEMS_1.add(new Clue(5, LocationContent.ITEMS.get(5).name, "10-1-44  21-53<br>Mandeleev helped us with this clue. Decipher it to reach the next clue."));
        ITEMS_1.add(new Clue(6, LocationContent.ITEMS.get(6).name, "<b>.-- --- .-. .-.. ..   -.. .- .. .-. -.--</b>"));
        ITEMS_1.add(new Clue(7, LocationContent.ITEMS.get(7).name, "Pherozeshah sits overlooking the Arabian sea,\n" +
                "awaiting your arrival. Better hurry!\n" +
                "Your fate is hanging in the balance"));
        ITEMS_1.add(new Clue(8, LocationContent.ITEMS.get(8).name, "6-6 2-2-2 7 2"));
        ITEMS_1.add(new Clue(9, LocationContent.ITEMS.get(9).name, "It's the economic backbone of this City. Visit \"The Red Street\" to know more!"));
        ITEMS_1.add(new Clue(10, LocationContent.ITEMS.get(10).name, "The next location is named after the blind mother of a prosperous broker, and stands proudly looking over the land of freedom"));
        ITEMS_1.add(new Clue(11, LocationContent.ITEMS.get(11).name, "<a href=\"image://techrace2k16.image/clue\">Image</a><br>The station with a lakeview where even the stars come to rest"));
        ITEMS_1.add(new Clue(12, LocationContent.ITEMS.get(12).name, "What goes around, comes around. Start is end and end is start."));

        ITEMS_2.add(new Clue(1, LocationContent.ITEMS.get(1).name, "This is where amphibians go to watch movies. Think TechRace! Think puns!"));
        ITEMS_2.add(new Clue(2, LocationContent.ITEMS.get(2).name, "Located on Salsette island, this place holds the next clue.\n" +
                "Easily accessible through three different lines, isn't this clue out of the blue?"));
        ITEMS_2.add(new Clue(3, LocationContent.ITEMS.get(3).name, "Though my name means utterly unpleasant, now that I am shut, people reminisce my aroma!"));
        ITEMS_2.add(new Clue(4, LocationContent.ITEMS.get(4).name, "He's got some funk in his trunk, he's got a \uD83D\uDD2B in his name. People flock to this place to see him, and you must do the same."));
        ITEMS_2.add(new Clue(5, LocationContent.ITEMS.get(5).name, "10-1-44  21-53<br>Mandeleev helped us with this clue. Decipher it to reach the next clue."));
        ITEMS_2.add(new Clue(6, LocationContent.ITEMS.get(6).name, "dlior hvzuzxv<br>Decipher this"));
        ITEMS_2.add(new Clue(7, LocationContent.ITEMS.get(7).name, "Your race will go on only if you find one of our organizers who has ditched his responsibilities but knows the further clues and destinations. Apparently, this guy has gone to watch the beautiful sunset atop a hill. Find this guy as the future of your race Hangs in the balance."));
        ITEMS_2.add(new Clue(8, LocationContent.ITEMS.get(8).name, "Waves crash, curtains rise. If you want to stay in the race, keep your eye on the prize"));
        ITEMS_2.add(new Clue(9, LocationContent.ITEMS.get(9).name, "It's the economic backbone of this City. Visit \"The Red Street\" to know more!"));
        ITEMS_2.add(new Clue(10, LocationContent.ITEMS.get(10).name, "The next location is named after the blind mother of a prosperous broker, and stands proudly looking over the land of freedom"));
        ITEMS_2.add(new Clue(11, LocationContent.ITEMS.get(11).name, "<a href=\"image://techrace2k16.image/clue\">Image</a><br>The station with a lakeview where even the stars come to rest"));
        ITEMS_2.add(new Clue(12, LocationContent.ITEMS.get(12).name, "What goes around, comes around. Start is end and end is start."));
    }

    public static InAppChallenge getInAppChallenge(int location) {
        switch (location) {
            case 2:
                return new InAppChallenge("Give the next element in the sequence:\nABC, FDE, HIG, ___", "JKL");
            case 4:
                return new InAppChallenge("What kind of tree can you carry in your hand?\n" +
                        "(Answer in one word)", "PALM");
            case 6:
                return new InAppChallenge("Give the next 2 elements in the series:\n" +
                        "3, 11, 31, 69, _, _\n" +
                        "(Input two numbers separated by single space)", "131 223");
            case 9:
                return new InAppChallenge("Replace the ? by the correct mathematics symbol (+ OR - OR x OR /) to make the expression true\n" +
                        "18 ? 12 ? 4 ? 5 = 59\n" +
                        "(Input 3 operators separated by space)", "x / +");
            default:
                return new InAppChallenge("Without using any letter more than once, what are the largest and the smallest whole numbers that you can write down in words?\n" +
                        "E.G. FORTY SIX is a valid answer, but NINETY is not (as N is used twice in NINETY)\n" +
                        "(Input as LARGEST<space>AND<space>SMALLEST)", "FIVE THOUSAND AND ZERO");
        }
    }

    public static class InAppChallenge {
        public final String question;
        public final String answer;

        public InAppChallenge(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }
    }

    public static class Clue {
        public final int id;
        public final String name;
        public final String details;

        public Clue(int id, String name, String details) {
            this.id = id;
            this.name = name;
            this.details = details;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
