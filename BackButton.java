import greenfoot.*;

public class BackButton extends Button {

    public BackButton() {
        super("images/button/Back.png");
    }

    public void act() {
        if (isClicked()) {
            Greenfoot.setWorld(new MenuWorld());
        }
    }
}
