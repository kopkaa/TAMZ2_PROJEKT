package com.hroo078.gxattack.Game.Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.hroo078.gxattack.Game.GallaxyAttackGame;


public class AssetManager {

    public Music menuMusic;
    public Music gameMusic;
    public Sound shootSound;
    public Music rockSound;
    public Music gameOverSound;
    public Music playerHitSound;


    public final com.badlogic.gdx.assets.AssetManager manager = new com.badlogic.gdx.assets.AssetManager();

    private final String explosionSoundFile = "sounds/explosion.wav";
    private final String rockSoundFile = "sounds/sfx_laser1.ogg";
    private final String gameMusicFile = "music/soundtrack.mp3";
    private final String menuMusicFile = "music/menu_music.mp3";



    public void loadSounds() {
        manager.load(menuMusicFile, Music.class);
        manager.load(gameMusicFile, Music.class);
        manager.load(rockSoundFile, Music.class);
        //manager.load(shootSoundFile, Music.class);
    }

    public void initSounds() {
        menuMusic = manager.get("music/menu_music.mp3");
        gameMusic = manager.get("music/soundtrack.mp3");
        rockSound = manager.get("sounds/sfx_laser1.ogg");
    }

    public void dispose() {
        menuMusic.dispose();
        gameMusic.dispose();
        shootSound.dispose();
        rockSound.dispose();
        gameOverSound.dispose();
        playerHitSound.dispose();
    }
}
