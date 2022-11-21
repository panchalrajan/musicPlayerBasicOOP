public class Song {
    private static int increment=1;
    private int trackNo;
    private String title;
    private double duration;
    private int publishedYear;
    private String artistName;

    public Song(String title, double duration, int publishedYear, String artistName) {
        this.title = title;
        this.duration = duration;
        this.publishedYear = publishedYear;
        this.artistName = artistName;
    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public String getArtistName() {
        return artistName;
    }

    /*
    This function is called when we give command like
    Song s = new Song("title", 1.4, "Arman");
    System.out.print(s);
    Output -> Address of Given Object
     */
    @Override
    public String toString() {
        String details = "Title -> " + getTitle() +
                " | Duration -> " + getDuration() +
                " | Artist -> " + getArtistName() +
                " | Published Year -> " + getPublishedYear();
        return details;
    }
}
