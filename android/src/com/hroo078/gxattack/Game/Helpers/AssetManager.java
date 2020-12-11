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

    public Music backgroundMusic;
    public Music explosionSound;
    public Sound shootSound;
    public Music rockSound;
    public Music gameOverSound;
    public Music playerHitSound;


    public final com.badlogic.gdx.assets.AssetManager manager = new com.badlogic.gdx.assets.AssetManager();

    private final String explosionSoundFile = "sounds/explosion.wav";
    private final String shootSoundFile = "sounds/shoot.wav";
    private final String rockSoundFile = "sounds/rock.mp3";
    private final String gameOverSoundFile = "sounds/gameOver.mp3";
    private final String playerHitSoundFile = "sounds/playerHit.wav";
    private final String bgMusic = "music/menu_music.mp3";



    public void loadSounds() {
        manager.load(bgMusic, Music.class);
        manager.load(shootSoundFile, Music.class);
        //manager.load(shootSoundFile, Music.class);
    }

    public void initSounds() {
        backgroundMusic = manager.get("music/menu_music.mp3");
        rockSound = manager.get("sounds/rock.mp3");
    }

    public void dispose() {
        backgroundMusic.dispose();
        explosionSound.dispose();
        shootSound.dispose();
        rockSound.dispose();
        gameOverSound.dispose();
        playerHitSound.dispose();
    }
}
