package com.hroo078.gxattack.Game.Helpers;

import com.hroo078.gxattack.Game.GallaxyAttackGame;

public class SoundManager {
    private AssetManager assetManager = GallaxyAttackGame.assetManager;

    public static boolean musicEnabled = true;
    public static boolean soundEnabled = true;
    public static float musicVolume = 0.5f;
    public static float soundVolume = 1.0f;

    public SoundManager() {
        assetManager.loadSounds();
        assetManager.manager.finishLoading();
        assetManager.initSounds();
    }


    public void changeMusicState() {
        if (musicEnabled) {
            if (!assetManager.menuMusic.isPlaying()) {
                assetManager.menuMusic.play();
                assetManager.menuMusic.setLooping(true);
                assetManager.menuMusic.setVolume(musicVolume);

            }
        } else {
            if (assetManager.menuMusic.isPlaying()) {
                assetManager.menuMusic.stop();
                assetManager.menuMusic.setLooping(false);
            }
        }
    }

    public void setMusicEnabled(boolean enabled) {
        musicEnabled = enabled;
        changeMusicState();
    }

    public void changeMusicVolume(float volume) {
        musicVolume = volume;
        assetManager.menuMusic.setVolume(musicVolume);
    }

    public void setSoundEnabled(boolean enabled) {
        soundEnabled = enabled;
    }

    public void changeSoundVolume(float volume) {
        soundVolume = volume;
        assetManager.shootSound.setVolume(1, volume);
        assetManager.laserSound.setVolume(volume);
    }

    public void playShootSound() {

        if (soundEnabled) {
            assetManager.shootSound.play();
            assetManager.shootSound.stop();
        }

    }



    public void playLaserSound() {

        if (soundEnabled) {
            assetManager.laserSound.stop();
            assetManager.laserSound.play();
        }
    }

    public void playGameOverSound() {
        assetManager.menuMusic.stop();
        if (soundEnabled) {
            assetManager.gameOverSound.stop();
            assetManager.gameOverSound.play();
        }

    }

    public void playMenuMusic() {
        assetManager.menuMusic.play();
        assetManager.menuMusic.setLooping(true);
        assetManager.menuMusic.setVolume(musicVolume);
    }

    public void playGameMusic() {
        assetManager.gameMusic.play();
        assetManager.gameMusic.setLooping(true);
        assetManager.gameMusic.setVolume(musicVolume);
    }

    public void stopMenuMusic() {
        assetManager.menuMusic.stop();
    }

    public void stopGameMusic() {
        assetManager.gameMusic.stop();
    }

    public void playPlayerHitSound() {
        if (soundEnabled) {
            assetManager.playerHitSound.stop();
            assetManager.playerHitSound.play();
        }

    }
}
