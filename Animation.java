import greenfoot.*;
import java.util.ArrayList;

/**
 * Animation - memecah sprite strip horizontal menjadi frames dan mengatur playback.
 * path -> path to image in images/
 */
public class Animation {
    private ArrayList<GreenfootImage> frames;
    private int framesCount;
    private int currentIndex;
    private int frameDelay;   // ticks per frame
    private int delayCounter;
    private boolean looping;
    private boolean playing;
    private int playOnceRemaining; // ticks remaining for playOnce mode

    public Animation(String path, int framesCount) {
        this(path, framesCount, 6);
    }

    public Animation(String path, int framesCount, int frameDelay) {
        frames = new ArrayList<>();
        this.framesCount = Math.max(1, framesCount);
        this.currentIndex = 0;
        this.frameDelay = Math.max(1, frameDelay);
        this.delayCounter = 0;
        this.looping = true;
        this.playing = true;
        this.playOnceRemaining = -1;

        GreenfootImage strip = new GreenfootImage(path);
        int totalW = strip.getWidth();
        int totalH = strip.getHeight();
        int fw = totalW / this.framesCount;

        for (int i = 0; i < this.framesCount; i++) {
            GreenfootImage f = new GreenfootImage(fw, totalH);
            f.drawImage(strip, -i * fw, 0);
            frames.add(f);
        }
    }

    public void update() {
        if (!playing) return;

        delayCounter++;
        if (delayCounter >= frameDelay) {
            delayCounter = 0;
            currentIndex++;
            if (currentIndex >= frames.size()) {
                if (looping) {
                    currentIndex = 0;
                } else {
                    currentIndex = frames.size() - 1;
                    playing = false;
                }
            }
        }

        if (playOnceRemaining > 0) {
            playOnceRemaining--;
            if (playOnceRemaining <= 0) {
                // when ended, stop playing (caller decides next action)
                playing = false;
            }
        }
    }

    public GreenfootImage getCurrentFrame() {
        if (frames.isEmpty()) return null;
        return frames.get(currentIndex);
    }

    public GreenfootImage getFrameScaled(double scale) {
        GreenfootImage f = getCurrentFrame();
        if (f == null) return null;
        GreenfootImage copy = new GreenfootImage(f);
        int newW = Math.max(1, (int)(f.getWidth() * scale));
        int newH = Math.max(1, (int)(f.getHeight() * scale));
        copy.scale(newW, newH);
        return copy;
    }

    public void playLoop() {
        looping = true;
        playing = true;
        currentIndex = 0;
        delayCounter = 0;
        playOnceRemaining = -1;
    }

    public void playOnce(int durationTicks) {
        looping = false;
        playing = true;
        currentIndex = 0;
        delayCounter = 0;
        playOnceRemaining = Math.max(1, durationTicks);
    }

    public void stop() {
        playing = false;
    }

    public boolean isPlaying() {
        return playing;
    }
}
