package com.mygdx.game;

import java.util.List;

public interface Collidable {
    void setCollisionManager(CollisionManager collisionManager);
    List<Entities> getCollidableEntities();
    boolean collidesWith(Entities entity);
    void handleCollision(Entities entity, Entities collidedObj);
}
