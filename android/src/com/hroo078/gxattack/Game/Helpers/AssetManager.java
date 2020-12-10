package com.hroo078.gxattack.Game.Helpers;

import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.hroo078.gxattack.Game.GallaxyAttackGame;


public class AssetManager {

    public static Texture backgroundTexture;
    public static Texture starsTexture;
    public static Texture playerTExture;
    public static Texture wallLargeTexture;
    public static Texture wallMediumTexture;
    public static Texture wallSmallTexture;
    public static Texture enemyTexture1a;
    public static Texture enemyTexture1b;
    public static Texture enemyTexture2a;
    public static Texture enemyTexture2b;
    public static Texture enemyBulletTexture;
    public static Texture playerBulletTexture;
    public static TextureAtlas explosionAtlas;
    public static Texture loadingBackgroundTexture;
    public static Texture logoTexture;
    public static BitmapFont font;


    public Music backgroundMusic;
    public Music explosionSound;
    public Music shootSound;
    public Music rockSound;
    public Music gameOverSound;
    public Music playerHitSound;


    public final com.badlogic.gdx.assets.AssetManager manager = new com.badlogic.gdx.assets.AssetManager();

    private final String explosionSoundFile = "sounds/explosion.wav";
    private final String shootSoundFile = "sounds/shoot.wav";
    private final String rockSoundFile = "sounds/rock.mp3";
    private final String gameOverSoundFile = "sounds/gameOver.mp3";
    private final String playerHitSoundFile = "sounds/playerHit.wav";

    // Textures
    private final String explosionImage = "images/explosion.atlas";
    private final String playerImage = "images/player.png";
    private final String backgroundImage = "images/background.png";
    private final String starsImage = "images/stars.png";
    private final String wallLargeImage = "images/large-A.png";
    private final String wallMediumImage = "images/medium-A.png";
    private final String wallSmallImage = "images/small-A.png";
    private final String enemyImage1a = "images/enemy1a.png";
    private final String enemyImage1b = "images/enemy1b.png";
    private final String enemyImage2a = "images/enemy2a.png";
    private final String enemyImage2b = "images/enemy2b.png";
    private final String enemyBulletImage = "images/enemyBullet.png";
    private final String playerBulletImage = "images/playerBullet.png";
    public final String loadingBackgroundImage = "images/loadingBackground.jpg";
    public final String logoImage = "images/logo.png";

    //font
    private final String fontFile = "fonts/OpenSans-Bold.fnt";


    public void queueAddFonts() {
        manager.load(fontFile, BitmapFont.class);
    }

    public void inicializeFonts() {
        font = GallaxyAttackGame.assetManager.manager.get(GallaxyAttackGame.assetManager.fontFile);
        font.setColor(255, 249, 129, 1);
    }


    public void queueAddImages() {
        manager.load(playerImage, Texture.class);
        manager.load(backgroundImage, Texture.class);
        manager.load(wallLargeImage, Texture.class);
        manager.load(wallMediumImage, Texture.class);
        manager.load(wallSmallImage, Texture.class);
        manager.load(starsImage, Texture.class);
        manager.load(enemyImage1a, Texture.class);
        manager.load(enemyImage1b, Texture.class);
        manager.load(enemyImage2a, Texture.class);
        manager.load(enemyImage2b, Texture.class);
        manager.load(enemyBulletImage, Texture.class);
        manager.load(playerBulletImage, Texture.class);
        manager.load(explosionImage, TextureAtlas.class);
    }

    public void inicializeImages() {
        playerTExture = GallaxyAttackGame.assetManager.manager.get(GallaxyAttackGame.assetManager.playerImage, Texture.class);
        wallLargeTexture = GallaxyAttackGame.assetManager.manager.get(GallaxyAttackGame.assetManager.wallLargeImage, Texture.class);
        wallMediumTexture = GallaxyAttackGame.assetManager.manager.get(GallaxyAttackGame.assetManager.wallMediumImage, Texture.class);
        wallSmallTexture = GallaxyAttackGame.assetManager.manager.get(GallaxyAttackGame.assetManager.wallSmallImage, Texture.class);
        enemyTexture1a = GallaxyAttackGame.assetManager.manager.get(GallaxyAttackGame.assetManager.enemyImage1a, Texture.class);
        enemyTexture1b = GallaxyAttackGame.assetManager.manager.get(GallaxyAttackGame.assetManager.enemyImage1b, Texture.class);
        enemyTexture2a = GallaxyAttackGame.assetManager.manager.get(GallaxyAttackGame.assetManager.enemyImage2a, Texture.class);
        enemyTexture2b = GallaxyAttackGame.assetManager.manager.get(GallaxyAttackGame.assetManager.enemyImage2b, Texture.class);
        enemyBulletTexture = GallaxyAttackGame.assetManager.manager.get(GallaxyAttackGame.assetManager.enemyBulletImage, Texture.class);
        playerBulletTexture = GallaxyAttackGame.assetManager.manager.get(GallaxyAttackGame.assetManager.playerBulletImage, Texture.class);
        explosionAtlas = GallaxyAttackGame.assetManager.manager.get(GallaxyAttackGame.assetManager.explosionImage);
        backgroundTexture = GallaxyAttackGame.assetManager.manager.get(GallaxyAttackGame.assetManager.backgroundImage, Texture.class);
        starsTexture = GallaxyAttackGame.assetManager.manager.get(GallaxyAttackGame.assetManager.starsImage, Texture.class);
    }

    // a small set of images used by the loading screen
    public void queueAddLoadingImages() {
        manager.load(loadingBackgroundImage, Texture.class);
        manager.load(logoImage, Texture.class);
    }

    public void queueAddSkin() {
        SkinLoader.SkinParameter params = new SkinLoader.SkinParameter("skin/glassy-ui.atlas");
        String skin = "skin/glassy-ui.json";
        manager.load(skin, Skin.class, params);
    }

    public void queueAddMusic() {
        String backgroundMusicFile = "music/menu_music.mp3";
        manager.load(backgroundMusicFile, Music.class);
    }

    public void queueAddSounds() {
        manager.load(explosionSoundFile, Music.class);
        manager.load(shootSoundFile, Music.class);
        manager.load(rockSoundFile, Music.class);
        manager.load(gameOverSoundFile, Music.class);
        manager.load(playerHitSoundFile, Music.class);
    }

    public void inicializeSounds() {
        shootSound = manager.get(shootSoundFile);
        explosionSound = manager.get(explosionSoundFile);
        rockSound = manager.get(rockSoundFile);
        gameOverSound = manager.get(gameOverSoundFile);
        playerHitSound = manager.get(playerHitSoundFile);
    }

    public void dispose() {
        backgroundTexture.dispose();
        starsTexture.dispose();
        playerTExture.dispose();
        wallLargeTexture.dispose();
        wallMediumTexture.dispose();
        wallSmallTexture.dispose();
        enemyTexture1a.dispose();
        enemyTexture1b.dispose();
        enemyTexture2a.dispose();
        enemyTexture2b.dispose();
        enemyBulletTexture.dispose();
        playerBulletTexture.dispose();
        explosionAtlas.dispose();
        loadingBackgroundTexture.dispose();
        logoTexture.dispose();
        font.dispose();
        backgroundMusic.dispose();
        explosionSound.dispose();
        shootSound.dispose();
        rockSound.dispose();
        gameOverSound.dispose();
        playerHitSound.dispose();
    }
}
