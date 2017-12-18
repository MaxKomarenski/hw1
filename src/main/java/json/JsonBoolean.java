package json;

import java.util.HashMap;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */
public class JsonBoolean extends Json {
    private final Boolean bool;
    private static HashMap<Boolean, String> boolHashMap;
    static {
        boolHashMap = new HashMap<Boolean, String>();
        boolHashMap.put(true, "true");
        boolHashMap.put(false, "false");
    }

    public JsonBoolean(Boolean bool) {
        this.bool = bool;

    }

    @Override
    public String toJson() {
        return boolHashMap.get(bool);
    }
}
