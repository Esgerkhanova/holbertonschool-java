public class VideoMediaPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVLC(String fileName) {
        System.out.print("Playing VLC: " + fileName);
    }

    @Override
    public void playMP4(String fileName) {
        System.out.print("Playing MP4: " + fileName);
    }
}
