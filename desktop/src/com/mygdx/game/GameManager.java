package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

public class GameManager extends ApplicationAdapter {
    private SpriteBatch batch;
    private SceneManager sceneManager;
    private Entities entities;
    private TexturedObject spaceshipObject;
    private PlayerControlManager playerControlManager;

    public GameManager(SceneManager sceneManager, Entities entities) {
        this.sceneManager = sceneManager;
        this.entities = entities;
    }

    @Override
    public void create() {
        batch = new SpriteBatch();

        AssetManager assetManager = new AssetManager();
        assetManager.load("rick-and-morty-spaceship.png", Texture.class);
        assetManager.finishLoading(); // Blocks until all assets are loaded

        Texture spaceshipTexture = assetManager.get("rick-and-morty-spaceship.png", Texture.class);

        float spaceshipX = 100;
        float spaceshipY = 100;
        float spaceshipScaleX = 1f;
        float spaceshipScaleY = 1f;
        spaceshipObject = new TexturedObject(spaceshipTexture, spaceshipX, spaceshipY, spaceshipScaleX, spaceshipScaleY);
        entities.addTexturedObject(spaceshipObject);

        playerControlManager = new PlayerControlManager(spaceshipObject);

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

        batch.begin();
        sceneManager.render(batch); // Render the scene first
        entities.render(batch); // Then render the entities (including the spaceship)
        batch.end();
    }


    @Override
    public void dispose() {
        sceneManager.dispose();
        batch.dispose();
        entities.dispose();
    }
}
