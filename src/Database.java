import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Database {
    LinkedList<Song> songs;
    private Buttons buttons;

    public Database() {
        this.songs = new LinkedList<>();
    }

    public boolean findSong(Song songToFind) {
        for(Song checkSong : this.songs) {
            if(checkSong.getTitle().equalsIgnoreCase(songToFind.getTitle()) &&
                checkSong.getArtistName().equalsIgnoreCase(songToFind.getArtistName())) {
                System.out.println("Find Song Result -> Song Found in Library");
                return true;
            }
        }
        System.out.println("Find Song Result -> Song Not Found in Library");
        return false;
    }

    public boolean findSong(String title, String artistName) {
        for(Song checkSong : this.songs) {
            if(checkSong.getTitle().equalsIgnoreCase(title) &&
                    checkSong.getArtistName().equalsIgnoreCase(artistName)) {
                System.out.println("Find Song Result -> Song Found in Library");
                return true;
            }
        }
        System.out.println("Find Song Result -> Song Not Found in Library");
        return false;
    }

    public boolean addSong(Song songToAdd) {
        if(findSong(songToAdd)) {
            System.out.println("Ad Song Result -> Song Already Present in the Library");
            return false;
        }
        Song song = new Song(songToAdd.getTitle(), songToAdd.getDuration(), songToAdd.getPublishedYear(), songToAdd.getArtistName());
        songs.add(song);
        System.out.println("Add Song Result -> Song added to the Library Successfully");
        return true;
    }

    public boolean addSong(String title, double duration, int publishedYear, String artistName)  {
        if(findSong(title, artistName)) {
            System.out.println("Ad Song Result -> Song Already Present in the Library");
            return false;
        }
        Song song = new Song(title, duration, publishedYear, artistName);
        songs.add(song);
        System.out.println("Add Song Result -> Song added to the Library Successfully");
        return true;
    }

    public void deleteSong() {
        System.out.println("Please select the Track No of Song which you want to Delete");
        printSongsList();
        Scanner sc = new Scanner(System.in);
        int deleteIndex = sc.nextInt();
        this.songs.remove(deleteIndex-1);
        System.out.println("Song Deleted from Database Successfully");
        sc.close();
    }

    public void deleteSong(int deleteIndex) {
        this.songs.remove(deleteIndex-1);
        System.out.println("Song Deleted from Database Successfully");
    }


    public void printSongsList() {
        System.out.println("<-------------------------------Songs List Starts------------------------------->");
        for(int i=0;i<this.songs.size();i++) {
            System.out.println("Track No -> " + (i+1) + " | " + songs.get(i));
        }
        System.out.println("<--------------------------------Songs List Ends-------------------------------->");
    }


}
