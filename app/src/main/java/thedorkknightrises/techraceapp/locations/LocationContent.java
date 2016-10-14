package thedorkknightrises.techraceapp.locations;

import java.util.ArrayList;
import java.util.List;

import thedorkknightrises.techraceapp.R;

public class LocationContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Location> ITEMS = new ArrayList<>();

    static {
        ITEMS.add(new Location(0, "SPIT Quad", "This is where your journey starts...", R.drawable.spit));
        ITEMS.add(new Location(1, "Bhavan's Campus", "Location", R.drawable.banner));
        ITEMS.add(new Location(2, "Andheri East Station", "Location", R.drawable.banner));
        ITEMS.add(new Location(3, "Parle Factory", "Location", R.drawable.banner));
        ITEMS.add(new Location(4, "Siddhivinayak", "Location", R.drawable.banner));
        ITEMS.add(new Location(5, "Nehru Science Center", "Location", R.drawable.banner));
        ITEMS.add(new Location(6, "Worli Seaface", "Location", R.drawable.banner));
        ITEMS.add(new Location(7, "Hanging Gardens", "Location", R.drawable.banner));
        ITEMS.add(new Location(8, "NCPA", "Location", R.drawable.banner));
        ITEMS.add(new Location(9, "BSE", "Location", R.drawable.banner));
        ITEMS.add(new Location(10, "Azad Maidan", "Location", R.drawable.banner));
        ITEMS.add(new Location(11, "Byculla Zoo", "Location", R.drawable.banner));
        ITEMS.add(new Location(12, "Bandra Station", "Location", R.drawable.p12));
        ITEMS.add(new Location(13, "SPIT", "Location", R.drawable.spit));
    }

    public static class Location {
        public final int id;
        public final String name;
        public final String details;
        public int image;

        public Location(int id, String name, String details, int imageRes) {
            this.id = id;
            this.name = name;
            this.details = details;
            this.image = imageRes;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
