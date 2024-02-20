// InputOutputManager.java
package com.mygdx.game;

public class InputOutputManager {
    private TexturedObject spaceship;
    private float prevX;
    private float prevY;

    public InputOutputManager(TexturedObject spaceship) {
        this.spaceship = spaceship;
        this.prevX = spaceship.getX();
        this.prevY = spaceship.getY();
    }

    // Method to handle input and update spaceship position
    public void handleInputAndUpdatePosition(float deltaX, float deltaY) {
        // Update spaceship position based on input
        spaceship.move(deltaX, deltaY);

        // Check if the position has changed
        if (spaceship.getX() != prevX || spaceship.getY() != prevY) {
            // Print the updated position
            System.out.println("Spaceship position - X: " + spaceship.getX() + ", Y: " + spaceship.getY());

            // Update previous position
            prevX = spaceship.getX();
            prevY = spaceship.getY();
        }
    }
}
