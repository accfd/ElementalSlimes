import greenfoot.*;

public class QuitButton extends Button {

    public QuitButton() {
        super("images/button/Quit.png");
    }

    public void act() {
        if (isClicked()) {
            Greenfoot.stop();
        }
    }
}
