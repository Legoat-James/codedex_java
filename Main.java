public class Main {
    public static void main(String[] args) {
        // Add your code here! 💖
        MusicDownloader m = new MusicDownloader( "Pink Pony Club","Chappell Roan","Midwest Princess","https://www.spotify.com/pink-pony-club.mp3",2023);
        m.showFilelink("pink pony club");
        m.showFilelink("nonexistant");


    }
}

// Add your class here! 💖
class MusicDownloader {
    private String songName;
    private String artistName;
    private String album;
    private String fileLink;
    private int releaseYear;
    public void showFilelink(String songName){
        if (this.songName.equalsIgnoreCase(songName)){
            System.out.println("Link for " + songName + " is: " + fileLink);
        }
    };
    public MusicDownloader(){
        this.songName = "";
        this.artistName = "";
        this.album = "";
        this.fileLink = "";
        this.releaseYear = 0000;
    };
    public MusicDownloader(String song,String artist,String album,String filelink,int release){
        this.songName = song;
        this.artistName = artist;
        this.album = album;
        this.fileLink = filelink;
        this.releaseYear = release;
    };
}

