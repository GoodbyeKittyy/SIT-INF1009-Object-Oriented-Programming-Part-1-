// GameManager.java
package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameManager extends ApplicationAdapter {
    SpriteBatch batch;
    ShapeRenderer shapeRenderer; // Add ShapeRenderer
    SceneManager sceneManager;
    EntityManager entityManager;
    PlayerControlManager playerControlManager;
    AIControlManager aiControlManager;

    @Override
    public void create() {
        // Instantiate the SceneManager
        sceneManager = new SceneManager();

        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer(); // Instantiate ShapeRenderer

        // Instantiate the EntityManager
        entityManager = new EntityManager();

        // Create entities using EntityManager
        entityManager.createEntities();

        // Instantiate InputOutputManager with the spaceship object retrieved from EntityManager
        InputOutputManager inputOutputManager = new InputOutputManager(entityManager.getEntities().getTexturedObjects().get(0));

        // Instantiate PlayerControlManager with the spaceship object and InputOutputManager
        playerControlManager = new PlayerControlManager(entityManager.getEntities().getTexturedObjects().get(0), inputOutputManager);

        // Instantiate AIControlManager
        aiControlManager = new AIControlManager(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); // Pass screen width and height

        Scene scene = new Scene("Scenes/astronaut.png") {
            @Override
            public void dispose() {
                texture.dispose();
            }
        };

        sceneManager.loadScene(scene);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        playerControlManager.handleInput();

        aiControlManager.update(Gdx.graphics.getDeltaTime()); // Update AI-controlled ball

        batch.begin();
        sceneManager.render(batch); // Render the scene first
        entityManager.getEntities().render(batch); // Render the entities (including the spaceship)
        batch.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled); // Begin shape rendering
        aiControlManager.render(shapeRenderer); // Render the AI-controlled ball using ShapeRenderer
        shapeRenderer.end(); // End shape rendering
    }

    @Override
    public void dispose() {
        sceneManager.dispose();
        batch.dispose();
        entityManager.dispose();
        shapeRenderer.dispose(); // Dispose ShapeRenderer
    }

}
