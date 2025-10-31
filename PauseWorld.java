import greenfoot.*;

public class PauseWorld extends World {

    private ResumeButton resumeButton;
    private ReplayButton replayButton;
    private BackButton backButton;
    private PlayWorld playWorld; 

    public PauseWorld(PlayWorld playWorld) {
        super(400, 600, 1);
        this.playWorld = playWorld;

        // === Background Semi Transparan ===
        GreenfootImage bg = new GreenfootImage("images/background/Menu_Background.png");
        bg.scale(getWidth(), getHeight());
        bg.setTransparency(200);
        setBackground(bg);

        int centerX = getWidth() / 2;
        int yButton = 300;
        int yText = 350;
        int spacing = 100; // jarak antar tombol

        // ===== Resume Button (kiri) =====
        resumeButton = new ResumeButton();
        addObject(resumeButton, centerX - spacing, yButton);
        TextLabel resumeText = new TextLabel("RESUME", 24);
        addObject(resumeText, centerX - spacing, yText);

        // ===== Replay Button (tengah) =====
        replayButton = new ReplayButton();
        addObject(replayButton, centerX, yButton);
        TextLabel replayText = new TextLabel("REPLAY", 24);
        addObject(replayText, centerX, yText);

        // ===== Back Button (kanan) =====
        backButton = new BackButton();
        addObject(backButton, centerX + spacing, yButton);
        TextLabel backText = new TextLabel("BACK", 24);
        addObject(backText, centerX + spacing, yText);

        // ===== Ganti TextLabel "PAUSED" jadi Gambar =====
        Paused pausedLogo = new Paused();
        addObject(pausedLogo, centerX, 150);
    }

    public void act() {
        if (resumeButton.isClicked()) {
            SoundManager.playButtonClick();
            Greenfoot.setWorld(playWorld); // lanjut game sebelumnya
        }

        if (replayButton.isClicked()) {
            SoundManager.playButtonClick();
            Greenfoot.setWorld(new PlayWorld()); // mulai ulang game
        }

        if (backButton.isClicked()) {
            SoundManager.playButtonClick();
            Greenfoot.setWorld(new MenuWorld()); // balik ke menu utama
        }
    }
}
