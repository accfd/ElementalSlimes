import greenfoot.*;

public class Slime extends Actor {
    private String color;
    private int score = 0;
    private int lives = 3;

    private boolean rainbowMode = false;
    private int rainbowTimer = 0;

    private Animation idleAnim;
    private Animation walkAnim;
    private Animation danceAnim;
    private Animation deadAnim;
    private Animation currentAnim;

    public Slime(String color) {
        this.color = color;

        idleAnim = new Animation("images/characters/" + color + "_Idle.png", 8);
        walkAnim = new Animation("images/characters/" + color + "_Walk.png", 8);
        danceAnim = new Animation("images/characters/" + color + "_Dance.png", 5);
        deadAnim = new Animation("images/characters/" + color + "_Dead.png", 6);

        currentAnim = idleAnim;
    }

    public void act() {
        if (lives <= 0) {
            playDead();
            return;
        }

        handleMovement();
        checkCollision();
        updateRainbowMode();

        currentAnim.update();
        GreenfootImage frame = currentAnim.getCurrentFrame();
        if (frame != null) setImage(frame);
    }

    private void handleMovement() {
        boolean moving = false;

        if (Greenfoot.isKeyDown("left") && getX() > 40) {
            setLocation(getX() - 4, getY());
            moving = true;
            getImage().mirrorHorizontally();
        } else if (Greenfoot.isKeyDown("right") && getX() < getWorld().getWidth() - 40) {
            setLocation(getX() + 4, getY());
            moving = true;
        }

        if (moving && currentAnim != walkAnim && !rainbowMode) {
            currentAnim = walkAnim;
            walkAnim.playLoop();
        } else if (!moving && currentAnim != idleAnim && !rainbowMode) {
            currentAnim = idleAnim;
            idleAnim.playLoop();
        }
    }

    private void checkCollision() {
        Element e = (Element)getOneIntersectingObject(Element.class);
        if (e == null) return;

        String type = e.getType();
        getWorld().removeObject(e);

        if (type.equals("Skull")) {
            lives--;
            SoundManager.playSkullHit();
        } 
        else if (type.equals("Star")) {
            lives++;
            SoundManager.playStarCollect();
            playDanceOnce();
        } 
        else if (type.equals("Rainbow")) {
            startRainbowMode();
            SoundManager.playRainbowCollect();
        } 
        else { // orb warna
            if (rainbowMode || type.equals(color)) {
                score += 10;
                SoundManager.playOrbCorrect();
                playDanceOnce();
            } else {
                score -= 5;
                SoundManager.playOrbWrong();
            }
        }

        ((PlayWorld)getWorld()).updateHUD(score, lives);
    }

    private void startRainbowMode() {
        rainbowMode = true;
        rainbowTimer = 600; // 10 detik
        currentAnim = danceAnim;
        danceAnim.playLoop();
    }

    private void updateRainbowMode() {
        if (rainbowMode) {
            rainbowTimer--;
            if (rainbowTimer <= 0) {
                rainbowMode = false;
                currentAnim = idleAnim;
                idleAnim.playLoop();
            }
        }
    }

    private void playDanceOnce() {
        if (!rainbowMode) {
            currentAnim = danceAnim;
            danceAnim.playOnce(50); // dance sebentar lalu idle
        }
    }

    private void playDead() {
        // mainkan SFX player death
        SoundManager.playPlayerDeath();
        currentAnim = deadAnim;
        deadAnim.playOnce(60);
        Greenfoot.delay(60);
        Greenfoot.setWorld(new GameOverWorld(score));
    }

    public String getColor() { return color; }
    public int getScore() { return score; }
    public int getLives() { return lives; }
}
