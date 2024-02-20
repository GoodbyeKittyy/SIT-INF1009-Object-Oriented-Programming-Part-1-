package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.InputOutputManager;
import com.mygdx.game.AIControlManager;
// Import other necessary classes

public class Collidable implements ControlledEntity {
    private ControlledEntity entity;
    private InputOutputManager inputOutputManager;
    private AIControlManager aiControlManager;
    public Collidable(ControlledEntity entity, InputOutputManager inputOutputManager, AIControlManager aiControlManager) {
        this.entity = entity;
        this.inputOutputManager = inputOutputManager;
        this.aiControlManager = aiControlManager;
    }
    @Override
    public void update(float delta) {
        entity.update(delta);
        if (checkCollision()) {
            System.out.println("Collision Detected!");
            // Assuming inputOutputManager is accessible and has the playCollisionSound() method
            inputOutputManager.playCollisionSound();
        }
    }


    @Override
    public void render(ShapeRenderer shapeRenderer) {
        entity.render(shapeRenderer);
    }

    private boolean checkCollision() {
        // Assuming you can access the spaceship's and the red circle's positions and sizes
        float circleX = aiControlManager.getX();
        float circleY = aiControlManager.getY();
        float circleRadius = aiControlManager.getRadius();

        // Assuming spaceship's position (center) and a rough size (radius) for simplicity
        float spaceshipX = spaceship.getX() + spaceship.getWidth() / 2;
        float spaceshipY = spaceship.getY() + spaceship.getHeight() / 2;
        float spaceshipSize = 30; // This should be adjusted based on your actual spaceship size

        // Calculate the distance between the circle's center and the spaceship's center
        float distanceX = circleX - spaceshipX;
        float distanceY = circleY - spaceshipY;
        float distance = (float) Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        // Check if the distance is less than the sum of the radii (collision detected)
        if (distance < circleRadius + spaceshipSize) {
            return true;
        }
        return false;
    }

}
