package json;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private ArrayList<JsonPair> list = new ArrayList<>();

    public JsonObject(JsonPair... jsonPairs) {
        list.addAll(Arrays.asList(jsonPairs));
    }



    @Override
    public String toJson() {
        StringBuilder json = new StringBuilder("{");
        for (JsonPair aList : list) {
            json.append("'").append(aList.key).append("'").append(": ").append(aList.value.toJson()).append(",");
        }
        if(json.length() != 1) {
            json.deleteCharAt(json.length() - 1); //delete last element
        }
        json.append("}");
        return json.toString();
    }

    public void add(JsonPair jsonPair) {
        list.add(jsonPair);
    }

    public Json find(String name) {
        for (JsonPair aList : list) {
            if(aList.key.equals(name)){
                return aList.value;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject json = new JsonObject();
        ArrayList<String> nm = new ArrayList<>();
        nm.addAll(Arrays.asList(names));
        for (JsonPair aList: list) {
            if(nm.contains(aList.key)){
                json.add(aList);
            }
        }
        return json;
    }

}
