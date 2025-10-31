import greenfoot.*;

public class PlayWorld extends World {
    private Slime slime;
    private int spawnTimer = 0;
    private int spawnInterval = 60;
    private double difficultyTimer = 0;

    private HUD hud;
    private int score = 0;
    private int lives = 3;

    private String selectedId;
    private PauseButton pauseButton;

    // ===== Constructor default =====
    public PlayWorld() {    
        super(400, 600, 1, false);
        this.selectedId = "Blue"; // default slime
        prepare();
    }

    // ===== Constructor dengan slime terpilih =====
    public PlayWorld(String selectedId) {
        super(400, 600, 1, false);
        this.selectedId = selectedId;
        prepare();
    }

    // ===== Prepare World =====
    private void prepare() {
        // Background
        GreenfootImage bg = new GreenfootImage("images/background/Play_Background.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);

        // Urutan tampilan (nyawa & score di atas orb)
        setPaintOrder(HeartDisplay.class, HUD.class, PauseButton.class, Element.class, Slime.class);

        // Sound
        SoundManager.stopMenuBGM();
        SoundManager.playMainBGM();

        // Slime
        slime = new Slime(selectedId);
        addObject(slime, getWidth() / 2, getHeight() - 100);

        // HUD
        hud = new HUD(lives, score);
        addObject(hud, 70, 30); // kiri atas (score)

        // Pause Button di tengah atas
        pauseButton = new PauseButton();
        addObject(pauseButton, getWidth() / 2, 35);
    }

    // ===== Act =====
    public void act() {
        spawnTimer++;
        difficultyTimer += 0.005;

        if (spawnTimer >= spawnInterval) {
            spawnRandomElement();
            spawnTimer = 0;
        }

        if (spawnInterval > 20) {
            spawnInterval = (int) Math.max(20, 60 - (int) difficultyTimer * 2);
        }

        if (pauseButton.isClicked()) {
            SoundManager.playButtonClick();
            Greenfoot.setWorld(new PauseWorld(this));
        }
    }

    // ===== Spawn Element Random =====
    private void spawnRandomElement() {
        int roll = Greenfoot.getRandomNumber(12);
        Element e;

        if (roll < 3) e = new BlueOrb();
        else if (roll < 6) e = new RedOrb();
        else if (roll < 9) e = new GreenOrb();
        else if (roll == 9) e = new Skull();
        else if (roll == 10) e = new Star();
        else e = new Rainbow();

        int x = Greenfoot.getRandomNumber(getWidth());
        addObject(e, x, 0);
    }

    // ===== Update HUD =====
    public void updateHUD(int score, int lives) {
        this.score = score;
        this.lives = Math.max(0, Math.min(3, lives)); // batasi 0–3
        if (hud != null) {
            hud.updateHUD(this.score, this.lives);
        }
    }

    public int getScore() { return score; }
    public int getLives() { return lives; }
}
