package com.mygdx.game;

import com.badlogic.gdx.math.Circle;

import ECS.Component;

/**
 * Created by LENOVO- on 19/03/2018.
 */

public class GraphicsComponent extends Component {
    public static final int CIRCLE = 0;
    public static final int RECTANGLE = 1;

    public int shape;

    public GraphicsComponent() {
        super(Constants.GRAPHICS_CODE);
    }
}
