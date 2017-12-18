package domain;

import json.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    private String inputName;
    private String inputSureName;
    private int inputYear;
    private ArrayList<Tuple<String, Integer>> list = new ArrayList<>();
    private HashMap<Integer, Boolean> passedMark = new HashMap<>();

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        this.inputName = name;
        this.inputSureName = surname;
        this.inputYear = year;
        list.addAll(Arrays.asList(exams));
        passedMark.put(5, true);
        passedMark.put(4, true);
        passedMark.put(3, true);
        passedMark.put(2, false);
        passedMark.put(1, false);

    }

    public JsonObject toJsonObject() {
        JsonObject json = new JsonObject();
        json.add(new JsonPair("name", new JsonString(getInputName())));
        json.add(new JsonPair("surname", new JsonString(getInputSureName())));
        json.add(new JsonPair("year", new JsonNumber(getInputYear())));
        JsonObject[] examsJason = new JsonObject[list.size()];
        for (int i =0; i<examsJason.length; i++) {
            examsJason[i] =  new JsonObject(new JsonPair("course", new JsonString(list.get(i).key)),
                                          new JsonPair("mark", new JsonNumber(list.get(i).value)),
                                          new JsonPair("passed", new JsonBoolean(passedMark.get(list.get(i).value))));
        }
        JsonArray js = new JsonArray(examsJason);

        json.add(new JsonPair("exams", js));
        return json;
    }

    public String getInputName() {
        return inputName;
    }

    public String getInputSureName() {
        return inputSureName;
    }

    public int getInputYear() {
        return inputYear;
    }
}
