package com.mygdx.game;

import com.badlogic.gdx.Gdx;

import ECS.ECSManager;
import ECS.Entity;
import ECS.System;

/**
 * Created by LENOVO- on 19/03/2018.
 */

public class PhysicsSystem extends System {

    public PhysicsSystem(ECSManager ecsManager) {
        super(Constants.PHYSICS_CODE);
    }

    @Override
    public void update(float dt){
        for(int entity : entities){
            PhysicsComponent pc = (PhysicsComponent)ecsManager.getComponent(entity, Constants.PHYSICS_CODE);
            pc.velocity.x += dt * pc.acceleration.x;
            pc.velocity.y += dt * pc.acceleration.y;
            pc.position.x += dt * pc.velocity.x;
            pc.position.y += dt * pc.velocity.y;
        }
    }

}
