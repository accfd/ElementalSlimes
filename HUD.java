import greenfoot.*;

public class HUD extends Actor {
    private HeartDisplay heartDisplay;
    private int score = 0;

    public HUD(int lives, int score) {
        heartDisplay = new HeartDisplay(lives);
        this.score = score;
        updateScore();
    }

    public void addedToWorld(World world) {
        // Tambahkan heart di kanan atas (selalu di atas orb)
        world.addObject(heartDisplay, world.getWidth() - 70, 35);
        updateScore();
    }

    public void updateHUD(int score, int lives) {
        this.score = score;
        heartDisplay.updateLives(lives);
        updateScore();
    }

    private void updateScore() {
        GreenfootImage text = new GreenfootImage("Score: " + score, 24, Color.WHITE, new Color(0, 0, 0, 0));
        setImage(text);
    }
}
