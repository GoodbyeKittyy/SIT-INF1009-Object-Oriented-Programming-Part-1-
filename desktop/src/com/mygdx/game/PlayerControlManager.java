// PlayerControlManager.java
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class PlayerControlManager {
    private TexturedObject spaceshipObject;

    public PlayerControlManager(TexturedObject spaceshipObject) {
        this.spaceshipObject = spaceshipObject;
    }

    public void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            spaceshipObject.move(-5, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            spaceshipObject.move(5, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            spaceshipObject.move(0, 5);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            spaceshipObject.move(0, -5);
        }
    }
}