import greenfoot.*;

public class LoadingWorld extends World {
    private String selectedId;
    private int ticksToLoad = 500; // ≈ 5 detik
    private int dotCounter = 0;
    private TextLabel loadingLabel;
    private SlimePreviewActor slimeActor;
    private Animation danceAnimation;

    public LoadingWorld(String selectedId) {
        super(400, 600, 1);
        this.selectedId = selectedId;

        // ===== Background =====
        GreenfootImage bg = new GreenfootImage("images/background/Play_Background.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);

        // ===== Loading Label =====
        loadingLabel = new TextLabel("LOADING", 28);
        addObject(loadingLabel, getWidth()/2, getHeight()/2 - 120);

        // ===== Slime pilihan =====
        danceAnimation = new Animation("images/characters/" + selectedId + "_Dance.png", 5, 8);
        slimeActor = new SlimePreviewActor(danceAnimation);
        addObject(slimeActor, getWidth()/2, getHeight()/2 - 20);

        // ===== Text slime terpilih =====
        TextLabel selectedText = new TextLabel("Selected: " + selectedId, 22);
        addObject(selectedText, getWidth()/2, getHeight()/2 + 70);

        // ===== Peraturan singkat =====
        addObject(new TextLabel("HOW TO PLAY:", 22), getWidth()/2, getHeight()/2 + 120);
        addObject(new TextLabel("Use ← → to Move", 18), getWidth()/2, getHeight()/2 + 145);
        addObject(new TextLabel("Collect Orbs to Score", 18), getWidth()/2, getHeight()/2 + 165);
        addObject(new TextLabel("Avoid Skulls!", 18), getWidth()/2, getHeight()/2 + 185);

        // ===== BGM tetap menu sampai PlayWorld muncul =====
        // SoundManager.playMenuBGM(); 
        // Tidak perlu dipanggil lagi karena sudah dipanggil di ChooseSlimeWorld
    }

    public void act() {
        ticksToLoad--;

        // Update animasi dance
        danceAnimation.update();
        slimeActor.updateImage(danceAnimation);

        // Update titik-titik pada LOADING...
        if (ticksToLoad % 15 == 0) {
            dotCounter = (dotCounter + 1) % 4;
            String dots = "";
            for (int i = 0; i < dotCounter; i++) dots += ".";
            loadingLabel.setImage(new GreenfootImage(
                "LOADING" + dots,
                28,
                new Color(255, 255, 255),
                new Color(0, 0, 0, 0)
            ));
        }

        // Setelah selesai loading → masuk PlayWorld
        if (ticksToLoad <= 0) {
            Greenfoot.setWorld(new PlayWorld(selectedId));
        }
    }
}
