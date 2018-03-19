package ECS;

/**
 * Created by LENOVO- on 19/03/2018.
 */

public class ECSEvent {
    public int eventCode;
    public Object message;

    public ECSEvent(int eventCode, Object message){
        this.eventCode = eventCode;
        this.message = message;
    }
}
