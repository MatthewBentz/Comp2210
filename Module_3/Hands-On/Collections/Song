/**
 * Models a musical song.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-02-02
 *
 */
public class Song implements Comparable<Song> {

   // title of the song
   String title;

   // name of the recording artist
   String artist;

   // year the song was released
   int year;

   // running time in seconds
   int duration;

   /** Creates a new Song instance. */
   public Song(String theTitle, String theArtist, int theYear, int theDuration) {
      title = theTitle;
      artist = theArtist;
      year = theYear;
      duration = theDuration;
   }

   /** Returns the title of this Song. */
   public String getTitle() {
      return title;
   }

   /** Returns the recording artist for this Song. */
   public String getArtist() {
      return artist;
   }

   /** Returns the year this Song was recorded. */
   public int getYear() {
      return year;
   }

   /** Returns the duration of this Song in seconds. */
   public int getDuration() {
      return duration;
   }

   /** Plays this Song. */
   public void play() {
      System.out.println(this);
   }

   /** Compare this Song with the parameter for order. */
   @Override
   public int compareTo(Song other) {
      int cmp = this.title.compareTo(other.title);
      if (cmp == 0){
         cmp = this.artist.compareTo(other.artist);
      }
      return cmp;
   }

   /** Compares this Song with the parameter for equality. */
   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (!(obj instanceof Song)) {
         return false;
      }
      Song other = (Song) obj;
      return this.title.equals(other.title) &&
         this.artist.equals(other.artist);
   }

   /** Returns a string representation of this Song. */
   @Override
   public String toString() {
      return "'" + title + "'"
         + ", " + artist + ", "
         + "(" + year + ")";
   }

}
