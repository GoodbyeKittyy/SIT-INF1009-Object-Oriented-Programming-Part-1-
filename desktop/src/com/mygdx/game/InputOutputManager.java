// InputOutputManager.java
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class InputOutputManager {
    private TexturedObject spaceship;
    private float prevX;
    private float prevY;

    private Music bgm;
    private Sound soundeffect;
    public InputOutputManager(TexturedObject spaceship) {
        this.spaceship = spaceship;
        this.prevX = spaceship.getX();
        this.prevY = spaceship.getY();

        //music
        bgm = Gdx.audio.newMusic(Gdx.files.internal("Music/background_music.mp3"));
        bgm.setLooping(true);
        bgm.setVolume(5);
        bgm.play();

    }

    // Method to handle input and update spaceship position
    public void handleInputAndUpdatePosition(float deltaX, float deltaY) {
        // Update spaceship position based on input
        spaceship.move(deltaX, deltaY);

        // Check if the position has changed
        if (spaceship.getX() != prevX || spaceship.getY() != prevY) {
            // Print the updated position
            System.out.println("Spaceship position - X: " + spaceship.getX() + ", Y: " + spaceship.getY());

            // Update previous position
            prevX = spaceship.getX();
            prevY = spaceship.getY();
        }
    }
    //when touch then music
    public void playCollisionSound() {
        //sound effect
        soundeffect = Gdx.audio.newSound(Gdx.files.internal("Music/effect_sound.mp3"));
        soundeffect.play(1.0f); // Play at full volume
    }

}