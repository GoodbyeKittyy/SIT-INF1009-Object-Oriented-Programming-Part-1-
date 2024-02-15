package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class EntityManager {
    private List<Entities> entities = new ArrayList<>();
    private final CollisionManager collisionManager;

    public EntityManager(CollisionManager collisionManager) {
        this.collisionManager = collisionManager;
    }

    public void addEntity(Entities entity) {
        entities.add(entity);
    }

    public void removeEntity(Entities entity) {
        entities.remove(entity);
    }

    public void update(float deltaTime) {
        for (Entities entity : entities) {
            entity.update(deltaTime);
        }
        collisionManager.checkCollisions();
    }

    public void draw(SpriteBatch spriteBatch) {
        for (Entities entity : entities) {
            entity.draw(spriteBatch);
        }
    }
}
