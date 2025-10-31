import greenfoot.GreenfootSound;

public class SoundManager {
    // BGM
    private static GreenfootSound bgmMenu = new GreenfootSound("sounds/bgm_menu.mp3");
    private static GreenfootSound bgmMain = new GreenfootSound("sounds/bgm_main.mp3");
    private static GreenfootSound bgmScore = new GreenfootSound("sounds/bgm_score.mp3");

    private static boolean menuBGMStarted = false;
    private static boolean mainBGMStarted = false;
    private static boolean scoreBGMStarted = false;

    // SFX
    private static GreenfootSound sfxButtonClick = new GreenfootSound("sounds/sfx_button_click.mp3");
    private static GreenfootSound sfxOrbCorrect = new GreenfootSound("sounds/sfx_orb_correct.mp3");
    private static GreenfootSound sfxOrbWrong = new GreenfootSound("sounds/sfx_orb_wrong.mp3");
    private static GreenfootSound sfxPlayerDeath = new GreenfootSound("sounds/sfx_player_death.mp3");
    private static GreenfootSound sfxSkullHit = new GreenfootSound("sounds/sfx_skull_hit.mp3");
    private static GreenfootSound sfxStarCollect = new GreenfootSound("sounds/sfx_star_collect.mp3");
    private static GreenfootSound sfxRainbowCollect = new GreenfootSound("sounds/sfx_rainbow_collect.mp3");

    // ===== BGM Controls =====
    public static void playMenuBGM() {
        if (!menuBGMStarted) {
            stopAllBGM();
            bgmMenu.playLoop();
            menuBGMStarted = true;
        }
    }

    public static void stopMenuBGM() {
        bgmMenu.stop();
        menuBGMStarted = false;
    }

    public static void playMainBGM() {
        if (!mainBGMStarted) {
            stopAllBGM();
            bgmMain.playLoop();
            mainBGMStarted = true;
        }
    }

    public static void stopMainBGM() {
        bgmMain.stop();
        mainBGMStarted = false;
    }

    public static void playScoreBGM() {
        if (!scoreBGMStarted) {
            stopAllBGM();
            bgmScore.playLoop();
            scoreBGMStarted = true;
        }
    }

    public static void stopScoreBGM() {
        bgmScore.stop();
        scoreBGMStarted = false;
    }

    // Stop semua BGM (misal pindah world)
    public static void stopAllBGM() {
        stopMenuBGM();
        stopMainBGM();
        stopScoreBGM();
    }

    // ===== SFX Controls =====
    public static void playButtonClick() {
        sfxButtonClick.stop(); // hentikan jika masih main
        sfxButtonClick.play();
    }

    public static void playOrbCorrect() {
        sfxOrbCorrect.stop();
        sfxOrbCorrect.play();
    }

    public static void playOrbWrong() {
        sfxOrbWrong.stop();
        sfxOrbWrong.play();
    }

    public static void playPlayerDeath() {
        sfxPlayerDeath.stop();
        sfxPlayerDeath.play();
    }

    public static void playSkullHit() {
        sfxSkullHit.stop();
        sfxSkullHit.play();
    }

    public static void playStarCollect() {
        sfxStarCollect.stop();
        sfxStarCollect.play();
    }

    public static void playRainbowCollect() {
        sfxRainbowCollect.stop();
        sfxRainbowCollect.play();
    }
}
