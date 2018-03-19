package ECS;

/**
 * Created by LENOVO- on 19/03/2018.
 */

public abstract class Component {
    private final int componentCode ;
    private int componentId;

    public Component(int componentCode){
        this.componentCode = componentCode;
    }

    public int getComponentCode()
    {
        return componentCode;
    }
    public void setId(int id){
        componentId = id;
    }

    public int getId(){
        return componentId;
    }

}
