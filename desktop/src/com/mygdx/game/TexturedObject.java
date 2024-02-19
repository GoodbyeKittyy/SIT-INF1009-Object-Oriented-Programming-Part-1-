// TexturedObject.java
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TexturedObject {
    private Texture texture;
    private float x;
    private float y;
    private float width;
    private float height;

    public TexturedObject(Texture texture, float x, float y, float scaleX, float scaleY) {
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.width = texture.getWidth() * scaleX;
        this.height = texture.getHeight() * scaleY;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y, width, height);
    }

    public void dispose() {
        texture.dispose();
    }

    // Define a move method to update the position of the object
    public void move(float deltaX, float deltaY) {
        x += deltaX;
        y += deltaY;
    }
}
