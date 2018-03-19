package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ECS.ECSEventListener;
import ECS.ECSManager;
import ECS.System;

/**
 * Created by LENOVO- on 19/03/2018.
 */

public class GraphicsSystem extends System{

    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer shapeRenderer;

    public GraphicsSystem(ECSManager ecsManager) {
        super(Constants.PHYSICS_CODE, Constants.GRAPHICS_CODE);
        camera = new OrthographicCamera();
        viewport = new ScreenViewport(camera);
        shapeRenderer = new ShapeRenderer();
        ecsManager.subscribe(Constants.RESIZE_EVENT, new ECSEventListener() {
            @Override
            public boolean update(int eventCode, Object message) {
                Vector2 v = (Vector2) message;
                return resize((int)v.x, (int)v.y);
            }
        });
    }

    private boolean resize(int width, int height){
        viewport.update(width, height);
        viewport.apply();
        return true;
    }

    @Override
    public void update(float dt){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.setProjectionMatrix(viewport.getCamera().combined);

        for(int entity : entities){
            GraphicsComponent gc = (GraphicsComponent)ecsManager.getComponent(entity, Constants.GRAPHICS_CODE);
            PhysicsComponent pc = (PhysicsComponent)ecsManager.getComponent(entity, Constants.PHYSICS_CODE);

            Gdx.app.log("X:", String.valueOf(pc.position.y));

            if (gc.shape == GraphicsComponent.CIRCLE)
            {
                shapeRenderer.circle(pc.position.x, pc.position.y, pc.width);
            }
            else
            {
                shapeRenderer.rect(pc.position.x, pc.position.y, pc.width, pc.height);
            }
        }

        shapeRenderer.end();
    }

}
