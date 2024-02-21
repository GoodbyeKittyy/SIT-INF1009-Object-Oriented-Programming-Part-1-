package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameManager extends ApplicationAdapter {
    SpriteBatch batch;
    ShapeRenderer shapeRenderer;
    SceneManager sceneManager;
    EntityManager entityManager;
    PlayerControlManager playerControlManager;
    AIControlManager aiControlManager;
    InputOutputManager inputOutputManager;
    ControlledEntity collidable;

    @Override
    public void create() {
        sceneManager = new SceneManager();
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        entityManager = new EntityManager();
        entityManager.createEntities();
        inputOutputManager = new InputOutputManager(entityManager.getEntities().getTexturedObjects().get(0));
        playerControlManager = new PlayerControlManager(entityManager.getEntities().getTexturedObjects().get(0), inputOutputManager);
        aiControlManager = new AIControlManager(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Scene scene = new Scene("Scenes/astronaut.png") {
            @Override
            public void dispose() {
                texture.dispose();
            }
        };
        sceneManager.loadScene(scene);
        collidable = new Collidable(); // Instantiate Collidable object
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        playerControlManager.handleInput();
        aiControlManager.update(Gdx.graphics.getDeltaTime());

        if (checkCollisionWithAI()) {
            if (inputOutputManager != null) {
                inputOutputManager.playCollisionSound();
            }
            aiControlManager.resetPosition();
            collidable.onCollisionDetected(); // Call onCollisionDetected method
        }

        batch.begin();
        sceneManager.render(batch);
        entityManager.getEntities().render(batch);
        batch.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        aiControlManager.render(shapeRenderer);
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        sceneManager.dispose();
        batch.dispose();
        entityManager.dispose();
        shapeRenderer.dispose();
    }

    private boolean checkCollisionWithAI() {
        TexturedObject player = entityManager.getEntities().getPlayer();
        float playerX = player.getX();
        float playerY = player.getY();
        float playerWidth = player.getWidth();
        float playerHeight = player.getHeight();

        float aiX = aiControlManager.getX();
        float aiY = aiControlManager.getY();
        float aiRadius = aiControlManager.getRadius();

        float closestX = Math.max(playerX, Math.min(aiX, playerX + playerWidth));
        float closestY = Math.max(playerY, Math.min(aiY, playerY + playerHeight));

        float distanceX = aiX - closestX;
        float distanceY = aiY - closestY;

        boolean collision = Math.sqrt(distanceX * distanceX + distanceY * distanceY) < aiRadius;

        return collision;
    }
}
