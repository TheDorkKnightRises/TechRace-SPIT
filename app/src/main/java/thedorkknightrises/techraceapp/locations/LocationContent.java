package thedorkknightrises.techraceapp.locations;

import java.util.ArrayList;
import java.util.List;

public class LocationContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Location> ITEMS = new ArrayList<>();

    static {
        ITEMS.add(new Location(0, "Bhavan's Campus", "Location"));
        ITEMS.add(new Location(1, "Andheri East Station", "Location"));
        ITEMS.add(new Location(2, "Parle Factory", "Location"));
        ITEMS.add(new Location(3, "Siddhivinayak", "Location"));
        ITEMS.add(new Location(4, "Worli Seaface", "Location"));
        ITEMS.add(new Location(5, "Nehru Science Center", "Location"));
        ITEMS.add(new Location(6, "Hanging Gardens", "Location"));
        ITEMS.add(new Location(7, "NCPA", "Location"));
        ITEMS.add(new Location(8, "BSE", "Location"));
        ITEMS.add(new Location(9, "Azad Maidan", "Location"));
        ITEMS.add(new Location(10, "Byculla Zoo", "Location"));
        ITEMS.add(new Location(11, "Bandra Station", "Location"));
        ITEMS.add(new Location(12, "SPIT", "Location"));
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
