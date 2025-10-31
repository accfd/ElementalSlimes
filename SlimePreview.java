import greenfoot.*;

public class SlimePreview extends Actor {

    private String color;
    private String currentAnim;
    private int idleFrames, danceFrames, frameCount, frameIndex;
    private int frameDelay = 5, delayCount = 0;

    private int targetX, targetY = 250;
    private double targetScale, currentScale = 0.6;
    private int slot;

    private int danceTimer = 0;

    public SlimePreview(String color, int idleFrames, int danceFrames) {
        this.color = color;
        this.idleFrames = idleFrames;
        this.danceFrames = danceFrames;
        this.currentAnim = "Idle";
        this.frameCount = idleFrames;
        updateImage();
    }

    public void act() {
        smoothMove();
        animate();

        if (danceTimer > 0) {
            danceTimer--;
            if (danceTimer == 0 && slot != 1) {
                setAnimation("Idle");
            }
        }
    }

    public void setSlot(int slot) {
        this.slot = slot;
        if (slot == 0) {          // kiri
            targetX = 100;
            targetScale = 0.6;
            setAnimation("Idle");
        } else if (slot == 1) {   // tengah
            targetX = 200;
            targetScale = 1.0;
            setAnimation("Dance");
            danceTimer = 60;
        } else if (slot == 2) {   // kanan
            targetX = 300;
            targetScale = 0.6;
            setAnimation("Idle");
        }
    }

    private void setAnimation(String anim) {
        if (!anim.equals(currentAnim)) {
            currentAnim = anim;
            frameIndex = 0;
            frameCount = anim.equals("Idle") ? idleFrames : danceFrames;
        }
    }

    private void animate() {
        delayCount++;
        if (delayCount >= frameDelay) {
            delayCount = 0;
            frameIndex = (frameIndex + 1) % frameCount;
            updateImage();
        }
    }

    private void smoothMove() {
        // posisi X bergeser halus ke targetX
        int currentX = getX();
        int newX = currentX + (int)((targetX - currentX) * 0.2);
        int newY = targetY;
        setLocation(newX, newY);

        // skala berubah halus ke targetScale
        currentScale += (targetScale - currentScale) * 0.1;
    }

    private void updateImage() {
        try {
            String path = "images/characters/" + color + "_" + currentAnim + ".png";
            GreenfootImage sheet = new GreenfootImage(path);
            int frameWidth = sheet.getWidth() / frameCount;
            int frameHeight = sheet.getHeight();

            GreenfootImage frame = new GreenfootImage(frameWidth, frameHeight);
            frame.drawImage(sheet, -frameIndex * frameWidth, 0);

            int scaledW = (int)(frame.getWidth() * currentScale);
            int scaledH = (int)(frame.getHeight() * currentScale);
            frame.scale(Math.max(1, scaledW), Math.max(1, scaledH));
            setImage(frame);
        } catch (Exception e) {
            setImage(new GreenfootImage(60, 60));
            getImage().setColor(Color.RED);
            getImage().fill();
        }
    }

    public void onSelected() {
        setAnimation("Dance");
        targetScale = 1.2;
        updateImage();
    }

    public String getId() {
        return color;
    }
}
