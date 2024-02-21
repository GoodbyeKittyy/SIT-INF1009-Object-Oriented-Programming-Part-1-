package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

public class AIControlManager implements ControlledEntity {
    private float speed;
    private float x;
    private float y;
    private float radius;
    private float screenWidth;
    private float screenHeight;
    private Random random;

    public AIControlManager(float screenWidth, float screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.random = new Random();
        this.speed = 40; // Initial speed
        this.x = random.nextFloat() * screenWidth; // Random initial x position
        this.y = screenHeight; // Start at the top of the screen
        this.radius = 30; // Radius of the ball
    }

    public void update(float delta) {
        // Move the ball downwards based on speed and delta time
        y -= speed * delta;

        // If the ball exits the screen, reset its position to the top with a random x position
        if (y < -radius) {
            y = screenHeight;
            x = random.nextFloat() * screenWidth;
        }
    }

    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle(x, y, radius);
    }

    public void resetPosition() {
        this.x = random.nextFloat() * screenWidth;
        this.y = screenHeight;
    }

    // Implementation of the onCollisionDetected method
    @Override
    public void onCollisionDetected() {
        // Define the behavior for collision detection here
        // For example, you can reset the position of the AI entity
        resetPosition();
    }

    // Getter methods for position and radius, if not already present
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getRadius() {
        return radius;
    }

}
