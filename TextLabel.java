import greenfoot.*;

public class TextLabel extends Actor
{
    public TextLabel(String text, int size) {
        // Foreground = putih, Background = transparan (alpha = 0)
        GreenfootImage img = new GreenfootImage(
            text,
            size,
            new greenfoot.Color(255, 255, 255),   // teks putih
            new greenfoot.Color(0, 0, 0, 0)      // background transparan
        );
        setImage(img);
    }
}
