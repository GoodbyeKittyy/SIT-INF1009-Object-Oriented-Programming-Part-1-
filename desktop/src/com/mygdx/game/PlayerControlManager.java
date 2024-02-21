// PlayerControlManager.java
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class PlayerControlManager {
    private TexturedObject spaceship;
    private InputOutputManager inputOutputManager;

    public PlayerControlManager(TexturedObject spaceship, InputOutputManager inputOutputManager) {
        this.spaceship = spaceship;
        this.inputOutputManager = inputOutputManager;
    }

    // Method to handle user input and update spaceship position
    public void handleInput() {
        // Example key codes, you can change them according to your input controls
        float deltaX = 0, deltaY = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            deltaX -= 4;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            deltaX += 4;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            deltaY += 4;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            deltaY -= 4;
        }

        // Call InputOutputManager to handle input and update position
        inputOutputManager.handleInputAndUpdatePosition(deltaX, deltaY);
    }
}