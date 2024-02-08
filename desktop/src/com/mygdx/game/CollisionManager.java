package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

public class CollisionManager {
    private List<Collidable> collidables;

    public CollisionManager() {
        collidables = new ArrayList<>(); // Corrected initialization
    }

    public void addCollidable(Collidable collidable) {
        collidables.add(collidable);
    }

    public void removeCollidable(Collidable collidable) {
        collidables.remove(collidable);
    }

    public void checkCollisions() {
        for (int i = 0; i < collidables.size(); i++) {
            for (int j = i + 1; j < collidables.size(); j++) {
                if (collidables.get(i).collidesWith((Entities) collidables.get(j))) {
                    collidables.get(i).handleCollision(collidables.get(j));
                    collidables.get(j).handleCollision(collidables.get(i));
                }
            }
        }
    }
}
