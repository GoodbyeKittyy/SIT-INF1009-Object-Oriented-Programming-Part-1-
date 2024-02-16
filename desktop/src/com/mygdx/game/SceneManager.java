package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

public class SceneManager {

    // List to store all our scene objects tbc
    private List<Scene> scenes;
    // Active current scene
    private Scene currentScene;

    // Constructor to initialize all scenes into list
    public SceneManager() {
        scenes = new ArrayList<>();
    }
    // Methods
    public void loadScene(Scene scene) {
        scenes.add(scene);
    }
    public void unloadScene(Scene scene) {
        scenes.remove(scene);
    }
    public void switchScene(Scene scene) {
        if (scenes.contains(scene)) {
            currentScene = scene;
            currentScene.updateScene();
        } else {
            System.out.println("Scene not found");
        }
    }
    // Tbc depending on game
    /* public void updateCurrentScene() {
        if (currentScene != null) {
            currentScene.updateScene();
        }
    }*/


    // Getters and Setters
    public Scene getCurrentScene() {

        return currentScene;
    }

    public void setCurrentScene(Scene currentScene) {

        this.currentScene = currentScene;
    }
}
