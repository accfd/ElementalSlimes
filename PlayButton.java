import greenfoot.*;

public class PlayButton extends Button {

    public PlayButton() {
        super("images/button/Play.png");
    }

    public void act() {
        if (isClicked()) {
            Greenfoot.setWorld(new ChooseSlimeWorld());
        }
    }
}
