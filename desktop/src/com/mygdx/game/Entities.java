// Entities.java
package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Entities {
    protected SceneManager sceneManager;
    protected List<TexturedObject> texturedObjects;

    public Entities(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        this.texturedObjects = new ArrayList<>();
    }

    public void addTexturedObject(TexturedObject texturedObject) {
        texturedObjects.add(texturedObject);
    }

    public void render(SpriteBatch batch) {
        for (TexturedObject texturedObject : texturedObjects) {
            texturedObject.render(batch);
        }
    }

    public void dispose() {
        for (TexturedObject texturedObject : texturedObjects) {
            texturedObject.dispose();
        }
    }
}