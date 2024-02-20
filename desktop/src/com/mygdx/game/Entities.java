package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class Entities {
    private List<TexturedObject> texturedObjects;
    private TexturedObject player; // Add player object

    public Entities(List<TexturedObject> texturedObjects) {
        this.texturedObjects = texturedObjects;
    }

    // Method to create entities
    public void createEntities() {
        AssetManager assetManager = new AssetManager();
        assetManager.load("Entities/rick-and-morty-spaceship.png", Texture.class);
        assetManager.finishLoading(); // Blocks until all assets are loaded

        Texture spaceshipTexture = assetManager.get("Entities/rick-and-morty-spaceship.png", Texture.class);

        float spaceshipX = 180;
        float spaceshipY = 20;
        float spaceshipScaleX = 0.1f;
        float spaceshipScaleY = 0.1f;

        // Create TexturedObject instance for spaceship
        TexturedObject spaceship = new TexturedObject(spaceshipTexture, spaceshipX, spaceshipY, spaceshipScaleX, spaceshipScaleY);

        // Set the player object
        player = spaceship;

        // Add TexturedObject to Entities
        addTexturedObject(spaceship);
    }

    // Method to add a TexturedObject instance
    private void addTexturedObject(TexturedObject texturedObject) {
        texturedObjects.add(texturedObject);
    }

    public List<TexturedObject> getTexturedObjects() {
        return texturedObjects;
    }

    // Getter for the player object
    public TexturedObject getPlayer() {
        return player;
    }

    public void render(SpriteBatch batch) {
        for (TexturedObject texturedObject : texturedObjects) {
            texturedObject.render(batch);
        }
    }

    public void dispose() {
        for (TexturedObject texturedObject : texturedObjects) {
            texturedObject.dispose();
        }
    }

    // Collision detection method
    public boolean checkCollision(TexturedObject obj1, TexturedObject obj2) {
        return obj1.getX() < obj2.getX() + obj2.getWidth() &&
                obj1.getX() + obj1.getWidth() > obj2.getX() &&
                obj1.getY() < obj2.getY() + obj2.getHeight() &&
                obj1.getY() + obj1.getHeight() > obj2.getY();
    }

    // Example method to check and handle all collisions
    public void checkAndHandleCollisions() {
        for (TexturedObject obj : texturedObjects) {
            if (obj != player && checkCollision(player, obj)) {
                System.out.println("Collision Detected!");
                // Handle the collision here (e.g., remove the object, reduce health)
            }
        }
    }
}