import greenfoot.*;

public class Your_Score extends Actor
{
    public Your_Score() {
        setImage("images/text/Your_Score.png"); // path gambar
        GreenfootImage img = getImage();
        img.scale(260, 150); // sesuaikan ukuran
        setImage(img);
    }
}
