package thedorkknightrises.techraceapp.clues;

import java.util.ArrayList;
import java.util.List;

public class ClueContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Clue> ITEMS_1 = new ArrayList<>();
    public static final List<Clue> ITEMS_2 = new ArrayList<>();

    static {
        ITEMS_1.add(new Clue(0, "Bhavan's Campus", ""));
        ITEMS_1.add(new Clue(1, "Andheri East Station", "A clue is what you seek.\n" +
                "No one said it is easy.\n" +
                "Did you really strive for it?\n" +
                "Sure?\n" +
                "Trust your instincts.\n" +
                "Now go and find your destiny.\n" +
                "Easy it is, if you concentrate at first."));
        ITEMS_1.add(new Clue(2, "Parle Factory", "Though she has aged over the years,\n" +
                "her childhood photo will remain eternal.\n" +
                "If you figure this out, you are a genius!"));
        ITEMS_1.add(new Clue(3, "Siddhivinayak", "He's got some funk in his trunk, he's got a \uD83D\uDD2B in his name. People flock to this place to see him, and you must do the same."));
        ITEMS_1.add(new Clue(4, "Mahalaxmi Racecourse", "IZXVXLFIGV (A->Z)"));
        ITEMS_1.add(new Clue(5, "Hanging Gardens", "Pherozeshah sits overlooking the Arabian sea,\n" +
                "awaiting your arrival. Better hurry!\n" +
                "Your fate is hanging there"));
        //TODO: Add clue
        ITEMS_1.add(new Clue(6, "NCPA", "Clue"));
        //TODO: Change clue
        ITEMS_1.add(new Clue(7, "Gateway of India", "This is NOT just a race. It's a battle against your friends AND your enemies. OR is it a battle against yourself? Is this the only WAY? Use some LOGIC and make INDIA proud."));
        ITEMS_1.add(new Clue(8, "Zoo", "Her tales inspired a young child,\n" +
                "while her ideals moulded a great \n" +
                "Maratha warrior. Now she sits resilient\n" +
                "nurturing diverse species."));
        //TODO: Add clue
        ITEMS_1.add(new Clue(9, "SPIT", "Clue"));

        ITEMS_2.add(new Clue(0, "Bhavan's Campus", ""));
        ITEMS_2.add(new Clue(1, "Andheri East Station", "Located on Salsette island, this place holds the next clue.\n" +
                "Easily accessible through three different lines, isn't this clue out of the blue?"));
        ITEMS_2.add(new Clue(2, "Parle Factory", "Though my name means utterly unpleasant, now that I am shut, people reminisce my aroma!"));
        //TODO: Change clue
        ITEMS_2.add(new Clue(3, "Siddhivinayak", "He's got some funk in his trunk, he's got a \uD83D\uDD2B in his name. People flock to this place to see him, and you must do the same."));
        ITEMS_2.add(new Clue(4, "Mahalaxmi Racecourse", "True to its name, many people make a lot of money here. Better be quick\n" +
                "because this is a race!"));
        //TODO: Change clue
        ITEMS_2.add(new Clue(5, "Hanging Gardens", "Pherozeshah sits overlooking the Arabian sea,\n" +
                "awaiting your arrival. Better hurry!\n" +
                "Your fate is hanging there"));
        //TODO: Add clue
        ITEMS_2.add(new Clue(6, "NCPA", "Clue"));
        ITEMS_2.add(new Clue(7, "Gateway of India", "This is NOT just a race. It's a battle against your friends AND your enemies. OR is it a battle against yourself? Is this the only WAY? Use some LOGIC and make INDIA proud."));
        //TODO: Change clue
        ITEMS_2.add(new Clue(8, "Zoo", "Her tales inspired a young child,\n" +
                "while her ideals moulded a great \n" +
                "Maratha warrior. Now she sits resilient\n" +
                "nurturing diverse species."));
        //TODO: Add clue
        ITEMS_2.add(new Clue(9, "SPIT", "Clue"));
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
