package com.mygdx.game;

import java.util.List;

public class AIControlManager {
    private GameManager gameManager;
    private PlayerControlManager playerControlManager;

    public AIControlManager(GameManager gameManager, PlayerControlManager playerControlManager) {
        this.gameManager = gameManager;
        this.playerControlManager = playerControlManager;
        this.directRelationshipWithGameManager();
        this.directRelationshipWithPlayerControlManager();
    }

    // Method to control AI entities in the game but dk what game so cannot control.
    //unless u wan the AI to follow player then can add inside if not idk what to put for a basic control AI
    public void controlAI(List<Entity> entities) {
        for (Entity entity : entities) {
        }
    }

    public void directRelationshipWithGameManager() {
        gameManager.addLifecycleListener(new ApplicationListener() {
            @Override
            // AI move when the game starts, DK what game so idk what to put inside
            public void onGameStart() {
            }

            @Override
            //AI stop all activities when the game ends
            public void onGameEnd() {
            }
        });
    }

    //Method to link with player control manager but idk what to put cuz idk wat game we going for
    public void directRelationshipWithPlayerControlManager() {

    }

    //for the ai to follow the lifecycle
    public interface ApplicationListener {
        void onGameStart();
        void onGameEnd();
    }
}
