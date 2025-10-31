import greenfoot.*;

public class StarButton extends Button {

    private boolean clicked = false;

    public StarButton() {
        super("images/button/Play.png"); // path asset
    }

    public void act() {
        checkClick();
    }

    private void checkClick() {
        if (Greenfoot.mouseClicked(this)) {
            clicked = true;
            SoundManager.playButtonClick(); // mainkan SFX tombol
        }
    }

    // world akan memanggil ini untuk tahu tombol diklik
    public boolean isClicked() {
        boolean wasClicked = clicked;
        clicked = false; // reset setelah diakses
        return wasClicked;
    }
}
