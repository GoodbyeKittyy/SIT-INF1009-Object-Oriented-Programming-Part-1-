package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class EntityManager {
    private List<Entities> entities = new ArrayList<>();
    private CollisionManager collisionManager; // Added reference to CollisionManager

    public EntityManager(CollisionManager collisionManager) {
        this.collisionManager = collisionManager; // Initialize the CollisionManager
    }

    public void addEntity(Entities entity) {
        entities.add(entity);
        if (entity instanceof Collidable) {
            collisionManager.addCollidable((Collidable) entity);
        }
    }

    public void removeEntity(Entities entity) {
        entities.remove(entity);
        if (entity instanceof Collidable) {
            collisionManager.removeCollidable((Collidable) entity);
        }
    }

    public void update(float deltaTime) {
        for (Entities entity : new ArrayList<>(entities)) {
            entity.update(deltaTime);
        }
        collisionManager.checkCollisions(); // Check for collisions
    }

    public void draw(SpriteBatch spriteBatch) {
        for (Entities entity : entities) {
            entity.draw(spriteBatch);
        }
    }
}
