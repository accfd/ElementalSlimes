import greenfoot.*;

public class ReplayButton extends Button {

    public ReplayButton() {
        super("images/button/Replay.png"); // pastikan path gambar replay
    }

    public void act() {
        if (isClicked()) {
            SoundManager.playButtonClick(); // suara klik
            Greenfoot.setWorld(new PlayWorld()); // mulai ulang game / masuk ke world utama
        }
    }
}
