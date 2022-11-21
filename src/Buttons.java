import java.util.ListIterator;

public class Buttons {
    private Database database;
    private boolean shuffle = false;
    static int i=0;
    static int randomNo;
    public Buttons(Database database) {
        this.database = database;
    }

    public boolean isShuffle() {
        return shuffle;
    }

    public void setShuffle(boolean shuffle) {
        if(!isShuffle()) System.out.println("Shuffling the Songs");
        else System.out.println("Stopped the Shuffling of Songs");
        this.shuffle = shuffle;
    }


    public void playSong() {
        if(isShuffle()) System.out.println(this.database.songs.get(randomNo));
        else System.out.println(this.database.songs.get(i));
    }

    public void playNext() {
        if(isShuffle()) playRandom();
        else if(this.database.songs.size() > i+1)
            System.out.println(this.database.songs.get(++i));
        else{
            System.out.println("You have reached the end of Songs List, Starting Playing from 1st Song");
            i=0;
            playSong();
        }
    }

    public void playPrevious() {
        if(isShuffle()) playRandom();
        else if(i==0)
            System.out.println("You have reached the starting of Songs List");
        else
            System.out.println(this.database.songs.get(--i));
    }

    public void playRandom() {
        //Even I am using random function, I can still record the prev and next values using 2 stack method
        randomNo = 0 + (int) (Math.random() * ((this.database.songs.size()-1) -0)+ 1);
        System.out.println(this.database.songs.get(randomNo));
    }
}
