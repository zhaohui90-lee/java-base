package org.melody.gson;

import com.google.gson.Gson;
import org.melody.gson.pojo.Person;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author lizhaohui
 * @since 2023/12/27
 */
public class GsonTest {

    public static void main(String[] args) {
        // Serialization
        Gson gson = new Gson();
        gson.toJson(1);            // ==> 1
        gson.toJson("abcd");       // ==> "abcd"
        gson.toJson(new Long(10)); // ==> 10
        int[] values = { 1 };
        gson.toJson(values);       // ==> [1]

        // Deserialization
        int i = gson.fromJson("1", int.class);
        Integer intObj = gson.fromJson("1", Integer.class);
        Long longObj = gson.fromJson("1", Long.class);
        Boolean boolObj = gson.fromJson("false", Boolean.class);
        String str = gson.fromJson("\"abc\"", String.class);
        String[] strArray = gson.fromJson("[\"abc\"]", String[].class);

        Person p = new Person("lizhaohui", 18);

        // Serialization
        String json = gson.toJson(p);
        System.out.println(json);

        // deserialization
        Person p2 = gson.fromJson(json, Person.class);
        System.out.println(p2.createId());

        var list = new ArrayList<String>();
        list.add("lizhaohui");
        System.out.println(list);

    }
}
