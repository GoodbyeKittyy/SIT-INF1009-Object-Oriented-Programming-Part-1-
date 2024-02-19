package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import java.util.List;

// Single player controls
public class PlayerControlManager {
    private GameManager gameManager;
    private Entities playerEntity;
    private float playerSpeed = 5.0f; // Speed at which the player moves
    private boolean isPaused = false; // To track whether the game is paused
    public PlayerControlManager(GameManager gameManager, Entities playerEntity) {
        this.gameManager = gameManager;
        this.playerEntity = playerEntity;
    }

    // Movement up, down, left, right respectively, and control keys
    public void controlPlayer(float deltaTime) {
        // If the game is paused, don't process movement inputs
        if (!isPaused) {
            float moveAmount = playerSpeed * deltaTime;

            // Check for input and move the player entity accordingly
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                playerEntity.y += moveAmount;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                playerEntity.y -= moveAmount;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                playerEntity.x -= moveAmount;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                playerEntity.x += moveAmount;
            }

            // Update the player entity with the new position
            playerEntity.update(deltaTime);
        }

        // Check for pause key
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            isPaused = !isPaused; // Toggle pause state
            gameManager.setPaused(isPaused); // You need to implement this method in GameManager
        }

        // Check for volume up key
        if (Gdx.input.isKeyJustPressed(Input.Keys.PAGE_UP)) {
            gameManager.adjustVolume(true); // You need to implement this method in GameManager
        }

        // Check for volume down key
        if (Gdx.input.isKeyJustPressed(Input.Keys.PAGE_DOWN)) {
            gameManager.adjustVolume(false); // You need to implement this method in GameManager
        }

        // Check for menu key
        if (Gdx.input.isKeyJustPressed(Input.Keys.M)) {
            gameManager.showMenu(); // You need to implement this method in GameManager
        }
    }

    // Placeholder for direct relationships with other managers
    public void directRelationshipWithGameManager() {
        // Placeholder
    }

    public void directRelationshipWithAiControlManager() {
        // Placeholder
    }

    public void directRelationshipWithInputOutputManager() {
        // Placeholder
    }
}