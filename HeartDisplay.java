import greenfoot.*;
import java.util.ArrayList;

public class HeartDisplay extends Actor {
    private ArrayList<GreenfootImage> hearts;
    private int lives;

    public HeartDisplay(int lives) {
        this.lives = Math.max(0, Math.min(3, lives)); // batas awal 0–3
        hearts = new ArrayList<>();
        updateImage();
    }

    public void updateLives(int newLives) {
        this.lives = Math.max(0, Math.min(3, newLives)); // batas 0–3
        updateImage();
    }

    private void updateImage() {
        GreenfootImage img = new GreenfootImage(150, 50);
        GreenfootImage red = new GreenfootImage("images/items/Red_Heart.png");
        GreenfootImage grey = new GreenfootImage("images/items/Grey_Heart.png");

        red.scale(40, 40);
        grey.scale(40, 40);

        for (int i = 0; i < 3; i++) {
            if (i < lives)
                img.drawImage(red, i * 45, 5);
            else
                img.drawImage(grey, i * 45, 5);
        }

        setImage(img);
    }
}
