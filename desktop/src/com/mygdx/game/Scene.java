// Scene.java
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public abstract class Scene {
    protected Texture texture;

    public Scene(String filePath) {
        texture = new Texture(filePath);
    }

    public Texture getTexture() {
        return texture;
    }

    public abstract void dispose();
}
