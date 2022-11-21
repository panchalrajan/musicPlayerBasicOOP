import java.util.ArrayList;

public class Album {
    private String artistName;
    private ArrayList<Song> songs;

    public Album(String artistName) {
        this.artistName = artistName;
        this.songs = new ArrayList<>();
    }

    //Find Song
    public boolean findSong(String title) {
        for(Song s : this.songs) {
            if(s.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Given Song found in Album");
                return true;
            }
        }
        System.out.println("Song not Found in the Album");
        return false;
    }

    //Add Song
    public boolean addSong(String title, double duration, int publishedYear, String artistName) {
        if(findSong(title)) {
            System.out.println("Song already present in the album");
            return false;
        } else {
            Song song = new Song(title, duration, publishedYear, artistName);
            songs.add(song);
            System.out.println("Song added Successfully");
        }
        return true;
    }

}
