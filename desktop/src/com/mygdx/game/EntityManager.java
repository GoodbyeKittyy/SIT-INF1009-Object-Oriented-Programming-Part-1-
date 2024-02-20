// EntityManager.java
package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {
    private Entities entities;

    public EntityManager() {
        // Instantiate the Entities with an empty list
        entities = new Entities(new ArrayList<>());
    }

    // Method to create entities
    public void createEntities() {
        // Add entities to the Entities object
        entities.createEntities();
    }

    // Getter for the Entities
    public Entities getEntities() {
        return entities;
    }

    // Method to dispose of resources
    public void dispose() {
        entities.dispose();
    }
}