package thedorkknightrises.techraceapp.locations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Location> ITEMS = new ArrayList<>();

    static {
        ITEMS.add(new Location(0, "Bhavan's Campus", "“It's a dangerous business, Frodo, going out your door. You step onto the road, and if you don't keep your feet, there's no knowing where you might be swept off to.”\n\t\t\t- J.R.R. Tolkien, The Hobbit"));
        ITEMS.add(new Location(1, "Andheri East Station", "“\"I've got to go back, haven't I?\"\n" +
                "\"That is up to you.\"\n" +
                "\"I've got a choice?\"\n" +
                "\"Oh yes.\" Dumbledore smiled at him. \"We are in King's Cross, you say? I think that if you decided not to go back, you would be able to…let's say…board a train.\"\n" +
                "\"And where would it take me?\"\n" +
                "\"On,\" said Dumbledore simply.”\n\t\t\t- J.K. Rowling, Harry Potter and the Deathly Hallows"));
        ITEMS.add(new Location(2, "Parle Factory", "“Mr. Wonka: \"Don’t forget what happened to the man who suddenly got everything he wanted.\"\n" +
                "Charlie Bucket: \"What happened?\"\n" +
                "Mr. Wonka: \"He lived happily ever after.”\n\t\t\t- Roald Dahl, Charlie and the Chocolate Factory"));
        ITEMS.add(new Location(3, "Siddhivinayak", "“We are not human beings on a spiritual journey,\nWe are spiritual beings on a human journey“\n\t\t\t- Dr. Stephen Covey"));
        ITEMS.add(new Location(4, "Mahalaxmi Racecourse", "“Speed has never killed anyone, suddenly becoming stationary… that’s what gets you.” \n" +
                "\t\t\t- Jeremy Clarkson"));
        ITEMS.add(new Location(5, "Hanging Gardens", "“And the secret garden bloomed and bloomed and every morning revealed new miracles.” \n" +
                "\t\t\t- Frances Hodgson Burnett, The Secret Garden"));
        ITEMS.add(new Location(6, "NCPA", "Description"));
        ITEMS.add(new Location(7, "Gateway of India", "Description"));
        ITEMS.add(new Location(8, "Zoo", "Description"));
        ITEMS.add(new Location(9, "SPIT", "\tBack where we started. Just like in 'The Alchemist'...how cliched. But then it IS true: \"...wherever your heart is, that is where you´ll find your treasure\"\nThis is the end of this treasure hunt. Or is it merely the beginning of the next?"));
    }

    public static class Location {
        public final int id;
        public final String name;
        public final String details;

        public Location(int id, String name, String details) {
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
