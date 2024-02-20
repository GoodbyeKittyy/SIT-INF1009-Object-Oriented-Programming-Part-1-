// SceneManager.java
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SceneManager {
    private Scene currentScene;

    public void loadScene(Scene scene) {
        if (currentScene != null) {
            currentScene.dispose();
        }
        currentScene = scene;
    }

    public void render(SpriteBatch batch) {
        if (currentScene != null) {
            batch.draw(currentScene.getTexture(), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }
    }

    public void dispose() {
        if (currentScene != null) {
            currentScene.dispose();
        }
    }
}