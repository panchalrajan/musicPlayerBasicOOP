import java.util.Scanner;

public class Main {
    public static void UserMenu() {

        System.out.println("<-------MENU------->");
        System.out.println("Type 1 to Play the Song");
        System.out.println("Type 2 to Play Next Song");
        System.out.println("Type 3 to Play Previous Song");
        System.out.println("Type 4 to Shuffle (On/Off) the Songs");
        System.out.println("Type 5 to Print List of Songs");
        System.out.println("Type 6 to Delete a Song by Index");
        System.out.println("Type 7 to Print the Menu Again");
        System.out.println("Type 8 to Quit the Music Player");
    }
    public static void main(String[] args) {
        Database database = new Database();
        Buttons buttons = new Buttons(database);
        //Using Random Function to Generate some Songs Data
        for(int i=1;i<10;i++) {
            double duration = 1 + Math.round(Math.random()*90)/10D;
            int year = 2015 + (int)(Math.random() * ((2021 - 2015) + 1));
            int artistNo = 1+ (int)(Math.random() * ((3 - 1) + 1));
            database.addSong("Title 0" + i, duration , year, "Artist 0" + artistNo);
        }

        //Printing Menu by Default
        UserMenu();

        //Infinitely Taking Input from User
        Scanner sc = new Scanner(System.in);
        while(true) {
            int caseHandler = sc.nextInt();
            switch (caseHandler) {
                case 1:
                    System.out.println("Command : Play Song");
                    buttons.playSong();
                    break;
                case 2:
                    System.out.println("Command : Next Song");
                    buttons.playNext();
                    break;
                case 3:
                    System.out.println("Command : Previous Song");
                    buttons.playPrevious();
                    break;
                case 4:
                    System.out.println("Command : Shuffle (On/Off) the Songs");
                    buttons.setShuffle(!buttons.isShuffle());
                    break;
                case 5:
                    System.out.println("Command : Print Songs List");
                    database.printSongsList();
                    break;
                case 6:
                    System.out.println("Command : Delete a Song");
                    database.printSongsList();
                    System.out.println("Please enter the Track No. of Song to Delete");
                    int deleteIndex = sc.nextInt();
                    database.deleteSong(deleteIndex);
                    break;
                case 7:
                    UserMenu();
                    break;
                case 8:
                    System.out.println("Closing the App");
                    System.exit(0);
                    break;
            }
        }
    }
}