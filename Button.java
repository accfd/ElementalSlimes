import greenfoot.*;

public class Button extends Actor
{
    public Button(String imagePath) {
        setImage(imagePath);

        GreenfootImage img = getImage();
        img.scale(55, 55); // Ukuran tombol pas dan simetris
        setImage(img);
    }

    public boolean isClicked() {
        return Greenfoot.mouseClicked(this);
    }
}
