import greenfoot.*;

public class ChooseTitle extends Actor
{
    public ChooseTitle() {
        setImage("images/text/Choose_Slime.png");
        GreenfootImage img = getImage();
        img.scale(260, 150); // sesuaikan agar pas di 400x600
        setImage(img);
    }
}
