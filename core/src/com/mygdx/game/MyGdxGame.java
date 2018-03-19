package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import ECS.ECSEvent;
import ECS.ECSManager;


public class MyGdxGame extends ApplicationAdapter {

	private ECSManager ecsManager;

	@Override
	public void create () {
		ecsManager = new ECSManager();
		GraphicsSystem gs = new GraphicsSystem(ecsManager);
		ecsManager.addSystem(gs);
		int playerEntity = ecsManager.createEntity();
		ecsManager.addComponent(new PhysicsComponent(), playerEntity);
		ecsManager.addComponent(new PlayerComponent(), playerEntity);
		GraphicsComponent gc = new GraphicsComponent();
		gc.shape = GraphicsComponent.CIRCLE;
		ecsManager.addComponent(gc, playerEntity);
		PlayerSystem ps = new PlayerSystem(ecsManager);
		PhysicsSystem phys = new PhysicsSystem(ecsManager);
		ecsManager.addSystem(phys);
		ecsManager.addSystem(ps);


	}

	@Override
	public void resize(int width, int height){
		ECSEvent event = new ECSEvent(Constants.RESIZE_EVENT, new Vector2(width, height));
		ecsManager.fireEvent(event);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		float dt = Gdx.graphics.getDeltaTime();
		ecsManager.update(dt);
	}
	
	@Override
	public void dispose () {
	}
}
