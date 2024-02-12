package com.mygdx.game;

public interface Collidable {
    boolean collidesWith(Entities entity);
    void handleCollision(Entities entity, Entities collidedObj);
}
