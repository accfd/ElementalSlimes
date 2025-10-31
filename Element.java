import greenfoot.*;  

public abstract class Element extends Actor {
    protected double baseSpeed = 1.0;
    protected String type;
    private static double timeFactor = 0; // makin lama, makin cepat

    public Element(String type, double baseSpeed) {
        this.type = type;
        this.baseSpeed = baseSpeed;

        GreenfootImage img = getImage();
        if (img != null) {
            img.scale(50, 50); // semua element pakai 50x50
            setImage(img);
        }
    }

    public void act() {
        fall();
    }

    protected void fall() {
        timeFactor += 0.0005; // percepatan
        double currentSpeed = baseSpeed + timeFactor;
        setLocation(getX(), (int)(getY() + currentSpeed));

        World world = getWorld();
        if (world != null && getY() > world.getHeight() + 20) {
            world.removeObject(this);
        }
    }

    public String getType() {
        return type;
    }
}