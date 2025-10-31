import greenfoot.*;

public class GameOverWorld extends World {

    private BackButton backButton;
    private ReplayButton replayButton;
    private QuitButton quitButton;

    public GameOverWorld(int finalScore) {
        super(400, 600, 1);

        GreenfootImage bg = new GreenfootImage("images/background/Menu_Background.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);

        SoundManager.stopMainBGM();
        SoundManager.playScoreBGM();

        Your_Score yourScoreText = new Your_Score();
        addObject(yourScoreText, getWidth() / 2, 150);

        TextLabel scoreText = new TextLabel(String.valueOf(finalScore), 32);
        addObject(scoreText, getWidth() / 2, 200);

        int centerX = getWidth() / 2;
        int yButton = 350;
        int yText = 400;
        int spacing = 100;

        backButton = new BackButton();
        addObject(backButton, centerX - spacing, yButton);
        TextLabel backText = new TextLabel("BACK", 26);
        addObject(backText, centerX - spacing, yText);

        replayButton = new ReplayButton();
        addObject(replayButton, centerX, yButton);
        TextLabel replayText = new TextLabel("REPLAY", 26);
        addObject(replayText, centerX, yText);

        quitButton = new QuitButton();
        addObject(quitButton, centerX + spacing, yButton);
        TextLabel quitText = new TextLabel("QUIT", 26);
        addObject(quitText, centerX + spacing, yText);
    }

    public void act() {
        if (backButton.isClicked()) {
            SoundManager.playButtonClick();
            Greenfoot.setWorld(new MenuWorld());
        }

        if (replayButton.isClicked()) {
            SoundManager.playButtonClick();
            Greenfoot.setWorld(new PlayWorld());
        }

        if (quitButton.isClicked()) {
            SoundManager.playButtonClick();
            Greenfoot.stop();
        }
    }
}
