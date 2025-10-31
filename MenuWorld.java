import greenfoot.*;

public class MenuWorld extends World {

    private Logo logo;
    private PlayButton playButton;
    private QuitButton quitButton;

    public MenuWorld() {
        super(400, 600, 1);

        // === Set Background ===
        GreenfootImage bg = new GreenfootImage("images/background/Menu_Background.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);

        // === Logo ===
        logo = new Logo();
        addObject(logo, getWidth() / 2, 145);

        int centerX = getWidth() / 2;
        int yButton = 290;
        int yText = 340;

        // === Play Button ===
        playButton = new PlayButton();
        addObject(playButton, centerX - 50, yButton);
        TextLabel playText = new TextLabel("PLAY", 26);
        addObject(playText, centerX - 50, yText);

        // === Quit Button ===
        quitButton = new QuitButton();
        addObject(quitButton, centerX + 50, yButton);
        TextLabel quitText = new TextLabel("QUIT", 26);
        addObject(quitText, centerX + 50, yText);

        // === Main Menu BGM ===
        SoundManager.playMenuBGM();
    }

    public void act() {
        // Cek klik tombol
        if (playButton.isClicked()) {
            SoundManager.playButtonClick();
            Greenfoot.setWorld(new ChooseSlimeWorld());
        }

        if (quitButton.isClicked()) {
            SoundManager.playButtonClick();
            Greenfoot.stop();
        }
    }
}
