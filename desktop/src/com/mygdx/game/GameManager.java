package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameManager {
    private EntityManager entityManager;

    public GameManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void update(float deltaTime) {
        entityManager.update(deltaTime);
    }

    public void draw(SpriteBatch spriteBatch) {
        entityManager.draw(spriteBatch);
    }

    // Method to add entities to the game
    public void addEntity(Entities entity) {
        entityManager.addEntity(entity);
    }

    // Method to remove entities from the game
    public void removeEntity(Entities entity) {
        entityManager.removeEntity(entity);
    }
}
