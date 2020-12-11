package com.hroo078.gxattack.Game.Helpers;

import com.hroo078.gxattack.Game.GallaxyAttackGame;

public class Sound {
    private AssetManager assetManager = GallaxyAttackGame.assetManager;

    public static boolean musicEnabled = true;
    public static boolean soundEnabled = true;
    public static float musicVolume = 0.5f;
    public static float soundVolume = 1.0f;

    public Sound() {

        assetManager.loadSounds();
        assetManager.manager.finishLoading();
        assetManager.initSounds();
        assetManager.backgroundMusic.play();
        assetManager.backgroundMusic.setLooping(true);
        assetManager.backgroundMusic.setVolume(musicVolume);
    }


    public void changeMusicState() {
        if (musicEnabled) {
            if (!assetManager.backgroundMusic.isPlaying()) {
                assetManager.backgroundMusic.play();
                assetManager.backgroundMusic.setLooping(true);
                assetManager.backgroundMusic.setVolume(musicVolume);

            }
        } else {
            if (assetManager.backgroundMusic.isPlaying()) {
                assetManager.backgroundMusic.stop();
                assetManager.backgroundMusic.setLooping(false);
            }
        }
    }

    public void setMusicEnabled(boolean enabled) {
        musicEnabled = enabled;
        changeMusicState();
    }

    public void changeMusicVolume(float volume) {
        musicVolume = volume;
        assetManager.backgroundMusic.setVolume(musicVolume);
    }

    public void setSoundEnabled(boolean enabled) {
        soundEnabled = enabled;
    }

    public void changeSoundVolume(float volume) {
        soundVolume = volume;
        assetManager.explosionSound.setVolume(volume);
        assetManager.shootSound.setVolume(1, volume);
        assetManager.rockSound.setVolume(volume);
    }

    public void playShootSound() {

        if (soundEnabled) {
            assetManager.shootSound.play();
            assetManager.shootSound.stop();
        }

    }

    public void playExplosionSound() {
        if (soundEnabled) {
            assetManager.explosionSound.stop();
            assetManager.explosionSound.play();
        }
    }

    public void playRockSound() {

        if (soundEnabled) {
            assetManager.rockSound.stop();
            assetManager.rockSound.play();
        }
    }

    public void playGameOverSound() {
        assetManager.backgroundMusic.stop();
        if (soundEnabled) {
            assetManager.gameOverSound.stop();
            assetManager.gameOverSound.play();
        }

    }

    public void playPlayerHitSound() {
        if (soundEnabled) {
            assetManager.playerHitSound.stop();
            assetManager.playerHitSound.play();
        }

    }
}
