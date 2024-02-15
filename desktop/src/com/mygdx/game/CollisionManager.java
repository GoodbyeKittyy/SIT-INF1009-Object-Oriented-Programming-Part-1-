package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

public class CollisionManager {
    private List<Collidable> collidables = new ArrayList<>();

    public void addCollidable(Collidable collidable) {
        collidable.setCollisionManager(this);
        collidables.add(collidable);
    }

    public void removeCollidable(Collidable collidable) {
        collidables.remove(collidable);
    }

    public void checkCollisions() {
        for (Collidable collidable1 : collidables) {
            List<Entities> collidableEntities1 = collidable1.getCollidableEntities();
            for (Collidable collidable2 : collidables) {
                if (collidable1 != collidable2) {
                    List<Entities> collidableEntities2 = collidable2.getCollidableEntities();
                    for (Entities entity1 : collidableEntities1) {
                        for (Entities entity2 : collidableEntities2) {
                            if (entity1.collidesWith(entity2)) {
                                collidable1.handleCollision(entity1, entity2);
                                collidable2.handleCollision(entity2, entity1);
                            }
                        }
                    }
                }
            }
        }
    }
}
