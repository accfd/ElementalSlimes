import greenfoot.*;

public class SlimePreviewActor extends Actor {
    private Animation anim;

    public SlimePreviewActor(Animation anim) {
        this.anim = anim;
        setImage(anim.getCurrentFrame());
    }

    public void updateImage(Animation anim) {
        GreenfootImage img = anim.getCurrentFrame();
        if (img != null) {
            GreenfootImage scaled = new GreenfootImage(img);
            scaled.scale(120, 120);
            setImage(scaled);
        }
    }
}
