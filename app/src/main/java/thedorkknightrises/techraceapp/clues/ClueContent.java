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
        ITEMS_1.add(new Clue(1, LocationContent.ITEMS.get(1).name, "A clue is what you seek.\n" +
                "No one said it is easy.\n" +
                "Did you really strive for it?\n" +
                "Sure?\n" +
                "Trust your instincts.\n" +
                "Now go and find your destiny.\n" +
                "Easy it is, if you concentrate at first."));
        ITEMS_1.add(new Clue(2, LocationContent.ITEMS.get(2).name, "Though she has aged over the years,\n" +
                "her childhood photo will remain eternal.\n" +
                "If you figure this out, you are a genius!"));
        ITEMS_1.add(new Clue(3, LocationContent.ITEMS.get(3).name, "He's got some funk in his trunk, he's got a \uD83D\uDD2B in his name. People flock to this place to see him, and you must do the same."));
        ITEMS_1.add(new Clue(4, LocationContent.ITEMS.get(4).name, "This style of painting is quite popular in rural areas. Though it may seem vague, if you can <b>link</b> this clue to the next location, you may proceed further"));
        ITEMS_1.add(new Clue(5, LocationContent.ITEMS.get(5).name, "10-1-44  21-53\n\nMandeleev helped us with this clue. Decipher it to reach the next clue."));
        ITEMS_1.add(new Clue(6, LocationContent.ITEMS.get(6).name, "Pherozeshah sits overlooking the Arabian sea,\n" +
                "awaiting your arrival. Better hurry!\n" +
                "Your fate is hanging there"));
        ITEMS_1.add(new Clue(7, LocationContent.ITEMS.get(7).name, "6-6 2-2-2 7 2"));
        ITEMS_1.add(new Clue(8, LocationContent.ITEMS.get(8).name, "Bull yourself together and Bear with us a little longer as we point you towards the next location!"));
        ITEMS_1.add(new Clue(9, LocationContent.ITEMS.get(9).name, "The next location is named after the blind mother of a prosperous broker, and stands proudly looking over the land of freedom"));
        ITEMS_1.add(new Clue(10, LocationContent.ITEMS.get(10).name, "Her tales inspired a young child,\n" +
                "while her ideals moulded a great \n" +
                "Maratha warrior. Now she sits resilient\n" +
                "nurturing diverse species."));
        ITEMS_1.add(new Clue(11, LocationContent.ITEMS.get(11).name, ""));
        ITEMS_1.add(new Clue(12, LocationContent.ITEMS.get(12).name, "What goes around, comes around"));

        ITEMS_2.add(new Clue(1, LocationContent.ITEMS.get(1).name, "Located on Salsette island, this place holds the next clue.\n" +
                "Easily accessible through three different lines, isn't this clue out of the blue?"));
        ITEMS_2.add(new Clue(2, LocationContent.ITEMS.get(2).name, "Though my name means utterly unpleasant, now that I am shut, people reminisce my aroma!"));
        ITEMS_2.add(new Clue(3, LocationContent.ITEMS.get(3).name, "He's got some funk in his trunk, he's got a \uD83D\uDD2B in his name. People flock to this place to see him, and you must do the same."));
        ITEMS_2.add(new Clue(4, LocationContent.ITEMS.get(4).name, "dlior hvzuzxv\n\nDecipher this"));
        ITEMS_2.add(new Clue(5, LocationContent.ITEMS.get(5).name, "<b>-. ... -.-.</b>"));
        ITEMS_2.add(new Clue(6, LocationContent.ITEMS.get(6).name, "Your race will go on only if you find one of our organizers who has ditched his responsibilities but knows the further clues and destinations. Apparently, this guy has gone to watch the beautiful sunset atop a hill. Find this guy as the future of your race Hangs in the balance."));
        ITEMS_2.add(new Clue(7, LocationContent.ITEMS.get(7).name, "Waves crash, curtains rise. If you want to stay in the race, keep your eye on the prize"));
        ITEMS_2.add(new Clue(8, LocationContent.ITEMS.get(8).name, "<b>\"Bravo!\"</b>, he said, as the travelling performers from <b>Sierra</b> Leone bowed in front of their audience, amidst the <b>echo</b> of the audience's applause"));
        ITEMS_2.add(new Clue(9, LocationContent.ITEMS.get(9).name, "The next location is named after the blind mother of a prosperous broker, and stands proudly looking over the land of freedom"));
        ITEMS_2.add(new Clue(10, LocationContent.ITEMS.get(10).name, "Her tales inspired a young child,\n" +
                "while her ideals moulded a great \n" +
                "Maratha warrior. Now she sits resilient\n" +
                "nurturing diverse species."));
        ITEMS_2.add(new Clue(11, LocationContent.ITEMS.get(11).name, ""));
        ITEMS_2.add(new Clue(12, LocationContent.ITEMS.get(12).name, "What goes around, comes around"));
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
