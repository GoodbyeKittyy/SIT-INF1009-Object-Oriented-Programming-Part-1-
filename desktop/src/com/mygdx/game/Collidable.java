package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Collidable implements ControlledEntity {
    private ControlledEntity entity;
    private boolean collisionDetected;

    public Collidable(ControlledEntity entity) {
        this.entity = entity;
        this.collisionDetected = false;
    }



    @Override
    public void render(ShapeRenderer shapeRenderer) {
        entity.render(shapeRenderer);
    }


}