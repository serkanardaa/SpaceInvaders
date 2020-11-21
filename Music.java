//Serkan Arda Yilal S005044 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Music {

    String s;
    AudioPlayer MGP = AudioPlayer.player;

    public Music(String s) {
        this.s = s;
    }

    public void startBGMusic() {

        AudioStream BGM;

        ContinuousAudioDataStream loop = null;

        try {
            InputStream test = new FileInputStream("./" + s + ".wav");
            BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);

        } catch (FileNotFoundException e) {
            System.out.print(e.toString());
        } catch (IOException error) {
            System.out.print(error.toString());
        }
        MGP.start(loop);

    }

}
