package com.hroo078.gxattack.Game.Helpers;

public class Sound {
    private AssetManager assetManager = Main.assetManager;

    public static boolean musicEnabled = true;
    public static boolean soundEnabled = true;
    public static float musicVolume = 0.5f;
    public static float soundVolume = 1.0f;

    public Sound() {

        assetManager.queueAddMusic();

        assetManager.manager.finishLoading();

        assetManager.backgroundMusic = assetManager.manager.get("music/Rolemusic_-_pl4y1ng.mp3");
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
        assetManager.shootSound.setVolume(volume);
        assetManager.rockSound.setVolume(volume);
    }

    public void playShootSound() {
        if (soundEnabled) {
            assetManager.shootSound.stop();
            assetManager.shootSound.play();
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
