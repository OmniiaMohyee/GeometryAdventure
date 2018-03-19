package ECS;

/**
 * Created by LENOVO- on 19/03/2018.
 */

public interface ECSEventListener {
    public boolean update(int eventCode, Object message);
}
