package com.mygdx.game;

public abstract class Scene {
    //Aggregation to SceneManager
    private SceneManager sceneManager;
    //Scene Count attribute (rethink in the future e.g. if doing chess theres only 1 scene this can throw away)
    private int SceneCount;

    // Constructor
    public Scene(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    // Abstract methods
    public abstract void createScene();
    public abstract void updateScene();
    public abstract void endScene();

    // Methods to obtain Scene through sceneManager
    public SceneManager getSceneManager() {
        return sceneManager;
    }

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }
}
