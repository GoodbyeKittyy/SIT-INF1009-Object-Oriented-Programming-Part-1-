package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import java.util.List;

// Single player controls
public class PlayerControlManager {
    private GameManager gameManager;
    private Entities playerEntity;
    private float playerSpeed = 5.0f; // Speed at which the player moves

    public PlayerControlManager(GameManager gameManager, Entities playerEntity) {
        this.gameManager = gameManager;
        this.playerEntity = playerEntity;
    }

    //Movement up, down, left right respectively
    public void controlPlayer(float deltaTime) {
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

    // Placeholder for direct relationships with others
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
