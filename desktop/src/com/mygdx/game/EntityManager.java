package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class EntityManager {
    private List<Entities> entities = new ArrayList<>();

    public void addEntity(Entities entity) {
        entities.add(entity); // Fixed adding entity to the list
    }

    public void removeEntity(Entities entity) {
        entities.remove(entity);
    }

    public void update(float deltaTime) {
        for (Entities entity : new ArrayList<>(entities)) {
            entity.update(deltaTime);
        }
    }

    public void draw(SpriteBatch spriteBatch) {
        for (Entities entity : entities) {
            entity.draw(spriteBatch);
        }
    }
}
