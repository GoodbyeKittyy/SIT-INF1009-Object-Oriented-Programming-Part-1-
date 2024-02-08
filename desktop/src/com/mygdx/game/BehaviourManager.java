package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

public class BehaviourManager {
    private List<Entities> behaviours;

    public BehaviourManager() {
        behaviours = new ArrayList<>();
    }

    public void addBehaviour(Entities behaviour) {
        behaviours.add(behaviour);
    }

    public void removeBehaviour(Entities behaviour) {
        behaviours.remove(behaviour);
    }

    public void update(float deltaTime) {
        for (Entities behaviour : new ArrayList<>(behaviours)) {
            behaviour.update(deltaTime);
        }
    }
}
