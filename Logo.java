import greenfoot.*;

public class Logo extends Actor
{
    public Logo() {
        setImage("images/text/Logo_ElementalSlimes.png");
        GreenfootImage img = getImage();
        img.scale(260, 150);
        setImage(img);
    }
}
