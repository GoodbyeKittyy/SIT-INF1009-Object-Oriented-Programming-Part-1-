package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public interface ControlledEntity {

    void render(ShapeRenderer shapeRenderer);

    void onCollisionDetected();
}
