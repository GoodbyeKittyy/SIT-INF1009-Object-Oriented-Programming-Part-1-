package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public interface ControlledEntity {
    void update(float delta);
    void render(ShapeRenderer shapeRenderer);
}