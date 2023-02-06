package org.melody.pojo;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lizhaohui
 * @since 2023/2/6
 */
class PersonTest {

    private Map<Person, Integer> getHashData() {

        HashMap<Person, Integer> map = new HashMap<>();

        Person p = new Person();
        p.setName("zhangsan");
        p.setAge(10);
        p.setAddress("hangzhou");

        System.out.println(p.hashCode());

        map.put(p, 100);
        return map;
    }

    @Test
    public void hashPersonTest() {
        Map<Person, Integer> data = getHashData();

        Person person = new Person();
        person.setAddress("hangzhou");
        person.setAge(10);
        person.setName("zhangsan");

        Integer value = data.get(person);

        System.out.println(value);
    }
}