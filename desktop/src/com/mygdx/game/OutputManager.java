package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class OutputManager {

    private Music backgroundMusic;
    private Sound effectSound;
    private SpriteBatch spriteBatch;

    public OutputManager() {
        spriteBatch = new SpriteBatch();

        //Music and Sound
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("background_music.mp3"));
        effectSound = Gdx.audio.newSound(Gdx.files.internal("effect_sound.wav"));
    }

    public void playBackgroundMusic(boolean loop) {
        if (!backgroundMusic.isPlaying()) {
            backgroundMusic.setLooping(loop);
            backgroundMusic.play();
        }
    }

    public void stopBackgroundMusic() {
        if (backgroundMusic.isPlaying()) {
            backgroundMusic.stop();
        }
    }

    public void playEffectSound() {
        effectSound.play();
    }


    public void dispose() {
        // Dispose of your audio and rendering components when you're done with them
        if (backgroundMusic != null) backgroundMusic.dispose();
        if (effectSound != null) effectSound.dispose();
        if (spriteBatch != null) spriteBatch.dispose();
    }
}
