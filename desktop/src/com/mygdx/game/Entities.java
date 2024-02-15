package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Entities {
    protected int x, y;
    protected int width, height;

    public Entities(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void update(float deltaTime);

    public abstract void draw(SpriteBatch spriteBatch);

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public boolean collidesWith(Entities entity) {
        Rectangle thisBounds = this.getBounds();
        Rectangle otherBounds = entity.getBounds();
        return thisBounds.overlaps(otherBounds);
    }

    public void handleCollision(Entities entity, Entities collidedObj) {
        // Handle collision logic here
        // This is an abstract method, so subclasses must implement it
    }
}
