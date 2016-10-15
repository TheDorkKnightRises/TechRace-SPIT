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
        ITEMS.add(new Location(0, "SPIT Quad", "This is where your journey starts...<br>Within the walls of Sardar Patel Institute of Technology, an engineering college located in Andheri, a suburb of Mumbai. It is affiliated to Mumbai University and offers graduate (Bachelor), post-graduate (Master) and doctoral (Ph.D.) degrees in Engineering. The Institute is reputed for excellent training in programs in engineering and technology at the certificate, degree, post-graduate and doctoral levels, as well as numerous well-regarded research works. The institute has initiated the process of academic autonomy with Maharashtra State.", R.drawable.spit));
        ITEMS.add(new Location(1, "Bhavan's Campus", "Bhavan's Campus is home to Bhavan's College, Sardar Patel College of Engineering (SPCE), and the hosts of this event, Sardar Patel Institute of Technology(SPIT). It is built upon 45 acres (180,000 m2) of land and has huge volleyball and basketball courts, as well as football pitches,a botanical garden and an adventure park.", R.drawable.p01));
        ITEMS.add(new Location(2, "Andheri East Station", "It serves the Western line and Harbour lines of the Mumbai Suburban Railway. The station also inter-connects the Line 1 of the Andheri metro station. Andheri station first came under prominence after the development of Salsette-Trombay Railway services in 1928 by the British Empire of India during the pre-independence period.<br>" +
                "With a pre-eminent number of passengers boarding daily, it has been termed \"one of the busiest stations\" in Mumbai surpassing Ghatkopar station on the Central line. In 2014, the station, along with Jogeshwari and Goregaon stations, was re-developed and expanded with the expenditure of ₹103 crore (US$15 million). In addition, the station has two bus stations operating more than 30 bus routes.", R.drawable.p02));
        ITEMS.add(new Location(3, "Parle Factory", "The aroma of India's favourite cookie/biscuit, Parle G, being baked in a large factory very close to the station made a journey through Vile Parle a drool-worthy experience. Started in 1929, Parle Products Pvt. Ltd borrowed the biscuit’s name from the area itself, so much so that the factory has become the landmark for Vile Parle over the decades.", R.drawable.p03));
        ITEMS.add(new Location(4, "Siddhivinayak", "The city of Mumbai is a mute witness to places of worship & historical interest, which are not only popular but also of archaeological importance. Arguably the most popular & significant places of worship is the Shree Siddhivinayak Ganapati Mandir situated at Prabhadevi ,Mumbai, a two-century-old Temple that fulfills the desires of the worshipers.", R.drawable.p04));
        ITEMS.add(new Location(5, "Nehru Science Center", "Nehru Science Centre is a wonderful initiative that covers various aspects of science and technology in a way that is both interesting and informative. This science centre has an impressive collection of historical artefacts that depict scientific achievements in various fields.", R.drawable.p05));
        ITEMS.add(new Location(6, "Worli Sea Face", "Featuring picturesque surroundings that are characterised by endless blue waters of the Arabian Sea and distant Haji Ali Dargah, Worli Sea Face is a posh area in South Mumbai. It is a business district and a major residential area, inhabited mostly by affluent people.", R.drawable.p06));
        ITEMS.add(new Location(7, "Hanging Gardens", "Hanging Gardens, also referred as Pherozeshah Mehta Gardens, are beautiful terraced gardens that are set atop the western side of Malabar Hill. The colourful flower clock at the centre and numerous animal-shaped hedges are the unique features of this park. You can also enjoy spectacular views of the Arabian Sea from the Hanging Gardens.", R.drawable.p07));
        ITEMS.add(new Location(8, "NCPA", "National Centre for the Performing Arts, abbreviated as NCPA, is an esteemed cultural institution in the vibrant metropolis of Mumbai. It is a multi-venue and multi-purpose complex that aims at promoting and preserving the rich Indian heritage - performing arts, literature, films and photography.", R.drawable.p08));
        ITEMS.add(new Location(9, "BSE", "Bombay Stock Exchange (BSE), now known as 'BSE Limited', is the oldest stock exchange in the entire Asia. It is located in the Phiroze Jeejeebhoy Towers, Dalal Street in Fort and has the largest number of companies of the world listed on it.", R.drawable.p09));
        ITEMS.add(new Location(10, "Azad Maidan", "Azad Maidan (formerly known as Bombay Gymkhana Maidan). is a triangular-shaped maidan (sports ground) in Mumbai, Maharashtra, India.It is located on 25 acres of land near the Chhatrapati Shivaji Terminus station.It is a regular venue for inter-school cricket matches. The name Azad means \"liberty\" in Persian.The ground is known for its cricket pitches,for protest meetings, and for political rallies.The Bombay Gymkhana clubhouse was built in 1875, at the southern end of the maidan.", R.drawable.p10));
        ITEMS.add(new Location(11, "Bandra Station", "Bandra Terminus is a railway terminus in Bandra (E) from where trains bound for northern and western India are scheduled regularly. It is one of the six railway terminus within Mumbai City. It was built in the 1990s to decongest the main Mumbai Central station. Presently about 49 trains use this station.<br>" +
                "Bandra Terminus is close to 'Bandra-Kurla Complex', a commercially important part of Mumbai as well as Mumbai Airport.", R.drawable.p11));
        ITEMS.add(new Location(12, "SPIT", "This is where your journey ends...<br>Within the walls of Sardar Patel Institute of Technology.", R.drawable.spit));
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
