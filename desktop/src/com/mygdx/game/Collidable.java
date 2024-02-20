package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Collidable implements ControlledEntity {
    private ControlledEntity entity;

    public Collidable(ControlledEntity entity) {
        this.entity = entity;
    }

    @Override
    public void update(float delta) {
        entity.update(delta);
        // Add collision detection logic here if needed
        // For example, if collision detected, print message
        if (checkCollision()) {
            System.out.println("Collision Detected!");
        }
    }

    @Override
    public void render(ShapeRenderer shapeRenderer) {
        entity.render(shapeRenderer);
    }

    // Placeholder method for collision detection
    private boolean checkCollision() {
        // Implement collision detection logic here
        // For example, check if the ball and spaceship intersect
        return false; // Placeholder return value
    }
}