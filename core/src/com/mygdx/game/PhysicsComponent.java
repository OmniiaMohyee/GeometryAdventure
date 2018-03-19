package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

import ECS.Component;

/**
 * Created by LENOVO- on 19/03/2018.
 */

public class PhysicsComponent extends Component {

    public Vector2 position;
    public Vector2 velocity;
    public Vector2 acceleration;
    public float width;
    public float height;

    public PhysicsComponent() {
        super(Constants.PHYSICS_CODE);
        position = new Vector2();
        velocity = new Vector2();
        acceleration = new Vector2();
    }
}
