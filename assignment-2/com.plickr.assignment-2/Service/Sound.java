package Service;
import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Sound{
    public Sound(){
        try {
            URL url=this.getClass().getClassLoader().getResource( "images/Start.wav" );
            AudioInputStream audioIN= AudioSystem.getAudioInputStream( url );
            Clip clip=AudioSystem.getClip();
            clip.open( audioIN );
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();}}}
