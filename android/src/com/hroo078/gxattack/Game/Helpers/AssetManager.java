package com.hroo078.gxattack.Game.Helpers;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;


public class AssetManager {

    public Music menuMusic;
    public Music gameMusic;
    public Music explosionSound;
    public Music laserSound;
    public Music gameOverSound;
    public Music playerHitSound;


    public final com.badlogic.gdx.assets.AssetManager manager = new com.badlogic.gdx.assets.AssetManager();

    private final String explosionSoundFile = "sounds/explode1.ogg";
    private final String laserSoundFile = "sounds/sfx_laser1.ogg";
    private final String gameMusicFile = "music/soundtrack.mp3";
    private final String menuMusicFile = "music/menu_music.mp3";
    private final String gameOverMusicFile = "sounds/gameOver.mp3";



    public void loadSounds() {
        manager.load(menuMusicFile, Music.class);
        manager.load(gameMusicFile, Music.class);
        manager.load(laserSoundFile, Music.class);
        manager.load(explosionSoundFile, Music.class);
        manager.load(gameOverMusicFile, Music.class);
    }

    public void initSounds() {
        menuMusic = manager.get("music/menu_music.mp3");
        gameMusic = manager.get("music/soundtrack.mp3");
        laserSound = manager.get("sounds/sfx_laser1.ogg");
        explosionSound = manager.get("sounds/explode1.ogg");
        gameOverSound = manager.get("sounds/gameOver.mp3");
    }

    public void dispose() {
        menuMusic.dispose();
        explosionSound.dispose();
        gameMusic.dispose();
        laserSound.dispose();
        gameOverSound.dispose();
        playerHitSound.dispose();
    }
}
