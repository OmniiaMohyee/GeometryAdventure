package com.mygdx.game;

import com.badlogic.gdx.Gdx;

import ECS.ECSManager;
import ECS.System;

/**
 * Created by LENOVO- on 19/03/2018.
 */

public class PlayerSystem extends System {

    public PlayerSystem(ECSManager ecsManager) {
        super(Constants.PLAYER_CODE, Constants.PHYSICS_CODE);
        Gdx.app.log("PlayerSystem Mask", Long.toBinaryString(componentsMask));
    }

    @Override
    public boolean addEntity(int entity) {
        boolean returnValue = super.addEntity(entity);
        if(!returnValue) return returnValue;
        PhysicsComponent pc = (PhysicsComponent)ecsManager.getComponent(entity, Constants.PHYSICS_CODE);
        pc.position.x = 200;
        pc.position.y = 100;
        pc.acceleration.x = 0;
        pc.acceleration.y = -9.8f;
        pc.velocity.x = 0;
        pc.velocity.y = 0;
        return returnValue;
    }

    @Override
    public void update(float dt) {

    }
}
