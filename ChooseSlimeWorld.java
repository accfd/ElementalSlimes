import greenfoot.*;
import java.util.ArrayList;

public class ChooseSlimeWorld extends World {
    private ArrayList<SlimePreview> previews;
    private int inputCooldown;
    private static final int COOLDOWN_TICKS = 12;

    private StarButton starButton;
    private BackButton backButton;

    public ChooseSlimeWorld() {
        super(400, 600, 1);

        // ===== Background =====
        GreenfootImage bg = new GreenfootImage("images/background/Play_Background.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);

        // ===== Title =====
        ChooseTitle title = new ChooseTitle();
        addObject(title, getWidth() / 2, 145);

        // ===== Slime previews =====
        previews = new ArrayList<>();

        SlimePreview blue = new SlimePreview("Blue", 8, 5);
        SlimePreview red = new SlimePreview("Red", 8, 5);
        SlimePreview green = new SlimePreview("Green", 8, 5);

        previews.add(blue);
        previews.add(red);
        previews.add(green);

        addObject(previews.get(0), 100, 250);
        addObject(previews.get(1), 200, 250);
        addObject(previews.get(2), 300, 250);

        for (int i = 0; i < previews.size(); i++) {
            previews.get(i).setSlot(i);
        }

        // ===== Buttons =====
        int centerX = getWidth() / 2;
        int yButton = 400;
        int yText = 445;

        starButton = new StarButton();
        addObject(starButton, centerX - 70, yButton);
        TextLabel startText = new TextLabel("START", 26);
        addObject(startText, centerX - 70, yText);

        backButton = new BackButton();
        addObject(backButton, centerX + 70, yButton);
        TextLabel backText = new TextLabel("BACK", 26);
        addObject(backText, centerX + 70, yText);

        inputCooldown = 0;

        // ===== Play BGM menu hanya saat world muncul =====
        SoundManager.playMenuBGM();
    }

    public void act() {
        if (inputCooldown > 0) inputCooldown--;

        if (inputCooldown == 0) {
            if (Greenfoot.isKeyDown("left")) {
                rotateLeft();
                inputCooldown = COOLDOWN_TICKS;
            } else if (Greenfoot.isKeyDown("right")) {
                rotateRight();
                inputCooldown = COOLDOWN_TICKS;
            }
        }

        if (Greenfoot.isKeyDown("enter") || starButton.isClicked()) {
            SlimePreview selected = getCenterSlime();
            selected.onSelected();
            Greenfoot.setWorld(new LoadingWorld(selected.getId()));
        }
    }

    private void rotateLeft() {
        SlimePreview first = previews.remove(0);
        previews.add(first);
        updateSlots();
        SoundManager.playButtonClick(); // efek klik saat geser
    }

    private void rotateRight() {
        SlimePreview last = previews.remove(previews.size() - 1);
        previews.add(0, last);
        updateSlots();
        SoundManager.playButtonClick(); // efek klik saat geser
    }

    private void updateSlots() {
        for (int i = 0; i < previews.size(); i++) {
            previews.get(i).setSlot(i);
        }
    }

    public SlimePreview getCenterSlime() {
        return previews.get(1);
    }
}
